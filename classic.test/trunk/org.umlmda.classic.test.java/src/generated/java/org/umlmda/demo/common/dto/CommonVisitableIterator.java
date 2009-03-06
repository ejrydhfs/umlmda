//@@Generated file, please edit UserSections only
//@@UserSection-Begin RCSHeader
//   $Header$
//   $Source$
// $Revision$
//     $Name$
//     $Date$
//@@UserSection-End RCSHeader
package org.umlmda.demo.common.dto;

import org.umlmda.runtime.visitor.AbstractVisitableIterator;


/**
 * Visitable iterator for the business objects of org.umlmda.demo.common 
 */
public class CommonVisitableIterator extends AbstractVisitableIterator {

   /**
    * 
    */
   public CommonVisitableIterator(Object startPoint) {
      this(null, startPoint);
   }

   /**
    * 
    */
   public CommonVisitableIterator(AbstractVisitableIterator parentIterator, Object startPoint) {
      super(parentIterator, startPoint);
   }

   /* (non-Javadoc)
    * @see org.umlmda.runtime.visitor.AbstractVisitableIterator#registerChilds()
    */
   protected void registerChilds(Object startPoint) {
      if ( startPoint instanceof Note ) {
         Note spNote = (Note)startPoint;

      }
      if ( startPoint instanceof SecurityToken ) {
         SecurityToken spSecurityToken = (SecurityToken)startPoint;

      }
      if ( startPoint instanceof TimeDependent ) {
         TimeDependent spTimeDependent = (TimeDependent)startPoint;

      }
   }
}

//@@UserSection-Begin RCSLog
//@@UserSection-End RCSLog