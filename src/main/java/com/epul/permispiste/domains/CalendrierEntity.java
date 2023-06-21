package com.epul.permispiste.domains;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "calendrier", schema = "permispiste")
public class CalendrierEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "DATEJOUR", nullable = false)
    private Date datejour;

    public Date getDatejour() {
        return datejour;
    }

    public void setDatejour(Date datejour) {
        this.datejour = datejour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendrierEntity that = (CalendrierEntity) o;
        return Objects.equals(datejour, that.datejour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datejour);
    }
}
