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
     * Listado de todos los pagos que ha hecho el empleado
     */
    private List<PagoDTO> pagos;

    private List<ComprasEnTiendaDTO> comprasEnTienda;

    private List<EntregasDeDocumentosDTO> entregasDeDocumentos;

    private List<VueltasConDemoraEnOficinaDTO> vueltasConDemoraEnOficina;

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
                this.pagos = new ArrayList();
                for (PagoEntity entityPago : entity.getPagos()) {
                    pagos.add(new PagoDTO(entityPago));
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

    public List<ComprasEnTiendaEntity> comprasListToEntity() {
        ArrayList<ComprasEnTiendaEntity> lista = new ArrayList<>();
        for (ComprasEnTiendaDTO compra : comprasEnTienda) {
            lista.add(compra.toEntity());
        }
        return lista;
    }

    public List<EntregasDeDocumentosEntity> entregasListToEntity() {
        ArrayList<EntregasDeDocumentosEntity> lista = new ArrayList<>();
        for (EntregasDeDocumentosDTO entrega : entregasDeDocumentos) {
            lista.add(entrega.toEntity());
        }
        return lista;
    }

    public List<OrganizacionEntity> organizacionesListToEntity() {
        ArrayList<OrganizacionEntity> lista = new ArrayList<>();
        for (OrganizacionDTO organizacion : organizaciones) {
            lista.add(organizacion.toEntity());
        }
        return lista;
    }

    public List<VueltasConDemoraEnOficinaEntity> vueltasListToEntity() {
        ArrayList<VueltasConDemoraEnOficinaEntity> lista = new ArrayList<>();
        for (VueltasConDemoraEnOficinaDTO vuelta : vueltasConDemoraEnOficina) {
            lista.add(vuelta.toEntity());
        }
        return lista;
    }

    public List<PagoEntity> pagoListToEntity() {
        ArrayList<PagoEntity> lista = new ArrayList();
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
        entity.setIdentificacion(identificacion);
        entity.setFoto(foto);
        entity.setEPS(EPS);
        entity.setCalificacion(calificacion);
        entity.setComprasEnTienda(comprasListToEntity());
        entity.setEntregasDeDocumentos(entregasListToEntity());
        entity.setOrganizaciones(organizacionesListToEntity());
        entity.setVueltasConDemoraEnOficina(vueltasListToEntity());
        entity.setPagos(pagoListToEntity());
        entity.setLogin(login);
        return entity;
    }
}
