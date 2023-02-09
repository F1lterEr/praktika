package com.example.praktika1;
import javafx.beans.property.SimpleIntegerProperty;
public class filmsTable {
    String filmID, filmName, filmGenre, filmYear, filmRating, filmActor, filmProducer, filmFrom;
    public filmsTable(String filmID, String filmName, String filmGenre, String filmYear,
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
    public filmsTable() {}
    public String getFilmID(){
        return filmID;
    }
    public void setFilmID(String filmID){
    }
    public String getFilmName(){
        return filmName;
    }
    public void setFilmName(String filmName){
    }
    public String getFilmGenre(){
        return filmGenre;
    }
    public void setFilmGenre(String filmGenre){
    }
    public String getFilmYear(){
        return filmYear;
    }
    public void setFilmYear(String filmYear){
    }
    public String getFilmRating(){
        return filmRating;
    }
    public void setFilmRating(String filmRating){
    }
    public String getFilmActor(){
        return filmActor;
    }
    public void setFilmActor(String filmActor){
    }
    public String getFilmProducer(){
        return filmProducer;
    }
    public void setFilmProducer(String filmProducer){
    }
    public String getFilmFrom(){
        return filmFrom;
    }
    public void setFilmFrom(String filmFrom){
    }
}
