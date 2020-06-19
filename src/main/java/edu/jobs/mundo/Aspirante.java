package edu.jobs.mundo;

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
    // Fields
    // -----------------------------------------------------------------

    /**
     * The applicant's name
     */
    private final String name;

    /**
     * The applicant's profession
     */
    private final Profession profession;

    /**
     * The applicant's experience in years
     */
    private final int experienceYears;

    /**
     * The applicant's age
     */
    private final int age;

    /**
     * The applicant's telephone
     */
    private final String telephone;

    /**
     * The applicant's image
     */
    private final String image;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo aspirante con los parómetros indicados
     *
     * @param nombreA           El nombre del aspirante - nombreA != null
     * @param profesionA        La profesión del aspirante - profesionA pertenece a { ADMINISTRADOR, INGENIERO_INDUSTRIAL, CONTADOR, ECONOMISTA }
     * @param aniosExperienciaA Aóos de experiencia del aspirante - aniosExperienciaA > 0
     * @param edadA             La edad del aspirante - edadA > 0
     * @param telefonoA         El telófono del aspirante - telefonoA != null
     * @param imagenA           La ruta a la imagen del aspirante - imagenA != null
     */
    public Aspirante(String nombreA, Profession profesionA, int aniosExperienciaA, int edadA, String telefonoA, String imagenA)
    {
        name = nombreA;
        profession = profesionA;
        experienceYears = aniosExperienciaA;
        age = edadA;
        telephone = telefonoA;
        image = imagenA;

        verificarInvariante();
    }

    // -----------------------------------------------------------------
    // Mótodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del aspirante
     *
     * @return nombre
     */
    public String getName()
    {
        return name;
    }

    /**
     * Retorna la profesión del aspirante
     *
     * @return profesion
     */
    public String getProfessionName()
    {
        return profession.name();
    }

    /**
     * Retorna los aóos de experiencia del aspirante
     *
     * @return aniosExperiencia
     */
    public int getExperienceYears()
    {
        return experienceYears;
    }

    /**
     * Retorna la edad del aspirante
     *
     * @return edad
     */
    public int getAge()
    {
        return age;
    }

    /**
     * Retorna el telófono del aspirante
     *
     * @return telefono
     */
    public String getTelephone()
    {
        return telephone;
    }

    /**
     * Retorna la ruta de la imagen del aspirante
     *
     * @return imagen
     */
    public String getImage()
    {
        return image;
    }

    /**
     * Compara dos aspirantes segón el nombre. <br>
     * @param a es el aspirante contra el que se estó comparando - a !=null
     * @return Retorna 0 si los aspirantes tienen el mismo nombre. <br>
     *         Retorna -1 si el aspirante a tiene una valor mayor lexicogróficamente para el nombre. <br>
     *         Retorna 1 si el aspirante a tiene una valor menor lexicogróficamente para el nombre. <br>
     */
    public int compararPorNombre( Aspirante a )
    {
        int resultado = name.compareToIgnoreCase(a.name);
        return Integer.compare( resultado, 0 );
    }

    /**
     * Compara dos aspirantes segón la profesión
     * @param a El aspirante contra el que se estó comparando - a!=null
     * @return Retorna 0 si los aspirantes tienen la misma profesión. <br>
     *         Retorna -1 si el aspirante a tiene una valor mayor lexicogróficamente para la profesión. <br>
     *         Retorna 1 si el aspirantes a tiene una valor menor lexicogróficamente para la profesión. <br>
     */
    public int compararPorProfesion(Aspirante a)
    {
        int resultado = profession.name().compareToIgnoreCase( a.getProfessionName( ) );
        return Integer.compare( resultado, 0 );
    }

    /**
     * Compara dos aspirantes segón los aóos de experiencia
     * @param a El aspirante contra el que se estó comparando - a!=null
     * @return Retorna 0 si los aspirantes tienen los mismos aóos de experiencia. <br>
     *         Retorna -1 si el aspirante a tiene mós aóos de experiencia. <br>
     *         Retorna 1 si el aspirante a tiene menos aóos de experiencia. <br>
     */
    public int compararPorAniosExperiencia(Aspirante a)
    {
        return Integer.compare(experienceYears, a.getExperienceYears());
    }

    /**
     * Compara dos aspirantes segón la edad
     * @param a El aspirante contra el que se estó comparando - a!=null
     * @return Retorna 0 si los aspirantes tienen la misma edad. <br>
     *         Retorna -1 si el aspirante a es mayor. <br>
     *         Retorna 1 si el aspirantes a es menor. <br>
     */
    public int compararPorEdad(Aspirante a)
    {
        return Integer.compare(age, a.getAge());
    }

    /**
     * Retorna una cadena con el nombre del aspirante, su profesión y los aóos de experiencia
     * @return Información del aspirante en una cadena con el formato "<nombre> - <profesion>"
     */
    public String toString( )
    {
        return name + " - " + profession;
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
        assert (name != null) : "nombre no puede ser null";
        assert (experienceYears > 0) : "aniosExperiencia no puede ser 0";
        assert (age > 0) : "edad no puede ser 0";
        assert (telephone != null) : "telefono no puede ser null";
        assert (image != null) : "imagen no puede ser null";

    }
}