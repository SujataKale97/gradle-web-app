# Pull base image

RUN -t tomcat -P -d tomcat

#ADD  workspace.war /usr/local/tomcat/webapps/workspace.war 
# Expose the default tomcat port
#EXPOSE 8088

#CMD ["catalina.sh", "run"]
