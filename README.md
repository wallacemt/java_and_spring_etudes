# Java & Spring — Estudos

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=flat&logo=springboot&logoColor=white)
![Status](https://img.shields.io/badge/status-em%20andamento-blue)
![License](https://img.shields.io/badge/license-MIT-lightgrey)

Repositório pessoal de exercícios e desafios para praticar **Java** e, em seguida, **Spring / Spring Boot**. Cada pasta é um exercício independente, organizado por tópico e nível de dificuldade — veja a convenção completa em [`docs/ESTRUTURA.md`](docs/ESTRUTURA.md).

## Estrutura

```
java/
├── 01-fundamentos/        sintaxe, tipos, estruturas de controle
├── 02-poo/                orientação a objetos
└── 03-projetos/           mini-projetos que combinam os fundamentos
spring/                    desafios com Spring / Spring Boot (em breve)
desafios/                  enunciados dos desafios em PDF (sem solução)
docs/                      convenções do repositório e storyboards de aprendizado
```

> Este repositório está em **Modo Yoda** (ver [`CLAUDE.md`](CLAUDE.md)): a IA orienta o
> raciocínio, não escreve a implementação.

## Progresso

### Java — Fundamentos
- [x] Hello World — `java/01-fundamentos/hello-world`
- [x] Sintaxe básica (variáveis, tipos, operadores) — `java/01-fundamentos/sintaxe-basica`
- [x] Estruturas de controle (if/else, for, arrays) — `java/01-fundamentos/estruturas-controle`

### Java — POO
- [x] Classe `Pessoa` com cálculo de IMC — `java/02-poo/pessoa`

### Java — Projetos
- [x] Calculadora de console — `java/03-projetos/calculadora`

### Spring
- [ ] Ainda não iniciado

## Como rodar

Exercícios de Java puro (sem build tool):

```bash
cd java/01-fundamentos/hello-world/src
javac Main.java && java Main
```

Desafios Spring (quando existirem) terão seu próprio `pom.xml`/`build.gradle` e rodam com:

```bash
./mvnw spring-boot:run
```

## Objetivo

Testar e consolidar conhecimento em Java e no ecossistema Spring através de exercícios práticos incrementais, do básico ao avançado.
