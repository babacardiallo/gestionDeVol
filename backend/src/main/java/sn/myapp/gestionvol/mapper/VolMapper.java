package sn.myapp.gestionvol.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import sn.myapp.gestionvol.dto.VolDto;
import sn.myapp.gestionvol.persitence.entity.Escale;
import sn.myapp.gestionvol.persitence.entity.Vol;
import sn.myapp.gestionvol.util.DateUtils;

import java.util.Date;
import java.util.List;


@Mapper
public interface VolMapper {

    @Mappings({
            @Mapping(target = "indentifiant", source = "id"),
            @Mapping(target = "prix", source = "prix"),
            @Mapping(target = "dateDepart", source = "dateDepart", qualifiedByName = "dateTimeToDate"),
            @Mapping(target = "dateArrive", source = "dateArrive", qualifiedByName = "dateTimeToDate"),
            @Mapping(target = "heureDepart", source = "dateDepart", qualifiedByName = "timeWithoutDay"),
            @Mapping(target = "heureArrive", source = "dateArrive", qualifiedByName = "timeWithoutDay"),
            @Mapping(target = "lieuDepart", source = "lieuDepart.nom"),
            @Mapping(target = "lieuArrive", source = "lieuArrive.nom"),
            @Mapping(target = "nbrEscales", source = "escales", qualifiedByName = "escalesToNbrEscales"),
    })
    VolDto volToVolDto(Vol vol);

    @Named("escalesToNbrEscales")
    public static double escalesToNbrEscales(List<Escale> escales) {
        return escales.size();
    }

    @Named("dateTimeToDate")
    public static String dateTimeToDate(Date date) {
        return DateUtils.dayWithoutTime(date);
    }

    @Named("timeWithoutDay")
    public static String  timeWithoutDay(Date date) {
        return DateUtils.timeWithoutDay(date);
    }

}
