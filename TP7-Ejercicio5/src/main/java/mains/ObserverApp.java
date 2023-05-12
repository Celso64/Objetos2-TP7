package mains;

import java.awt.Color;
import java.util.List;

import restaurante.ComarcaPlus;
import restaurante.Mastercard;
import restaurante.Tarjeta;
import restaurante.Viedma;
import restaurante.Visa;
import restaurantealmacenamiento.FakeTicket;
import ui.Caja;
import ui.ConCotaSuperior;
import ui.MontoDisplay;

public class ObserverApp {

    public static void main(String[] args) {

	MontoDisplay display = new ConCotaSuperior(new MontoDisplay(), Color.RED, 300000.0);
	display.setVisible(true);

	List<Tarjeta> tarjetas = List.of(new Viedma(), new Visa(), new Mastercard(), new ComarcaPlus());

	Caja frame = new Caja(new FakeTicket(), tarjetas, List.of(display));
	frame.setVisible(true);

    }

}
