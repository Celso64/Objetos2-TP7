package main;

import java.util.List;
import java.util.Properties;

import com.google.gson.Gson;

import api.CiudadDAO;
import api.OpenWeatherCiudadDAO;
import api.OpenWeatherClimaDAO;
import modelo.ApiClimaOnline;
import modelo.ApiManager;
import modelo.Medidor;
import observadores.SalidaPorConsola;
import okhttp3.OkHttpClient;

public class App {

    public static void main(String[] args) {

	Properties prop = ApiManager.getProperties("weatherApi");

	String codPostal, codPais, apiKey;

	codPostal = prop.getProperty("codigoPostal");
	codPais = prop.getProperty("codigoPais");
	apiKey = prop.getProperty("apiKey");

	CiudadDAO ciudadDAO = new OpenWeatherCiudadDAO(new Gson(), new OkHttpClient(), codPostal, codPais, apiKey);

	Medidor m = new Medidor(new ApiClimaOnline(
		new OpenWeatherClimaDAO(new Gson(), new OkHttpClient(), ciudadDAO.findCiudad().orElseThrow(), apiKey)),
		List.of(new SalidaPorConsola()));

	m.leerTemperatura();

	// System.out.println(m.leerTemperatura());

    }

}
