package ejemplo.cajero.control;

import ejemplo.cajero.modelo.Banco;

public class ComandoGenerarArchivoAuditoria implements Comando {

	@Override
	public String getNombre() {
		return "Generar archivo de auditoría";
	}

	@Override
	public void ejecutar(Banco contexto) throws Exception {
		
		System.out.println("Log de auditoria");
		System.out.println();
		
		System.out.println(contexto.getLogDeAuditoria());
		
	}
	
}
