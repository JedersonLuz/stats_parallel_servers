/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedianServer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
@Path("median")
public class Median {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Median
     */
    public Median() {
    }

    /**
     * Retrieves representation of an instance of MedianServer.Median
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public String getMatrix(@PathParam("id") String id) {
        StringBuilder builder = new StringBuilder();
        float result = 0;
        String[] nums = id.split(",");
        Arrays.sort(nums);
        if (nums.length % 2 == 0) {
            return String.valueOf((Float.valueOf(nums[(nums.length/2)-1]) + Float.valueOf(nums[(nums.length/2)])) / 2);
        } else {
            return nums[(nums.length/2)];
        }
    }

    /**
     * PUT method for updating or creating an instance of Median
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
