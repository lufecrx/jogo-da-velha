package jogodavelha;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CampoInformacoes extends JPanel implements CampoInformacoesObserver {

	private final Color COR_CINZA_ESCURO = new Color(50, 50, 50, 255);
	private final Color COR_CINZA_CLARO = new Color(59, 59, 59, 255);

	private JLabel txtVezDo;

	public CampoInformacoes(CampoJogo campoJogo) {
		setLayout(null);
		setBackground(COR_CINZA_ESCURO);
		setBorder(BorderFactory.createLineBorder(new Color(32, 32, 32, 255)));

		txtVezDo = new JLabel();
		txtVezDo.setBounds(10, 38, 119, 140);
		txtVezDo.setBackground(new Color(32,32,32,255));
		txtVezDo.setForeground(Color.WHITE);
		txtVezDo.setFont(new Font("Courier", Font.PLAIN, 20));
		txtVezDo.setText("Vez do: X");

		add(txtVezDo);

		JButton btnResetar = new JButton("Resetar");
		btnResetar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarInformacoes(1, AcaoEvento.REINICIAR);
				campoJogo.getBotoesX().clear();
				campoJogo.getBotoesO().clear();
				campoJogo.getBotoes().stream().forEach(b -> b.setText(""));
				campoJogo.getBotoes().stream().forEach(b -> b.setEnabled(true));
				campoJogo.setRodada(1);
			}
		});
		btnResetar.setBounds(10, 189, 119, 50);
		btnResetar.setFont(new Font("Courier", Font.PLAIN, 25));
		btnResetar.setBackground(COR_CINZA_CLARO);
		btnResetar.setForeground(Color.WHITE);
		btnResetar.setBorder(BorderFactory.createLineBorder(new Color(32, 32, 32, 255)));
		add(btnResetar);
	}

	public void setTxtVezDo(String string) {
		txtVezDo.setText(string);
	}

	// Acessar os métodos e propriedades de CampoJogo
	@Override
	public void atualizarInformacoes(int rodada, AcaoEvento evento) {
		switch (evento) {
		case MARCAR:
			if (rodada % 2 == 1)
				setTxtVezDo("Vez do: O");
			else
				setTxtVezDo("Vez do: X");
			break;
		case GANHAR:
			if (rodada % 2 == 1)
				setTxtVezDo("Vencedor: O");
			else
				setTxtVezDo("Vencedor: X");
			break;
		case REINICIAR:
			setTxtVezDo("Vez do: X");
			break;
		case EMPATAR:
			setTxtVezDo("Empate!");
		}

	}
}
