package mapas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StorageManagement {
    private HashMap<String, Integer> storageList;

    public StorageManagement() {
        storageList = new HashMap<String, Integer>();
    }

    public String addOrUpdate(final String product, final Integer size) {
        if (size < 0) {
            return "Quantidade invalida, deve uma quantidade positiva!";
        }

        if (storageList.containsKey(product)) {
            storageList.put(product, storageList.get(product) + size);
            return "Produto " + product + " atualizado com sucesso!";
        } else {
            storageList.put(product, size);
            return "Produto adicionado ao estoque";
        }

    }

    public String removeProduct(final String product) {
        if (storageList.remove(product) != null) {
            return "Produto: " + product + " foi removido!";
        } else {
            return "Produto não encontrado no estoque";
        }
    }


    public void showAllProducts() {
        for (Map.Entry<String, Integer> entry : storageList.entrySet()) {
            System.out.println("Produto: " + entry.getKey() + " Quantidade: " + entry.getValue());
        }
    }

    public void getProduct(final String product) {
        if (storageList.containsKey(product)) {
            Integer qtdProduct = storageList.get(product);
            System.out.println("Product: " + product + " Quantidade: " + qtdProduct);
        } else {
            System.out.println("Produto não encontrado no estoque");
        }
    }

    void main(String[] args) {

        Integer option = -1;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("=== Gerenciando Estoques ===");
            System.out.println(
                    "1. Adicionar Produto \n" +
                            "2. Remover Produto\n" +
                            "3. Ver todos os Produtos\n" +
                            "4. Consultar Produto\n" +
                            "0. Sair\n" +
                            "Escolha uma opcao acima: ");
            option = sc.nextInt();

            switch (option) {
                case 1: {
                    System.out.println("Digite o nome do produto");
                    String productName = sc.next();

                    System.out.println("Digite a quantidade do produto (" + productName + ")");
                    Integer productSize = sc.nextInt();

                    System.out.println(addOrUpdate(productName, productSize));
                    break;
                }
                case 2: {
                    System.out.println("Digite o nome do produto que quer remover: ");
                    String productName = sc.next();

                    System.out.println(removeProduct(productName));
                    break;
                }
                case 3: {
                    showAllProducts();
                    break;
                }
                case 4: {
                    System.out.println("Digite o nome do produto que deseja consultar: ");
                    String productName = sc.next();
                    getProduct(productName);
                    break;
                }
                default: {
                    System.out.println("Opção Invalida!!");
                }
            }


        }
        while (option != 0);

        sc.close();
        System.out.println("Finalizando....");
    }
}
