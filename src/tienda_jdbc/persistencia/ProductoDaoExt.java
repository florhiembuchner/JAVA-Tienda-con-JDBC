/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda_jdbc.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda_jdbc.entidades.Producto;

/**
 *
 * @author Flor Hiembuchner
 */
public class ProductoDaoExt extends DAO{
    
    public Collection<Producto> listarProductos() throws Exception {
        try {
            String sql = "SELECT nombre FROM producto ";

            consultarBase(sql);

            Producto producto= null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
        
        public Collection<Producto> listarProductosConPrecio() throws Exception {
        try {
            String sql = "SELECT nombre,precio FROM producto ";

            consultarBase(sql);

            Producto producto= null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                
                
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
        }
        
        public Collection<Producto> listarProductosConPrecioFiltrado() throws Exception {
        try {
            String sql = "SELECT nombre,precio FROM producto WHERE precio BETWEEN 120 AND 202";
 
            consultarBase(sql);

            Producto producto= null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                
                
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
        }
        
        public Collection<Producto> listarPortatiles() throws Exception {
        try {
            String sql = "SELECT codigo,nombre,precio FROM producto WHERE nombre LIKE 'Portátil%'";
 
            consultarBase(sql);
            
            Producto producto= null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                
                
                
                
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
        }
        
        public Collection<Producto> listarProductosConPrecioMasBajo() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto WHERE precio = (SELECT MIN(precio) FROM producto)";
 
            consultarBase(sql);

            Producto producto= null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                
                
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
        }
        
        public void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el Fabricante");
            }

            String sql = "INSERT INTO producto(codigo,nombre,precio,fabricante)"
                    + "VALUES ( '" + producto.getCodigo() + "' , '" + producto.getNombre() + "','"+ producto.getPrecio() + "','"+ producto.getFabricante()+"');";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
        //hay que editarlo
         public void modificarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto que desea modificar");
            }

            String sql = "UPDATE producto SET "
                    + "precio = '" + producto.getPrecio() + "' WHERE codigo = '" + producto.getCodigo() + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    
}
