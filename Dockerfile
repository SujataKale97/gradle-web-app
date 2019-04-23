# Pull base image

FROM tomcat:7-jre8

EXPOSE 8080
ADD  workspace.war /usr/local/tomcat/apache-tomcat-8.0.53/webapps/workspace.war 







