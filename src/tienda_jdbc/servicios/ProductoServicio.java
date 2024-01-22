/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda_jdbc.servicios;

import java.util.ArrayList;
import tienda_jdbc.entidades.Producto;
import tienda_jdbc.persistencia.ProductoDaoExt;

/**
 *
 * @author Flor Hiembuchner
 */
public class ProductoServicio {
     private ProductoDaoExt dao;

    public ProductoServicio() {
        this.dao= new ProductoDaoExt();
    }
     public void listarNombres() {
        try {
            ArrayList<Producto>prods= new ArrayList<>();
            
           prods= (ArrayList<Producto>) dao.listarProductos();
                System.out.println("Los productos cargados en la base de datos son:");
            for (Producto prod : prods) {
                System.out.println(prod.getNombre());
            }
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
    }
     
     public void listarNombresYPrecios() {
        try {
            ArrayList<Producto>prods= new ArrayList<>();
            
           prods= (ArrayList<Producto>) dao.listarProductosConPrecio();
                System.out.println("Los productos cargados en la base de datos son:");
            for (Producto prod : prods) {
                System.out.println("nombre: " + prod.getNombre() + " precio: " + prod.getPrecio());
            }
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
    }
     
     public void listarProductosConPrecioFiltrado() {
        try {
            ArrayList<Producto>prods= new ArrayList<>();
            
           prods= (ArrayList<Producto>) dao.listarProductosConPrecioFiltrado();
                System.out.println("Los productos cuyos precios varían entre 120 y 202 son: ");
            for (Producto prod : prods) {
                System.out.println("nombre: " + prod.getNombre() + " precio: " + prod.getPrecio());
            }
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
    }
     public void listarPortatiles() {
        try {
            ArrayList<Producto>prods= new ArrayList<>();
            
           prods= (ArrayList<Producto>) dao.listarPortatiles();
                System.out.println("Los portatiles cargados en la base de datos son:");
            for (Producto prod : prods) {
                System.out.println("nombre: " + prod.getNombre() + " precio: " + prod.getPrecio());
            }
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
    }
    public void listarMenorPrecio() {
        try {
            ArrayList<Producto>prods= new ArrayList<>();
            
           prods= (ArrayList<Producto>) dao.listarProductosConPrecioMasBajo();
                System.out.println("El producto más barato es:");
            for (Producto prod : prods) {
                System.out.println("nombre: " + prod.getNombre() + " precio: " + prod.getPrecio());
            }
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
    }
}
