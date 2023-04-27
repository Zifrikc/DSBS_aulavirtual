package com.examples.demos.modelo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name="secciones")
@NamedQueries({
        @NamedQuery(name = "Secciones.findAdll", query = "SELECT p FROM Secciones p")
        ,@NamedQuery(name = "Secciones.findByIdSecciones", query="SELECT p FROM Secciones p WHERE p.idSecciones = :idSecciones")
        ,@NamedQuery(name = "Secciones.findBydiseño", query="SELECT p FROM Secciones p WHERE p.diseño = :diseño")
        ,@NamedQuery(name = "Secciones.findBymobile", query="SELECT p FROM Secciones p WHERE p.mobile = :mobile")
        ,@NamedQuery(name = "Secciones.findByarquitectura", query="SELECT p FROM Secciones p WHERE p.arquitectura = :arquitectura")
        ,@NamedQuery(name = "Secciones.findByqa", query="SELECT p FROM Secciones p WHERE p.qa = :qa")
        ,@NamedQuery(name = "Secciones.findBymetodologiasagiles", query="SELECT p FROM Secciones p WHERE p.metodologiasagiles = :metodologiasagiles")



})
public class Secciones implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false) //representa que este campo es obligatorio en base de datos
    @Column(name ="idsecciones")
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
    public Secciones(Integer idSecciones) {

        this.idSecciones = idSecciones;
  //      this.nombre = nombre;
    }

    public Secciones(String diseño, String mobile, String arquitectura, String qa, String metodologiasagiles) {
        super();
        this.diseño = diseño;
        this.mobile = mobile;
        this.arquitectura = arquitectura;
        this.qa = qa;
        this.metodologiasagiles = metodologiasagiles;
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

    public Integer getIdSecciones() {
        return idSecciones;
    }

    public void setIdSecciones(Integer idSecciones) {
        this.idSecciones = idSecciones;
    }


    @Override
    public int hashCode() {
        return Objects.hash(idSecciones);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Secciones other = (Secciones) obj;
        return Objects.equals(idSecciones, other.idSecciones);
    }
    @Override
    public String toString() {
        return "Secciones [idSecciones=" + idSecciones + "]";
    }


    public Secciones buscarPorID(int i) {
        return null;
    }

}
