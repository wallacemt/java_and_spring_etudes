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