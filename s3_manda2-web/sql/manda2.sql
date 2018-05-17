/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  na.caceres
 * Created: 16/05/2018
 */
delete from USUARIOENTITY_PAGOENTITY;
delete from SERVICIOENTITY_ARTICULOENTITY;
delete from ARTICULOENTITY;
update SERVICIOENTITY set PAGO_ID = null WHERE ID = 1000;
delete from PAGOENTITY;
delete from MEDIOPAGOENTITY;
delete from SERVICIOENTITY;
delete from USUARIOENTITY;
delete from BILLETERAENTITY;




delete from ELEMENTOBUSQUEDARESERVAENTITY;
delete from RECLAMOENTITY;
/** cliente1*/

insert into BILLETERAENTITY (ID, PUNTOSDEFIDELIDAD, SALDO) values (1000,100,3700.0);

insert into MEDIOPAGOENTITY (ID, DTYPE, NOMBRECLIENTE, LINKPAYPAL, PAYPALS_ID) values (1000, 'PayPalEntity','Pablo Emilio Acosta','http://www.paypal.com/users/pabloEmilioAcosta',1000);

insert into MEDIOPAGOENTITY (ID, DTYPE, NOMBRECLIENTE, LINKPSE, PSES_ID) values (2000, 'PSEEntity','Pablo Emilio Acosta','http://www.pse.com.co/users/pabloEmilioAcosta',1000);

insert into MEDIOPAGOENTITY (ID, DTYPE, NOMBRECLIENTE, NUMEROTARJETA, TARJETASDECREDITO_ID) values (3000, 'TarjetaCreditoEntity','Pablo Emilio Acosta','4506686675942095',1000);

insert into USUARIOENTITY (ID,DTYPE,CALIFICACION,CEDULA,FECHAINGRESO,LOGIN,NOMBRE,HORASDESERVICIOSEMANAL,PAGOANTICIPADO,BILLETERA_ID) values (1000,'ClienteEntity',5.0,'1020839175','2012-04-23','pacosta','Pablo Emilio Acosta',20,1,1000);
/** empleado1 */
insert into USUARIOENTITY (ID, DTYPE, CALIFICACION, CEDULA, FECHAINGRESO, LOGIN, NOMBRE, EPS, FOTO, IDENTIFICACION, PAGOANTICIPADO) values (2000,'EmpleadoEntity', 5.0, '1020839170','2011-04-23', 'asuarez', 'Alfonso Suarez Velez', 'Colsanitas', 'data/images/munequito.png', 'AlfonsoSuarez001',0);
/** servicio1 */
insert into SERVICIOENTITY (ID, DTYPE, CALIFICACION, COSTO, DESCRIPCION, ESTADO, NOMBRE, PUNTODEENCUENTRO, PUNTODEREALIZACION, CLIENTE_ID, EMPLEADO_ID, COSTODETRANSPORTE, PORCENTAJEEXTRA,DESPLAZAMIENTO) values (1000, 'EntregasDeDocumentosEntity', 4.0, 15000, 'Llevar carta a gerente general', 'FINALIZADO','Entrega de documento a bancolombia','Pan Pa Ya 116','Bancolombia calle 72',1000,2000,8000,0.3,0);
/** pago 1 asociado a cliente 1, a servicio 1 y a usuario1 */
insert into PAGOENTITY (ID, ESTADOTRANSACCION, FECHA,CLIENTE_ID,ENTREGADEDOCUMENTOS_ID, PAYPAL_ID) values (1000, 'ACTIVO','2012-04-24', 1000,1000,1000);

update SERVICIOENTITY set PAGO_ID = 1000 WHERE ID = 1000;

insert into USUARIOENTITY_PAGOENTITY (EMPLEADOENTITY_ID , PAGOS_ID) values (1000,1000);

insert into USUARIOENTITY_PAGOENTITY (EMPLEADOENTITY_ID , PAGOS_ID) values (2000,1000);

/**  servicio2 No esta pago*/

insert into SERVICIOENTITY (ID, DTYPE, CALIFICACION, COSTO, DESCRIPCION, ESTADO, NOMBRE, PUNTODEENCUENTRO, PUNTODEREALIZACION, CLIENTE_ID, EMPLEADO_ID, COSTODETRANSPORTE, COSTODEDURACION ,DESPLAZAMIENTO) values (2000, 'VueltasConDemoraEnOficinaEntity', 3.0, 18000, 'Pague los impuestos 2018', 'EN_DESARROLLO','Vuelta en banco de bogota','Archies 116','Banco de bogota calle 68',1000,2000,10000,14000,0);

/**  Articulo1 */

insert into ARTICULOENTITY (ID,NOMBREARTICULO,PRECIO,RUTAIMAGEN) values(1000,'morcilla', 5000, 'data/images/morcilla');

/** Servicio3 No esta pago*/
insert into SERVICIOENTITY (ID, DTYPE, CALIFICACION, COSTO, DESCRIPCION, ESTADO, NOMBRE, PUNTODEENCUENTRO, PUNTODEREALIZACION, CLIENTE_ID, EMPLEADO_ID, COSTODETRANSPORTE,DESPLAZAMIENTO) values (3000, 'ComprasEnTiendaEntity', 2.0, 9000, 'Compra de morcilla en doña juana', 'EN_DESARROLLO','Compra de alimentos','Doña Juana cra 68','Universidad de los Andes',1000,2000,11000,0);

insert into SERVICIOENTITY_ARTICULOENTITY (COMPRASENTIENDAENTITY_ID, ARTICULO_ID) values (3000, 1000);
