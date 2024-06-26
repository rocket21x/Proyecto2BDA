/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOss;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jesus
 */
@Entity
@Table(name="Licencia")
public class Licencia implements Serializable {

    private static final long serialVersionUID = 1L;
   
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NumeroLicencia")
    private Integer numeroLicencia;
    
    @Column(name = "FechaExpedicion")
    private Date fechaExpedicion;
    
    @Column(name = "Vigencia")
    private Integer vigencia;
    
    @Column(name = "Monto", precision = 8, scale = 2)
    private BigDecimal monto;
    
    @Column(name = "Tipo", length = 20)
    private String tipo;
    
    @ManyToOne
    @JoinColumn(name = "RFC")
    private String RFC;
    
    public Licencia() {
        // Constructor vacío requerido por JPA
    }

    public Licencia(Date fechaExpedicion, Integer vigencia, BigDecimal monto, String tipo, String RFC) {
        this.fechaExpedicion = fechaExpedicion;
        this.vigencia = vigencia;
        this.monto = monto;
        this.tipo = tipo;
        this.RFC = RFC;
    }

    public Integer getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(Integer numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroLicencia != null ? numeroLicencia.hashCode() : 0);
        return hash;
    }

//    @Override
//    public boolean equals(Object object) {
//        if (!(object instanceof DTOs.Licencia)) {
//            return false;
//        }
//        DTOs.Licencia other = (DTOs.Licencia) object;
//        if ((this.numeroLicencia == null && other.numeroLicencia != null) || (this.numeroLicencia != null && !this.numeroLicencia.equals(other.numeroLicencia))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "dominio.Licencia[ numeroLicencia=" + numeroLicencia + " ]";
    }
    
}
