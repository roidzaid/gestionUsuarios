package com.ItRoid.ServicioUsuarios.services;

import com.ItRoid.ServicioUsuarios.entities.UsuariosEntity;
import com.ItRoid.ServicioUsuarios.exceptions.*;
import com.ItRoid.ServicioUsuarios.models.RecuperarPassModel;
import com.ItRoid.ServicioUsuarios.models.RolesModel;
import com.ItRoid.ServicioUsuarios.models.UsuariosModel;

public interface UsuariosService {

    public void crearUsuario(UsuariosModel usuario) throws UsuarioExistenteException;
    public void deleteUsuario(UsuariosModel usuario) throws UsuarioNoRegistradoException;
    public void agregarRol(String usuario, RolesModel rol) throws UsuarioNoRegistradoException, RolNoRegistradoException, RolYaAsignadoAlUsuarioException;
    public void quitarRol(String usuario, RolesModel rol) throws UsuarioNoRegistradoException, RolNoAsignadoAlUsuarioException, RolNoRegistradoException;
    public UsuariosModel buscarUsuarioLogin(String usuario) throws UsuarioNoRegistradoException;
    public UsuariosEntity buscarUsuario(String usuario) throws UsuarioNoRegistradoException;
    public void updateUsuario(UsuariosModel usuario) throws UsuarioNoRegistradoException;
    public String recuperarPass(RecuperarPassModel recuperarPassModel) throws UsuarioNoRegistradoException, MailNoCoincideconElregistradoException;

}
