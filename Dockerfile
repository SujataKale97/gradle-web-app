# Pull base image
From tomcat:7-jre8



# Copy to images tomcat path
ADD  workspace.war /usr/local/tomcat/webapps/workspace.war 

run -i --expose=22 90134baa2d83


