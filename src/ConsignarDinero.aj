import java.util.List;

import ejemplo.cajero.control.Comando;
import ejemplo.cajero.control.ComandoConsignar;

public aspect ConsignarDinero {
	
	pointcut metodosCargaComandos() : call( * ejemplo.cajero.Cajero.cargaComandos(..));
	
	List<Comando> around(): metodosCargaComandos() {
		
		List<Comando> comandos = proceed();
		
		comandos.add(new ComandoConsignar());
		
		return comandos;
	}
}