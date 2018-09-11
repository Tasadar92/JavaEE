package com.sopra.dao;

public class Multiplicacion extends Abstract_DAO{

	public Multiplicacion(Double op1, Double op2) {
		super(op1, op2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double operar() {
		// TODO Auto-generated method stub
		return super.getOperando1() * super.getOperando2();
		
	}

}
