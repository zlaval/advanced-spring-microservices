FROM anapsix/alpine-java

VOLUME app
WORKDIR /app
ADD /build/libs/zuul-server.jar .
ENTRYPOINT ["java","-jar","zuul-server.jar"]
