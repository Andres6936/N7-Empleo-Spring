package edu.jobs.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import edu.jobs.mundo.Aspirante;

/**
 * Es el panel donde se muestra la lista de aspirantes y estón los botones para interactuar con la lista
 */
public class PanelLista extends JPanel implements ListSelectionListener
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazBolsaDeEmpleo principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es la lista que se muestra
     */
    private JList< Aspirante > listaAspirantes;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa todos sus componentes
     * @param interfaz Es una referencia a la clase principal de la interfaz - interfaz != null
     */
    PanelLista( InterfazBolsaDeEmpleo interfaz )
    {
        principal = interfaz;

        setLayout( new BorderLayout( ) );
        setBorder( new TitledBorder( "Aspirantes Registrados en la Bolsa" ) );

        listaAspirantes = new JList<>( );
        listaAspirantes.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        listaAspirantes.addListSelectionListener( this );

        JScrollPane scroll = new JScrollPane( );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setBorder( new CompoundBorder( new EmptyBorder( 3, 3, 3, 3 ), new LineBorder( Color.BLACK, 1 ) ) );
        scroll.getViewport( ).add( listaAspirantes );

        add( scroll, BorderLayout.CENTER );

    }

    // -----------------------------------------------------------------
    // Mótodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la lista de aspirantes que se estó mostrando
     * @param listaActualizada Es una lista con los aspirantes que deben mostrarse
     */
    void actualizarLista( ArrayList< Aspirante > listaActualizada )
    {
        listaAspirantes.setListData( new Vector<>( listaActualizada ) );
        listaAspirantes.setSelectedIndex( 0 );
    }

    /**
     * Selecciona un aspirante de la lista
     * @param seleccionado La posición del aspirante que se debe seleccionar
     */
    void seleccionar( int seleccionado )
    {
        listaAspirantes.setSelectedIndex( seleccionado );
        listaAspirantes.ensureIndexIsVisible( seleccionado );
    }

    /**
     * Cambia la información del aspirante que se esta mostrando de acuerdo al nuevo aspirante seleccionado
     * @param evento El evento de cambio del ótem seleccionado en la lista. evento!=null
     */
    public void valueChanged( ListSelectionEvent evento )
    {
        if( listaAspirantes.getSelectedValue( ) != null )
        {
            Aspirante aspiranteSeleccionado = listaAspirantes.getSelectedValue( );
            principal.verDatos( aspiranteSeleccionado );
        }
    }

    /**
     * Informa si hay algón óndice seleccionado en la lista de aspirantes.
     * @return true si hay un ótem seleccionado, false de lo contrario
     */
    boolean haySeleccionado( )
    {
        return !listaAspirantes.isSelectionEmpty( );
    }

    /**
     * Retorna el nombre del aspirante seleccionado en la lista
     * @return Se retornó el nombre del aspirante seleccionado en la lista o null si no hay selección
     */
    String darNombreSeleccionado( )
    {
        String nombre = null;

        if( listaAspirantes.getSelectedValue( ) != null )
        {
            Aspirante aspiranteSeleccionado = listaAspirantes.getSelectedValue( );
            nombre = aspiranteSeleccionado.getName();
        }

        return nombre;
    }

}