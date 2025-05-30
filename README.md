# 💈 BarberBross

Sistema de agendamento online para barbearias, feito com Java + Spring Boot no backend.

## ✂️ Funcionalidades

- Cadastro de barbearias com endereço e horários de funcionamento  
- Registro de barbeiros e serviços oferecidos por cada barbearia  
- Agendamento e cancelamento de horários com verificação de disponibilidade  
- Validação de relacionamentos (barbeiro/serviço pertencem à barbearia)  
- Suporte a múltiplos dias e horários disponíveis  
- Pronto para expansão futura com geolocalização e busca de barbearias próximas  

## 🧱 Tecnologias

- Java 21
- Spring Boot  
- Spring Data JPA  
- PostgreSQL 
- Lombok  
- DBeaver (gerenciamento do banco)  
- Postman (teste dos endpoints)

## 📦 Como rodar

1. Clone o repositório  
   `git clone https://github.com/rickkruiv/BarberBross.git`

2. Configure o banco no `application.properties`  
3. Rode o projeto com sua IDE ou `./mvnw spring-boot:run`

## 📌 Exemplo de agendamento (JSON)

```json
{
    "data":	"2025-05-02",
    "hora":	"14:30:00",
    "clienteId": 2,
    "barbeiroId": 1,
    "servicoId": 4,
    "barbeariaId": 2
}
```

## 🚀 Próximos passos

- Integração com front usando Angular ou React

- Autenticação de usuários

- Painel administrativo

- Busca por barbearias próximas (geolocalização)

> Projeto em andamento criado por Henrique como parte de estudo e portfólio.

---

## 🔐 [Licença](LICENSE)

> ⚠️ Este projeto está sob a licença [CC BY-NC 4.0](LICENSE).  
> Pode estudar e usar como referência, mas **não pode copiar para uso comercial.**

Leia mais sobre a licença [aqui](https://creativecommons.org/licenses/by-nc/4.0/).
