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

    public RegsResource() {

    }

    @POST
        public Regs create(Regs r){
            this.dao.create(r);
            return r;
        }

        @GET
        public Response read(){
            List<Regs> regsList= dao.read();
            return Response.ok(regsList).build();
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


