package servicio.controlador;

import javax.xml.ws.WebFault;

@SuppressWarnings("serial")
@WebFault
public class GeonamesException extends Exception {

	public GeonamesException(String msg, Throwable causa) {		
		super(msg, causa);
	}
	
	public GeonamesException(String msg) {
		super(msg);		
	}
	
	public String getFaultInfo() {
		
		return getMessage();
	}
	
}
