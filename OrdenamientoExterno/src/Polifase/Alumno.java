package Polifase;

/**
 *
 * @author Nahim Rosas
 */

public class Alumno
{
    private String apellido;
    private String nombre;
    private String noCnt;
    
    public Alumno(String apellido, String nombre, String noCnt)
    {
        this.apellido = apellido;
        this.nombre = nombre;
        this.noCnt = noCnt;
    }

    public String getApellido()
    {
        return apellido;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getNoCnt()
    {
        return noCnt;
    }

}
