FROM maven:3.8.1-openjdk-17 AS builder

WORKDIR /app

COPY pom.xml .

RUN mvn -e -B dependency:resolve

COPY src ./src

RUN mvn clean -e -B package -DskipTests

# RTSDK Java

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=builder /app/target/backFinalProject-0.0.1-SNAPSHOT.jar .

#COPY run.sh ./run.sh #comment the COPY command

ENTRYPOINT ["java", "-jar", "./backFinalProject-0.0.1-SNAPSHOT.jar"]

CMD ["-ric", "/EUR="]