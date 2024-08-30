# 🍽️ CardapiosMktplaceApi

![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-336791?style=for-the-badge&logo=postgresql&logoColor=white)

**CardapiosMktplaceApi** é uma API desenvolvida em Java com Spring para o backend e utiliza PostgreSQL como banco de dados. A API é projetada para gerenciar cardápios em um marketplace, permitindo a integração com outras aplicações.

---

## 📚 Descrição

O **CardapiosMktplaceApi** fornece uma API para o gerenciamento de cardápios em um marketplace. As principais funcionalidades incluem:

- **CRUD de Cardápios**: Criar, ler, atualizar e excluir cardápios.
- **Gerenciamento de Itens de Cardápio**: Adicionar, editar e remover itens dos cardápios.
- **Listagem de Cardápios**: Obter uma lista de todos os cardápios disponíveis.

---

## 🚀 Como Executar

Para executar a API **CardapiosMktplaceApi** em sua máquina, siga os passos abaixo:

1. **Clone o repositório:**

    ```bash
    git clone https://github.com/SeuUsuario/CardapiosMktplaceApi.git
    cd CardapiosMktplaceApi
    ```

2. **Configure o banco de dados PostgreSQL:**

    Certifique-se de que o PostgreSQL esteja instalado e configurado. Crie um banco de dados para a aplicação e atualize o arquivo `application.properties` com as informações do seu banco de dados.

3. **Instale as dependências e inicie a aplicação:**

    ```bash
    ./mvnw spring-boot:run
    ```

4. **Testar a API:**

    Após iniciar a aplicação, você pode testar a API usando ferramentas como Postman ou cURL. A API estará disponível em `http://localhost:8080`.

---

## 🧩 Funcionalidades

- **Endpoints RESTful**: API com endpoints para gerenciamento de cardápios e itens.
- **Banco de Dados PostgreSQL**: Armazenamento persistente dos dados de cardápios e itens.
