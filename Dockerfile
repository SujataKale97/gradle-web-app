# Pull base image

FROM tomcat:7-jre8

ADD  workspace.war /usr/local/tomcat/webapps/workspace.war 
# Expose the default tomcat port
EXPOSE 8080

# Start the tomcat (and leave it hanging)
CMD service tomcat start && tail -f /var/lib/tomcat7/logs/catalina.out

