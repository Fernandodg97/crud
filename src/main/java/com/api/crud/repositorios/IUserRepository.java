package com.api.crud.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crud.models.UserModel;

//Clase que me permite realizar las consultas a la base de datos

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {

}
