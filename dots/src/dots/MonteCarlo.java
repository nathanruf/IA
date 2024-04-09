package dots;

import java.util.ArrayList;

public class MonteCarlo implements Ia {

	private static ArrayList<Integer> jogadas = new ArrayList<Integer>();
	private static boolean[] partida = new boolean[12];
	private static final int QUANTIDADE = 10000;

	public MonteCarlo() {
		jogadas.add(0);
		jogadas.add(1);
		jogadas.add(2);
		jogadas.add(3);
		jogadas.add(4);
		jogadas.add(5);
		jogadas.add(6);
		jogadas.add(7);
		jogadas.add(8);
		jogadas.add(9);
		jogadas.add(10);
		jogadas.add(11);
	}

	@Override
	public void jogada() {
		while (Tabuleiro.fazerJogada(jogadas.remove(simulacao()), true));
	}

	public static void atualizar(Integer id) {
		partida[id] = true;
		jogadas.remove(id);
	}

	@SuppressWarnings("unchecked")
	private int simulacao() {
		int h = 0;
		
		int pontos = 0, size = jogadas.size() - 1, maior = Integer.MIN_VALUE, escolhido = -1, vitorias = 0;
		ArrayList<Integer> aux;
		boolean[] marcado;
		boolean vezIA = true;

		for (int k = 0; k < jogadas.size(); k++) {
			marcado = partida.clone();
			aux = (ArrayList<Integer>) jogadas.clone();
			int jogadaAux = aux.remove(k);
			marcado[jogadaAux] = true;

			if (verificaPonto(jogadaAux, marcado))
				pontos++;
			else
				vezIA = false;

			for (int i = 0; i < QUANTIDADE; i++) {

				for (int j = 0; j < size; j++) {
					h = 0;
					while (!verificaPonto(aux.get(h), marcado) && ++h < aux.size());

					if (h < aux.size()) {
						jogadaAux = h;
						if (vezIA)
							pontos++;
					} else {
						jogadaAux = aux.remove((int) (Math.random() * aux.size()));
						vezIA = !vezIA;
					}

					marcado[jogadaAux] = true;

				}
				aux = (ArrayList<Integer>) jogadas.clone();
				marcado = partida.clone();
				marcado[aux.remove(k)] = true;

				if (pontos > 2)
					vitorias++;
				else if (pontos < 2)
					vitorias--;

				pontos = 0;
			}

			if (vitorias > maior) {
				maior = vitorias;
				escolhido = k;
			}
			pontos = 0;
			vitorias = 0;
			vezIA = true;
		}

		return escolhido;
	}

	private boolean verificaPonto(int jogada, boolean[] partida) {

		boolean ponto = false;

		switch (jogada) {
		case 0:
			if (partida[2] == true && partida[3] == true && partida[5] == true)
				ponto = true;
			break;
		case 1:
			if (partida[3] == true && partida[4] == true && partida[6] == true)
				ponto = true;
			break;
		case 2:
			if (partida[0] == true && partida[3] == true && partida[5] == true)
				ponto = true;
			break;
		case 3:
			if ((partida[0] == true && partida[2] == true && partida[5] == true)
					|| (partida[1] == true && partida[4] == true && partida[6] == true))
				ponto = true;
			break;
		case 4:
			if (partida[1] == true && partida[3] == true && partida[6] == true)
				ponto = true;
			break;
		case 5:
			if ((partida[0] == true && partida[2] == true && partida[3] == true)
					|| (partida[7] == true && partida[8] == true && partida[10] == true))
				ponto = true;
			break;
		case 6:
			if ((partida[1] == true && partida[3] == true && partida[4] == true)
					|| (partida[8] == true && partida[9] == true && partida[11] == true))
				ponto = true;
			break;
		case 7:
			if (partida[5] == true && partida[8] == true && partida[10] == true)
				ponto = true;
			break;
		case 8:
			if ((partida[5] == true && partida[7] == true && partida[10] == true)
					|| (partida[6] == true && partida[9] == true && partida[11] == true))
				ponto = true;
			break;
		case 9:
			if (partida[6] == true && partida[8] == true && partida[11] == true)
				ponto = true;
			break;
		case 10:
			if (partida[5] == true && partida[7] == true && partida[8] == true)
				ponto = true;
			break;
		case 11:
			if (partida[6] == true && partida[8] == true && partida[9] == true)
				ponto = true;
			break;
		}

		return ponto;
	}

	@Override
	public void jogadaInicial() {
		Tabuleiro.fazerJogada(jogadas.remove((int) (Math.random() * jogadas.size())), true);
		return;
	}

	@Override
	public void finalizar() {
		jogadas.add(0);
		jogadas.add(1);
		jogadas.add(2);
		jogadas.add(3);
		jogadas.add(4);
		jogadas.add(5);
		jogadas.add(6);
		jogadas.add(7);
		jogadas.add(8);
		jogadas.add(9);
		jogadas.add(10);
		jogadas.add(11);

		partida = new boolean[12];
		return;
	}

}
