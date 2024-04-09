package dots;

public class Jogada {

	private javax.swing.JPanel quadradoAlvo;
	private javax.swing.JLabel labelAlvo;
	private javax.swing.JLabel[] vizinhos;
	private javax.swing.JPanel[] colorir;
	
	public Jogada(javax.swing.JPanel quadradoAlvo, javax.swing.JLabel labelAlvo, javax.swing.JPanel[] colorir, javax.swing.JLabel... vizinhos) {
		this.labelAlvo = labelAlvo;
		this.quadradoAlvo = quadradoAlvo;
		this.vizinhos = vizinhos;
		this.colorir = colorir;
	}

	public javax.swing.JLabel[] getVizinhos() {
		return vizinhos;
	}

	public javax.swing.JPanel[] getColorir() {
		return colorir;
	}

	public javax.swing.JPanel getQuadradoAlvo() {
		return quadradoAlvo;
	}

	public javax.swing.JLabel getLabelAlvo() {
		return labelAlvo;
	}
}
