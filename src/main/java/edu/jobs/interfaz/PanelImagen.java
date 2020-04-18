package edu.jobs.interfaz;

import java.awt.Color;
import java.awt.FlowLayout;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Es el panel donde se muestra una imagen decorativa
 */
final class PanelImagen extends JPanel
{
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     */
    PanelImagen( )
    {
        FlowLayout layout = new FlowLayout( );
        layout.setHgap( 0 );
        layout.setVgap( 0 );
        setLayout( layout );
        //
        // Carga la imagen
        InputStream in = getClass( ).getClassLoader( ).getResourceAsStream( "data/titulo.png" );
        assert in != null;

        try
        {
            ImageIcon icono = new ImageIcon( ImageIO.read( in ) );

            // La agrega a la etiqueta

            // Imagen del titulo
            JLabel imagen = new JLabel( "" );
            imagen.setIcon( icono );
            add( imagen );
        }
        catch ( Exception e )
        {
            System.err.println( e.getMessage( ) );
        }

        // Color de fondo blanco
        setBackground( Color.WHITE );
        setBorder( new LineBorder( Color.GRAY ) );
    }
}