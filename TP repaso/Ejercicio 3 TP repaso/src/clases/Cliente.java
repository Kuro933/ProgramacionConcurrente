package clases;

public class Cliente {
	
	private String nombre,apellido,Dni;
	
	public Cliente(String nombre, String apellido, String Dni) {
	this.nombre = nombre;
	this.apellido = apellido;
	this.Dni = Dni;
	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}
	
	public String obtenerDatos() {
		String s="";
		
		s+= "Nombre: " + this.nombre + "\n" + "Apellido: " + this.apellido + "\n" + "Dni: " + this.Dni;
		return s;
	}
	

}
