import entities.CollectionStore;
import entities.Movie;
import entities.MusicalScore;
import entities.Serie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Conservation;

import static org.junit.jupiter.api.Assertions.*;


public class CollectionStoreTest {
    static CollectionStore collectionStoreTest;

    @BeforeAll
    static void setUp() {
        collectionStoreTest = new CollectionStore();
        collectionStoreTest.catalog(new MusicalScore("PT-001", "Prelúdio em Sol",
                1717, Conservation.INTACT, "J. S. Bach", 4, 42, 60));
        collectionStoreTest.catalog(new MusicalScore("PT-002", "Take On Me (arranjo p/ violino)", 1985,
                Conservation.WORN, "a-ha", 2, 96, 84));
        collectionStoreTest.catalog(new MusicalScore("PT-003", "Future Days", 2013,
                Conservation.ILLEGIBLE, "P. Yorn", 3, 64, 76));
        collectionStoreTest.catalog(new Movie("FL-001", "Curtis e Viper 2", 2013,
                Conservation.INTACT, "dir. desconhecido", 118.0));
        collectionStoreTest.catalog(new Serie("SR-001", "Além da Imaginação", 1959,
                Conservation.DEMAGED, new int[]{36, 29}, 25.0));
    }

    @Test
    @DisplayName("o acervo de exemplo soma 1753,7 min, sem arredondar antes de somar")
    void aoSomarTotalDeDuracaoDoAcervoDeveRetornarValorEsperado() {
        double total = collectionStoreTest.getTotalDuration();
        assertEquals(1753.7, total, 0.1);
    }





}
