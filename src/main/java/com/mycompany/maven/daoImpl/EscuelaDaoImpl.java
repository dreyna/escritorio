
package com.mycompany.maven.daoImpl;

import com.mycompany.maven.dao.Operaciones;
import com.mycompany.maven.entity.Escuela;
import java.util.List;
import java.util.Map;
import com.mycompany.maven.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Docente
 */
public class EscuelaDaoImpl implements Operaciones<Escuela>{
private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;
    @Override
    public int create(Escuela t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Escuela t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Escuela read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Escuela> readAll() {
        String SQL = "SELECT *FROM escuela";
        List<Escuela> lista =new ArrayList<>();
        int x= 0;
        try {
             cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
           rs = ps.executeQuery();
           while(rs.next()){
               Escuela es = new Escuela();
               es.setIdescuela(rs.getInt("idescuela"));
               es.setNombre(rs.getString("nombre"));
               lista.add(es);
           }
        } catch (SQLException e) {
            System.out.println("error: "+e);
        }
       return lista;
    }

    @Override
    public List<Map<String, Object>> lista() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Escuela read2(String nom) {
        String SQL = "SELECT *FROM escuela WHERE nombre=?";
        Escuela alu = new Escuela();
        int x= 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, nom);
           rs = ps.executeQuery();
           while(rs.next()){
               alu.setIdescuela(rs.getInt("idescuela"));
               alu.setNombre(rs.getString("nombre"));
           }
        } catch (SQLException e) {
            System.out.println("error: "+e);
        }
        return alu;        
    }
    
}
