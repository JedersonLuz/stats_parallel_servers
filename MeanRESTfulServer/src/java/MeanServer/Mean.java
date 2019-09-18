/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeanServer;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;

/**
 * REST Web Service
 *
 * @author jederson_luz
 */
@Path("mean")
public class Mean {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Mean
     */
    public Mean() {
    }

    /**
     * Retrieves representation of an instance of MeanServer.Mean
     * @param pathSegment
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public String getMatrix(@PathParam("id") PathSegment pathSegment) {
        StringBuilder builder = new StringBuilder();
        float result = 0;
        MultivaluedMap matrix = pathSegment.getMatrixParameters();
        for(Object key : matrix.entrySet()){
            result += Float.valueOf(key.toString().split("=")[0]);
        }
        return String.valueOf(result/matrix.size());
    }

    /**
     * PUT method for updating or creating an instance of Mean
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
