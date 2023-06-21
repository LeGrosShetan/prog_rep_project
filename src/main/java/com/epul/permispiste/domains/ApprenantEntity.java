package com.epul.permispiste.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "apprenant", schema = "permispiste")
public class ApprenantEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NUMAPPRENANT", nullable = false)
    private Integer numApprenant;
    @Basic
    @Column(name = "NOMAPPRENANT", nullable = false, length = 25)
    private String nomApprenant;
    @Basic
    @Column(name = "PRENOMAPPRENANT", nullable = false, length = 25)
    private String prenomApprenant;

    public Integer getNumapprenant() {
        return numApprenant;
    }

    public void setNumapprenant(Integer numApprenant) {
        this.numApprenant = numApprenant;
    }

    public String getNomapprenant() {
        return nomApprenant;
    }

    public void setNomapprenant(String nomApprenant) {
        this.nomApprenant = nomApprenant;
    }

    public String getPrenomapprenant() {
        return prenomApprenant;
    }

    public void setPrenomapprenant(String prenomApprenant) {
        this.prenomApprenant = prenomApprenant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApprenantEntity that = (ApprenantEntity) o;
        return Objects.equals(numApprenant, that.numApprenant) && Objects.equals(nomApprenant, that.nomApprenant) && Objects.equals(prenomApprenant, that.prenomApprenant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numApprenant, nomApprenant, prenomApprenant);
    }
}
