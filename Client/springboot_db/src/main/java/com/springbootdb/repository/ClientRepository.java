package com.springbootdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootdb.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
