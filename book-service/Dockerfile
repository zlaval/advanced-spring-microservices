FROM anapsix/alpine-java

VOLUME app
WORKDIR /app
ADD /build/libs/book-service.jar .
ENTRYPOINT ["java","-jar","book-service.jar"]
