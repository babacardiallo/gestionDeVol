package sn.myapp.gestionvol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sn.myapp.gestionvol.dto.*;
import sn.myapp.gestionvol.service.VolService;

@RestController
@RequestMapping(value = "/vol")
@CrossOrigin("*")
public class VolController {

    @Autowired
    private VolService volService;

    @PostMapping("/getAllVols")
    public Mono<DataTableDto<VolDto>> getAllVols(@RequestBody VolSearchFilterDto dto) {
            return volService.getAllVol(dto);
    }

    @GetMapping("/{id}")
    public Mono<VolDto> getById(@PathVariable Long id) {
        return volService.getVolById(id);
    }

    @PostMapping("/compareAllAndGetMinPriceForSameStartAndDestinationAndOrSameStartDate")
    public Flux<VolDto> compareAllGetMinPriceWithSameStartAndDestinationAndOrStartDate
            (@RequestBody VolCompareDto volCompareDto) {
        return volService.getMinPriceForSameStartAndSameDestinationTownAndOrSameStartDate(volCompareDto);
    }

    @PostMapping("/compareAllAndGetMinDateArriveForSameStartAndDestinationAndSameStartDate")
    public Flux<VolDto> compareAllWithSameStartAndDestinationAndStartDate
            (@RequestBody VolCompareDto volCompareDto) {
        return volService.getMinDateArriveForSameStartAndSameDestinationTown(volCompareDto);
    }
}
