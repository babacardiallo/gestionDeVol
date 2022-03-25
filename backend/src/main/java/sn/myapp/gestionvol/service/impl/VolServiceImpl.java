package sn.myapp.gestionvol.service.impl;

import com.querydsl.core.types.dsl.Expressions;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sn.myapp.gestionvol.dto.*;
import sn.myapp.gestionvol.mapper.EscaleMapper;
import sn.myapp.gestionvol.mapper.VolMapper;
import sn.myapp.gestionvol.persitence.entity.Vol;
import sn.myapp.gestionvol.persitence.filter.VolFilter;
import sn.myapp.gestionvol.persitence.repository.VolRepository;
import sn.myapp.gestionvol.service.VolService;
import sn.myapp.gestionvol.util.DateUtils;

import java.util.List;

@Service
public class VolServiceImpl implements VolService {

    @Autowired
    private VolRepository volRepository;

    private final VolMapper mapper = Mappers.getMapper(VolMapper.class);

    private final EscaleMapper escaleMapper = Mappers.getMapper(EscaleMapper.class);


    @Override
    public Mono<DataTableDto<VolDto>> getAllVol(VolSearchFilterDto volSearchFilterDto) {
        DataTableDto<VolDto>  dataTableDto = new DataTableDto<>();
        Flux.fromIterable(
                volRepository.findAll(
                        volSearchFilterDto != null && VolFilter.getSearchFilter(volSearchFilterDto) != null ?
                                VolFilter.getSearchFilter(volSearchFilterDto): Expressions.asBoolean(true).isTrue(),
                        PageRequest.of(volSearchFilterDto != null ? volSearchFilterDto.getPageDto().getPageNumber():0,
                                volSearchFilterDto != null ? volSearchFilterDto.getPageDto().getPageSize():10, Sort.by(Sort.Direction.ASC, "lieuDepart.nom"))
                )).map(mapper::volToVolDto)
                .doOnNext(dto -> dataTableDto.getData().add(dto))
                .reduce(0, (nbResult, dto) -> {
                    nbResult+=1;
                    return nbResult;
                })
                .doOnNext(dataTableDto::setNbResults)
                 .block();

         return Mono.just(dataTableDto);

    }

    @Override
    public Mono<VolDto> getVolById(Long id) {
        Vol vol = volRepository.findById(id).orElse(null);
        VolDto dto = mapper.volToVolDto(vol);
        vol.getEscales()
        .forEach(escale -> {
            dto.getEscales().add(escaleMapper.escaleToEscaleDto(escale));
        });
        return Mono.just(dto);
    }

    @Override
    public Flux<VolDto> getMinPriceForSameStartAndSameDestinationTownAndOrSameStartDate(VolCompareDto volCompareDto) {

        List<Vol> vols = (List<Vol>) volRepository.findAll(
                VolFilter.getMinPriceOrDateArriveForSameStartAndSameDestinationTownAndOrSameStartDate(volCompareDto),
                Sort.by(Sort.Direction.ASC, "prix")
        );
        return Flux.fromIterable(vols).map(mapper::volToVolDto);
    }

    @Override
    public Flux<VolDto> getMinDateArriveForSameStartAndSameDestinationTown(VolCompareDto volCompareDto) {
        List<Vol> vols = (List<Vol>) volRepository.findAll(
                VolFilter.getMinPriceOrDateArriveForSameStartAndSameDestinationTownAndOrSameStartDate(volCompareDto),
                Sort.by(Sort.Direction.ASC, "dateArrive")
        );
        return Flux.fromIterable(vols).map(mapper::volToVolDto);
    }



}
