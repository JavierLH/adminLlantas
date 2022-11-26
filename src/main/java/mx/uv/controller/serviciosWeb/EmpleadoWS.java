package mx.uv.controller.serviciosWeb;

import mx.uv.model.EmpleadoDAO;
import static spark.Spark.*;
import com.google.gson.Gson;



public class EmpleadoWS {

    public static Gson gson = new Gson();
    public static void main( String[] args )
    {
       // System.out.println( "Hello World!" );
        port(80);

        
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

        System.out.println("Hello World!");
        before((req, res) -> res.type("application/json"));
        
        get("/empleados", (req, res) -> gson.toJson(EmpleadoDAO.dameEmpleados()));

        
        
        //empleadosEnJson();
        
    }
   
    
    


    
    
}
