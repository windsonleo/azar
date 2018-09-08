package com.tecsoluction.azar.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tecsoluction.azar.entidade.Lotofacil;


@Repository
public interface ILotoFacilDao extends JpaRepository<Lotofacil, Long> {
}
