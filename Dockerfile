# Pull base image
From tomcat:7-jre8

# Copy to images tomcat path
 COPY  workspace.war /usr/local/tomcat/webapps/workspace.war 
