package edu.jobs;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import edu.jobs.mundo.Profession;
import junit.framework.TestCase;
import edu.jobs.mundo.Aspirante;
import edu.jobs.mundo.BolsaDeEmpleo;

/**
 * Esta es la clase usada para verificar que los mótodos de la clase BolsaDeEmpleo estón correctamente implementados
 */
public class BolsaDeEmpleoTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la bolsa de empleo sobre la que se van a realizar las pruebas
     */
    private BolsaDeEmpleo bolsa;

    /**
     * La cantidad de aspirantes que hay en la bolsa de empleo.
     */
    private int cantidadAspirantes;

    // -----------------------------------------------------------------
    // Mótodos
    // -----------------------------------------------------------------

    /**
     * Crea un bolsa de empleo a partir del archivo aspirantes1.properties
     */
    private void setupEscenario1( )
    {
        bolsa = new BolsaDeEmpleo( );

        cargarAspirantes( "data/aspirantes1.properties" );

    }

    /**
     * Crea un bolsa de empleo a partir del archivo aspirantes2.properties
     */
    private void setupEscenario2( )
    {
        bolsa = new BolsaDeEmpleo( );
        cargarAspirantes( "data/aspirantes2.properties" );
    }

    /**
     * Crea una bolsa de empleo vacóa
     */
    private void setupEscenario3( )
    {
        bolsa = new BolsaDeEmpleo( );
        cantidadAspirantes = 0;
    }

    /**
     * Verifica el mótodo agregarAspirante agregando correctamente un aspirante. <br>
     * <b> Mótodos a probar: </b> <br>
     * agregarAspirante, buscarAspirante, darAspirante. <br>
     * <b> Objetivo: </b> Probar que el mótodo agregarAspirante() sea capaz de registrar un aspirante en la bolsa de empleo. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar (por nombre) un aspirante previamente agregado se debe obtener una posición diferente de -1 (se debe encontrar) y los datos del aspirante en esa posición
     * deben corresponder a los del aspirante con el nombre correspondiente. <br>
     * 
     */
    public void testAgregarAspirante1( )
    {
        // Configura los datos de prueba
        setupEscenario3( );

        String nombre;
        String profesion;
        int experiencia;
        int edad;
        String telefono;
        String imagen;

        boolean agregado;
        cantidadAspirantes = 10;

        // Agrega un aspirante y luego verifica que se haya agregado de forma correcta
        for( int cont = 1; cont <= cantidadAspirantes; cont++ )
        {
            nombre = "nombre" + cont;
            profesion = Profession.INDUSTRIAL_ENGINEER.name();
            experiencia = cont;
            edad = cont;
            telefono = "telefono" + cont;
            imagen = "imagen" + cont;

            agregado = bolsa.agregarAspirante(nombre, profesion, experiencia, edad, telefono, imagen);
            int pos = bolsa.buscarAspirante(nombre);
            Aspirante aspirante = bolsa.darAspirantes().get(pos);

            assertTrue("El aspirante no se agregó de forma correcta", agregado);
            assertEquals("El aspirante no se agregó de forma correcta", cont - 1, pos);
            assertEquals("El aspirante no se agregó de forma correcta", nombre, aspirante.getName());
            assertEquals("El aspirante no se agregó de forma correcta", profesion, aspirante.getProfessionName());
            assertEquals("El aspirante no se agregó de forma correcta", experiencia, aspirante.getExperienceYears());
            assertEquals("El aspirante no se agregó de forma correcta", edad, aspirante.getAge());
            assertEquals("El aspirante no se agregó de forma correcta", telefono, aspirante.getTelephone());
            assertEquals("El aspirante no se agregó de forma correcta", imagen, aspirante.getImage());
        }
    }

    /**
     * Verifica el mótodo agregarAspirante agregando un aspirante con nombre repetido. <br>
     * <b> Mótodos a probar: </b> <br>
     * agregarAspirante, buscarAspirante, darAspirante. <br>
     * <b> Objetivo: </b> Probar que el mótodo agregarAspirante() no agregue un aspirante en la bolsa de empleo cuando su nombre ya pertenece a otro aspirante registrado. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al agregar un aspirante con nombre repetido el nómero de aspirantes se debe mantener igual y la información de los aspirantes existentes no debe haberse alterado.
     */
    public void testAgregarAspirante2( )
    {
        // Configura los datos de prueba
        setupEscenario1( );

        ArrayList aspirantes = bolsa.darAspirantes( );
        Aspirante a = (Aspirante)aspirantes.get(0);
        String nombreAspirante = a.getName();

        int i = Integer.parseInt( nombreAspirante );
        boolean agregado = bolsa.agregarAspirante( nombreAspirante, nombreAspirante, i, i, nombreAspirante, nombreAspirante );
        assertFalse( "El aspirante no deberóa haberse agregado", agregado );

        String nombre;
        String profesion;
        int experiencia;
        int edad;
        String telefono;
        String imagen;

        // Busca un aspirante y verifica que sus datos estón correctos
        for( int cont = 0; cont < cantidadAspirantes; cont++ ) {
            nombre = "" + (cont + 1);
            profesion = "Administrador";
            experiencia = cont + 1;
            edad = cont + 1;
            telefono = "" + (cont + 1);
            imagen = "" + (cont + 1);

            Aspirante aspirante = (Aspirante)bolsa.darAspirantes().get(cont);

            assertEquals("El aspirante no se agregó de forma correcta", nombre, aspirante.getName());
            assertEquals("El aspirante no se agregó de forma correcta", profesion, aspirante.getProfessionName());
            assertEquals("El aspirante no se agregó de forma correcta", experiencia, aspirante.getExperienceYears());
            assertEquals("El aspirante no se agregó de forma correcta", edad, aspirante.getAge());
            assertEquals("El aspirante no se agregó de forma correcta", telefono, aspirante.getTelephone());
            assertEquals("El aspirante no se agregó de forma correcta", imagen, aspirante.getImage());
        }

    }

    /**
     * Verifica el mótodo buscarAspirante buscando un aspirante que se sabe que deberóa encontrarse. <br>
     * <b> Mótodos a probar: </b> <br>
     * buscarAspirante. <br>
     * <b> Objetivo: </b> Probar que el mótodo buscarAspirante() sea capaz de encontrar aspirantes registrados en la bolsa de empleo. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un aspirante previamente agregado se debe obtener una posición diferente de -1. <br>
     * 2. Al buscar un aspirante que no exista la posición retornada debe ser -1.
     * 
     */
    public void testBuscarAspirante( )
    {
        // Configura los datos de prueba
        setupEscenario2( );

        bolsa.ordenarPorEdad( );
        ArrayList aspirantes = bolsa.darAspirantes( );
        Aspirante a0 = (Aspirante)aspirantes.get(0);
        String nombreAspirante = a0.getName();
        bolsa.ordenarPorProfesion( );

        int posicion = bolsa.buscarAspirante( nombreAspirante );
        assertTrue( "No se encontró el aspirante", posicion != - 1 );

        aspirantes = bolsa.darAspirantes( );
        Aspirante an = ( Aspirante )aspirantes.get( posicion );
        assertEquals("No se encontró el aspirante buscado", an.getName(), nombreAspirante);

        posicion = bolsa.buscarAspirante( "el aspirante no existe" );
        assertEquals( "No se encontró el aspirante buscado", - 1, posicion );
    }

    /**
     * Verifica el mótodo buscarBinarioPorNombre buscando un aspirante que se sabe que deberóa encontrarse. <br>
     * <b> Mótodos a probar: </b> <br>
     * buscarBinarioPorNombre. <br>
     * <b> Objetivo: </b> Probar que el mótodo buscarBinarioPorNombre() sea capaz de encontrar aspirantes registrados en la exposición. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un aspirante previamente agregado se debe obtener una posición diferente de -1. <br>
     * 2. Al buscar un aspirante que no exista la posición retornada debe ser -1.
     * 
     */
    public void testBuscarBinarioPorNombre( )
    {
        // Configura los datos de prueba
        setupEscenario2( );

        bolsa.ordenarPorNombre( );
        ArrayList aspirantes = bolsa.darAspirantes( );

        // Busca el primer aspirante
        Aspirante aspirante = (Aspirante)aspirantes.get(0);
        String nombreAspirante = aspirante.getName();

        int posicion = bolsa.buscarBinarioPorNombre( nombreAspirante );
        assertTrue( "No se encontró el aspirante", posicion != - 1 );

        Aspirante aspiranteNuevo = ( Aspirante )aspirantes.get( posicion );
        assertEquals("No se encontró el aspirante buscado", aspiranteNuevo.getName(), nombreAspirante);

        // Busca el aspirante del medio
        aspirante = (Aspirante)aspirantes.get(cantidadAspirantes / 2);
        nombreAspirante = aspirante.getName();

        posicion = bolsa.buscarBinarioPorNombre( nombreAspirante );
        assertTrue( "No se encontró el aspirante", posicion != - 1 );

        aspiranteNuevo = (Aspirante)aspirantes.get(posicion);
        assertEquals("No se encontró el aspirante buscado", aspiranteNuevo.getName(), nombreAspirante);

        // Busca el aspirante del final
        aspirante = (Aspirante)aspirantes.get(cantidadAspirantes - 1);
        nombreAspirante = aspirante.getName();

        posicion = bolsa.buscarBinarioPorNombre( nombreAspirante );
        assertTrue( "No se encontró el aspirante", posicion != - 1 );

        aspiranteNuevo = (Aspirante)aspirantes.get(posicion);
        assertEquals("No se encontró el aspirante buscado", aspiranteNuevo.getName(), nombreAspirante);

        // Busca un aspirante que no existe
        posicion = bolsa.buscarAspirante( "el aspirante no existe" );
        assertEquals( "No se encontró el aspirante buscado", - 1, posicion );
    }

    /**
     * Verifica el mótodo para ordenar por aóos de experiencia. <br>
     * <b> Mótodos a probar: </b> <br>
     * ordenarPorAniosDeExperiencia. <br>
     * <b> Objetivo: </b> Probar que el mótodo ordenarPorAniosDeExperiencia() ordena la bolsa de empleo de forma correcta (en orden ascendente por aóos de experiencia). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar la bolsa de empleo por aóos de experiencia el aspirante con menor experiencia debe quedar de primero y el de mayor experiencia de óltimo.
     * 
     */
    public void testOrdenarPorAniosDeExperiencia( )
    {
        // Configura los datos de prueba
        setupEscenario2( );

        bolsa.ordenarPorAniosDeExperiencia( );
        ArrayList aspirantes = bolsa.darAspirantes( );

        for( int i = 1; i < aspirantes.size( ); i++ )
        {
            Aspirante a0 = ( Aspirante )aspirantes.get( i - 1 );
            Aspirante a1 = ( Aspirante )aspirantes.get( i );

            assertTrue("No se ordenó bien por aóos de experiencia", a0.getExperienceYears() <= a1.getExperienceYears());
        }
    }

    /**
     * Verifica el mótodo para ordenar por edad. <br>
     * <b> Mótodos a probar: </b> <br>
     * ordenarPorEdad. <br>
     * <b> Objetivo: </b> Probar que el mótodo ordenarPorEdad() ordena la bolsa de empleo de forma correcta (en orden ascendente por edad). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar la bolsa de empleo por edad el aspirante con menor edad debe quedar de primero y el de mayor edad de óltimo.
     * 
     */
    public void testOrdenarPorEdad( )
    {
        // Configura los datos de prueba
        setupEscenario2( );

        bolsa.ordenarPorEdad( );
        ArrayList aspirantes = bolsa.darAspirantes( );
        for( int i = 1; i < aspirantes.size( ); i++ )
        {
            Aspirante a0 = ( Aspirante )aspirantes.get( i - 1 );
            Aspirante a1 = ( Aspirante )aspirantes.get( i );

            assertTrue("No se ordenó bien por edad", a0.getAge() <= a1.getAge());
        }
    }

    /**
     * Verifica el mótodo de ordenar por profesión. <br>
     * <b> Mótodos a probar: </b> <br>
     * ordenarPorProfesion. <br>
     * <b> Objetivo: </b> Probar que el mótodo ordenarPorProfesion() ordena la bolsa de empleo de forma correcta (en orden ascendente por profesión). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al ordenar la bolsa de empleo por profesión los aspirantes deben quedar ordenados por orden alfabótico de acuerdo a su profesión. <br>
     * 
     */
    public void testOrdenarPorProfesion( )
    {
        // Configura los datos de prueba
        setupEscenario2( );

        bolsa.ordenarPorProfesion( );
        ArrayList aspirantes = bolsa.darAspirantes( );
        for( int i = 1; i < aspirantes.size( ); i++ )
        {
            Aspirante a0 = ( Aspirante )aspirantes.get( i - 1 );
            Aspirante a1 = ( Aspirante )aspirantes.get( i );

            assertTrue("No se ordenó bien por profesión", a0.getProfessionName().compareTo(a1.getProfessionName()) <= 0);
        }
    }

    /**
     * Verifica que el mótodo que busca el aspirante mós joven funcione correctamente. <br>
     * <b> Mótodos a probar: </b> <br>
     * buscarAspiranteMasJoven. <br>
     * <b> Objetivo: </b> Probar que el mótodo buscarAspiranteMasJoven() retorna el aspirante correcto (el que tiene menor edad). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar el aspirante con menor edad se debe obtener la posición del aspirante con la edad menor en la bolsa de empleo. <br>
     * 2. Al buscar el aspirante con menor edad en una bolsa vacóa la posición retornada debe ser -1.
     * 
     */
    public void testBuscarAspiranteMasJoven( )
    {
        // Configura los datos de prueba
        setupEscenario2( );

        int posMenor = bolsa.buscarAspiranteMasJoven( );
        ArrayList aspirantes = bolsa.darAspirantes( );
        Aspirante menorBusqueda = ( Aspirante )aspirantes.get( posMenor );

        bolsa.ordenarPorEdad( );
        aspirantes = bolsa.darAspirantes( );
        Aspirante menorOrdenamiento = ( Aspirante )aspirantes.get( 0 );

        assertEquals( "El aspirante de menor edad (el mós joven) no es el correcto", menorBusqueda, menorOrdenamiento );

        setupEscenario3( );
        posMenor = bolsa.buscarAspiranteMasJoven( );
        assertEquals( "El aspirante de menor edad no debe existir", -1, posMenor );

    }

    /**
     * Verifica que el mótodo que busca el aspirante de mayor experiencia funcione correctamente. <br>
     * <b> Mótodos a probar: </b> <br>
     * buscarAspiranteMayorExperiencia. <br>
     * <b> Objetivo: </b> Probar que el mótodo buscarAspiranteMayorExperiencia() retorna el aspirante correcto (el que tiene mayor experiencia). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar el aspirante con mayor experiencia se debe obtener la posición del aspirante con la experiencia mós grande en la bolsa de empleo. <br>
     * 2. Al buscar el aspirante con mayor experiencia en una bolsa vacóa la posición retornada debe ser -1.
     * 
     */
    public void testBuscarAspiranteMayorExperiencia( )
    {
        // Configura los datos de prueba
        setupEscenario2( );

        int posMayor = bolsa.buscarAspiranteMayorExperiencia( );
        ArrayList aspirantes = bolsa.darAspirantes( );
        Aspirante mayorBusqueda = ( Aspirante )aspirantes.get( posMayor );

        bolsa.ordenarPorAniosDeExperiencia( );
        aspirantes = bolsa.darAspirantes( );
        Aspirante mayorOrdenamiento = ( Aspirante )aspirantes.get( aspirantes.size( ) - 1 );

        assertEquals( "El aspirante de mayor experiencia no es el correcto", mayorBusqueda, mayorOrdenamiento );

        setupEscenario3( );
        posMayor = bolsa.buscarAspiranteMayorExperiencia( );
        assertEquals( "El aspirante de mayor experiencia no debe existir", -1, posMayor );

    }

    /**
     * Verifica que el mótodo que contrata un aspirante funcione correctamente. <br>
     * <b> Mótodos a probar: </b> <br>
     * contratarAspirante. <br>
     * <b> Objetivo: </b> Probar que el mótodo contratarAspirante() elimina al aspirante de la lista. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar el aspirante que se contrató la posición retornada debe ser -1. <br>
     * 
     */
    public void testContratarAspirante( )
    {
        // Configura los datos de prueba
        setupEscenario2( );

        bolsa.ordenarPorProfesion( );
        ArrayList aspirantes = bolsa.darAspirantes( );
        Aspirante a0 = (Aspirante)aspirantes.get(0);
        String nombreAspirante = a0.getName();
        bolsa.ordenarPorEdad( );

        bolsa.contratarAspirante( nombreAspirante );
        int posicionEncontrado = bolsa.buscarAspirante( nombreAspirante );
        assertTrue( "No se contrató bien al aspirante", posicionEncontrado == - 1 );
    }

    /**
     * Verifica que el mótodo que un aspirante por su experiencia. <br>
     * <b> Mótodos a probar: </b> <br>
     * eliminarAspirantesPorExperiencia. <br>
     * <b> Objetivo: </b> Probar que el mótodo eliminarAspirantesPorExperiencia() elimina correctamente los aspirantes de la lista. <br>
     * de acuerdo a los aóos de experiencia dados. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que el nómero de aspirantes con menos de X aóos de experiencia es Z. Al eliminar por experiencia los<br>
     * los participantes con menos de X aóos de experiencia se deben borrar Z aspirantes.
     * 
     */
    public void testEliminarAspirantesPorExperiencia( )
    {
        setupEscenario2( );

        assertEquals( "Se debieron eliminar 3 aspirantes", 3, bolsa.eliminarAspirantesPorExperiencia( 5 ) );

        assertEquals( "Se debieron eliminar 3 aspirantes", cantidadAspirantes - 3, bolsa.darAspirantes( ).size( ) );

        setupEscenario1( );

        assertEquals( "Se debió eliminar 1 aspirante", 1, bolsa.eliminarAspirantesPorExperiencia( 2 ) );
        assertEquals( "Se debió eliminar 1 aspirante", cantidadAspirantes - 1, bolsa.darAspirantes( ).size( ) );
    }

    // -----------------------------------------------------------------
    // Mótodos Auxiliares
    // -----------------------------------------------------------------

    /**
     * Carga los aspirantes de la bolsa de empleo especificada a partir de un archivo de propiedades.
     * @param archivo es el nombre del archivo de propiedades que contiene la información de los aspirantes
     */
    private void cargarAspirantes( String archivo )
    {

        try
        {
            InputStream in = getClass( ).getClassLoader( ).getResourceAsStream( archivo );
            Properties propiedades = new Properties( );
            propiedades.load( in );

            // Cargar los aspirantes
            String dato;
            String nombre;
            String profesion;
            int experiencia;
            int edad;
            String telefono;
            String imagen;
            String aux;
            dato = "total.aspirantes";
            aux = propiedades.getProperty( dato );
            cantidadAspirantes = Integer.parseInt( aux );

            for( int cont = 1; cont <= cantidadAspirantes; cont++ )
            {
                // Carga un aspirante
                dato = "aspirante" + cont + ".nombre";
                nombre = propiedades.getProperty( dato );

                dato = "aspirante" + cont + ".profesion";
                profesion = propiedades.getProperty( dato );

                dato = "aspirante" + cont + ".experiencia";
                aux = propiedades.getProperty( dato );
                experiencia = Integer.parseInt( aux );

                dato = "aspirante" + cont + ".edad";
                aux = propiedades.getProperty( dato );
                edad = Integer.parseInt( aux );

                dato = "aspirante" + cont + ".telefono";
                telefono = propiedades.getProperty( dato );

                dato = "aspirante" + cont + ".imagen";
                imagen = propiedades.getProperty( dato );

                bolsa.agregarAspirante( nombre, profesion, experiencia, edad, telefono, imagen );
            }
        }
        catch( Exception e )
        {

            fail( "No se pudo cargar el archivo de aspirantes: " + e.getMessage( ) );
        }
    }

}