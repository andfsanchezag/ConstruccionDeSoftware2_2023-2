package Clasica;

import ModeloImp.MaterialImp;

public class Principal {

	public static void main(String[] args) {
		MaterialImp material1 = new MaterialImp();
		System.out.println(material1);
		material1.setTitulo("el señor de los anillos");
		System.out.println(material1.getTitulo());
		MaterialImp material2 = new MaterialImp();
		System.out.println(material2);
		System.out.println(material2.getTitulo());
		
	}

}
