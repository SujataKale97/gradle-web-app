# Pull base image
From tomcat:7-jre8

RUN value=`cat conf/server.xml` && echo "${value//8080/8082}" >| conf/server.xml

# Copy to images tomcat path
ADD  workspace.war /usr/local/tomcat/webapps/workspace.war 


