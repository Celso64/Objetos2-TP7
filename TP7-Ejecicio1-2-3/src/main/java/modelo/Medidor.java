package modelo;

import java.util.List;

public class Medidor extends Observado {

    private String temperatura;
    private ClimaOnline clima;

    public Medidor(ClimaOnline clima, List<Observador> observadores) {
	this.clima = clima;
	super.observadores = observadores;
    }

    public String leerTemperatura() {
	// leo la temperatura del servicio web
	this.temperatura = this.clima.temperatura();
	super.notificar(temperatura);
	return this.temperatura;
    }

}
