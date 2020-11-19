EJECUTAR LOS SIGUIENTES CODIGOS  DENTRO DE LA CARPETA msc-evaluation

mvnw clean package
docker build -t dockerhandson/spring-boot-mongo .
docker-compose up -d 
