package com.epul.oeuvre.domains;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ReservationEntityPK implements Serializable {
    @Column(name = "id_oeuvrevente", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOeuvrevente;
    @Column(name = "id_adherent", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAdherent;

    @Column(name = "id_oeuvrevente", insertable = false, updatable = false)
    @Id
    public int getIdOeuvrevente() {
        return idOeuvrevente;
    }

    public void setIdOeuvrevente(int idOeuvrevente) {
        this.idOeuvrevente = idOeuvrevente;
    }

    @Column(name = "id_adherent", insertable = false, updatable = false)
    @Id
    public int getIdAdherent() {
        return idAdherent;
    }

    public void setIdAdherent(int idAdherent) {
        this.idAdherent = idAdherent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationEntityPK that = (ReservationEntityPK) o;
        return idOeuvrevente == that.idOeuvrevente && idAdherent == that.idAdherent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOeuvrevente, idAdherent);
    }
}
