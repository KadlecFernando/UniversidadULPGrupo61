
package universidadulpgrupo61;

import java.time.LocalDate;
import universidadulpgrupo61.entidades.Alumno;
import universidadulpgrupo61.entidades.accesoADatos.AlumnoData;


public class UniversidadULPGrupo61 {

    
    public static void main(String[] args) {
        AlumnoData maria = new AlumnoData();
       Alumno alum = new Alumno(65347345,"apellido","nombre",LocalDate.of(1996, 11, 6),true);
       maria.guardarAlumno(alum);
       
       
       
       
    }
    
}
