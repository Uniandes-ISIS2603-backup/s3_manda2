/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.ComprasEnTiendaEntity;
import co.edu.uniandes.csw.manda2.entities.EmpleadoEntity;
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
public class EmpleadoDetailDTO extends EmpleadoDTO{
    //ATRIBUTOS
    /**
     * Listado de todos los pagos que ha hecho el empleado
     */
    private List<PagoDTO> pagos;
     /**
     * Listado de todos los servicios del empleado
     */
    private List<ServicioDetailDTO>servicios;
    //CONSTRUCTOR
    /**
     * genera un empleado
     **/
    public EmpleadoDetailDTO()
    {   
        super();
        pagos = new ArrayList<PagoDTO>();
        servicios = new ArrayList<ServicioDetailDTO>();
    }

    public EmpleadoDetailDTO(EmpleadoEntity entity) {
        super(entity);
        if(entity !=null)
        {
            this.id = entity.getId();
            this.nombre = entity.getNombre();
            this.cedula = entity.getCedula();
            this.calificacion = entity.getCalificacion();
            this.fechaIngreso = entity.getFechaIngreso();
            if (entity.getServicios() != null) {
               this.servicios = new ArrayList();
                for (ServicioEntity entityServicio : entity.getServicios()) {
                   if( entityServicio instanceof EntregasDeDocumentosEntity)
                   {
                        servicios.add(new EntregasDeDocumentosDTO((EntregasDeDocumentosEntity) entityServicio));
                   }
                   else if( entityServicio instanceof ComprasEnTiendaEntity)
                   {
                        servicios.add(new ComprasEnTiendaDTO((ComprasEnTiendaEntity) entityServicio));
                   }
                   else if( entityServicio instanceof VueltasConDemoraEnOficinaEntity)
                   {
                        servicios.add(new VueltasConDemoraEnOficinaDTO((VueltasConDemoraEnOficinaEntity) entityServicio));
                   }
                   else if( entityServicio instanceof OrganizacionEntity)
                   {
                        servicios.add(new OrganizacionDTO((OrganizacionEntity) entityServicio));
                   }
                }
            }
            
            if (entity.getPagos() != null) {
                this.pagos = new ArrayList();
                for (PagoEntity entityPago : entity.getPagos()) {
                    pagos.add(new PagoDTO(entityPago));
                }
            }
        }
    }
   
    /**
     * Retorna la lista de pagos del empleado
     * @return la lista de pagos
     */
    public List<PagoDTO> getPagos() {
        return pagos;
    }
    /**
     * se asigna la lista de pagos al empleado
     * @param pagos Lista de pagos != null
     */
    
    public void setPagos(List<PagoDTO> pagos) {
        this.pagos = pagos;
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
        ArrayList<ServicioEntity> lista = new ArrayList<ServicioEntity>();
        for (ServicioDetailDTO servicio : servicios) {
            lista.add(servicio.toEntity());
        }
        return lista;
    }
     public List<PagoEntity> pagoListToEntity()
    {
        ArrayList<PagoEntity> lista = new ArrayList<PagoEntity>();
        for (PagoDTO pago : pagos) {
            lista.add(pago.toEntity());
        }
        return lista;
    }
     @Override
    public EmpleadoEntity toEntity() {
     EmpleadoEntity entity = new EmpleadoEntity();
     entity.setNombre(nombre);
     entity.setCedula(cedula);
     entity.setFechaIngreso(fechaIngreso);
     entity.setCedula(cedula);
     entity.setId(id);
     entity.setIdentificacio(identificacion);
     entity.setFoto(foto);
     entity.setEPS(EPS);
     entity.setCalificacion(calificacion);
     entity.setServicios(servicioListToEntity());
     entity.setPagos(pagoListToEntity());
     return entity;
    }
    
}
