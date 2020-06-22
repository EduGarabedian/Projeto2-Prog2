package api;
import java.util.ArrayList;
import java.util.List;

    public class Regs {
        private List<Regs> regs;
        private String date;
        private int acessos;

        public Regs() {
            this.regs = regs;
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

        public List<Regs> getRegs() {
            return regs;
        }
        public void setResults(List<Results> results) {
            this.regs = results == null ? new ArrayList() : results;
        }


    }





