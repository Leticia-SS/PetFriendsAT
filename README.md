# PetFriends - Sistema de Pedidos com Microsserviços

Aplicação acadêmica desenvolvida com Spring Boot e Apache Kafka, simulando um fluxo de pedidos em um sistema de e-commerce para pets. A comunicação entre os serviços é assíncrona via eventos Kafka.

---

## Arquitetura

```
[Cliente] → POST /pedidos
               ↓
       pedidos-service (8081)
               ↓ publica evento
       [Kafka] tópico: pedido-enviado-almoxarifado
               ↓ consome evento
    almoxarifado-service (8082)
               ↓ publica evento
       [Kafka] tópico: pedido-despachado-transporte
               ↓ consome evento (em desenvolvimento)
      transporte-service (8083)
```

---

## Serviços

### pedidos-service (porta 8081)
Responsável por receber pedidos via API REST e publicar eventos para o almoxarifado.

- **POST /pedidos** — cria um pedido e publica o evento `pedido-enviado-almoxarifado`
- Banco: H2 em memória (`pedidosdb`)
- Produz para o tópico: `pedido-enviado-almoxarifado`

**Exemplo de requisição:**
```json
POST http://localhost:8081/pedidos
{
  "produtoId": 101,
  "quantidade": 5
}
```

### almoxarifado-service (porta 8082)
Responsável por reservar e separar itens do estoque ao receber um pedido.

- Consome o tópico: `pedido-enviado-almoxarifado`
- Cria uma `ReservaEstoque` com status `RESERVADO`, separa os itens (status `SEPARADO`) e publica para o transporte
- Banco: H2 em memória (`almoxarifadodb`)
- Produz para o tópico: `pedido-despachado-transporte`

### transporte-service (porta 8083)
Responsável por criar ordens de transporte ao receber pedidos despachados.

- Consome o tópico: `pedido-despachado-transporte` 
- Banco: H2 em memória (`transportedb`)

---

## Infraestrutura

O Kafka e o Kafka UI ficam no `docker-compose.yml` dentro do `pedidos-service`.

### Subir a infraestrutura
```bash
cd pedidos-service
docker compose up
```

- **Kafka** — `localhost:9092`
- **Kafka UI** — `http://localhost:8084`

### Rodar os serviços
Cada serviço é rodado individualmente pelo IntelliJ ou via:
```bash
./mvnw spring-boot:run
```

---

## Tópicos Kafka

| Tópico | Produtor | Consumidor |
|---|---|---|
| `pedido-enviado-almoxarifado` | pedidos-service | almoxarifado-service |
| `pedido-despachado-transporte` | almoxarifado-service | transporte-service *(em desenvolvimento)* |

---

## Observações

- Os bancos H2 são em memória — os dados são perdidos ao reiniciar os serviços
- O `auto-offset-reset: earliest` garante que mensagens publicadas antes do consumer subir sejam reprocessadas
- A configuração do consumer Kafka no almoxarifado é feita via `KafkaConsumerConfig` por limitações do Spring Boot 4.x com auto-configuração do `JsonDeserializer`
