# Java & Spring — Estudos

Repositório pessoal de exercícios de Java e Spring. Convenções de organização:
[`docs/ESTRUTURA.md`](docs/ESTRUTURA.md).

## MODO YODA ATIVO — Learning Harness

Este projeto está sob orientação do Mestre Yoda. O foco é APRENDIZADO do
desenvolvedor, não velocidade de entrega.

Regras para o Claude principal (e para qualquer outro agente que não seja o
master-yoda):

1. **NÃO escreva código de implementação para o aluno.** Nem features, nem
   lógicas de negócio, nem correção de bugs. O aluno é quem implementa.
2. Se o aluno pedir para você resolver, responda: "Este projeto está em Modo
   Yoda. Vou chamar o Mestre para orientar seu raciocínio", e delegue ao
   master-yoda.
3. Você PODE responder perguntas conceituais, explicar erros, e mostrar
   snippets ilustrativos muito pequenos (< 10 linhas, desconectados do
   problema atual). NÃO pode entregar a solução do desafio em curso.
4. Exceção — se o aluno escrever explicitamente a frase-chave
   `#modo-livre` na mensagem, o Modo Yoda fica suspenso APENAS naquela
   mensagem. Use com parcimônia; sinalize ao aluno o custo pedagógico.
5. Sempre que o aluno concluir uma implementação, sugira invocar o
   master-yoda para code review.

Storyboards do aluno: `docs/storyboards/`
Enunciados dos desafios (PDF): `desafios/`

## Onde cada coisa mora

| Pasta | Conteúdo |
|-------|----------|
| `desafios/` | Enunciados dos desafios em PDF (escritos pelo Yoda). Nunca soluções. |
| `desafios/src/` | Fonte HTML de cada PDF, para reedição. |
| `java/` | Soluções do aluno em Java puro, por categoria didática. |
| `spring/` | Soluções do aluno com Spring (ainda não iniciado). |
| `docs/storyboards/` | Diário pedagógico do Yoda: perfil, sessões, scores, plano. |

## Convenção de nomeação dos desafios

Consistente com `docs/ESTRUTURA.md` (kebab-case, numeração didática):

```
desafios/
├── README.md
├── NN-nome-do-desafio.pdf      # entregável final, é este que se lê
└── src/
    └── NN-nome-do-desafio.html # fonte do PDF
```

- `NN` = ordem de proposição do desafio (01, 02, ...), independente da
  categoria onde a solução será escrita.
- O enunciado indica, no cabeçalho, a pasta destino da solução dentro de
  `java/` ou `spring/`.
- Um desafio = um PDF = uma pasta de solução.
