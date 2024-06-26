package dots;

import java.util.ArrayList;

public class Heuristica implements Ia {

	private final static int NUM_JOGADAS = 12;
	private final static int NUM_NOS = NUM_JOGADAS - 2;
	private final static int JOGADA_INICIAL = (int) (Math.random() * NUM_JOGADAS);
	private static No raiz = null;

	public Heuristica() {
	}

	@Override
	public void jogadaInicial() {
		Tabuleiro.fazerJogada(JOGADA_INICIAL, true);
	}

	@Override
	public void finalizar() {
		raiz = null;
	}

	public static void percorrerArvore(int jogada) {
		if (jogada == JOGADA_INICIAL)
			return;

		if (raiz == null) {
			TelaCarregamento tc = new TelaCarregamento();
			tc.setVisible(true);
			tc.setEnabled(false);
			raiz = new No(0, createArray(jogada), new No[NUM_NOS], Vez.IA);
			construirArvore(raiz);
			Tabuleiro.setenable(true);
			tc.dispose();
			return;
		}

		ArrayList<Integer> atual = raiz.getJogadas();
		int i = 0;

		while (atual.get(i) != jogada) {
			i++;
		}

		raiz = raiz.getFilhos()[i];
	}

	@Override
	public void jogada() {

		ArrayList<Integer> melhores = new ArrayList<Integer>();
		int jogada = 0;
		
		do {
			melhores.clear();
			No[] atual = raiz.getFilhos();

			if (atual.length == 0)
				return;

			int maior = Integer.MIN_VALUE;
			
			for(int i = 0; i<atual.length; i++) {
				int valor = atual[i].getMinmax();
				
				if(valor > maior) {
					maior = valor;
					melhores.clear();
					melhores.add(i);
				}
				else if(valor == maior) {
					melhores.add(i);
				}
			}
			
			jogada = raiz.getJogadas().get(melhores.get((int) (Math.random() * melhores.size())));

		} while (Tabuleiro.fazerJogada(jogada, true));

	}

	private static void construirArvore(No n) {
		No[] atual = n.getFilhos();
		Vez vez = n.getVez();

		for (int i = 0; i < atual.length; i++) {
			@SuppressWarnings("unchecked")
			ArrayList<Integer> prox = (ArrayList<Integer>) n.getJogadas().clone();
			int num_jogada = prox.remove(i);
			atual[i] = new No(n.getMinmax(), prox, new No[atual.length - 1], defineVez(num_jogada, prox, vez));
			if (vez == Vez.IA && vez == atual[i].getVez()) {
				atual[i].setMinmax(atual[i].getMinmax() + 1);
			}
			construirArvore(atual[i]);
		}

		if (atual.length == 0) {
			if (n.getMinmax() > 2)
				n.setMinmax(1);
			else if (n.getMinmax() < 2)
				n.setMinmax(-1);
			else
				n.setMinmax(0);
		} else {
			int procurado = n.getVez() == Vez.IA ? 1 : -1, countBom = 0, countRuim = 0;
			boolean empate = false, maiorZero;

			for(int i = 0; i<atual.length; i++) {
				maiorZero = atual[i].getMinmax() * procurado > 0;
				
				if(maiorZero) {
					countBom += atual[i].getMinmax();
				}
				else if (atual[i].getMinmax() == 0) {
					empate = true;
				}
				else {
					countRuim += atual[i].getMinmax();
				}
			}

			if (countBom == 0)
				n.setMinmax(empate ? 0 : countRuim);
			else
				n.setMinmax(countBom);
		}

		// �rvore iterativa(funcionando)
		/*
		 * No[][] pais = new No[NUM_NOS][];
		 * 
		 * for (int i = 0; i < NUM_NOS; i++) { n1[i] = new No(0, new No[NUM_NOS]);
		 * pais[i] = n1[i].getFilhos(); }
		 * 
		 * for (int i = NUM_NOS; i > 1; i--) {
		 * 
		 * No[][] paiAux = new No[(i - 1) * pais.length][]; int count = 0;
		 * 
		 * for (int j = 0; j < pais.length; j++) { for (int k = 0; k < (i - 1); k++) {
		 * pais[j][k] = new No(0, new No[i - 2]); paiAux[count++] =
		 * pais[j][k].getFilhos(); } }
		 * 
		 * pais = paiAux;
		 * 
		 * }
		 */
	}

	private static ArrayList<Integer> createArray(int r) {
		ArrayList<Integer> aux = new ArrayList<Integer>();

		for (int i = 0; i < NUM_JOGADAS; i++) {
			aux.add(i);
		}

		aux.remove(JOGADA_INICIAL);
		Integer remove = r;
		aux.remove(remove);

		return aux;
	}

	private static Vez defineVez(int jogada, ArrayList<Integer> restantes, Vez vez) {

		boolean[] anteriores = new boolean[NUM_JOGADAS];
		boolean ponto = false;

		for (int i = 0; i < NUM_JOGADAS; i++)
			anteriores[i] = true;

		for (int r : restantes) {
			anteriores[r] = false;
		}

		switch (jogada) {
		case 0:
			if (anteriores[2] == true && anteriores[3] == true && anteriores[5] == true)
				ponto = true;
			break;
		case 1:
			if (anteriores[3] == true && anteriores[4] == true && anteriores[6] == true)
				ponto = true;
			break;
		case 2:
			if (anteriores[0] == true && anteriores[3] == true && anteriores[5] == true)
				ponto = true;
			break;
		case 3:
			if ((anteriores[0] == true && anteriores[2] == true && anteriores[5] == true)
					|| (anteriores[1] == true && anteriores[4] == true && anteriores[6] == true))
				ponto = true;
			break;
		case 4:
			if (anteriores[1] == true && anteriores[3] == true && anteriores[6] == true)
				ponto = true;
			break;
		case 5:
			if ((anteriores[0] == true && anteriores[2] == true && anteriores[3] == true)
					|| (anteriores[7] == true && anteriores[8] == true && anteriores[10] == true))
				ponto = true;
			break;
		case 6:
			if ((anteriores[1] == true && anteriores[3] == true && anteriores[4] == true)
					|| (anteriores[8] == true && anteriores[9] == true && anteriores[11] == true))
				ponto = true;
			break;
		case 7:
			if (anteriores[5] == true && anteriores[8] == true && anteriores[10] == true)
				ponto = true;
			break;
		case 8:
			if ((anteriores[5] == true && anteriores[7] == true && anteriores[10] == true)
					|| (anteriores[6] == true && anteriores[9] == true && anteriores[11] == true))
				ponto = true;
			break;
		case 9:
			if (anteriores[6] == true && anteriores[8] == true && anteriores[11] == true)
				ponto = true;
			break;
		case 10:
			if (anteriores[5] == true && anteriores[7] == true && anteriores[8] == true)
				ponto = true;
			break;
		case 11:
			if (anteriores[6] == true && anteriores[8] == true && anteriores[9] == true)
				ponto = true;
			break;
		}

		return ponto ? vez : (vez == Vez.IA ? Vez.JOGADOR : Vez.IA);
	}

}