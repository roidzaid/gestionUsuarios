package com.ItRoid.ServicioUsuarios.controllers;

import com.ItRoid.ServicioUsuarios.exceptions.RolExistenteException;
import com.ItRoid.ServicioUsuarios.exceptions.RolNoRegistradoException;
import com.ItRoid.ServicioUsuarios.exceptions.UsuarioExistenteException;
import com.ItRoid.ServicioUsuarios.models.RolesModel;
import com.ItRoid.ServicioUsuarios.models.UsuariosModel;
import com.ItRoid.ServicioUsuarios.services.RolesService;
import com.ItRoid.ServicioUsuarios.services.UsuariosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("roles")
public class RolesController {

    Logger logger = LoggerFactory.getLogger(RolesController.class);

    @Autowired
    private RolesService rolesService;

    @PostMapping()
    public ResponseEntity<?> guardarRol(@RequestBody RolesModel rolesModel) throws Exception  {

        logger.info("Se guarda rol: " + rolesModel.getRol() + " para aplicacion: " + rolesModel.getAplicacion());

        try {

            this.rolesService.crearRol(rolesModel);

            return new ResponseEntity<String>("Rol creado", HttpStatus.CREATED);

        } catch (RolExistenteException rolExistenteException){
            return new ResponseEntity<String>("Rol existente", HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<String>("Error al crear el Rol", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping()
    public ResponseEntity<?> eliminarRol(@RequestBody RolesModel rolesModel) throws Exception  {

        logger.info("Se borra el rol: " + rolesModel.getRol() + " para aplicacion: " + rolesModel.getAplicacion());

        try {

            this.rolesService.deleteRol(rolesModel);

            return new ResponseEntity<String>("Rol eliminado", HttpStatus.CREATED);

        } catch (RolNoRegistradoException rolNoRegistradoException){
            return new ResponseEntity<String>("Rol no registrado", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<String>("Error al eliminar el Rol", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
