package db;
import api.Charts;


public abstract class ChartsDao {


        abstract boolean create(Charts var1);

        Lista<Charts> read();

        boolean update(Charts var1);

        boolean delete(Charts var1);



}
