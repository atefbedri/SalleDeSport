package com.example.salledesport;

public class Seance {

    private String dateSeance;
    private String nomActivite;
    private String nomCoach;

    public Seance() {
    }

    public Seance(String dateSeance, String nomActivite, String nomCoach) {
        this.dateSeance = dateSeance;
        this.nomActivite = nomActivite;
        this.nomCoach = nomCoach;
    }

    public String getDateSeance() {
        return dateSeance;
    }

    public void setDateSeance(String dateSeance) {
        this.dateSeance = dateSeance;
    }

    public String getNomActivite() {
        return nomActivite;
    }

    public void setNomActivite(String nomActivite) {
        this.nomActivite = nomActivite;
    }

    public String getNomCoach() {
        return nomCoach;
    }

    public void setNomCoach(String srcImage) {
        this.nomCoach = srcImage;
    }
}
