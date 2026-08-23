import entities.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Conservation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MovieTest {
    @Test
    @DisplayName("a duração informada deve ser a duração devolvida")
    void duracaoInformadaDuracaoRecebida() {
        Movie movieTest = new Movie("FL-001", "Curtis e Viper 2", 2013,
                Conservation.INTACT, "dir. desconhecido", 118.0);
        assertEquals(118, movieTest.getDuration());
    }

    @Test
    @DisplayName("Deve rejeitar construtor  Movie  Duracao Negativa")
    void rejeitaConstrutorMovieDuracaoNegativa() {
        assertThrows(IllegalArgumentException.class, () -> new Movie("FL-001", "Curtis e Viper 2", 2013,
                Conservation.INTACT, "dir. desconhecido", -120));
    }
}
