/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.manda2.dtos;

/**
 *
 * @author cvtrujillo
 */
public class ArticuloDTO 
{

    public ArticuloDTO(String rutaImagen, String nombre, double precio) {
        this.rutaImagen = rutaImagen;
        this.nombre = nombre;
        this.precio = precio;
    }    
    
    
    /**
     * La ruta de la imágen del artículo
     * */
    private String rutaImagen;
    /**
     * Nombre del articulo
     * */
    private String nombre;
    
    /**
     * El precio del articulo
     * */
    private double precio;
    
    /**
     * Obtener la ruta de la imagen del articulo
     * @return ruta de la imagen
     * */
    public String getRutaImagen()
    {
        return rutaImagen;
    }
    /**
     * Obtener el nombre del articulo
     * @return nombre
     * */
    
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * Obtener el precio del articulo
     * @return precio
     * */
    public double getPrecio()
    {
        return precio;
    }
    /**
     * Establecer la ruta de la imagen del articulo
     * @param rutaIm nueva ruta 
     * */
    
    public void setRutaImagen(String rutaIm)
    {
        this.rutaImagen=rutaIm;
    }
    
    /**
     *  Establecer  el nombre del articulo
     * @param pNombre nuevo nombre
     * */
    public void setNombreArticulo(String pNombre)
    {
      this.nombre=pNombre;  
    }
    
    /**
     *  Establecer el precio del articulo
     * @param pPrecio nuevo precio
     * */
    public void setPrecio(double pPrecio)
    {
        this.precio=pPrecio;
    }
    
    
}
