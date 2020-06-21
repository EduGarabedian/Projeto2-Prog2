package db;
import api.Charts;
import java.util.List;


public abstract class ChartsDao {


        abstract boolean create(Charts var1);

        abstract List<Charts> read();

        abstract boolean update(Charts var1);

        abstract boolean delete(Charts var1);



}
