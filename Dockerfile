# Pull base image
From tomcat:7-jre8
cd c:/
# Copy to images tomcat path
 COPY  workspace/build/libs/workspace.war /usr/local/tomcat/webapps/workspace.war 
