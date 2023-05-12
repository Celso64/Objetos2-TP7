package modelo;

import java.util.Properties;
import java.util.ResourceBundle;

public abstract class ApiManager {

    public static Properties getProperties(String nombrePropiedades) {

	Properties propiedades = new Properties();

	try {
	    ResourceBundle infoDataBase = ResourceBundle.getBundle(nombrePropiedades);
	    propiedades.setProperty("apiKey", infoDataBase.getString("api_key"));
	    propiedades.setProperty("codigoPostal", infoDataBase.getString("codigo_postal"));
	    propiedades.setProperty("codigoPais", infoDataBase.getString("codigo_pais"));

	} catch (Exception e1) {
	    throw new RuntimeException("Ocurrio un error al leer la configuraci�n desde el archivo");
	}

	return propiedades;
    }

}
