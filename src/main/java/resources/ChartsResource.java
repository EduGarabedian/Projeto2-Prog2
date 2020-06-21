package resources;
import api.Charts;
import db.ChartsDao;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("charts")

@Produces(MediaType.APPLICATION_JSON)
public class ChartsResource {


        ChartsDao dao;

        public ChartsResource(ChartsDao dao){
            this.dao=dao;
        }

        @GET
        public List<Charts> getResults(){
            return this.dao.read();
        }

    }


