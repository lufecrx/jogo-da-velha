package jogodavelha;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	/**
	 * Iniciando app
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Criando o app
	 */
	public TelaPrincipal() {
		
		// TELA PRINCIPAL
		setTitle("Jogo da Velha");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 139, 290, 0 };
		gridBagLayout.rowHeights = new int[] { 261, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		
		// TELA DIREITA
		CampoJogo campoJogo = new CampoJogo();	
		GridBagConstraints gbc_campoJogo = new GridBagConstraints();
		gbc_campoJogo.fill = GridBagConstraints.BOTH;
		gbc_campoJogo.gridx = 1;
		gbc_campoJogo.gridy = 0;
		add(campoJogo, gbc_campoJogo);

		// TELA ESQUERDA
		CampoInformacoes campoInformacoes = new CampoInformacoes(campoJogo);
		campoJogo.adicionarObservador(campoInformacoes);
		GridBagConstraints gbc_campoInformacoes = new GridBagConstraints();
		gbc_campoInformacoes.fill = GridBagConstraints.BOTH;
		gbc_campoInformacoes.gridx = 0;
		gbc_campoInformacoes.gridy = 0;
		add(campoInformacoes, gbc_campoInformacoes);
	}

}
