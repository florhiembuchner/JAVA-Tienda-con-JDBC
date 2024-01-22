/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda_jdbc;

import java.util.Scanner;
import tienda_jdbc.servicios.ProductoServicio;

/**
 *
 * @author Flor Hiembuchner
 */
public class Tienda_JDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      int opcion=1;
      ProductoServicio ps= new ProductoServicio();
      
      Scanner read= new Scanner(System.in);
      while(opcion!=0){
          System.out.println("-----BIENVENIDO AL MENU DE CONSULTA-----");
          System.out.println("Indique la operacion que desea realizar:");
          System.out.println("1.Lista el nombre de todos los productos que hay en la tabla producto. ");
          System.out.println("2.Lista los nombres y los precios de todos los productos de la tabla producto.");
          System.out.println("3.Listar aquellos productos que su precio esté entre 120 y 202.");
          System.out.println("4.Buscar y listar todos los Portátiles de la tabla producto.");
          System.out.println("5.Listar el nombre y el precio del producto más barato.");
          System.out.println("6.Ingresar un producto a la base de datos.");
          System.out.println("7.Ingresar un fabricante a la base de datos"); //faltan de acá en adelante
          System.out.println("8.Editar un producto con datos a elección.");
          System.out.println("0.Para finalizar el programa");
          opcion= read.nextInt();
          
          switch(opcion){
              case 1: {
                  ps.listarNombres();
                  break;
              }
              case 2: {
                  ps.listarNombresYPrecios();
                  break;
              }
              case 3: {
                  ps.listarProductosConPrecioFiltrado();
                  break;
              }
              case 4: {
                  ps.listarPortatiles();
                  break;
              }
              case 5:{
                  ps.listarMenorPrecio();
                  break;
              }
              default: {
                  System.out.println("Programa finalizado");
              }
              
          }
                
      }
    }
    
}
