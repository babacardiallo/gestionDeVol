package sn.myapp.gestionvol.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sn.myapp.gestionvol.dto.VolDto;
import sn.myapp.gestionvol.persitence.entity.Lieu;
import sn.myapp.gestionvol.persitence.repository.LieuRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/lieu")
@CrossOrigin("*")
public class LieuController {

    @Autowired
    private LieuRepository lieuRepository;

    @GetMapping("/all")
    public List<String> getByAll() {
        List<String> listLieu = new ArrayList<>();
        lieuRepository.findAll(Sort.by(Sort.Direction.ASC, "nom")).forEach(lieu -> listLieu.add(lieu.getNom()));
        return listLieu;
    }
}
