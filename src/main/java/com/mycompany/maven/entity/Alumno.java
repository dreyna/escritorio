
package com.mycompany.maven.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Docente
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Alumno {
    private int idalumno;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String correo;
    private int idescuela;
}
