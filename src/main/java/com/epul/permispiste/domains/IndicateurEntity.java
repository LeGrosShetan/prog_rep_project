package com.epul.permispiste.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "indicateur", schema = "permispiste")
public class IndicateurEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NUMINDIC", nullable = false)
    private Integer numIndic;
    @Basic
    @Column(name = "LIBINDIC", nullable = false, length = 20)
    private String libIndic;
    @Basic
    @Column(name = "POIDS", nullable = false)
    private Integer poids;

    @ManyToOne
    @JoinColumn( name = "NUMACTION")
    private ActionEntity action;

    public Integer getNumindic() {
        return numIndic;
    }

    public void setNumindic(Integer numIndic) {
        this.numIndic = numIndic;
    }

    public String getLibindic() {
        return libIndic;
    }

    public void setLibindic(String libIndic) {
        this.libIndic = libIndic;
    }

    public Integer getPoids() {
        return poids;
    }

    public void setPoids(Integer poids) {
        this.poids = poids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndicateurEntity that = (IndicateurEntity) o;
        return Objects.equals(numIndic, that.numIndic) && Objects.equals(libIndic, that.libIndic) && Objects.equals(poids, that.poids);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numIndic, libIndic, poids);
    }
}
