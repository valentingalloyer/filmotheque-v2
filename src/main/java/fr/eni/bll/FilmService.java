package fr.eni.bll;

import fr.eni.bo.Avis;
import fr.eni.bo.Catalogue;
import fr.eni.bo.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("FilmService")
public class FilmService implements IFilmService {

    @Autowired
    Catalogue catalogue;

    @Autowired
    ConnectionService connectionService;

    @Override
    public List<Film> listFilms() {
        return catalogue.getFilms();
    }

    @Override
    public Film getFilm(int id) {
        return this.listFilms().stream().filter(film -> film.getId() == id).findFirst().get();
    }

    @Override
    public void addFilm(Film film) throws Exception {
        if (connectionService.getMembreConnecte() != null && connectionService.getMembreConnecte().isAdmin()) {
            film.setId(catalogue.getFilms().get(catalogue.getFilms().size()-1).getId() + 1);
            this.catalogue.getFilms().add(film);
        } else {
            throw new Exception("Vous n'êtes pas connecté ! INTERDIT !");
        }
    }

    @Override
    public void updateFilm(int id, Film film) {
//        this.catalogue.getFilms().stream().findFirst().get()
    }

    @Override
    public void deleteFilm(int id) {
        if (connectionService.getMembreConnecte() != null && connectionService.getMembreConnecte().isAdmin()) {
            this.listFilms().removeIf(film -> film.getId() == id);
        }
    }

    @Override
    public void noterFilm(int id, Avis avis) {
        if (connectionService.getMembreConnecte() != null) {
            getFilm(id).getListAvis().add(avis);
        }
    }


}
