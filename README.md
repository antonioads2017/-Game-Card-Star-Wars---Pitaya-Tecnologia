# Game Card Star Wars - Pitaya Tecnologia - VAGA-BACKEND
### API Rest inspirado no [SWAPI](https://swapi.co/)
#### Antonio Miguel de Sousa Filho
#
#### Para abrir a api, foi utilizado o UI do SWAGGER e deploy no Heroku 
##### Acesse  https://starwarsgc-api.herokuapp.com/swagger-ui.html 
##

##### Tecnologias Utilizadas 
 - JAVA Spring com Restful
 - Postgresql
 - Swagger
 - JPA Hibernate

#### Para testes utilizando a ferramenta [Postman](https://www.getpostman.com/)
* Use a url * https://starwarsgc-api.herokuapp.com/

### Deploy via IDE

#### Tenha o Docker instalado em sua maquina e execute os seguintes scripts para o banco de dados

#####Iniciar banco de dados
sudo ./bd_run.sh

#####Encerrar banco de dados
sudo ./bd_stop.sh

#### No arquivo application.properties localizado em src/main/resources, modifique as linhas para:
#
...
spring.datasource.url= jdbc:postgresql://localhost:5433/starwarsapi
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=org.postgresql.Driver
...
#
* Agora so construir e executar na IDE *