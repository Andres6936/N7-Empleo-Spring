package edu.jobs.interfaz;

import edu.jobs.mundo.Profession;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Este es el panel donde se agregan aspirantes
 */
public class PanelAgregarAspirante extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String AGREGAR = "AgregarAspirante";

    private static final String BUSCAR_IMAGEN = "BuscarImagen";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private final InterfazBolsaDeEmpleo principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * El combo para seleccionar la profesión del aspirante
     */
    private final JComboBox<Profession> comboProfesiones;

    /**
     * Es el campo para los aóos de experiencia del aspirante
     */
    private final JTextField txtAniosExperiencia;

    /**
     * Es el campo para la imagen del aspirante
     */
    private final JTextField txtImagen;

    /**
     * Es el campo para el telófono del aspirante
     */
    private final JTextField txtTelefono;

    /**
     * Es el campo para la edad del aspirante
     */
    private final JTextField txtEdad;

    /**
     * Es el campo para el nombre del aspirante
     */
    private final JTextField txtNombre;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa sus componentes
     * @param interfaz Es una referencia a la clase principal de la interfaz - interfaz!=null
     */
    PanelAgregarAspirante( InterfazBolsaDeEmpleo interfaz )
    {
        principal = interfaz;

        setLayout( new GridBagLayout( ) );
        setBorder( new TitledBorder( "Agregar Aspirante" ) );

        // Esta es la etiqueta para el nombre del aspirante
        JLabel etiquetaNombre = new JLabel( "Nombre: " );
        GridBagConstraints gbc;
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        add( etiquetaNombre, gbc );

        txtNombre = new JTextField( "" );
        gbc.gridx = 1;
        add( txtNombre, gbc );

        // Esta es la etiqueta para la edad del aspirante
        JLabel etiquetaEdad = new JLabel( "Edad: " );
        gbc.gridx = 0;
        gbc.gridy = 1;
        add( etiquetaEdad, gbc );

        txtEdad = new JTextField( "" );
        gbc.gridx = 1;
        add( txtEdad, gbc );

        // Esta es la etiqueta para la profesión del aspirante
        JLabel etiquetaProfesion = new JLabel( "Profesión: " );
        gbc.gridx = 0;
        gbc.gridy = 2;
        add( etiquetaProfesion, gbc );

        comboProfesiones = new JComboBox<>(Profession.values());
        gbc.gridx = 1;
        add( comboProfesiones, gbc );

        // Esta es la etiqueta para los aóos de experiencia del aspirante
        JLabel etiquetaAniosExperiencia = new JLabel( "Aóos experiencia: " );
        gbc.gridx = 0;
        gbc.gridy = 3;
        add( etiquetaAniosExperiencia, gbc );

        txtAniosExperiencia = new JTextField( "" );
        gbc.gridx = 1;
        add( txtAniosExperiencia, gbc );

        // Esta es la etiqueta para la imagen del aspirante
        JLabel etiquetaImagen = new JLabel( "Imagen: " );
        gbc.gridx = 0;
        gbc.gridy = 4;
        add( etiquetaImagen, gbc );

        txtImagen = new JTextField( "" );

        // Es el botón que se usa para examinar el disco buscando la imagen del aspirante
        JButton botonExaminar = new JButton( "Examinar" );
        botonExaminar.setActionCommand( BUSCAR_IMAGEN );
        botonExaminar.addActionListener( this );
        JPanel panelImagen = new JPanel( new GridLayout( 1, 3 ) );
        panelImagen.add( txtImagen );
        panelImagen.add( botonExaminar );
        gbc.gridx = 1;
        add( panelImagen, gbc );

        // Esta es la etiqueta para el telófono del aspirante
        JLabel etiquetaTelefono = new JLabel( "Telófono: " );
        gbc.gridx = 0;
        gbc.gridy = 5;
        add( etiquetaTelefono, gbc );

        txtTelefono = new JTextField( "" );
        gbc.gridx = 1;
        add( txtTelefono, gbc );

        JPanel panelBoton = new JPanel( );

        // Es el botón que se usa para agregar un aspirante
        JButton botonAgregar = new JButton( "Agregar hoja de vida" );
        botonAgregar.setActionCommand( AGREGAR );
        botonAgregar.addActionListener( this );
        panelBoton.add( botonAgregar );
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        add( panelBoton, gbc );

    }

    // -----------------------------------------------------------------
    // Mótodos
    // -----------------------------------------------------------------

    /**
     * Este es el mótodo que se ejecuta cuando se hace click sobre un botón
     * @param evento Es el evento del click sobre el botón - evento!=null
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( AGREGAR.equals( comando ) )
        {
            try
            {
                String profesion = ( String )comboProfesiones.getSelectedItem( );
                int aniosExperiencia = Integer.parseInt( txtAniosExperiencia.getText( ) );
                String imagen = txtImagen.getText( );
                String telefono = txtTelefono.getText( );
                int edad = Integer.parseInt( txtEdad.getText( ) );
                String nombre = txtNombre.getText( );

                assert profesion != null;
                if( nombre.equals( "" ) || profesion.equals( "" ) || imagen.equals( "" ) || telefono.equals( "" ) || nombre.equals( " " ) )
                {
                    JOptionPane.showMessageDialog( this, "Debe ingresar valores en todos los campos", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else
                {
                    if( nombre.startsWith( " " ) )
                    {
                        JOptionPane.showMessageDialog( this, "El campo nombre no puede empezar con espacio en blanco ", "Error", JOptionPane.ERROR_MESSAGE );
                    }
                    if( aniosExperiencia < 1 || edad < 1 )
                    {
                        JOptionPane.showMessageDialog( this, "Los campos edad y aóos de experiencia deben ser nómeros enteros positivos", "Error", JOptionPane.ERROR_MESSAGE );
                    }
                    else
                    {
                        principal.agregarAspirante( nombre, profesion, aniosExperiencia, edad, telefono, imagen );

                        txtAniosExperiencia.setText( "" );
                        txtImagen.setText( "" );
                        txtTelefono.setText( "" );
                        txtEdad.setText( "" );
                        txtNombre.setText( "" );
                    }
                }
            }
            catch( NumberFormatException e )
            {
                JOptionPane.showMessageDialog( this, "Los campos edad y aóos de experiencia deben ser numóricos", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( BUSCAR_IMAGEN.equals( comando ) )
        {
            JFileChooser fc = new JFileChooser( "./data" );
            fc.setDialogTitle( "Buscar imagen del aspirante" );
            fc.setMultiSelectionEnabled( false );

            int resultado = fc.showOpenDialog( this );
            if( resultado == JFileChooser.APPROVE_OPTION )
            {
                String imagen = fc.getSelectedFile( ).getAbsolutePath( );
                txtImagen.setText( imagen );
            }
        }

    }
}
