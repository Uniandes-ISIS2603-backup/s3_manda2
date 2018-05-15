/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.ClienteEntity;
import co.edu.uniandes.csw.manda2.entities.ComprasEnTiendaEntity;
import co.edu.uniandes.csw.manda2.entities.EntregasDeDocumentosEntity;
import co.edu.uniandes.csw.manda2.entities.OrganizacionEntity;
import co.edu.uniandes.csw.manda2.entities.PagoEntity;
import co.edu.uniandes.csw.manda2.entities.ReclamoEntity;
import co.edu.uniandes.csw.manda2.entities.ServicioEntity;
import co.edu.uniandes.csw.manda2.entities.VueltasConDemoraEnOficinaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que extiende de {@link ClienteDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la ciudad vaya a la documentacion de {@link ClienteDTO} Al
 * serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "nombre": string,
 *      "cedula": string,
 *      "fechaDeIngreso": date,
 *      "calificacion": Double,
 *      "pagoAnticipado": boolean,
 *      "horasDeServicioSemanal": number,
 *
 *      "quejasYReclamos": [{
 *      "mensaje": string,
 *      "numero": number,
 *      "id": number
 *   }],
 *      "servicios": [{
 *      "costoDeTransporte": 500,
 *      "id": Long,
 *      "nombre": String,
 *      "costo": Double,
 *      "puntoDeEncuentro": String,
 *      "puntoDeRealizacion": String,
 *      "exitoDiligencia": Boolean,
 *      "calification": Double,
 *      "descripcion": String,
 * }],
 *      "pagos": [{
 *      "id": long,
 *      "estadoTransaccion: string,
 *      "fecha": date
 *   }],
 *      "billetera" [{
 *      "saldo": Double,
 *      "puntosFidelidad": integer
 *   }]
 *   }
 * </pre> Por ejemplo un cliente detallado se representa asi:<br>
 *
 * <pre>
 *
 *   {
 *      "id": 084156584,
 *      "nombre": "Nicolas Bello",
 *      "cedula": "1020839175",
 *      "fechaDeIngreso": 15/07/06,
 *      "calificacion": 5,
 *      "pagoAnticipado": false,
 *      "horasDeServicioSemanal": 20,
 *      "quejasYReclamos": [{
 *      "mensaje": "El servicio se demoro mucho",
 *      "numero": 001,
 *   }],
 *      "servicios": [{
 *      "costoDeTransporte": 500,
 *      "id": 525252145256,
 *      "nombre": "Nicolas Bello",
 *      "costo": 58455452,
 *      "puntoDeEncuentro": "C.C mazuren",
 *      "puntoDeRealizacion": "Las vegas",
 *      "exitoDiligencia": true,
 *      "calification": 5,
 *      "descripcion": "Hamburguesa grande",
 * }],
 *      "pagos": ["id": 91852,
 *      "estadoTransaccion: "cancelado",
 *      "fecha": "02/06/2018"],
 *      "billetera" [{
 *      "saldo": 37000,
 *      "puntosFidelidad": "100"
 *   }]
 *   }
 *
 * </pre>
 *
 * @author na.caceres
 */
public class ClienteDetailDTO extends ClienteDTO {

    //Atributos
    /**
     * Atributo que representa la billetera que tiene cada usuario.
     */
    private BilleteraDTO billetera;
    /**
     * Servicios de compras en tieneda asociados al cliente.
     */
    private List<ComprasEnTiendaDTO> comprasEnTienda;

    /**
     * Servicios de entregas de documentos asociados al cliente.
     */
    private List<EntregasDeDocumentosDTO> entregasDeDocumentos;

    /**
     * Servicios de vueltas con demora en oficina asociados al cliente.
     */
    private List<VueltasConDemoraEnOficinaDTO> vueltasConDemoraEnOficina;

    /**
     * Servicios de organización asociados al cliente.
     */
    private List<OrganizacionDTO> organizaciones;
    /**
     * Atributo que modela una lista con todos los pagos contratados por un
     * usuario.
     */
    private List<PagoDTO> pagos;
    /**
     * Atributo que modela una lista con todos los reclamos hechos por un
     * usuario.
     */
    private List<ReclamoDTO> quejasYReclamos;

    //Constructor
    /**
     * Constructor por defecto
     */
    public ClienteDetailDTO() {
        super();
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de ciudad a partir de la cual se construye el
     * objeto
     */
    public ClienteDetailDTO(ClienteEntity entity) {

        super(entity);
        if (entity != null) {        
            
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
            if (entity.getQuejasYReclamos() != null) {
                this.quejasYReclamos = new ArrayList();
                for (ReclamoEntity entityReclamo : entity.getQuejasYReclamos()) {
                    quejasYReclamos.add(new ReclamoDTO(entityReclamo));
                }
            }
            if(entity.getBilletera()!= null)
            {
                billetera = new BilleteraDTO (entity.getBilletera());
            }
            else
                billetera = null;
            
        }
        
    }

    //Metodos
    /**
     * @return the billetera
     */
    public BilleteraDTO getBilletera() {
        return billetera;
    }

    /**
     * @param billetera the billetera to set
     */
    public void setBilletera(BilleteraDTO billetera) {
        this.billetera = billetera;
    }

    /**
     * @return the pagos
     */
    public List<PagoDTO> getPagos() {
        return pagos;
    }

    /**
     * @param pagos the pagos to set
     */
    public void setPagos(List<PagoDTO> pagos) {
        this.pagos = pagos;
    }

    /**
     * @return the quejasYReclamos
     */
    public List<ReclamoDTO> getQuejasYReclamos() {
        return quejasYReclamos;
    }

    /**
     * @param quejasYReclamos the quejasYReclamos to set
     */
    public void setQuejasYReclamos(List<ReclamoDTO> quejasYReclamos) {
        this.quejasYReclamos = quejasYReclamos;
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
     * Transformar un DTO a un Entity
     *
     * @return La entidad construida a partir del DTO.
     */
    @Override
    public ClienteEntity toEntity() {
        ClienteEntity clienteE = super.toEntity();
        //Esto se arreglara en el ciclo 3 ya que los to entity de alguna clases fallan.
        
        if (billetera != null) {
            clienteE.setBilletera(billetera.toEntity());
        }
        else
            clienteE.setBilletera(null);
        if(comprasEnTienda!= null)
        clienteE.setComprasEnTienda(comprasListToEntity());
        if(entregasDeDocumentos!= null&& !entregasDeDocumentos.isEmpty())
        clienteE.setEntregasDeDocumentos(entregasListToEntity());
        if(organizaciones!= null)
        clienteE.setOrganizaciones(organizacionesListToEntity());
        if(vueltasConDemoraEnOficina!= null)
        clienteE.setVueltasConDemoraEnOficina(vueltasListToEntity());
        if (pagos != null) {
            List<PagoEntity> pagosEntity = new ArrayList();
            for (PagoDTO dtoPago : pagos) {
                pagosEntity.add(dtoPago.toEntity());
            }
            clienteE.setPagos(pagosEntity);
        }
        if (quejasYReclamos != null) {
            List<ReclamoEntity> reclamosEntity = new ArrayList();
            for (ReclamoDTO dtoReclamo : quejasYReclamos) {
                reclamosEntity.add(dtoReclamo.toEntity());
            }
            clienteE.setQuejasYReclamos(reclamosEntity);
        }
     
        return clienteE;
    }
}
