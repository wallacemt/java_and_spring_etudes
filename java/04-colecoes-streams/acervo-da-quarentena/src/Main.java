import abstracts.Item;
import entities.CollectionStore;
import entities.Movie;
import entities.MusicalScore;
import entities.Serie;
import exceptions.DuplicatedItemException;
import exceptions.NotFoundItemException;
import utils.Conservation;
import utils.ItemType;

import java.util.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Main {
    private static DecimalFormat df;

    static {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
        df = new DecimalFormat("0.0", symbols);
    }

    public static void main(String[] args) {
        CollectionStore collectionStore = new CollectionStore();
        // Montar collectionStore de exemplo
        try {
            collectionStore.catalog(new MusicalScore("PT-001", "Prelúdio em Sol",
                    1717, Conservation.INTACT, "J. S. Bach", 4, 42, 60));
            collectionStore.catalog(new MusicalScore("PT-002", "Take On Me (arranjo p/ violino)", 1985,
                    Conservation.WORN, "a-ha", 2, 96, 84));
            collectionStore.catalog(new MusicalScore("PT-003", "Future Days", 2013,
                    Conservation.ILLEGIBLE, "P. Yorn", 3, 64, 76));
            collectionStore.catalog(new Movie("FL-001", "Curtis e Viper 2", 2013,
                    Conservation.INTACT, "desconhecido", 118.0));
            collectionStore.catalog(new Serie("SR-001", "Além da Imaginação", 1959,
                    Conservation.DEMAGED, new int[]{36, 29}, 25.0));
        } catch (DuplicatedItemException e) {
            System.out.println("Erro in cataloge: " + e.getMessage());
        }

        // Relatório principal
        printReport(collectionStore);

        // Testes de erro
        System.out.println("\n--- TENTATIVAS INVÁLIDAS ---");
        testErrors(collectionStore);

        // Auto-teste
        System.out.println("\n--- AUTO-TESTE ---");
        autoTeste(collectionStore);
    }

    private static void printReport(CollectionStore collectionStore) {
        System.out.println("=== ACERVO DA QUARENTENA — JACKSON, WY ===");
        System.out.println("Itens catalogados: " + collectionStore.getAllItens());

        double totalDuration = collectionStore.getTotalDuration();
        long hours = (long) totalDuration / 60;
        long minutes = (long) totalDuration % 60;
        System.out.println("Duração total: " + df.format(totalDuration) + " min (" +
                hours + "h" + String.format("%02d", minutes) + ")");

        // Agrupar por tipo
        System.out.println("\n--- POR TIPO ---");
        Map<ItemType, List<Item>> byType = collectionStore.groupedByType();

        for (Map.Entry<ItemType, List<Item>> entry : byType.entrySet()) {
            System.out.println(entry.getKey() + " (" + entry.getValue().size() + ")");

            for (Item item : entry.getValue()) {
                System.out.println("  " + item.describe());
            }
        }

        // Sessões da noite
        System.out.println("\n--- SESSÃO DA NOITE (120 min disponíveis) ---");
        printSession(collectionStore, 120);

        System.out.println("\n--- SESSÃO DA NOITE (130 min disponíveis) ---");
        printSession(collectionStore, 130);
    }

    private static void printSession(CollectionStore collectionStore, double minutos) {
        try {
            List<Item> session = collectionStore.nightSession(minutos);
            double totalSessao = 0;

            for (Item item : session) {
                double dur = item.getDuration();
                System.out.println("  [" + item.getCode() + "] " + item.getTitle() +
                        " — " + df.format(dur) + " min");
                totalSessao += dur;
            }

            double restante = minutos - totalSessao;
            if (session.isEmpty()) {
                System.out.println("  Nenhum item cabe.");
            } else {
                System.out.println("  Restam " + df.format(restante) + " min.");
            }
            System.out.println("Total da sessão: " + df.format(totalSessao) +
                    " min de " + df.format(minutos) + " min");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void testErrors(CollectionStore collectionStore) {
        // Teste 1: Duplicado
        try {
            collectionStore.catalog(new MusicalScore("PT-001", "Outro", 2000,
                    Conservation.INTACT, "Outro", 1, 1, 1));
        } catch (DuplicatedItemException e) {
            System.out.println("Catalogar PT-001 de novo -> ItemDuplicadoException: " + e.getMessage());
        }

        // Teste 2: Não encontrado
        try {
            collectionStore.search("XX-999");
        } catch (NotFoundItemException e) {
            System.out.println("Buscar XX-999             -> ItemNaoEncontradoException: " + e.getMessage());
        }

        // Teste 3: BPM inválido
        try {
            new MusicalScore("PT-999", "Teste", 2000, Conservation.INTACT, "Teste", 1, 1, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Partitura com 0 bpm       -> IllegalArgumentException: " + e.getMessage());
        }
    }

    private static void autoTeste(CollectionStore collectionStore) {
        try {
            // PT-001: (42 × 4) ÷ 60 = 2,8 min
            Item pt001 = collectionStore.search("PT-001");
            double durPt001 = pt001.getDuration();
            check( Math.abs(durPt001 - 2.8) < 0.01 , "PT-001 deve ter 2,8 min");
            System.out.println("✓ PT-001: " + df.format(durPt001) + " min (esperado 2,8)");

            // PT-002: (96 × 4) ÷ 84 = 4,571...
            Item pt002 = collectionStore.search("PT-002");
            double durPt002 = pt002.getDuration();
            check(Math.abs(durPt002 - 4.571) < 0.01 , "PT-002 deve ter ~4,571 min");
            System.out.println("✓ PT-002: " + df.format(durPt002) + " min (esperado 4,6)");

            // SR-001: (36 + 29) × 25 = 1625,0 min
            Item sr001 = collectionStore.search("SR-001");
            double durSr001 = sr001.getDuration();
            check(Math.abs(durSr001 - 1625.0) < 0.01 , "SR-001 deve ter 1625,0 min");

            System.out.println("✓ SR-001: " + df.format(durSr001) + " min (esperado 1625,0)");

            // Total: 2,8 + 4,571 + 3,368 + 118 + 1625 = 1753,7
            double total = collectionStore.getTotalDuration();
            check(
                    Math.abs(total - 1753.7) < 0.1,
                    "Total deve ser ~1753,7 min"
            );

            System.out.println("✓ Total: " + df.format(total) + " min (esperado 1753,7)");

            System.out.println("\n✓ Todos os testes passaram!");
        } catch (NotFoundItemException e) {
            System.out.println("✗ Erro no auto-teste: " + e.getMessage());
        } catch (AssertionError e) {
            System.out.println("✗ Asserção falhou: " + e.getMessage());
        }
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}