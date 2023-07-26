package jogodavelha;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Botao extends JButton{
	private int linha;
	private int coluna;
	private final Color COR_CINZA_CLARO = new Color(59, 59, 59, 255);
	
	public Botao(int linha, int coluna) {
		setFont(new Font("Courier", Font.PLAIN, 25));
		setBackground(COR_CINZA_CLARO);
		setForeground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(new Color(32, 32, 32, 255)));
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public int getLinha() {
		return linha;
	}
	
	public int getColuna() {
		return coluna;
	}
}
