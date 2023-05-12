package observadores;

import modelo.Observador;

public class SalidaPorConsola implements Observador {

    @Override
    public void notificar(String temperatura) {
	System.out.println(temperatura);
    }

}
