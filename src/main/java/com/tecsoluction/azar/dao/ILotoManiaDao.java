package com.tecsoluction.azar.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tecsoluction.azar.entidade.LotoMania;


@Repository
public interface ILotoManiaDao extends JpaRepository<LotoMania, Long> {
}
