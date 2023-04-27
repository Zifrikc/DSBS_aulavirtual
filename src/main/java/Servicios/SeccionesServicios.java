package Servicios;

import Modelo.Secciones;
import Repositorios.SeccionesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SeccionesServicios {


    @Autowired // Inyección de dependencia
    private SeccionesRepository repositorio;

    public SeccionesServicios() {

    }

    public List<Secciones> buscarTodo(){
        return (List<Secciones>) repositorio.findAll();
    }

    public Secciones secciones(Secciones seccionesActualizar) {

        Secciones seccionesActual = repositorio.findById(seccionesActualizar.getIdSecciones()).get();

        //peliculaActual.setIdPelicula(peliculaActualizar.getIdPelicula());
        seccionesActual.setDiseño(seccionesActualizar.getDiseño());
        seccionesActual.setMobile(seccionesActualizar.getMobile());
        seccionesActual.setArquitectura(seccionesActualizar.getArquitectura());
        seccionesActual.setQa(seccionesActualizar.getQa());
        seccionesActual.setMetodologiasagiles(seccionesActualizar.getMetodologiasagiles());


        Secciones SeccionActualizado = repositorio.save(seccionesActual); // registra en base de datos
        return SeccionActualizado;


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
