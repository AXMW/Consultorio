package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import recursos.Dentista;
import conexao.dentista.CreateDentista;
import conexao.dentista.ReadDentista;
import conexao.dentista.UpdateDentista;

public class AtualizD {

	private JFrame frame;
	private JButton btnVoltar;
	private JTextField nomeFunc_Field;
	private JTextField CRM_Field;
	private JTextField Especialidade_Field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizD window = new AtualizD();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AtualizD() throws Exception{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws Exception {
		ArrayList<Dentista> dentistas = ReadDentista.read(TelaLogin.con);
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setBounds(100, 100, 533, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bem-vindo ao Dr Sorriso");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(134, 11, 247, 36);
		frame.getContentPane().add(lblNewLabel);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaListD tld = new TelaListD();
					tld.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnVoltar.setBounds(134, 232, 68, 36);
		frame.getContentPane().add(btnVoltar);
		
		nomeFunc_Field = new JTextField();
		nomeFunc_Field.setBounds(215, 85, 191, 20);
		frame.getContentPane().add(nomeFunc_Field);
		nomeFunc_Field.setColumns(10);
		for(Dentista dent : dentistas) {
			if(dent.getId_Dent() == TelaListD.valorID) {
				nomeFunc_Field.setText(dent.getNome_Dent());
			}
		}
		
		CRM_Field = new JTextField();
		CRM_Field.setBounds(215, 123, 191, 20);
		frame.getContentPane().add(CRM_Field);
		CRM_Field.setColumns(10);
		
		for(Dentista dent : dentistas) {
			if(dent.getId_Dent() == TelaListD.valorID) {
				CRM_Field.setText(dent.getCRM());
			}
		}
		
		Especialidade_Field = new JTextField();
		Especialidade_Field.setColumns(10);
		Especialidade_Field.setBounds(215, 168, 191, 20);
		frame.getContentPane().add(Especialidade_Field);
		
		for(Dentista dent : dentistas) {
			if(dent.getId_Dent() == TelaListD.valorID) {
				Especialidade_Field.setText(dent.getEspecialidade());
			}
		}
		
		JLabel lblNewLabel_1 = new JLabel("Nome do Dentista:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(81, 87, 137, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("CRM:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(169, 124, 33, 16);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Especialidade:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(111, 169, 91, 16);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JButton btnCadastrar = new JButton("Alterar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (TelaLogin.f.isGerente()) {
						if (nomeFunc_Field.getText().isBlank() || CRM_Field.getText().isBlank() || Especialidade_Field.getText().isBlank()) {
							JOptionPane.showMessageDialog(null, "Algum campo esta vazio", "Credenciais incorretas", JOptionPane.ERROR_MESSAGE);
						}else {
							Dentista d = new Dentista(TelaListD.valorID, nomeFunc_Field.getText(), CRM_Field.getText(), Especialidade_Field.getText());
							UpdateDentista.update(TelaLogin.con, d);
							JOptionPane.showMessageDialog(null, "Dentista Alterado!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "É necessário ter cargo de gerente para Atualizar!", "Cadastro", JOptionPane.ERROR_MESSAGE);
					}
				}catch(Exception e1){
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Algo foi digitado errado!", "Credenciais incorretas", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCadastrar.setBounds(227, 232, 109, 36);
		frame.getContentPane().add(btnCadastrar);
		
	}
}
