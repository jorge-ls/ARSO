package servicio.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.sun.jersey.api.client.ClientResponse.Status;

import servicio.controlador.CiudadesFavoritas;
import servicio.controlador.GeonamesException;
import servicio.controlador.ServicioGeoNames;
import servicio.tipos.Ciudad;
import servicio.tipos.ListadoCiudades;

@Path("ciudades")
public class ServicioRestGeonames {
	
	@Context private UriInfo uriInfo;
	private ServicioGeoNames controlador = new ServicioGeoNames();
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getResultadoBusquedaXML(@QueryParam("busqueda") String busqueda) throws GeonamesException{
		ListadoCiudades ciudades = controlador.getResultdoBusquedaXML(busqueda);
		return Response.status(Status.OK).entity(ciudades).build();
	}
	
	@GET
	@Path("/{idGeonames}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getCiudad(@PathParam("idGeonames") String id) throws GeonamesException{
		Ciudad ciudad = controlador.getCiudad(id);
		return Response.status(Status.OK).entity(ciudad).build();
	}
	
	@POST
	@Path("/favoritas")
	public Response crearDocumentoFavoritos() throws GeonamesException {
		String idDocumento = controlador.crearDocumentoFavoritos();
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(idDocumento);
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("/favoritas/{idDocumento}/{idGeonames}")
	public Response addCiudadFavorita(
				@PathParam("idDocumento") String idDocumento, 
				@PathParam("idGeonames") String idGeoNames) throws GeonamesException{
		controlador.addCiudadFavorita(idDocumento, idGeoNames);
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/favoritas/{idDocumento}/{idGeonames}")
	public Response removeCiudadFavorita(
				@PathParam("idDocumento") String idDocumento, 
				@PathParam("idGeonames") String idGeoNames) throws GeonamesException{
		controlador.removeCiudadFavorita(idDocumento, idGeoNames);
		return Response.noContent().build();
	}
	
	@GET
	@Path("/favoritas/{idDocumento}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getFavoritos(@PathParam("idDocumento") String idDocumento) throws GeonamesException{
		CiudadesFavoritas favoritas = controlador.getFavoritos(idDocumento);
		return Response.status(Status.OK).entity(favoritas).build();
	}
	
	@DELETE
	@Path("/favoritas/{idDocumento}")
	public Response removeDocumentoFavoritos (@PathParam("idDocumento") String idDocumento){
		controlador.removeDocumentoFavoritos(idDocumento);
		return Response.noContent().build();
	}

}
