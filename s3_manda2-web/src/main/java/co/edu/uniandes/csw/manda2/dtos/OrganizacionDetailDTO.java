/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.ComprasEnTiendaEntity;
import co.edu.uniandes.csw.manda2.entities.OrganizacionEntity;
import co.edu.uniandes.csw.manda2.entities.EntregasDeDocumentosEntity;
import co.edu.uniandes.csw.manda2.entities.OrganizacionEntity;
import co.edu.uniandes.csw.manda2.entities.PagoEntity;
import co.edu.uniandes.csw.manda2.entities.ServicioEntity;
import co.edu.uniandes.csw.manda2.entities.VueltasConDemoraEnOficinaEntity;
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
 * </pre>
 * Por ejemplo un empleado se representa así:<br>
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
 * @author n.bello
 */
public class OrganizacionDetailDTO extends OrganizacionDTO{
    //ATRIBUTOS
    /**
     * Listado de todos los pagos que ha hecho el empleado
     */
    private PagoDTO pago;
     /**
     * Listado de todos los servicios del empleado
     */
    private List<ServicioDetailDTO>servicios;
    //CONSTRUCTOR
    /**
     * genera un empleado
     **/
    public OrganizacionDetailDTO()
    {   
    }

    public OrganizacionDetailDTO(OrganizacionEntity entity) {
        super(entity);
        if(entity !=null)
        {
            this.nombre = entity.getNombre();
            this.costo = entity.getCosto();
            this.puntoDeEncuentro=entity.getPuntoDeEncuentro();
            this.puntoDeRealizacion= entity.getPuntoDeRealizacion();
            this.calificacion = entity.getCalificacion();
            this.descripcion=entity.getDescripcion();
            this.estado = entity.getEstado();
            this.id = entity.getId();       
            this.costoDeDuracion=entity.getCostoDeDuracion();
            this.costoDeTransporte=entity.getCostoDeTransporte();
            this.desplazamiento=entity.getDesplazamiento();
            if (entity.getCliente() != null) {
                this.cliente = new ClienteDTO(entity.getCliente());
            }
            if (entity.getEmpleado() != null) {
                this.empleado = new EmpleadoDTO(entity.getEmpleado());
            }
            if (entity.getPago() != null) {
                this.pago = new PagoDTO(entity.getPago());
            }
        }
    }
   
    /**
     * Retorna la lista de pagos del empleado
     * @return la lista de pagos
     */
    public PagoDTO getPagos() {
        return pago;
    }
    /**
     * se asigna la lista de pagos al empleado
     * @param pagos Lista de pagos != null
     */
    
    public void setPagos(PagoDTO pagos) {
        this.pago = pagos;
    }
    /**
     * retorna la lista de servicios del empleado
     * @return servicios Lista de servicios del empleado
     **/ 
    public List<ServicioDetailDTO> getServicios() {
        return servicios;
    }
    /**
     * Lista de servicios que se le va a asignar 
     * @param servicios llega la lista de servicios para asignar !=null
     */
    
    public void setServicios(List<ServicioDetailDTO> servicios) {
        this.servicios = servicios;
    }
    public List<ServicioEntity> servicioListToEntity()
    {
        ArrayList<ServicioEntity> lista = new ArrayList();
        for (ServicioDetailDTO servicio : servicios) {
            lista.add(servicio.toEntity());
        }
        return lista;
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
     return entity;
    }
   
}
