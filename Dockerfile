FROM openjdk:11.0.1-jre-slim
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ADD /build/libs/<jar_name.jar> <docker_jar_name.jar>
ENTRYPOINT ["java","-jar","spring-boot-docker-1.0.jar"]
