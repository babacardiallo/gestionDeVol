package sn.myapp.gestionvol.persitence.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "lieu",
        indexes = { @Index(name = "ixnom", columnList = "nom") })
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
@ToString
public class Lieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;


}
