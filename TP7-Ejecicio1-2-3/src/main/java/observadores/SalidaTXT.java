package observadores;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;

import modelo.Observador;

public class SalidaTXT implements Observador {

    private OutputStream salida;

    public SalidaTXT(OutputStream salida) {
	this.salida = salida;
    }

    @Override
    public void notificar(String temperatura) {

	LocalDate hoy = LocalDate.now();

	StringBuilder buffer = new StringBuilder(64);

	buffer.append(temperatura).append(", ").append(hoy.toString());

	try {
	    this.salida.write(buffer.toString().getBytes());
	} catch (IOException e) {
	    throw new RuntimeException(e.getMessage());
	}
    }

}
