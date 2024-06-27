package modelLiga;

public class Usuario extends Persona {
private int correo;
private String contraseña;

public Usuario() {
    
}
public Usuario(int correo, String contraseña) {
    this.correo = correo;
    this.contraseña = contraseña;
}
public Usuario(int id, String nombre, String apellido, int edad, int correo, String contraseña) {
    super(id, nombre, apellido, edad);
    this.correo = correo;
    this.contraseña = contraseña;
}
public int getCorreo() {
    return correo;
}
public void setCorreo(int correo) {
    this.correo = correo;
}
public String getContraseña() {
    return contraseña;
}
public void setContraseña(String contraseña) {
    this.contraseña = contraseña;
}
}
