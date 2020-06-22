package resources;
import api.Regs;
import db.RegsDao;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("charts")

@Produces(MediaType.APPLICATION_JSON)
public class RegsResource {


        RegsDao dao;

        public RegsResource(RegsDao dao){
            this.dao=dao;
        }

        @GET
        public List<Regs> getResults(){
            return this.dao.read();
        }

    }


