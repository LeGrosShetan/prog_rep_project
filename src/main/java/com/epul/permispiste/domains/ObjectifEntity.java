package com.epul.permispiste.domains;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "objectif", schema = "permispiste")
public class ObjectifEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NUMOBJECTIF", nullable = false)
    private Integer numObjectif;
    @Basic
    @Column(name = "LIBOBJECTIF", nullable = false, length = 25)
    private String libObjectif;

    @ManyToMany(mappedBy = "objectifs")
    private Set<ActionEntity> actions;

    @ManyToMany(mappedBy = "objectifs")
    private Set<MissionEntity> missions;



    public Integer getNumobjectif() {
        return numObjectif;
    }

    public void setNumobjectif(Integer numObjectif) {
        this.numObjectif = numObjectif;
    }

    public String getLibobjectif() {
        return libObjectif;
    }

    public void setLibobjectif(String libObjectif) {
        this.libObjectif = libObjectif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectifEntity that = (ObjectifEntity) o;
        return Objects.equals(numObjectif, that.numObjectif) && Objects.equals(libObjectif, that.libObjectif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numObjectif, libObjectif);
    }
}
