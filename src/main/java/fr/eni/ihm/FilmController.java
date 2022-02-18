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
        System.out.println(id);
        model.addAttribute("film", filmService.getFilm(id));
        return "getFilm";
    }

    @GetMapping("/add")
    public String goAjouterFilm(Model model) {
        Film film = new Film();
        model.addAttribute("filmForm", film);

        return "ajouterconsulterfilm";
    }

    @PostMapping("/add")
    public String addFilm(@ModelAttribute("filmForm") Film filmForm, Model model) throws Exception {
        model.addAttribute("filmForm", filmForm);
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

//    @GetMapping("note/${id}")
    public void noterFilm() {
        System.out.println("Quel id ?");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        System.out.println("Vous allez noter le film " + getFilmById(id).getTitre());

        System.out.println("Quelle note ?");
        int note = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Dites m'en plus");
        String libelle = scanner.nextLine();

        Avis avis = new Avis(note, libelle, getFilmById(id));

        this.filmService.noterFilm(id, avis);
    }
}
