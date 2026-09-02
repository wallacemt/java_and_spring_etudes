package utils;

public enum ItemType {
    MUSICAL_SCORE("MUSICAL_SCORE"),
    MOVIE("MOVIE"),
    SERIE("SERIE");
    private final String name;

    ItemType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
