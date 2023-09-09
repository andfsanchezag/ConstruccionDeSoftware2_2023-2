package ControladoresImp;

import Controladores.ControladorMaterialesBusiness;
import Controladores.ControladorMovimientos;
import Controladores.ControladorPersonasBusiness;
import ModeloImp.Biblioteca;
import ModeloImp.Material;
import ModeloImp.Movimiento;
import ModeloImp.Persona;

public class ControladorBusinessImp implements ControladorPersonasBusiness, ControladorMaterialesBusiness, ControladorMovimientos{
	private Biblioteca biblioteca;
	@Override
	public void validadorCedula( int cedula) throws Exception {
		for (Persona persona : getBiblioteca().getPersonas()) {
			if (persona.getCedula()==cedula) {
				throw new Exception("ya existe una persona con esa cedula registrada");
			}
		}
		
	}

	@Override
	public void validarIdentificador(int identificador) throws Exception {
		for (Material material : getBiblioteca().getMateriales()) {
			if (material.getIdentificador()==identificador) {
				throw new Exception("ya existe una persona con esa cedula registrada");
			}
		}
		
	}

	@Override
	public Persona buscarPersona(int cedula) throws Exception {
		for (Persona persona : getBiblioteca().getPersonas()) {
			if (persona.getCedula()==cedula) {
				return persona;
			}
		}
		throw new Exception("no existe una persona con esa cedula registrada");
	}
	@Override
	public Material buscarMaterial(int identificador) throws Exception {
		for (Material material : getBiblioteca().getMateriales()) {
			if (material.getIdentificador()==identificador) {
				return material;
			}
		}
		throw new Exception("no existe un material con esa cedula registrada");
	}

	@Override
	public void realizarPrestamo( int cedula, int identificador) throws Exception {
		Persona persona = buscarPersona(cedula);
		Material material = buscarMaterial(identificador);
		if(material.getCantidadActual()==0) {
			throw new Exception ("no hay mas ejemplares para prestal de ese material");
		}
		if(persona.getPrestamos().size()==persona.getLimitePrestamos()) {
			throw new Exception ("esta persona no puede realizar mas prestamos");
		}
		persona.getPrestamos().add(material);
		material.setCantidadActual(material.getCantidadActual()-1);
		this.crearMovimiento( material, persona, "prestamo");
		System.out.println("se ha realizado el prestamo del material " + material.mostrarDatos());
		System.out.println("a la persona " + persona.mostrarDatos());
	}

	@Override
	public void realizarDevolucion(int cedula, int identificador) throws Exception {
		Persona persona = buscarPersona(cedula);
		Material material = buscarMaterial(identificador);
		this.verificacionPrestamoMaterial(persona,material);
		persona.getPrestamos().remove(material);
		material.setCantidadActual(material.getCantidadActual()+1);
		this.crearMovimiento(material, persona, "devolucion");
		System.out.println("se ha realizado la devolucion del material " + material.mostrarDatos());
		System.out.println("por la persona " + persona.mostrarDatos());
	}

	
	private void crearMovimiento( Material material, Persona persona, String tipo) {
		Movimiento movimiento = new Movimiento();
		movimiento.setMaterial(material);
		movimiento.setPersona(persona);
		movimiento.setTipo(tipo);
		getBiblioteca().getMovimientos().add(movimiento);
	}
	
	private void verificacionPrestamoMaterial(Persona persona, Material material) throws Exception {
		for(Material prestamo: persona.getPrestamos()) {
			if (prestamo.equals(material)) {
				return;
			}
		}
		throw new Exception("la persona no tiene el material registrado entre sus prestamos");
	}

	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
	

}
