package com.epul.oeuvre.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "utilisateur", schema = "baseoeuvre", catalog = "")
@NamedQuery(name = "UtilisateurEntity.rechercheNom",query = "select ut  from UtilisateurEntity  ut where ut.nomUtil = ?1")
public class UtilisateurEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NumUtil", nullable = false)
    private int numUtil;
    @Basic
    @Column(name = "NomUtil", nullable = false, length = 100)
    private String nomUtil;
    @Basic
    @Column(name = "MotPasse", nullable = false, length = 100)
    private String motPasse;
    @Basic
    @Column(name = "salt", nullable = false, length = 100)
    private String salt;
    @Basic
    @Column(name = "role", nullable = false, length = 100)
    private String role;

    @Id
    @Column(name = "numutil",insertable = false, updatable = false, nullable = false)
    public Integer getNumUtil() {
        return numUtil;
    }

    public void setNumUtil(int numUtil) {
        this.numUtil = numUtil;
    }

    @Basic
    @Column(name = "nomutil", insertable = false, updatable = false, nullable = false, length = 100)
    public String getNomUtil() {
        return nomUtil;
    }

    public void setNomUtil(String nomUtil) {
        this.nomUtil = nomUtil;
    }

    @Basic
    @Column(name = "motpasse", insertable = false, updatable = false, nullable = false, length = 100)
    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    @Basic
    @Column(name = "salt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtilisateurEntity that = (UtilisateurEntity) o;
        return numUtil == that.numUtil && Objects.equals(nomUtil, that.nomUtil) && Objects.equals(motPasse, that.motPasse) && Objects.equals(salt, that.salt) && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numUtil, nomUtil, motPasse, salt, role);
    }
}
