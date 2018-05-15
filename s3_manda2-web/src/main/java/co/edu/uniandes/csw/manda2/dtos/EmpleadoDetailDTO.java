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
import co.edu.uniandes.csw.manda2.entities.ReclamoEntity;
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
public class EmpleadoDetailDTO extends EmpleadoDTO {

    //ATRIBUTOS
    /**
     * Listado de todos los pagos que ha hecho el empleado.
     */
    private List<PagoDTO> pagos;

    /**
     * Reclamos del empleado.
     */
    private List<ReclamoDTO> reclamos;

    /**
     * Servicios de compras en tieneda asociados al empleado.
     */
    private List<ComprasEnTiendaDTO> comprasEnTienda;

    /**
     * Servicios de entregas de documentos asociados al empleado.
     */
    private List<EntregasDeDocumentosDTO> entregasDeDocumentos;

    /**
     * Servicios de vueltas con demora en oficina asociados al empleado.
     */
    private List<VueltasConDemoraEnOficinaDTO> vueltasConDemoraEnOficina;

    /**
     * Servicios de organización asociados al empleado.
     */
    private List<OrganizacionDTO> organizaciones;

    //CONSTRUCTOR
    /**
     * genera un empleado
     *
     */
    public EmpleadoDetailDTO() {
        super();
        pagos = new ArrayList<>();
        comprasEnTienda = new ArrayList<>();
        entregasDeDocumentos = new ArrayList<>();
        vueltasConDemoraEnOficina = new ArrayList<>();
        organizaciones = new ArrayList<>();
    }

    /**
     * Constructor de un EmpleadoDetailDTO a partir de un EmpleadoEntity.
     *
     * @param entity EmpleadoEntity.
     */
    public EmpleadoDetailDTO(EmpleadoEntity entity) {
        super(entity);
        if (entity != null) {
            this.id = entity.getId();
            this.nombre = entity.getNombre();
            this.cedula = entity.getCedula();
            this.calificacion = entity.getCalificacion();
            this.fechaIngreso = entity.getFechaIngreso();
            this.login = entity.getLogin();
            if (entity.getComprasEnTienda() != null) {
                List<ComprasEnTiendaDTO> comprasDTO = new ArrayList<>();
                for (ComprasEnTiendaEntity compraEntity : entity.getComprasEnTienda()) {
                    comprasDTO.add(new ComprasEnTiendaDTO(compraEntity));
                }
                this.comprasEnTienda = comprasDTO;
            }
            if (entity.getEntregasDeDocumentos() != null) {
                List<EntregasDeDocumentosDTO> entregasDTO = new ArrayList<>();
                for (EntregasDeDocumentosEntity entregaEntity : entity.getEntregasDeDocumentos()) {
                    entregasDTO.add(new EntregasDeDocumentosDTO(entregaEntity));
                }
                this.entregasDeDocumentos = entregasDTO;
            }
            if (entity.getOrganizaciones() != null) {
                List<OrganizacionDTO> organizacionesDTO = new ArrayList<>();
                for (OrganizacionEntity organizacionEntity : entity.getOrganizaciones()) {
                    organizacionesDTO.add(new OrganizacionDTO(organizacionEntity));
                }
                this.organizaciones = organizacionesDTO;
            }
            if (entity.getVueltasConDemoraEnOficina() != null) {
                List<VueltasConDemoraEnOficinaDTO> vueltasDTO = new ArrayList<>();
                for (VueltasConDemoraEnOficinaEntity vueltaEntity : entity.getVueltasConDemoraEnOficina()) {
                    vueltasDTO.add(new VueltasConDemoraEnOficinaDTO(vueltaEntity));
                }
                this.vueltasConDemoraEnOficina = vueltasDTO;
            }
            if (entity.getPagos() != null) {
                this.pagos = new ArrayList<>();
                for (PagoEntity entityPago : entity.getPagos()) {
                    pagos.add(new PagoDTO(entityPago));
                }
            }
            if (entity.getReclamos() != null) {
                this.reclamos = new ArrayList<>();
                for (ReclamoEntity reclamo : entity.getReclamos()) {
                    reclamos.add(new ReclamoDTO(reclamo));
                }
            }
        }
    }

    /**
     * Retorna la lista de pagos del empleado
     *
     * @return la lista de pagos
     */
    public List<PagoDTO> getPagos() {
        return pagos;
    }

    /**
     * se asigna la lista de pagos al empleado
     *
     * @param pagos Lista de pagos != null
     */
    public void setPagos(List<PagoDTO> pagos) {
        this.pagos = pagos;
    }

    /**
     * Retorna los reclamos del empleado.
     *
     * @return reclamos del empleado
     */
    public List<ReclamoDTO> getReclamos() {
        return reclamos;
    }

    /**
     * Asigna los reclamos al valor dado por parámtetro.
     *
     * @param reclamos reclamos
     */
    public void setReclamos(List<ReclamoDTO> reclamos) {
        this.reclamos = reclamos;
    }

    /**
     * Retorna los servicios de compras en tienda asociados al empleado.
     *
     * @return compras en tienda
     */
    public List<ComprasEnTiendaDTO> getComprasEnTienda() {
        return comprasEnTienda;
    }

    /**
     * Asigna las compras en tienda al valor dado por parámetro
     *
     * @param comprasEnTienda compras en tienda
     */
    public void setComprasEnTienda(List<ComprasEnTiendaDTO> comprasEnTienda) {
        this.comprasEnTienda = comprasEnTienda;
    }

    /**
     * Retorna los servicios entregas de documentos asociados al empleado.
     *
     * @return entregas de documentos
     */
    public List<EntregasDeDocumentosDTO> getEntregasDeDocumentos() {
        return entregasDeDocumentos;
    }

    /**
     * Asigna las entregas de documentos al valor dado por parámetro
     *
     * @param entregasDeDocumentos entregas de documentos.
     */
    public void setEntregasDeDocumentos(List<EntregasDeDocumentosDTO> entregasDeDocumentos) {
        this.entregasDeDocumentos = entregasDeDocumentos;
    }

    /**
     * Retorna los servicios de vueltas con demora en oficina asociados al
     * empleado.
     *
     * @return vueltas con demora en oficina
     */
    public List<VueltasConDemoraEnOficinaDTO> getVueltasConDemoraEnOficina() {
        return vueltasConDemoraEnOficina;
    }

    /**
     * Asigna las vueltas con demora en oficina al valor dado por parámetro
     *
     * @param vueltasConDemoraEnOficina vueltas con demora en oficina
     */
    public void setVueltasConDemoraEnOficina(List<VueltasConDemoraEnOficinaDTO> vueltasConDemoraEnOficina) {
        this.vueltasConDemoraEnOficina = vueltasConDemoraEnOficina;
    }

    /**
     * Retorna los servicios de organizacion asociados al empleado.
     *
     * @return organizaciones
     */
    public List<OrganizacionDTO> getOrganizaciones() {
        return organizaciones;
    }

    /**
     * Asigna las organizaciones al valor dado por parámetro
     *
     * @param organizaciones organizaciones
     */
    public void setOrganizaciones(List<OrganizacionDTO> organizaciones) {
        this.organizaciones = organizaciones;
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

    /**
     * Convierte la lista de pagos del DTO a una lista de Entities
     *
     * @return lista de PagoEntity
     */
    private List<PagoEntity> pagoListToEntity() {
        ArrayList<PagoEntity> lista = new ArrayList();
        for (PagoDTO pago : pagos) {
            lista.add(pago.toEntity());
        }
        return lista;
    }

    /**
     * Convierte la lista de reclamosdel DTO a una lista de Entities
     *
     * @return lista de ReclamoEntity
     */
    private List<ReclamoEntity> reclamosListToEntity() {
        ArrayList<ReclamoEntity> lista = new ArrayList<>();
        for (ReclamoDTO reclamo : reclamos) {
            lista.add(reclamo.toEntity());
        }
        return lista;
    }

    /**
     * Conviete el DTO a un Entity
     *
     * @return EmpleadoEntity
     */
    @Override
    public EmpleadoEntity toEntity() {
        EmpleadoEntity entity = new EmpleadoEntity();
        entity.setNombre(nombre);
        entity.setCedula(cedula);
        entity.setFechaIngreso(fechaIngreso);
        entity.setCedula(cedula);
        entity.setId(id);
        entity.setIdentificacion(identificacion);
        entity.setFoto(foto);
        entity.setEps(eps);
        entity.setCalificacion(calificacion);
        entity.setComprasEnTienda(comprasListToEntity());
        entity.setEntregasDeDocumentos(entregasListToEntity());
        entity.setOrganizaciones(organizacionesListToEntity());
        entity.setVueltasConDemoraEnOficina(vueltasListToEntity());
        entity.setPagos(pagoListToEntity());
        entity.setLogin(login);
        entity.setReclamos(reclamosListToEntity());
        return entity;
    }
}
