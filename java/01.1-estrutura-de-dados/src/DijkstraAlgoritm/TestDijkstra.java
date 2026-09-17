package DijkstraAlgoritm;

import java.util.Scanner;

public class TestDijkstra {

    private static final int S1 = 0;
    private static final int S2 = 1;
    private static final int S3 = 2;
    private static final int S4 = 3;
    private static final int S5 = 4;
    private static final int S6 = 5;
    private static final int S7 = 6;
    private static final int S8 = 7;
    private static final int S9 = 8;
    private static final int S10 = 9;
    private static final int S11 = 10;
    private static final int S12 = 11;
    private static final int S13 = 12;
    private static final int S14 = 13;
    private static final int S15 = 14;
    private static final int S16 = 15;
    private static final int S17 = 16;
    private static final int S18 = 17;
    private static final int S19 = 18;
    private static final int S20 = 19;

    static void main(String[] args) {
        DijkstraAlgoritm djikstra = new DijkstraAlgoritm(20);

        //Linha Vermelha
        djikstra.createEdge(S1, S2, 16);
        djikstra.createEdge(S2, S3, 14);
        djikstra.createEdge(S3, S4, 12);
        djikstra.createEdge(S4, S5, 16);
        djikstra.createEdge(S5, S6, 14);

        // Linha Verde
        djikstra.createEdge(S7, S8, 15);
        djikstra.createEdge(S8, S9, 11);
        djikstra.createEdge(S9, S10, 13);
        djikstra.createEdge(S10, S11, 16);
        djikstra.createEdge(S11, S6, 15);

        // Linha Amarela.
        djikstra.createEdge(S12, S8, 11);
        djikstra.createEdge(S8, S2, 8);
        djikstra.createEdge(S2, S15, 7);
        djikstra.createEdge(S15, S16, 7);
        djikstra.createEdge(S16, S17, 12);
        djikstra.createEdge(S17, S18, 9);

        //Linha Azul
        djikstra.createEdge(S12, S9, 11);
        djikstra.createEdge(S9, S13, 7);
        djikstra.createEdge(S13, S14, 9);
        djikstra.createEdge(S14, S5, 9);
        djikstra.createEdge(S5, S17, 10);

        //Linha Roxa
        djikstra.createEdge(S10, S13, 11);
        djikstra.createEdge(S13, S3, 13);
        djikstra.createEdge(S3, S16, 11);
        djikstra.createEdge(S16, S19, 13);
        djikstra.createEdge(S19, S20, 12);

        Scanner in = new Scanner(System.in);
        System.out.println("Bem vindo ao SubWay-Systems");
        System.out.println("-------------------------------");

        while (true) {
            System.out.println("Entre com sua rota ou pressione ENTER para sair do programa!");
            int origin = readStaton("Origem", in);
            int destination = readStaton("Destino", in);


            for (Integer station : djikstra.minWay(origin, destination)) {
                System.out.print((station + 1) + " -> ");
            }

            System.out.println("Fim da Rota!");
        }


    }

    public static int readStaton(String text, Scanner in) {
        System.out.println(text + " : ");
        return in.nextInt();
    }
}
