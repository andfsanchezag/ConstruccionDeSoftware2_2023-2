package Controladores;

public interface ControladorPersonasInput {
	public String validarNombre(String nombre) throws Exception;
	public int validarCedula(String cedula) throws Exception;
	public String validarRol(String rol) throws Exception;
	
}
