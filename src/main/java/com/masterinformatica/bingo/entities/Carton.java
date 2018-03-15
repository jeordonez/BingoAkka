package com.masterinformatica.bingo.entities;

import java.util.Random;

public class Carton {

	private static final int ROWS = 4;
	private static final int COLS = 4;
	
	private Casilla[] casillas;
	
	public Carton() {
		this.casillas = new Casilla[ROWS * COLS];
		init();
	}
	
	private void init() {
		Random rand = new Random();
		
		for (int i = 0; i < ROWS; ++i) {
			for (int j = 0; j < COLS; ++j) {
				int number = rand.nextInt(Bombo.MAX_NUMBERS) + 1;
				System.err.println(String.format("i : %d, j : %d", i, j));
				this.casillas[i * ROWS + j] = new Casilla(new Coordenada(i, j), number);				
			}
		}		
	}
	
	public boolean isLinea() {		
		for (int i = 0; i < ROWS; i++) {
			if (!this.casillas[i * ROWS].isMarked()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isBingo() {
		for (int i = 0; i < ROWS; ++i) {
			for (int j = 0; j < COLS; ++j) {
				if (!this.casillas[i * COLS + j].isMarked()) {
					return false;
				}
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		StringBuffer format = new StringBuffer();
		
		format.append("Carton\n");
		for (int i = 0; i < ROWS; ++i) {
			for (int j = 0; j < COLS; ++j) {
				format.append(String.format(" %s ", this.casillas[i * COLS + j].toString()));				
			}
			format.append('\n');
		}
		return format.toString();
	}
}