package Controladores;

import ModeloImp.Persona;

public interface ControladorPersonasBusiness {
	public void validadorCedula(int cedula) throws Exception;
	public Persona buscarPersona( int cedula) throws Exception;
}
