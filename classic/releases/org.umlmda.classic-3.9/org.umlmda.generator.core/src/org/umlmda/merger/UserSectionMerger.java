// jUMLMDA, GeneratorBase-API
//  
//   $Header: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/merger/UserSectionMerger.java,v 1.6 2006/02/16 20:27:14 moroff Exp $
//   $Source: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/merger/UserSectionMerger.java,v $
// $Revision: 1.6 $
//    $State: Exp $
//     $Name: oAW $
//     $Date: 2006/02/16 20:27:14 $
//   $Locker:  $
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Library General Public
// License as published by the Free Software Foundation; either
// version 2 of the License, or (at your option) any later version.
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Library General Public License for more details.
//
// You should have received a copy of the GNU Library General Public
// License along with this library; if not, write to the
// Free Software Foundation, Inc., 59 Temple Place - Suite 330,
// Boston, MA  02111-1307, USA. The text of license can be also found
// at http://www.gnu.org/copyleft/lgpl.html
// 
// Original author: Dieter Moroff (moroff@users.sourceforge.net)
// Created on:      11.07.2003

package org.umlmda.merger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;


import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.MatchResult;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;
import org.umlmda.generator.GeneratorRuntimeConfig;

/**
 * @author Dieter Moroff
 */
public class UserSectionMerger  {
   private static final String USER_SECTION_NAME_PATTERN = "[\\s]+([A-Za-z][A-Za-z0-9_\\.]+)";
   private static final String newline = System.getProperty("line.separator");
   private static final String eyecatchPrefixPattern = "(.+?)";
   /**
    * Exception thrown by the usersectionmerger
    * @author Dieter Moroff
    */
   public class MergeException extends RuntimeException {
      public MergeException(String message) {
         super(message);
      }
   }
   
   /**
    * Hashtable, which holds all UserSection from the first parse
    */
   private Hashtable userSections = new Hashtable();

   private List obsoleteUserSections = new ArrayList();
   
   final private GeneratorRuntimeConfig config;
   
   private String xmlDeclaration = null;

   private boolean mergeable = true;
   
   public UserSectionMerger(GeneratorRuntimeConfig config) {
      this.config = config;
   }
    
   public boolean merge(File newFile) {
      File mergeDir = new File(newFile.getParentFile().getParentFile(), config.getMergedFolder());
      File mergeFile = new File(mergeDir, newFile.getName());
      File originalFile = new File(newFile.getParentFile().getParentFile(), newFile.getName());

      mergeable = true;
      parse(originalFile, null);
      
      if ( mergeDir.exists() == false )
         mergeDir.mkdirs();
      
      return merge(originalFile, newFile, mergeFile);
   }
   
   private void parse(File file, File output) {
      String userSectionName = null;
      StringBuffer userSection = null;
      Perl5Compiler compiler = new Perl5Compiler();
      Perl5Matcher matcher = new Perl5Matcher();
      BufferedReader reader = null;
      String line = null;
      String prefix = null;
      PrintWriter writer = null;
      boolean mergeFinished = false;
      
      userSections.clear();
      xmlDeclaration = null;
         
      try {
         Pattern startFilePattern = compiler.compile(eyecatchPrefixPattern+config.getGeneratedEyecatcher());
         
         reader = new BufferedReader(new FileReader(file));
         line = reader.readLine();
         if ( line == null )
            return;
                     
         if ( line.startsWith("<?xml")) {
            xmlDeclaration = line;
            line = reader.readLine();                        
         }
         
         // First line must contain startFilePattern
         if ( matcher.contains(line, startFilePattern) ) {
            MatchResult result = matcher.getMatch();   
           
            prefix = result.group(1);
         }
         else {
            mergeable = false;
         }

         Pattern beginPattern = compiler.compile("[\\s]*"+prefix+config.getBeginEyecatcher()+USER_SECTION_NAME_PATTERN);         
         Pattern endPattern = compiler.compile("[\\s]*"+prefix+config.getEndEyecatcher()+USER_SECTION_NAME_PATTERN);         
         Pattern obsoletePattern = compiler.compile("[\\s]*"+prefix+config.getObsoleteEyecatcher());         
         String userSectionContent = null;
         
         // Read the rest of the file
         do {
            
            line = reader.readLine();
            if ( line == null )
               break;                        

            // Read the obsolete UserSection 
            if ( mergeFinished ) {
               obsoleteUserSections.add(line);
               continue;   
            }
            
            // Outside usersection
            if ( userSectionName == null ) {
               if ( mergeFinished == false && matcher.contains(line, beginPattern) ) {
                  userSectionName = matcher.getMatch().group(1);
                  userSection = new StringBuffer();
               }

               // Handle usersection which doesn't appear in the generated file any more                
               if ( matcher.contains(line, obsoletePattern)) {
                  mergeFinished = true;
               }
                                 
            }

            // Inside usersection
            else if ( userSectionContent == null ) {
               if ( matcher.contains(line, endPattern) ) {
                  String endingUserSectionName = matcher.getMatch().group(1);
                  if (!userSectionName.equals(endingUserSectionName))
                     throw new MergeException("Expected user section end of "+userSectionName+" but found end of "+endingUserSectionName);
                  else {
                     userSections.put(userSectionName, userSection.toString());
                     userSection = null;
                     userSectionName = null;
                  }
               }
               else {
                  userSection.append(line);
                  userSection.append(newline);
               }
            }
            else 
               writer.println(line);
         } while ( true );
         
         if ( userSection != null ) {
            throw new MergeException("Unexpected end of file, user section "+userSectionName+" not closed");
         }
      }
      catch (FileNotFoundException e) {
         throw new RuntimeException(e);
      }
      catch (MalformedPatternException e) {
         throw new RuntimeException(e);
      } 
      catch (IOException e) {
         throw new RuntimeException(e);
      }
      finally {
         try {
            if ( reader != null )
               reader.close();
            if( writer != null )
               writer.close();   
         }
         catch (IOException e1) {
         }
      }
   }

   private boolean merge(File originalFile, File newFile, File mergedFile) {
      String userSectionName = null;
      StringBuffer userSection = null;
      Perl5Compiler compiler = new Perl5Compiler();
      Perl5Matcher matcher = new Perl5Matcher();
      BufferedReader reader = null;
      String line = null;
      String prefix = null;
      PrintWriter writer = null;
      boolean mergeFinished = false;
      
      try {
         Pattern startFilePattern = compiler.compile(eyecatchPrefixPattern+config.getGeneratedEyecatcher());

         reader = new BufferedReader(new FileReader(newFile));
         if ( mergedFile != null )
            writer = new PrintWriter(new FileWriter(mergedFile));

         line = reader.readLine();
         if ( line == null )
            return mergeable;
                     
         if ( line.startsWith("<?xml")) {
            xmlDeclaration = line;
            line = reader.readLine();                        
         }

         // First line must contain startFilePattern
         if ( matcher.contains(line, startFilePattern) ) {
            MatchResult result = matcher.getMatch();   
           
            prefix = result.group(1);
            if ( mergeable == false ) {
               throw new MergeException("First lines of "+originalFile.getAbsolutePath()+" doesn't contain \""+config.getGeneratedEyecatcher()+"\"");
            }
         }
         else {
            if ( mergeable ) {
               throw new MergeException("First lines of "+newFile.getAbsolutePath()+" doesn't contain \""+config.getGeneratedEyecatcher()+"\"");
            }
         }

         if ( xmlDeclaration != null )
            writer.println(xmlDeclaration);
         writer.println(line);
            
         Pattern beginPattern = compiler.compile("[\\s]*"+prefix+config.getBeginEyecatcher()+USER_SECTION_NAME_PATTERN);         
         Pattern endPattern = compiler.compile("[\\s]*"+prefix+config.getEndEyecatcher()+USER_SECTION_NAME_PATTERN);         
         Pattern obsoletePattern = compiler.compile("[\\s]*"+prefix+config.getObsoleteEyecatcher());         
         String userSectionContent = null;
         
         // Read the rest of the file
         do {
            
            line = reader.readLine();
            if ( line == null )
               break;                        

            // Outside usersection
            if ( userSectionName == null ) {
               if ( mergeFinished == false && matcher.contains(line, beginPattern) ) {
                  userSectionName = matcher.getMatch().group(1);
                  userSectionContent = (String) userSections.remove(userSectionName);
               }

               writer.println(line);

               // Handle usersection which doesn't appear in the generated file any more                
               if ( matcher.contains(line, obsoletePattern)) {
                  mergeFinished = true;
                  List keys = new ArrayList(userSections.keySet());
                  Collections.sort(keys);
                  
                  for (Iterator iter = keys.iterator(); iter.hasNext();) {
                     String key = (String) iter.next();
                     StringTokenizer userSectionParser = new StringTokenizer((String) userSections.remove(key), "\n");
                     
                     writer.println(prefix+config.getBeginEyecatcher()+" "+key);
                     while ( userSectionParser.hasMoreTokens() )
                        writer.println(prefix+userSectionParser.nextToken()); 
                     writer.println(prefix+config.getEndEyecatcher()+" "+key);
                  }
                  
                  for (Iterator iter = obsoleteUserSections.iterator(); iter.hasNext();) 
                     writer.println((String) iter.next());
               }
                                 
            }

            // Inside usersection, defined before
            else if ( userSectionContent != null ) {
               if ( matcher.contains(line, endPattern) ) {
                  String endingUserSectionName = matcher.getMatch().group(1);
                  if (!userSectionName.equals(endingUserSectionName))
                     throw new MergeException("Expected user section end of "+userSectionName+" but found end of "+endingUserSectionName);
                  else {
                     if ( userSectionContent != null ) {
                        userSections.remove(userSectionName);
                        writer.print(userSectionContent);
                        writer.print(line);
                        writer.print(newline);
                        userSectionContent = null;
                     }
                     userSectionName = null;
                  }
               }
            }
            // Inside usersection new to the file
            else { 
               if ( matcher.contains(line, endPattern) ) {
                  String endingUserSectionName = matcher.getMatch().group(1);
                  if (!userSectionName.equals(endingUserSectionName))
                     throw new MergeException("Expected user section end of "+userSectionName+" but found end of "+endingUserSectionName);
                  else {
                     userSectionName = null;
                  }
               }
               writer.println(line);
            }
         } while ( true );
         
         if ( userSection != null ) {
            throw new MergeException("Unexpected end of file, user section "+userSectionName+" not closed");
         }
      }
      catch (FileNotFoundException e) {
         throw new RuntimeException(e);
      }
      catch (MalformedPatternException e) {
         throw new RuntimeException(e);
      } 
      catch (IOException e) {
         throw new RuntimeException(e);
      }
      finally {
         try {
            if ( reader != null )
               reader.close();
            if( writer != null )
               writer.close();   
         }
         catch (IOException e1) {
         }
      }
      
      if ( mergeable == false ) {
         mergedFile.delete();
      }
      return mergeable;
   }

}
