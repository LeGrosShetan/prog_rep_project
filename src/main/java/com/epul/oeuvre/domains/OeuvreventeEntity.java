package com.epul.oeuvre.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "oeuvrevente", schema = "baseoeuvre", catalog = "")
public class OeuvreventeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_oeuvrevente", nullable = false)
    private int idOeuvrevente;
    @Basic
    @Column(name = "titre_oeuvrevente", nullable = false, length = 200)
    private String titreOeuvrevente;
    @Basic
    @Column(name = "etat_oeuvrevente", nullable = false, length = 1)
    private String etatOeuvrevente;
    @Basic
    @Column(name = "prix_oeuvrevente", nullable = false, precision = 0)
    private double prixOeuvrevente;
    @Basic
    @Column(name = "id_proprietaire", nullable = true)
    private Integer idProprietaire;

    @Id
    @Column(name = "id_oeuvrevente")
    public int getIdOeuvrevente() {
        return idOeuvrevente;
    }

    public void setIdOeuvrevente(int idOeuvrevente) {
        this.idOeuvrevente = idOeuvrevente;
    }

    @Basic
    @Column(name = "titre_oeuvrevente")
    public String getTitreOeuvrevente() {
        return titreOeuvrevente;
    }

    public void setTitreOeuvrevente(String titreOeuvrevente) {
        this.titreOeuvrevente = titreOeuvrevente;
    }

    @Basic
    @Column(name = "etat_oeuvrevente")
    public String getEtatOeuvrevente() {
        return etatOeuvrevente;
    }

    public void setEtatOeuvrevente(String etatOeuvrevente) {
        this.etatOeuvrevente = etatOeuvrevente;
    }

    @Basic
    @Column(name = "prix_oeuvrevente")
    public double getPrixOeuvrevente() {
        return prixOeuvrevente;
    }

    public void setPrixOeuvrevente(double prixOeuvrevente) {
        this.prixOeuvrevente = prixOeuvrevente;
    }


    @Basic
    @Column(name = "id_proprietaire", insertable = false, updatable = false)
    public Integer getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(Integer idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OeuvreventeEntity that = (OeuvreventeEntity) o;
        return idOeuvrevente == that.idOeuvrevente && Double.compare(that.prixOeuvrevente, prixOeuvrevente) == 0 && Objects.equals(titreOeuvrevente, that.titreOeuvrevente) && Objects.equals(etatOeuvrevente, that.etatOeuvrevente) && Objects.equals(idProprietaire, that.idProprietaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOeuvrevente, titreOeuvrevente, etatOeuvrevente, prixOeuvrevente, idProprietaire);
    }
}
