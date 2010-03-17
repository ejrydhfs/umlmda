/*
 * UMLMDA, GeneratorBase-API
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 * 
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA  02111-1307, USA. The text of license can be also found
 * at http://www.gnu.org/copyleft/lgpl.html
 * 
 * Original author: Dieter Moroff (moroff@users.sourceforge.net)
 * Created on:      23.07.2003
 */
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
import org.umlmda.generator.model.util.string.DefaultStringShorteningStrategy;
import org.umlmda.generator.model.util.string.StringShorteningStrategy;

/**
 * Utility and convenience methods for various String manipulations in the scope <i>org.umlmda.generator.model</i>.
 */
public class StringUtil
{

   /**
    * Exception thrown, if pattern does not match
    * 
    * @author moroff
    */
   public static class PatternNotMatchException extends Exception
   {

      private static final long serialVersionUID = 1276431567426120992L;

   }

   public static final String EMPTY = "";

   /**
    * Capitalizes the first character of the given string.
    */
   public static String firstToUpperCase(String string) {
      StringBuffer tmp = new StringBuffer(string);

      if ( tmp.length() > 0 ) {
         tmp.setCharAt(0, Character.toUpperCase(string.charAt(0)));
      }

      return tmp.toString();
   }

   /**
    * Converts a camel type formatted string (e.g. "<code>StringUtil</code>") to an underscore separated upper case string (e.g. "
    * <code>STRING_UTIL</code>").
    */
   public static String toUpperCaseIdentifier(String identifier) {
      StringBuffer buffer = new StringBuffer();
      int identLen = identifier.length();

      for ( int i = 0; i < identLen; ++i ) {
         char c = identifier.charAt(i);

         if ( i != 0 && (Character.isUpperCase(c) || c == '_') ) {
            buffer.append('_');
         }
         buffer.append(Character.toUpperCase(c));
      }
      return buffer.toString();
   }

   /**
    * Checks if the given string is null or empty, returning <i>true</i> in that case.
    */
   public static boolean isEmpty(String checkString) {
      return checkString == null || checkString.length() == 0;
   }

   /**
    * Regular expression replacement.
    */
   public static String regexReplacement(String source, String matchPattern, String replacePattern)
         throws PatternNotMatchException {
      Pattern pattern = null;
      PatternCompiler compiler = new Perl5Compiler();
      PatternMatcher matcher = new Perl5Matcher();
      Substitution substitution = new Perl5Substitution(replacePattern);

      try {
         pattern = compiler.compile(matchPattern);
      }
      catch (MalformedPatternException e) {
         throw new RuntimeException(e.getMessage(), e);
      }

      if ( matcher.matches(source, pattern) ) {
         String replaced = Util.substitute(matcher, pattern, substitution, source, Util.SUBSTITUTE_ALL);
         return replaced;
      }
      else {
         throw new PatternNotMatchException();
      }
   }

   /**
    * Shortens the given string to the given <i>maxLength</i> using the given strategy class.
    */
   public static String shortenString(String strategyClass, String stringToShorten, Integer maxLength) {
      return StringUtil.shortenString(strategyClass, stringToShorten, maxLength, "");
   }

   /**
    * Shortens the given string to the given <i>maxLength</i> using the given strategy class.<br />
    * The given prefix string is taken into account when comparing the max length of the shortened name.
    */
   public static String shortenString(String strategyClass, String stringToShorten, Integer maxLength, String prefix) {
      if ( StringUtil.isEmpty(strategyClass) ) {
         throw new IllegalArgumentException("No strategy class provided for string shortening!");
      }
      try {
         Class<?> clazz = Class.forName(strategyClass);
         StringShorteningStrategy strategy = (StringShorteningStrategy) clazz.newInstance();
         return strategy.shortenString(stringToShorten, maxLength, prefix);
      }
      catch (Exception e) {
         throw new IllegalArgumentException("Invalid strategy class '" + strategyClass + "' provided for string shortening!", e);
      }
   }

   /**
    * Shortens the given string to the given <i>maxLength</i> using the default strategy class
    * {@link DefaultStringShorteningStrategy}.
    */
   public static String shortenString(String stringToShorten, Integer maxLength) {
      return StringUtil.shortenString(stringToShorten, maxLength, "");
   }

   /**
    * Shortens the given string to the given <i>maxLength</i> using the default strategy class
    * {@link DefaultStringShorteningStrategy}.<br />
    * The given prefix string is taken into account when comparing the max length of the shortened name.
    */
   public static String shortenString(String stringToShorten, Integer maxLength, String prefix) {
      return new DefaultStringShorteningStrategy().shortenString(stringToShorten, maxLength, prefix);
   }

}
