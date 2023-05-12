package api;

import java.io.IOException;
import java.util.Optional;

import com.google.gson.Gson;

import modelo.Ciudad;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OpenWeatherCiudadDAO implements CiudadDAO {

    private static final String URL = "http://api.openweathermap.org/geo/1.0/zip?zip=";
    private static final String URL_FIN = "&appid=";

    private Gson gson = new Gson();
    private OkHttpClient conexion = new OkHttpClient();
    private String codigoPostal;
    private String codigoPais;
    private String apiKey;

    public OpenWeatherCiudadDAO(Gson gson, OkHttpClient conexion, String codigoPostal, String codigoPais,
	    String apiKey) {
	this.gson = gson;
	this.conexion = conexion;
	this.codigoPostal = codigoPostal;
	this.codigoPais = codigoPais;
	this.apiKey = apiKey;
    }

    @Override
    public Optional<Ciudad> findCiudad() {

	Ciudad ciudad = null;

	StringBuilder peticion = new StringBuilder(128);

	peticion.append(URL).append(this.codigoPostal).append(",").append(this.codigoPais).append(URL_FIN)
		.append(this.apiKey);

	Request request = new Request.Builder().url(peticion.toString()).build();

	try (Response response = this.conexion.newCall(request).execute()) {
	    String cuerpo = response.body().string();

	    ciudad = this.gson.fromJson(cuerpo, Ciudad.class);

	} catch (IOException e) {
	    throw new RuntimeException(e);
	}

	return Optional.ofNullable(ciudad);
    }

}
