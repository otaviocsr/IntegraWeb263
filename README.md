# IntegraWeb263

Aplicação de livraria com frontend em Angular e API REST em Spring Boot.
O frontend permite cadastrar livros e envia os dados para o backend em
`http://localhost:8080`.

## Estrutura

```text
Backend/livraria   API Spring Boot, JPA e banco H2
Frontend/livraria  Aplicação Angular
```

## Pré-requisitos

- Java 21 ou superior
- Node.js e npm

## Executar o projeto

Abra dois terminais na raiz do repositório.

### Backend

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

## Banco de dados

O projeto usa H2 em memória. Os dados ficam disponíveis apenas enquanto o
backend estiver em execução e são recriados quando a aplicação reinicia.

Console do H2: `http://localhost:8080/h2-console`

- JDBC URL: `jdbc:h2:mem:livraria`
- Usuário: `sa`
- Senha: vazia

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
