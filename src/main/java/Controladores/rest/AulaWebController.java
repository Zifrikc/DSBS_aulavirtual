package Controladores.rest;

import Modelo.Secciones;
import Servicios.SeccionesServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/secciones")
public class AulaWebController {



    @Autowired // Inyección de Depencia
    private SeccionesServicios servicio;


    @RequestMapping("/Listageneral")
    public ResponseEntity<Object> listarSecciones (Model model) {

        List<Secciones> listaSecciones = servicio.buscarTodo();
        System.out.println("LISTA DE PELICULAS : " + listaSecciones);
        return new ResponseEntity<>(listaSecciones, HttpStatus.OK);
       // model.addAttribute("listaSecciones", listaSecciones);
       // return "/moduloSecciones/Listageneral";
    }

    @RequestMapping("/nuevo")
    public String nuevaSecciones(Model model) {
        Secciones secciones = new Secciones ();
        model.addAttribute("pelicula",secciones);
        return "/moduloPeliculas/nuevaPelicula";
    }

    @RequestMapping(value ="/guardar", method= RequestMethod.POST)
    public String crearSeccion(@ModelAttribute("seccion") Secciones secciones) {
        servicio.crear(secciones);
        return "redirect:/secciones/Listageneral";

    }

    @RequestMapping(value ="/actualizar/{id}")
    public ModelAndView editarSeccion(@PathVariable(name="id") int id) {
        ModelAndView mav = new ModelAndView("/moduloSecciones/editarSecciones");
        Secciones seccion = servicio.buscarPorId(id);
        mav.addObject("seccion",seccion);
        return mav;
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String elimnarPelicula(@PathVariable(name="id") int id) {
        servicio.borrarPorId(id);
        return "redirect:/secciones/listarTodo";
    }

}
