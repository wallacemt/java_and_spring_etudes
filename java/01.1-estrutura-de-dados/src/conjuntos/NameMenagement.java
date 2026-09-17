package conjuntos;

import javax.swing.*;
import java.util.HashSet;

public class NameMenagement {
    private HashSet<String> hashNames;

    public NameMenagement() {
        this.hashNames = new HashSet<String>();
    }


    public String addName(String name) {
        if (hashNames.add(name)) {
            return "Nome adicionado na lista";
        } else {
            return "Nome duplciado! Nao pode ser adicionado!";
        }
    }


    public boolean isNameExists(String name) {
        return hashNames.contains(name);
    }

    public String removeName(final String name) {
        if (hashNames.remove(name)) {
            return "Nome removido com sucesso!";
        } else {
            return "Nome não encontrado!";
        }
    }

    public void showAllNames() {
        if (hashNames.isEmpty()) {
            System.out.println("Lista de nomes vazia!");
        } else {
            for (String s : hashNames) {
                System.out.println("Nome: " + s);
            }
        }
    }

    static void main(String[] args) {
        NameMenagement nameManegements = new NameMenagement();
        int opt = 0;
        do {
            opt = Integer.parseInt(JOptionPane.showInputDialog(
                    "1 - Adicionar Nomes \n" +
                            "2 - Verificar Nome \n" +
                            "3 - Remover Nome \n" +
                            "4 - Exibir todos os nomes \n" +
                            "5 - Sair"
            ));


            switch (opt) {
                case 1: {
                    System.out.println(nameManegements.addName(JOptionPane.showInputDialog("Digite um nome para adicionar: ")));
                    break;
                }
                case 2: {
                    System.out.println( nameManegements.isNameExists(JOptionPane.showInputDialog("Digite um nome, para consultar: ")));
                    break;
                }
                case 3: {
                    System.out.println(nameManegements.removeName(JOptionPane.showInputDialog("Digite um nome para remover!")));
                    break;
                }
                case 4: {
                    nameManegements.showAllNames();
                    break;
                }
                default:
                    System.out.println("Opção invalida. Entre 1 a 5");
            }
        } while (opt != 5);
    }
}
