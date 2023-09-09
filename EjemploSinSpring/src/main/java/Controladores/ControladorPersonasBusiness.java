package Controladores;

import ModeloImp.Biblioteca;
import ModeloImp.Persona;

public interface ControladorPersonasBusiness {
	public void validadorCedula(Biblioteca biblioteca, int cedula) throws Exception;
	public Persona buscarPersona(Biblioteca biblioteca, int cedula) throws Exception;
}
