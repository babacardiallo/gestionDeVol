package sn.myapp.gestionvol.persitence.entity;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
@ToString
public class Escale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idlieuscale")
    private Lieu lieuESsale;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "idvol")
    private Vol vol;

    @Column(nullable = false)
    private Date dateArrive;

    @Column(nullable = false)
    private Date dateDepart;


}
