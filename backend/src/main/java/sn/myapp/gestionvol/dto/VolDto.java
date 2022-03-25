package sn.myapp.gestionvol.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class VolDto {

    private Long indentifiant;

    private double prix;

    private String dateDepart;

    private String  heureDepart;

    private String dateArrive;

    private String heureArrive;

    private String lieuDepart;

    private String lieuArrive;

    private int nbrEscales;

    private List<EscaleDto> escales = new ArrayList<>();
}