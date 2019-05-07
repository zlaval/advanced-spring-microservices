FROM anapsix/alpine-java

VOLUME app
WORKDIR /app
ADD /build/libs/eureka-server.jar .
ENTRYPOINT ["java","-jar","eureka-server.jar"]
