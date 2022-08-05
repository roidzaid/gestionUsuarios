package com.ItRoid.ServicioUsuarios.services;

import com.ItRoid.ServicioUsuarios.entities.RolesEntity;
import com.ItRoid.ServicioUsuarios.exceptions.RolExistenteException;
import com.ItRoid.ServicioUsuarios.exceptions.RolNoRegistradoException;
import com.ItRoid.ServicioUsuarios.models.RolesModel;

public interface RolesService {

    public void crearRol(RolesModel rol) throws RolExistenteException;
    public void deleteRol(RolesModel rol) throws RolNoRegistradoException;

    public RolesEntity buscarRol(RolesModel rol) throws RolNoRegistradoException;
}
