package co.edu.uniandes.csw.manda2.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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


    @OneToMany(mappedBy = "organizacion",cascade = CascadeType.ALL, orphanRemoval = false)
    @PodamExclude
    @JoinColumn(nullable = true)
    private List< PagoEntity> pago;
    
    /**
     * Representa si es necesario el desplazamiento de uno de nuestros
     * trabajadores con el fin de cumplir con la diligencia. 0
     */
    private Boolean desplazamiento;

    /**
     * Elementos de la organización.
     */
     @PodamExclude
    @OneToMany
    private List<ElementoBusquedaReservaEntity> elementosBusquedaReserva;

    /**
     * Retorna el pago asociado al servicio.
     * @return pago asociado al servicio.
     */
    public List<PagoEntity> getPago() {
        return pago;
    }

    /**
     * Asigna el pago al dado por parámetro
     * @param pago nuevo pago
     */
    public void setPago(List<PagoEntity> pago) {
        this.pago = pago;
    }
    /**
     * Retorna el costo del transporte del servicio
     *
     * @return costoDeTransporte el costo del transporte.
     */
    public Double getCostoDeTransporte() {
        return costoDeTransporte;
    }

    /**
     * Retorna el costo de la duración del servicio
     *
     * @return costoDeDuracion retorna el costo de la duracion.
     */
    public Double getCostoDeDuracion() {
        return costoDeDuracion;
    }

    /**
     * Establecer el costo del trasnporte a cobrar
     *
     * @param costoDeTransporte el costo del transporte
     */
    public void setCostoDeTransporte(Double costoDeTransporte) {
        this.costoDeTransporte = costoDeTransporte;
    }

    /**
     * Establecer el costo del desplazamiento del servicio
     *
     * @param costoDeDuracion el costo por la duracion.
     */
    public void setCostoDeDuracion(Double costoDeDuracion) {
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


    public List<ElementoBusquedaReservaEntity> getElementosBusquedaReserva() {
        return elementosBusquedaReserva;
    }

    public void setElementosBusquedaReserva(List<ElementoBusquedaReservaEntity> elementosBusquedaReserva) {
        this.elementosBusquedaReserva = elementosBusquedaReserva;
    }
}
