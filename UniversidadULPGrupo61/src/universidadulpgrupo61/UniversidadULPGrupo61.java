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
import universidadulpgrupo61.vistas.Principal;

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
        /*AlumnoData aD = new AlumnoData();
        MateriaData mD = new MateriaData();
        InscripcionData iD = new InscripcionData();
        Alumno a1 = aD.buscarAlumno(1);
        System.out.println(a1);
        Materia m1 = mD.buscarMateria(1);
        System.out.println(m1);

        Inscripcion i1 = new Inscripcion(a1, m1, 7);
//        System.out.println(m1);
//        iD.guardarInscripcion(i1);
        List<Inscripcion> inscripciones = iD.obtenerInscripciones();

        for (Inscripcion ins : inscripciones) {
            System.out.println(ins);
//        }

        }*/
        
        Principal prin = new Principal();
        prin.setVisible(true);
        prin.setLocationRelativeTo(null);

    }
}
