package sn.myapp.gestionvol.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VolCompareDto {

    private String startTown;
    private String endTown;
    private Date startDate;
}
