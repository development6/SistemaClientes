package servicio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ExportadorCsv extends Exportador {

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
				pw.println(cl.getRutCliente()+","+cl.getNombreCliente()+","+cl.getApellidoCliente()+","+cl.getAniosCliente()+","+categoria);
			}
			pw.close();
			System.out.println("El archivo Csv ha sido generado exitosamente\n");
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}

}
