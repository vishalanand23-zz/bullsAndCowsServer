package server;

import java.sql.Connection;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.PlayResult;

import com.google.gson.Gson;

import db.DbConnection;
import db.QueryHandler;

/**
 * Servlet implementation class InsertResult
 */
@Path("/insert")
public class InsertResult {

    @POST
    @Path("/result")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response doPost(String data) {
    	PlayResult result = new Gson().fromJson(data, PlayResult.class);
    	DbConnection database= new DbConnection();
		Connection connection;
		try {
			connection = database.getConnection();
		} catch (Exception e) {
			return Response.status(500).entity("Data Failed.").build();
		}
		QueryHandler queryHandler= new QueryHandler();
		boolean done = queryHandler.insert(result, connection);
		if (done) {
			return Response.status(200).entity("Data Entered.").build();
		} else {
			return Response.status(500).entity("Data Failed.").build();
		}
	}
}
