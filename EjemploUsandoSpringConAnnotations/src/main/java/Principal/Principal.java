package Principal;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import Controladores.ControladorMaterialesBusiness;
import Controladores.ControladorMaterialesInput;
import Controladores.ControladorMovimientos;
import Controladores.ControladorPersonasBusiness;
import Controladores.ControladorPersonasInput;
import ModeloImp.Biblioteca;
import ModeloImp.Material;
import ModeloImp.Persona;

public class Principal {
	public static void main(String args[]) {
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("Contexto.xml");
		Scanner lector = new Scanner(System.in);
		Biblioteca biblioteca = contexto.getBean("Biblioteca",Biblioteca.class);
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
					ControladorPersonasInput controladorInputImp = contexto
							.getBean("controladorInputImp", ControladorPersonasInput.class);
					ControladorPersonasBusiness controladorBusinessImp = contexto.getBean("controladorBusinessImp", ControladorPersonasBusiness.class);
					System.out.println("ingrese el nombre de la persona");
					String nombre = controladorInputImp.validarNombre(lector.next());
					System.out.println("ingrese la cedula de la persona");
					int cedula = controladorInputImp.validarCedula(lector.next());
					controladorBusinessImp.validadorCedula(cedula);
					System.out.println("ingrese el rol de la persona");
					String rol = controladorInputImp.validarRol(lector.next());
					Persona persona = contexto.getBean("Persona",Persona.class);
					persona.setCedula(cedula);
					persona.setNombre(nombre);
					persona.setRol(rol);
					biblioteca.getPersonas().add(persona);
					System.out.println("se agrega persona con datos: " + persona.mostrarDatos());
					break;
				}
				case 2: {
					ControladorMaterialesInput controladorInputImp = contexto.getBean("controladorInputImp", ControladorMaterialesInput.class);
					ControladorMaterialesBusiness controladorBusinessImp = contexto.getBean("controladorBusinessImp", ControladorMaterialesBusiness.class);
					System.out.println("ingrese el titulo del material");
					String titulo = controladorInputImp.validarTitulo(lector.next());
					System.out.println("ingrese la identificador del material");
					int identificador = controladorInputImp.validarIdentificador(lector.next());
					controladorBusinessImp.validarIdentificador(identificador);
					System.out.println("ingrese la cantidad del material");
					int cantidad = controladorInputImp.validarCantidad(lector.next());
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
					ControladorPersonasInput controladorInputImp = contexto.getBean("controladorInputImp", ControladorPersonasInput.class);
					ControladorPersonasBusiness controladorBusinessImp = contexto.getBean("controladorBusinessImp", ControladorPersonasBusiness.class);
					int cedula = controladorInputImp.validarCedula(lector.next());
					Persona persona = controladorBusinessImp.buscarPersona(cedula);
					biblioteca.getPersonas().remove(persona);
					System.out.println("se elimina persona con datos: " + persona.mostrarDatos());
					break;
				}
				case 4: {
					ControladorMovimientos controladorBusinessImp = contexto.getBean("controladorBusinessImp", ControladorMovimientos.class);
					ControladorPersonasInput controladorInputImpPersona = contexto.getBean("controladorInputImp", ControladorPersonasInput.class);
					ControladorMaterialesInput controladorInputImpMaterial = (ControladorMaterialesInput) controladorInputImpPersona;
					System.out.println("ingrese la cedula de la persona");
					int cedula = controladorInputImpPersona.validarCedula(lector.next());
					System.out.println("ingrese la identificador de la persona");
					int identificador = controladorInputImpMaterial.validarIdentificador(lector.next());
					controladorBusinessImp.realizarPrestamo(cedula, identificador);
					break;
				}
				case 5: {
					ControladorMovimientos controladorBusinessImp = contexto.getBean("controladorBusinessImp", ControladorMovimientos.class);
					ControladorPersonasInput controladorInputImpPersona = contexto.getBean("controladorInputImp", ControladorPersonasInput.class);
					ControladorMaterialesInput controladorInputImpMaterial = (ControladorMaterialesInput) controladorInputImpPersona;
					System.out.println("ingrese la cedula de la persona");
					int cedula = controladorInputImpPersona.validarCedula(lector.next());
					System.out.println("ingrese la identificador de la persona");
					int identificador = controladorInputImpMaterial.validarIdentificador(lector.next());
					controladorBusinessImp.realizarDevolucion(cedula, identificador);
					break;
				}
				case 6: {
					ControladorMaterialesInput controladorInputImp = contexto.getBean("controladorInputImp", ControladorMaterialesInput.class);
					ControladorMaterialesBusiness controladorBusinessImp = contexto.getBean("controladorBusinessImp", ControladorMaterialesBusiness.class);
					System.out.println("ingrese la identificador del material");
					int identificador = controladorInputImp.validarIdentificador(lector.next());
					Material material = controladorBusinessImp.buscarMaterial( identificador);
					System.out.println("ingrese la cantidad a incrementar del material");
					int cantidad = controladorInputImp.validarCantidad(lector.next());
					material.setCantidadActual(material.getCantidadActual()+cantidad);
					material.setCantidadRegistrada(material.getCantidadRegistrada()+cantidad);
					System.out.println("se ha incrementado la cantidad al material :" + material.mostrarDatos());			
				}case 7: {
					System.out.println(biblioteca.mostrarMovimientos());
					break;
				}
				case 8 : {
					System.out.println(biblioteca.mostrarPersonas());
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
