package pesta�as.sineventos;
import javax.swing.*;

public class PanelSabores extends JPanel
{
	public PanelSabores ( )
	{
		JComboBox lista;
		
		lista = new JComboBox ( );

		lista.addItem ( "Vanilla"   );
		lista.addItem ( "Chocolate" );
		lista.addItem ( "Fresa"     );
		lista.addItem ( "Mandarina" );
		lista.addItem ( "Lim�n"     );

		add ( lista );
	}
}
