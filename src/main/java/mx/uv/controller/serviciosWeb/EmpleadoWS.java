package mx.uv.controller.serviciosWeb;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import mx.uv.model.Empleado;
import mx.uv.model.EmpleadoDAO;

@WebService (serviceName = "servicos")
public class EmpleadoWS {
    EmpleadoDAO ed = new EmpleadoDAO();
    @WebMethod (operationName = "listarEmpleados")
    public List<Empleado> listarEmpleados(){
    List datos=ed.dameUsuarios();
    return datos;   
    }
    
}
