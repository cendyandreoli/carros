package com.app.concessionaria.veiculos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface VeiculoRepository extends CrudRepository<Veiculo, UUID> {
    @Query("SELECT c FROM Veiculo c")
    Page<Veiculo> listaDeCarros(Pageable pageable);

    @Query("SELECT c FROM Veiculo c WHERE c.id = :id")
    Veiculo getById(@Param("id") UUID id); //== ?1

}
