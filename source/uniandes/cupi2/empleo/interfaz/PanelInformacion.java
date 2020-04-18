/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelInformacion.java,v 1.9 2007/04/12 03:43:58 carl-veg Exp $ 
 * Universidad de los Andes (Bogotó - Colombia)
 * Departamento de Ingenieróa de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_empleo
 * Autor: Milena Vela - 21-abr-2006
 * Modificación: Silvia de la Torre - 06-jul-2006
 * Autor: Daniel Romero - 22-Nov-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.empleo.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.empleo.mundo.Aspirante;

/**
 * Es el panel donde se muestran los datos de un aspirante
 */
public class PanelInformacion extends JPanel
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Esta constante indica la altura que debe tener la imagen de un individuo
     */
    private static final int ALTURA = 125;

    /**
     * Esta constante indica el ancho que debe tener la imagen de un individuo
     */
    private static final int ANCHO = 200;

    /**
     * El nombre de la imagen vacóa
     */
    private static final String IMANGEN_VACIA = "./data/vacia.jpg";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Imagen para mostrar cuando ya no hayan mós aspirantes en la bolsa
     */
    private ImageIcon imagenVacia;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el campo para la profesión del aspirante
     */
    private JTextField txtProfesion;

    /**
     * Es el campo para los aóos de experiencia del aspirante
     */
    private JTextField txtAniosExperiencia;

    /**
     * Es el campo para el telófono del aspirante
     */
    private JTextField txtTelefono;

    /**
     * Es el campo para la edad del aspirante
     */
    private JTextField txtEdad;

    /**
     * Es el campo para el nombre del aspirante
     */
    private JTextField txtNombre;

    /**
     * Esta es la etiqueta para la profesión del aspirante
     */
    private JLabel etiquetaProfesion;

    /**
     * Esta es la etiqueta para los aóos de experiencia del aspirante
     */
    private JLabel etiquetaAniosExperiencia;

    /**
     * Esta es la etiqueta para el telófono del aspirante
     */
    private JLabel etiquetaTelefono;

    /**
     * Esta es la etiqueta para la edad del aspirante
     */
    private JLabel etiquetaEdad;

    /**
     * Esta es la etiqueta para el nombre del aspirante
     */
    private JLabel etiquetaNombre;

    /**
     * Esta es la etiqueta para la imagen del aspirante
     */
    private JLabel etiquetaImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa sus componentes
     */
    public PanelInformacion(  )
    {
        setLayout( new GridBagLayout( ) );
        setBorder( new TitledBorder( "Datos del Aspirante" ) );

        JPanel panelImagen = new JPanel( );
        etiquetaImagen = new JLabel( );
        etiquetaImagen.setBorder( new LineBorder( Color.BLACK, 1 ) );
        etiquetaImagen.setMinimumSize( new Dimension( 250, 80 ) );
        etiquetaImagen.setMaximumSize( new Dimension( 250, 80 ) );

        imagenVacia = new ImageIcon( IMANGEN_VACIA );
        etiquetaImagen.setIcon( imagenVacia );

        panelImagen.add( etiquetaImagen );

        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets( 0, 0, 0, 10 );
        add( etiquetaImagen, gbc );

        etiquetaNombre = new JLabel( "Nombre: " );
        gbc.gridx = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets( 0, 0, 5, 0 );
        add( etiquetaNombre, gbc );

        txtNombre = new JTextField( "" );
        txtNombre.setEditable( false );
        txtNombre.setPreferredSize( new Dimension( 140, 20 ) );
        gbc.gridx = 2;
        add( txtNombre, gbc );

        etiquetaEdad = new JLabel( "Edad: " );
        gbc.gridx = 1;
        gbc.gridy = 1;
        add( etiquetaEdad, gbc );

        txtEdad = new JTextField( );
        txtEdad.setEditable( false );
        txtEdad.setPreferredSize( new Dimension( 140, 20 ) );
        gbc.gridx = 2;
        add( txtEdad, gbc );

        etiquetaProfesion = new JLabel( "Profesión: " );
        gbc.gridx = 1;
        gbc.gridy = 2;
        add( etiquetaProfesion, gbc );

        txtProfesion = new JTextField( );
        txtProfesion.setEditable( false );
        txtProfesion.setPreferredSize( new Dimension( 140, 20 ) );
        gbc.gridx = 2;
        add( txtProfesion, gbc );

        etiquetaAniosExperiencia = new JLabel( "Experiencia: " );
        gbc.gridx = 1;
        gbc.gridy = 3;
        add( etiquetaAniosExperiencia, gbc );

        txtAniosExperiencia = new JTextField( );
        txtAniosExperiencia.setEditable( false );
        txtAniosExperiencia.setPreferredSize( new Dimension( 140, 20 ) );
        gbc.gridx = 2;
        add( txtAniosExperiencia, gbc );

        etiquetaTelefono = new JLabel( "Telófono: " );
        gbc.gridx = 1;
        gbc.gridy = 4;
        add( etiquetaTelefono, gbc );

        txtTelefono = new JTextField( );
        txtTelefono.setEditable( false );
        txtTelefono.setPreferredSize( new Dimension( 140, 20 ) );
        gbc.gridx = 2;
        add( txtTelefono, gbc );
    }

    // -----------------------------------------------------------------
    // Mótodos
    // -----------------------------------------------------------------

    /**
     * Muestra los datos del aspirante
     * @param aspirante El aspirante del que se quieren mostrar los datos - aspirante != null
     */
    public void mostrarDatos( Aspirante aspirante )
    {
        try
        {
            txtProfesion.setText( aspirante.darProfesion( ) );
            txtAniosExperiencia.setText( String.valueOf( aspirante.darAniosExperiencia( ) + " aóo(s)" ) );
            String imagen = aspirante.darImagen( );
            BufferedImage bImagen;
            bImagen = ImageIO.read( new File( imagen ) );

            Image laImagen = bImagen.getScaledInstance( ( int ) ( ANCHO ), ( int ) ( ALTURA ), Image.SCALE_AREA_AVERAGING );
            etiquetaImagen.setIcon( new ImageIcon( laImagen ) );
            txtTelefono.setText( aspirante.darTelefono( ) );
            txtEdad.setText( String.valueOf( aspirante.darEdad( ) + " aóos" ) );
            txtNombre.setText( aspirante.darNombre( ) );
            validate( );
        }
        catch( IOException e )
        {
            JOptionPane.showMessageDialog( this, "Error al cargar la imagen del aspirante " + aspirante.darNombre( ), "Error", JOptionPane.ERROR_MESSAGE );
        }

    }

    /**
     * Limpia todos los campos
     */
    public void limpiarDatos( )
    {
        txtProfesion.setText( "" );
        txtAniosExperiencia.setText( "" );
        etiquetaImagen.setIcon( imagenVacia );
        txtTelefono.setText( "" );
        txtEdad.setText( "" );
        txtNombre.setText( "" );
    }
}