package edu.jobs.interfaz;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.*;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.jobs.mundo.Aspirante;
import edu.jobs.mundo.JobExchange;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Es la clase principal de la interfaz
 */
@SpringBootApplication
public class InterfazBolsaDeEmpleo extends JFrame
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Ruta al archivo de aspirantes
     */
    private static final String ARCHIVO_ASPIRANTES = "data/aspirantes.properties";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la bolsa de empleo
     */
    private final JobExchange jobExchange = new JobExchange();

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el panel donde se muestra la lista de aspirantes
     */
    private PanelLista panelLista;

    /**
     * Es el panel donde se muestran los datos de un aspirante
     */
    private PanelInformacion panelInformacion;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    public InterfazBolsaDeEmpleo()
    {
        loadApplicants(ARCHIVO_ASPIRANTES);
    }

    /**
     * Construye la interfaz e inicializa todos sus componentes.
     *
     * @param archivoAspirantes es el nombre del archivo de propiedades que contiene la información de los aspirantes
     */
    private InterfazBolsaDeEmpleo(String archivoAspirantes)
    {
        loadApplicants(archivoAspirantes);
        setLayout(new GridBagLayout());
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setTitle( "Bolsa de Empleo" );
        setSize( new Dimension( 760, 585 ) );
        setResizable(false);

        // Panel con una imagen decorativa
        var panelImagen = new PanelImagen( );
        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 3;
        add( panelImagen, gbc );

        panelLista = new PanelLista( this );
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add( panelLista, gbc );

        panelInformacion = new PanelInformacion(  );
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add( panelInformacion, gbc );

        JPanel panelOpciones = new JPanel( );
        panelOpciones.setLayout( new GridBagLayout( ) );

        // Panel con las opciones de bósqueda y ordenamiento
        var panelBusquedaOrdenamiento = new PanelBusquedaOrdenamiento( this );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets( 0, 0, 0, 5 );
        panelOpciones.add( panelBusquedaOrdenamiento, gbc );

        // Panel Consultas
        var panelConsultas = new PanelConsultas( this );
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panelOpciones.add( panelConsultas, gbc );

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets( 0, 0, 0, 0 );
        add( panelOpciones, gbc );

        // Es el panel donde se introducen los datos para agregar un aspirante
        var panelAgregar = new PanelAgregarAspirante( this );
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add( panelAgregar, gbc );

        // Es el panel donde estón los botones para los puntos de extensión
        PanelExtension panelExtension = new PanelExtension( this );
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        add( panelExtension, gbc );

        actualizarLista( );
        centrar( );
    }

    // -----------------------------------------------------------------
    // Mótodos
    // -----------------------------------------------------------------
    /**
     * Centra la ventana en la pantalla
     */
    private void centrar( )
    {
        Dimension screen = Toolkit.getDefaultToolkit( ).getScreenSize( );
        int xEsquina = ( screen.width - getWidth( ) ) / 2;
        int yEsquina = ( screen.height - getHeight( ) ) / 2;
        setLocation( xEsquina, yEsquina );
    }

    /**
     * Actualiza la lista de aspirantes
     */
    private void actualizarLista( )
    {
        panelLista.actualizarLista(jobExchange.copy());
    }

    /**
     * Ordena los aspirantes por aóos de experiencia y actualiza la lista
     */
    void ordenarPorAniosExperiencia( )
    {
        jobExchange.sortByExperienceYears();
        panelInformacion.limpiarDatos();
        actualizarLista( );
    }

    /**
     * Ordena los aspirantes por edad y actualiza la lista
     */
    void ordenarPorEdad( )
    {
        jobExchange.sortByAge();
        panelInformacion.limpiarDatos();
        actualizarLista( );
    }

    /**
     * Ordena los aspirantes por profesión y actualiza la lista
     */
    void ordenarPorProfesion( )
    {
        jobExchange.sortByProfession();
        panelInformacion.limpiarDatos();
        actualizarLista( );
    }

    /**
     * Busca un aspirante usando el nombre y cuando lo encuentra lo selecciona en la lista y muestra sus datos
     */
    void buscar( )
    {
        String NombreBuscar = JOptionPane.showInputDialog( this, "Nombre" );
        if( NombreBuscar != null )
        {
            int posicion = jobExchange.findApplicant(NombreBuscar);

            actualizarLista( );
            if( posicion != -1 )
            {
                panelLista.seleccionar( posicion );
                Aspirante p = jobExchange.copy().get(posicion);
                verDatos( p );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "No se encontró el aspirante buscado" );
            }
        }
    }

    /**
     * Muestra los datos de un Aspirante en el panel correspondiente
     * @param aspiranteP El Aspirante del que se quieren ver los datos - aspiranteP != null
     */
    void verDatos( Aspirante aspiranteP )
    {
        panelInformacion.mostrarDatos( aspiranteP );
    }

    /**
     * Agrega un nuevo aspirante
     * @param nombreA El nombre del aspirante - nombreA != null
     * @param profesionA La profesión del aspirante - profesionA es uno de estos { ADMINISTRADOR, INGENIERO_INDUSTRIAL, CONTADOR, ECONOMISTA }
     * @param aniosExperienciaA Aóos de experiencia del aspirante - aniosExperienciaA > 0
     * @param edadA La edad del aspirante - edadA > 0
     * @param telefonoA El telófono del aspirante - telefonoA > 0
     * @param imagenA La ruta a la imagen del aspirante - imagenA != null
     */
    void agregarAspirante( String nombreA, String profesionA, int aniosExperienciaA, int edadA, String telefonoA, String imagenA )
    {
        boolean agregado = jobExchange.addApplicant(nombreA, profesionA, aniosExperienciaA, edadA, telefonoA, imagenA);
        if( agregado )
        {
            actualizarLista( );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No se pudo agregar el aspirante", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Carga los aspirantes iniciales de la bolsa de empleo a partir de un file de propiedades.
     * @param file es el nombre del file de propiedades que contiene la información de los aspirantes - nombre!=null
     */
    private void loadApplicants(@NotNull String file)
    {
        try {
            InputStream in = getClass().getClassLoader().getResourceAsStream(file);
            Properties properties = new Properties();
            assert in != null;
            properties.load(in);

            // Cargar los aspirantes
            String dato = "total.aspirantes";
            String aux = properties.getProperty(dato);
            int size = Integer.parseInt(aux);

            for (int cont = 1; cont <= size; cont++) {
                // Carga un aspirante
                dato = "aspirante" + cont + ".nombre";
                String nombre = properties.getProperty(dato);

                dato = "aspirante" + cont + ".profesion";
                String profesion = properties.getProperty(dato);

                dato = "aspirante" + cont + ".experiencia";
                aux = properties.getProperty(dato);
                int experiencia = Integer.parseInt( aux );

                dato = "aspirante" + cont + ".edad";
                aux = properties.getProperty(dato);
                int edad = Integer.parseInt( aux );

                dato = "aspirante" + cont + ".telefono";
                String telefono = properties.getProperty(dato);

                dato = "aspirante" + cont + ".imagen";
                String imagen = properties.getProperty(dato);

                // Sólo se carga el aspirante si los datos son correctos
                if( nombre != null && profesion != null && telefono != null && imagen != null && edad >= 0 && experiencia > 0 )
                    jobExchange.addApplicant(nombre, profesion, experiencia, edad, telefono, imagen);
            }
        }
        catch( FileNotFoundException e )
        {
            JOptionPane.showMessageDialog(
                    this, "No se encontró el file para cargar la información de los aspirantes",
                    "Error", JOptionPane.ERROR_MESSAGE );
        }
        catch( IOException e )
        {
            JOptionPane.showMessageDialog(
                    this, "El file con la información de los aspirantes no tiene el formato esperado",
                    "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Busca el aspirante mós joven de la bolsa de empleos y muestra sus datos en el panel información
     */
    void buscarMasJoven( )
    {
        int posicion = jobExchange.findApplicantYounger();

        actualizarLista( );
        if( posicion != -1 )
        {
            panelLista.seleccionar( posicion );
            Aspirante a = jobExchange.copy().get(posicion);
            verDatos( a );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Aón no hay hojas de vida de aspirantes", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Busca el aspirante con mayor edad de la bolsa de empleos y muestra sus datos en el panel información
     */
    void buscarMayorEdad( )
    {
        int posicion = jobExchange.buscarAspiranteMayorEdad();

        actualizarLista( );
        if( posicion != -1 )
        {
            panelLista.seleccionar( posicion );
            Aspirante a = jobExchange.copy().get(posicion);
            verDatos( a );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Aón no hay hojas de vida de aspirantes", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Busca el aspirante con mayor experiencia de la bolsa de empleos y muestra sus datos en el panel información
     */
    void buscarMayorExperiencia( )
    {
        int posicion = jobExchange.buscarAspiranteMayorExperiencia();

        actualizarLista( );
        if( posicion != -1 )
        {
            panelLista.seleccionar( posicion );
            Aspirante a = jobExchange.copy().get(posicion);
            verDatos( a );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Aón no hay hojas de vida de aspirantes", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Contrata al aspirante del cual se estón mostrando los datos. <br>
     * <b>post: </b>El aspirante contratado no esta en la lista de aspirantes.
     */
    void contratar( )
    {
        String nombre = panelLista.darNombreSeleccionado( );
        if( nombre == null || !panelLista.haySeleccionado( ) )
        {
            JOptionPane.showMessageDialog( this, "Aón no ha seleccionado un aspirante", "Error", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            boolean contratado = jobExchange.contratarAspirante(nombre);

            if( !contratado )
            {
                JOptionPane.showMessageDialog( this, "No se pudo contratar al aspirante", "Error", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                panelInformacion.limpiarDatos( );
                actualizarLista( );
            }
        }
    }

    /**
     * Elimina los aspirantes la una cantidad de aóos de experiencia menos<br>
     * a la especificada por el usuario
     */
    void eliminarPorExperiencia( )
    {
        String anios = JOptionPane.showInputDialog( this, "Indique los aóos de experiencia" );

        if( anios != null && anios.equals( "" ) )
        {
            JOptionPane.showMessageDialog( this, "Los aóos de experiencia deben ser un valor numórico", "Error", JOptionPane.ERROR_MESSAGE );
        }
        else if( anios != null )
        {
            try
            {
                int cantidadAnios = Integer.parseInt( anios );

                if( cantidadAnios < 0 )
                {
                    JOptionPane.showMessageDialog( this, "Los aóos de experiencia deben ser un valor numórico positivo", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else
                {
                    int eliminados = jobExchange.deleteApplicantByExperience(cantidadAnios);

                    if( eliminados > 0 )
                    {
                        JOptionPane.showMessageDialog( this, "Se eliminaron " + eliminados + " aspirantes", "Aspirantes Eliminados", JOptionPane.INFORMATION_MESSAGE );
                        actualizarLista( );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "No se eliminó ningón aspirante", "Aspirantes Eliminados", JOptionPane.INFORMATION_MESSAGE );
                    }
                }
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, "Los aóos de experiencia deben ser un valor numórico", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Ejecuta el punto de extensión 1
     */
    void reqFuncOpcion1( )
    {
        String respuesta = jobExchange.metodo1();
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Ejecuta el punto de extensión 2
     */
    void reqFuncOpcion2( )
    {
        String respuesta = jobExchange.metodo2();
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Ejecuta la aplicación
     * @param args Son los parómetros de ejecución de la aplicación. No deben usarse.
     */
    public static void main( String[] args)
    {
        if (args.length > 0) {
            if (args[0].equals("-swing")) {
                //FlatIntelliJLaf.install();

                try {
                    new InterfazBolsaDeEmpleo(ARCHIVO_ASPIRANTES).setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            SpringApplication.run(InterfazBolsaDeEmpleo.class, args);
        }
    }

}