
package universidadulpgrupo61.entidades.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadulpgrupo61.entidades.Alumno;
import universidadulpgrupo61.entidades.Inscripcion;
import universidadulpgrupo61.entidades.Materia;


public class InscripcionData {
    private Connection con=null;
    private MateriaData matData= new MateriaData();
    private AlumnoData aluData= new AlumnoData();

    public InscripcionData() {
        con=Conexion.getConnection();
    }

    
    public void guardarInscripcion(Inscripcion insc){
        try {
            
            String sql="INSERT INTO inscripcion(idAlumno,idMateria) VALUES (?,?,?)";
            PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,insc.getAlumno().getIdAlumno());
            ps.setInt(2,insc.getMateria().getIdMateria());
            ps.setDouble(3, insc.getNota());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if (rs.next()){
                //rs.getInt("idinscripcion") da error con el insert y el generated keys, seria con un SELECT idMateria FROM inscripcion WHERE dni = ?
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Inscripción añadida con éxito.");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla inscripción " + ex.getMessage());
        }
        
    }
    
    public List<Inscripcion> listarInscripciones(){
            List <Inscripcion> inscripciones = new ArrayList<>();
            
        try {
            String sql = "SELECT * FROM inscripcion";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                
                Inscripcion inscripcion = new Inscripcion();
                Alumno alumno = new Alumno();
                Materia materia = new Materia();
                
                inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
                alumno = aluData.buscarAlumno(rs.getInt("idAlumno"));
                materia = matData.buscarMateria(rs.getInt("idMateria"));
                inscripcion.setAlumno(alumno);
                inscripcion.setMateria(materia);
                inscripcion.setNota(rs.getDouble("nota"));
                
                inscripciones.add(inscripcion);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion." + ex.getMessage());
        }
        return inscripciones;
    }
    
    
    
    
    
}
