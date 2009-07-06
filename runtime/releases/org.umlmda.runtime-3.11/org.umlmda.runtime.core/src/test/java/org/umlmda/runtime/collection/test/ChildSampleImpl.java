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
package org.umlmda.runtime.collection.test;

import java.util.Set;

import org.umlmda.runtime.collection.OneToManyParent;

public class ChildSampleImpl implements ChildSample {
   
   private OneToManyParent<ParentSample, ChildSample> parent = new OneToManyParent<ParentSample, ChildSample>(this) {

      @Override
      protected Set<ChildSample> getChildren(ParentSample parent) {
         return parent.getChildren();
      }};

   public ParentSample getParentSample() {
      return parent.getParent();
   }

   public void setParentSample(ParentSample parent) {
      this.parent.setParent(parent);
   }

}
