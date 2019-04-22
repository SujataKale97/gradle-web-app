# Pull base image
From tomcat:7-jre8

# Copy to images tomcat path
 COPY  C:/Apps/Jenkins/jobs/gradle-pipeline/workspace/build/libs/ /usr/local/tomcat/webapps/ 
