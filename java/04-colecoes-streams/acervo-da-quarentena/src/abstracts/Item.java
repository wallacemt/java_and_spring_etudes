package abstracts;

import utils.Conservation;
import utils.ItemType;


public abstract class Item {
    private String code;
    private String title;
    private int year;
    private Conservation conservation;

    public Item(String code, String title, int year, Conservation conservation) {
        validateCode(code);
        validateTitle(title);
        validateYear(year);
        validateConservation(conservation);

        this.code = code;
        this.title = title;
        this.year = year;
        this.conservation = conservation;
    }

    private void validateConservation(Conservation conservation) {
        if (conservation == null) {
            throw new IllegalArgumentException("Conservation has cannot null");
        }
    }

    private void validateYear(int year) {
        if (year < 1500 || year > 2013) {
            throw new IllegalArgumentException(
                    "Year must be between 1500 and 2013"
            );
        }
    }

    private void validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title has cannot empty");
        }
    }

    public void validateCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Code has cannot empty: " + code);
        }
    }


    public abstract double getDuration();

    public abstract String describe();

    public abstract ItemType getType();

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public Conservation getConservation() {
        return conservation;
    }


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Item)) {
            return false;
        }

        Item itemEquals = (Item) obj;

        return this.code.equals(itemEquals.code);
    }

    @Override
    public int hashCode() {
        return this.code.hashCode();
    }
}
