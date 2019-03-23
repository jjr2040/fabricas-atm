import ejemplo.cajero.modelo.Cuenta;

public aspect SaldoReducido {
	
	pointcut metodoRetirar(): call ( * ejemplo.cajero.modelo.Cuenta.retirar(..));
	
	void around() throws Exception: metodoRetirar() {
		
		long saldoMenor = 200000;
		
		long valor = (long) thisJoinPoint.getArgs()[0];
		Cuenta cuenta = (Cuenta) thisJoinPoint.getTarget();
		
		if ( (cuenta.getSaldo() - valor) < saldoMenor) {
			throw new Exception("La cuenta no se puede quedar con un saldo menor a " + saldoMenor);
		} 
		
		proceed();	
	}
}