/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda_jdbc.entidades;

/**
 *
 * @author Flor Hiembuchner
 */
public class Producto {
    private Integer codigo;
    private String nombre;
    private Double precio;
    private Fabricante fabricante;

    public Producto() {
        this.fabricante= new Fabricante();
    }

    public Producto(Integer codigo, String nombre, Double precio, Fabricante fabricante) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.fabricante = fabricante;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
    
    

   
    
    
    
}
