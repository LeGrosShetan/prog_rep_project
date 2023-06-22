package com.epul.permispiste.domains;

import javax.persistence.*;

@Entity
@Table(name = "obtient")
public class ObtentionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "NUMACTION")
    private ActionEntity action;

    @ManyToOne
    @JoinColumn(name = "NUMAPPRENANT")
    private ApprenantEntity apprenant;

    @ManyToOne
    @JoinColumn(name = "DATEJOUR")
    private CalendrierEntity date;

    private Integer valeurDebut;

    private Integer valeurFin;
}
