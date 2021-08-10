package utilidades;

public class Utilidad {
	
	public void esperar() {
		try {
			System.out.print("Abandonando el sistema de clientes");
			for (int i = 0; i < 10; i++) {
				Thread.sleep(1000);
				System.out.print(".");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void limpiar() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	public void mensaje(String mensaje) {
		System.out.println(mensaje);
	}
}
