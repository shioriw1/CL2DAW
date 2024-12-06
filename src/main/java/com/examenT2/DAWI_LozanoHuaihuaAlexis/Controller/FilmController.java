package com.examenT2.DAWI_LozanoHuaihuaAlexis.Controller;

import com.examenT2.DAWI_LozanoHuaihuaAlexis.Models.Film;
import com.examenT2.DAWI_LozanoHuaihuaAlexis.dto.FilmDTO;
import com.examenT2.DAWI_LozanoHuaihuaAlexis.dto.FilmDetailDTO;
import com.examenT2.DAWI_LozanoHuaihuaAlexis.repository.CategoryRepository;
import com.examenT2.DAWI_LozanoHuaihuaAlexis.repository.LanguageRepository;
import com.examenT2.DAWI_LozanoHuaihuaAlexis.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController {
    @Autowired
    private FilmService filmService;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping("/films")
    public List<FilmDTO> getFilms() {
        List<FilmDTO> films = filmService.getAllFilms();
         return films;
    }


    @GetMapping("/films/{id}")
    public FilmDetailDTO getFilmDetails(@PathVariable Long id, Model model) {
        FilmDetailDTO film = filmService.getFilmDetails(id);
        model.addAttribute("film", film);
        return film;
    }



    @PutMapping("/films/{id}")
    public String updateFilm(@PathVariable Long id, @RequestBody Film film) {
        filmService.updateFilm(id, film);
        return "se actualizo la pelicula";
    }


    @DeleteMapping("/films/{id}")
    public String deleteFilm(@PathVariable Long id) {
        filmService.deleteFilm(id);
        return "se elimino registro : " + id;
    }

    @GetMapping("/films/new")
    public String newFilmForm(Model model) {
        model.addAttribute("film", new Film());
        model.addAttribute("languages", languageRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        return "filmNew"; // Template para crear un nuevo film
    }

    @PostMapping("/films")
    public String createFilm(@RequestBody Film film) {
        filmService.createFilm(film);
        return "Se creo nuevo registro";
    }

    @GetMapping("/start")
    public String start(Model model) {
        List<FilmDTO> films = filmService.getAllFilms();
        model.addAttribute("films", films);
        return "maintenance";
    }

}
