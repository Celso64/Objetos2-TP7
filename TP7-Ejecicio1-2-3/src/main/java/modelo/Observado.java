package modelo;

import java.util.List;

public abstract class Observado {

    protected List<Observador> observadores;

    protected void notificar(String temperatura) {
	this.observadores.forEach(x -> x.notificar(temperatura));
    }

}
