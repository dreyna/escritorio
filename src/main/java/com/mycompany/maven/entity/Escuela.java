
package com.mycompany.maven.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Docente
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Escuela {
    private int idescuela;
    private String nombre;
}
