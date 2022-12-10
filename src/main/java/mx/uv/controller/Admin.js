function login(){
    var user, password

    user = document.getElementById("Usuario").value;
    password = document.getElementById("Contraseña").value;

    if(user == "Admin" && password == "qwerty"){
        //alert("Bienvenido")
        location.href = "/src/main/java/mx/uv/view/administrador/adminiatradorView.html"
    }else{
        alert("Credenciales incorrectas")
    }

}

function exit(){
    location.href = "/src/main/java/mx/uv/view/login/loginView.html"
}

function Empleados_menu(){
    location.href = "/src/main/java/mx/uv/view/administrador/ev.html"   
}

function Provedores_menu(){
    location.href = "/src/main/java/mx/uv/view/administrador/pv.html"   
}

function Sucursal_menu(){
    location.href = "/src/main/java/mx/uv/view/administrador/sv.html"   
}

function btn_menu(){
    location.href = "/src/main/java/mx/uv/view/administrador/adminiatradorView.html"
}

function empleadoView(){
    var users;
    const tabla = document.querySelector('#cuerpo');
    const opciones ={
      method :'POST'
    }
    axios.get('http://localhost:1024/empleados')
    .then(response => {
        users = response.data;
        users.forEach(element => {
            tabla.innerHTML +=
            `
            <td scope="row">${element.idEmpleado}</td>
            <td>${element.nombre}</td>
            <td>${element.apellidoPaterno}</td>
            <td>${element.apellidoMaterno}</td>
            <td>${element.correoElectronico}</td>
            <td>${element.direccion}</td>
            <td>${element.telefono}</td>
            <td>${element.password}</td>
            <td>${element.estatus}</td>     
            <td>
            <button class="btn btn-warning " style="width: 100%;">Editar</button>
            <button class="btn btn-danger" style="width: 100%;" >Eliminar</button>
            </td>
        ` 
      });
    })
    .catch(e => {console.log(e);}) 
}
