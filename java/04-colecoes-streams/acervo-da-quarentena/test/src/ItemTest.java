import entities.Movie;
import entities.MusicalScore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Conservation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ItemTest {

    @Test
    @DisplayName("Items com mesmo codigo devem ser considerado iguais.")
    void itemsComMesmoCodigoSaoIguais() {
        MusicalScore item1 = new MusicalScore("C-001", "Prelúdio em Sol",
                1717, Conservation.INTACT, "J. S. Bach", 4, 42, 60);
        Movie item2 = new Movie("C-001", "Curtis e Viper 2", 2013,
                Conservation.INTACT, "dir. desconhecido", 118.0);

        assertEquals(item1, item2);
    }

    @Test
    @DisplayName("Items com dados nao iguais devem ser considerados diferentes.")
    void itemsComCodigoDiferenteNaoSaoIguais() {
        MusicalScore item1 = new MusicalScore("C-001", "Prelúdio em Sol",
                1717, Conservation.INTACT, "J. S. Bach", 4, 42, 60);
        Movie item2 = new Movie("C-002", "Curtis e Viper 2", 2013,
                Conservation.INTACT, "dir. desconhecido", 118.0);

        assertNotEquals(item1, item2);
    }

    @Test
    @DisplayName("Items iguais tem o mesmo hashCode.")
    void itemsComCodigosIguaisTemMesmoHashCode() {
        MusicalScore item1 = new MusicalScore("C-001", "Prelúdio em Sol",
                1717, Conservation.INTACT, "J. S. Bach", 4, 42, 60);
        Movie item2 = new Movie("C-001", "Curtis e Viper 2", 2013,
                Conservation.INTACT, "dir. desconhecido", 118.0);

        assertEquals(item1.hashCode(), item2.hashCode());
    }


}
