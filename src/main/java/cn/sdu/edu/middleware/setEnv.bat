@echo 
set JACORB_HOME=D:\temp\jacorb-3.0
set CLASSPATH=.;%CLASSPATH%;%JACORB_HOME%/lib/idl.jar;%JACORB_HOME%/lib/jacorb.jar;%JACORB_HOME%/lib/slf4j-api-1.6.4.jar;%JACORB_HOME%/lib/wrapper-3.1.0.jar;%JACORB_HOME%/lib/picocontainer-1.2.jar; %JACORB_HOME%/lib/antlr-2.7.2.jar;%JACORB_HOME%/classes
pause

wmic ENVIRONMENT create name="JACORB_HOME",username="<system>", VariableValue="D:\temp\jacorb-3.0"
wmic ENVIRONMENT where "name='CLASSPATH' and username='<system>'" set VariableValue=".;%CLASSPATH%;%JACORB_HOME%/lib/idl.jar;%JACORB_HOME%/lib/jacorb.jar;%JACORB_HOME%/lib/slf4j-api-1.6.4.jar;%JACORB_HOME%/lib/wrapper-3.1.0.jar;%JACORB_HOME%/lib/picocontainer-1.2.jar; %JACORB_HOME%/lib/antlr-2.7.2.jar;%JACORB_HOME%/classes"
wmic ENVIRONMENT where "name='Path' and username='<system>'" set VariableValue="%Path%;%JACORB_HOME%\bin;"

pause