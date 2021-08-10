package servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ArchivoServicio extends Exportador {

	@Override
	public void exportarDatos(String fileName, List<Cliente> listaClientes) {
		// TODO Auto-generated method stub

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
