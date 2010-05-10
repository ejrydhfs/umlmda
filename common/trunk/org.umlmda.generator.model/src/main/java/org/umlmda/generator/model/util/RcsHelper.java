// UMLMDA, GeneratorBase-API
//  
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

/**
 * @author MOROFF
 */
public class RcsHelper
{
   private static final String KEYWORD_PREFIX  = "$";
   private static final String KEYWORD_POSTFIX = "$";
   private static final String NEWLINE         = "\n";
   private static final String HEADER          = "Header";
   private static final String SOURCE          = "Source";
   private static final String REVISION        = "Revision";
   private static final String STATE           = "State";
   private static final String NAME            = "Name";
   private static final String DATE            = "Date";
   private static final String LOCKER          = "Locker";
   private static final String LOG             = "Log";

   public static String writeHeader(String prefix) {
      StringBuffer buffer = new StringBuffer();
      writeKeyword(prefix, buffer, HEADER, NEWLINE);
      writeKeyword(prefix, buffer, SOURCE, NEWLINE);
      writeKeyword(prefix, buffer, REVISION, NEWLINE);
      writeKeyword(prefix, buffer, STATE, NEWLINE);
      writeKeyword(prefix, buffer, NAME, NEWLINE);
      writeKeyword(prefix, buffer, DATE, NEWLINE);
      writeKeyword(prefix, buffer, LOCKER, "");
      return buffer.toString();
   }

   private static void writeKeyword(String prefix, StringBuffer buffer, String keyword, String newline) {
      buffer.append(prefix);
      buffer.append(KEYWORD_PREFIX);
      buffer.append(keyword);
      buffer.append(KEYWORD_POSTFIX);
      buffer.append(newline);
   }

   public static String writeLog() {
      return KEYWORD_PREFIX + LOG + KEYWORD_POSTFIX;
   }

   public static String writeLog(String prefix) {
      return prefix + writeLog();
   }

}
