/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.PagoEntity;

import java.util.Date;

/**
 * /**
 * PagoDTO Objeto de transferencia de datos de Pagos. Los DTO contienen las
 * representaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * <p>
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": long,
 *      "estadoTransaccion": string,
 *      "fecha": date
 *   }
 * </pre>
 * Por ejemplo un pago se representa asi:<br>
 *
 * <pre>
 *
 *   {
 *      "id": 91852,
 *      "estadoTransaccion": "cancelado",
 *      "fecha": "02/06/2018"
 *   }
 *
 * </pre>
 *
 * @author m.moreno
 */
public class PagoDTO {


    /**
     * Constante que indica si el pago ha sido finalizado.
     */
    public static final String FINALIZADO = "FINALIZADO";
    /**
     * Constante que indica si el pago ha sido cancelado".
     */
    public static final String CANCELADO = "CANCELADO";


    /**
     * Id del pago
     */
    private Long id;

    /**
     * Indica el estado en el que se encuentra la transaccion
     */
    private String estadoTransaccion;

    /**
     * Fecha en que se realiza el pago
     */
    private Date fecha;

    public PagoDTO() {

    }

    public PagoDTO(PagoEntity entity) {
        if (entity != null) {
            this.id = entity.getId();
            this.estadoTransaccion = entity.getEstadoTransaccion();
            this.fecha = entity.getFecha();


        }
    }

    PagoEntity toEntity() {
        PagoEntity pago = new PagoEntity();
        pago.setId(this.id);
        pago.setEstadoTransaccion(this.estadoTransaccion);
        pago.setFecha(this.fecha);
        return pago;
    }

    /**
     * Retorna el id del pago.
     *
     * @return id de pago.
     */
    public Long getId() {
        return id;
    }

    /**
     * Retorna el estado de transaccion.
     *
     * @return estado de la transaccion.
     */
    public String getEstadoTransaccion() {
        return estadoTransaccion;
    }

    /**
     * Retorna la fecha del pago.
     *
     * @return fecha del pago.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece el id del pago.
     *
     * @param id del pago.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Establece el  estado de la transaccion.
     *
     * @param estado Nuevo estado de pago.
     */
    public void setEstadoTransaccion(String estado) {
        this.estadoTransaccion = estado;
    }

    /**
     * Establece la fecha dada.
     *
     * @param pFecha fecha de el pago.
     */
    public void setFecha(Date pFecha) {
        this.fecha = pFecha;
    }


}
