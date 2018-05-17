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
import java.util.ArrayList;
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
    private List<ComprasEnTiendaDTO> comprasEnTienda;

    /**
     * Servicio de entregas de documentos asociados al reclamo.
     */
    private List<EntregasDeDocumentosDTO> entregasDeDocumentos;

    /**
     * Servicio de vueltas con demora en oficina asociados al reclamo.
     */
    private List<VueltasConDemoraEnOficinaDTO> vueltasConDemoraEnOficina;

    /**
     * Servicio de organización asociados al reclamo.
     */
    private List<OrganizacionDTO> organizaciones;

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
                List<ComprasEnTiendaDTO> comprasDTO = new ArrayList<>();
                for (ComprasEnTiendaEntity compraEntity : entity.getComprasEnTienda()) {
                    comprasDTO.add(new ComprasEnTiendaDTO(compraEntity));
                }
                this.comprasEnTienda = comprasDTO;
            }
            if (entity.getEntregasDeDocumentos() != null&&!entity.getEntregasDeDocumentos().isEmpty()) {
                List<EntregasDeDocumentosDTO> entregasDTO = new ArrayList<>();
                for (EntregasDeDocumentosEntity entregaEntity : entity.getEntregasDeDocumentos()) {
                    entregasDTO.add(new EntregasDeDocumentosDTO(entregaEntity));
                }
                this.entregasDeDocumentos = entregasDTO;
            }
            if (entity.getOrganizacion() != null) {
                List<OrganizacionDTO> organizacionesDTO = new ArrayList<>();
                for (OrganizacionEntity organizacionEntity : entity.getOrganizacion()) {
                    organizacionesDTO.add(new OrganizacionDTO(organizacionEntity));
                }
                this.organizaciones = organizacionesDTO;
            }
            if (entity.getVueltaConDemoraEnOficina() != null) {
                List<VueltasConDemoraEnOficinaDTO> vueltasDTO = new ArrayList<>();
                for (VueltasConDemoraEnOficinaEntity vueltaEntity : entity.getVueltaConDemoraEnOficina()) {
                    vueltasDTO.add(new VueltasConDemoraEnOficinaDTO(vueltaEntity));
                }
                this.vueltasConDemoraEnOficina = vueltasDTO;
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

    public List<ComprasEnTiendaDTO> getComprasEnTienda() {
        return comprasEnTienda;
    }

    public void setComprasEnTienda(List<ComprasEnTiendaDTO> comprasEnTienda) {
        this.comprasEnTienda = comprasEnTienda;
    }

    public List<EntregasDeDocumentosDTO> getEntregasDeDocumentos() {
        return entregasDeDocumentos;
    }

    public void setEntregasDeDocumentos(List<EntregasDeDocumentosDTO> entregasDeDocumentos) {
        this.entregasDeDocumentos = entregasDeDocumentos;
    }

    public List<VueltasConDemoraEnOficinaDTO> getVueltasConDemoraEnOficina() {
        return vueltasConDemoraEnOficina;
    }

    public void setVueltasConDemoraEnOficina(List<VueltasConDemoraEnOficinaDTO> vueltasConDemoraEnOficina) {
        this.vueltasConDemoraEnOficina = vueltasConDemoraEnOficina;
    }

    public List<OrganizacionDTO> getOrganizaciones() {
        return organizaciones;
    }

    public void setOrganizaciones(List<OrganizacionDTO> organizaciones) {
        this.organizaciones = organizaciones;
    }

   

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    /**
     * Convierte la lista de compras en tienda del DTO a una lista de Entities
     *
     * @return lista de ComprasEnTiendaEntity
     */
    private List<ComprasEnTiendaEntity> comprasListToEntity() {
        ArrayList<ComprasEnTiendaEntity> lista = new ArrayList<>();
        for (ComprasEnTiendaDTO compra : comprasEnTienda) {
            lista.add(compra.toEntity());
        }
        return lista;
    }

    /**
     * Convierte la lista de entregas de documentos del DTO a una lista de
     * Entities
     *
     * @return lista de EntregaDeDocumentosEntity
     */
    private List<EntregasDeDocumentosEntity> entregasListToEntity() {
        ArrayList<EntregasDeDocumentosEntity> lista = new ArrayList<>();
        for (EntregasDeDocumentosDTO entrega : entregasDeDocumentos) {
            lista.add(entrega.toEntity());
        }
        return lista;
    }

    /**
     * Convierte la lista de organizaciones del DTO a una lista de Entities
     *
     * @return lista de OrganizacionEntity
     */
    private List<OrganizacionEntity> organizacionesListToEntity() {
        ArrayList<OrganizacionEntity> lista = new ArrayList<>();
        for (OrganizacionDTO organizacion : organizaciones) {
            lista.add(organizacion.toEntity());
        }
        return lista;
    }

    /**
     * Convierte la lista de vueltas con demora del DTO a una lista de Entities
     *
     * @return lista de VueltasConDemoraEnOficinaEntity
     */
    private List<VueltasConDemoraEnOficinaEntity> vueltasListToEntity() {
        ArrayList<VueltasConDemoraEnOficinaEntity> lista = new ArrayList<>();
        for (VueltasConDemoraEnOficinaDTO vuelta : vueltasConDemoraEnOficina) {
            lista.add(vuelta.toEntity());
        }
        return lista;
    }
    
    @Override
    public ReclamoEntity toEntity() {
        ReclamoEntity entity = new ReclamoEntity();
        entity.setId(id);
        entity.setNumero(numero);
        entity.setMensaje(mensaje);
         if(comprasEnTienda!= null)
        entity.setComprasEnTienda(comprasListToEntity());
        if(entregasDeDocumentos!= null&& !entregasDeDocumentos.isEmpty())
        entity.setEntregasDeDocumentos(entregasListToEntity());
        if(organizaciones!= null)
        entity.setOrganizacion(organizacionesListToEntity());
        if(vueltasConDemoraEnOficina!= null)
        entity.setVueltaConDemoraEnOficina(vueltasListToEntity());
        if (cliente != null) {
            entity.setCliente(cliente.toEntity());
        }
        if (empleado != null)
        {
            entity.setEmpleado(empleado.toEntity());
        }
        return entity;
    }
}
