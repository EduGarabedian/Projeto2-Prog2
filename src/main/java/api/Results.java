package api;

import java.util.ArrayList;
import java.util.List;

public class Results {
    private String date;
    private int acessos;
    private int size;

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date=date;
    }

    public int getAcessos(){
        return acessos;
    }

    public void setAcessos(int acessos){
        this.acessos=acessos;
    }


}
