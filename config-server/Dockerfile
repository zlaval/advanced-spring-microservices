FROM anapsix/alpine-java

VOLUME app
WORKDIR /app
ADD /build/libs/config-server.jar .
ENTRYPOINT ["java","-jar","config-server.jar"]
