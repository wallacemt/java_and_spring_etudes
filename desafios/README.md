# Desafios

Enunciados dos desafios propostos pelo Mestre Yoda. **Aqui não mora solução** —
o código do aluno vai para `java/` (ou `spring/`), na pasta indicada no
cabeçalho de cada enunciado.

## Convenção

```
NN-nome-do-desafio.pdf      # entregável final — leia este
src/NN-nome-do-desafio.html # fonte, para reedição
```

- `NN`: ordem de proposição (01, 02, ...), em `kebab-case`, como em
  `docs/ESTRUTURA.md`.
- O PDF é gerado a partir do HTML com Chrome headless:

```bash
google-chrome --headless --disable-gpu --no-sandbox \
  --print-to-pdf=desafios/NN-nome.pdf desafios/src/NN-nome.html
```

## Índice

| # | Desafio | Nível | Solução em |
|---|---------|-------|-----------|
| 01 | [Acervo da Quarentena](01-acervo-da-quarentena.pdf) | Difícil | `java/04-colecoes-streams/acervo-da-quarentena/` |
