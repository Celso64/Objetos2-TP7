package modelo;

import api.ClimaDAO;

public class ApiClimaOnline implements ClimaOnline {

    private ClimaDAO clima;

    public ApiClimaOnline(ClimaDAO climaDAO) {
	this.clima = climaDAO;
    }

    @Override
    public String temperatura() {
	Clima clima = this.clima.getClimaPorCiudad().orElseThrow();
	String res = clima.getTemperatura().toString() + " c";
	return res;
    }

}
