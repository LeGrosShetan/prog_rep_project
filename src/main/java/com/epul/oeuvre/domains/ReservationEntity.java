package com.epul.oeuvre.domains;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "reservation", schema = "baseoeuvre", catalog = "")
@IdClass(ReservationEntityPK.class)
public class ReservationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_oeuvrevente", nullable = false)
    private int idOeuvrevente;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_adherent", nullable = false)
    private int idAdherent;
    @Basic
    @Column(name = "date_reservation", nullable = false)
    private Date dateReservation;
    @Basic
    @Column(name = "statut", nullable = false, length = 20)
    private String statut;

    @Id
    @Column(name = "id_oeuvrevente", insertable = false, updatable = false)
    public int getIdOeuvrevente() {
        return idOeuvrevente;
    }

    public void setIdOeuvrevente(int idOeuvrevente) {
        this.idOeuvrevente = idOeuvrevente;
    }

    @Id
    @Column(name = "id_adherent", insertable = false, updatable = false)
    public int getIdAdherent() {
        return idAdherent;
    }

    public void setIdAdherent(int idAdherent) {
        this.idAdherent = idAdherent;
    }

    @Basic
    @Column(name = "date_reservation")
    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    @Basic
    @Column(name = "statut")
    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationEntity that = (ReservationEntity) o;
        return idOeuvrevente == that.idOeuvrevente && idAdherent == that.idAdherent && Objects.equals(dateReservation, that.dateReservation) && Objects.equals(statut, that.statut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOeuvrevente, idAdherent, dateReservation, statut);
    }
}
