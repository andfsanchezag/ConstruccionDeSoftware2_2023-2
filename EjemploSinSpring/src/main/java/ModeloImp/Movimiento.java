package ModeloImp;

import java.sql.Date;

public class Movimiento {
	private Material material;
	private Persona persona;
	private Date fecha;
	private String tipo;
	
	public Movimiento() {
		this.setFecha(new Date(System.currentTimeMillis()));
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String mostrarDatos() {
		
		return "\n cedula persona " + persona.getCedula() + " identificador material " + material.getIdentificador() + " fecha " + fecha.toString() + " tipo " + tipo;
	}
}
