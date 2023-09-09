package ModeloImp;

import java.util.ArrayList;

public class Biblioteca {
	private ArrayList<Persona> personas;
	private ArrayList<Material> materiales;
	private ArrayList<Movimiento> movimientos;
	
	public Biblioteca(){
		this.setPersonas(new ArrayList<Persona>());
		this.setMateriales(new ArrayList<Material>());
		this.setMovimientos(new ArrayList<Movimiento>());
		
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}

	public ArrayList<Material> getMateriales() {
		return materiales;
	}

	public void setMateriales(ArrayList<Material> materiales) {
		this.materiales = materiales;
	}

	public ArrayList<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(ArrayList<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	
	public String mostrarMovimientos() {
		String historial = "se han registrado los siguientes movimientos:";
		for(Movimiento movimiento : movimientos) {
			historial += movimiento.mostrarDatos();
		}
		return historial;
	}
	
	
}