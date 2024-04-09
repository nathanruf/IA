package dots;

import java.util.ArrayList;
import java.util.List;

public class No {

	private List<Integer> jogadas;
	private int minmax;
	private No[] filhos;
	private Vez vez;
	
	public No(int minmax, ArrayList<Integer> jogadas ,No[] filhos, Vez vez) {
		this.jogadas = jogadas;
		this.minmax = minmax;
		this.filhos = filhos;
		this.setVez(vez);
	}

	public int getMinmax() {
		return minmax;
	}

	public void setMinmax(int minmax) {
		this.minmax = minmax;
	}

	public ArrayList<Integer> getJogadas() {
		return (ArrayList<Integer>) jogadas;
	}

	public No[] getFilhos() {
		return filhos;
	}

	public Vez getVez() {
		return vez;
	}

	public void setVez(Vez vez) {
		this.vez = vez;
	}
}