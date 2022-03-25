package sn.myapp.gestionvol.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import sn.myapp.gestionvol.dto.EscaleDto;
import sn.myapp.gestionvol.dto.VolDto;
import sn.myapp.gestionvol.persitence.entity.Escale;
import sn.myapp.gestionvol.persitence.entity.Vol;
import sn.myapp.gestionvol.util.DateUtils;

import java.util.Date;

@Mapper
public interface EscaleMapper {

    @Mappings({
            @Mapping(target = "dateArrive", source = "dateArrive", qualifiedByName = "dateTimeToDate"),
            @Mapping(target = "dateDepart", source = "dateDepart", qualifiedByName = "dateTimeToDate"),
            @Mapping(target = "heureArrive", source = "dateArrive", qualifiedByName = "timeWithoutDay"),
            @Mapping(target = "heureDepart", source = "dateDepart", qualifiedByName = "timeWithoutDay"),
            @Mapping(target = "lieuEscale", source = "lieuESsale.nom"),
    })
    EscaleDto escaleToEscaleDto(Escale escale);

    @Named("dateTimeToDate")
    public static String dateTimeToDate(Date date) {
        return DateUtils.dayWithoutTime(date);
    }

    @Named("timeWithoutDay")
    public static String  timeWithoutDay(Date date) {
        return DateUtils.timeWithoutDay(date);
    }
}
