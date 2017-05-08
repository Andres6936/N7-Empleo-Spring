/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Aspirante.java,v 1.9 2007/04/12 03:43:58 carl-veg Exp $ 
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_empleo
 * Autor: Milena Vela - 21-abr-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.empleo.mundo;

/**
 * Es la clase que representa a un Aspirante <br>
 * <b>inv: </b> <br>
 * nombre != null <br>
 * profesion pertenece a { ADMINISTRADOR, INGENIERO_INDUSTRIAL, CONTADOR, ECONOMISTA } <br>
 * aniosExperiencia > 0 <br>
 * edad > 0 <br>
 * telefono != null <br>
 */

public class Aspirante
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Indica que la profesión es ADMINISTRADOR
     */
    public static final String ADMINISTRADOR = "Administrador";

    /**
     * Indica que la profesión es INGENIERO INDUSTRIAL
     */
    public static final String INGENIERO_INDUSTRIAL = "Ingeniero Industrial";

    /**
     * Indica que la profesión es contador
     */
    public static final String CONTADOR = "Contador";

    /**
     * Indica que la profesión es economista
     */
    public static final String ECONOMISTA = "Economista";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * El nombre del aspirante
     */
    private String nombre;

    /**
     * La profesión del aspirante
     */
    private String profesion;

    /**
     * Los años de experiencia del aspirante
     */
    private int aniosExperiencia;

    /**
     * La edad del aspirante
     */
    private int edad;

    /**
     * El teléfono del aspirante
     */
    private String telefono;

    /**
     * La ruta de la imagen del aspirante
     */
    private String imagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo aspirante con los parámetros indicados
     * @param nombreA El nombre del aspirante - nombreA != null
     * @param profesionA La profesión del aspirante - profesionA pertenece a { ADMINISTRADOR, INGENIERO_INDUSTRIAL, CONTADOR, ECONOMISTA }
     * @param aniosExperienciaA Años de experiencia del aspirante - aniosExperienciaA > 0
     * @param edadA La edad del aspirante - edadA > 0
     * @param telefonoA El teléfono del aspirante - telefonoA != null
     * @param imagenA La ruta a la imagen del aspirante - imagenA != null
     */
    public Aspirante( String nombreA, String profesionA, int aniosExperienciaA, int edadA, String telefonoA, String imagenA )
    {
        nombre = nombreA;
        profesion = profesionA;
        aniosExperiencia = aniosExperienciaA;
        edad = edadA;
        telefono = telefonoA;
        imagen = imagenA;

        verificarInvariante( );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del aspirante
     * @return nombre
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la profesión del aspirante
     * @return profesion
     */
    public String darProfesion( )
    {
        return profesion;
    }

    /**
     * Retorna los años de experiencia del aspirante
     * @return aniosExperiencia
     */
    public int darAniosExperiencia( )
    {
        return aniosExperiencia;
    }

    /**
     * Retorna la edad del aspirante
     * @return edad
     */
    public int darEdad( )
    {
        return edad;
    }

    /**
     * Retorna el teléfono del aspirante
     * @return telefono
     */
    public String darTelefono( )
    {
        return telefono;
    }

    /**
     * Retorna la ruta de la imagen del aspirante
     * @return imagen
     */
    public String darImagen( )
    {
        return imagen;
    }

    /**
     * Compara dos aspirantes según el nombre. <br>
     * @param a es el aspirante contra el que se está comparando - a !=null
     * @return Retorna 0 si los aspirantes tienen el mismo nombre. <br>
     *         Retorna -1 si el aspirante a tiene una valor mayor lexicográficamente para el nombre. <br>
     *         Retorna 1 si el aspirante a tiene una valor menor lexicográficamente para el nombre. <br>
     */
    public int compararPorNombre( Aspirante a )
    {
        int resultado = nombre.compareToIgnoreCase( a.nombre );
        if( resultado > 0 )
            return 1;
        else if( resultado < 0 )
            return -1;
        else
            return 0;
    }

    /**
     * Compara dos aspirantes según la profesión
     * @param a El aspirante contra el que se está comparando - a!=null
     * @return Retorna 0 si los aspirantes tienen la misma profesión. <br>
     *         Retorna -1 si el aspirante a tiene una valor mayor lexicográficamente para la profesión. <br>
     *         Retorna 1 si el aspirantes a tiene una valor menor lexicográficamente para la profesión. <br>
     */
    public int compararPorProfesion( Aspirante a )
    {
        int resultado = profesion.compareToIgnoreCase( a.darProfesion( ) );
        if( resultado > 0 )
            return 1;
        else if( resultado < 0 )
            return -1;
        else
            return 0;
    }

    /**
     * Compara dos aspirantes según los años de experiencia
     * @param a El aspirante contra el que se está comparando - a!=null
     * @return Retorna 0 si los aspirantes tienen los mismos años de experiencia. <br>
     *         Retorna -1 si el aspirante a tiene más años de experiencia. <br>
     *         Retorna 1 si el aspirante a tiene menos años de experiencia. <br>
     */
    public int compararPorAniosExperiencia( Aspirante a )
    {
        if( aniosExperiencia == a.darAniosExperiencia( ) )
            return 0;
        else if( aniosExperiencia > a.darAniosExperiencia( ) )
            return 1;
        else
            return -1;

    }

    /**
     * Compara dos aspirantes según la edad
     * @param a El aspirante contra el que se está comparando - a!=null
     * @return Retorna 0 si los aspirantes tienen la misma edad. <br>
     *         Retorna -1 si el aspirante a es mayor. <br>
     *         Retorna 1 si el aspirantes a es menor. <br>
     */
    public int compararPorEdad( Aspirante a )
    {
        if( edad == a.darEdad( ) )
            return 0;
        else if( edad > a.darEdad( ) )
            return 1;
        else
            return -1;
    }

    /**
     * Retorna una cadena con el nombre del aspirante, su profesión y los años de experiencia
     * @return Información del aspirante en una cadena con el formato "<nombre> - <profesion>"
     */
    public String toString( )
    {
        return nombre + " - " + profesion;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica el invariante de la clase <br>
     * <b>inv: </b> <br>
     * nombre != null <br>
     * profesion pertenece a { ADMINISTRADOR, INGENIERO_INDUSTRIAL, CONTADOR, ECONOMISTA } <br>
     * aniosExperiencia > 0 <br>
     * edad > 0 <br>
     * telefono != null <br>
     */
    private void verificarInvariante( )
    {
        assert ( nombre != null ) : "nombre no puede ser null";
        assert ( profesion.equals( ADMINISTRADOR ) || profesion.equals( INGENIERO_INDUSTRIAL ) || profesion.equals( CONTADOR ) || profesion.equals( ECONOMISTA ) ) : "La profesión debe ser uno de los valores válidos";
        assert ( aniosExperiencia > 0 ) : "aniosExperiencia no puede ser 0";
        assert ( edad > 0 ) : "edad no puede ser 0";
        assert ( telefono != null ) : "telefono no puede ser null";
        assert ( imagen != null ) : "imagen no puede ser null";

    }
}