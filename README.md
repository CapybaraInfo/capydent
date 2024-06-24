Sistema para dentistas
=======
Capy Odonto - API REST
===============================

Bem-vindo ao repositório da API REST para o controle de um consultório odontológico. Esta aplicação foi desenvolvida utilizando Spring Boot, MyBatis e PostgreSQL. Ela fornece endpoints para gerenciar pacientes, agendamentos e tratamentos odontológicos.

Índice
------

*   [Descrição](#descrição)
*   [Tecnologias Utilizadas](#tecnologias-utilizadas)
*   [Pré-requisitos](#pré-requisitos)
*   [Configuração](#configuração)
*   [Execução](#execução)
*   [Documentação da API](#documentação-da-api)
*   [Contribuidores](#contribuidores)
*   [Frontend](#frontend)
*   [Licença](#licença)

Descrição
---------

Esta API REST permite a gestão de um consultório dentário, oferecendo funcionalidades como:

*   Cadastro e gerenciamento de pacientes.
*   Agendamento de consultas.
*   Registro de tratamentos odontológicos.

Tecnologias Utilizadas
----------------------

*   **Java 17**
*   **Spring Boot**
*   **MyBatis**
*   **PostgreSQL**
*   **Maven**

Pré-requisitos
--------------

Antes de começar, você precisará ter o seguinte instalado em sua máquina:

*   **Java JDK 17+**
*   **Maven**
*   **PostgreSQL**

Configuração
------------

Crie um banco de dados PostgreSQL para a aplicação:

    CREATE DATABASE consultorio_odontologico;
        

Configure as credenciais do banco de dados em `src/main/resources/application.properties`:

    spring.datasource.url=jdbc:postgresql://localhost:5432/consultorio_odontologico
    spring.datasource.username=seu-usuario
    spring.datasource.password=sua-senha
        

Execução
--------

Para construir e executar a aplicação, utilize o Maven:

    mvn clean install
    mvn spring-boot:run
        

A API estará disponível em `http://localhost:8080`.

Documentação da API
-------------------

A documentação completa da API pode ser acessada através do Swagger UI após iniciar a aplicação:

[Swagger UI - Documentação da API](http://localhost:8080/swagger-ui/index.html#/)

Contribuidores
--------------

Agradecemos aos seguintes contribuidores pelo seu trabalho árduo:

*   [@edertelhado](https://github.com/edertelhado)
*   [@mrfelipefarias](https://github.com/mrfelipefarias)
*   [@Carlos3108](https://github.com/Carlos3108)

Frontend
--------

O link para o repositório do frontend pode ser encontrado [aqui](https://github.com/edertelhado/capyfront).

Licença
-------

Este projeto está licenciado sob a Licença BSD-3-Clause. Veja o arquivo `LICENSE` para mais detalhes.

* * *

Feito com ❤️ por [Capybara Tech](https://capybaratech.info/ )

Para qualquer dúvida ou suporte, sinta-se à vontade para abrir uma issue ou entrar em contato.
