FROM openjdk:8-alpine
RUN mkdir /rentalCarApp
COPY ./docker-entrypoint.sh /rentalCarApp
COPY ./target/serving-web-content-0.0.1-SNAPSHOT.jar /rentalCarApp
WORKDIR /rentalCarApp
ENTRYPOINT ["/rentalCarApp/docker-entrypoint.sh"]
CMD exec java  $JAVA_OPTS -jar /rentalCarApp/serving-web-content-0.0.1-SNAPSHOT.jar
