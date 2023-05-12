package ui;

import java.awt.Color;

public class ConCotaSuperior extends MontoDisplay {

    private static final long serialVersionUID = 2L;

    private final Color colorSiLimiteEsSuperado;
    private final Double limite;

    public ConCotaSuperior(MontoDisplay pantalla, Color color, Double limite) {
	this.colorSiLimiteEsSuperado = color;
	this.limite = limite;
    }

    @Override
    public void notificar(Double valorUltimaMesa) {

	if (valorUltimaMesa >= this.limite) {
	    super.setColortexto(colorSiLimiteEsSuperado);
	} else
	    super.setColortexto(COLOR_TEXTO_DEFAULT);

	super.notificar(valorUltimaMesa);
    }

}
