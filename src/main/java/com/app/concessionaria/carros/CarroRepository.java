package com.app.concessionaria.carros;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface CarroRepository extends CrudRepository<Carro, UUID> {
    @Query("SELECT c FROM Carro c")
    Page<Carro> listaDeCarros(Pageable pageable);

    @Query("SELECT c FROM Carro c WHERE c.id = :id")
    Carro getById(@Param("id") UUID id); //== ?1

}
