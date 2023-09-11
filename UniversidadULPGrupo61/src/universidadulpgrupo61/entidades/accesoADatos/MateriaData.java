
package universidadulpgrupo61.entidades.accesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import universidadulpgrupo61.entidades.Alumno;
import universidadulpgrupo61.entidades.Materia;


public class MateriaData {
    private Connection con=null;

    public MateriaData() {
        con=Conexion.getConnection();
    }
    
    public void guardarMateria(Materia materia){
        
        try {
            String sql="INSERT INTO materia(nombre,año,estado) VALUES (?,?,?)";
            PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isActivo());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if (rs.next()){
                //rs.getInt("idAlumno") da error con el insert y el generated keys, seria con un SELECT idMateria FROM alumno WHERE dni = ?
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Materia añadida con éxito.");
            }
            ps.close();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla materia " + ex.getMessage());
        }

    }
    
    public Materia buscarMateria(int id){
        
        Materia materia = null;
        String sql = "SELECT nombre,año,estado FROM alumno WHERE idMateria = ? AND estado = 1";

        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                materia = new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materia.setActivo(true);   
            }else{
                JOptionPane.showMessageDialog(null, "No existe la materia.");
            }
                ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia " + ex.getMessage());
        }
        
        return materia;
    }
}
