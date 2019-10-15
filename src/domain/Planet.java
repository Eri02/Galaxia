package domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PLANET")
public class Planet implements Serializable{

	private static final long serialVersionUID = 1;
	
	@Id
	@Column(name = "ID")
	private long id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "VELOCIDAD")
	private int velocidad;
	
	@Column(name = "RADIO")
	private long radio;
	
	public Planet() {
		
	}
	
	public Planet(String nombre, int velocidad, long radio) {

		this.nombre = nombre;
		this.velocidad = velocidad;
		this.radio = radio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public long getRadio() {
		return radio;
	}

	public void setRadio(long radio) {
		this.radio = radio;
	}
	
	@Override
	public String toString() {
		return "Planet [nombre=" + nombre + ", velocidad=" + velocidad + ", radio=" + radio + "]";
	}
}
