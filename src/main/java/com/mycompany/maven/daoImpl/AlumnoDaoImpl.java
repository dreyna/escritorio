
package com.mycompany.maven.daoImpl;

import com.mycompany.maven.dao.Operaciones;
import com.mycompany.maven.entity.Alumno;
import com.mycompany.maven.config.Conexion;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Docente
 */
public class AlumnoDaoImpl implements Operaciones<Alumno>{
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;
    @Override
    public int create(Alumno t) {
         String SQL = "INSERT INTO alumno(nombres, apellidos, direccion, correo, idescuela) VALUES(?,?,?,?,?)";
        int x= 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, t.getNombres());
            ps.setString(2, t.getApellidos());
            ps.setString(3, t.getDireccion());
            ps.setString(4, t.getCorreo());
            ps.setInt(5, t.getIdescuela());
           x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error: "+e);
        }
        return x;
    }

    @Override
    public int update(Alumno t) {
        String SQL = "UPDATE alumno SET nombres=?, apellidos=?, direccion=?, correo=?, idescuela=? WHERE idalumno=?";
        int x= 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, t.getNombres());
            ps.setString(2, t.getApellidos());
            ps.setString(3, t.getDireccion());
            ps.setString(4, t.getCorreo());
            ps.setInt(5, t.getIdescuela());
            ps.setInt(6, t.getIdalumno());
           x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error: "+e);
        }
       return x;       
    }

    @Override
    public int delete(int id) {
        String SQL = "DELETE FROM alumno WHERE idalumno=?";
        int x= 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
           x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error: "+e);
        }
        return x;
    }

    @Override
    public Alumno read(int id) {
        String SQL = "SELECT *FROM alumno WHERE idalumno=?";
        Alumno alu = new Alumno();
        int x= 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
           rs = ps.executeQuery();
           while(rs.next()){
               alu.setIdalumno(rs.getInt("idalumno"));
               alu.setNombres(rs.getString("nombres"));
               alu.setApellidos(rs.getString("apellidos"));
               alu.setDireccion(rs.getString("direccion"));
               alu.setCorreo(rs.getString("correo"));
               alu.setIdescuela(rs.getInt("idescuela"));
           }
        } catch (SQLException e) {
            System.out.println("error: "+e);
        }
        return alu;
    }

    @Override
    public List<Alumno> readAll() {
        String SQL = "SELECT *FROM alumno";
        List<Alumno> lista =new ArrayList<>();
        int x= 0;
        try {
             cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
           rs = ps.executeQuery();
           while(rs.next()){
               Alumno alu = new Alumno();
               alu.setIdalumno(rs.getInt("idalumno"));
               alu.setNombres(rs.getString("nombres"));
               alu.setApellidos(rs.getString("apellidos"));
               alu.setDireccion(rs.getString("direccion"));
               alu.setCorreo(rs.getString("correo"));
               alu.setIdescuela(rs.getInt("idescuela"));
               lista.add(alu);
           }
        } catch (SQLException e) {
            System.out.println("error: "+e);
        }
       return lista;
    }

    @Override
    public List<Map<String, Object>> lista() {
        String SQL = "select a.idalumno, a.nombres, a.apellidos, a.direccion, a.correo, e.idescuela, e.nombre from alumno as a " +
                     "inner join escuela as e on a.idescuela=e.idescuela";
        List<Map<String, Object>> lista =new ArrayList<>();
        int x= 0;
        try {
             cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
           rs = ps.executeQuery();
           while(rs.next()){
               Map<String, Object> map = new HashMap<>();
               map.put("idalumno", rs.getInt("idalumno"));
               map.put("nombres", rs.getString("nombres"));
               map.put("apellidos", rs.getString("apellidos"));
               map.put("direccion", rs.getString("direccion"));
               map.put("correo", rs.getString("correo"));
               map.put("idescuela", rs.getInt("idescuela"));
               map.put("escuela", rs.getString("nombre"));
               lista.add(map);
           }
        } catch (SQLException e) {
            System.out.println("error: "+e);
        }
       return lista;
    }

    @Override
    public Alumno read2(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
