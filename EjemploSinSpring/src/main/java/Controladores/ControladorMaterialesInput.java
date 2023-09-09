package Controladores;

public interface ControladorMaterialesInput {
	public String validarTitulo(String titulo) throws Exception;

	public int validarIdentificador(String Identificador) throws Exception;

	public int validarCantidad(String cantidad) throws Exception;
}
