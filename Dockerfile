# Pull base image
From tomcat:7-jre8

# Copy to images tomcat path
COPY  tomcat:7-jre8:/usr/local/tomcat/webapps/workspace.war C:/Apps/Jenkins/jobs/gradle-pipeline/workspace/build/libs/workspace.war
