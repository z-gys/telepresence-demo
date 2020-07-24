FROM bellsoft/liberica-openjdk-alpine:14

WORKDIR /opt/app

EXPOSE 8080

ENV PROFILE=cloud

HEALTHCHECK \
        --interval=5s \
        --start-period=10s \
        --retries=10 \
        CMD curl -v --fail http://localhost:8080/actuator/health || exit 1

COPY docker/entrypoint.sh /
COPY target/*.jar .
RUN apk add --update --no-cache curl bash \
    && chmod +x /entrypoint.sh


ENTRYPOINT ["/entrypoint.sh"]