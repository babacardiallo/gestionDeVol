package sn.myapp.gestionvol.persitence.filter;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import constant.GestionVolCst;
import org.springframework.data.repository.query.Param;
import sn.myapp.gestionvol.dto.VolCompareDto;
import sn.myapp.gestionvol.dto.VolSearchFilterDto;
import sn.myapp.gestionvol.persitence.entity.*;
import sn.myapp.gestionvol.util.DateUtils;

import java.util.Date;

public class VolFilter {

    public VolFilter() {

    }

    public static Predicate getSearchFilter(VolSearchFilterDto dto) {

        Predicate filter = null;

        QVol vol = QVol.vol;

        if(dto.getPrix() != 0) {
            filter = ExpressionUtils.and(filter, vol.prix.eq(dto.getPrix()));
        }
        if(dto.isHaveEscale()) {
            filter = ExpressionUtils.and(filter, vol.escales.size().goe(1));
        }
        if(dto.getLieuDepart() != null){
            filter = ExpressionUtils.and(filter, vol.lieuDepart.nom.toLowerCase().eq(dto.getLieuDepart().trim().toLowerCase()));
        }
        if(dto.getLieuArrive() != null){
            filter = ExpressionUtils.and(filter, vol.lieuArrive.nom.toLowerCase().eq(dto.getLieuArrive().trim().toLowerCase()));
        }
        if(dto.getDateDepart() != null) {
            Date depart = DateUtils.startOfDay(dto.getDateDepart());
            Date arr = DateUtils.startOfDay(dto.getDateDepart());
            filter = ExpressionUtils.and(filter,
                    vol.dateDepart.between(
                            DateUtils.startOfDay(dto.getDateDepart()),
                            DateUtils.endOfDay(dto.getDateDepart())
                    )
            );
        }

        if(dto.getDateArrive() != null) {
            filter = ExpressionUtils.and(filter,
                    vol.dateArrive.between(
                            DateUtils.startOfDay(dto.getDateArrive()),
                            DateUtils.endOfDay(dto.getDateArrive())
                    )
            );
        }

        return filter;

    }

    public static Predicate getMinPriceOrDateArriveForSameStartAndSameDestinationTownAndOrSameStartDate(VolCompareDto volCompareDto){



        QVol vol = QVol.vol;

        Predicate filter = null;

        if(volCompareDto.getStartTown() != null){
            filter = ExpressionUtils.and(filter, vol.lieuDepart.nom.toLowerCase().eq(volCompareDto.getStartTown().trim().toLowerCase()));
        }
        if(volCompareDto.getEndTown() != null){
            filter = ExpressionUtils.and(filter, vol.lieuArrive.nom.toLowerCase().eq(volCompareDto.getEndTown().trim().toLowerCase()));
        }
        if(volCompareDto.getStartDate() != null) {
            filter = ExpressionUtils.and(filter, vol.dateDepart.between(DateUtils.startOfDay(volCompareDto.getStartDate()),
                    DateUtils.endOfDay(volCompareDto.getStartDate())));
        }

        return filter;
    }


}
