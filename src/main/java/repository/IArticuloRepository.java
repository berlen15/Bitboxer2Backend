package repository;

import entities.Articulo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IArticuloRepository extends CrudRepository<Articulo, Integer> {
    List<Articulo> findByCodigo(int codigo);
    Articulo findOneById(int id);
    Articulo findOneByCodigo(int codigo);
    List<Articulo> findByProveedor(int idProveedor);
}
