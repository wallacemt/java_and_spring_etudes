package utils;

public enum Conservation {
    INTACT("INTACT"),
    WORN("WORN"),
    DEMAGED("DEMAGED"),
    ILLEGIBLE("ILEGIBLE");
    private final String description;

    Conservation(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
