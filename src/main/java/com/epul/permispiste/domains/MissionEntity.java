package com.epul.permispiste.domains;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "mission", schema = "permispiste")
public class MissionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NUMMISSION", nullable = false)
    private Integer numMission;
    @Basic
    @Column(name = "LIBELLEMISSION", nullable = false, length = 25)
    private String libMission;

    @ManyToMany
    @JoinTable(
            name = "fixe",
            joinColumns = @JoinColumn(name = "NUMMISSION"),
            inverseJoinColumns = @JoinColumn (name = "NUMOBJECTIF")
    )
    private Set<ObjectifEntity> objectifs;

    @ManyToOne
    @JoinColumn(name = "NUMJEU", nullable = false)
    private JeuEntity jeu;

    public Integer getNummission() {
        return numMission;
    }

    public void setNummission(Integer numMission) {
        this.numMission = numMission;
    }

    public String getLibellemission() {
        return libMission;
    }

    public void setLibellemission(String libMission) {
        this.libMission = libMission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MissionEntity that = (MissionEntity) o;
        return Objects.equals(numMission, that.numMission) && Objects.equals(libMission, that.libMission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numMission, libMission);
    }
}
