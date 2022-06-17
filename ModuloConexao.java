/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.Bank.dal;
import java.sql.*;
/**
 * 
 * @author USER
 */
public class ModuloConexao {
     public static Connection conector(){
         java.sql.Connection conexao = null;
         String driver = "com.mysql.cj.jdbc.Driver";
         String url = "jdbc:mysql://localhost:3306/banco";
         String user = "root";
         String password = "159789";
         
         try {
             Class.forName(driver);
             conexao = DriverManager.getConnection(url, user, password);
             return conexao; 
             
         } catch (Exception e) { 
             //linha abaixo serve de apoio a comunicacao
             //System.out.println(e);
             return null;
         }
     }
}  



