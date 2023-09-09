package Principal;

import java.util.Scanner;

import Controladores.ControladorMaterialesBusiness;
import Controladores.ControladorMaterialesInput;
import Controladores.ControladorMovimientos;
import Controladores.ControladorPersonasBusiness;
import Controladores.ControladorPersonasInput;
import ControladoresImp.ControladorBusinessImp;
import ControladoresImp.ControladorInputImp;
import ModeloImp.Biblioteca;
import ModeloImp.Material;
import ModeloImp.Persona;

public class Principal {

	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		Scanner lector = new Scanner(System.in);
		boolean ejecucion = true;
		while (ejecucion) {
			try {
				System.out.println("ingrese 0 para salir");
				System.out.println("ingrese 1 para registrar persona");
				System.out.println("ingrese 2 para registrar Material");
				System.out.println("ingrese 3 para eliminar persona");
				System.out.println("ingrese 4 para realizar prestamo");
				System.out.println("ingrese 5 para realizar devolucion");
				System.out.println("ingrese 6 para incremetnar cantidad de un material");
				System.out.println("ingrese 7 para ver historial");
				int opcion = lector.nextInt();
				switch (opcion) {
				case 0: {
					ejecucion = false;
					lector.close();
					break;
				}
				case 1: {
					ControladorPersonasInput controladorInput = new ControladorInputImp();
					ControladorPersonasBusiness controladorBusiness = new ControladorBusinessImp();
					System.out.println("ingrese el nombre de la persona");
					String nombre = controladorInput.validarNombre(lector.next());
					System.out.println("ingrese la cedula de la persona");
					int cedula = controladorInput.validarCedula(lector.next());
					controladorBusiness.validadorCedula(biblioteca, cedula);
					System.out.println("ingrese el rol de la persona");
					String rol = controladorInput.validarRol(lector.next());
					Persona persona = new Persona();
					persona.setCedula(cedula);
					persona.setNombre(nombre);
					persona.setRol(rol);
					biblioteca.getPersonas().add(persona);
					System.out.println("se agrega persona con datos: " + persona.mostrarDatos());
					break;
				}
				case 2: {
					ControladorMaterialesInput controladorInput = new ControladorInputImp();
					ControladorMaterialesBusiness controladorBusiness = new ControladorBusinessImp();
					System.out.println("ingrese el titulo del material");
					String titulo = controladorInput.validarTitulo(lector.next());
					System.out.println("ingrese la identificador del material");
					int identificador = controladorInput.validarIdentificador(lector.next());
					controladorBusiness.validarIdentificador(biblioteca, identificador);
					System.out.println("ingrese la cantidad del material");
					int cantidad = controladorInput.validarCantidad(lector.next());
					Material material = new Material();
					material.setTitulo(titulo);
					material.setIdentificador(identificador);
					material.setCantidadActual(cantidad);
					material.setCantidadRegistrada(cantidad);
					biblioteca.getMateriales().add(material);
					System.out.println("se agrega material con datos: " + material.mostrarDatos());
					break;
				}
				case 3: {
					ControladorPersonasInput controladorInput = new ControladorInputImp();
					ControladorPersonasBusiness controladorBusiness = new ControladorBusinessImp();
					int cedula = controladorInput.validarCedula(lector.next());
					Persona persona = controladorBusiness.buscarPersona(biblioteca, cedula);
					biblioteca.getPersonas().remove(persona);
					System.out.println("se elimina persona con datos: " + persona.mostrarDatos());
					break;
				}
				case 4: {
					ControladorMovimientos controladorBusiness = new ControladorBusinessImp();
					ControladorPersonasInput controladorInputPersona = new ControladorInputImp();
					ControladorMaterialesInput controladorInputMaterial = (ControladorMaterialesInput) controladorInputPersona;
					System.out.println("ingrese la cedula de la persona");
					int cedula = controladorInputPersona.validarCedula(lector.next());
					System.out.println("ingrese la identificador de la persona");
					int identificador = controladorInputMaterial.validarIdentificador(lector.next());
					controladorBusiness.realizarPrestamo(biblioteca, cedula, identificador);
					break;
				}
				case 5: {
					ControladorMovimientos controladorBusiness = new ControladorBusinessImp();
					ControladorPersonasInput controladorInputPersona = new ControladorInputImp();
					ControladorMaterialesInput controladorInputMaterial = (ControladorMaterialesInput) controladorInputPersona;
					System.out.println("ingrese la cedula de la persona");
					int cedula = controladorInputPersona.validarCedula(lector.next());
					System.out.println("ingrese la identificador de la persona");
					int identificador = controladorInputMaterial.validarIdentificador(lector.next());
					controladorBusiness.realizarDevolucion(biblioteca, cedula, identificador);
					break;
				}
				case 6: {
					ControladorMaterialesInput controladorInput = new ControladorInputImp();
					ControladorMaterialesBusiness controladorBusiness = new ControladorBusinessImp();
					System.out.println("ingrese la identificador del material");
					int identificador = controladorInput.validarIdentificador(lector.next());
					Material material = controladorBusiness.buscarMaterial(biblioteca, identificador);
					System.out.println("ingrese la cantidad a incrementar del material");
					int cantidad = controladorInput.validarCantidad(lector.next());
					material.setCantidadActual(material.getCantidadActual()+cantidad);
					material.setCantidadRegistrada(material.getCantidadRegistrada()+cantidad);
					System.out.println("se ha incrementado la cantidad al material :" + material.mostrarDatos());			
				}case 7: {
					System.out.println(biblioteca.mostrarMovimientos());
					break;
				}
				default: {
					System.out.println("opcion no valida");
				}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
