package com.api.crud.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.crud.models.UserModel;
import com.api.crud.repositorios.IUserRepository;

@Service
public class UserService {

    //Sirve para injectar dependencias
    @Autowired
    IUserRepository userRepository;

    //Metodo que me permite obtener todos los usuarios
    public ArrayList<UserModel> getUsers() {
        //findAll() es un metodo que me permite obtener todos los registros de la tabla
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    //Metodo que me permite guardar un usuario
    public UserModel saveUser(UserModel user) {
        //save() es un metodo que me permite guardar un registro en la tabla
        return userRepository.save(user);
    }

    //Metodo que me permite obtener un usuario por su id
    public Optional<UserModel> getById(Long id) {
        //findById() es un metodo que me permite obtener un registro por su id
        return userRepository.findById(id);
    }

    //Metodo que me permite actualiar un usuario por su id
    public UserModel updateByID(UserModel request, Long id) {
        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con el ID: " + id));

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());

        // Guardar los cambios en la base de datos
        return userRepository.save(user);
    }

    //Metodo que me permite eliminar un usuario por su id
    public Boolean deleteUser (Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
