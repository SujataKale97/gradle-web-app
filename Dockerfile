# Pull base image
From tomcat:8-jre8

# Copy to images tomcat path
ADD C:\\Apps\\Jenkins\\jobs\\gradle-pipeline\\workspace\\build\\libs\\*.war C:\\apache-tomcat-7.0.94\\webapps
