package com.examenT2.DAWI_LozanoHuaihuaAlexis.dto;

import java.time.LocalDate;

public class FilmDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDate releaseDate;

    public FilmDTO(Long id, String title, String description, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
