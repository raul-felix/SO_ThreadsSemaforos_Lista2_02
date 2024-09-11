package view;

import java.util.concurrent.Semaphore;

import controller.ThreadAviao;

public class Main {
	
	public static void main(String[] args) {
		
		int permissoes = 1;
		Semaphore semaforoNorte = new Semaphore(permissoes);
		Semaphore semaforoSul = new Semaphore(permissoes);
		
		for (int i = 0; i < 12; i++) {
			int num = (int) (Math.random() * 2);
			Thread threadAviao;
			
			if (num % 2 == 0) {
				threadAviao = new ThreadAviao(i, "Norte", semaforoNorte);
			} else {
				threadAviao = new ThreadAviao(i, "Sul", semaforoSul);
			}
			threadAviao.start();
		}
	}

}
