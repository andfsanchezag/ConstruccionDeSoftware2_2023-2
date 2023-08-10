package UsandoSpring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ModeloImp.MaterialImp;

public class Principal2 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("Context.xml");
		MaterialImp material1 = contexto.getBean("miPrimerBean", MaterialImp.class);
		MaterialImp material2 = contexto.getBean("miPrimerBean", MaterialImp.class);
		System.out.println(material1);
		material1.setTitulo("el Señor de los anillos");
		System.out.println(material1.getTitulo());
		System.out.println(material2);
		System.out.println(material2.getTitulo());

	}

}
