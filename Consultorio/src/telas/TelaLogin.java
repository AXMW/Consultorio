package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.sql.Connection;
import recursos.Paciente;
import conexao.Conector;
import conexao.funcionario.ReadFuncionario;
import conexao.paciente.*;
import java.util.ArrayList;
import recursos.Funcionario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin {

	private JFrame frame;
	private JTextField login_Field;
	private JLabel lblSenha;
	private JPasswordField senha_Field;
	private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
	public static Connection con = null;
	public static Funcionario f = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					con = Conector.getConecction();
					funcionarios = ReadFuncionario.read(con);
					TelaLogin window = new TelaLogin();
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
	public TelaLogin() {
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
		
		login_Field = new JTextField();
		login_Field.setBounds(190, 92, 161, 20);
		frame.getContentPane().add(login_Field);
		login_Field.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setBounds(134, 95, 46, 14);
		frame.getContentPane().add(lblLogin);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setBounds(134, 154, 46, 14);
		frame.getContentPane().add(lblSenha);
		
		senha_Field = new JPasswordField();
		senha_Field.setBounds(190, 151, 161, 20);
		frame.getContentPane().add(senha_Field);
		senha_Field.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean entrar = false;
				String senha = new String(senha_Field.getPassword());
				for (int i = 0; i < funcionarios.size(); i++) {
					if (funcionarios.get(i).getLogin().equals(login_Field.getText())) {
						if (funcionarios.get(i).getSenha().equals(senha)) {
							f = funcionarios.get(i);
							entrar = true;
							break;
						}
					}
				}
				if (entrar) {
					MenuPrincipal mp = new MenuPrincipal();
					mp.main(null);
					frame.dispose();
				}else {
				JOptionPane.showMessageDialog(null, "O Login e/ou a senha estão errados!", "Credenciais incorretas", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEntrar.setBounds(190, 225, 100, 36);
		frame.getContentPane().add(btnEntrar);
	}
}
