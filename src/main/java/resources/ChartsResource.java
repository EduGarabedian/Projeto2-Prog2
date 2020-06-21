package resources;
import java.util.ArrayList;
import java.util.List;



public class ChartsResource {




    public class ChartsResource {
        ChartsDAO dao;

        public ChartsResource(ChartsDAO dao){
            this.dao=dao;
        }


        public List<Results>getResults(){
            return this.dao.read();
        }

