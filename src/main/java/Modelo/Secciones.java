package Modelo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

    @Entity
    @Table(name="seccion")
    @NamedQueries({
            @NamedQuery(name = "seccion.findAdll", query = "SELECT p FROM Secciones p")
            ,@NamedQuery(name = "seccion.findBydiseño", query="SELECT p FROM Secciones p WHERE p.diseño = :diseño")
            ,@NamedQuery(name = "seccion.findBymobile", query="SELECT p FROM Secciones p WHERE p.mobile = :mobile")
            ,@NamedQuery(name = "seccion.findByarquitectura", query="SELECT p FROM Secciones p WHERE p.arquitectura = :arquitectura")
            ,@NamedQuery(name = "Pelicula.findByqa", query="SELECT p FROM Secciones p WHERE p.qa = :qa")
            ,@NamedQuery(name = "Pelicula.findBymetodologiasagiles", query="SELECT p FROM Secciones p WHERE p.metodologiasagiles = :metodologiasagiles")

    })
    public class Secciones implements Serializable {


        private static final long serialVersionUID = 1L;

        @Basic(optional = false)
        @Column(name ="diseño")
        private String diseño;

        @Column(name="mobile")
        private String mobile;

        @Column(name= "arquitectura")
        private String arquitectura;

        @Column(name="qa")
        private String qa;

        @Column(name= "metodologiasagiles")
        private String metodologiasagiles;


        public Secciones() {

        }

        public String getDiseño() {
            return diseño;
        }

        public void setDiseño(String diseño) {
            this.diseño = diseño;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getArquitectura() {
            return arquitectura;
        }

        public void setArquitectura(String arquitectura) {
            this.arquitectura = arquitectura;
        }

        public String getQa() {
            return qa;
        }

        public void setQa(String qa) {
            this.qa = qa;
        }

        public String getMetodologiasagiles() {
            return metodologiasagiles;
        }

        public void setMetodologiasagiles(String metodologiasagiles) {
            this.metodologiasagiles = metodologiasagiles;
        }

 //       public Secciones(Integer idPelicula, String nombre) {
//
//            this.idPelicula = idPelicula;
//        this.nombre = nombre;
 //       }

        public Secciones(String diseño, String mobile, String arquitectura, String qa, String metodologiasagiles) {
            super();
            this.diseño = diseño;
            this.mobile = mobile;
            this.arquitectura = arquitectura;
            this.qa = qa;
            this.metodologiasagiles = metodologiasagiles;

        }





        public Secciones buscarPorID(int i) {
            return null;
        }

    }
