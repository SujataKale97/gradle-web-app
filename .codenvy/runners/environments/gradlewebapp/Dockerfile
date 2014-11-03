FROM codenvy/jdk7_tomcat7
RUN mkdir /home/user/gradle
# download Gradle distribution, unzip it
RUN wget -P /home/user/ --quiet https://services.gradle.org/distributions/gradle-2.0-bin.zip
RUN cd /home/user/ && unzip gradle-2.0-bin.zip

# set environment variables
ENV GRADLE_HOME /home/user/gradle-2.0
RUN echo 'export GRADLE_HOME=$GRADLE_HOME' >> /home/user/.bashrc
ENV PATH $GRADLE_HOME/bin:$PATH
RUN echo "export PATH=$PATH" >> /home/user/.bashrc

RUN mkdir /home/user/app
ADD $app$ /home/user/app/
ENV CODENVY_APP_PORT_8080_HTTP 8080
EXPOSE 8080
RUN cd /home/user/app && gradle war && cp /home/user/app/build/libs/app.war /home/user/tomcat7/webapps/ROOT.war
CMD /home/user/tomcat7/bin/catalina.sh run
