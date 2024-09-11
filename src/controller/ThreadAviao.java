package controller;

import java.util.concurrent.Semaphore;

public class ThreadAviao extends Thread {
	
	int id;
	String pista;
	Semaphore semaforo;
	
	public ThreadAviao(int id, String pista, Semaphore semaforo) {
		super();
		this.id = id;
		this.pista = pista;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		manobrar();
		taxiar();
		decolar();
		afastar();
	}
	
	private void manobrar() {
		int tempo = (int) (Math.random() * (700 - 300 + 1) + 300);
		System.out.println(String.format("Avião %d manobrando na pista %s!", id, pista));
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
	
	private void taxiar() {
		int tempo = (int) (Math.random() * (1000 - 500 + 1) + 500);
		System.out.println(String.format("Avião %d taxiando na pista %s!", id, pista));
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
	
	private void decolar() {
		try {
			semaforo.acquire();
			int tempo = (int) (Math.random() * (800 - 600 + 1) + 600);
			System.out.println(String.format("Avião %d decolando na pista %s!", id, pista));
			sleep(tempo);
			System.out.println(String.format("Avião %d decolou na pista %s!", id, pista));
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		} finally {
			semaforo.release();
		}
	}
	
	private void afastar() {
		int tempo = (int) (Math.random() * (800 - 300 + 1) + 300);
		System.out.println(String.format("Avião %d se afastando na pista %s!", id, pista));
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
}
