# Imagen Docker
FROM postgres:10-alpine
# Directorio del contenedor compartido al exterior
VOLUME /tmp
# Instalación de paquetes de software
RUN apk --update add openjdk8-jre
RUN apk add --no-cache supervisor && mkdir /etc/supervisord.d && mkdir -p /supervisor
#Variables
ARG JAR_FILE
ARG POSTGRES_PORT
ARG POSTGRES_HOSTNAME
# Variables de entorno
ENV DB_HOST=${POSTGRES_HOSTNAME}
ENV DB_PORT=${POSTGRES_PORT}
# Copia de archivo
COPY docker-scripts/supervisord.conf /etc
# Copia de Jar
COPY ${JAR_FILE} /app.jar
# Copia de script
COPY docker-scripts/entrypoint.sh /usr/local/bin/entrypoint.sh
# Especificación de puertos dentro del contenedor
EXPOSE 8080
EXPOSE 5432
# Comando de inicio de docker
CMD ["supervisord", "--nodaemon", "--configuration", "/etc/supervisord.conf"]