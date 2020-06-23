package api;
import java.util.ArrayList;
import java.util.List;

    public class Regs {
        private String term;
        private List<Results> results;

        public Regs(){
            this.results=new ArrayList();
        }

        public Regs(String term, List<Results> data){
            this.term=term;
            this.results= data;
        }

        public String getTerm() {
            return term;
        }

        public List<Results> getResults(){
            return results;
        }

        public void setResults(List<Results> results) {
            this.results = results == null ? new ArrayList() : results;
        }


    }





