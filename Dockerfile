# Pull base image

FROM tomcat:7-jre8

ADD  workspace.war /usr/local/tomcat/webapps/workspace.war 
# Expose the default tomcat port
#EXPOSE 8088

#CMD ["catalina.sh", "run"]
