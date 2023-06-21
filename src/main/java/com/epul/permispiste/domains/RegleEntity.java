package com.epul.permispiste.domains;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "regle", schema = "permispiste")
public class RegleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NUMREGLE", nullable = false)
    private Integer numRegle;
    @Basic
    @Column(name = "LIBREGLE", nullable = false, length = 25)
    private String libRegle;
    @Basic
    @Column(name = "SCOREMIN", nullable = false)
    private Integer scoreMin;

    @ManyToMany(mappedBy = "regles")
    private Set<ActionEntity> actions;

    public Integer getNumregle() {
        return numRegle;
    }

    public void setNumregle(Integer numRegle) {
        this.numRegle = numRegle;
    }

    public String getLibregle() {
        return libRegle;
    }

    public void setLibregle(String libRegle) {
        this.libRegle = libRegle;
    }

    public Integer getScoremin() {
        return scoreMin;
    }

    public void setScoremin(Integer scoreMin) {
        this.scoreMin = scoreMin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegleEntity that = (RegleEntity) o;
        return Objects.equals(numRegle, that.numRegle) && Objects.equals(libRegle, that.libRegle) && Objects.equals(scoreMin, that.scoreMin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numRegle, libRegle, scoreMin);
    }
}
