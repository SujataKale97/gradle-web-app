# Pull base image

FROM java

RUN apt-get install wget -y
WORKDIR /opt/
RUN wget https://archive.apache.org/dist/tomcat/tomcat-8/v8.0.53/bin/apache-tomcat-8.0.53.tar.gz 
RUN tar xvfz 

EXPOSE 8080
ADD  workspace.war /usr/local/tomcat/webapps/workspace.war 
CMD ['/usr/local/tomcat/bin/startup.sh','run']






