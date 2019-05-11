[![Build Status](https://travis-ci.org/ExampleDriven/spring-boot-docker-example.svg?branch=master)](https://travis-ci.org/ExampleDriven/spring-boot-docker-example)
# GFT prueba tecnica



Features :
- Maven docker plugin
- Crear images sin dockerfile
- spring cloud config
- spring netflix eureka
- spring netflix zuul
- spring feign
- docker-compose 

Para ejecutar :

```sh
## crea imagenes docker
mvn clean install -Dmaven.test.skip=true

##ver imganes creadas 
docker images

##inicia orquestacion de imagenes
docker-compose up

##ver contenedores levantados
docker-compose ps


##inicia algun contenedor no levantado
docker-compose scale nombre-Servicio=1
```

endpoint | descripcion
--- | ---
http://localhost:8761/ | Eureka service.
http://localhost:8080/persona-feing/swagger-ui.html | SWAGGER api
