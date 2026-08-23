import entities.Serie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Conservation;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SerieTest {

    private static Serie serie;

    @BeforeAll
    static void setUp() {
        serie =  new Serie("SR-001", "Além da Imaginação", 1959,
                Conservation.DEMAGED, new int[]{36, 29}, 25.0);
    }

    @Test
    @DisplayName("temporadas [36, 29] a 25 min/ep dão 1625,0 min")
    void temporadasComValoresEspecificosRetornaValorEsperado(){
        assertEquals(1625, serie.getDuration(), 0.01);
    }

    @Test
    @DisplayName("Deve rejeitar construtor  Serie  Array de  Episodios Vazio")
    void rejeitaConstrutorSerieArrayDeEpisodiosVazios() {
        assertThrows(IllegalArgumentException.class, () -> new Serie("SR-001", "Além da Imaginação", 1959,
                Conservation.DEMAGED, new int[]{}, 25.0));
    }
}
