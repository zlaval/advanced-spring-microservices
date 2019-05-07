FROM anapsix/alpine-java

VOLUME app
WORKDIR /app
ADD /build/libs/authentication-service.jar .
ENTRYPOINT ["java","-jar","authentication-service.jar"]
