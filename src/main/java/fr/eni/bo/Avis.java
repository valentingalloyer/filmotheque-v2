package fr.eni.bo;

public class Avis {

    private int id;
    private int note;
    private String avis;
    private Film film;
    private Membre membre;

    public Avis() {
    }

    public Avis(int id, int note, String avis, Film film, Membre membre) {
        this.id = id;
        this.note = note;
        this.avis = avis;
        this.film = film;
        this.membre = membre;
    }

    public Avis(int note, String avis, Film film) {
        this.note = note;
        this.avis = avis;
        this.film = film;
    }

    @Override
    public String toString() {
        return "Avis donné par " + (membre != null ? membre.toString() : "inconnu") + " :\n" +
                note + "/10\n" +
                avis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getAvis() {
        return avis;
    }

    public void setAvis(String avis) {
        this.avis = avis;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }
}
