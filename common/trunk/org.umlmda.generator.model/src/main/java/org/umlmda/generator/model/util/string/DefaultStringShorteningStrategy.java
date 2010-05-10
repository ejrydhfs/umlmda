/*
 * Copyright: (C) 2010 COR AG Insurance Technologies
 */
package org.umlmda.generator.model.util.string;

import org.apache.commons.lang.StringUtils;

/**
 * The default string shortening strategy splits a camel type string by capital letters and shortens each string part one by one.
 * 
 * @author aschmacks
 */
public class DefaultStringShorteningStrategy implements StringShorteningStrategy
{

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.model.util.StringShorteningStrategy#shortenString(java.lang.String, java.lang.Integer)
    */
   public String shortenString(String camelTypeString, Integer maxLength) {
      return shortenString(camelTypeString, maxLength, "");
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.model.util.StringShorteningStrategy#shortenString(java.lang.String, java.lang.Integer,
    * java.lang.String)
    */
   public String shortenString(String camelTypeString, Integer maxLength, String prefix) {
      String result = camelTypeString;

      // Split name into parts to shorten them part by part
      String[] nameParts = StringUtils.splitByCharacterTypeCamelCase(camelTypeString);
      do {
         // Find longest part to shorten - or take the last one
         int longest = -1;
         for ( int i = 0; i < nameParts.length; i++ ) {
            if ( longest == -1 || nameParts[i].length() >= nameParts[longest].length() ) {
               longest = i;
            }
         }
         // Shorten longest name part by one character
         nameParts[longest] = StringUtils.chop(nameParts[longest]);

         result = StringUtils.join(nameParts);
      } while ( (prefix + result).length() > maxLength );

      return result;
   }

}
