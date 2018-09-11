package com.sopra.dao;

public class Division_DAO extends Abstract_DAO{

	public Division_DAO(Double op1, Double op2) {
		super(op1, op2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double operar() throws Exception {
		// TODO Auto-generated method stub
		if(super.getOperando2() == 0)
			throw new Exception("Cannot divide by 0");
		
		return super.getOperando1()/super.getOperando2();
		
	}

}
