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
import co.edu.uniandes.csw.manda2.entities.ReclamoEntity;
import co.edu.uniandes.csw.manda2.entities.ServicioEntity;
import co.edu.uniandes.csw.manda2.entities.VueltasConDemoraEnOficinaEntity;
import java.util.List;

/**
 * Clase que representa el reclamo.
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "mensaje": string,
 *      "numero": number,
 *      "id": number,
 *      "empleado": [
 *          "nombre": string,
 *          "cedula": string,
 *          "fechaingreso": date,
 *          "calificacion": double,
 *          "id": number,
 *          "identificacion": string,
 *          "foto": string,
 *          "eps: string],
 *      "organizaciones": [ 
 *          "nombre": String,
 *          "puntoDeEncuentro": String,
 *          "puntoDeRealizacion": String,
 *          "calificacion":Double,
 *          "descripcion": String,
 *          "estado": String,
 *          "costoTransporte": double,
 *          "costoDuracion": double,
 *          "costo":double,
 *          "desplazamiento": Boolean],
 *      "vueltasConDemoraEnOficina":[
 *          "costoDeDuracion": Double,
 *          "costoDeTransporte": Double,
 *          "porcentajeExtra": Double,
 *          "id": Long,
 *          "nombre": String,
 *          "costo": Double,
 *          "puntoDeEncuentro": String,
 *          "puntoDeRealizacion": String,
 *          "puntoDeRealizacion": String,
 *          "exitoDiligencia": Boolean,
 *          "calification": Double,
 *          "descripcion": String ],
 *      "comprasEnTienda":[
 *          "costoDeTransporte": Double,
 *          "id": Long,
 *          "nombre": String,
 *          "costo": Double,
 *          "puntoDeEncuentro": String,
 *          "puntoDeRealizacion": String,
 *          "exitoDiligencia": Boolean,
 *          "calification": Double,
 *          "descripcion": String],
 *      "entregasDeDocumentos":[
 *          "costoDeTransporte": Double,
 *          "porcentajeExtra": Double,
 *          "id": Long,
 *          "nombre": String,
 *          "costo": Double,
 *          "puntoDeEncuentro": String,
 *          "puntoDeRealizacion": String,
 *          "puntoDeRealizacion": String,
 *          "exitoDiligencia": Boolean,
 *          "calification": Double,
 *          "descripcion": String]
 * 
 * }
 * </pre> Por ejemplo reclamo se representa así:<br>
 *
 * <pre>
 *      "mensaje": "El servicio se demoro mucho",
 *      "numero": 1,
 *      "id": 1
 *      "empleado" :[
 *          "nombre": "nicolas_caceres",
 *          "cedula": "1014563321",
 *          "fechaingreso": date,
 *          "calificacion": 5.0,
 *          "id": 001,
 *          "identificacion": "nicolascaceres001",
 *          "foto": "nicolascaceres.jpg",
 *          "eps: "millossaludprepagada"],
 *      "organizaciones": [
 *          "nombre": "Concierto Justin B",
 *          "puntoDeEncuentro": "Calle 134#29-93",
 *          "puntoDeRealizacion": "Calle 127#69-02",
 *          "calificacion": 5,
 *          "descripcion": "Quiero una reserva vip",
 *          "estado": "En desarrollo",
 *          "costoTransporte":25000,
 *          "costoDuracion": 65000,
 *          "costo":100000,
 *          "desplazamiento": true],
 *      "vueltasConDemoraEnOficina":[
 *          "costoDeTransporte": 10000,
 *          "id": 345,
 *          "nombre": compra1,
 *          "costo": 30000,
 *          "puntoDeEncuentro":calle 44,
 *          "puntoDeRealizacion": Exito ,
 *          "exitoDiligencia": true,
 *          "calification": 5,
 *          "descripcion": estuvo bien],
 *      "comprasEnTienda":[
 *          "costoDeTransporte": 10000, 
 *          "id": 345,
 *          "nombre": compra1,
 *          "costo": 30000,
 *          "puntoDeEncuentro":calle 44,
 *          "puntoDeRealizacion": Exito ,
 *          "exitoDiligencia":true,
 *          "calification": 5,
 *          "descripcion": estuvo bien],
 *      "entregasDeDocumentos":[
 *          "costoDeTransporte": 10000,
 *          "id": 345,
 *          "nombre": compra1,
 *          "costo": 30000,
 *          "puntoDeEncuentro":calle 44,
 *          "puntoDeRealizacion": Exito ,
 *          "exitoDiligencia": true,
 *          "calification": 5,
 *          "descripcion": estuvo bien]
 *
 * </pre>
 *
 * @author n.bello
 */
public class ReclamoDetailDTO extends ReclamoDTO {

    //ATRIBUTOS
    /**
     * Atributo que representa el empleado conectado con el reclamo
     */
    private EmpleadoDTO empleado;
    /**
     * Servicio de compras en tieneda asociados al reclamo.
     */
    private ComprasEnTiendaDTO comprasEnTienda;

    /**
     * Servicio de entregas de documentos asociados al reclamo.
     */
    private EntregasDeDocumentosDTO entregasDeDocumentos;

    /**
     * Servicio de vueltas con demora en oficina asociados al reclamo.
     */
    private VueltasConDemoraEnOficinaDTO vueltasConDemoraEnOficina;

    /**
     * Servicio de organización asociados al reclamo.
     */
    private OrganizacionDTO organizaciones;

    private ClienteDTO cliente;
    //CONSTRUCTOR

    /**
     * se general el reclamo
     */
    public ReclamoDetailDTO() {
    }

    public ReclamoDetailDTO(ReclamoEntity entity) {
        super(entity);
        this.id = entity.getId();
        if (entity.getCliente() != null) {
            this.cliente = new ClienteDTO(entity.getCliente());
        }
        if (entity.getComprasEnTienda() != null) {
                comprasEnTienda = new ComprasEnTiendaDTO(entity.getComprasEnTienda());
            
        }
        if (entity.getEntregasDeDocumentos() != null) {
            entregasDeDocumentos = new EntregasDeDocumentosDTO(entity.getEntregasDeDocumentos());
            
        }
        if (entity.getOrganizacion() != null){ 
                organizaciones = new OrganizacionDTO(entity.getOrganizacion());
            
        }
        if (entity.getVueltaConDemoraEnOficina() != null) {
            vueltasConDemoraEnOficina = new VueltasConDemoraEnOficinaDTO(entity.getVueltaConDemoraEnOficina());
            
        }
        if (entity.getEmpleado() != null) {
            this.empleado = new EmpleadoDTO(entity.getEmpleado());
        }
    }

    //METODOS
    /**
     * retorna al empleado del reclamo
     *
     * @return empleado del cual se hace el reclamo
     */
    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    /**
     * asigna empleado al reclamo
     *
     * @param empleado el empleado del cual se hace el reclamo
     */
    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }

    public ComprasEnTiendaDTO getComprasEnTienda() {
        return comprasEnTienda;
    }

    public void setComprasEnTienda(ComprasEnTiendaDTO comprasEnTienda) {
        this.comprasEnTienda = comprasEnTienda;
    }

    public EntregasDeDocumentosDTO getEntregasDeDocumentos() {
        return entregasDeDocumentos;
    }

    public void setEntregasDeDocumentos(EntregasDeDocumentosDTO entregasDeDocumentos) {
        this.entregasDeDocumentos = entregasDeDocumentos;
    }

    public VueltasConDemoraEnOficinaDTO getVueltasConDemoraEnOficina() {
        return vueltasConDemoraEnOficina;
    }

    public void setVueltasConDemoraEnOficina(VueltasConDemoraEnOficinaDTO vueltasConDemoraEnOficina) {
        this.vueltasConDemoraEnOficina = vueltasConDemoraEnOficina;
    }

    public OrganizacionDTO getOrganizaciones() {
        return organizaciones;
    }

    public void setOrganizaciones(OrganizacionDTO organizaciones) {
        this.organizaciones = organizaciones;
    }

   

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    @Override
    public ReclamoEntity toEntity() {
        ReclamoEntity entity = new ReclamoEntity();
        entity.setId(id);
        entity.setNumero(numero);
        entity.setMensaje(mensaje);
        entity.setComprasEnTienda(comprasEnTienda.toEntity());
        entity.setEntregasDeDocumentos(entregasDeDocumentos.toEntity());
        entity.setOrganizacion(organizaciones.toEntity());
        entity.setVueltaConDemoraEnOficina(vueltasConDemoraEnOficina.toEntity());
        return entity;
    }
}
