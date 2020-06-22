package resources;
import api.Regs;
import db.RegsDao;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("regs")
@Produces(MediaType.APPLICATION_JSON)
public class RegsResource {
        RegsDao dao;

        public RegsResource(RegsDao dao){
            this.dao=dao;
        }

        @POST
        public Regs create(Regs r){
            this.dao.create(r);
            return r;
        }

        @GET
        public List<Regs> getResults(){
            return this.dao.read();
        }

        @PUT
        public Regs update(Regs r){
            if(dao.update(r)){
                return r;
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


