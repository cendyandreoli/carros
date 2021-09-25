package com.app.concessionaria.concessionaria;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConcessionariaRepository extends CrudRepository<Concessionaria, UUID> {
    @Query("SELECT c from Concessionaria c")
    Page<Concessionaria>concessionarias (Pageable pageable);

    @Query("SELECT c FROM Concessionaria c WHERE c.id = :id")
    Concessionaria getById(@Param("id") UUID id);
}
