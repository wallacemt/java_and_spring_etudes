 
1. Ao remover o `.filter(item -> item.getConservation() != Conservation.ILLEGIBLE) do nightSession()` o `teste do aoConsultarSessaoNoturnaCom130RetornaTresItems` quebra.

2. Em `CollectionStore` ao remover o reversed do `Comparator` o error e capturado nas consultas das sessoes noturnas.

3. Em `Movie` Ao trocar o validarDuration pra == 0 o erro e capturado em `MovieTest` em `rejeitaConstrutorMovieDuracaoNegativa`