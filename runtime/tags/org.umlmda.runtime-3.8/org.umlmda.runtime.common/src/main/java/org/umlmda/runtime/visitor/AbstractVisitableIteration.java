/*
 *   $Header: /cvsroot/umlmda/org.umlmda.runtime.common/src/main/java/org/umlmda/runtime/visitor/AbstractVisitableIteration.java,v 1.1 2008/03/25 09:54:06 moroff Exp $
 *   $Source: /cvsroot/umlmda/org.umlmda.runtime.common/src/main/java/org/umlmda/runtime/visitor/AbstractVisitableIteration.java,v $
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * TODO Insert type javadoc
 * @author Dieter Moroff (20.02.2006), last change $Date: 2008/03/25 09:54:06 $ $Name:  $
 * @version $Revision: 1.1 $
 */
public abstract class AbstractVisitableIteration implements VisitableIteration {
   private final VisitableIterator iterator;
   private final VisitorContext context;
   private final List visitors = new ArrayList();
   
   /**
    * 
    */
   public AbstractVisitableIteration(VisitableIterator iterator, VisitorContext context) {
      super();
      this.iterator = iterator;
      this.context = context;
   }

   /**
    * Iterate over all elements of the iterator, creates a visitor and
    * accepts the visitor at the visitable class.
    * @return the visitor context
    */
   public VisitorContext iterate() {
      while ( iterator.hasNext() ) {
         Visitable visitable = iterator.nextVisitable();
         
         for (Iterator iv = visitors.iterator(); iv.hasNext();) {
            Visitor visitor = (Visitor) iv.next();
            
            if ( visitor.isApplicable(visitable.getClass())) {
               visitor.setContext(context);
               visitable.accept(visitor);
            }
         }
      }
      
      return context;
   }

   /* (non-Javadoc)
    * @see org.umlmda.runtime.visitor.VisitableIteration#registerVisitorFor(java.lang.Package, org.umlmda.runtime.visitor.Visitor)
    */
   public void registerVisitor(Visitor visitor) {
      visitors.add(visitor);
   }
}
