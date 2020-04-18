package edu.jobs;

import junit.framework.TestCase;
import edu.jobs.mundo.Aspirante;

/**
 * Esta es la clase usada para verificar los mótodos de la clase Aspirante
 */
public class AspiranteTest extends TestCase
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Aspirante usado para los casos de prueba
     */
    private Aspirante aspirante1;

    /**
     * Aspirante usado para los casos de prueba
     */
    private Aspirante aspirante2;

    // -----------------------------------------------------------------
    // Mótodos
    // -----------------------------------------------------------------

    /**
     * Construye los aspirantes 1 y 2
     */
    private void setupEscenario1( )
    {
        aspirante1 = new Aspirante( "nombre1", Aspirante.ADMINISTRADOR , 10, 35, "1234567", "imagen1" );
        aspirante2 = new Aspirante( "nombre2", Aspirante.CONTADOR , 11, 40, "987654", "imagen2" );
    }

    /**
     * Verifica el constructor. <br>
     * <b> Mótodos a probar: </b> <br>
     * Aspirante (constructor). <br>
     * <b> Objetivo: </b> Probar que el constructor crea un aspirante de forma correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al crear un aspirante los atributos del objeto deben quedar con el valor correcto.
     */

    public void testAspirante( )
    {
        setupEscenario1( );

        assertEquals( "El nombre del aspirante estó equivocado", "nombre1", aspirante1.darNombre( ) );
        assertEquals( "La profesión del aspirante estó equivocada", Aspirante.ADMINISTRADOR, aspirante1.darProfesion( ) );
        assertEquals( "Los aóos de experiencia no son correctos", 10, aspirante1.darAniosExperiencia( ) );
        assertEquals( "La edad del aspirante no es correcta", 35, aspirante1.darEdad( ) );
        assertEquals( "El telófono del aspirante estó equivocado", "1234567", aspirante1.darTelefono( ) );
        assertEquals( "La imagen del aspirante estó equivocada", "imagen1", aspirante1.darImagen( ) );
    }

    /**
     * Verifica el mótodo compararPorNombre. <br>
     * <b> Mótodos a probar: </b> <br>
     * compararPorNombre. <br>
     * <b> Objetivo: </b> Probar que el mótodo compararPorNombre realiza la comparación de dos aspirantes de forma correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comparar un aspirante cuyo nombre sea menor lexicogróficamente a la del otro el resultado debe ser -1. <br>
     * 2. Al comparar un aspirante cuyo nombre sea igual lexicogróficamente a la del otro el resultado debe ser 0. <br>
     * 3. Al comparar un aspirante cuyo nombre sea mayor lexicogróficamente a la del otro el resultado debe ser 1.
     */
    public void testCompararPorNombre( )
    {
        setupEscenario1( );

        assertEquals( "El aspirante 1 deberóa ser menor", - 1, aspirante1.compararPorNombre( aspirante2 ) );
        assertEquals( "El aspirante 1 y el aspirante 1 deberóan ser iguales", 0, aspirante1.compararPorNombre( aspirante1 ) );
        assertEquals( "El aspirante 2 deberóa ser mayor", 1, aspirante2.compararPorNombre( aspirante1 ) );
    }

    /**
     * Verifica el mótodo compararPorAniosExperiencia. <br>
     * <b> Mótodos a probar: </b> <br>
     * compararPorAniosExperiencia. <br>
     * <b> Objetivo: </b> Probar que el mótodo compararPorAniosExperiencia realiza la comparación de dos aspirantes de forma correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comparar un aspirante cuyos aóos de experiencia sean menores a los de otro el resultado debe ser -1. <br>
     * 2. Al comparar un aspirante cuyos aóos de experiencia sean iguales a los de otro el resultado debe ser 0. <br>
     * 3. Al comparar un aspirante cuyos aóos de experiencia sean mayores a los de otro el resultado debe ser 1.
     */

    public void testCompararPorAniosExperiencia( )
    {
        setupEscenario1( );

        assertEquals( "El aspirante 1 deberóa ser menor", - 1, aspirante1.compararPorAniosExperiencia( aspirante2 ) );
        assertEquals( "El aspirante 1 y el aspirante 1 deberóan ser iguales", 0, aspirante1.compararPorAniosExperiencia( aspirante1 ) );
        assertEquals( "El aspirante 2 deberóa ser mayor", 1, aspirante2.compararPorAniosExperiencia( aspirante1 ) );
    }

    /**
     * Verifica el mótodo compararPorEdad. <br>
     * <b> Mótodos a probar: </b> <br>
     * compararPorEdad. <br>
     * <b> Objetivo: </b> Probar que el mótodo compararPorEdad realiza la comparación de dos aspirantes de forma correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comparar un aspirante cuya edad sea menor a la del otro el resultado debe ser -1. <br>
     * 2. Al comparar un aspirante cuya edad sea igual a la del otro el resultado debe ser 0. <br>
     * 3. Al comparar un aspirante cuya edad sea mayor a la del otro el resultado debe ser 1.
     */
    public void testCompararPorEdad( )
    {
        setupEscenario1( );

        assertEquals( "El aspirante 1 deberóa ser menor", - 1, aspirante1.compararPorEdad( aspirante2 ) );
        assertEquals( "El aspirante 1 y el aspirante 1 deberóan ser iguales", 0, aspirante1.compararPorEdad( aspirante1 ) );
        assertEquals( "El aspirante 2 deberóa ser mayor", 1, aspirante2.compararPorEdad( aspirante1 ) );
    }

    /**
     * Verifica el mótodo compararPorProfesion. <br>
     * <b> Mótodos a probar: </b> <br>
     * compararPorProfesion. <br>
     * <b> Objetivo: </b> Probar que el mótodo compararPorProfesion realiza la comparación de dos aspirantes de forma correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al comparar un aspirante cuya profesión sea menor lexicogróficamente a la del otro el resultado debe ser -1. <br>
     * 2. Al comparar un aspirante cuya profesión sea igual lexicogróficamente a la del otro el resultado debe ser 0. <br>
     * 3. Al comparar un aspirante cuya profesión sea mayor lexicogróficamente a la del otro el resultado debe ser 1.
     */
    public void testCompararPorProfesion( )
    {
        setupEscenario1( );

        assertEquals( "El aspirante 1 deberóa ser menor", - 1, aspirante1.compararPorProfesion( aspirante2 ) );
        assertEquals( "El aspirante 1 y el aspirante 1 deberóan ser iguales", 0, aspirante1.compararPorProfesion( aspirante1 ) );
        assertEquals( "El aspirante 2 deberóa ser mayor", 1, aspirante2.compararPorProfesion( aspirante1 ) );
    }

}