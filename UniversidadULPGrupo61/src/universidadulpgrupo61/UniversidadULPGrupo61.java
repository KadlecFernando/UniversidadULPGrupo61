
package universidadulpgrupo61;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import universidadulpgrupo61.entidades.Alumno;
import universidadulpgrupo61.entidades.Inscripcion;
import universidadulpgrupo61.entidades.Materia;
import universidadulpgrupo61.entidades.accesoADatos.AlumnoData;
import universidadulpgrupo61.entidades.accesoADatos.InscripcionData;
import universidadulpgrupo61.entidades.accesoADatos.MateriaData;


public class UniversidadULPGrupo61 {

    
    public static void main(String[] args) {
        //Alumno alumno = new Alumno(1,42622026,"Rubio","Luana",LocalDate.of(2000, 04, 19),true);
        //System.out.println(maria.buscarAlumnoPorDni(42622026));
        
        /*List<Alumno> alumnos = maria.listaAlumnos();
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }*/
        
        //maria.eliminarAlumno(3);
        /*Alumno alum = new Alumno(3,471,"","",LocalDate.of(1970, 07, 07),true);
        Materia mat = new Materia(1,"Historia",2,true);*/
        Inscripcion insc = new Inscripcion();
        InscripcionData inscData = new InscripcionData();
        
        List<Inscripcion> inscripciones = inscData.listarInscripciones();
        
        for (Inscripcion ins : inscripciones){
            System.out.println(ins);
        }
        
        //MateriaData md= new MateriaData();
        //System.out.println(md.buscarMateria(1));
        
        
    }
   
}
