FROM anapsix/alpine-java

VOLUME app
WORKDIR /app
ADD /build/libs/zipkin-server.jar .
ENTRYPOINT ["java","-jar","zipkin-server.jar"]
