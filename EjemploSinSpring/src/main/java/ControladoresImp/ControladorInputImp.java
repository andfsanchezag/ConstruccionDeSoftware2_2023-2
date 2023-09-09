package ControladoresImp;

import Controladores.ControladorMaterialesInput;
import Controladores.ControladorPersonasInput;

public class ControladorInputImp extends ControladorInput implements ControladorPersonasInput,ControladorMaterialesInput{

	@Override
	public String validarNombre(String nombre) throws Exception {
		super.stringVacio(nombre, "nombre persona");
		return nombre;
	}

	@Override
	public int validarCedula(String cedula) throws Exception {
		return super.numeroValido(cedula, "cedula persona");
	}

	@Override
	public String validarRol(String rol) throws Exception {
		super.stringVacio(rol, "rol persona");
		if(!(rol.equals("administrativo") || rol.equals("profesor") || rol.equals("estudiante")))
			throw new Exception("el rol debe ser administrativo, profesor o estudiante");
		return rol;
	}

	@Override
	public String validarTitulo(String titulo) throws Exception {
		super.stringVacio(titulo, "titulo material");
		return titulo;
	}

	@Override
	public int validarIdentificador(String Identificador) throws Exception{
		return super.numeroValido(Identificador, "cantidad material");
	}

	@Override
	public int validarCantidad(String cantidad) throws Exception {
		return super.numeroValido(cantidad, "cantidad material");
	}

}
