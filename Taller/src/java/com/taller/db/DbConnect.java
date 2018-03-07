/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taller.db;

import com.taller.model.Empleados;
import com.taller.model.Departamentos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author docente
 */
public class DbConnect {
     private static String user="root";
    private static String password="";
    private static String url="jdbc:mysql://localhost:3306/taller";
    private static Connection con = null;
    
    public static void conectar () throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url,user,password);
    }
    public static void guardar_departamento(Departamentos d) throws ClassNotFoundException, SQLException{
        conectar();
        PreparedStatement pst = con.prepareStatement("Insert into "
                + "departamento values(?,?,?)");
        pst.setInt(1,d.getId() );
        pst.setString(2, d.getNombre());
        pst.setString(3, d.getLocalizacion());
        pst.executeUpdate();
        con.close();
        pst.close();
    }
    public static  void guardar_empleado(Empleados e) throws ClassNotFoundException, SQLException{
        conectar();
        PreparedStatement pst = con.prepareStatement("Insert into "
                                + "empleados values(?,?,?,?)");
        pst.setInt(1, e.getId());
        pst.setInt(2, e.getId_depart());
        pst.setString(3, e.getNombre());
        pst.setFloat(3, e.getSalario());
        pst.setDate(4, e.getFecha_ingreso());
    }
     public static List<Empleados> lista_empleados() throws ClassNotFoundException, SQLException{
       conectar();
       List<Empleados> lista=new  ArrayList<>();
        PreparedStatement pst = con.prepareStatement("Select * from empleados ");
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Empleados e = new Empleados(rs.getInt(1),rs.getInt(2),
                              rs.getString(2),rs.getFloat(3),rs.getDate(4));
        }
        con.close();
        pst.close();
        return lista;
       
    }
     public static List<Departamentos> lista_departamentos() throws ClassNotFoundException, SQLException{
       conectar();
       List<Departamentos> lista=new  ArrayList<>();
        PreparedStatement pst = con.prepareStatement("Select * from departamento ");
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Departamentos d = new Departamentos(rs.getInt(1),rs.getString(2),rs.getString(3));
        }
        con.close();
        pst.close();
        return lista;
       
    }
     
}