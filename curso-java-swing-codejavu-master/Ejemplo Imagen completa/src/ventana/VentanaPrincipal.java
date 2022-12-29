package ventana;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class VentanaPrincipal extends JFrame{
	
	 private Dimension tama�oPantalla;
	 private Rectangle pantalla;
	public ImageIcon icono;
	 Panel miPanel;
	
	public VentanaPrincipal(){
		
   		/**Asigna un titulo a la barra de titulo*/
		setTitle("CoDejaVu : Imagenes en Java");
		/**tama�o de la ventana en caso de que no se tome
		 * el tama�o por defecto*/
		setSize(500,520);
		/**pone la ventana en el Centro de la pantalla*/
		setLocationRelativeTo(null);
		this.setLocationRelativeTo(null);
		/**capturamos el tama�o de la pantalla el pc y lo asignamos
		 * al tama�o de la ventana*/
        tama�oPantalla= Toolkit.getDefaultToolkit().getScreenSize();
        pantalla=new Rectangle(tama�oPantalla); 
        setBounds(pantalla);
        /**permite iniciar las propiedades de los componentes*/
		iniciarComponentes();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Metodo que permite iniciar los componentes, en este caso
	 * creamos un objeto panel que corresponde a la clase donde
	 * cargamos y redimensionamos la imagen, este panel se lo 
	 * asignamo a la ventana
	 */
	private void iniciarComponentes() {
		miPanel=new Panel();
		this.setContentPane(miPanel);
	}
}
