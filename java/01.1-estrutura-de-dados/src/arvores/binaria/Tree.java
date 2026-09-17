package arvores.binaria;

public class Tree {
    private Leaf leaf;
    private Tree left;
    private Tree right;

    public Tree() {
        this.leaf = null;
        this.left = null;
        this.right = null;
    }

    public Tree(Leaf leaf) {
        this.leaf = leaf;
        this.left = null;
        this.right = null;
    }

    public boolean isEmpty() {
        return this.leaf == null;
    }

    public void insert(Leaf newLeaft) {
        if (isEmpty()) {
            this.leaf = newLeaft;
        } else {
            Tree newTree = new Tree(newLeaft);

            if (newLeaft.getValue() < this.leaf.getValue()) {
                if (this.left == null) {
                    this.left = newTree;
                    System.out.println("Folha: " + newLeaft.getValue() + " a esquerda de: " + this.leaf.getValue());
                } else {
                    this.left.insert(newLeaft);
                }
            } else if (newLeaft.getValue() > this.leaf.getValue()) {
                if (this.right == null) {
                    this.right = newTree;
                    System.out.println("Folha: " + newLeaft.getValue() + " a direita de: " + this.leaf.getValue());

                } else {
                    this.right.insert(newLeaft);
                }
            }
        }
    }
}
