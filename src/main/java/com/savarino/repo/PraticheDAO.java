package com.savarino.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.savarino.entities.Pratiche;

public interface PraticheDAO extends JpaRepository<Pratiche, Integer> {

}
