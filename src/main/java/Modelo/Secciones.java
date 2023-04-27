package Modelo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

    @Entity
    @Table(name="seccion")
    @NamedQueries({
            @NamedQuery(name = "seccion.findAdll", query = "SELECT p FROM Secciones p")
            ,@NamedQuery(name = "seccion.findByIdSecciones", query="SELECT p FROM Secciones p WHERE p.idSecciones = :idSecciones")
            ,@NamedQuery(name = "seccion.findBydiseño", query="SELECT p FROM Secciones p WHERE p.diseño = :diseño")
            ,@NamedQuery(name = "seccion.findBymobile", query="SELECT p FROM Secciones p WHERE p.mobile = :mobile")
            ,@NamedQuery(name = "seccion.findByarquitectura", query="SELECT p FROM Secciones p WHERE p.arquitectura = :arquitectura")
            ,@NamedQuery(name = "seccion.findByqa", query="SELECT p FROM Secciones p WHERE p.qa = :qa")
            ,@NamedQuery(name = "seccion.findBymetodologiasagiles", query="SELECT p FROM Secciones p WHERE p.metodologiasagiles = :metodologiasagiles")

    })
    public class Secciones implements Serializable {


        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false) //representa que este campo es obligatorio en base de datos
        @Column(name ="idSecciones")
        private Integer idSecciones;

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
        public void setIdPelicula(Integer idSecciones) {
            this.idSecciones = idSecciones;
        }

        public String getDiseño() {
            return diseño;
        }

        public Integer getIdSecciones() {
            return idSecciones;
        }

        public void setIdSecciones(Integer idSecciones) {
            this.idSecciones = idSecciones;
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

        public Secciones(Integer idSecciones, String nombre) {
//
          this.idSecciones = idSecciones;
//        this.nombre = nombre;
       }

        public Secciones(String diseño, String mobile, String arquitectura, String qa, String metodologiasagiles) {
            super();
            this.diseño = diseño;
            this.mobile = mobile;
            this.arquitectura = arquitectura;
            this.qa = qa;
            this.metodologiasagiles = metodologiasagiles;

        }



        @Override
        public String toString() {
            return "Secciones [idSecciones=" + idSecciones + "]";
        }




        public Secciones buscarPorID(int i) {
            return null;
        }

    }
