/*
 *  $Header$
 *  Copyright (C) 2003, 2004, 2005 Dieter Moroff
 *
 *  This file is part of UMLMDA (http://www.umlmda.org)
 *
 *  UMLMDA is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as
 *  published by the Free Software Foundation; either version 2.1 of
 *  the License, or (at your option) any later version.
 * 
 *  UMLMDA is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  General Public License for more details.
 * 
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with UMLMDA; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 *  02111-1307, USA.
 *
 *  Created on 18.10.2005 by Dieter Moroff (moroff@users.sourceforge.net)
 */
package org.umlmda.generator.model.uml;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.umlmda.generator.logging.CommonsLoggingWriter;
import org.umlmda.generator.logging.JavaLoggingWriter;
import org.umlmda.generator.logging.Log4jWriter;
import org.umlmda.generator.logging.LoggingWriter;
import org.umlmda.generator.logging.NoneLoggingWriter;
import org.umlmda.generator.model.util.CodeEmitter;
import org.umlmda.generator.model.util.RcsHelper;
import org.umlmda.generator.profile.Artefact;
import org.umlmda.generator.profile.Mapping;
import org.umlmda.generator.profile.Profile;
import org.umlmda.generator.profile.Property;
import org.umlmda.generator.profile.Stereotype;
import org.umlmda.generator.set.GenerationProfile;
import org.umlmda.generator.set.GenerationSet;

/**
 * Implementation of the GeneratorModel, can be used as delegate in PSM model adapters
 */
public abstract class GeneratorModelImpl implements GeneratorModel {
   private GenerationProfile profile;
   private GenerationSet generationSet;
   private GeneratorContext context = new GeneratorContextImpl();
   private Properties properties = null;
   private LoggingWriter loggingWriter = null;
   
   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorModel#createEmitter()
    */
   public CodeEmitter createEmitter() {
      boolean useSpaces = Boolean.valueOf(getProperties().getProperty("UseSpaces", "true")).booleanValue();
      int identDepth = Integer.parseInt(getProperties().getProperty("IdentDepth", "3"));
      
      return new CodeEmitter(identDepth, 0, useSpaces);
   }
   
   /**
    * 
    */
   public GeneratorModelImpl() {
      super();
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.GeneratorModel#getProfile()
    */
   public GenerationProfile getProfile() {
      return profile;
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.GeneratorModel#setProfile(org.umlmda.generator.set.GenerationProfile)
    */
   public void setProfile(GenerationProfile profile) {
      this.profile = profile;
      this.properties = null;
   }

   public GenerationSet getGenerationSet() {
      return generationSet;
   }
   
   public void setGenerationSet(GenerationSet generationSet) {
      this.generationSet = generationSet;
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.GeneratorModel#getContext()
    */
   public GeneratorContext getContext() {
      return context;
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.GeneratorModel#getRcsHelper()
    */
   public RcsHelper getRcsHelper() {
      // TODO Auto-generated method stub
      return null;
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.GeneratorModel#getArtefacts(java.lang.String)
    */
   public Set getArtefacts(String stereotypeName) {
      Stereotype stereotype = getStereotype(stereotypeName);
      
      if ( stereotype != null ) {
         Set artefacts = new HashSet();
         for (Iterator im = stereotype.getMappings().iterator(); im.hasNext();) {
            Mapping mapping = (Mapping) im.next();

            artefacts.add(mapping.getArtefact());
         }
         return artefacts;
      }
      else {
         return Collections.EMPTY_SET;
      }
   }

   public Stereotype getStereotype(String stereotypeName) {
      for (Iterator is = profile.getProfile().getStereotypes().iterator(); is.hasNext();) {
         Stereotype stereotype = (Stereotype) is.next();
         
         if ( stereotypeName.equals(stereotype.getName()) ) {
            return stereotype;
         }
      }
      
      return null;
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.GeneratorModel#getProperties()
    */
   public Properties getProperties() {
      if ( properties == null ) {
         properties = new Properties();
         
         if ( profile != null ) {
            for (Iterator ip = profile.getProperties().iterator(); ip.hasNext();) {
               Property property = (Property) ip.next();

               properties.put(property.getName(), property.getValue());
            }
            addDefaultProperties(profile.getProfile());
         }
      }
      return properties;
   }
   
   /**
    * @param profile
    */
   private void addDefaultProperties(Profile profile) {
      for (Iterator ip = profile.getDefaultProperties().iterator(); ip.hasNext();) {
         Property property = (Property) ip.next();

         if ( properties.containsKey(property.getName()) == false )
            properties.put(property.getName(), property.getValue());
      }
      for (Iterator ib = profile.getBasedOn().iterator(); ib.hasNext();) {
         Profile baseProfile = (Profile) ib.next();
         
         addDefaultProperties(baseProfile);
      }
   }

   public Artefact getArtefact() {
      return ( getContext() != null ) ? getContext().getCurrentArtefact() : null;
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.GeneratorModel#getArtefact(java.lang.String)
    */
   public Artefact getArtefact(String artefactName, GeneratorModelElement modelElement) {
      String qualifiedName = modelElement.getQualifiedName();
      Artefact artefact = null;
      
      if ( StringUtils.isNotEmpty(qualifiedName) && qualifiedName.startsWith(profile.getPackagePrefix()))
         artefact = getArtefact(artefactName, profile, modelElement);
      else {
         for (Iterator irs = generationSet.getReferencedSets().iterator(); artefact == null && irs.hasNext();) {
            GenerationSet referencedSet = (GenerationSet) irs.next();
            
            for (Iterator igp = referencedSet.getGenerationProfile().iterator(); artefact == null && igp.hasNext();) {
               GenerationProfile generationProfile = (GenerationProfile) igp.next();
               
               if ( qualifiedName.startsWith(generationProfile.getPackagePrefix()))
                  artefact = getArtefact(artefactName, generationProfile, modelElement);
            }
         }
      }
      
      // No artefact found with respect to the correct package prefix, 
      // use the current profile 
      if ( artefact == null ) {
         artefact = getArtefact(artefactName, profile, modelElement);
         //TODO Warning to logging
      }
      
      if ( artefact == null ) {
         throw new RuntimeException("Artefact "+artefactName+" not found in profiles");
      }
      
      return artefact;
   }

   /**
    * Search a artefact by name or alias
    * @param artefactName
    * @param profile
    * @return
    */
   private static Artefact getArtefact(String artefactName, GenerationProfile genProfile, GeneratorModelElement modelElement) {
      
      Profile profile = genProfile.getProfile();
      Artefact a = getArtefact(artefactName, profile, modelElement);
      
      return a;
   }
   
   /**
    * @param artefactName
    * @param profile
    * @param modelElement
    * @return
    */
   private static Artefact getArtefact(String artefactName, Profile profile, GeneratorModelElement modelElement) {
      Artefact a = null;
      
      // Search in own profile
      for (Iterator ia = profile.getArtefacts().iterator(); a == null && ia.hasNext();) {
         Artefact artefact = (Artefact) ia.next();
         
         if ( artefactName.equals(artefact.getName()) ) {
            a = artefact;
         }
         else if ( artefactName.equals(artefact.getAlias()) ) {
            a = artefact;
         }
      }

      // Search in based profiles
      for (Iterator ip = profile.getBasedOn().iterator(); a == null && ip.hasNext();) {
         Profile p = (Profile) ip.next();
      
         a = getArtefact(artefactName, p, modelElement);
      }
      return a;
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorModel#getLoggingWriter()
    */
   public LoggingWriter getLoggingWriter() {
      if ( loggingWriter == null ) {
         String loggingType = getProperties().getProperty("Logging");
         
         if ( "log4j".equalsIgnoreCase(loggingType)) {
            loggingWriter = new Log4jWriter(createEmitter());
         }
         else if ( "commons".equalsIgnoreCase(loggingType)) {
            loggingWriter = new CommonsLoggingWriter(createEmitter());
         }
         else if ( "none".equalsIgnoreCase(loggingType)) {
            loggingWriter = new NoneLoggingWriter(createEmitter());
         }
         else {
            loggingWriter = new JavaLoggingWriter(createEmitter());
         }
      }
      return loggingWriter;
   }
   
}
