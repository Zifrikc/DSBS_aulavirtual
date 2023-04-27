package Controladores.rest;

import Modelo.Secciones;
import Servicios.SeccionesServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/secciones")
public class AulaWebController {



    @Autowired // Inyección de Depencia
    private SeccionesServicios servicio;


    @RequestMapping("/Listageneral")
    public String listarPeliculas (Model model) {

        List<Secciones> listaPeliculas = servicio.buscarTodo();
        System.out.println("LISTA DE PELICULAS : " + listaPeliculas);
        model.addAttribute("listaPeliculas", listaPeliculas);
        return "/moduloPeliculas/Listageneral";
    }

    @RequestMapping("/nuevo")
    public String nuevaPelicula(Model model) {
        Secciones pelicula = new Secciones ();
        model.addAttribute("pelicula",pelicula);
        return "/moduloPeliculas/nuevaPelicula";
    }

    @RequestMapping(value ="/guardar", method= RequestMethod.POST)
    public String crearPelicula(@ModelAttribute("pelicula") Secciones secciones) {
        servicio.crear(secciones);
        return "redirect:/secciones/Listageneral";

    }

    @RequestMapping(value ="/actualizar/{id}")
    public ModelAndView editarPelicula(@PathVariable(name="id") int id) {
        ModelAndView mav = new ModelAndView("/moduloPeliculas/editarPelicula");
        Secciones pelicula = servicio.buscarPorId(id);
        mav.addObject("pelicula",pelicula);
        return mav;
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String elimnarPelicula(@PathVariable(name="id") int id) {
        servicio.borrarPorId(id);
        return "redirect:/peliculas/listarTodo";
    }

}
