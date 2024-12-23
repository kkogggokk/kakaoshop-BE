# kakaoshop-BE 컨테이너 이미지
FROM --platform=$BUILDPLATFORM gradle:8-jdk17 AS build
WORKDIR /home/gradle
COPY . /home/gradle
RUN ./gradlew build -x test

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY setup_node_exporter.sh /usr/local/bin/setup_node_exporter.sh
RUN chmod +x /usr/local/bin/setup_node_exporter.sh
COPY --from=build /home/gradle/build/libs/kakao-1.0.jar /app/kakao-1.0.jar
CMD ["/bin/sh", "-c", "/usr/local/bin/setup_node_exporter.sh && java -jar -Dspring.profiles.active=docker /app/kakao-1.0.jar"]
EXPOSE 8080 9100