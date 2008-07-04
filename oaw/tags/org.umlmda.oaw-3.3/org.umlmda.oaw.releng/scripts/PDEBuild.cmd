SET JAVA_HOME=C:\winapp\Rational\SDP\7.0\jdk
SET ECLIPSE_HOME=C:\winapp\Rational\SDP\7.0-Shared
SET STARTUP=C:\winapp\Rational\SDP\7.0\startup.jar
SET RELENG_PROJECT=%WORKSPACE%\org.umlmda.oaw.releng
%JAVA_HOME%\bin\java -version
%JAVA_HOME%\bin\java -jar %STARTUP% -application org.eclipse.ant.core.antRunner -buildfile %ECLIPSE_HOME%/plugins/org.eclipse.pde.build_3.3.2.R331_v20071019/scripts/build.xml -Dbuilder=%RELENG_PROJECT%/scripts
