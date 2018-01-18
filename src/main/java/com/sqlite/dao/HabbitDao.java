package com.sqlite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sqlite.entities.Habbit;
import com.sqlite.models.HabbitVo;
@Repository
public interface HabbitDao extends JpaRepository<Habbit, Integer> {

}
