package com.Api.MaterialEstocado.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SaidaRepository
        extends JpaRepository<SaidaEntity, Integer> {

    @Query("""
        SELECT COALESCE(SUM(s.quantidade), 0)
        FROM SaidaEntity s
        WHERE s.equipamento.id = :equipamentoId
    """)
    Integer totalSaidas(
            @Param("equipamentoId") Integer equipamentoId
    );
}