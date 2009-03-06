//@@Generated file, please edit UserSections only
//@@UserSection-Begin RCSHeader
// $Header$
// $Source$
// $Revision$
// $State$
// $Name$
// $Date$
// $Locker$
//@@UserSection-End RCSHeader
   
package org.umlmda.demo.common.ejb.beanimpl;

import javax.ejb.SessionContext;
import java.util.logging.*;

import org.springframework.ejb.support.AbstractStatelessSessionBean;
import org.umlmda.demo.common.CommonService;
//@@UserSection-Begin CommonService.Imports
//@@UserSection-End CommonService.Imports

/**
 * Bean implementation for CommonService.
 * @see org.umlmda.demo.common.CommonService
 */
public abstract class CommonServiceBeanImpl extends AbstractStatelessSessionBean
{
   private SessionContext sessionContext = null;
   private CommonService delegate = null;
   private Logger logger = Logger.getLogger(getClass().getName());
   
   /**
    * Set the delegate 
    */
   protected void setDelegate(Object delegate) {
      if ( delegate instanceof CommonService ) {
         this.delegate = (CommonService)delegate;
      }
      else {
         throw new IllegalArgumentException("delegate not instanceof org.umlmda.demo.common.CommonService");
      } 
   }

   /**
    * 
    */
   public boolean isAvailable () {
      if ( logger.isLoggable(Level.FINER) ) { logger.entering(getClass().getName(),"isAvailable"); }

      try {
         return delegate.isAvailable();
      } catch ( RuntimeException e ) {
         logger.log(Level.SEVERE, e.getMessage(), e);
         
         throw e;
      } finally {
         if ( logger.isLoggable(Level.FINER) ) { logger.exiting(getClass().getName(),"isAvailable"); }
      }
   }


//@@UserSection-Begin CommonService.NotModeledElements
//@@UserSection-End CommonService.NotModeledElements
};
