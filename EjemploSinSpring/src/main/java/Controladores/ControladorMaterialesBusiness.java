package Controladores;

import ModeloImp.Biblioteca;
import ModeloImp.Material;

public interface ControladorMaterialesBusiness {
	public void validarIdentificador(Biblioteca biblioteca,int identificador) throws Exception;
	public Material buscarMaterial(Biblioteca biblioteca, int identificador) throws Exception; 
}
