import abstracts.Item;
import entities.CollectionStore;
import entities.Movie;
import entities.MusicalScore;
import entities.Serie;
import exceptions.DuplicatedItemException;
import exceptions.NotFoundItemException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Conservation;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CollectionStoreTest {
    static CollectionStore collectionStoreTest;

    @BeforeAll
    static void setUp() {
        collectionStoreTest = new CollectionStore();
        collectionStoreTest.catalog(
                new MusicalScore("PT-001", "Prelúdio em Sol", 1717, Conservation.INTACT, "J. S. Bach", 4, 42, 60));
        collectionStoreTest.catalog(
                new MusicalScore("PT-002", "Take On Me (arranjo p/ violino)", 1985, Conservation.WORN, "a-ha", 2, 96, 84));
        collectionStoreTest.catalog(
                new MusicalScore("PT-003", "Future Days", 2013, Conservation.ILLEGIBLE, "P. Yorn", 3, 64, 76));
        collectionStoreTest.catalog(
                new Movie("FL-001", "Curtis e Viper 2", 2013, Conservation.INTACT, "dir. desconhecido", 118.0));
        collectionStoreTest.catalog(
                new Serie("SR-001", "Além da Imaginação", 1959, Conservation.DEMAGED, new int[]{36, 29}, 25.0));
    }

    @Test
    @DisplayName("o acervo de exemplo soma 1753,7 min, sem arredondar antes de somar")
    void aoSomarTotalDeDuracaoDoAcervoDeveRetornarValorEsperado() {
        double total = collectionStoreTest.getTotalDuration();
        assertEquals(1753.7, total, 0.1);
    }


    @Test
    @DisplayName("Retornar a exceção ao adicionar codigo duplicado, e item original mantem no catalogo")
    void aoAdicionarCodigoExistenteLancaExcecaoECodigoOriginalEMantido() {
        assertThrows(DuplicatedItemException.class, () -> collectionStoreTest.catalog(new MusicalScore("PT-001", "Concert A Minor",
                1820, Conservation.INTACT, "A. Vivaldi", 2, 60, 120)));

        Item searchItem = collectionStoreTest.search("PT-001");
        assertEquals("Prelúdio em Sol", searchItem.getTitle());
    }


    @Test
    @DisplayName("Retornar Exceção de 'not-found' ao buscar item inexistente")
    void aoBuscarUmItemInexistenteRetornarExcecao() {
        assertThrows(NotFoundItemException.class, () -> collectionStoreTest.search("PT-0000"));
    }

    @Test
    @DisplayName("Verificar Exceção ao tentar fazer clear, e verificar se o acervo mantem os dados apos esvaziar.")
    void aoRodarClearLancaExecaoEAoVerificarOsDadosNaoSaoRemovidos() {
        CollectionStore itemsIsolado = new CollectionStore();
        itemsIsolado.catalog(new MusicalScore("PT-023", "Preludium e Allegro", 1920, Conservation.INTACT,
                "Kraisler", 5, 50, 120));

        List<Item> itemsCaptura = itemsIsolado.listAll();

        assertThrows(UnsupportedOperationException.class, () -> itemsCaptura.clear());


        itemsIsolado.catalog(new MusicalScore("PT-033", "Concert G Minor", 1782, Conservation.INTACT,
                "A. Vivaldi", 3, 60, 120));

        assertEquals(1, itemsCaptura.size());
    }

    @Test
    @DisplayName("Na sessao noturna com tempo de 120 retorna apenas um item")
    void aoConsultarSessaoNoturnaCom120MinRetornaUmItem() {
        List<Item> itemsSessaoNoturna = collectionStoreTest.nightSession(120);
        assertEquals(List.of(
                        new Movie("FL-001", "Curtis e Viper 2", 2013, Conservation.INTACT, "dir. desconhecido", 118.0)),
                itemsSessaoNoturna);
    }

    @Test
    @DisplayName("Na sessao noturna com tempo de 130 retorna  3 items")
    void aoConsultarSessaoNoturnaCom130RetornaTresItems() {
        List<Item> itemsSessaoNoturna = collectionStoreTest.nightSession(130);
        assertEquals(List.of(
                        new Movie("FL-001", "Curtis e Viper 2", 2013, Conservation.INTACT, "dir. desconhecido", 118.0),
                        new MusicalScore("PT-002", "Take On Me (arranjo p/ violino)", 1985, Conservation.WORN, "a-ha", 2, 96, 84),
                        new MusicalScore("PT-001", "Prelúdio em Sol", 1717, Conservation.INTACT, "J. S. Bach", 4, 42, 60)),
                itemsSessaoNoturna);
    }

    @Test
    @DisplayName("Em sessao noturna items Inelegivel nunca entra na lista")
    void naSessaoNoturnaItemInelegivelNaoEntraNaFila() {
        List<Item> itemsSessaoNoturnaUmItem = collectionStoreTest.nightSession(120);
        List<Item> itemsSessaoNoturnaTresItems = collectionStoreTest.nightSession(130);
        Item inellegibleItem = new MusicalScore("PT-003", "Future Days", 2013, Conservation.ILLEGIBLE, "P. Yorn", 3, 64, 76);

        assertNotEquals(List.of(inellegibleItem), itemsSessaoNoturnaUmItem);
        assertNotEquals(List.of(inellegibleItem), itemsSessaoNoturnaTresItems);
    }


    @Test
    @DisplayName("Sessao com tempo negativo lança error")
    void naSessaoNoturnaMinutoNegativoLancaError() {
        assertThrows(IllegalArgumentException.class, () -> collectionStoreTest.nightSession(-20));
    }

    @Test
    @DisplayName("Sessao com minuto zerado, nao retorna nenhum item")
    void naSessaoNoturnaComMinutoSendoZeroNaoRetornaNenhumItem() {
        List<Item> sessaoNoturna = collectionStoreTest.nightSession(0);
        assertTrue(sessaoNoturna.isEmpty());
    }

}
