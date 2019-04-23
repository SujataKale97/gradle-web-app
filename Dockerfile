# Pull base image

FROM java
RUN apt-get wget -y upgrade
WORKDIR /opt/
RUN wget 'http://mirrors.estointernet.in/apache/tomcat/tomcat-8/v8.5.40/bin/apache-tomcat-8.5.40-deployer.tar.gz'
RUN tar -xvf
EXPOSE 8080

CMD ['/opt/apache-tomcat-8.5.40/bin/catalina.sh','run']
ADD  workspace.war /usr/local/tomcat/webapps/workspace.war 





