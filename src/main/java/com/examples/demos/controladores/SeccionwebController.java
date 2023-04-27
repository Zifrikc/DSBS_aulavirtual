package com.examples.demos.controladores;

import com.examples.demos.modelo.Secciones;

import com.examples.demos.servicios.SeccionServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/Secciones")
public class SeccionwebController {


    @Autowired // Inyección de Depencia
    private SeccionServicios servicio;


    @RequestMapping("/listarSeccion")
    public String listarSecciones (Model model) {

        List<Secciones> listaSecciones = servicio.buscarTodo();
        System.out.println("Lista de Secciones disponibles : " + listaSecciones);
        model.addAttribute("listaSecciones", listaSecciones);
        return "/moduloSecciones/listarSeccion";

    }

    @RequestMapping("/nuevo")
    public String nuevoSecciones(Model model) {
        Secciones secciones = new Secciones ();
        model.addAttribute("Secciones",secciones);
        return "/moduloSecciones/nuevaSecciones";
    }

    @RequestMapping(value ="/guardar", method= RequestMethod.POST)
    public String crearSecciones(@ModelAttribute("secciones") Secciones secciones) {
        servicio.crear(secciones);
        return "redirect:/Secciones/listarSeccion";

    }

    @RequestMapping(value ="/actualizar/{id}")
    public ModelAndView editarSecciones(@PathVariable(name="id") int id) {
        ModelAndView mav = new ModelAndView("/moduloSecciones/editarSecciones");
        Secciones secciones = servicio.buscarPorId(id);
        mav.addObject("secciones",secciones);
        return mav;
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String elimnarSecciones(@PathVariable(name="id") int id) {
        servicio.borrarPorId(id);
        return "redirect:/Secciones/listarTodo";
    }

}
