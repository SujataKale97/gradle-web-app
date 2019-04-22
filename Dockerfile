# Pull base image

FROM tomcat:8.0-alpine

ADD  workspace.war /usr/local/tomcat/webapps/workspace.war 
# Expose the default tomcat port
EXPOSE 8080

CMD ["catalina.sh", "run"]
