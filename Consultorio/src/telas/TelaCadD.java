package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class TelaCadD {

	private JFrame frame;
	private JButton btnVoltar;
	private JTextField nomeFunc_Field;
	private JTextField CRM_Field;
	private JPasswordField Especialidade_Field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadD window = new TelaCadD();
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
	public TelaCadD() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		btnVoltar.setBounds(134, 232, 68, 36);
		frame.getContentPane().add(btnVoltar);
		
		nomeFunc_Field = new JTextField();
		nomeFunc_Field.setBounds(215, 85, 191, 20);
		frame.getContentPane().add(nomeFunc_Field);
		nomeFunc_Field.setColumns(10);
		
		CRM_Field = new JTextField();
		CRM_Field.setBounds(215, 123, 191, 20);
		frame.getContentPane().add(CRM_Field);
		CRM_Field.setColumns(10);
		
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
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(227, 232, 109, 36);
		frame.getContentPane().add(btnCadastrar);
		
		Especialidade_Field = new JPasswordField();
		Especialidade_Field.setBounds(215, 168, 191, 20);
		frame.getContentPane().add(Especialidade_Field);
	}
}
