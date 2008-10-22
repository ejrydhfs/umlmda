SET JAVA_HOME=D:\winapp\IBM\SDP\jdk
REM SET ECLIPSE_HOME=D:\winapp\IBM\SDPShared
SET ECLIPSE_HOME=D:\devel\umlmda.pde\releng\org.eclipse.releng.basebuilder
REM SET STARTUP=D:\winapp\IBM\SDP\startup.jar
SET STARTUP=%ECLIPSE_HOME%\startup.jar
SET RELENG_PROJECT=%WORKSPACE%\org.umlmda.3rdparty.releng
%JAVA_HOME%\bin\java -version
%JAVA_HOME%\bin\java -jar %STARTUP% -application org.eclipse.ant.core.antRunner -buildfile %ECLIPSE_HOME%/plugins/org.eclipse.pde.build/scripts/build.xml -Dbuilder=%RELENG_PROJECT%/scripts
