package ModeloImp;

import java.sql.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component()
@Scope("prototype")
public class Material {
	private int identificador;
	private String titulo;
	private Date fechaRegistro;
	private int cantidadRegistrada;
	private int cantidadActual;
	
	public Material() {
		this.setFechaRegistro(new Date(System.currentTimeMillis()));
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getCantidadRegistrada() {
		return cantidadRegistrada;
	}

	public void setCantidadRegistrada(int cantidadRegistrada) {
		this.cantidadRegistrada = cantidadRegistrada;
	}

	public int getCantidadActual() {
		return cantidadActual;
	}

	public void setCantidadActual(int cantidadActual) {
		this.cantidadActual = cantidadActual;
	}
	public String mostrarDatos() {
		return "\n titulo " + titulo +
				"\n identificador " + identificador +
				"\n fechaRegistro " + fechaRegistro +
				"\n cantidadRegistrada " + cantidadRegistrada +
				"\n cantidadActual " + cantidadActual ;
	}
}
