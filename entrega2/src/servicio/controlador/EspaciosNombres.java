package servicio.controlador;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.xml.namespace.NamespaceContext;

public class EspaciosNombres implements NamespaceContext {

    private HashMap<String, String> alias = new HashMap<String, String>();
	
	public EspaciosNombres() {
		alias.put("a","http://www.w3.org/2005/Atom");
		alias.put("dc", "http://purl.org/dc/terms");
	}
	
	@Override
	public Iterator<String> getPrefixes(String namespaceURI) {			
		return alias.keySet().iterator();
	}
	
	@Override
	public String getPrefix(String namespaceURI) {
		
		for (Entry<String, String> entry : alias.entrySet())
			if (entry.getValue().equals(namespaceURI))
				return entry.getKey();		
		
		return null;
	}
	
	@Override
	public String getNamespaceURI(String prefix) {		
		return alias.get(prefix);
	}	
}
