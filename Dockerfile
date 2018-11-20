FROM java:8-jdk
COPY target/*.jar /app/app.jar
EXPOSE 8000
WORKDIR /app
CMD /bin/bash -c 'java -jar app.jar'