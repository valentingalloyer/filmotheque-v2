package fr.eni.bo;

import java.util.ArrayList;
import java.util.List;

public class Film {
    private int id;
    private String titre;
    private int annee;
    private int duree;
    private String synopsis;
    private Personne realisateur;
    private List<Personne> acteurs;
    private List<Avis> listAvis;
    private Genre genre;

    public Film() {
        realisateur = new Personne();
        acteurs = new ArrayList<>();
        genre = new Genre();
        listAvis = new ArrayList<>();
    }

    public Film(int id, String titre, int annee, int duree, String synopsis, Personne realisateur, List<Personne> acteurs, Genre genre) {
        this.id = id;
        this.titre = titre;
        this.annee = annee;
        this.synopsis = synopsis;
        this.duree = duree;
        this.realisateur = realisateur;
        this.acteurs = acteurs;
        this.genre = genre;
        this.listAvis = new ArrayList<>();
    }

    public Film(String titre, int annee, int duree, String synopsis, Personne realisateur, List<Personne> acteurs, Genre genre) {
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.synopsis = synopsis;
        this.realisateur = realisateur;
        this.acteurs = acteurs;
        this.genre = genre;
        this.listAvis = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", annee=" + annee +
                ", duree=" + duree +
                ", synopsis='" + synopsis + '\'' +
                ", realisateur=" + realisateur +
                ", acteurs=" + acteurs +
                ", listAvis=" + listAvis +
                ", genre=" + genre +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Personne getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Personne realisateur) {
        this.realisateur = realisateur;
    }

    public List<Personne> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Personne> acteurs) {
        this.acteurs = acteurs;
    }

    public List<Avis> getListAvis() {
        return listAvis;
    }

    public void setListAvis(List<Avis> listAvis) {
        this.listAvis = listAvis;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
