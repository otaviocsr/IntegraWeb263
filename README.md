# IntegraWeb263

Aplicação de livraria com frontend em Angular e API REST em Spring Boot.
O frontend permite cadastrar livros e envia os dados para o backend em
`http://localhost:8080`.

## Estrutura

```text
Backend/livraria   API Spring Boot, MongoDB e Spring Data
Frontend/livraria  Aplicação Angular
```

## Pré-requisitos

- Java 21 ou superior
- Node.js e npm
- MongoDB 8 ou Docker Desktop

## Executar o projeto

Abra dois terminais na raiz do repositório.

### MongoDB

Com Docker Desktop em execução, suba o banco na raiz do projeto:

```bash
docker compose up -d mongodb
```

O banco será criado em `mongodb://localhost:27017/livraria`, com os dados
persistidos no volume `livraria-mongodb-data`.

### Backend

O MongoDB precisa estar disponível antes de iniciar a API.

```bash
cd Backend/livraria
./mvnw spring-boot:run
```

A API ficará disponível em `http://localhost:8080`.

### Frontend

```bash
cd Frontend/livraria
npm install
npm start
```

A aplicação Angular ficará disponível em `http://localhost:4200`.

## API de livros

| Método | Endpoint | Descrição |
| --- | --- | --- |
| `GET` | `/api/livros` | Lista os livros |
| `GET` | `/api/livros/{id}` | Busca um livro |
| `POST` | `/api/livros` | Cadastra um livro |
| `PUT` | `/api/livros/{id}` | Atualiza um livro |
| `DELETE` | `/api/livros/{id}` | Remove um livro |

Exemplo de cadastro:

```json
{
	"titulo": "O cortiço",
	"autor": "Aluísio Azevedo",
	"genero": "Romance",
	"sinopse": "Uma obra brasileira.",
	"anoPublicacao": 1890,
	"quantidadePaginas": 320
}
```

## API de autores

| Método | Endpoint | Descrição |
| --- | --- | --- |
| `GET` | `/api/autores` | Lista os autores |
| `GET` | `/api/autores/{id}` | Busca um autor |
| `POST` | `/api/autores` | Cadastra um autor |
| `PUT` | `/api/autores/{id}` | Atualiza um autor |
| `DELETE` | `/api/autores/{id}` | Remove um autor |

## Banco de dados

O backend usa MongoDB e lê a conexão pela variável `MONGODB_URI`. Sem essa
variável, utiliza o MongoDB local padrão:

```text
mongodb://localhost:27017/livraria
```

Para usar MongoDB Atlas ou outro servidor, defina a URI antes de iniciar o
backend:

```bash
export MONGODB_URI="mongodb+srv://usuario:senha@cluster.mongodb.net/livraria"
./mvnw spring-boot:run
```

As coleções usadas pela aplicação são `livros` e `autores`.

Não versione credenciais no código. Para MongoDB Atlas, mantenha a senha em
uma variável de ambiente ou em um gerenciador de segredos.

## Testes e build

Backend:

```bash
cd Backend/livraria
./mvnw test
```

Frontend:

```bash
cd Frontend/livraria
npm run build
```
