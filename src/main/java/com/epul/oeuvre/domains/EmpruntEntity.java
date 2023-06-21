package com.epul.oeuvre.domains;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "emprunt", schema = "baseoeuvre", catalog = "")
public class EmpruntEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_emprunt", nullable = false)
    private int idEmprunt;
    @Basic
    @Column(name = "id_adherent", nullable = true)
    private Integer idAdherent;
    @Basic
    @Column(name = "id_oeuvrepret", nullable = true)
    private Integer idOeuvrepret;
    @Basic
    @Column(name = "date_emprunt", nullable = true)
    private Date dateEmprunt;
    @Basic
    @Column(name = "date_retour", nullable = true)
    private Date dateRetour;

    @Id
    @Column(name = "id_emprunt", insertable = false, updatable = false)
    public int getIdEmprunt() {
        return idEmprunt;
    }

    public void setIdEmprunt(int idEmprunt) {
        this.idEmprunt = idEmprunt;
    }

    @Basic
    @Column(name = "id_adherent", insertable = false, updatable = false)
    public Integer getIdAdherent() {
        return idAdherent;
    }

    public void setIdAdherent(Integer idAdherent) {
        this.idAdherent = idAdherent;
    }

    @Basic
    @Column(name = "id_oeuvrepret", insertable = false, updatable = false)
    public Integer getIdOeuvrepret() {
        return idOeuvrepret;
    }

    public void setIdOeuvrepret(Integer idOeuvrepret) {
        this.idOeuvrepret = idOeuvrepret;
    }

    @Basic
    @Column(name = "date_emprunt")
    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    @Basic
    @Column(name = "date_retour")
    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpruntEntity that = (EmpruntEntity) o;
        return idEmprunt == that.idEmprunt && Objects.equals(idAdherent, that.idAdherent) && Objects.equals(idOeuvrepret, that.idOeuvrepret) && Objects.equals(dateEmprunt, that.dateEmprunt) && Objects.equals(dateRetour, that.dateRetour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmprunt, idAdherent, idOeuvrepret, dateEmprunt, dateRetour);
    }
}
