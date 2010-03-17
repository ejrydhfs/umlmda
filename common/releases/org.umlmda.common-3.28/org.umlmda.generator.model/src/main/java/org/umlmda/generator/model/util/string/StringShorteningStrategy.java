/*
 * Copyright: (C) 2010 COR AG Insurance Technologies
 * Name:      $Id: StringShorteningStrategy.java,v $Version 17.03.2010 15:34:50 {user} Exp $
 */
package org.umlmda.generator.model.util.string;

/**
 * Interface for different strategy implementations for shortening a string.
 * 
 * @author aschmacks
 */
public interface StringShorteningStrategy
{

   /**
    * Shortens the given string to the given <i>maxLength</i>.<br />
    * The specific strategy of how that's done depends on the implementing class.
    */
   String shortenString(String stringToShorten, Integer maxLength);

   /**
    * Shortens the given string to the given <i>maxLength</i>.<br />
    * The given prefix string is taken into account when comparing the max length of the shortened name.<br />
    * The specific strategy of how that's done depends on the implementing class.
    */
   String shortenString(String stringToShorten, Integer maxLength, String prefix);

}
