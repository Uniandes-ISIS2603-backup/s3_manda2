package co.edu.uniandes.csw.manda2.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author cv.trujillo
 */
@Entity
public class OrganizacionEntity extends ServicioEntity implements Serializable {

    /**
     * Costo del transporte para hacer el mandado de éste tipo
     */
    private Double costoDeTransporte;

    /**
     * Costo que se le cobra al usuario, por la duración que se tiene al hacer
     * el servicio.
     */
    private Double costoDeDuracion;

    /**
     * Representa si es necesario el desplazamiento de uno de nuestros
     * trabajadores con el fin de cumplir con la diligencia. 0
     */
    private Boolean desplazamiento;

    /**
     * Elementos de la organización.
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="ORGANIZACION_ID", nullable = true)
    @PodamExclude
    private List<ElementoBusquedaReservaEntity> elementosBusquedaReserva;

    /**
     * Retorna el costo del transporte del servicio
     *
     * @return costoDeTransporte el costo del transporte.
     */
    public Double getCostoTransporte() {
        return costoDeTransporte;
    }

    /**
     * Retorna el costo de la duración del servicio
     *
     * @return costoDeDuracion retorna el costo de la duracion.
     */
    public Double getCostoDuracion() {
        return costoDeDuracion;
    }

    /**
     * Establecer el costo del trasnporte a cobrar
     *
     * @param costoDeTransporte el costo del transporte
     */
    public void setCostoTransporte(Double costoDeTransporte) {
        this.costoDeTransporte = costoDeTransporte;
    }

    /**
     * Establecer el costo del desplazamiento del servicio
     *
     * @param costoDeDuracion el costo por la duracion.
     */
    public void setCostoDuracion(Double costoDeDuracion) {
        this.costoDeDuracion = costoDeDuracion;
    }

    /**
     * Verifica si el sericio requiere de un desplazamiento
     *
     * @return desplazamiento true si desplazo, false lo contrario
     */
    public Boolean getDesplazamiento() {
        return desplazamiento;
    }

    /**
     * Establecer el desplazamiento, en caso de ser requerido
     *
     * @param desplazamiento a recorer
     */
    public void setDesplazamiento(Boolean desplazamiento) {
        this.desplazamiento = desplazamiento;
    }

    public Double getCostoDeTransporte() {
        return costoDeTransporte;
    }

    public void setCostoDeTransporte(Double costoDeTransporte) {
        this.costoDeTransporte = costoDeTransporte;
    }

    public Double getCostoDeDuracion() {
        return costoDeDuracion;
    }

    public void setCostoDeDuracion(Double costoDeDuracion) {
        this.costoDeDuracion = costoDeDuracion;
    }

    public List<ElementoBusquedaReservaEntity> getElementosBusquedaReserva() {
        return elementosBusquedaReserva;
    }

    public void setElementosBusquedaReserva(List<ElementoBusquedaReservaEntity> elementosBusquedaReserva) {
        this.elementosBusquedaReserva = elementosBusquedaReserva;
    }
}
