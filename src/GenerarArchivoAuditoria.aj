
import java.util.List;

import ejemplo.cajero.control.Comando;
import ejemplo.cajero.control.ComandoGenerarArchivoAuditoria;

public aspect GenerarArchivoAuditoria {
	
	pointcut metodosCargaComandos() : call( * ejemplo.cajero.Cajero.cargaComandos(..));
	
	List<Comando> around(): metodosCargaComandos() {
		
		List<Comando> comandos = proceed();
		
		comandos.add(new ComandoGenerarArchivoAuditoria());
		
		return comandos;
	}
}
