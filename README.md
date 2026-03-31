# 💳 Payment Manager API

API de gerenciamento de pagamentos inspirada em transações do tipo Pix, desenvolvida com foco em **arquitetura hexagonal**, boas práticas de backend e preparação para ambientes cloud.

---

## 🚀 Tecnologias utilizadas

* Java 17
* Spring Boot
* Project Lombok
* Maven
* Arquitetura Hexagonal (Ports & Adapters)

---

## 🧠 Arquitetura

O projeto segue o padrão **Hexagonal Architecture (Ports and Adapters)**:

```
src/main/java/com/example/demo

├── domain         # Regras de negócio
│   ├── model
│   └── port
│
├── application    # Casos de uso
│   └── usecase
│
├── adapters       # Entrada e saída
│   ├── inbound    # Controllers (API REST)
│   └── outbound   # Repositórios
│
└── infrastructure # Configuração do Spring
```

---

## ⚙️ Como rodar o projeto localmente

### ✅ Pré-requisitos

Antes de começar, você precisa ter instalado:

* Java 17
* IntelliJ IDEA (ou outra IDE)
* Maven (ou usar o wrapper `mvnw`)

---

### 📥 Clonar o repositório

```bash
git clone https://github.com/raissamlima/gerenciadordegastos.git
```

---

### ▶️ Rodar a aplicação

Você pode rodar de duas formas:

#### 🔹 Pela IDE (recomendado)

1. Abra o projeto no IntelliJ
2. Localize a classe:

```
DemoApplication.java
```

3. Clique em ▶️ (Run)

---

#### 🔹 Pelo terminal

```bash
./mvnw spring-boot:run
```

(Windows)

```bash
mvnw.cmd spring-boot:run
```

---

### 🌐 A aplicação estará disponível em:

```
http://localhost:8080
```

---

## 🧪 Testando a API

### 📌 Endpoint de transferência

```
POST /payments/transfer
```

---

### 📥 Exemplo de requisição

```json
{
  "senderId": "1",
  "receiverId": "2",
  "amount": 100,
  "description": "pagamento almoço"
}
```

---

### 📤 Exemplo de resposta

```json
{
  "transactionId": "uuid",
  "status": "SUCCESS",
  "amount": 100,
  "senderName": "Raissa Martins",
  "senderCpf": "123.456.789-00",
  "receiverName": "João Silva",
  "receiverCpf": "987.654.321-00",
  "timestamp": "2026-03-30T22:00:00"
}
```

---

### 🛠 Ferramentas para teste

Você pode testar usando:

* Postman
* Insomnia
* ou arquivo `.http` no IntelliJ

---

## 🧩 Funcionalidades

* Transferência entre usuários
* Validação de saldo
* Simulação de transações financeiras
* Estrutura pronta para integração com banco

---

## ⚠️ Observações

* Os dados estão sendo armazenados em memória (InMemory)
* Não há persistência em banco ainda
* CPF e dados pessoais são fictícios

---

## 🚀 Próximos passos

* [ ] Integração com banco de dados (PostgreSQL)
* [ ] Uso de JPA/Hibernate
* [ ] Deploy em Amazon Web Services (ECS)
* [ ] Infraestrutura com Terraform
* [ ] Observabilidade com Datadog

---

## 💡 Objetivo do projeto

Este projeto foi desenvolvido com foco em:

* Evolução técnica em backend Java
* Aplicação de arquitetura limpa
* Preparação para sistemas distribuídos
* Simulação de cenário real de pagamentos

---

## 👩‍💻 Autores

Desenvolvido por **Raissa Martins Lima e Lucas Martins Caetano** 🚀

---
