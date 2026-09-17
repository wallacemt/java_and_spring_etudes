package arvores.binaria;

public class TestTree {
    static void main(String[] args) {
        Tree tree = new Tree(new Leaf(30));

        tree.insert(new Leaf(15));
        tree.insert(new Leaf(45));
        tree.insert(new Leaf(7));
        tree.insert(new Leaf(19));
    }
}
