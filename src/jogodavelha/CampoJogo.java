package jogodavelha;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CampoJogo extends JPanel {
	
	private int rodada = 1;
	private List<Botao> botoes = new ArrayList<>();
	private List<Botao> botoesX = new ArrayList<>();
	private List<Botao> botoesO = new ArrayList<>();
    private List<CampoInformacoesObserver> observadores = new ArrayList<>();

	public CampoJogo() {
		setLayout(new GridLayout(0, 3, 0, 0));
		setBorder(BorderFactory.createLineBorder(new Color(32, 32, 32, 255)));


		Botao btn11 = new Botao(1, 1);
		Botao btn12 = new Botao(1, 2);
		Botao btn13 = new Botao(1, 3);
		Botao btn21 = new Botao(2, 1);
		Botao btn22 = new Botao(2, 2);
		Botao btn23 = new Botao(2, 3);
		Botao btn31 = new Botao(3, 1);
		Botao btn32 = new Botao(3, 2);
		Botao btn33 = new Botao(3, 3);
		botoes.add(btn11);
		botoes.add(btn12);
		botoes.add(btn13);
		botoes.add(btn21);
		botoes.add(btn22);
		botoes.add(btn23);
		botoes.add(btn31);
		botoes.add(btn32);
		botoes.add(btn33);

		btn11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcarBtn(btn11);
			}
		});

		btn12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcarBtn(btn12);
			}
		});

		btn13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcarBtn(btn13);
			}
		});

		btn21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcarBtn(btn21);
			}
		});

		btn22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcarBtn(btn22);
			}
		});

		btn23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcarBtn(btn23);
			}
		});

		btn31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcarBtn(btn31);
			}
		});

		btn32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcarBtn(btn32);
			}
		});

		btn33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcarBtn(btn33);		
			}
		});

		for (Botao botao : botoes) {
			add(botao);
		}
	}

	public void marcarBtn(Botao btn) {
		notificarObservadores(AcaoEvento.MARCAR);

		if (rodada % 2 == 1) {
			btn.setText("X");
			btn.setEnabled(false);
			botoesX.add(btn);
		} else {
			btn.setText("O");
			btn.setEnabled(false);
			botoesO.add(btn);
		}

		proximaRodada();
		boolean isVitoria = verificaVitoria(btn);
		boolean isEmpate = verificaEmpate();
		if (isVitoria)
			ganhou();
		if (isEmpate)
			empatou();
	}

	public void proximaRodada() {
		rodada++;
	}

	public boolean verificaEmpate() {
		for (Botao botao : botoes) {
			if (botao.isEnabled()) {
				return false;
			}
		}
		return true;
	}

	public boolean verificaVitoria(Botao btn) {
		int jogadorLinha = btn.getLinha();
		int jogadorColuna = btn.getColuna();
		int verificador = 0;

		// COMPLETOU UMA LINHA DE X
		for (Botao botao : botoesX) {
			if (jogadorLinha == botao.getLinha()) {
				verificador++;

				if (verificador == 3) {
					return true;
				}
			}
		}
		verificador = 0;

		// COMPLETOU UMA LINHA DE O
		for (Botao botao : botoesO) {
			if (jogadorLinha == botao.getLinha()) {
				verificador++;

				if (verificador == 3) {
					return true;
				}
			}
		}
		verificador = 0;

		// COMPLETOU UMA COLUNA DE X
		for (Botao botao : botoesX) {
			if (jogadorColuna == botao.getColuna()) {
				verificador++;

				if (verificador == 3) {
					return true;
				}
			}
		}
		verificador = 0;

		// COMPLETOU UMA COLUNA DE O
		for (Botao botao : botoesO) {
			if (jogadorColuna == botao.getColuna()) {
				verificador++;

				if (verificador == 3) {
					return true;
				}
			}
		}
		verificador = 0;

		// COMPLETOU UMA DIAGONAL PRINCIPAL COM X's
		for (Botao botao : botoesX) {
			if (botao.getLinha() == botao.getColuna()) {
				verificador++;

				if (verificador == 3) {
					return true;
				}
			}
		}
		verificador = 0;

		// COMPLETOU UMA DIAGONAL PRINCIPAL COM O's
		for (Botao botao : botoesO) {
			if (botao.getLinha() == botao.getColuna()) {
				verificador++;

				if (verificador == 3) {
					return true;
				}
			}
		}
		verificador = 0;

		// COMPLETOU UMA DIAGONAL SECUNDARIA COM X's
		for (Botao botao : botoesX) {
			if (botao.getLinha() + botao.getColuna() == 4) {
				verificador++;

				if (verificador == 3) {
					return true;
				}
			}
		}
		verificador = 0;

		// COMPLETOU UMA DIAGONAL SECUNDARIA COM O's
		for (Botao botao : botoesO) {
			if (botao.getLinha() + botao.getColuna() == 4) {
				verificador++;

				if (verificador == 3) {
					return true;
				}
			}
		}
		verificador = 0;

		return false;
	}

	public void ganhou() {
		notificarObservadores(AcaoEvento.GANHAR);
		for (Botao botao : botoes) {
			botao.setEnabled(false);
		}
	}

	public void empatou() {
		notificarObservadores(AcaoEvento.EMPATAR);
	}

	public List<Botao> getBotoes() {
		return botoes;
	}
	
	public List<Botao> getBotoesX() {
		return botoesX;
	}
	
	public List<Botao> getBotoesO() {
		return botoesO;
	}
	
	public int getRodada() {
		return rodada;
	}
	
	public void setRodada(int rodada) {
		this.rodada = rodada;
	}
	
    public void adicionarObservador(CampoInformacoesObserver observador) {
        observadores.add(observador);
    }

    public void removerObservador(CampoInformacoesObserver observador) {
        observadores.remove(observador);
    }

    // Método que notifica os observadores quando algo mudar no jogo
    private void notificarObservadores(AcaoEvento evento) {
        for (CampoInformacoesObserver observador : observadores) {
            observador.atualizarInformacoes(this.rodada, evento);
        }
    }
	
}
