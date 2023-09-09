package Controladores;

import ModeloImp.Material;

public interface ControladorMaterialesBusiness {
	public void validarIdentificador(int identificador) throws Exception;
	public Material buscarMaterial(int identificador) throws Exception; 
}
