package observadores;

public class ConRefrigeracion extends SalidaPorConsola {

    private SalidaPorConsola consola;
    private Double limiteSuperior;

    public ConRefrigeracion(SalidaPorConsola consola, Double limiteSuperior) {
	this.consola = consola;
	this.limiteSuperior = limiteSuperior;
    }

    @Override
    public void notificar(String temperatura) {
	consola.notificar(temperatura);

	String[] valores = temperatura.split(" ");
	Double temp = Double.valueOf(valores[0]);

	if (temp >= this.limiteSuperior)
	    System.out.println("Hace calor, se encenderá el aire acondicionado");
    }

}
