package entities;

import abstracts.Item;
import utils.Conservation;
import utils.ItemType;

public class Serie extends Item {
    private int[] episodesPerSeason;
    private double averageDuration;

    public Serie(String code, String title, int year, Conservation conservation,
                 int[] episodesPerSeason, double averageDuration) {
        super(code, title, year, conservation);
        validateEpisode(episodesPerSeason);
        validateAverageDuration(averageDuration);

        this.episodesPerSeason = episodesPerSeason.clone();
        this.averageDuration = averageDuration;
    }

    private void validateEpisode(int[] episodes) {
        if (episodes == null || episodes.length == 0) {
            throw new IllegalArgumentException("episódios has cannot null!");
        }
        for (int ep : episodes) {
            if (ep <= 0) {
                throw new IllegalArgumentException("episodes per season needs greater than zero");
            }
        }
    }

    private void validateAverageDuration(double duration) {
        if (duration <= 0) {
            throw new IllegalArgumentException("average duration needs greater than zero!");
        }
    }

    @Override
    public double getDuration() {
        int totalEpisodes = 0;
        for (int ep : episodesPerSeason) {
            totalEpisodes += ep;
        }
        return totalEpisodes * this.averageDuration;
    }

    @Override
    public String describe() {
        int totalEpisodes = 0;
        for (int ep : episodesPerSeason) {
            totalEpisodes += ep;
        }
        return String.format("[%s] %s (%d) · %d seasons · %d episodes · %.1f min · %s",
                this.getCode(), this.getTitle(), this.getYear(), this.episodesPerSeason.length,
                totalEpisodes, this.getDuration(), this.getConservation());
    }

    @Override
    public String getType() {
        return ItemType.SERIE.name();
    }

    public int[] getEpisodesPerSeason() {
        return episodesPerSeason.clone();
    }

    public double getAverageDuration() {
        return averageDuration;
    }
}
