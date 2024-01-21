
![Banner](https://github.com/Gabriel1Pinheiro/workshop-SpringBoot-/blob/main/Spring.png)

Este projeto de web services com Spring Boot e JPA, Hibernate foi desenvolvido com o objetivo de implementar um modelo de domínio e estruturar as camadas lógicas: resource, service, repository. Além disso, configura um banco de dados de teste (H2), popula o banco de dados, realiza operações CRUD (Create, Retrieve, Update, Delete) e inclui um tratamento de exceções.
## Tecnologias Utilizadas

Este projeto foi desenvolvido utilizando as seguintes tecnologias:

- **Spring Boot:** Framework de desenvolvimento Java para criação de aplicações robustas e escaláveis.
- **Java Persistence API (JPA):** Especificação Java para gerenciamento de dados em aplicações Java EE.
- **Hibernate:** Framework de mapeamento objeto-relacional (ORM) para Java.
- **Spring Data JPA:** Projeto da Spring que simplifica a implementação de repositórios baseados em JPA.
- **Banco de Dados:** H2 (para desenvolvimento e testes).
- **Spring Web:** Módulo do Spring para desenvolvimento de aplicações web.
- **Outras dependências do Spring:** Spring Web, H2 Database e Spring Data JPA

### Ferramentas de Desenvolvimento

- **IDE:** IntelliJ IDEA
- **Gestão de Dependências:** Maven
- **Controle de Versão:** Git

### Ambiente de Execução

- **Servidor de Aplicação:** Tomcat (incorporado no Spring Boot)
- **Sistema Operacional:** Windows


### Como Executar o Projeto

1. Clone este repositório: `git clone [https://github.com/Gabriel1Pinheiro/workshop-SpringBoot-.git]`
2. Abra o projeto na sua IDE (recomendado: IntelliJ IDEA).
3. Execute a aplicação.
4. Acesse [http://localhost:8080](http://localhost:8080) no seu navegador.




## Estrutura do Projeto

O projeto `workshop-SpringBoot-` segue uma estrutura organizada para facilitar a manutenção e a compreensão do código-fonte. Abaixo está uma explicação mais detalhada da estrutura:

- **`src/main/java/SpringBoot`**: O pacote principal do código-fonte.
  - **`config`**: Contém classes de configuração para o Spring Boot, incluindo configurações relacionadas ao banco de dados, beans personalizados, etc.
  - **`entities`**: Classes que representam as entidades do modelo de domínio da aplicação, utilizadas pelo Hibernate para mapeamento objeto-relacional.
  - **`repositories`**: Interfaces JPA para comunicação com o banco de dados, definindo operações de CRUD para as entidades.
  - **`resources`**: Contém arquivos de recursos, como arquivos de propriedades de configuração, scripts SQL, etc.
  - **`services`**: Implementações dos serviços de negócios da aplicação, responsáveis por lógica de negócios específica.

- **`src/test/java/SpringBoot`**: Diretório para testes unitários e integrados.
  - **`ApplicationTests`**: Classe de teste para a aplicação, contendo testes relacionados à configuração geral e inicialização.

- **`Application.java`**: A classe principal que inicializa a aplicação Spring Boot. Contém o método `main` para iniciar a aplicação.

Foi estruturada dessa  forma para proporcionar uma separação clara de responsabilidades e facilitar a expansão do projeto.

## Licença

[MIT](https://choosealicense.com/licenses/mit/)
