package sn.myapp.gestionvol.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sn.myapp.gestionvol.dto.*;
import sn.myapp.gestionvol.persitence.entity.Vol;

public interface VolService {

    Mono<DataTableDto<VolDto>> getAllVol(VolSearchFilterDto dto);

    Flux<VolDto> getMinPriceForSameStartAndSameDestinationTownAndOrSameStartDate(VolCompareDto volCompareDto);

    Flux<VolDto> getMinDateArriveForSameStartAndSameDestinationTown(VolCompareDto volCompareDto);

    Mono<VolDto> getVolById(Long id);

}
