package entities;

import abstracts.Item;
import exceptions.DuplicatedItemException;
import exceptions.NotFoundItemException;
import utils.Conservation;
import utils.ItemType;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionStore {
    private Map<String, Item> itens;

    public CollectionStore() {
        this.itens = new HashMap<>();
    }

    public void catalog(Item item) throws DuplicatedItemException {
        if (itens.containsKey(item.getCode())) {
            throw new DuplicatedItemException(item.getCode());
        }
        itens.put(item.getCode(), item);
    }

    public Item search(String code) throws NotFoundItemException {
        if (!itens.containsKey(code)) {
            throw new NotFoundItemException(code);
        }
        return itens.get(code);
    }

    public List<Item> listAll() {
        return Collections.unmodifiableList(
                new ArrayList<>(itens.values())
        );
    }

    public Map<String, List<Item>> groupedByType() {
        return itens.values().stream()
                .collect(Collectors.groupingBy(Item::getType));
    }

    public double getTotalDuration() {
        return itens.values().stream()
                .mapToDouble(Item::getDuration)
                .sum();
    }

    public List<Item> nightSession(double availibleMinutes)
            throws IllegalArgumentException {
        if (availibleMinutes < 0) {
            throw new IllegalArgumentException("minutes has  cannot negative!");
        }

        List<Item> valids = itens.values().stream()
                .filter(item -> item.getConservation() != Conservation.ILLEGIBLE)
                .sorted(Comparator
                        .comparingDouble(Item::getDuration).reversed()
                        .thenComparing(Item::getTitle))
                .collect(Collectors.toList());

        List<Item> sessao = new ArrayList<>();
        double restTime = availibleMinutes;

        for (Item item : valids) {
            double duracao = item.getDuration();
            if (duracao <= restTime) {
                sessao.add(item);
                restTime -= duracao;
            }
        }

        return sessao;
    }

    public int obterTotalItens() {
        return itens.size();
    }

}
