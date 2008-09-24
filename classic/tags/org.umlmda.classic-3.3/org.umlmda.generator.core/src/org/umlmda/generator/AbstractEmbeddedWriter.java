// jUMLMDA, GeneratorBase-API
//  
//   $Header: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/AbstractEmbeddedWriter.java,v 1.2 2006/08/09 11:58:56 moroff Exp $
//   $Source: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/AbstractEmbeddedWriter.java,v $
// $Revision: 1.2 $
//    $State: Exp $
//     $Name: oAW $
//     $Date: 2006/08/09 11:58:56 $
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
// Created on:      05.10.2004
package org.umlmda.generator;

import org.umlmda.generator.model.util.Feedback;



/**
 * @author moroff
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public abstract class AbstractEmbeddedWriter extends AbstractWriter {

   private AbstractParentWriter parentWriter;
   private int                  targetType;

   /**
    * Generierung durch Writer ablaufen lassen, zuvor müssen die get..() Funktionen aufgerufen worden sein.
    *
    * @throws RuntimeException DOCUMENT ME!
    */
   public void run() {
      writer__initialize();
      _setOutputBuffer(parentWriter._getOutputBuffer());

      // Writer laufen lassen
      try {
         writer__write();
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }

   /**
    * Method _setOutputBuffer.
    *
    * @param stringBuffer
    */
   abstract public void _setOutputBuffer(StringBuffer stringBuffer);

   /**
    * Liefert das Feedback-Interface zur Ausgabe von Status- nd Fehlermeldungen
    */   
   public Feedback getFeedback() {
      return parentWriter.getFeedback();
   }


   /**
    * Method beginUserSection.
    * @param id
    * @return String
    */
   public String beginUserSection(String id) {
      return beginUserSection(id, MANDATORY);
   }

   /**
    * Method endUserSection.
    * @param id
    * @return String
    */
   public String endUserSection(String id) {
      return endUserSection(id, MANDATORY);
   }
   
   /**
    * Returns the parentWriter.
    * @return AbstractParentWriter
    */
   public AbstractParentWriter getParentWriter()
   {
      return parentWriter;
   }

   /**
    * @param writer
    */
   public void setParentWriter(AbstractParentWriter writer) {
      parentWriter = writer;
   }

}


//-------------------------------------------------------------------------
//$Log: AbstractEmbeddedWriter.java,v $
//Revision 1.2  2006/08/09 11:58:56  moroff
//Refactoring
//
//Revision 1.1  2005/10/26 13:03:37  moroff
//* Refactoring package names to org.umlmda
//* Generator configuration based on profiles and sets
//
//Revision 1.1  2004/10/06 19:38:47  moroff
//* Supporting embedded writers
//
//-------------------------------------------------------------------------