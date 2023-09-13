
package universidadulpgrupo61.entidades.accesoADatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
            String sql="INSERT INTO alumno(dni,apellido,nombre,fechaNacimiento,estado) VALUES (?,?,?,?,?)";
            PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if (rs.next()){
                //rs.getInt("idAlumno") da error con el insert y el generated keys, seria con un SELECT idAlumno FROM alumno WHERE dni = ?
                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Alumno añadido con exito ");
            }
            ps.close();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla alumno "+ ex.getMessage());
        }

    }
    
    public Alumno buscarAlumno(int id){
        
            Alumno alumno = null;
            String sql = "SELECT dni, apellido, nombre, fechaNacimiento FROM alumno WHERE idAlumno = ? AND estado = 1";
            
            PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                alumno = new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);   
            }else{
                JOptionPane.showMessageDialog(null, "No existe el alumno.");
            }
                ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno " + ex.getMessage());
        }
        
        return alumno;
    }
    
    public Alumno buscarAlumnoPorDni(int dni){
        
            Alumno alumno = null;
            String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento FROM alumno WHERE dni = ? AND estado = 1";
            
            PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);   
            }else{
                JOptionPane.showMessageDialog(null, "No existe el alumno.");
            }
                ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno " + ex.getMessage());
        }
        
        return alumno;
    }
    
    public List<Alumno> listaAlumnos(){
            List <Alumno> alumnos = new ArrayList<>();
            
        try {
            String sql = "SELECT * FROM alumno WHERE estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){

                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));

                alumnos.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno." + ex.getMessage());
        }
        return alumnos;
    }
    
    public void modificarAlumno(Alumno alumno){
 
        String sql = "UPDATE alumno SET dni = ?, apellido = ?, nombre = ?, fechaNacimiento = ? WHERE idAlumno = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setInt(5, alumno.getIdAlumno());
            
            int exito = ps.executeUpdate();
            if (exito == 1){
                JOptionPane.showMessageDialog(null, "Modificado exitosamente.");
            }else{
                JOptionPane.showMessageDialog(null, "El alumno no existe.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno " + ex.getMessage());   
        }
    }
    
    public void eliminarAlumno(int id){
        
        try {
            String sql = "UPDATE alumno SET estado = 0 WHERE idAlumno = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();
            if (fila == 1){
                JOptionPane.showMessageDialog(null, "Se eliminó el alumno.");
            }else{
                JOptionPane.showMessageDialog(null, "No se encontró el alumno.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla alumno " + ex.getMessage());
        }
    }
}
