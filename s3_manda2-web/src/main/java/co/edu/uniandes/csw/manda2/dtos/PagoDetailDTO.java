/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

import co.edu.uniandes.csw.manda2.entities.PagoEntity;

/**
 * Clase que extiende de {@link PagoDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la ciudad vaya a la documentacion de {@link PagoDTO}
 *
 * @author m.moreno
 */
public class PagoDetailDTO extends PagoDTO {

    /**
     * Servicio de compra en tienda asociado al pago.
     */
    private ComprasEnTiendaDTO compraEnTienda;

    /**
     * Servicio de entrega de documentos asociado al pago.
     */
    private EntregasDeDocumentosDTO entregaDeDocumentos;

    /**
     * Servicio de organización asociado al pago.
     */
    private OrganizacionDTO organizacion;

    /**
     * Servicio de vuelta con demora en oficina asociado al pago.
     */
    private VueltasConDemoraEnOficinaDTO vueltaConDemoraEnOficina;

    /**
     * PayPal asociado al pago.
     */
    private PayPalDTO payPal;

    /**
     * PSE asociado al pago.
     */
    private PSEDTO pse;

    /**
     * Tarjeta de crédito asociada al pago.
     */
    private TarjetaCreditoDTO tarjetaDeCredito;

    /**
     * Cliente que realiza el pago
     */
    private ClienteDTO cliente;

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de ciudad a partir de la cual se construye el
     * objeto
     */
    public PagoDetailDTO(PagoEntity entity) {
        super(entity);

        if (entity != null) {
            if (entity.getPayPal() != null) {
                this.payPal = new PayPalDTO(entity.getPayPal());
            }
            if (entity.getPse() != null) {
                this.pse = new PSEDTO(entity.getPse());
            }
            if (entity.getTarjetaDeCredito() != null) {
                this.tarjetaDeCredito = new TarjetaCreditoDTO(entity.getTarjetaDeCredito());
            }
            if (entity.getCompraEnTienda() != null) {
                this.compraEnTienda = new ComprasEnTiendaDTO(entity.getCompraEnTienda());
            }
            if (entity.getEntregaDeDocumentos() != null) {
                this.entregaDeDocumentos = new EntregasDeDocumentosDTO(entity.getEntregaDeDocumentos());
            }
            if (entity.getOrganizacion() != null) {
                this.organizacion = new OrganizacionDTO(entity.getOrganizacion());
            }
            if (entity.getVueltaConDemoraEnOficina() != null) {
                this.vueltaConDemoraEnOficina = new VueltasConDemoraEnOficinaDTO(entity.getVueltaConDemoraEnOficina());
            }
            if (entity.getCliente() != null) {
                this.cliente = new ClienteDTO(entity.getCliente());
            }
        }
    }

    /**
     * Constructor vacío con llamado al super.
     */
    public PagoDetailDTO() {
        super();
    }

    /**
     * Retorna la compra en tienda asociada al pago.
     *
     * @return compra en tienda asociada al pago.
     */
    public ComprasEnTiendaDTO getCompraEnTienda() {
        return compraEnTienda;
    }

    /**
     * Asigna la compra en tienda al valor dado por parámetro.
     *
     * @param compraEnTienda compra en tienda.
     */
    public void setCompraEnTienda(ComprasEnTiendaDTO compraEnTienda) {
        this.compraEnTienda = compraEnTienda;
    }

    /**
     * Retorna la entrega de documentos al pago.
     *
     * @return entrega de documentos asociada al pago.
     */
    public EntregasDeDocumentosDTO getEntregaDeDocumentos() {
        return entregaDeDocumentos;
    }

    /**
     * Asigna la entrega de documentos al valor dado por parámetro.
     *
     * @param entregaDeDocumentos entrega de documentos.
     */
    public void setEntregaDeDocumentos(EntregasDeDocumentosDTO entregaDeDocumentos) {
        this.entregaDeDocumentos = entregaDeDocumentos;
    }

    /**
     * Retorna organización asociada al pago.
     *
     * @return organización asociada al pago.
     */
    public OrganizacionDTO getOrganizacion() {
        return organizacion;
    }

    /**
     * Asigna la organización al valor dado por parámetro.
     *
     * @param organizacion organización.
     */
    public void setOrganizacion(OrganizacionDTO organizacion) {
        this.organizacion = organizacion;
    }

    /**
     * Retorna la vuelta con demora en oficina asociada al pago.
     *
     * @return vuelta con demora en oficna asociada al pago.
     */
    public VueltasConDemoraEnOficinaDTO getVueltaConDemoraEnOficina() {
        return vueltaConDemoraEnOficina;
    }

    /**
     * Asigna la vuelta con demora en oficina al valor dado por parámetro.
     *
     * @param vueltaConDemoraEnOficina vuelta con demora en oficina.
     */
    public void setVueltaConDemoraEnOficina(VueltasConDemoraEnOficinaDTO vueltaConDemoraEnOficina) {
        this.vueltaConDemoraEnOficina = vueltaConDemoraEnOficina;
    }

    /**
     * Retorna el cliente
     *
     * @return cliente.
     */
    public ClienteDTO getCliente() {
        return cliente;
    }

    /**
     * Asigna el cliente a pCliente.
     *
     * @param pCliente nuevo cliente
     */
    public void setCliente(ClienteDTO pCliente) {
        this.cliente = pCliente;
    }

    /**
     * Retorna el paypal.
     *
     * @return paypal.
     */
    public PayPalDTO getPayPal() {
        return payPal;
    }

    /**
     * Asigna el paypal al valor dado por parámetro.
     *
     * @param payPal nuevo paypal.
     */
    public void setPayPal(PayPalDTO payPal) {
        this.payPal = payPal;
    }

    /**
     * Retorna el pse.
     *
     * @return pse.
     */
    public PSEDTO getPse() {
        return pse;
    }

    /**
     * Asigna el pse al valor dado por parámetro.
     *
     * @param pse nuevo pse.
     */
    public void setPse(PSEDTO pse) {
        this.pse = pse;
    }

    /**
     * Retorna la tarjeta de crédito.
     *
     * @return Tarjeta de crédito.
     */
    public TarjetaCreditoDTO getTarjetaDeCredito() {
        return tarjetaDeCredito;
    }

    /**
     * Asigna la tarjeta de crédito al valor dado por parámetro.
     *
     * @param tarjetaCredito nueva tarjeta de crédito.
     */
    public void setTarjetaDeCredito(TarjetaCreditoDTO tarjetaCredito) {
        this.tarjetaDeCredito = tarjetaCredito;
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return La entidad construida a partir del DTO.
     */
    @Override
    public PagoEntity toEntity() {
        PagoEntity pagoE = super.toEntity();
        if (payPal != null) {
            pagoE.setPayPal(payPal.toEntity());
        }
        if (pse != null) {
            pagoE.setPse(pse.toEntity());
        }
        if (tarjetaDeCredito != null) {
            pagoE.setTarjetaDeCredito(tarjetaDeCredito.toEntity());
        }
        if (compraEnTienda != null) {
            pagoE.setCompraEnTienda(compraEnTienda.toEntity());
        }
        if (entregaDeDocumentos != null) {
            pagoE.setEntregaDeDocumentos(entregaDeDocumentos.toEntity());
        }
        if (organizacion != null) {
            pagoE.setOrganizacion(organizacion.toEntity());
        }
        if (vueltaConDemoraEnOficina != null) {
            pagoE.setVueltaConDemoraEnOficina(vueltaConDemoraEnOficina.toEntity());
        }
        if (cliente != null) {
            pagoE.setCliente(cliente.toEntity());
        }
        return pagoE;
    }
}
