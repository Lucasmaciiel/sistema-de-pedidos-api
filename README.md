# 🛍️ Sistema de Pedidos API

## 📝 Descrição
API REST desenvolvida com Spring Boot para gerenciamento de pedidos, oferecendo funcionalidades completas de e-commerce com segurança e documentação.

## 🚀 Tecnologias Utilizadas

- ☕ Java 11
- 🍃 Spring Boot 2.4.0
- 🔐 Spring Security + JWT
- 📊 JPA/Hibernate
- 🗄️ Bancos de Dados:
  - MySQL (Produção)
  - H2 Database (Testes)
- 📧 Spring Mail + Thymeleaf
- ☁️ AWS SDK (Armazenamento de imagens)
- 📝 Swagger (Documentação da API)
- 🖼️ ImageScalr (Processamento de imagens)

## 🛠️ Funcionalidades

- ✅ Autenticação e Autorização com JWT
- 📦 Gerenciamento de Produtos
- 🛒 Gestão de Pedidos
- 👥 Cadastro e Gestão de Clientes
- 📧 Envio de E-mails Transacionais
- 🖼️ Upload e Processamento de Imagens
- 📊 Relatórios e Consultas

## 🔧 Configuração do Ambiente

### Pré-requisitos
- Java 11
- Maven
- MySQL (para ambiente de produção)

### Instalação

1. Clone o repositório:
```bash
git clone https://github.com/Lucasmaciiel/sistema-de-pedidos-api.git
```

2. Configure o banco de dados no arquivo `application.properties`

3. Execute o projeto:
```bash
mvn spring-boot:run
```

## 📚 Documentação da API

A documentação completa da API está disponível através do Swagger UI:
- Local: http://localhost:8080/swagger-ui.html
- Produção: https://sistema-pedido-spring.herokuapp.com/swagger-ui.html#/

## 🚀 Deploy

O projeto está configurado para deploy no Heroku, utilizando:
- JawsDB MySQL para banco de dados
- Amazon S3 para armazenamento de arquivos

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👨‍💻 Autor

Desenvolvido por Lucas Maciel de Gois

---
⭐ Se este projeto te ajudou, não esqueça de deixar uma estrela!
