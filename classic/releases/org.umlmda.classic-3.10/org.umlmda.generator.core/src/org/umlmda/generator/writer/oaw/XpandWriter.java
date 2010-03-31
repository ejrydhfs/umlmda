/**
 * 
 */
package org.umlmda.generator.writer.oaw;

import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenStream;
import org.apache.log4j.Logger;
import org.openarchitectureware.expression.ExecutionContext;
import org.openarchitectureware.expression.Variable;
import org.openarchitectureware.type.impl.java.JavaMetaModel;
import org.openarchitectureware.type.impl.java.beans.JavaBeansStrategy;
import org.openarchitectureware.type.impl.oawclassic.OAWClassicStrategy;
import org.openarchitectureware.xpand2.XpandExecutionContext;
import org.openarchitectureware.xpand2.XpandExecutionContextImpl;
import org.openarchitectureware.xpand2.ast.Definition;
import org.openarchitectureware.xpand2.ast.ExpandStatement;
import org.openarchitectureware.xpand2.codeassist.XpandTokens;
import org.openarchitectureware.xpand2.parser.XpandFactory;
import org.openarchitectureware.xpand2.parser.XpandLexer;
import org.openarchitectureware.xpand2.parser.XpandParser;
import org.umlmda.generator.model.util.Feedback;
import org.umlmda.generator.model.util.GeneratorRuntime;
import org.umlmda.generator.writer.AbstractTemplateWriter;


/**
 * @author MOROFF
 *
 */
public class XpandWriter extends AbstractTemplateWriter {
   private Logger logger = Logger.getLogger(XpandWriter.class);
   
   /**
    * @param feedback
    * @param templateName
    * @param templatePaths
    */
   public XpandWriter(GeneratorRuntime runtime, String templateName, List templatePaths) {
      super(runtime.getFeedback(), templateName, templatePaths);
   }
   
   
   @Override
   protected StringBuffer _getOutputBuffer() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   protected void _setOutputFolder(String outputFolder) {
      GeneratorRuntime.getInstance().getXpandOutputImpl().setOutputFolder(outputFolder);
   }

   @Override
   protected void writer__initialize() {
      // TODO Auto-generated method stub
      
   }

   @Override
   protected void writer__write() throws Exception {
      getFeedback().message(Feedback.INFO, "Write template "+templateName+" to "+getOutputName());
      
      Variable variable = new Variable("modelElement", getModelElement());
      ExpandStatement statement = getStatement();
      XpandExecutionContext localExecutionContext = (XpandExecutionContext) GeneratorRuntime.getInstance().getXpandExecutionContext().cloneWithVariable(variable);
      statement.evaluate(localExecutionContext);
   }

   private ExpandStatement getStatement() {
      String statement = XpandTokens.LT + "DEFINE test FOR test" + XpandTokens.RT
                       + XpandTokens.LT + "EXPAND " + templateName + " FOR modelElement" + XpandTokens.RT 
                       + XpandTokens.LT + "ENDDEFINE" + XpandTokens.RT;
//       final Scanner s = new Scanner(new StringReader(statement));
       final TokenStream s = new CommonTokenStream(new XpandLexer(new ANTLRStringStream(statement)));
       final XpandParser p = new XpandParser(s, new XpandFactory("workflow-description"));
       ExpandStatement es = null;
       try {
           es = (ExpandStatement) ((Definition) p.template().getDefinitions()[0]).getBody()[1];
       } catch (final Exception e) {
           logger.error(e);
       }
       return es;
   }

}
