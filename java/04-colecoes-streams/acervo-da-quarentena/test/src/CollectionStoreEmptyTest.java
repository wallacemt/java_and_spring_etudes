import entities.CollectionStore;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CollectionStoreEmptyTest {
    static CollectionStore collectionStoreEmptyTest;

    @BeforeAll
    static void setUp() {
        collectionStoreEmptyTest = new CollectionStore();
    }

    @Test
    @DisplayName("Acervo vazio, duracao total deve ser igual a zero")
    void acervoVazioDuracaoTotalRetornaZero() {
        assertEquals(0.0, collectionStoreEmptyTest.getTotalDuration());
    }

    @Test
    @DisplayName("Acervo vazio, ao listar deve estar vazio")
    void acervoVazioAoListarDeveEstaVazio(){
        assertTrue(collectionStoreEmptyTest.listAll().isEmpty());
    }

    @Test
    @DisplayName("Acervo vazio, agrupamento deve estar vazio")
    void acervoVazioAgrupamentoDeveEstaVazio(){
        assertTrue(collectionStoreEmptyTest.groupedByType().isEmpty());
    }


    @Test
    @DisplayName("Acervo vazio, sessao noturna deve estar vazia.")
    void acervoVazioSessaoNoturnaDeveEstaVazio(){
        assertTrue(collectionStoreEmptyTest.nightSession(120).isEmpty());
    }
}
