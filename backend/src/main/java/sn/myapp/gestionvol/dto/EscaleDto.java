package sn.myapp.gestionvol.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EscaleDto {


    private String dateArrive;

    private String heureArrive;

    private String dateDepart;

    private String  heureDepart;

    private String lieuEscale;

}
