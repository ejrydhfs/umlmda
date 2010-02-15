/*
 *   $Header: /cvsroot/umlmda/org.umlmda.runtime.common/src/main/java/org/umlmda/runtime/visitor/VisitableIteration.java,v 1.1 2008/03/25 09:54:06 moroff Exp $
 *   $Source: /cvsroot/umlmda/org.umlmda.runtime.common/src/main/java/org/umlmda/runtime/visitor/VisitableIteration.java,v $
 * $Revision: 1.1 $
 *     $Name:  $
 *     $Date: 2008/03/25 09:54:06 $
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
 * Created by Dieter Moroff (20.02.2006)
 */
package org.umlmda.runtime.visitor;

/**
 * register visitables with visitors and define an iteration on the visitables
 * 
 * @author Dieter Moroff
 */
public interface VisitableIteration
{

   /**
    * Iterate over all elements of the iterator using a previously specified context.
    * 
    * @return the context, filled with the iteration results.
    */
   public VisitorContext iterate();

   /**
    * Register a visitor specific for a given package.
    * 
    * @param visitor
    */
   public void registerVisitor(Visitor visitor);

}
