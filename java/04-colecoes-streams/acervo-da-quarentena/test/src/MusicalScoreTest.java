import entities.MusicalScore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Conservation;

import static org.junit.jupiter.api.Assertions.*;


public class MusicalScoreTest {
    @Test
    @DisplayName("Se compasso e 42 e bpm 60 retorno deve ser 2.8")
    void validaSeCompassoEBpmValoresFixosIgualRetornoEsperado() {
        MusicalScore musicalScoreTest = new MusicalScore("PT-001", "Prelúdio em Sol",
                1717, Conservation.INTACT, "J. S. Bach", 4, 42, 60);
        double d = musicalScoreTest.getDuration();
        assertEquals(2.8, d, 0.01);
    }

    @Test
    @DisplayName("Se compaso 96 e bpm 84 duracao deve ter ~4,571 min ")
    void validaSeCompassoEBpmValoresFixosRetornoComCasaDecimal() {
        MusicalScore musicalScoreTest = new MusicalScore("PT-002", "Take On Me (arranjo p/ violino)", 1985,
                Conservation.WORN, "a-ha", 2, 96, 84);
        double d = musicalScoreTest.getDuration();
        assertEquals(4.571, d, 0.01);

    }
    @Test
    @DisplayName("Deve rejeitar construtor  musicalScore sem titulo")
    void rejeitaConstrutorMusicalScoreSemTitulo() {
        assertThrows(IllegalArgumentException.class, () -> new MusicalScore("PT-TST01", "",
                1717, Conservation.INTACT, "J.S. Bach", 4, 42, 60));
    }

    @Test
    @DisplayName("Deve rejeitar construtor  musicalScore  titulo so com espacos")
    void rejeitaConstrutorMusicalScoreSomenteEspaco() {
        assertThrows(IllegalArgumentException.class, () -> new MusicalScore("PT-TST02", " ",
                1717, Conservation.INTACT, "J. S. Bach", 4, 42, 60));
    }

    @Test
    @DisplayName("Deve rejeitar construtor  musicalScore  dificuldade maior que 5")
    void rejeitaConstrutorMusicalScoreDiffMaiorQueOEsperado() {
        assertThrows(IllegalArgumentException.class, () -> new MusicalScore("PT-TST03", "Prelúdio em Sol",
                1717, Conservation.INTACT, "J. S. Bach", 9, 42, 60));
    }

    @Test
    @DisplayName("Deve rejeitar construtor  musicalScore  dificuldade negativa ")
    void rejeitaConstrutorMusicalScoreDiffMenorQueOEsperado() {
        assertThrows(IllegalArgumentException.class, () -> new MusicalScore("PT-TST04", "Prelúdio em Sol",
                1717, Conservation.INTACT, "J. S. Bach", -1, 42, 60));
    }

    @Test
    @DisplayName("Deve rejeitar construtor  musicalScore  BPM sendo zero ")
    void rejeitaConstrutorMusicalScoreBpmZero() {
        assertThrows(IllegalArgumentException.class, () -> new MusicalScore("PT-TST05", "Prelúdio em Sol",
                1717, Conservation.INTACT, "J. S. Bach", 3, 42, 0));
    }

    @Test
    @DisplayName("Deve rejeitar construtor  musicalScore  compasso sendo zero")
    void rejeitaConstrutorMusicalScoreCompassZero() {
        assertThrows(IllegalArgumentException.class, () -> new MusicalScore("PT-TST06", "Prelúdio em Sol",
                1717, Conservation.INTACT, "J. S. Bach", 3, 0, 120));
    }

    @Test
    @DisplayName("Deve rejeitar construtor  musicalScore  Ano maior que o esperado")
    void rejeitaConstrutorMusicalScoreAnoMaiorQueEsperado() {
        assertThrows(IllegalArgumentException.class, () -> new MusicalScore("PT-TST07", "Prelúdio em Sol",
                2049, Conservation.INTACT, "J. S. Bach", 3, 50, 120));
    }

    @Test
    @DisplayName("Deve rejeitar construtor  musicalScore  Ano menor que o esperado")
    void rejeitaConstrutorMusicalScoreAnoMenorQueEsperado() {
        assertThrows(IllegalArgumentException.class, () -> new MusicalScore("PT-TST08", "Prelúdio em Sol",
                1200, Conservation.INTACT, "J. S. Bach", 3, 50, 120));
    }
}
