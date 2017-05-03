package providers;
import org.testng.annotations.DataProvider;

/**
 * Created by Boss on 01.05.2017.
 */
public class Providers {


    private static final boolean PARALLEL = true;


    @DataProvider(name = "login", parallel = PARALLEL)
    public Object[][] oneMightyDP(){
        return new Object[][]{
                {"cats"},
                {"care"},
                {"free donuts"}
        };
    }
}
