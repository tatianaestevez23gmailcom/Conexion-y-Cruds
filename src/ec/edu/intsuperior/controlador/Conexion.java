/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class Conexion {
   static Connection conex= null;
    public static Connection conexion() {
        String user="root";
        String passwd="root";
        String url= "jdbc:mysql:// localhost: 3306/ dbgestionbodega?serverTimezone=UTC";
        
        try {
            conex=DriverManager.getConnection(url, user,passwd);
            
            System.out.println("Conexion Exitosa");
                    
                    
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }

    return conex;
    
}
    
    
    public void consultarUser() {
        try {
            Statement stm = conexion().createStatement();
            
            ResultSet rst = stm.executeQuery("select * from user");
            while (rst.next()) {
                System.out.println("Id User: " + rst.getInt(1)
                        + "\nUser Name: " + rst.getString(2)
                        + "\nPassword: " + rst.getString(3));
                System.out.println("**********************************");
            }

        } catch (Exception e) {
        }

    }
    
    public void insertarUser(){
        Scanner leer = new Scanner(System.in);
        try {
            Statement stm= conexion().createStatement();
            int iduser;
            String username;
            String passwd;
            System.out.println("Ingresa un iduser");
            iduser=leer.nextInt();
            System.out.println("Ingresa un user name");
            username= leer.next();
            System.out.println("Ingresa un passwd");
            passwd=leer.next();
            stm.executeUpdate("Insert into user values("+iduser+",\""+username+"\",\""+passwd+"\")");
            System.out.println("Datos ingresados correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    

}



