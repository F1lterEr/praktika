package com.example.praktika1;
public class Filter {
    private String filmGenre;
    public Filter(String filmGenre) {
        this.filmGenre = filmGenre;
    }
    public Filter() {}
    public String getFilmGenre() {
        return filmGenre;
    }
    public void setFilmGenre(String filmGenre) {
        this.filmGenre = filmGenre;
    }
}