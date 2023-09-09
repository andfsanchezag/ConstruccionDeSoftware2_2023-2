package Controladores;

public interface ControladorMovimientos {
	public void realizarPrestamo(int cedula,int identificador) throws Exception;
	public void realizarDevolucion(int cedula,int identificador) throws Exception;
}
