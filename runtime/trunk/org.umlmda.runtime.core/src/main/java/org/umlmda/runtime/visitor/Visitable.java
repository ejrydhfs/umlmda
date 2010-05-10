/*
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
 * Created by Dieter Moroff (16.02.2006)
 */
package org.umlmda.runtime.visitor;

/**
 * Interface to be implemented from all objects that can be visited
 * 
 * @author MOROFF
 */
public interface Visitable
{

   /**
    * the visitable performs the visitor's action
    * 
    * @param visitor
    */
   void accept(Visitor visitor);

   /**
    * return a child VisitableIterator when descending into a parent-child relation.
    * 
    * @param parent
    *           a VisitableIterator that is iterating the parent object
    * @return a visitableIterator suitable to iterate this object
    */
   VisitableIterator getVisitableIterator(VisitableIterator parent);
}
