# Estrutura do repositório

Este repositório guarda exercícios e desafios de estudo de **Java** e **Spring**, organizados por tópico e nível, não por data.

## Árvore de diretórios

```
.
├── java/                       # Java puro (sem framework)
│   ├── 01-fundamentos/         # sintaxe, tipos, estruturas de controle
│   ├── 02-poo/                 # orientação a objetos
│   ├── 03-projetos/            # mini-projetos que combinam os fundamentos
│   └── 04-colecoes-streams/    # List/Map/Set, Stream API, Optional...
├── spring/                     # Desafios com Spring / Spring Boot
│   ├── 01-web-rest/            # controllers, REST, validação
│   ├── 02-persistencia/        # JPA, Spring Data, transações
│   └── 03-seguranca/           # Spring Security, JWT, OAuth2
└── docs/
    └── ESTRUTURA.md            # este arquivo
```

Categorias novas (ex.: `05-concorrencia`, `04-testes`) são criadas sob demanda — não crie pastas vazias "para o futuro".

## Convenção de cada desafio

Cada desafio é uma pasta própria dentro da categoria, em `kebab-case`, descrevendo o que ele exercita (não o nome do arquivo Java):

```
java/02-poo/pessoa/
└── src/
    └── Pessoa.java
```

- Um desafio = uma pasta, com o código-fonte em `src/`.
- Sem `.class` nem `out/`/`target/` versionados — o `.gitignore` da raiz já cobre isso.
- Projetos Java puro (sem Maven/Gradle) podem ter só `src/`. Quando um exercício precisar de dependências (ex.: Spring), ele ganha seu próprio `pom.xml` (ou `build.gradle`) dentro da própria pasta do desafio — cada desafio Spring é um projeto Maven/Gradle independente, não um módulo dentro de um projeto gigante.

## Nomeação

- Pastas de categoria: `NN-nome-da-categoria` (número = ordem didática, não cronológica).
- Pastas de desafio: nome curto do que está sendo praticado, em português ou inglês, mas consistente dentro da mesma categoria.
- Classes Java: `PascalCase` como de costume; pacotes só quando o projeto tiver mais de um arquivo relacionado.

## Como rodar um exercício de Java puro

```bash
cd java/01-fundamentos/hello-world/src
javac Main.java && java Main
```

## Como rodar um desafio Spring (quando existir)

```bash
cd spring/01-web-rest/nome-do-desafio
./mvnw spring-boot:run
```
