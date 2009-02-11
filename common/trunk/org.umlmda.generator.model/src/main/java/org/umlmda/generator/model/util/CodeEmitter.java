/*
 *  $Header$
 *  Copyright (C) 2003, 2004, 2005 Dieter Moroff
 *
 *  This file is part of UMLMDA (http://www.umlmda.org)
 *
 *  UMLMDA is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as
 *  published by the Free Software Foundation; either version 2.1 of
 *  the License, or (at your option) any later version.
 * 
 *  UMLMDA is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  General Public License for more details.
 * 
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with UMLMDA; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 *  02111-1307, USA.
 *
 *  Created on 15.12.2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.generator.model.util;

/**
 * Utility to produce sourcecode, which help with idents.
 * @author MOROFF
 */
public class CodeEmitter {
   private boolean firstLine = true;
   private final int identDepth;
   private int identBase;
   private final boolean useSpaces;
   private StringBuffer buffer = new StringBuffer();
   private final static String newLine = System.getProperty("line.separator", "\n");

   /**
    * 
    */
   public CodeEmitter() {
      this(0);
   }

   /**
    * 
    */
   public CodeEmitter(int identBase) {
      this(3, identBase, false);
   }

   /**
    * 
    */
   public CodeEmitter(int identDepth, int identBase) {
      this(identDepth, identBase, false);
   }

   /**
    * 
    */
   public CodeEmitter(int identDepth, int identBase, boolean useSpaces) {
      super();
      this.identDepth = identDepth;
      this.identBase = identBase;
      this.useSpaces = useSpaces;
   }

   public void addLine(String line) {
      addLine(0, line);
   }

   public void addLine(int identLevel, String line) {
      ident(identLevel);
      buffer.append(line);
      buffer.append(newLine);
   }
   
   public String toString() {
      return buffer.toString();
   }
   
   private void ident(int identLevel) {
      final int tabs = identLevel + (firstLine ? 0 : identBase);
      firstLine = false;
      
      if ( useSpaces ) {
         final int spaces = (tabs) * identDepth;
         for ( int i = 0; i < spaces; ++i ) {
            buffer.append(" ");
         }
      }
      else {
         for ( int i = 0; i < tabs; ++i ) {
            buffer.append("\t");
         }
      }
   }
   /**
    * @return Returns the identBase.
    */
   public int getIdentBase() {
      return identBase;
   }
   /**
    * @param identBase The identBase to set.
    */
   public void setIdentBase(int identBase) {
      this.identBase = identBase;
   }

   /**
    * 
    */
   public void reset() {
      if ( buffer.length() > 0 ) {
         buffer = new StringBuffer();
      }
   }
}
