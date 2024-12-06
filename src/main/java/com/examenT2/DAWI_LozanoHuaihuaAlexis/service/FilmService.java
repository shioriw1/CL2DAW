package com.examenT2.DAWI_LozanoHuaihuaAlexis.service;

import com.examenT2.DAWI_LozanoHuaihuaAlexis.Models.Category;
import com.examenT2.DAWI_LozanoHuaihuaAlexis.Models.Film;
import com.examenT2.DAWI_LozanoHuaihuaAlexis.dto.FilmDTO;
import com.examenT2.DAWI_LozanoHuaihuaAlexis.dto.FilmDetailDTO;
import com.examenT2.DAWI_LozanoHuaihuaAlexis.repository.CategoryRepository;
import com.examenT2.DAWI_LozanoHuaihuaAlexis.repository.FilmRepository;
import com.examenT2.DAWI_LozanoHuaihuaAlexis.repository.LanguageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    public List<FilmDTO> getAllFilms() {
        List<Film> films = filmRepository.findAll();
        List<FilmDTO> filmDTOs = films.stream().map(film -> new FilmDTO(
                        film.getFilmId(), film.getTitle(), film.getDescription(), film.getReleaseYear()))
                .collect(Collectors.toList());
        return filmDTOs;
    }


    public FilmDetailDTO getFilmDetails(Long id) {
        Film film = filmRepository.findById(id).orElseThrow(() -> new RuntimeException("Film not found"));
        List<String> categories = film.getCategories().stream().map(Category::getName).collect(Collectors.toList());
        return new FilmDetailDTO(film.getFilmId(), categories, film.getDescription(), film.getReleaseYear(), film.getLanguage().getName(), film.getTitle());
    }


    @Transactional
    public Film updateFilm(Long id, Film filmDetails) {
        Film film = filmRepository.findById(id).orElseThrow(() -> new RuntimeException("Film not found"));
     //    film.setTitle(filmDetails.getTitle());
        //  film.setDescription(filmDetails.getDescription());
        //  film.setReleaseYear(filmDetails.getReleaseYear());
        filmDetails.setFilmId(id);
        return filmRepository.save(filmDetails);
    }


    @Transactional
    public void deleteFilm(Long id) {
        filmRepository.deleteById(id);
    }


    @Transactional
    public Film createFilm(Film film) {
        return filmRepository.save(film);
    }
}
