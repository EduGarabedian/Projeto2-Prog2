package resources;
import api.Results;
import db.RegsDao;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("regs")
@Produces(MediaType.APPLICATION_JSON)
public class RegsResource {
        RegsDao dao;

    public RegsResource(RegsDao dao) {
        this.dao=dao;
    }

    @POST
        public Results create(Results results){
            this.dao.create(results);
            return results;
        }

        @GET
        public List<Results> read(){
        return this.dao.read();
        }

        @PUT
        public Results update(Results results){
            if(dao.update(results)){
                return results;
            }
            throw new NotFoundException();
        }

        @DELETE
        @Path("/{date}")
        public Response delete(@PathParam("date") String date){
            if(dao.delete(date)){
                return Response.ok().build();
            }
            throw new NotFoundException();
        }



    }


