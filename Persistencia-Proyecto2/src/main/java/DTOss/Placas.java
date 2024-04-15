package DTOss;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author eduar
 */
@Entity
public class Placas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String numeroPlacas;
    
    private Date fechaEmision;
    private Date fechaRecepcion;
    private BigDecimal costoTramite;
    private String tipoTramite;
    private String numeroSerieAutomovil; // Cambiado a String para corresponder con la columna en la tabla
    private String rfcPersona; // Cambiado a String para corresponder con la columna en la tabla
    
    public Placas() {
    }

    public Placas(String numeroPlacas, Date fechaEmision, Date fechaRecepcion, BigDecimal costoTramite, String tipoTramite, String numeroSerieAutomovil, String rfcPersona) {
        this.numeroPlacas = numeroPlacas;
        this.fechaEmision = fechaEmision;
        this.fechaRecepcion = fechaRecepcion;
        this.costoTramite = costoTramite;
        this.tipoTramite = tipoTramite;
        this.numeroSerieAutomovil = numeroSerieAutomovil;
        this.rfcPersona = rfcPersona;
    }

    public String getNumeroPlacas() {
        return numeroPlacas;
    }

    public void setNumeroPlacas(String numeroPlacas) {
        this.numeroPlacas = numeroPlacas;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public BigDecimal getCostoTramite() {
        return costoTramite;
    }

    public void setCostoTramite(BigDecimal costoTramite) {
        this.costoTramite = costoTramite;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public String getNumeroSerieAutomovil() {
        return numeroSerieAutomovil;
    }

    public void setNumeroSerieAutomovil(String numeroSerieAutomovil) {
        this.numeroSerieAutomovil = numeroSerieAutomovil;
    }

    public String getRfcPersona() {
        return rfcPersona;
    }

    public void setRfcPersona(String rfcPersona) {
        this.rfcPersona = rfcPersona;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.numeroPlacas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Placas other = (Placas) obj;
        return Objects.equals(this.numeroPlacas, other.numeroPlacas);
    }

    @Override
    public String toString() {
        return "DTOss.Placas[ numeroPlacas=" + numeroPlacas + " ]";
    }

    

    
    
}
