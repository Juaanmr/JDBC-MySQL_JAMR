/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectobd1;

import java.sql.*;

/**
 *
 * @author Juan
 */
public class ProyectoBD1 {

    //Datos de conexion a la base de datos
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/jcvd";
    static final String USER = "juan";
    static final String PASS = "1234";
    static final String QUERY = "SELECT * FROM videojuegos";
    /*static final String QUERY2 = "INSERT INTO `videojuegos` (`id`, `Nombre`, `Genero`, `FechaLanzamiento`, `Compañia`, `Precio`) "
            + "VALUES (NULL, 'Spider-Man', 'Mundo abierto', '2023-11-13', 'Sony', '78')";*/
    static final String QUERY3 = "DELETE FROM `videojuegos` WHERE id = 7";

    public static void main(String[] args) {
        //Abre la conexion
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);) {
            // Extrae la informacion del set de resultados
            while(rs.next()){
                //Obtiene la info segun el nombre de la columna de la base de datos
                System.out.print("ID: " +rs.getInt("id"));
                System.out.print(", Nombre: " +rs.getString("Nombre"));
                System.out.print(", Genero: " +rs.getString("Genero"));
                System.out.print(", FechaLanzamietno: " +rs.getDate("FechaLanzamiento"));
                System.out.print(", Compañia: " +rs.getString("Compañia"));
                System.out.println(" y Precio: " +rs.getFloat("Precio"));
            }
            //Insertar un nuevo juego
            //stmt.executeUpdate(QUERY2);
            
            //Borrar un juego
            stmt.executeUpdate(QUERY3);
            System.out.println("Videojuego eliminadisimooooooooo");
            
            //Cerramos el Statement el ResultSet y la conexion 
            stmt.close();
            rs.close();
            conn.close();
        } catch (Exception e) {
            //excepcion que salta si hay algun error durante la ejecucion
            e.printStackTrace();
        }
    }
}