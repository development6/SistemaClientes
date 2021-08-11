package servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ArchivoServicio extends Exportador {

	@Override
	public void exportarDatos(String fileName, List<Cliente> listaClientes) {
		try {
			File fl=new File(fileName);
			FileWriter fw=new FileWriter(fl);
			PrintWriter pw= new PrintWriter(fw);
			
			for(Cliente cl:listaClientes) {
				String categoria="Activo";
				if(cl.getNombreCategoria().equals(CategoriaEnum.ACTIVO)) {
					categoria="Activo";
				}
				else if(cl.getNombreCategoria().equals(CategoriaEnum.INACTIVO)) {
					categoria="Inactivo";
				}
				pw.println("Datos Cliente:");
				pw.println("RUN: "+cl.getRutCliente());
				pw.println("Nombre: "+cl.getNombreCliente());
				pw.println("Apellido: "+cl.getApellidoCliente());
				pw.println("Años como cliente: "+cl.getAniosCliente());
				pw.println("Categoria: "+categoria);
				pw.println();
				
			}
			pw.close();
			System.out.println("El archivo Txt ha sido generado exitosamente\n");
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}

	public void cargarDatos(String fileName, List<Cliente> listaClientes, String ruta) {

		try {
			String rutaArchivo=ruta + "\\"+ fileName;
			File archivo = new File(rutaArchivo);
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();

			while (line != null) {
				String[] valores = line.split(",");
				if (valores.length == 5) {
					Cliente cl = new Cliente();
					cl.setRutCliente(valores[0]);
					cl.setNombreCliente(valores[1]);
					cl.setApellidoCliente(valores[2]);
					cl.setAniosCliente(valores[3]);
					CategoriaEnum categoria = CategoriaEnum.ACTIVO;
					if (valores[4].equals("Activo")) {
						categoria = CategoriaEnum.ACTIVO;
					} else if (valores[4].equals("Inactivo")) {
						categoria = CategoriaEnum.INACTIVO;
					}
					cl.setNombreCategoria(categoria);
					listaClientes.add(cl);
				}
				line = br.readLine();
			}
			br.close();
			System.out.println("Datos cargados correctamente en la lista\n");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
