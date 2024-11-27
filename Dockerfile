# Usa una imagen base de JDK para ejecutar el JAR
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado al contenedor
COPY target/servicios-0.0.1-SNAPSHOT.jar servicios-ms.jar

# Expone el puerto 8001
EXPOSE 8005

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "servicios-ms.jar"]