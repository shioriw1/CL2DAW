package com.examenT2.DAWI_LozanoHuaihuaAlexis.dto;

import java.time.LocalDate;
import java.util.List;

public class FilmDetailDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDate releaseDate;
    private String language;
    private List<String> categories;

    public FilmDetailDTO(Long id, List<String> categories,String description,  LocalDate releaseDate, String language, String title) {
        this.id = id;
        this.categories = categories;
        this.language = language;
        this.releaseDate = releaseDate;
        this.description = description;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
