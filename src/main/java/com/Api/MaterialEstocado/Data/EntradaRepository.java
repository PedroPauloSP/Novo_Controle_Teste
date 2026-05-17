package com.Api.MaterialEstocado.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaRepository
        extends JpaRepository<EntradaEntity, Integer> {

    @Query("""
        SELECT COALESCE(SUM(e.quantidade), 0)
        FROM EntradaEntity e
        WHERE e.equipamento.id = :equipamentoId
    """)
    Integer totalEntradas(
            @Param("equipamentoId") Integer equipamentoId
    );
}