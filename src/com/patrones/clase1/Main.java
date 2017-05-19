package com.patrones.clase1;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Empleado vendedorPorComision = new VendedorPorComision("Jorge", 123);

		Empleado secretaria = new Secretaria("Cecilia");

		List<Empleado> empleados = Arrays.asList(vendedorPorComision,
				secretaria);

		for (Empleado empleado : empleados) {
			System.out.print(String.format("%s ", empleado.getNombre()));
			System.out.println(String.format("%s\n", empleado.obtenerSalario()));
		}
	}
}

abstract class Empleado {
	private String nombre;

	public Empleado(String nombre) {
		this.nombre = nombre;
	}

	public abstract double obtenerSalario();

	public String getNombre() {
		return nombre;
	}
}

class Secretaria extends Empleado {
	public Secretaria(String nombre) {
		super(nombre);
	}

	@Override
	public double obtenerSalario() {
		return 15000.0;
	}
}

class Gerente extends Empleado {
	public Gerente(String nombre) {
		super(nombre);
	}

	@Override
	public double obtenerSalario() {
		return 90000.0;
	}
}

class Vendedor extends Empleado {
	public Vendedor(String nombre) {
		super(nombre);
	}

	@Override
	public double obtenerSalario() {
		return 15000.0;
	}
}

class VendedorPorComision extends Vendedor {
	private int cantidadDeComisiones;

	public VendedorPorComision(String nombre) {
		super(nombre);
	}

	public VendedorPorComision(String nombre, int cantidadDeComisiones) {
		super(nombre);
		this.cantidadDeComisiones = cantidadDeComisiones;
	}

	@Override
	public double obtenerSalario() {
		return super.obtenerSalario() + cantidadDeComisiones * 100;
	}
}

class Administrativo extends Empleado {
	public Administrativo(String nombre) {
		super(nombre);
	}

	@Override
	public double obtenerSalario() {
		return 20000.0;
	}
}
