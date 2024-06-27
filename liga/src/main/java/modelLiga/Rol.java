package modelLiga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rol {

private int id;
private String nombre;


public static void TipoRol() {
String [] nombresRoles = {"Administrador","Entrenador","Aficionado"};
List<String> rol = Arrays.asList(nombresRoles);
System.out.println(rol);
}



public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}



}