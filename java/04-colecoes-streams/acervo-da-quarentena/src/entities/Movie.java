package entities;

import abstracts.Item;
import utils.Conservation;
import utils.ItemType;

public class Movie extends Item {
    private String director;
    private double duration;

    public Movie(String code, String title, int ano, Conservation conservation,
                 String director, double duration) {
        super(code, title, ano, conservation);
        validateDirector(director);
        validateDuration(duration);

        this.director = director;
        this.duration = duration;
    }

    private void validateDirector(String diretor) {
        if (diretor == null || diretor.trim().isEmpty()) {
            throw new IllegalArgumentException("diretor cannot null or empty");
        }
    }

    private void validateDuration(double duracao) {
        if (duracao <= 0) {
            throw new IllegalArgumentException("duração needs greater than zero");
        }
    }

    @Override
    public double getDuration() {
        return this.duration;
    }

    @Override
    public String describe() {
        return String.format("[%s] %s (%d) · dir. %s · %.1f min · %s",
                this.getCode(), this.getTitle(), this.getYear(), this.director,
                this.duration, this.getConservation());
    }

    @Override
    public String getType() {
        return ItemType.MOVIE.name();
    }

    public String getDirector() {
        return director;
    }

}
