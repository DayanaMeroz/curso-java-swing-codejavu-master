package jtree.tres;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

// Esta clase coge un array de Strings, haciendo que el primer elemento
// del array sea un nodo y el resto sean ramas de ese nodo
// Con ello se consiguen las ramas del �rbol general cuando se pulsa
// el bot�n de test
class Rama {
    DefaultMutableTreeNode r;
    public Rama( String datos[] ) {
        r = new DefaultMutableTreeNode( datos[0] );
        System.out.print ( "Agregando " + datos[0] + ": " );
        for ( int i=1; i < datos.length; i++ ) {
            r.add( new DefaultMutableTreeNode( datos[i] ) );
            System.out.print ( " " + datos[i] );
        }
        System.out.print ( "\n" );
    }

    public DefaultMutableTreeNode node() {
        return( r );
    }
}


public class java1414 extends JPanel {
    String datos[][] = {
        { "Colores","Rojo","Verde","Azul"},
        { "Sabores","Salado","Dulce","Amargo"},
        { "Longitud","Corta","Media","Larga"},
        { "Intensidad","Alta","Media","Baja"},
        { "Temperatura","Alta","Media","Baja"},
        { "Volumen","Alto","Medio","Bajo"},
    };
    static int i=0;
    DefaultMutableTreeNode raiz,rama,seleccion;
    JTree arbol;
    DefaultTreeModel modelo;

    JButton botonPrueba = new JButton( "P�lsame" );

    public java1414() {
        setLayout( new BorderLayout() );
        raiz = new DefaultMutableTreeNode( "ra�z" );
        arbol = new JTree( raiz );
        // Se a�ade el �rbol y se hace sobre un ScrollPane, para
        // que se controle autom�ticamente la longitud del �rbol
        // cuando est� desplegado, de forma que aparecer� una
        // barra de desplazamiento para poder visualizarlo en su
        // totalidad
        add( new JScrollPane( arbol ),BorderLayout.CENTER );
        // Se obtiene el modelo del �rbol
        modelo =(DefaultTreeModel)arbol.getModel();
        // Y se a�ade el bot�n que va a ir incorporando ramas
        // cada vez que se pulse
        botonPrueba.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent evt ) {
                if( i < datos.length ) {
                    rama = new Rama( datos[i++] ).node();
                    // Control de la �tlima selecci�n realizada
                    seleccion = (DefaultMutableTreeNode)
                    arbol.getLastSelectedPathComponent();
                    if( seleccion == null )
                        seleccion = raiz;
                    // El modelo crear� el evento adecuado, y en respuesta
                    // a �l, el �rbol se actualizar� autom�ticamente
                    modelo.insertNodeInto( rama,seleccion,0 );
                    if ( i == datos.length )
                        botonPrueba.setEnabled( false );
                }
            }
        } );

        // Cambio del color del bot�n
        botonPrueba.setBackground( Color.blue );
        botonPrueba.setForeground( Color.white );
        // Se crea un panel para contener al bot�n
        JPanel panel = new JPanel();
        panel.add( botonPrueba );
        add( panel,BorderLayout.SOUTH );
    }


    public static void main( String args[] ) {
        JFrame frame = new JFrame( "Tutorial de Java, Swing" );
        frame.setDefaultCloseOperation( frame.EXIT_ON_CLOSE );
        frame.getContentPane().add( new java1414(),BorderLayout.CENTER );
        frame.setSize( 200,500 );
        frame.setVisible( true );
    }
}