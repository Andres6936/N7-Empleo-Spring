package edu.jobs.mundo;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

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

    // Fields

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

    // Constructs

    /**
     * Construye un nuevo aspirante con los parómetros indicados
     *
     * @param _name            El nombre del aspirante - _name != null
     * @param _profession      La profesión del aspirante - _profession pertenece a { ADMINISTRADOR, INGENIERO_INDUSTRIAL, CONTADOR, ECONOMISTA }
     * @param _experienceYears Aóos de experiencia del aspirante - _experienceYears > 0
     * @param _age             La edad del aspirante - _age > 0
     * @param _telephone       El telófono del aspirante - _telephone != null
     * @param _image           La ruta a la imagen del aspirante - _image != null
     */
    public Aspirante(@NotNull String _name, @NotNull Profession _profession,
                     int _experienceYears, int _age,
                     @NotNull String _telephone, @NotNull String _image)
    {
        name = _name;
        profession = _profession;
        experienceYears = _experienceYears;
        age = _age;
        telephone = _telephone;
        image = _image;

        verificarInvariante();
    }

    // Getters

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
        return profession.name().toLowerCase();
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
     *
     * @param a es el aspirante contra el que se estó comparando - a !=null
     * @return Retorna 0 si los aspirantes tienen el mismo nombre. <br>
     * Retorna -1 si el aspirante a tiene una valor mayor lexicogróficamente para el nombre. <br>
     * Retorna 1 si el aspirante a tiene una valor menor lexicogróficamente para el nombre. <br>
     */
    public int compareByName(Aspirante a)
    {
        int resultado = name.compareToIgnoreCase(a.name);
        return Integer.compare(resultado, 0);
    }

    /**
     * Compara dos aspirantes segón la profesión
     * @param a El aspirante contra el que se estó comparando - a!=null
     * @return Retorna 0 si los aspirantes tienen la misma profesión. <br>
     *         Retorna -1 si el aspirante a tiene una valor mayor lexicogróficamente para la profesión. <br>
     *         Retorna 1 si el aspirantes a tiene una valor menor lexicogróficamente para la profesión. <br>
     */
    public int compareByProfession(Aspirante a)
    {
        int resultado = profession.name().compareToIgnoreCase(a.getProfessionName());
        return Integer.compare(resultado, 0);
    }

    /**
     * Compara dos aspirantes segón los aóos de experiencia
     * @param a El aspirante contra el que se estó comparando - a!=null
     * @return Retorna 0 si los aspirantes tienen los mismos aóos de experiencia. <br>
     *         Retorna -1 si el aspirante a tiene mós aóos de experiencia. <br>
     *         Retorna 1 si el aspirante a tiene menos aóos de experiencia. <br>
     */
    public int compareByExperienceYears(Aspirante a)
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
    public int compareByAge(Aspirante a)
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
     * aniosExperiencia > 0 <br>
     * edad > 0 <br>
     */
    private void verificarInvariante( )
    {
        assert (experienceYears > 0) : "aniosExperiencia no puede ser 0";
        assert (age > 0) : "edad no puede ser 0";
    }
}