package com.epul.oeuvre.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "proprietaire", schema = "baseoeuvre", catalog = "")
public class
ProprietaireEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_proprietaire", nullable = false)
    private int idProprietaire;
    @Basic
    @Column(name = "nom_proprietaire", nullable = false, length = 100)
    private String nomProprietaire;
    @Basic
    @Column(name = "prenom_proprietaire", nullable = true, length = 100)
    private String prenomProprietaire;

    @Id
    @Column(name = "id_proprietaire")
    public int getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(int idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    @Basic
    @Column(name = "nom_proprietaire")
    public String getNomProprietaire() {
        return nomProprietaire;
    }

    public void setNomProprietaire(String nomProprietaire) {
        this.nomProprietaire = nomProprietaire;
    }

    @Basic
    @Column(name = "prenom_proprietaire")
    public String getPrenomProprietaire() {
        return prenomProprietaire;
    }

    public void setPrenomProprietaire(String prenomProprietaire) {
        this.prenomProprietaire = prenomProprietaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProprietaireEntity that = (ProprietaireEntity) o;
        return idProprietaire == that.idProprietaire && Objects.equals(nomProprietaire, that.nomProprietaire) && Objects.equals(prenomProprietaire, that.prenomProprietaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProprietaire, nomProprietaire, prenomProprietaire);
    }
}
