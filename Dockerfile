# Usar imagem oficial do Java 21
FROM eclipse-temurin:21-jdk-alpine

# Criar diretório dentro do container
WORKDIR /app

# Copiar o jar para dentro do container
COPY target/CadastroDeNinjas-0.0.1-SNAPSHOT.jar app.jar

# Expor porta da aplicação
EXPOSE 8080

# Rodar aplicação
ENTRYPOINT ["java","-jar","app.jar"]