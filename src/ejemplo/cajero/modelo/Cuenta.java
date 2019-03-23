package ejemplo.cajero.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Cuenta {

	private String numero;
	private String clave;
	private long saldo;
	// Lista de logs 
	private ArrayList<String> logDeOperaciones = new ArrayList<String>();
	
	// constructor que recibe la clave y el saldo de la cuenta
	public Cuenta(String numero, String clave, long saldo) {
		this.numero = numero;
		this.clave  = clave;
		this.saldo  = saldo;
	}
	
	// obtiene el número de la cuenta
	public String getNumero() {
		return numero;
	}
	
	// obtiene el valor del saldo
	public long getSaldo() {
		return saldo;
	}
	
	// cambia la clave de la cuenta
	public void cambiarClave(String claveAnterior, String claveNueva) throws Exception {
		
		// cambia la clave si la clave anterior es correcta
		if (this.clave.equals(claveAnterior)) {
			this.clave = claveNueva;
		}
		logOperacion("CAMBIAR_CLAVE");
	}
	
	// hace una consignación
	public void consignar(long valor) throws Exception {
		
		// solo se hace la consignación si el valor es mayor que cero
		if (valor < 0) {
			throw new Exception("No se puede consignar un valor negativo");
		}
		this.saldo += valor;
		logOperacion("CONSIGNAR");
	}
	
	// hace un retiro
	public void retirar(long valor) throws Exception {
		
		// solo se hace el retiro si el valor es mayor que cero
		// y el valor es mayor que el saldo actual
		if (valor < 0) {
			throw new Exception("No se puede retirar un valor negativo");
		}
		if (valor > this.saldo) {
			throw new Exception("No se puede retirar un valor mayor al saldo");
		}
		this.saldo -= valor;
		
		logOperacion("RETIRAR");
	}
	
	private void logOperacion(String operacion) {
		
		String timestamp = LocalDateTime.now().toString();
		long saldo = getSaldo();
		
		String log = "[" + timestamp + "] Cuenta #: " + getNumero() + " | Operacion: " + operacion + " | Saldo: " + saldo;
		
		logDeOperaciones.add(log);
	}
	
	public String getLogDeAuditoria() {
		String resp = "";
		for ( String log : logDeOperaciones) {
			resp += log + "\n";
		}
		
		return resp;
	}
		
}
