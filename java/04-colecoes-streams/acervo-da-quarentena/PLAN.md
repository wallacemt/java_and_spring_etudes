1.  O problema, com suas palavras:
    - O problema consiste em organizar um acervo de com medias variadas, e algumas dessas medias possuem avarias, e alem disso e necessario, calcular o tempo das medias para serem reproduzidas durantes as secoes, pois como e uma quarentena, os recursos sao limitados e nao podem utilizar em exesso.
---
2.  Seu desenho.
    - O que pensei foi em criar uma classe abstrata que no cenario do desafio se encaixa melhor, pois os itens compartilham atributos em comum.
       - Desenho:
        ```
        ┌──────────────────────────────────┐
        │   Item (classe abstrata)         │
        ├──────────────────────────────────┤
        │ - code: String                   │
        │ - title: String                  │
        │ - year: int                      │
        │ - conservation: Conservation     │
        ├──────────────────────────────────┤
        │ + getDuration(): double          │ ← abstrato
        │ + describe(): String             │ ← abstrato
        │ + equals(), hashCode()           │
        └──────────────────────────────────┘
        △       △            △
        │       │            │
        ┌────┴──┐         ┌──┴────┐ ┌──┴────┐
        │       │ │       ││      │
        ┌───┴────┐│       ┌──────┴─┐ ┌────┴───┐
        │MusicalScore│    │ Movie  │ │ Serie  │
        ├────────┤│ │     ├────────┤ ├────────┤
        │-compositor││ │  │-diretor│ │-eps/tmp│
        │-dif.   ││ │     │-duracao│ │-dur.ep │
        │-compass││ │     └────────┘ └────────┘
        │-bpm    ││ │
        └────────┘│ │
        └─┘
        ```

---
3.  Suas estruturas de dados.
    - Irei utilizar HashMap<String, Item>
    - Porque:  ela faz busca por chave em O(1) que fica mais simples ao se adicionar searchByCode().
    - Motivo da escolha: Operacoes mais frequentes no acervo e a searchByCodfe, e se utilizase o ArrayList seria um O(n) varrendo tudo, e com o HadhMap fica mais direto e custo de memoria reduzido. 
    - Trade-ofs: ArrayList(Simples, mas busca lenta), HashSet(nao permite busca por chave, pois so verifica a presença),TreeMap(busca mais lenta que hashmap, e alem disso a ordem e indiferente.)

---
4. Exceções checked vs. unchecked.
    - `DuplicatedItemException` e `NotFoundItemException` são unchecked porque representam violações das regras de uso do acervo, não falhas externas das quais todo chamador seja obrigado a se recuperar.
    - Estender `RuntimeException` mantém a API simples: quem puder tratar a situação pode capturá-la, como o `Main` já faz, mas não é necessário propagar `throws` por todas as chamadas.
    - Exceções checked seriam mais adequadas se a recuperação fosse obrigatória para todo chamador, por exemplo diante de uma falha de arquivo ou rede. Esse não é o caso deste projeto em memória.

---
5. Avisos do `javac -Xlint:all`.
    - `[this-escape]` em `Item`: não era aceitável manter um método público e sobrescrevível sendo chamado pelo construtor. `validateCode` foi tornado privado, pois só é usado internamente, impedindo despacho para uma subclasse ainda não inicializada.
    - `[serial]` em `DuplicatedItemException`: corrigido com `serialVersionUID = 1L`, identificando explicitamente a versão serializada da exceção.
    - `[serial]` em `NotFoundItemException`: corrigido da mesma forma, pelo mesmo motivo.
    - `[deprecation]` em `Main`: o construtor obsoleto `new Locale("pt", "BR")` foi substituído por `Locale.forLanguageTag("pt-BR")`, preservando a localidade sem usar API descontinuada.
    - Resultado: `src` e `test/src` compilam sem avisos com `javac -Xlint:all`.
