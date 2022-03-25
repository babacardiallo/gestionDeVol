package sn.myapp.gestionvol.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class DataTableDto<T> {
    private int nbResults;
    private List<T> data = new ArrayList<>();
}
