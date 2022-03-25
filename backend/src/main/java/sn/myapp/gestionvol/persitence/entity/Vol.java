package sn.myapp.gestionvol.persitence.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
@ToString
public class Vol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double prix;

    @Column(nullable = false)
    private Date dateDepart;

    @Column(nullable = false)
    private Date dateArrive;

    @ManyToOne()
    @JoinColumn(name = "idlieudepart")
    private Lieu lieuDepart;

    @ManyToOne()
    @JoinColumn(name = "idlieuarrive")
    private Lieu lieuArrive;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idvol")
    private List<Escale> escales = new ArrayList<>();



}
