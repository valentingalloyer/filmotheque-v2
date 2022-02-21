package fr.eni.ihm;

import fr.eni.bll.IFilmService;
import fr.eni.bo.Avis;
import fr.eni.bo.Film;
import fr.eni.bo.Genre;
import fr.eni.bo.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Scanner;

@Controller
public class FilmController {

    @Autowired
    IFilmService filmService;

    @GetMapping("/list")
    public String listFilms(Model model) {
        model.addAttribute("listFilms", filmService.listFilms());
        return "listFilms";
    }

    public Film getFilmById(int id) {
        return filmService.getFilm(id);
    }

    @GetMapping("/get/{id}")
    public String getFilm(@PathVariable("id") int id, Model model) {
        model.addAttribute("film", filmService.getFilm(id));
        return "getFilm";
    }

    @GetMapping("/add")
    public String goAjouterFilm(Model model) {
        Film film = new Film();
        film.setAnnee(2022);
        model.addAttribute("filmForm", film);

        return "ajouterconsulterfilm";
    }

    @PostMapping("/add")
    public String addFilm(@ModelAttribute("filmForm") Film filmForm, Model model) throws Exception {
        filmService.addFilm(filmForm);
        return "index";
    }

//    @GetMapping("delete/${id}")
    public void deleteFilm() {
        System.out.println("Quel id ?");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        this.filmService.deleteFilm(id);
        System.out.println("Le film a été supprimé");
    }

    @GetMapping("/{id}/avis")
    public String goAjouterAvisFilm(@PathVariable("id") int id, Model model) {
        Film film = getFilmById(id);
        Avis avis = new Avis();
        avis.setNote(5);
        model.addAttribute("film", film);
        model.addAttribute("avis", avis);
        return "ajouteravis";
    }

    @PostMapping("/{id}/avis")
    public String noterFilm(@PathVariable("id") int id, @ModelAttribute("avisForm") Avis avis, Film filmForm, Model model) throws Exception {
        model.addAttribute("avisForm", avis);
        filmService.noterFilm(id, avis);
        return "index";
    }
}
