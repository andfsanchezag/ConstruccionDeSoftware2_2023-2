package ModeloImp;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component()
@Scope("prototype")
public class Persona {
	private String nombre;
	private int cedula;
	private String rol;
	private ArrayList<Material> prestamos;
	private int limitePrestamos;

	public Persona() {
		this.setPrestamos(new ArrayList<Material>());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
		if (rol.equals("administrativo"))
			this.setLimitePrestamos(1);
		if (rol.equals("profesor"))
			this.setLimitePrestamos(3);
		if (rol.equals("estudiante"))
			this.setLimitePrestamos(5);
	}

	public ArrayList<Material> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(ArrayList<Material> prestamos) {
		this.prestamos = prestamos;
	}

	public int getLimitePrestamos() {
		return limitePrestamos;
	}

	public void setLimitePrestamos(int limitePrestamos) {
		this.limitePrestamos = limitePrestamos;
	}
	
	public String mostrarDatos() {
		return "\n nombre: " + this.getNombre() +
				"\n cedula: " + this.getCedula() +
				"\n rol: " + this.getRol() +
				"\n limite de prestamos: " + this.getLimitePrestamos();
	}
}
