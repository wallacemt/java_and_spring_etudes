# Estruturas de dados e algoritmos

Os exemplos estão separados por tema em `src`. Cada diretório corresponde
ao pacote Java, e as classes auxiliares ficam junto do exemplo que as utiliza.

| Diretório | Conteúdo |
| --- | --- |
| `vetores` | `Vector` e teste de desempenho `VetorLongTest` |
| `listas` | Comparação entre `ArrayList` e `LinkedList` |
| `pilhas` | `StackArray` e balanceamento de parênteses |
| `filas/prioridade` | Fila de tarefas com `PriorityQueue` (`Main` e `Task`) |
| `conjuntos` | Gerenciamento de nomes com `HashSet` |
| `mapas` | Exemplos com `HashMap`, produtos e estoque |
| `buscas/binaria` | Busca binária |
| `buscas/linear` | Busca linear |
| `ordenacao/bubble` | Bubble sort |
| `ordenacao/selection` | Selection sort |
| `ordenacao/merge` | Merge sort |
| `arvores/binaria` | Árvore binária, nós e exemplo de inserção |
| `grafos/dijkstra` | Algoritmo de Dijkstra e exemplo de rotas |

## Executar

Use o **JDK 25**, conforme a configuração do projeto no IntelliJ. Alguns
exemplos utilizam métodos `main` sem `public` ou sem `static`, executáveis
nessa versão do Java.

No IntelliJ, abra o projeto e execute o método `main` da classe desejada.
Se houver uma configuração antiga, recrie-a a partir da classe no novo pacote.

No terminal Bash, a partir desta pasta:

```bash
mkdir -p out/classes
find src -name '*.java' -print > out/sources.txt
javac -encoding UTF-8 -d out/classes @out/sources.txt
java -cp out/classes filas.prioridade.Main
```

Troque `filas.prioridade.Main` pela classe desejada, por exemplo
`pilhas.ParenthesesBalancer`, `ordenacao.merge.MergeSort` ou
`arvores.binaria.TestTree`. `conjuntos.NameMenagement` abre uma interface Swing;
`mapas.StorageManagement` e `grafos.dijkstra.TestDijkstra` recebem dados pelo terminal.

 