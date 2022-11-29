package mx.uv;
import static spark.Spark.*;
import com.google.gson.Gson;

import mx.uv.model.EmpleadoDAO; 
/**
 * Hello world!
 *
 */
public class App {
    public static Gson gson = new Gson();
    public static void main( String[] args )
    {
       // System.out.println( "Hello World!" );
        port(1024);

        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });
        before((req, res) -> res.header("Access-Control-Allow-Origin", "*"));
        before((req, res) -> res.type("application/json"));
        

        get("/empleados", (req, res) -> gson.toJson(EmpleadoDAO.dameEmpleados()));

        
    }
}
