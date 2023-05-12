package domain.model;

import java.util.List;
import java.util.Map;

import domain.portsout.Observer;

public class Observado {

    protected List<Observer> observadores;

    protected void notificar(Map<String, String> datos) {
	this.observadores.forEach(x -> x.notificar(datos));
    }

}
