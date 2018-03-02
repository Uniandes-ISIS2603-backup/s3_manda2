/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.ComprasEnTiendaEntity;
import co.edu.uniandes.csw.manda2.entities.ServicioEntity;
import java.io.Serializable;

/**
 *
 * Clase que representa el servicio de compras en tienda

 * ComprasEnTiendaDTO. Los DTO contienen las
 * representaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "costoDeTransporte": Double,
 *      "pago": PagoDTO,
 *      "cliente": ClienteDTO,
 *      "empleado": Empleado DTO,
 *      "id": Long,
 *      "nombre": String,
 *      "costo": Double,
 *      "puntoDeEncuentro": String,
 *      "puntoDeRealizacion": String,
 *      "puntoDeRealizacion": String,
 *      "exitoDiligencia": Boolean,
 *      "calification": Double,
 *      "descripcion": String,
 *  </pre>
 *   }
 * +
 * @author dv.gonzalez10
 */
public class ComprasEnTiendaDTO extends ServicioDetailDTO  implements Serializable{
    
    //Atributos
    /*
    *El costo del transporte del servicio
    */
    private Double costoDeTransporte;
  

    public ComprasEnTiendaDTO(){
        this(0D, null, null, null, 0L, "", 0D, "", "", false, 0D, "");
    }
    
    /**
     * Constructor
     * @param costoDeTransporte costo relacionado con le costo del transporte 
     * @param pago el pago que el cliente realiza por el servicio 
     * @param cliente el cliente que obtiene el servicio 
     * @param empleado empleado que realiza el servicio
     * @param id id del servicio
     * @param nombre nombre del servicio
     * @param costo costo del servicio
     * @param puntoDeEncuentro punto de encuentro del cliente y empleado
     * @param puntoDeRealizacion punto de realizacion del servicio
     * @param exitoDiligencia indica si la diligencia tuvo o no éxito
     * @param calificacion calificación del servicio.
     * @param descripcion descripción del servicio.
     */
    public ComprasEnTiendaDTO(Double costoDeTransporte, PagoDTO pago, ClienteDTO cliente, EmpleadoDTO empleado, Long id, String nombre, Double costo, String puntoDeEncuentro, String puntoDeRealizacion, Boolean exitoDiligencia, Double calificacion, String descripcion) {
        //super(pago, cliente, empleado, id, nombre, costo, puntoDeEncuentro, puntoDeRealizacion, exitoDiligencia, calificacion, descripcion);
        this.costoDeTransporte = costoDeTransporte;
    }

    public ComprasEnTiendaDTO(ServicioEntity entityServicio) {
        //Completar
    }

    
    //METODOS
      /**
     *Retorna el valor asociado al transporte del servicio
     * @return costoDeTransporte
     */
    public Double getCostoDeTransporte() {
        return costoDeTransporte;
    }

    /**
     * Asigna el valor del costo del transporte
     *  @param costoDeTransporte valor del transporte a modificar
     */
    public void setCostoDeTransporte(Double costoDeTransporte) {
        this.costoDeTransporte = costoDeTransporte;
    } 
    @Override
    public ComprasEnTiendaEntity toEntity()
    {
        // pendiente por completar.
        return null;
    }
}
