package sn.myapp.gestionvol.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.myapp.gestionvol.persitence.entity.Lieu;

import java.util.Date;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VolSearchFilterDto {

    private double prix;

    private Date dateDepart;

    private Date dateArrive;

    private String lieuDepart;

    private String lieuArrive;

    private boolean haveEscale;

    private PageDto pageDto;
}
