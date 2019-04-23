# Pull base image

FROM java

RUN apt-get install wget -y
RUN mkdir /usr/local/tomcat
RUN wget https://archive.apache.org/dist/tomcat/tomcat-8/v8.0.53/bin/apache-tomcat-8.0.53.tar.gz -O /tmp/tomcat.tar.gz
RUN cd /tmp && tar xvfz tomcat.tar.gz
RUN cp -Rv /tmp/apache-tomcat-8.0.53/* /usr/local/tomcat/
EXPOSE 8080
ADD  workspace.war /usr/local/tomcat/webapps/workspace.war 
CMD ['/usr/local/tomcat/bin/startup.sh','run']






