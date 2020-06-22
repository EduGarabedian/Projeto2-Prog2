package api;
import java.util.ArrayList;
import java.util.List;

    public class Regs {
        private String term;
        private List<Results> results;
        private String date;
        private int acessos;

        public Regs() {
            this.results = new ArrayList();
        }
        public Regs(String term, String UserName, List<Results> data) {
            this.term = term;
            this.results = data;
            this.date= date;
            this.acessos=acessos;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getAcessos() {
            return acessos;
        }

        public void setAcessos(int acessos) {
            this.acessos = acessos;
        }

        public String getTerm() {
            return term;
        }
        public void setTerm(String term) {
            this.term = term;
        }

        public List<Results> getResults() {
            return results;
        }
        public void setResults(List<Results> results) {
            this.results = results == null ? new ArrayList() : results;
        }


    }





