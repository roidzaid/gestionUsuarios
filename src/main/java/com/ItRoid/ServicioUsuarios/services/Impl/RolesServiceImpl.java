package com.ItRoid.ServicioUsuarios.services.Impl;

import com.ItRoid.ServicioUsuarios.entities.RolesEntity;
import com.ItRoid.ServicioUsuarios.exceptions.RolExistenteException;
import com.ItRoid.ServicioUsuarios.exceptions.RolNoRegistradoException;
import com.ItRoid.ServicioUsuarios.exceptions.UsuarioNoRegistradoException;
import com.ItRoid.ServicioUsuarios.models.RolesModel;
import com.ItRoid.ServicioUsuarios.repositories.RolesRepository;
import com.ItRoid.ServicioUsuarios.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public void crearRol(RolesModel rol) throws RolExistenteException {

        RolesEntity r = this.rolesRepository.findByRol(rol.getRol(), rol.getAplicacion());

        if(r==null){
            RolesEntity rolNuevo = new RolesEntity(
                    rol.getRol(),
                    rol.getAplicacion()
            );


            this.rolesRepository.save(rolNuevo);
        }else {
            throw new RolExistenteException();

        }

    }

    @Override
    public void deleteRol(RolesModel rol) throws RolNoRegistradoException {

        RolesEntity r = this.rolesRepository.findByRol(rol.getRol(), rol.getAplicacion());

        if(r!=null){
            this.rolesRepository.delete(r);
        }else{
            throw new RolNoRegistradoException();
        }

    }

    @Override
    public RolesEntity buscarRol(RolesModel rol) throws RolNoRegistradoException {

        RolesEntity r = this.rolesRepository.findByRol(rol.getRol(), rol.getAplicacion());

        if(r!=null){
           return r;
        }else{
            throw new RolNoRegistradoException();
        }

    }
}
