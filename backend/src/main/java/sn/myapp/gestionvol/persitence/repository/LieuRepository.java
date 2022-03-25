package sn.myapp.gestionvol.persitence.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sn.myapp.gestionvol.persitence.entity.Lieu;

@RepositoryRestResource(collectionResourceRel = "lieu", path = "lieu")
public interface LieuRepository extends BaseRepository<Lieu>{
}
