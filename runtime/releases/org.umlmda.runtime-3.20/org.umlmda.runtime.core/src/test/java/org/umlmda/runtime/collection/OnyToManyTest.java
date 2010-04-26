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

import java.util.Iterator;

import org.umlmda.runtime.collection.test.ChildSample;
import org.umlmda.runtime.collection.test.ChildSampleImpl;
import org.umlmda.runtime.collection.test.ParentSample;
import org.umlmda.runtime.collection.test.ParentSampleImpl;

import junit.framework.TestCase;

public class OnyToManyTest extends TestCase {

   public void testSetFromParent() {
      ChildSample child = new ChildSampleImpl();
      ParentSample parent = new ParentSampleImpl();
      
      parent.getChildren().add(child);
      
      assertNotNull(child.getParentSample());
      assertTrue(child.getParentSample() == parent);
      
      parent.getChildren().remove(child);
      assertNull(child.getParentSample());
   }
   
   public void testSetFromChild() {
      ChildSample child = new ChildSampleImpl();
      ParentSample parent = new ParentSampleImpl();

      child.setParentSample(parent);
      
      assertTrue(parent.getChildren().contains(child));
      
      child.setParentSample(null);
      
      assertFalse(parent.getChildren().contains(child));
   }
   
   public void testRemoveWithIterator() {
      ChildSample child = new ChildSampleImpl();
      ParentSample parent = new ParentSampleImpl();

      parent.getChildren().add(child);

      assertNotNull(child.getParentSample());
      
      for (Iterator<ChildSample> iterator = parent.getChildren().iterator(); iterator.hasNext();) {
         ChildSample child1 = iterator.next();
         
         iterator.remove();
      }
      
      assertNull(child.getParentSample());
   }
}
