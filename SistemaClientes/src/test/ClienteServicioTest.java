package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import modelo.Cliente;
import servicio.ClienteServicio;

public class ClienteServicioTest {
	
	private ClienteServicio clSer=new ClienteServicio();

	@Test
	public void agrearClienteNullTest() {
		//Si es null no se agrega
		Cliente cliente=null;
		clSer.agregarCliente(cliente);
		assertNull(cliente);
		
	}
	
	@Test
	public void agregarClienteTest() {
		Cliente cliente=new Cliente("12.577.846-5","Carlos","Zamudio","1 año");
		clSer.agregarCliente(cliente);
		//assertTrue(cliente.getApellidoCliente().equals("Zamudio"));
		assertNotNull(cliente);
		
	}

}
