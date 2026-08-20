package entities;

import abstracts.Item;
import utils.Conservation;

public class Movie extends Item {
    private String director;
    private double duractiton;

    public Movie(String code, String title, int ano, Conservation conservation,
                 String director, double duractiton) {
        super(code, title, ano, conservation);
        validateDirector(director);
        validateDuration(duractiton);

        this.director = director;
        this.duractiton = duractiton;
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
        return this.duractiton;
    }

    @Override
    public String describe() {
        return String.format("[%s] %s (%d) · dir. %s · %.1f min · %s",
                this.getCode(), this.getTitle(), this.getYear(), this.director,
                this.duractiton, this.getConservation());
    }

    @Override
    public String getType() {
        return "Movie";
    }

    public String getDirector() {
        return director;
    }

    public double getDuraction() {
        return duractiton;
    }
}
