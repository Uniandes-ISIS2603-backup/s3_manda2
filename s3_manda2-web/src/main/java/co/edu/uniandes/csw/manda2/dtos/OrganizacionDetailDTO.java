/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.ElementoBusquedaReservaEntity;
import co.edu.uniandes.csw.manda2.entities.OrganizacionEntity;
import co.edu.uniandes.csw.manda2.entities.PagoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el empleado.
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "nombre": string,
 *      "cedula": string,
 *      "fechaingreso": date,
 *      "calificacion": number,
 *      "id": number,
 *      "identificacion": string,
 *      "foto": string,
 *      "eps: string,
 *      "pagos" [{}],
 *      "servicios" [{}]
 *   }
 * </pre> Por ejemplo un empleado se representa así:<br>
 *
 * <pre>
 *   {
 *      "nombre": "nicolas_caceres",
 *      "cedula": "1014563321",
 *      "fechaingreso": date,
 *      "calificacion": 5.0,
 *      "id": 001,
 *      "identificacion": "nicolascaceres001",
 *      "foto": "nicolascaceres.jpg",
 *      "eps: "millossaludprepagada",
 *      "pagos"[{
 *       "id": 91852,
 *      "estadoTransaccion: "cancelado",
 *      "fecha": "02/06/2018"}],
 *      "servicios"[{"costoduracion": 15000, "costodetransporte": 25000, "pago": "paypal",
 *      "cliente"[{"id": 001,
 *      "nombre": nicolascaceres,
 *      "cedula": 2104565210,
 *      "fechaDeIngreso": Mayo 21,2017,
 *      "calificacion": 5.0,
 *      "pagoAnticipado": false,
 *      "horasDeServicioSemanal": 5}],
 *      "id":100, "puntodeencuentro": "usaquen", "puntoderealizacion": "usaquen",
 *      "exitodiligencia": true,
 *      "calificacion":5.0, "descripcion": "entregar documentos"
 *      }]
 *   }
 * </pre>
 *
 * @author n.bello
 */
public class OrganizacionDetailDTO extends OrganizacionDTO {

    //ATRIBUTOS
    /**
     * Listado de todos los pagos que ha hecho el empleado
     */
    private List<PagoDTO> pago;

    private List<ElementoBusquedaReservaDTO> elementosBusquedaReserva;

    //CONSTRUCTOR
    /**
     * genera un empleado
     *
     */
    public OrganizacionDetailDTO() {
        super();
        elementosBusquedaReserva = new ArrayList<>();
    }

    public OrganizacionDetailDTO(OrganizacionEntity entity) {
        super(entity);
        elementosBusquedaReserva = new ArrayList<>();
        if (entity != null) {
            this.nombre = entity.getNombre();
            this.costo = entity.getCosto();
            this.puntoDeEncuentro = entity.getPuntoDeEncuentro();
            this.puntoDeRealizacion = entity.getPuntoDeRealizacion();
            this.calificacion = entity.getCalificacion();
            this.descripcion = entity.getDescripcion();
            this.estado = entity.getEstado();
            this.id = entity.getId();
            this.costoDeDuracion = entity.getCostoDeDuracion();
            this.costoDeTransporte = entity.getCostoDeTransporte();
            this.desplazamiento = entity.getDesplazamiento();
        }
        if (entity.getEmpleado() != null) {
            this.empleado = new EmpleadoDTO(entity.getEmpleado());
        }
        if (entity.getPago() != null) {
                this.pago = new ArrayList();
                for (PagoEntity entityPago : entity.getPago()) {
                    pago.add(new PagoDTO(entityPago));
                }
            }
        if (entity.getElementosBusquedaReserva() != null) {
            for (ElementoBusquedaReservaEntity elementoEntity : entity.getElementosBusquedaReserva()) {
                elementosBusquedaReserva.add(new ElementoBusquedaReservaDTO(elementoEntity));
            }
            setElementosBusquedaReserva(elementosBusquedaReserva);
        }

    }

    public Boolean getDesplazamiento() {
        return desplazamiento;
    }

    public void setDesplazamiento(Boolean desplazamiento) {
        this.desplazamiento = desplazamiento;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }

    /**
     * Retorna la lista de pagos del empleado
     *
     * @return la lista de pagos
     */
    public List<PagoDTO> getPago() {
        return pago;
    }

    public void setPago(List<PagoDTO> pago) {
        this.pago = pago;
    }

    public List<ElementoBusquedaReservaDTO> getElementosBusquedaReserva() {
        return elementosBusquedaReserva;
    }

    public void setElementosBusquedaReserva(List<ElementoBusquedaReservaDTO> elementosBusquedaReserva) {
        this.elementosBusquedaReserva = elementosBusquedaReserva;
    }

    @Override
    public OrganizacionEntity toEntity() {
        OrganizacionEntity entity = new OrganizacionEntity();
        entity.setId(id);
        entity.setNombre(nombre);
        entity.setCosto(costo);
        entity.setPuntoDeEncuentro(puntoDeEncuentro);
        entity.setPuntoDeRealizacion(puntoDeRealizacion);
        entity.setCalificacion(calificacion);
        entity.setDescripcion(descripcion);
        entity.setEstado(estado);
        entity.setCostoDeDuracion(costoDeDuracion);
        entity.setCostoDeTransporte(costoDeTransporte);
        entity.setDesplazamiento(desplazamiento);

        if (cliente != null) {
            entity.setCliente(cliente.toEntity());
        }
        if (pago != null) {
            List<PagoEntity> pagosEntity = new ArrayList();
            for (PagoDTO dtoPago : pago) {
                pagosEntity.add(dtoPago.toEntity());
            }
            entity.setPago(pagosEntity);
        }
        if (empleado != null) {
            entity.setEmpleado(empleado.toEntity());
        }
        if(elementosBusquedaReserva!= null)
        {
            ArrayList<ElementoBusquedaReservaEntity> lista = new ArrayList<>();
            for (ElementoBusquedaReservaDTO elemento : elementosBusquedaReserva) {
            lista.add(elemento.toEntity());
        }
            entity.setElementosBusquedaReserva(lista);
        }
        return entity;
    }
}
