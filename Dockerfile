FROM openjdk:8-jdk-alpine
VOLUME /tmp
# RUN mvn install -DskipTests
COPY target/*.jar spring-boot-k8s.jar
ENV SPRING_PROFILES_ACTIVE=prod
ENV SPRING-BOOT_RUN_PROFILES=prod
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/spring-boot-k8s.jar"]