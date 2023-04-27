package com.examples.demos.servicios;

import com.examples.demos.modelo.Secciones;

import com.examples.demos.repositorios.SeccionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SeccionServicios {
    @Autowired // Inyección de dependencia
    private SeccionRepositorio repositorio;

    public SeccionServicios() {

    }

    public List<Secciones> buscarTodo(){
        return (List<Secciones>) repositorio.findAll();
    }

    public Secciones actualizar(Secciones SeccionesActualizar) {

        Secciones SeccionesActual = repositorio.findById(SeccionesActualizar.getIdSecciones()).get();

        //peliculaActual.setIdPelicula(peliculaActualizar.getIdPelicula());
        SeccionesActual.setDiseño(SeccionesActualizar.getDiseño());
        SeccionesActual.setMobile(SeccionesActualizar.getMobile());
        SeccionesActual.setArquitectura(SeccionesActualizar.getArquitectura());
        SeccionesActual.setQa(SeccionesActualizar.getQa());
        SeccionesActual.setMetodologiasagiles(SeccionesActualizar.getMetodologiasagiles());

        Secciones SeccionesActualizado = repositorio.save(SeccionesActual); // registra en base de datos
        return SeccionesActualizado;

    }


    public Secciones crear(Secciones secciones) {
        return repositorio.save(secciones);
    }

    public Secciones buscarPorId(Integer id) {
        return repositorio.findById(id).get();
    }

    public void borrarPorId(Integer id) {
        repositorio.deleteById(id);

    }

}
