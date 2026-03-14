# E-Bank — Application Bancaire avec Chatbot IA

Application bancaire full-stack basée sur une architecture microservices, intégrant un chatbot IA via Spring AI et le protocole MCP (Model Context Protocol), avec un frontend Angular.

---

## Architecture des microservices

| Service | Port | Description |
|---|---|---|
| `discovery-service` | 8761 | Serveur Eureka — registre et découverte des services |
| `gateway` | 9999 | API Gateway Spring Cloud — point d'entrée unique |
| `customer-service` | 8056 | Gestion des clients (CRUD) + outils MCP exposés |
| `ebank-service` | 8057 | Gestion des comptes bancaires |
| `ebank-chat` | 8058 | Chatbot IA — interaction avec Ollama via Spring AI |
| `ebank-app-fronted` | 4200 | Frontend Angular |

---

## Stack technique

**Backend**
- Java 21 + Spring Boot 3
- Spring Cloud (Eureka, Gateway)
- Spring AI + MCP (Model Context Protocol)
- Ollama (modèle LLM local)
- Spring Data JPA + H2 / PostgreSQL

**Frontend**
- Angular 19
- Bootstrap 5
- Signals & httpResource (Angular moderne)

**Monitoring**
- Micrometer + Prometheus
- Grafana

---

## Fonctionnalités

- Liste et gestion des clients
- Liste des comptes bancaires
- Chatbot IA bancaire (questions/réponses en langage naturel)
- Animation de chargement dans l'interface de chat
- Monitoring des métriques via Prometheus/Grafana

---

## Lancer le projet en local

### Prérequis
- Java 21
- Node.js 20+ / npm
- Maven
- Ollama installé et lancé (`ollama serve`)

### Ordre de démarrage

```bash
# 1. Discovery Service
cd discovery-service && mvn spring-boot:run

# 2. Gateway
cd gateway && mvn spring-boot:run

# 3. Customer Service
cd customer-service && mvn spring-boot:run

# 4. Ebank Service
cd ebank-service && mvn spring-boot:run

# 5. Chatbot
cd ebank-chat && mvn spring-boot:run

# 6. Frontend Angular
cd ebank-app-fronted && npm install && ng serve
```

### Monitoring (optionnel)

```bash
cd customer-service
docker-compose up -d
```

- Prometheus : http://localhost:9090
- Grafana : http://localhost:3000 (admin / admin)

### Accès

- Frontend : http://localhost:4200
- API Gateway : http://localhost:9999
- Eureka Dashboard : http://localhost:8761

---

## Structure du projet

```
ebank-ms-app/
├── customer-service/       # Microservice clients + MCP
├── ebank-service/          # Microservice comptes
├── ebank-chat/             # Chatbot IA Spring AI
├── gateway/                # API Gateway
├── discovery-service/      # Eureka Server
└── ebank-app-fronted/      # Frontend Angular
```
