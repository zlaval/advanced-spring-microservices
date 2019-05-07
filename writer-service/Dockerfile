FROM anapsix/alpine-java

VOLUME app
WORKDIR /app
ADD /build/libs/writer-service.jar .
ENTRYPOINT ["java","-jar","writer-service.jar"]
