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
import java.awt.event.ActionEvent;
import recursos.Funcionario;
import conexao.funcionario.CreateFuncionario;

public class TelaCadF {

	private JFrame frame;
	private JButton btnVoltar;
	private JTextField nomeFunc_Field;
	private JTextField loginFunc_Field;
	private JPasswordField senhaFunc_Field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadF window = new TelaCadF();
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
	public TelaCadF() {
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
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnVoltar.setBounds(134, 274, 68, 36);
		frame.getContentPane().add(btnVoltar);
		
		nomeFunc_Field = new JTextField();
		nomeFunc_Field.setBounds(215, 85, 191, 20);
		frame.getContentPane().add(nomeFunc_Field);
		nomeFunc_Field.setColumns(10);
		
		loginFunc_Field = new JTextField();
		loginFunc_Field.setBounds(215, 123, 191, 20);
		frame.getContentPane().add(loginFunc_Field);
		loginFunc_Field.setColumns(10);
		
		JCheckBox checkboxGerente = new JCheckBox("Gerente?");
		checkboxGerente.setBounds(215, 212, 69, 23);
		frame.getContentPane().add(checkboxGerente);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do Funcionário:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(65, 88, 137, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Login:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(152, 124, 50, 16);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Senha:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(152, 169, 50, 16);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		senhaFunc_Field = new JPasswordField();
		senhaFunc_Field.setBounds(215, 168, 191, 20);
		frame.getContentPane().add(senhaFunc_Field);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (TelaLogin.f.isGerente()) {
						
						String senha = new String(senhaFunc_Field.getPassword());
						
						if (nomeFunc_Field.getText().isBlank() || loginFunc_Field.getText().isBlank() || senha.isBlank()) {
							throw new Exception("Todos os Campos tem que estar preenchidos!");
						}
						
						boolean gerente = false;
						
						if (checkboxGerente.isSelected()) {
							gerente = true;
						}
						Funcionario f = new Funcionario(nomeFunc_Field.getText(), loginFunc_Field.getText(), senha, gerente);
						CreateFuncionario.create(TelaLogin.con, f);
						JOptionPane.showMessageDialog(null, "Funcionário Cadastrado!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "É necessário ter cargo de gerente para cadastrar!", "Cadastro", JOptionPane.ERROR_MESSAGE);
					}
						
				}catch(Exception e1){
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Algo foi digitado errado!", "Credenciais incorretas", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCadastrar.setBounds(228, 274, 109, 36);
		frame.getContentPane().add(btnCadastrar);
		
	}
}
