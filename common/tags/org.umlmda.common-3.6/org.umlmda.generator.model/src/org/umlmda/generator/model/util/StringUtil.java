// jUMLMDA, GeneratorBase-API
//  
//   $Header$
//   $Source$
// $Revision$
//    $State$
//     $Name$
//     $Date$
//   $Locker$
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
// Created on:      23.07.2003
package org.umlmda.generator.model.util;

import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;
import org.apache.oro.text.regex.Perl5Substitution;
import org.apache.oro.text.regex.Substitution;
import org.apache.oro.text.regex.Util;

public class StringUtil {
   
   /**
    * Exception thrown, if pattern does not match
    * @author moroff
    */
   public static class PatternNotMatchException extends Exception {
      
   }
   
   public static final String EMPTY = "";

   public static String firstToUpperCase(String string) {
      StringBuffer tmp = new StringBuffer(string);

		if ( tmp.length() > 0 ) {
			tmp.setCharAt(0, Character.toUpperCase(string.charAt(0)));
		}

      return tmp.toString();
   }
   
   /**
    * Konvertiert einen String in Groﬂ-/Kleinschreibweise in einen String mit Groﬂbuchstaben
    * Worttrennungen werden durch Underlines ersetzt
    */
   public static String toUpperCaseIdentifier(String identifier) {
      StringBuffer buffer = new StringBuffer();
      int identLen = identifier.length();
      
      for ( int i=0; i<identLen; ++i ) {
         char c = identifier.charAt(i);
         
         if ( i != 0 && (Character.isUpperCase(c) || c == '_') )
            buffer.append('_');
         buffer.append(Character.toUpperCase(c));
      }
      return buffer.toString();
   }

   /**
    * @param initialValue
    * @return
    */
   public static boolean isEmpty(String initialValue) {
      return initialValue == null || initialValue.length() == 0;
   }

   /**
    * Regualar expression replacement
    * @param source
    * @param matchPattern
    * @param replacePattern
    * @return
    * @throws PatternNotMatchException
    */
   public static String regexReplacement(String source, String matchPattern, String replacePattern) throws PatternNotMatchException{
      Pattern pattern = null;
      PatternCompiler compiler = new Perl5Compiler();
      PatternMatcher matcher = new Perl5Matcher();
      Substitution substitution = new Perl5Substitution(replacePattern);
         
      try {
         pattern = compiler.compile(matchPattern);
      } catch (MalformedPatternException e) {
         throw new RuntimeException(e.getMessage(), e);
      }

      if ( matcher.matches(source, pattern )) {
         String replaced = Util.substitute(matcher, pattern, substitution, source, Util.SUBSTITUTE_ALL); 
         return replaced;
      }
      else {
         throw new PatternNotMatchException();
      }
      
   }
}
