package Controladores;

import ModeloImp.Biblioteca;

public interface ControladorMovimientos {
	public void realizarPrestamo(Biblioteca biblioteca,int cedula,int identificador) throws Exception;
	public void realizarDevolucion(Biblioteca biblioteca,int cedula,int identificador) throws Exception;
}
