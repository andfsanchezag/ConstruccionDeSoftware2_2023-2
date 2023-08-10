package ModeloImp;

import Modelo.Material;

public class MaterialImp implements Material{
	//Atributos
	/*- Identificador. No pueden existir dos materiales en la biblioteca con el mismo
identificador
- Título. El nombre del libro.
- Fecha de registro.
- Cantidad registrada.
- Cantidad actual. Solo puede ser modificada mediante el préstamo, devolución y
adición de unidades registradas.*/
	
	private int identificador;
	private String titulo;
	
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	@Override
	public String saludar() {
		return "holi";
	}
	

}
