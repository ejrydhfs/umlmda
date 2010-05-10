/*
 * Created on 16.02.2006
 */
package org.umlmda.generator.model.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.collections.ExtendedProperties;
import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.openarchitectureware.type.impl.java.JavaMetaModel;
import org.openarchitectureware.type.impl.java.beans.JavaBeansStrategy;
import org.openarchitectureware.xpand2.XpandExecutionContext;
import org.openarchitectureware.xpand2.XpandExecutionContextImpl;

/**
 * Runtime services for the UMLMDA generator.
 * 
 * @author moroff
 */
public class GeneratorRuntime
{

   public static final String        VELOCITY_PROPERTIES   = "/velocity.properties";

   private static GeneratorRuntime   instance;
   private static Logger             logger                = Logger.getLogger(GeneratorRuntime.class);
   private boolean                   isInitialized         = false;
   private Feedback                  feedback              = null;
   private Template                  template              = null;
   private boolean                   isVelocityInitialized = false;
   private XpandExecutionContextImpl xpandExecutionContext = null;
   private XpandOutputImpl           xpandOutputImpl       = null;

   private GeneratorRuntime() {
      super();
   }

   public void startup() {
      logger.info("Startup generator runtime");
      oAWXpandInit();
   }

   public void shutdown() {
      logger.info("Shutdown generator runtime");
      oAWXPandRelease();
   }

   /**
    * Gets the singleton
    * 
    * @return
    */
   public static GeneratorRuntime getInstance() {
      if ( instance == null ) {
         instance = new GeneratorRuntime();
      }

      return instance;
   }

   /**
    * @return Returns the feedback.
    */
   public Feedback getFeedback() {
      return feedback;
   }

   /**
    * @param feedback
    *           The feedback to set.
    */
   public void setFeedback(Feedback feedback) {
      this.feedback = feedback;
   }

   /**
    * Initialize velocity
    */
   private void velocityInit() {
      // Initialize velocity
      if ( isVelocityInitialized == false ) {
         ExtendedProperties properties = null;
         try {
            InputStream propertiesStream = getClass().getResourceAsStream(VELOCITY_PROPERTIES);
            if ( propertiesStream != null ) {
               properties = new ExtendedProperties();
               properties.load(propertiesStream);
               propertiesStream.close();
            }
         }
         catch (IOException e) {
            getFeedback().message(Feedback.WARNING, VELOCITY_PROPERTIES + " not found in classpath, using default");
         }

         if ( properties != null ) {
            Velocity.setExtendedProperties(properties);
         }

         try {
            Velocity.init();
         }
         catch (Exception e1) {
            getFeedback().message(Feedback.ERROR, "Velocity cound not be initialized: " + e1.getMessage());
            throw new RuntimeException(e1);
         }
      }
   }

   /**
    * @return
    */
   public VelocityEngine createVelocityEngine() {
      if ( isVelocityInitialized == false ) {
         velocityInit();
      }

      return new VelocityEngine();
   }

   public void oAWXpandInit() {

      try {
         xpandOutputImpl = new XpandOutputImpl();
         xpandExecutionContext = new XpandExecutionContextImpl(xpandOutputImpl, null);
         xpandExecutionContext.registerMetaModel(new JavaMetaModel("java", new JavaBeansStrategy()));
      }
      catch (RuntimeException e) {
         logger.warn("oAW Xpand not initialized", e);
      }
   }

   public void oAWXPandRelease() {

   }

   public XpandExecutionContextImpl getXpandExecutionContext() {
      return xpandExecutionContext;
   }

   public XpandOutputImpl getXpandOutputImpl() {
      return xpandOutputImpl;
   }
}
