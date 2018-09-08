package com.tecsoluction.azar.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecsoluction.azar.entidade.JogoBicho;
import com.tecsoluction.azar.entidade.MegaSena;


@Repository
public interface IJogoBichoDao extends JpaRepository<JogoBicho, Long> {
}
