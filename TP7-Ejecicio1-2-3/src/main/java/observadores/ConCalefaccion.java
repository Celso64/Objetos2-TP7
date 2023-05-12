package observadores;

public class ConCalefaccion extends SalidaPorConsola {

    private SalidaPorConsola consola;
    private Double limiteInferior;

    public ConCalefaccion(SalidaPorConsola consola, Double limiteInferior) {
	this.consola = consola;
	this.limiteInferior = limiteInferior;
    }

    @Override
    public void notificar(String temperatura) {
	consola.notificar(temperatura);

	String[] valores = temperatura.split(" ");
	Double temp = Double.valueOf(valores[0]);

	if (temp <= this.limiteInferior)
	    System.out.println("Hace frio, se encenderá la caldera");
    }

}
