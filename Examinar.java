/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clientes;

import conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
/**
 *
 * @author sanch
 */
public class Examinar {
     public static void main(String[] args) {
        
        
        // CONEXION
        
        conexion con = new conexion ();
        Connection cn;
        Statement st;
        ResultSet rs;
      
        //CONSULTAR LA BASE DE DATOS
   
        try {
            Class.forName ("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Examinar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try{
         cn = con.getConnection();
         st = cn.createStatement();
        
         rs = st.executeQuery ("SELECT * FROM clientes"); // CONSULTA
         rs.next ();
         
              do {
        System.out.println(rs.getInt("idclientes")+":"+rs.getString("nombre")+" - "+rs.getString("direccion")+" - "+rs.getString("correo")+" - "+rs.getString("ciudad"));
        }while (rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(Examinar.class.getName()).log(Level.SEVERE,null, ex);
    }
    
   }
    
}