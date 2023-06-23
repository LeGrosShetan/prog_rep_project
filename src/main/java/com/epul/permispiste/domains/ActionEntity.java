package com.epul.permispiste.domains;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "action", schema = "permispiste", catalog = "")
public class ActionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUMACTION", nullable = false)
    private Integer numAction;
    @Basic
    @Column(name = "LIBACTION", nullable = false, length = 25)
    private String libAction;

    @ManyToMany
    @JoinTable(
            name = "est_associe",
            joinColumns = @JoinColumn(name = "NUMACTION"),
            inverseJoinColumns = @JoinColumn(name = "NUMOBJECTIF")
    )
    private Set<ObjectifEntity> objectifs;

    @ManyToMany
    @JoinTable(
            name = "possede",
            joinColumns = @JoinColumn(name = "NUMACTION"),
            inverseJoinColumns = @JoinColumn(name = "NUMREGLE")
    )
    private Set<RegleEntity> regles;

    //@ManyToOne
    //@JoinColumn( name = "NUMACTION")
    //private ActionEntity successeur;

    @ManyToMany
    @JoinTable(
            name = "appartient",
            joinColumns = @JoinColumn(name = "NUMACTION"),
            inverseJoinColumns = @JoinColumn(name = "NUMJEU")
    )
    private Set<JeuEntity> jeux;

    public Integer getNumaction() {
        return numAction;
    }

    public void setNumaction(Integer numaction) {
        this.numAction = numaction;
    }

    public String getLibaction() {
        return libAction;
    }

    public void setLibaction(String libaction) {
        this.libAction = libaction;
    }

    public Set<ObjectifEntity> getObjectifs() {
        return objectifs;
    }

    public void setObjectifs(Set<ObjectifEntity> objectifs) {
        this.objectifs = objectifs;
    }

    public Set<RegleEntity> getRegles() {
        return regles;
    }

    public void setRegles(Set<RegleEntity> regles) {
        this.regles = regles;
    }

    /*public ActionEntity getSuccesseur() {
        return successeur;
    }

    public void setSuccesseur(ActionEntity successeur) {
        this.successeur = successeur;
    }*/

    public Set<JeuEntity> getJeux() {
        return jeux;
    }

    public void setJeux(Set<JeuEntity> jeux) {
        this.jeux = jeux;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionEntity that = (ActionEntity) o;
        return Objects.equals(numAction, that.numAction) && Objects.equals(libAction, that.libAction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numAction, libAction);
    }
}
