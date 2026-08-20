package entities;

import abstracts.Item;
import utils.Conservation;
import utils.ItemType;

public class MusicalScore extends Item {

    private String composition;
    private int diff;
    private int compass;
    private int bpm;

    public MusicalScore(String code, String title, int year, Conservation conservation, String composition, int diff, int compass, int bpm) {
        super(code, title, year, conservation);

        validateComposition(composition);
        validateDiff(diff);
        validateCompass(compass);
        validateBpm(bpm);

        this.composition = composition;
        this.diff = diff;
        this.compass = compass;
        this.bpm = bpm;
    }

    private void validateBpm(int bpm) {
        if (bpm <= 0) {
            throw new IllegalArgumentException("BPM needs gratter than zero!");
        }
    }

    private void validateCompass(int compass) {
        if (compass <= 0) {
            throw new IllegalArgumentException("Compaas needs gratter than zero!");
        }
    }

    private void validateDiff(int diff) {
        if (diff < 1 || diff > 5) {
            throw new IllegalArgumentException("Diff not in range 1, 5");
        }
    }

    private void validateComposition(String composition) {
        if (composition == null || composition.trim().isEmpty()) {
            throw new IllegalArgumentException("Composition is cannot null");
        }
    }

    @Override
    public double getDuration() {
        return (this.compass * 4.0) / this.bpm;
    }

    @Override
    public String describe() {
        return String.format("[%s] %s (%d) · %s · dif. %d/5 · %.1f min · %s",
                this.getCode(), this.getTitle(), this.getYear(), this.composition,
                this.diff, this.getDuration(), this.getConservation());
    }

    @Override
    public String getType() {
        return ItemType.MUSICAL_SCORE.name();
    }

    public String getComposition() {
        return composition;
    }

    public int getDiff() {
        return diff;
    }

    public int getCompass() {
        return compass;
    }

    public int getBpm() {
        return bpm;
    }
}
