FROM amazoncorretto:21.0.4
ENV APP_DIR=/usr/app
ENV JAVA_OPTS="-Xmx1g -XX:+UseG1GC -XX:InitiatingHeapOccupancyPercent=70 -Djava.security.egd=file:/dev/./urandom"
ADD ./build/libs/service-tms-*plain.jar $APP_DIR/service-tms.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar ${APP_DIR}/service-tms.jar"]