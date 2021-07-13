package com.co.pragma.foto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.co.pragma.foto.entity.Foto;

@Repository
public interface IntFotoRepository extends MongoRepository<Foto,Long>{

}
