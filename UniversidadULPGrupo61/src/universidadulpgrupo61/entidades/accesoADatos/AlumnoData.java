
package universidadulpgrupo61.entidades.accesoADatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadulpgrupo61.entidades.Alumno;


public class AlumnoData {
    
    private Connection con=null;

    public AlumnoData() {
        con=Conexion.getConnection();
    }
    
    public void guardarAlumno(Alumno alumno){
        
        try {
            String sql="Insert into alumno(dni,apellido,nombre,fechaNacimiento,estado) values (?,?,?,?,?)";
            PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isActivo());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if (rs.next()){
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                JOptionPane.showMessageDialog(null,"Alumno añadido con exito ");
            }
            ps.close();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla alumno "+ ex.getMessage());
        }
        
        
    }
    
    
    
    
}
