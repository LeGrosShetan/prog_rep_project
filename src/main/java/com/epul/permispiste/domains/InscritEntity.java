package com.epul.permispiste.domains;

import javax.persistence.*;

@Entity
@Table(name = "inscrit")
public class InscritEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "NUMJEU", nullable = false)
    private JeuEntity jeu;

    @ManyToOne
    @JoinColumn(name = "NUMAPPRENANT", nullable = false)
    private ApprenantEntity apprenant;

    @ManyToOne
    @JoinColumn(name = "DATEJOUR", nullable = false)
    private CalendrierEntity date;

    public JeuEntity getJeu() {
        return jeu;
    }

    public ApprenantEntity getApprenant() {
        return apprenant;
    }

    public CalendrierEntity getDate() {
        return date;
    }
}
