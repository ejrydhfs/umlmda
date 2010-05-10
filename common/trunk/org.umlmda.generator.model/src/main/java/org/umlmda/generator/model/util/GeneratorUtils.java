/*
 * Created on 27.10.2005
 */
package org.umlmda.generator.model.util;

import org.apache.commons.lang.StringUtils;
import org.umlmda.generator.model.uml.GeneratorModelElement;
import org.umlmda.generator.profile.Artefact;

/**
 * @author MOROFF
 */
public class GeneratorUtils
{

   public static String getGeneratedName(GeneratorModelElement genElement, String artefactType) {
      Artefact artefact = genElement.getGeneratorModel().getArtefact(artefactType, genElement);

      if ( artefact == null ) {
         throw new RuntimeException("No artefact with name " + artefactType + " found");
      }

      if ( StringUtils.isNotEmpty(artefact.getReplacementPattern()) && StringUtils.isNotEmpty(artefact.getReplacement()) ) {
         try {
            return StringUtil.regexReplacement(genElement.getReplacementName(), artefact.getReplacementPattern(), artefact
                  .getReplacement());
         }
         catch (StringUtil.PatternNotMatchException e) {
            return getGeneratedPrePostfixName(genElement, artefact);
         }
      }
      else {
         return getGeneratedPrePostfixName(genElement, artefact);
      }
   }

   /**
    * @param genElement
    * @param artefact
    * @return
    */
   private static String getGeneratedPrePostfixName(GeneratorModelElement genElement, Artefact artefact) {
      StringBuffer buffer = new StringBuffer();

      if ( StringUtils.isNotEmpty(artefact.getPrefix()) )
         buffer.append(artefact.getPrefix());
      buffer.append(genElement.getName());
      if ( StringUtils.isNotEmpty(artefact.getPostfix()) )
         buffer.append(artefact.getPostfix());

      return buffer.toString();
   }

}
