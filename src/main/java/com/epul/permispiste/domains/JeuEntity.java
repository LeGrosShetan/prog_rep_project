package com.epul.permispiste.domains;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "jeu", schema = "permispiste")
public class JeuEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NUMJEU", nullable = false)
    private Integer numJeu;
    @Basic
    @Column(name = "LIBELLEJEU", nullable = false, length = 25)
    private String libelleJeu;

    @ManyToMany(mappedBy = "jeux")
    private Set<ActionEntity> actions;

    @OneToMany(mappedBy = "jeu")
    private Set<MissionEntity> missions;


    public Integer getNumjeu() {
        return numJeu;
    }

    public void setNumjeu(Integer numJeu) {
        this.numJeu = numJeu;
    }

    public String getLibellejeu() {
        return libelleJeu;
    }

    public void setLibellejeu(String libelleJeu) {
        this.libelleJeu = libelleJeu;
    }

    public Set<MissionEntity> getMissions() {
        return missions;
    }

    public Set<ActionEntity> getActions() {
        return actions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JeuEntity jeuEntity = (JeuEntity) o;
        return Objects.equals(numJeu, jeuEntity.numJeu) && Objects.equals(libelleJeu, jeuEntity.libelleJeu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numJeu, libelleJeu);
    }
}
