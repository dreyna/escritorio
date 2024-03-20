
package com.mycompany.maven;

import com.mycompany.maven.config.Conexion;
import com.mycompany.maven.daoImpl.AlumnoDaoImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Docente
 */
public class Maven {
    static AlumnoDaoImpl alumnDao = new AlumnoDaoImpl();
    public static void main(String[] args) {
        //conexion();
        listar_alumnos();
    }
    public static void listar(){
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> h1 = new HashMap<>();
        Map<String, Object> h2 = new HashMap<>();
        h1.put("A", 1);
        h1.put("B", 2);
        h1.put("C", 3);
        h2.put("A", 4);
        h2.put("B", 5);
        h2.put("C", 6);
        list.add(h1);
        list.add(h2);
        list.forEach(map->System.out.println(map.get("C")));
    }
    public static void conexion(){
    
        if(Conexion.getConexion()!=null){
            System.out.println("SI");
        }else{
            System.out.println("NO");
        }
    }
    public static void listar_alumnos(){
        List<Map<String, Object>> lista = alumnDao.lista();
        lista.forEach(map->System.out.println(map.get("nombres")+"->"+map.get("escuela")));
    }
}
