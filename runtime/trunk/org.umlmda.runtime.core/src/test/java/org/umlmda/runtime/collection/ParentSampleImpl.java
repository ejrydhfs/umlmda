/*
 * Copyright (C) All rights reserved 2005 - 2009, 
 * UMLMDA, http://www.umlmda.org
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
 * Created on 06.07.2009 (Dieter Moroff)
 */
package org.umlmda.runtime.collection;

import java.util.Set;

public class ParentSampleImpl implements ParentSample {
   
   private OneToManyChildSet<ParentSample, ChildSample> childrenSet =
      new OneToManyChildSet<ParentSample, ChildSample>(this) {

         @Override
         ParentSample getParent(ChildSample child) {
            return child.getParentSample();
         }

         @Override
         void setParent(ChildSample child, ParentSample parent) {
            child.setParentSample(parent);
         }
      
   };

   public Set<ChildSample> getChildren() {
      return childrenSet;
   }

}
