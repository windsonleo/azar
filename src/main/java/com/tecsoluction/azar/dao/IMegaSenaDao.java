package com.tecsoluction.azar.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tecsoluction.azar.entidade.MegaSena;


@Repository
public interface IMegaSenaDao extends JpaRepository<MegaSena, Long> {
}
