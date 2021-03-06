package edu.jobs.interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel con las opciones para realización de consultas
 */
public class PanelConsultas extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String CONTRATAR = "Contratar";
    private static final String MAS_JOVEN = "Mós joven";
    private static final String MAYOR_EXPERIENCIA = "Mayor experiencia";
    private static final String MAYOR_EDAD = "Mayor edad";
    private static final String ELIMINAR_POR_EXPERIENCIA = "Eliminar por Experiencia";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazBolsaDeEmpleo principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa sus componentes
     * @param ventanaPrincipal Ventana principal de la aplicación. ventanaPrincipal!=null
     */
    PanelConsultas( InterfazBolsaDeEmpleo ventanaPrincipal )
    {
        principal = ventanaPrincipal;
        setLayout( new GridBagLayout( ) );
        setBorder( new TitledBorder( "Consultas" ) );

        // Es el botón para mostrar la información del aspirante mós joven
        JButton botonMasJoven = new JButton( "Mós Joven" );
        botonMasJoven.addActionListener( this );
        botonMasJoven.setActionCommand( MAS_JOVEN );
        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets( 5, 18, 5, 18 );
        add( botonMasJoven, gbc );

        // Es el botón mostrar la información del aspirante de mayor edad
        JButton botonMayorEdad = new JButton( "Mayor Edad" );
        botonMayorEdad.addActionListener( this );
        botonMayorEdad.setActionCommand( MAYOR_EDAD );
        gbc.gridy = 1;
        add( botonMayorEdad, gbc );

        // Es el botón mostrar la información del aspirante de mayor experiencia
        JButton botonMayorExperiencia = new JButton( "Mayor Experiencia" );
        botonMayorExperiencia.addActionListener( this );
        botonMayorExperiencia.setActionCommand( MAYOR_EXPERIENCIA );
        gbc.gridy = 2;
        add( botonMayorExperiencia, gbc );

        // Es el botón para realizar una contratación
        JButton botonContratar = new JButton( "Contratar" );
        botonContratar.addActionListener( this );
        botonContratar.setActionCommand( CONTRATAR );
        gbc.gridy = 3;
        add( botonContratar, gbc );

        // Es el botón para eliminar los aspirantes po aóos de experiencia
        JButton botonEliminarPorExperiencia = new JButton( "Eliminar por Experiencia" );
        botonEliminarPorExperiencia.addActionListener( this );
        botonEliminarPorExperiencia.setActionCommand( ELIMINAR_POR_EXPERIENCIA );
        gbc.gridy = 4;
        add( botonEliminarPorExperiencia, gbc );

    }

    // -----------------------------------------------------------------
    // Mótodos
    // -----------------------------------------------------------------

    /**
     * Ejecuta una acción segón el botón que se haya presionado
     * @param evento El evento de click sobre un botón. evento!=null
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( MAS_JOVEN.equals( comando ) )
        {
            principal.buscarMasJoven( );
        }
        else if( MAYOR_EXPERIENCIA.equals( comando ) )
        {
            principal.buscarMayorExperiencia( );
        }
        else if( MAYOR_EDAD.equals( comando ) )
        {
            principal.buscarMayorEdad( );
        }
        else if( CONTRATAR.equals( comando ) )
        {
            principal.contratar( );
        }
        else if( ELIMINAR_POR_EXPERIENCIA.equals( comando ) )
        {
            principal.eliminarPorExperiencia( );
        }
    }
}
