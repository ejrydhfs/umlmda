/*
 * Created on Nov 26, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package org.umlmda.uml.generator.docbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.umlmda.model.uml.ModelElement;

/**
 * @author moroff
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Utils {
   public static String getDocParagraphs(ModelElement modelElement) {
      String docString = modelElement.getDocumentation();
      StringBuffer buffer = new StringBuffer(docString.length());
      Pattern listPattern = Pattern.compile("\\s*[\\*\\-]\\s+(.+)");
      Pattern paraPattern = Pattern.compile("<p>(.*)</p>");
      
      boolean list = false;
      
      if ( docString.length() > 0  ) {
         StringTokenizer parseDoc = new StringTokenizer(docString, "\n");
         
         while ( parseDoc.hasMoreElements() ) {
            String line = parseDoc.nextToken();
            Matcher paraMatcher = paraPattern.matcher(line);
            
            if ( paraMatcher.matches() ) {
               line = paraMatcher.group(1);
            }
            Matcher matcher = listPattern.matcher(line);

            if ( line.length() > 0 ) { 
               if ( matcher.matches() ) {
                  if ( !list ) {
                     buffer.append("<itemizedlist>");
                  }
                  buffer.append("<listitem><para>");
                  buffer.append(matcher.group(1));
                  buffer.append("</para></listitem>\n");
               }
               else {   
                  if ( list ) {
                     buffer.append("</itemizedlist>");
                  }
                  buffer.append("<para>");
                  buffer.append(line);
                  buffer.append("</para>\n");
               }
            }

            list = matcher.matches();
         }
         
         if ( list ) {
            buffer.append("</itemizedlist>");
         }
      }
      
      List keys = new ArrayList(modelElement.getTaggedValues().keySet());
      
      keys.remove("documentation");
      if ( keys.size() > 0 ) {
         java.util.Collections.sort(keys);
      
         buffer.append("<table id=\"");
         buffer.append(modelElement.getQualifiedName());
         buffer.append(".stereotypeAttributes\"><title>Stereotype-Attributes</title><tgroup cols=\"2\"><tbody>\n");
               
         for ( Iterator it = keys.iterator(); it.hasNext(); ) {
            String key = (String)it.next();
            String value = modelElement.getStereotypeProperty(key);

            buffer.append("<row id=\"");
            buffer.append(modelElement.getQualifiedName());
            buffer.append(".stereotypeAttribute.");
            buffer.append(key);
            buffer.append("\"><entry>");
            buffer.append(key);
            buffer.append("</entry><entry>");
            buffer.append(value);
            buffer.append("</entry></row>\n");
         }
         buffer.append("</tbody></tgroup></table>\n");
     }            
      return buffer.toString();
   }
}
