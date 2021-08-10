package servicio;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;

public class ClienteServicio {

	public List<Cliente>listaClientes=new ArrayList<Cliente>();

	public ClienteServicio() {
		super();
	}

	public ClienteServicio(List<Cliente> listaClientes) {
		super();
		this.listaClientes = listaClientes;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	@Override
	public String toString() {
		return "ClienteServicio [listaClientes=" + listaClientes + "]";
	}
	

	public void listarCliente() {

		if (listaClientes == null || listaClientes.isEmpty()) {
			System.out.println("No hay datos para mostrar\n");
		} else {
			this.listaClientes.stream().forEach((cliente) -> {
				System.out.println("-----------------Datos del cliente--------------\n");
				System.out.println("RUN del Cliente: " + cliente.getRutCliente());
				System.out.println("Nombre del Cliente: " + cliente.getNombreCliente());
				System.out.println("Apellido del Cliente: " + cliente.getApellidoCliente());
				System.out.println("Años como Cliente: " + cliente.getAniosCliente());
				System.out.println("Categoría del Cliente: " + cliente.getNombreCategoria());
				System.out.println();
			}

			);
		}

	}
	
	
	public void agregarCliente(Cliente cliente) {
		
		if(cliente!=null) {
			this.listaClientes.add(cliente);
		}
		else {
			System.out.println("Valores de cliente vacios");
		}
		System.out.println("Se agregó nuevo cliente\n");
		
	}
	
	public void editarCliente(Cliente cliente) {
		
		if(listaClientes == null || listaClientes.isEmpty()) {
			System.out.println("No hay clientes en la lista para editar");
		}
		
	}
	
	
}
