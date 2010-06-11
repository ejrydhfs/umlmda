/*
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
 * Created on 08.08.2006 (Dieter Moroff)
 */
package org.umlmda.oaw.generator.model.j2ee;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.uml.generator.j2ee.J2EEModelClassAdapter;

/**
 * @author MOROFF
 */
public class J2EEBusinessServiceAdapter extends J2EEModelClassAdapter implements J2EEBusinessService
{

   /**
    * @param modelClassBase
    * @param model
    */
   public J2EEBusinessServiceAdapter(ModelClassBase modelClassBase, Model model) {
      super(modelClassBase, model);
   }

}
