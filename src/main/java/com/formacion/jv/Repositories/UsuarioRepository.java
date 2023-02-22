package com.formacion.jv.Repositories;

import com.formacion.jv.Entity.Usuario;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.ArrayList;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public abstract ArrayList<Usuario> findByUsuario(String usuario);//Debe ser finndBy para que Jpa lo haga correctamente, si usamos otro nombre da error relacionado con la entidad


}
