package test;

import org.junit.Test;

import modelo.Cliente;
import servicio.ClienteServicio;

public class ClienteServicioTest {

	private ClienteServicio clSer;
	
	@Test
	public void agregarClienteTest() {
		Cliente cliente=new Cliente("12.577.846-5","Carlos","Zamudio","1 año");
		clSer.agregarCliente(cliente);
	}
	
	@Test
	public void agrearClienteNullTest() {
		Cliente cliente=new Cliente("12.577.846-5","Carlos","Zamudio",null);
	}
}
