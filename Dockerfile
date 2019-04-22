FROM java:8
VOLUME /tmp
EXPOSE 8080
ADD /build/libs/myjar.jar docker_jar.jar>
#ENTRYPOINT ["java","-jar","spring-boot-docker-1.0.jar"]
