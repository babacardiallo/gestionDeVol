package sn.myapp.gestionvol.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageDto {

    private int pageNumber;
    private int pageSize;


}
