/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.entities;
import co.edu.uniandes.csw.manda2.podam.DateStrategy;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author m.moreno
 */

@Entity
public class PagoEntity extends BaseEntity implements Serializable {
    
///**
//     * Id del pago
//     */
//    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private Long id; 

  /**
     * Indica el estado en el que se encuentra la transaccion
     */
    private String estadoTransaccion;
    
     /**
     * Fecha en que se realiza el pago
     */
    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    private Date fecha; 
     /**
     *  Atributo que modela el medio de pago ddl pago
     * 
     */
    @PodamExclude
    @OneToOne
    private MedioPagoEntity medioPago;
    
     /**
     *  Atributo que modela el empleado conoce el pago
     * 
     */
    @PodamExclude
    @ManyToOne
    private EmpleadoEntity empleado;
    
       /**
     *  Atributo que modela el empleado conoce el pago
     * 
     */
    @PodamExclude
    @OneToOne
    private ServicioEntity servicio;
       /**
     *  Atributo que modela el empleado conoce el pago
     * 
     */
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;
//  /**
//     * Retorna el id del pago.
//     * @return id de pago.
//     */
//    public Long getId(){
//        return id;
//    }
//    
    /**
     * Retorna el estado de transaccion.
     * @return estado de la transaccion.
     */
    public String getEstadoTransaccion(){
        return estadoTransaccion;
    }
    /**
     * Retorna la fecha del pago.
     * @return fecha del pago.
     */
    public Date getFecha(){
        return fecha;
    }
//     /**
//     * Establece el id del pago.
//     * @param id del pago.
//     */
//    public void setId(Long id){
//        this.id = id;
//    }
     /**
     * Establece el  estado de la transaccion.
     * @param estado Nuevo estado de pago.
     */
    public void setEstadoTransaccion(String estado)
    {
        this.estadoTransaccion = estado;
    }
    /**
     * Establece la fecha dada.
     * @param pFecha fecha de el pago.
     */
    public void setFecha (Date pFecha){
        this.fecha = pFecha;
    }
     /**
     * @return the medio pago
     */
    public MedioPagoEntity getMedioPago() {
        return medioPago;
    }

    /**
     * @param medio the medioPago to set
     */
    public void setMedioPago(MedioPagoEntity medio) {
        this.medioPago =medio;
    }
    
     /**
     * @return the Cliente
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * @param medio the medioPago to set
     */
    public void setCliente(ClienteEntity Cliente) {
        this.cliente =cliente;
    }
        /**
     * @return the Servicio
     */
    public ServicioEntity getServicio() {
        return servicio;
    }

    /**
     * @param servicio Servicio
     */
    public void setServicio(ServicioEntity servicio) {
        this.servicio =servicio;
    }
}

