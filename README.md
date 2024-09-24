# Music Shop

Este proyecto es una aplicación web para gestionar una tienda de música. Permite a los usuarios ver una lista de canciones, agregar nuevas canciones, actualizar información de canciones existentes y eliminar canciones.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **Spring Boot**: Framework para construir la aplicación.
- **Maven**: Herramienta de gestión de dependencias y construcción del proyecto.
- **Thymeleaf**: Motor de plantillas para la generación de vistas HTML.
- **PostgreSQL**: Base de datos utilizada para almacenar la información de las canciones.

## Estructura del Proyecto

El proyecto sigue una estructura estándar de Spring Boot con Maven:


### Descripción de Carpetas y Archivos

- **src/main/java/co/musicshop/fis/controllers**: Contiene los controladores de Spring MVC que manejan las solicitudes HTTP y devuelven las vistas correspondientes.
- **src/main/java/co/musicshop/fis/models**: Contiene las clases de modelo que representan las entidades de la base de datos.
- **src/main/java/co/musicshop/fis/repositories**: Contiene las interfaces de repositorio que extienden `JpaRepository` para realizar operaciones CRUD en la base de datos.
- **src/main/java/co/musicshop/fis/services**: Contiene las clases de servicio que implementan la lógica de negocio.
- **src/main/java/co/musicshop/fis/services/interfaces**: Contiene las interfaces de los servicios.
- **src/main/resources/static**: Contiene archivos estáticos como CSS y JavaScript.
- **src/main/resources/templates**: Contiene las plantillas Thymeleaf para las vistas HTML.
- **src/main/resources/application.yml**: Archivo de configuración de Spring Boot.
- **src/test/java**: Contiene las pruebas unitarias y de integración.
- **pom.xml**: Archivo de configuración de Maven que gestiona las dependencias del proyecto.
- **README.md**: Archivo que estás leyendo actualmente.

## Configuración

1. Clona el repositorio:
    ```sh
    git clone <URL_DEL_REPOSITORIO>
    ```
2. Configura las variables de entorno para la base de datos en `application.yml`:
    ```yaml
    spring:
      datasource:
        url: jdbc:postgresql://<HOST>:<PUERTO>/<NOMBRE_BD>
        username: <USUARIO>
        password: <CONTRASEÑA>
    ```
3. Ejecuta la aplicación:
    ```sh
    mvn spring-boot:run
    ```

## Uso

- Accede a la aplicación en `http://localhost:8080/songs`.
- Usa la interfaz para agregar, actualizar, eliminar y ver canciones.
