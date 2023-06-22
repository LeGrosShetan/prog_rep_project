package com.epul.permispiste.domains;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "action", schema = "permispiste")
public class ActionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NUMACTION", nullable = false)
    private Integer numAction;
    @Basic
    @Column(name = "LIBACTION", nullable = false, length = 25)
    private String libAction;

    @ManyToMany
    @JoinTable(
            name = "est_associe",
            joinColumns = @JoinColumn(name = "NUMACTION"),
            inverseJoinColumns = @JoinColumn (name = "NUMOBJECTIF")
    )
    private Set<ObjectifEntity> objectifs;

    @ManyToMany
    @JoinTable(
            name = "possede",
            joinColumns = @JoinColumn(name = "NUMACTION"),
            inverseJoinColumns = @JoinColumn (name = "NUMREGLE")
    )
    private Set<RegleEntity> regles;

    @ManyToOne
    @Column(name = "ACT_NUMACTION")
    @JoinColumn( name = "NUMACTION")
    private ActionEntity successeur;

    @ManyToMany(mappedBy = "actions")
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
