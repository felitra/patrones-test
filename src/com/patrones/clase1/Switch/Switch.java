package com.patrones.clase1.Switch;

public class Switch {

	public static void main(String[] args) {
		Empleado empleado = new Empleado("Jorge", "VendedorPorComision");
		System.out.print(String.format("%s ", empleado.getNombre()));
		System.out.println(String.format("%s ", empleado.obtenerSalario(123)));
	}
}

class Empleado {
	private String nombre;
	private String tipo;

	public Empleado(String nombre, String tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public double obtenerSalario(int cantidadDeComisiones) {
		switch (tipo) {
		case "Gerente":
			return 90000.0;
		case "Secretaria":
			return 15000.0;
		case "Administrativo":
			return 20000.0;
		case "Vendedor":
			return 15000.0;
		case "VendedorPorComision":
			return 15000.0 + (cantidadDeComisiones * 100);
		default:
			break;
		}

		return 0;
	}

	public String getNombre() {
		return nombre;
	}
}
