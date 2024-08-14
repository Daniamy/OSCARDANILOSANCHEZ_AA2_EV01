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
public class modificar {
    
    public static void main(String[] args) {
        
        // CONEXION
        
        conexion con = new conexion ();
        Connection cn;
        Statement st;
        ResultSet rs;

        
        // AGREGAR Modificar
        
        int idclientes_editar = 6;
        String New_Nombre = "Luz";
        String New_Direccion = "cra 15";
        String New_Correo = "fan@gmail.com";
        String New_Ciudad = "Bogota";
        
        String sql = "UPDATE Clientes set Nombre ='"+New_Nombre+"', Direccion ='"+New_Direccion+"',Correo ='"+New_Correo+"',Ciudad='"+New_Ciudad+"' where idclientes="+idclientes_editar;     
        try {
            Class.forName ("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(modificar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try{
         cn = con.getConnection();
         st = cn.createStatement();
         st.executeUpdate(sql);
         rs = st.executeQuery ("SELECT * FROM clientes"); // TRAER DATOS
         rs.next ();
         
              do {
        System.out.println(rs.getInt("idclientes")+":"+rs.getString("nombre")+" - "+rs.getString("direccion")+" - "+rs.getString("correo")+" - "+rs.getString("ciudad"));
        }while (rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(modificar.class.getName()).log(Level.SEVERE,null, ex);
    }
    
   }
    
}
