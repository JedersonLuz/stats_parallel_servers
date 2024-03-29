/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeanServer;

import java.util.ArrayList;
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
    public String getMatrix(@PathParam("id") String id) {
        StringBuilder builder = new StringBuilder();
        float result = 0;
        String[] nums = id.split(",");
        for (int i = 0; i < nums.length; i++) {
            result += Integer.valueOf(nums[i]);
        }
        //return String.valueOf(result/matrix.size());
        return String.valueOf(result/nums.length);
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
