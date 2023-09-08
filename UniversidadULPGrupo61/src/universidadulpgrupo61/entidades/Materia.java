
package universidadulpgrupo61.entidades;


public class Materia {
    
    private int idMateria;
    private String nombre;
    private int anioMatereia;
    private boolean activo;

    public Materia() {
    }

    public Materia(int idMateria, String nombre, int anioMatereia, boolean activo) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.anioMatereia = anioMatereia;
        this.activo = activo;
    }

    public Materia(String nombre, int anioMatereia, boolean activo) {
        this.nombre = nombre;
        this.anioMatereia = anioMatereia;
        this.activo = activo;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int isAnioMatereia() {
        return anioMatereia;
    }

    public void setAnioMatereia(int anioMatereia) {
        this.anioMatereia = anioMatereia;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idMateria + ", nombre=" + nombre + ", anioMatereia=" + anioMatereia + '}';
    }
    
}
