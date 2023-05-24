# Desafio Spot Sat

Esse é o meu repositório onde vou desenvolver os desafios propostos pela SpoT sat.

**Segue abaixo a descrição dos desafios propostos:**

**DESAFIO BACKEND**

Nós trabalhamos com a criação de soluções que lidam com dados geográficos, como mapeamento de áreas, localização de clientes, entre outros. Para isso, estamos propondo um desafio técnico dividido em várias etapas, cada uma com um nível de dificuldade crescente. O objetivo é avaliar a capacidade de resolver problemas e desenvolver soluções eficientes.

Você deve criar um projeto no github e implementar uma JSON REST API com as especificações abaixo. Cada parte cresce em nível de dificuldade e você não precisa necessariamente desenvolver todas.

**Primeira Parte**

1. GET /v1/

Retorna uma mensagem padrão com status 200 OK. Exemplo de resposta:

{

“message”: “Bem vindo a API GeoPoly!” }

2. POST /v1/auth

Simula uma rota de autenticação (não precisa implementar uma autenticação de verdade). Retorna umas das possíveis respostas dependendo do corpo da requisição.

Exemplo de requisição:

{

“email”: “admin@exemplo.com.br”, “password”: “abcd1234”

}

Exemplo de resposta (200 OK) para caso as credenciais estejam corretas (pode considerar corretas as credenciais acima):

{

“message”: “Autenticado com sucesso!” }

Exemplo de resposta (401 Unauthorized) para caso as credenciais estejam incorretas:

{

“message”: “Falha ao autenticar!” }

Exemplo de resposta (400 Bad Request) para caso o formato do corpo da requisição (nome dos atributos errados e/ou atributos a mais ou a menos) esteja incorreto:

{

“message”: “Formato da requisição inválido!” }

**Segunda Parte**

Os próximos itens do desafio consistem em desenvolver uma API RESTful para gerenciar uma lista de lugares com informações geográficas, como nome, latitude e longitude. A API deve fornecer as seguintes rotas e não precisa de integração com banco de dados neste primeiro momento, você pode deixar a lista de lugares hardcoded.

3. GET /v2/places

Retorna uma lista de lugares com informações geográficas em formato JSON. Exemplo de resposta (lugares em São José dos Campos - SP):

[

{

"id": 1,

"name": "Parque da Cidade", "latitude": -23.221112, "longitude": -45.899678

},

{

"id": 2,

"name": "Praça Ulisses Guimarães", "latitude": -23.180038, "longitude": -45.884357

},

...outros lugares

]

4. GET /v2/places/:id

Retorna um lugar específico da lista acima pelo seu ID em formato JSON. Exemplo de resposta:

{

"id": 1,

"name": "Parque da Cidade", "latitude": -23.221112, "longitude": -45.899678

}

**Terceira Parte**

Refazer as rotas acima em `/v2/places` porém agora persistindo os dados. Esta nova implementação deve estar em `/v3/places`. E incluir essas outras rotas:

5. POST /v3/places

Cria um novo lugar com informações geográficas a partir de um objeto JSON. Exemplo de requisição:

{

"name": "Lago do Vale",

"latitude": -23.200443,

"longitude": -45.896235 }

Exemplo de resposta:

{

"id": 5,

"name": "Lago do Vale", "latitude": -23.200443, "longitude": -45.896235

}

6. PUT /places/:id

Atualiza um lugar específico pelo seu ID a partir de um objeto JSON com as informações a serem atualizadas.

Exemplo de requisição:

{

"name": "Parque da Cidade - São José dos Campos", "latitude": -23.221112,

"longitude": -45.899678

}

Exemplo de resposta:

{

"id": 1,

"name": "Parque da Cidade - São José dos Campos", "latitude": -23.221112,

"longitude": -45.899678

}

7. DELETE /places/:id

Deleta um lugar específico pelo seu ID. Exemplo de resposta:

{

"message": "Lugar removido com sucesso!" }

**Quarta Parte**

Os dois próximos itens envolvem alguns cálculos em cima das coordenadas. Para este desafio você pode usar a fórmula de distância euclidiana para calcular a distância entre os pontos.

distance = sqrt((x1-x2)\*\*2 + (y1-y2)\*\*2)

8. GET /v4/places/:id1/distanceto/:id2 Retorna a distância entre 2 pontos. Exemplo de resposta:

{

“distance”: 1300.00 }

9. GET /v4/search?latitude={latitude}&longitude={longitude}&radius={radius}

Retorna uma lista de lugares e/ou áreas em um raio específico a partir de uma localização central (latitude e longitude) e um raio em metros. Cada lugar deve incluir a distância do ponto central especificado. Exemplo de resposta:

[

{

"id": 1,

"name": "Parque da Cidade", "latitude": -23.221112, "longitude": -45.899678, "distance": 1300.0

}, {

"id": 2,

"name": "Praça Ulisses Guimarães", "latitude": -23.180038, "longitude": -45.884357, "distance": 5000.0

},

{

"id": 3,

"name": "Shopping Center Vale", "latitude": -23.186732, "longitude": -45.884104, "distance": 5600.0

},

...outros lugares

]

**Quinta Parte**

Nesta parte você deve implementar um CRUD completo para lugares (nome + ponto) e áreas (nome + polígono) que deverão ser persistidos em um banco PostgreSQL com a extensão PostGIS. Você deve utilizar o formato GeoJSON e pode usar o site <https://geojson.io/> para gerar e visualizar os polígonos. Além das rotas com operações de listagem, criação, visualização, atualização, e remoção você deve incluir rotas para pesquisar lugares e áreas dentro de um círculo, calcular a distância entre dois lugares (usando a projeção adequada), verificar se um lugar está dentro de uma área e uma última rota para listar lugares dentro de uma área. As rotas devem ser autenticadas usando JWT mas não é necessário criar rotas para criar usuários, recuperação de senhas e outros relacionados apenas deixar um usuário administrador cadastrado no banco de dados e suas credenciais no readme do projeto.

Fique a vontade, leve quanto tempo precisar e pode interromper o desenvolvimento em qualquer uma das partes.

Os seguintes aspectos serão avaliados:

- Facilidade de executar o projeto
- Qualidade do código (clean code, uso de linter etc.)
- Histórico de commits (mensagem claras, commits concisos)
- Testes
- Documentação
