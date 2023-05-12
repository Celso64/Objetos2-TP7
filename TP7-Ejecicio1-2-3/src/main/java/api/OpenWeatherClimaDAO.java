package api;

import java.io.IOException;
import java.util.Optional;

import com.google.gson.Gson;

import modelo.Ciudad;
import modelo.Clima;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OpenWeatherClimaDAO implements ClimaDAO {

    private static final String URL = "https://api.openweathermap.org/data/2.5/weather?lat=";
    private static final String URL_LON = "&lon=";
    private static final String URL_ID = "&appid=";
    private static final String URL_UNIT = "&units=metric";

    private Gson gson = new Gson();
    private OkHttpClient conexion = new OkHttpClient();
    private Ciudad ciudad;
    private String apiKey;

    public OpenWeatherClimaDAO(Gson gson, OkHttpClient conexion, Ciudad ciudad, String apiKey) {
	this.gson = gson;
	this.conexion = conexion;
	this.ciudad = ciudad;
	this.apiKey = apiKey;
    }

    @Override
    public Optional<Clima> getClimaPorCiudad() {

	Clima clima = null;

	StringBuilder peticion = new StringBuilder(128);

	peticion.append(URL).append(ciudad.getLat()).append(URL_LON).append(ciudad.getLon()).append(URL_ID)
		.append(this.apiKey).append(URL_UNIT);

	Request request = new Request.Builder().url(peticion.toString()).build();

	try (Response response = this.conexion.newCall(request).execute()) {
	    String cuerpo = response.body().string();

	    clima = this.gson.fromJson(cuerpo, Clima.class);

	} catch (IOException e) {
	    throw new RuntimeException(e);
	}

	return Optional.ofNullable(clima);
    }

}
