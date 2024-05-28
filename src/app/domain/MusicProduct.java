package app.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.math.BigDecimal;
import java.util.Objects;

public class MusicProduct {
    private Long id;
    private String artist;
    private String song;
    private BigDecimal price;
    private String article;

    public MusicProduct(Long id, String artist, String song, BigDecimal price) {
        this.id = id;
        this.artist = artist;
        this.song = song;
        this.price = price;
    }



    public Long getId() {
        return id;
    }

    public String getArtist() {
        return artist;
    }

    public String getSong() {
        return song;
    }

    public BigDecimal getPrice() {
        return price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MusicProduct mp = (MusicProduct) o;
        return Objects.equals(id, mp.id) && Objects.equals(artist, mp.artist) && Objects.equals(song, mp.song) && Objects.equals(price, mp.price) && Objects.equals(article, mp.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, artist, song, price, article);
    }

    public Long getArticle() {
        return artist.hashCode() + song.hashCode() * id;
    }

}