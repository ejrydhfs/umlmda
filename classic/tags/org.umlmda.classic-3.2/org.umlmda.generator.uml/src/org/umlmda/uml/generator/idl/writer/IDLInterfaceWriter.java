



package org.umlmda.uml.generator.idl.writer;



import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Hashtable;

/* section:import << */
//


import org.umlmda.model.uml.*;
import java.util.*;
// ==== End of generation header ===============================================



//
/* section:import >> */



public class IDLInterfaceWriter
extends org.umlmda.uml.generator.idl.AbstractIDLElementWriter

{
  
  /* Constants << */
  
  // Command line arguments
  public static final String writer__ARGUMENT_CONTROL_PREFIX = "jsa:";
  public static final String writer__ARGUMENT_OutputFolder   = "o=";
  public static final String writer__ARGUMENT_BackupFolder   = "b=";
  public static final String writer__ARGUMENT_NoBackup       = "B";
  
  // User Interface text message parts
  public static final String writer__UITEXT_Method                   = "method ";
  public static final String writer__UITEXT_Main                     = "main ";
  public static final String writer__UITEXT_ExceptionIn              = "Exception in ";
  public static final String writer__UITEXT_ColonNewLine             = ":\n";
  public static final String writer__UITEXT_NewLine                  = "\n";
  public static final String writer__UITEXT_Section                  = "section ";
  public static final String writer__UITEXT_SavedFile                = "Saved file:       ";
  public static final String writer__UITEXT_UnableToSaveFile         = "Unable to save file: ";
  public static final String writer__UITEXT_UnableToBackupFile       = "Unable to backup file: ";
  public static final String writer__UITEXT_ToBackupFolder           = " to backup folder: ";
  public static final String writer__UITEXT_BackupFolderColon        = "Backup folder: ";
  public static final String writer__UITEXT_BackupFolderExistFailure = " does not exist and cannot be created.";
  public static final String writer__UITEXT_BackupFolderNotAFolder   = " is not a folder.";
  public static final String writer__UITEXT_BackupFolderNotWritable  = " is not writable.";
  public static final String writer__UITEXT_CodeWriterState          = "Code Writer State: ";
  public static final String writer__UITEXT_GetFileIndexEquals       = "\n_getFileIndex()    = ";
  public static final String writer__UITEXT_GetFullFileNameEquals    = "\n_getFullFileName() = ";
  public static final String writer__UITEXT_GetOutputFolderEquals    = "\n_getOutputFolder() = ";
  public static final String writer__UITEXT_ErrorHeader              = "\n\n--- CodeWriter Error Description Start ---\n\n";
  public static final String writer__UITEXT_ErrorFooter              = "\n--- CodeWriter Error Description End -----\n\n";
  public static final String writer__UITEXT_PlaceHolderException
  = "This placeholder Exception should never be thrown: there is an error in the WriterFormat.";
  
  public static final int writer__FILE_BUFFER_SIZE  = 4096;                // initial size of StringBuffer
  
  /* Constants >> */
  
  
  /* Writer Variables << */
  
  
  protected StringBuffer writer__iCurrentText       = null;                // current text
  
  protected String[]     writer__iArgs              = new String[0];       // cmd line args
  protected int          writer__iNumArgs           = 0;                   // number of cmd line args
  
  protected Hashtable    writer__iProperties            = new Hashtable(); // lookup table for compile time properties
  protected boolean      writer__iPropertiesInitialised = false;           // true => lookup table initialiased
  
  /* Writer Variables >> */
  
  
  
  
  
  
  
  
  
  
  /* Initialize. */
  public void writer__initialize() {
  }
  
  
  
  /** Main loop.
  *  Template script is placed here in the @body section.
  */
  public void writer__write() throws Exception {
    
    // initialize
    String writer__currentSection = "init";
    
    
    try {
      if ( writer__iCurrentText == null ) {
        throw new RuntimeException("call _setOutbutBuffer() first");
      }
      
      
      
      
      
      
      /* section:body << */
      //
      
      writer__currentSection = "body";
      _insert("\n");
      _insert("\n");
      _insert("\n   /**\n    *\n    */\n   interface ");
      _insert(getClassName());
      _insert(" ");
      if ( getModelClass().getSuperClass() != null ) {
        _insert(": ");
        _insert(getBaseClass());
      }
      _insert("\n   {\n      // name registed in the CORBA naming service\n      const string REGISTERED_SERVICE_NAME = \"");
      _insert(getModelClass().getTaggedValues().getProperty("CORBAServiceName", getClassName()));
      _insert("\";\n     \n");
      // Modelled Methods
      for ( Iterator ia = getModelClass().getMethods().iterator(); ia.hasNext(); ) {
        ModelMethod method = (ModelMethod)ia.next();
        _insert("   /**\n    * ");
        _insert(method.getDocumentation());
        _insert("\n    */\n    ");
        _insert(getMethodSignature(method));
        _insert(";\n");
      }
      _insert("\t\t\n   };\n");
      
      
      //
      /* section:body >> */
      
      
      
      
      
      
      
      
      
      
    }
    catch( Exception e ) {
      writer__handleException( writer__UITEXT_ExceptionIn + writer__UITEXT_Section + writer__currentSection, e );
    }
    
  }
  
  
  /** Store command line arguments */
  public void writer__setArgs( int rNumArgs, String[] rArgs ) {
    writer__iNumArgs = rNumArgs;
    writer__iArgs    = rArgs;
  }
  
  /** Print a user message */
  public void writer__userMessage( String rMessage ) {
    System.out.print( rMessage );
  }
  
  /** Handle exceptions: print an explanation for user. */
  public void writer__handleException( String rMessage, Exception rException ) {
    
    StringBuffer userMsg = new StringBuffer( 111 );
    
    userMsg.append( writer__UITEXT_ErrorHeader );
    
    userMsg.append( writer__describeState() + rMessage + writer__UITEXT_ColonNewLine );
    
    StringWriter stringWriter = new StringWriter();
    rException.printStackTrace( new PrintWriter( stringWriter) );
    userMsg.append( stringWriter.toString() );
    
    userMsg.append( writer__UITEXT_ErrorFooter );
    
    throw new RuntimeException(userMsg.toString(), rException);
  }
  
  /** Provide a concise description of the state of the CodeWriter. */
  public String writer__describeState() {
    String currentState
    = writer__UITEXT_CodeWriterState
    + writer__UITEXT_NewLine
    ;
    return currentState;
  }
  
  
  
  /** Set compile time properties. */
  public void writer__initProperties() {
    
    String[] propertyList = new String[] { "parse.SectionMarker","!","java.implements","","lang.TemplateInsertTransforms","JavaStringEscapeTransform, TextElementTransform, AppendNewLineTransform","parse.OpenOuterChar","<","lang.FalseString","false","jostraca.regexp.SubmatchAnyWhiteSpaceAnyCharsAtEnd","(\\s*.*)$","main.WorkFolder","C:\\devel\\umlmda.rsm7\\build\\plugins\\org.umlmda.generator.uml\\src\\org\\umlmda\\uml\\generator\\idl\\writer","main.FileNameRoot","GeneratedFile","parse.regexp.OpenOuterChar","<","main.CodeWriterTransform.script","AppendNewLineTransform","jostraca.regexp.AnyWhiteSpaceAtStart","^\\s*","jostraca.regexp.IsExpression","^\\s*=","jostraca.template.isLibrary","false","jostraca.regexp.IsDirective","^\\s*@","parse.OpenInnerChar","%","lang.section.all.Modifiers","BlockIndenter","jostraca.system.pathSeparator",";","parse.regexp.OpenInnerChar","%","main.SaveCodeWriter","yes","jostraca.TemplateScript.CanonicalName.jv","java","parse.regexp.SectionMarker","!","jostraca.standard.TemplateScriptTransforms","AppendNewLineTransform","lang.InsertPrefix","_insert(","lang.CommentLineSuffix","","main.TemplatePath","C:\\devel\\umlmda.rsm7\\build\\plugins\\org.umlmda.generator.core\\lib\\jostraca\\conf\\../templates/src","java.extends","","lang.NameValueList.itemSeparator",",","lang.TrueString","true","main.TemplateScript","","main.EnableMeta","yes","main.ExternalCompilerOptions","","jostraca.Location","C:\\devel\\umlmda.rsm7\\build\\plugins\\org.umlmda.generator.core\\lib\\jostraca\\conf\\..","parse.Directives","SectionDirective, InitDirective, OneLineDirective, CollapseWhiteSpaceDirective, InsertSectionDirective, ReplaceDirective, ReplaceRegExpDirective","main.DumpPropertySet","no","jostraca.TemplateScript.CanonicalName.perl","perl","main.CodeWriterCompiler","org.jostraca.BasicJavaCodeWriterCompiler","java.CodeWriter.extends","org.umlmda.uml.generator.idl.AbstractIDLElementWriter","jostraca.standard.TemplateDirectiveTransforms","","main.ExecuteCodeWriter","no","main.CodeWriterTransform.expr","ExpressionElementTransform, AppendNewLineTransform","main.ExternalControllerOptions","","main.CodeWriter.argument.name.OutputFolder","o=","lang.InsertSuffix",");","jostraca.template.path","C:\\devel\\umlmda.rsm7\\build\\plugins\\org.umlmda.generator.uml\\src\\org\\umlmda\\uml\\generator\\idl\\writer\\IDLInterfaceWriter.jtm","main.CodeWriterTransform.insert-section","InsertSectionTransform","main.FileNamePrefix","","jostraca.noexit","yes","lang.StringEscapeTransform","JavaStringEscapeTransform","jostraca.system.fileSeparator","\\","main.BackupPrefix","-","parse.regexp.ExpressionMarker","=","main.CodeWriter.argument.name.BackupFolder","b=","jostraca.regexp.template.IncludeDirective","<%\\s*@\\s*include\\s+(\".+?\"|[^ ]+)\\s*([a-z- ]*)\\s*%>","main.CodeWriterController","org.jostraca.BasicJavaCodeWriterController","jostraca.TemplateScript.CanonicalName.rebol","rebol","parse.CloseOuterChar",">","jostraca.MakeBackup","false","main.CompileCodeWriter","no","main.CodeBuilder","org.jostraca.BasicCodeBuilder","java.ClassPathPrefix","","jostraca.template.name","C:\\devel\\umlmda.rsm7\\build\\plugins\\org.umlmda.generator.uml/src/org/umlmda/uml/generator/idl/writer/IDLInterfaceWriter.jtm","main.IncludeBase","","main.FileNameSuffix",".java","lang.CodeWriterTransforms","SimpleIndentTransform","jostraca.standard.Directives","SectionDirective, InitDirective, OneLineDirective, CollapseWhiteSpaceDirective","main.BackupFolder",".jostraca","parse.CloseInnerChar","%","fs","\\","jostraca.regexp.template.IncludeBlockDirective","<%\\s*@\\s*include-block\\s+[\\\"']?(.+?)[\\\"']?\\s+/(.+?)/\\s*%>","parse.regexp.DeclarationMarker","!","main.BackupSuffix","-backup.txt","main.OutputFolder","C:\\devel\\umlmda.rsm7\\build\\plugins\\org.umlmda.generator.uml\\src\\org\\umlmda\\uml\\generator\\idl\\writer","main.ExternalCompiler","javac","lang.NameValueList.nameQuote","\"","lang.TextQuote","\"","java.package","","jostraca.standard.TemplateInsertTransforms","JavaStringEscapeTransform, TextElementTransform, AppendNewLineTransform","jostraca.regexp.SubmatchDirectiveName","([a-zA-Z/_|\\.-][0-9a-zA-Z/_|\\.-]*)","jostraca.TemplateScript.CanonicalName.rb","ruby","lang.CommentBlockPrefix","/*","main.CodeWriterTransform.text","JavaStringEscapeTransform, TextElementTransform, AppendNewLineTransform","jostraca.standard.TemplateExpressionTransforms","ExpressionElementTransform, AppendNewLineTransform","main.DefaultTemplateScript","java","jostraca.strict.version","yes","parse.regexp.DirectiveMarker","@","lang.NameValueList.pairSeparator",",","jostraca.regexp.AnyWhiteSpace","\\s*","java.ClassPathSuffix","","jostraca.FormatFolder","C:\\devel\\umlmda.rsm7\\build\\plugins\\org.umlmda.generator.core\\lib\\jostraca\\conf\\../format","main.MakeBackup","no","java.CodeWriter.package","org.umlmda.uml.generator.idl.writer","main.MetaFolder",".jostraca","lang.TemplateScriptTransforms","AppendNewLineTransform","jostraca.TemplateScript.CanonicalName.py","python","java.ClassPath","","lang.NameValueList.valueQuote","\"","main.CodeWriter","IDLInterfaceWriter","ps",";","jostraca.TemplateScript.CanonicalName.pl","perl","jostraca.TemplateScript.CanonicalName.java","java","jostraca.regexp.MatchDirective","^\\s*@\\s*([a-zA-Z/_|\\.-][0-9a-zA-Z/_|\\.-]*)(\\s*.*)$","lang.CommentBlockSuffix","*/","jostraca.regexp.MatchExpression","^\\s*=(\\s*.*)$","jostraca.TemplateScript.CanonicalName.r","rebol","main.CodeWriterPrefix","","jostraca.template.file","IDLInterfaceWriter.jtm","o","<%","jostraca.TemplateScript.CanonicalName.c","c","c","%>","main.TemplateParser","org.jostraca.BasicTemplateParser","jostraca.TemplateScript.CanonicalName.ruby","ruby","parse.regexp.CloseOuterChar",">","parse.DeclarationMarker","!","lang.TemplateDirectiveTransforms","","jostraca.properties.modifiers","org.jostraca.NameValueListPSM","main.CodeWriterSuffix",".java","main.ShowDocumentation","no","jostraca.version","0.3","jostraca.template.folder","C:\\devel\\umlmda.rsm7\\build\\plugins\\org.umlmda.generator.uml\\src\\org\\umlmda\\uml\\generator\\idl\\writer","parse.DirectiveMarker","@","parse.regexp.CloseInnerChar","%","main.CodeWriterFormat","format\\EmbeddedJavaWriterFormat.jwf","jostraca.regexp.template.ConfDirective","<%\\s*@\\s*conf\\s+(.+?)\\s*%>","main.DumpTemplate","no","jostraca.standard.TemplateTextTransforms","","main.CodeWriter.argument.ControlPrefix","jsa:","parse.ExpressionMarker","=","jostraca.regexp.MatchSectionName","^\\s*([a-zA-Z_\\.-][0-9a-zA-Z_\\.-]*)!(\\s*.*)$","main.JostracaVersion","0.3","jostraca.LocalConfigFileName","local.conf","jostraca.regexp.template.IncludeBaseDirective","<%\\s*@\\s*include-base\\s+[\\\"']?(.+?)[\\\"']?\\s*%>","jostraca.regexp.MatchDeclaration","^\\s*!(\\s*.*)$","lang.TemplateExpressionTransforms","ExpressionElementTransform, AppendNewLineTransform","main.ExternalController","java","main.DefaultTemplatePath","C:\\devel\\umlmda.rsm7\\build\\plugins\\org.umlmda.generator.core\\lib\\jostraca\\conf\\../templates/src","main.CodeWriter.argument.name.NoBackup","B","jostraca.regexp.SubmatchSectionName","([a-zA-Z_\\.-][0-9a-zA-Z_\\.-]*)","jostraca.TemplateScript.CanonicalName.python","python","main.CodeWriter.argument.name.CodeWriterOutputFolder","O=","lang.CommentLinePrefix","//","lang.TemplateTextTransforms","","java.CodeWriter.implements","","main.AlsoGenerate","" };
    int numProperties = propertyList.length;
    for( int propI = 0; propI < numProperties; propI += 2 ) {
      writer__iProperties.put( propertyList[ propI ], propertyList[ propI+1 ] );
    }
    writer__iPropertiesInitialised = true;
    
  }
  
  
  /* Writer Services >> */
  
  public void _setOutputBuffer(StringBuffer stringBuffer) {
    writer__iCurrentText = stringBuffer;
  }
  
  
  
  /* Template Services (Control) << */
  
  /** Get compile time property
  *  @param rName Name of property to get.
  */
  public String _getProperty( String rName ) {
    String result = "";
    
    if( ! writer__iPropertiesInitialised ) {
      writer__initProperties();
    }
    
    if( writer__iProperties.containsKey( rName ) ) {
      result = (String) writer__iProperties.get( rName );
    }
    
    return result;
  }
  
  
  
  /** Get first user arg - that is, first arg with no writer__ARGUMENT_CONTROL_PREFIX. */
  public String _getFirstUserArg() {
    return _getUserArg(0);
  }
  
  
  
  /** Get second user arg - that is, second arg with no writer__ARGUMENT_CONTROL_PREFIX. */
  public String _getSecondUserArg() {
    return _getUserArg(1);
  }
  
  
  
  /** Get third user arg - that is, third arg with no writer__ARGUMENT_CONTROL_PREFIX. */
  public String _getThirdUserArg() {
    return _getUserArg(2);
  }
  
  
  
  /** Get user arg at specified ordinal.
  *  @param rOrdinal ordinal of user arg to get.
  */
  public String _getUserArg( int rOrdinal ) {
    if( null == writer__iArgs ) {
      return "";
    }
    int ordinal = 0;
    int numArgs = writer__iArgs.length;
    next_arg: for(int argI = 0; argI < numArgs; argI++) {
      if( writer__iArgs[argI].startsWith( writer__ARGUMENT_CONTROL_PREFIX ) ) {
        continue next_arg;
      } else {
        if( ordinal == rOrdinal ) {
          return writer__iArgs[argI];
        } else {
          ordinal++;
        }
      }
    }
    return "";
  }
  
  
  
  /** Get command line arguments to CodeWriter. */
  public String[] _getArgs() {
    return writer__iArgs;
  }
  
  
  
  /** Get number of command line arguments to CodeWriter. */
  public int _getNumArgs() {
    return writer__iNumArgs;
  }
  
  
  
  /* Template Services (Control) >> */
  
  
  
  /* Template Services (Text Production) << */
  
  
  // inserts
  // ...
  
  /** Insert text into written file.
  *  Abbreviated by <%=foobar%>.
  *  @param rText Text to insert.
  */
  public void _insert( String rText ) {
    writer__iCurrentText.append( rText );
  }
  
  /** Insert string representation of object into written file.
  *  Abbreviated by <%=foobar%>.
  *  @param rObject Object to insert.
  */
  public void _insert( Object rObject ) {
    writer__iCurrentText.append( ""+rObject );
  }
  
  /** Insert string representation of primitive data type into written file.
  *  Abbreviated by <%=foobar%>.
  *  @param rInt int to insert
  */
  public void _insert( int rInt ) {
    writer__iCurrentText.append( rInt );
  }
  
  /** Insert string representation of primitive data type into written file.
  *  Abbreviated by <%=foobar%>.
  *  @param rLong long to insert
  */
  public void _insert( long rLong ) {
    writer__iCurrentText.append( rLong );
  }
  
  /** Insert string representation of primitive data type into written file.
  *  Abbreviated by <%=foobar%>.
  *  @param rShort short to insert
  */
  public void _insert( short rShort ) {
    writer__iCurrentText.append( rShort );
  }
  
  /** Insert string representation of primitive data type into written file.
  *  Abbreviated by <%=foobar%>.
  *  @param rByte byte to insert
  */
  public void _insert( byte rByte ) {
    writer__iCurrentText.append( rByte );
  }
  
  /** Insert string representation of primitive data type into written file.
  *  Abbreviated by <%=foobar%>.
  *  @param rDouble double to insert
  */
  public void _insert( double rDouble ) {
    writer__iCurrentText.append( rDouble );
  }
  
  /** Insert string representation of primitive data type into written file.
  *  Abbreviated by <%=foobar%>.
  *  @param rFloat float to insert
  */
  public void _insert( float rFloat ) {
    writer__iCurrentText.append( rFloat );
  }
  
  /** Insert string representation of primitive data type into written file.
  *  Abbreviated by <%=foobar%>.
  *  @param rChar char to insert
  */
  public void _insert( char rChar ) {
    writer__iCurrentText.append( rChar );
  }
  
  /** Insert string representation of primitive data type into written file.
  *  Abbreviated by <%=foobar%>.
  *  @param rBoolean boolean to insert
  */
  public void _insert( boolean rBoolean ) {
    writer__iCurrentText.append( rBoolean );
  }
  
  
  
  /** Create a String containing specified number of spaces.
  *  @param rNumSpaces Number of spaces to place in String
  */
  public String _spaces( int rNumSpaces ) {
    int numSpaces = rNumSpaces;
    if( 0 > numSpaces ) { numSpaces *= -1; }
    StringBuffer spaces = new StringBuffer( numSpaces );
    for(int spaceI = 0; spaceI < numSpaces; spaceI++) {
      spaces.append(" ");
    }
    return spaces.toString();
  }
  
  
  
  /** Left align String with spaces. */
  public String _left( String rText, int rColWidth ) {
    return _align( rText, " ", rColWidth, 'l' );
  }
  
  
  
  /** Right align String with spaces. */
  public String _right( String rText, int rColWidth ) {
    return _align( rText, " ", rColWidth, 'r' );
  }
  
  
  
  /** Center align String with spaces. */
  public String _center( String rText, int rColWidth ) {
    return _align( rText, " ", rColWidth, 'c' );
  }
  
  
  
  /** Align text within background text to specified column width.
  *  Alignment can be 'l': left, 'c': center, 'r': right
  */
  public String _align( String rText, String rBackText, int rColWidth, char rAlignment ) {
    String result = rText;
    
    if( null == rText ) {
      result = "";
    }
    else if( null != rBackText ) {
      try {
        int textLen = rText.length();
        if( rColWidth > textLen ) {
          int    backTextLen     = rBackText.length();
          int    remainWidth     = rColWidth - textLen;
          int    backTextRepeats = remainWidth / backTextLen;
          int    backTextRemain  = remainWidth % backTextLen;
          String back            = "";
          for( int backTextI = 0; backTextI < backTextRepeats; backTextI++ ) {
            back = back + rBackText;
          }
          back = back + rBackText.substring( 0, backTextRemain );
          
          switch( rAlignment ) {
            case 'l':
            result = result + back;
            break;
            case 'c':
            result = back.substring( 0, (back.length()/2) ) + result + back.substring( (back.length()/2) );
            break;
            case 'r':
            result = back + result;
            break;
          }
        }
      }
      catch( Exception e ) {
        result = rText;
      }
    }
    return result;
  }
  
  
  
  /** Set current text of file currently being generated. */
  public void _setText( String rText) {
    writer__iCurrentText = new StringBuffer( rText );
  }
  
  
  
  /** Get current text of file currently being generated. */
  public String _getText() {
    return writer__iCurrentText.toString();
  }
  
  /* Template Services (Text Production) << */
  
}



