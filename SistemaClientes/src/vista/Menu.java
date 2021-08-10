package vista;

import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import utilidades.Utilidad;

public class Menu implements InterfMenu{
	
	private ClienteServicio clienteServicio=new ClienteServicio();
	private ArchivoServicio archivoServicio=new ArchivoServicio();
	private ExportadorCsv expCsv=new ExportadorCsv();
	private ExportadorTxt expTxt=new ExportadorTxt();
	String fileName = "Clientes";
	String fileName1 = "DBClientes.csv";
	
	//List<Cliente>listaClientes=new ArrayList<Cliente>();
	
	Scanner sca=new Scanner(System.in);

	@Override
	public void listarCliente() {
		
		clienteServicio.listarCliente();
		
	}

	@Override
	public void agregarCliente() {
		String rutCliente, nombreCliente, apellidoCliente, aniosCliente;
		
		System.out.println("-------------------Crear Cliente-----------------");
		System.out.println("Ingresa RUN del cliente: ");
		rutCliente=sca.nextLine();
		System.out.println("Ingresa Nombre del cliente:");
		nombreCliente=sca.nextLine();
		System.out.println("Ingresa Apellido del cliente:");
		apellidoCliente=sca.nextLine();
		System.out.println("Ingresa años como cliente:");
		aniosCliente=sca.nextLine();
		
		Cliente cliente=new Cliente(rutCliente, nombreCliente, apellidoCliente, aniosCliente);
		clienteServicio.agregarCliente(cliente);
		
	}
	
	@Override
	public void editarCliente() {
		Cliente cliente=new Cliente();
		clienteServicio.editarCliente(cliente);
		
		System.out.println("-------------Editar Cliente-------------");
		System.out.println("1.-Cambiar el estado del Cliente");
		System.out.println("2.-Editar los datos ingresados del Cliente");
		System.out.println("\nIngrese opcion: ");
		int opc;
		opc=sca.nextInt();
		sca.nextLine();
		
		System.out.println("----------------------------------");
		System.out.println("Ingrese RUN del Cliente a editar: ");
		String rut=sca.nextLine();
		
		for(int i=0; i<clienteServicio.listaClientes.size();i++) {
			//System.out.println(clienteServicio.listaClientes.get(i).getRutCliente());
			if(clienteServicio.listaClientes.get(i).getRutCliente().equals(rut)) {
				if(opc==1) {
					int opc11;
					System.out.println("-----Actualizando estado del Cliente----");
					System.out.println("El estado actual es: "+clienteServicio.listaClientes.get(i).getNombreCategoria());
					if(clienteServicio.listaClientes.get(i).getNombreCategoria().equals(CategoriaEnum.ACTIVO)) {
						System.out.println("1.-Si desea cambiar el estado del Cliente a Inactivo");
						System.out.println("2.-Si desea mantener el estado del cliente Activo\n");
						System.out.println("Ingrese opcion: ");
						opc11=sca.nextInt();
						sca.nextLine();
						if(opc11==1) {
							clienteServicio.listaClientes.get(i).setNombreCategoria(CategoriaEnum.INACTIVO);
							System.out.println("Categoria de cliente cambiada\n");
						}
						else {
							clienteServicio.listaClientes.get(i).setNombreCategoria(CategoriaEnum.ACTIVO);
							System.out.println("Categoria de cliente cambiada\n");
						}
						break;
						
						
					}
					if(clienteServicio.listaClientes.get(i).getNombreCategoria().equals(CategoriaEnum.INACTIVO)) {
						System.out.println("1.-Si desea cambiar el estado del Cliente a Activo");
						System.out.println("2.-Si desea mantener el estado del cliente Inactivo\n");
						System.out.println("Ingrese opcion: ");
						opc11=sca.nextInt();
						sca.nextLine();
						if(opc11==1) {
							clienteServicio.listaClientes.get(i).setNombreCategoria(CategoriaEnum.ACTIVO);
							System.out.println("Categoria de cliente cambiada\n");
						}
						else {
							clienteServicio.listaClientes.get(i).setNombreCategoria(CategoriaEnum.INACTIVO);
							System.out.println("Categoria de cliente cambiada\n");
						}
						break;
						
					}
					
					
					//if(listaClientes.get(i).getNombreCategoria().equals(CategoriaEnum.ACTIVO))
						//listaClientes.get(i).setNombreCategoria(CategoriaEnum.INACTIVO);
				}
				else if(opc==2) {
					System.out.println("----Actualizando datos del Cliente-----\n");
					System.out.println("1.-El RUN del Cliente es: "+clienteServicio.listaClientes.get(i).getRutCliente());
					System.out.println("2.-El Nombre del Cliente es: "+clienteServicio.listaClientes.get(i).getNombreCliente());
					System.out.println("3.-El Apellido del Cliente es: "+clienteServicio.listaClientes.get(i).getApellidoCliente());
					System.out.println("4.-Los años como Cliente son: "+ clienteServicio.listaClientes.get(i).getAniosCliente());
					System.out.println("\nIngrese opcion a editar de los datos del cliente:");
					int opc2;
					opc2=sca.nextInt();
					sca.nextLine();
					switch(opc2) {
					case 1:
						String rutNuevo;
						System.out.println("----------------------------------------");
						System.out.println("1.-Ingrese nuevo RUN del Cliente: ");
						rutNuevo=sca.nextLine();
						clienteServicio.listaClientes.get(i).setRutCliente(rutNuevo);
						System.out.println("----------------------------------------");
						System.out.println("Datos cambiados con éxito\n");
						break;
						
					case 2:
						String nombreNuevo;
						System.out.println("----------------------------------------");
						System.out.println("2.-Ingrese nuevo nombre del Cliente: ");
						nombreNuevo=sca.nextLine();
						clienteServicio.listaClientes.get(i).setNombreCliente(nombreNuevo);
						System.out.println("----------------------------------------");
						System.out.println("Datos cambiados con éxito\n");
						break;
						
					case 3:
						String apellidoNuevo;
						System.out.println("----------------------------------------");
						System.out.println("3.-Ingrese nuevo apellido del Cliente: ");
						apellidoNuevo=sca.nextLine();
						clienteServicio.listaClientes.get(i).setApellidoCliente(apellidoNuevo);
						System.out.println("----------------------------------------");
						System.out.println("Datos cambiados con éxito\n");
						break;
						
					case 4:
						String anioNuevo;
						System.out.println("----------------------------------------");
						System.out.println("4.-Ingrese nueva cantidad de años como Cliente: ");
						anioNuevo=sca.nextLine();
						clienteServicio.listaClientes.get(i).setAniosCliente(anioNuevo);
						System.out.println("----------------------------------------");
						System.out.println("Datos cambiados con éxito\n");
						break;
					}
				}
				else {
					System.out.println("Opción inválida");
				}
			}
			else {
				System.out.println("No se ha encontrado información, RUN invalido");
			}
			
			
		}
		
		if(opc==1) {
			
		}
		else if(opc==2) {
			
		}
		else {
			
		}
		
	
	}

	@Override
	public void cargarDatos() {
		System.out.println("---------Cargar Datos en Windows---------------");
		System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv: ");
		String ruta=this.sca.nextLine().trim();
		
		archivoServicio.cargarDatos(fileName1, clienteServicio.listaClientes, ruta);
		
	}

	@Override
	public void exportarDatos() {
		System.out.println("---------Exportar Datos-----------");
		System.out.println("Seleccione el formato a exportar:");
		System.out.println("1.-Formato csv");
		System.out.println("2.-Formato txt");
		System.out.println("\nIngrese una opción para exportar:");
		int opc=sca.nextInt();
		sca.nextLine();
		System.out.println("---------Exportar Datos en Windows---------------");
		
		if(opc==1) {
			System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.csv:");
			String ruta=sca.nextLine().trim();
			String rutaArchivo=ruta+"\\"+fileName+".csv";
			//ExportadorCsv expCsv=new ExportadorCsv();
			expCsv.exportarDatos(rutaArchivo, clienteServicio.listaClientes);
		}
		else if(opc==2){
			System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.txt:");
			String ruta=sca.nextLine().trim();
			String rutaArchivo=ruta+"\\"+fileName+".txt";
			//ExportadorTxt expTxt=new ExportadorTxt();
			expTxt.exportarDatos(rutaArchivo, clienteServicio.listaClientes);
		}
		else {
			System.out.println("Opción inválida");
		}
		
		
	}

	@Override
	public void terminarPrograma() {
		Utilidad util=new Utilidad();
		util.esperar();
		util.limpiar();
		util.mensaje("Acaba de salir del sistema de clientes");
		
	}
	
	
	
	
	public void iniciarMenu() {
	
		int opcion =0;
		do {
			System.out.println("1 Listar Clientes");
			System.out.println("2 Agregar Cliente");
			System.out.println("3 Editar Cliente");
			System.out.println("4 Cargar Datos");
			System.out.println("5 Exportar Datos");
			System.out.println("6 Salir");
			
			System.out.println("Ingrese una opción: ");
			opcion=sca.nextInt();
			sca.nextLine();
			
			switch(opcion) {
			case 1:
				listarCliente();
				break;
			case 2:
				agregarCliente();
				break;
			case 3:
				editarCliente();
				break;
			case 4:
				cargarDatos();
				break;
			case 5:
				exportarDatos();
				break;
			case 6:
				terminarPrograma();
				break;
			default:
				System.out.println("La opción no es válida");
				break;
			
			
			}
			
			
		}while(opcion==1 || opcion==2 || opcion==3 || opcion==4 || opcion==5 );
		
		
	}

	
}
