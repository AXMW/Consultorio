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

import recursos.Funcionario;
import recursos.Paciente;
import conexao.paciente.*;
import util.Verificadores;

public class AtualizP {

	private JFrame frame;
	private JButton btnVoltar;
	private JTextField nomePac_Field;
	private JTextField CPF_Field;
	private JLabel lblNewLabel_1_1_2;
	private JLabel lblNewLabel_1_1_3;
	private JTextField tipoSang_Field;
	private JTextField endereco_Field;
	private JTextField telefone_Field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizP window = new AtualizP();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public AtualizP() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		ArrayList<Paciente> pac = ReadPaciente.read(TelaLogin.con);
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
					TelaListP tlp = new TelaListP();
					tlp.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnVoltar.setBounds(163, 290, 68, 36);
		frame.getContentPane().add(btnVoltar);
		
		nomePac_Field = new JTextField();
		for(Paciente itemP: pac){
			if(itemP.getId_Pac() == TelaListP.valorID) {
				nomePac_Field.setText(itemP.getNome_Pac());
			}
		}
		nomePac_Field.setBounds(215, 85, 191, 20);
		frame.getContentPane().add(nomePac_Field);
		nomePac_Field.setColumns(10);
		
		CPF_Field = new JTextField();
		for(Paciente itemP: pac){
			if(itemP.getId_Pac() == TelaListP.valorID) {
				CPF_Field.setText(itemP.getCPF_Pac());
			}
		}
		CPF_Field.setBounds(215, 123, 191, 20);
		frame.getContentPane().add(CPF_Field);
		CPF_Field.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do Paciente:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(73, 87, 135, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("CPF:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(163, 124, 39, 16);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tipo Sanguineo:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(98, 169, 104, 16);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		lblNewLabel_1_1_2 = new JLabel("Endereco:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_2.setBounds(134, 206, 80, 16);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		lblNewLabel_1_1_3 = new JLabel("Telefone:");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_3.setBounds(140, 248, 68, 16);
		frame.getContentPane().add(lblNewLabel_1_1_3);
		
		tipoSang_Field = new JTextField();
		for(Paciente itemP: pac){
			if(itemP.getId_Pac() == TelaListP.valorID) {
				tipoSang_Field.setText(itemP.getTipo_Sanguineo());
			}
		}
		tipoSang_Field.setColumns(10);
		tipoSang_Field.setBounds(215, 168, 191, 20);
		frame.getContentPane().add(tipoSang_Field);
		
		endereco_Field = new JTextField();
		for(Paciente itemP: pac){
			if(itemP.getId_Pac() == TelaListP.valorID) {
				endereco_Field.setText(itemP.getEndereco_Pac());
			}
		}
		endereco_Field.setColumns(10);
		endereco_Field.setBounds(215, 205, 191, 20);
		frame.getContentPane().add(endereco_Field);
		
		telefone_Field = new JTextField();
		for(Paciente itemP: pac){
			if(itemP.getId_Pac() == TelaListP.valorID) {
				telefone_Field.setText(itemP.getTelefone());
			}
		}
		telefone_Field.setColumns(10);
		telefone_Field.setBounds(215, 247, 191, 20);
		frame.getContentPane().add(telefone_Field);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!Verificadores.verificarCPF(CPF_Field.getText())) {
						throw new Exception("CPF ERRADO!");
					}
					Paciente p = new Paciente(TelaListP.valorID, nomePac_Field.getText(), endereco_Field.getText(), tipoSang_Field.getText(), CPF_Field.getText(), telefone_Field.getText());
					UpdatePaciente.update(TelaLogin.con, p);
					JOptionPane.showMessageDialog(null, "Paciente atualizado!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
					TelaListP.valorID = 0;
					try {
						TelaListP tlp = new TelaListP();
						tlp.main(null);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frame.dispose();
				} catch(Exception e1){
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Algo foi digitado errado!", "Credenciais incorretas", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnAlterar.setBounds(247, 290, 109, 36);
		frame.getContentPane().add(btnAlterar);
	}
}
