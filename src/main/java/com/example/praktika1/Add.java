package com.example.praktika1;
public class Add {
    private String filmID;
    private String filmName;
    private String filmGenre;
    private String filmYear;
    private String filmRating;
    private String filmActor;
    private String filmProducer;
    private String filmFrom;
    public Add(String filmID, String filmName, String filmGenre, String filmYear,
               String filmRating, String filmActor, String filmProducer, String filmFrom) {
        this.filmID = filmID;
        this.filmName = filmName;
        this.filmGenre = filmGenre;
        this.filmYear = filmYear;
        this.filmRating = filmRating;
        this.filmActor = filmActor;
        this.filmProducer = filmProducer;
        this.filmFrom = filmFrom;
    }
    public Add() {
    }
    public String getFilmID() {
        return filmID;
    }
    public void setFilmID(String filmID) {
        this.filmID = filmID;
    }
    public String getFilmName() {
        return filmName;
    }
    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }
    public String getFilmGenre() {
        return filmGenre;
    }
    public void setFilmGenre(String filmGenre) {
        this.filmGenre = filmGenre;
    }
    public String getFilmYear() {
        return filmYear;
    }
    public void setFilmYear(String filmYear) {
        this.filmYear = filmYear;
    }
    public String getFilmRating() {
        return filmRating;
    }
    public void setFilmRating(String filmRating) {
        this.filmRating = filmRating;
    }
    public String getFilmActor() {
        return filmActor;
    }
    public void setFilmActor(String filmActor) {
        this.filmActor = filmActor;
    }
    public String getFilmProducer() {
        return filmProducer;
    }
    public void setFilmProducer(String filmProducer) {
        this.filmID = filmID;
    }
    public String getFilmFrom() {
        return filmFrom;
    }
    public void setFilmFrom(String filmFrom) {
        this.filmFrom = filmFrom;
    }
}