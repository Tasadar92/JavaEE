package com.sopra.dao;

public abstract class Abstract_DAO {

	private Double operando1;
	private Double operando2;
	
	public Abstract_DAO(Double op1, Double op2) {
		
		this.operando1 = op1;
		this.operando2 = op2;
		
	}
	
	public Double getOperando1() {
		return operando1;
	}

	public void setOperando1(Double operando1) {
		this.operando1 = operando1;
	}

	public Double getOperando2() {
		return operando2;
	}

	public void setOperando2(Double operando2) {
		this.operando2 = operando2;
	}

	
	
	public abstract Double operar() throws Exception;
	
}
