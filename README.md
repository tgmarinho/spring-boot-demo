# spring-boot-demo

## [Wiki](https://github.com/wanderleisouza/spring-boot-demo/wiki)

Spring boot demo é um [walking skeleton](http://c2.com/cgi/wiki?WalkingSkeleton). Uma aplicação modelo para iniciar o desenvolvimento de microserviços com Spring Boot. A documentação dos componentes do projeto está disponível no [Wiki](https://github.com/wanderleisouza/spring-boot-demo/wiki).


## Compile, execute e valide o ambiente 

para compilar e gerar o pacote (é necessário instalar o [Maven3](https://maven.apache.org/download.cgi)):

```mvn clean package``` 

para executar:

para validar o ambiente:
```java -jar target/demo-0.0.1-SNAPSHOT.war```


[http://localhost:8080/health](http://localhost:8080/health)

## Exemplos

```curl -u my-client-with-secret:secret -d "grant_type=client_credentials" "http://localhost:8080/oauth/token"
```curl -H "Authorization: Bearer COLE_AQUI_SEU_ACCESS_TOKEN" "http://localhost:8080/v1/cars?q=ronda"

## IDE Suporte

Para utilizar esse projeto em uma IDE (Eclipse, etc) você precisará instalar o jar do projeto [project Lombok](http://projectlombok.org/features/index.html). Basicamente um duplo clique no jar do Lombok resolverá. Para mais detalhes, veja a documentação completa no site do Lombok. Se a instalação do Lombok não funcionou você verá muitos erros de compilação apontando métodos e atributos ausentes.
