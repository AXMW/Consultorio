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
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import recursos.Funcionario;
import conexao.funcionario.*;



public class AtualizF {

	private JFrame frame;
	private JButton btnVoltar;
	private JTextField nomeFunc_Field;
	private JTextField loginFunc_Field;
	private JTextField senhaFunc_Field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizF window = new AtualizF();
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
	public AtualizF() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		ArrayList<Funcionario> func = ReadFuncionario.read(TelaLogin.con);
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
					TelaListF tlf = new TelaListF();
					tlf.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnVoltar.setBounds(134, 274, 68, 36);
		frame.getContentPane().add(btnVoltar);
		
		nomeFunc_Field = new JTextField();
		for(Funcionario itemF: func){
			if(itemF.getId_Func() == TelaListF.valorID) {
				nomeFunc_Field.setText(itemF.getNome_Func());
			}
		}
		nomeFunc_Field.setBounds(215, 85, 191, 20);
		frame.getContentPane().add(nomeFunc_Field);
		nomeFunc_Field.setColumns(10);
		
		loginFunc_Field = new JTextField();
		for(Funcionario itemF: func){
			if(itemF.getId_Func() == TelaListF.valorID) {
				loginFunc_Field.setText(itemF.getLogin());
			}
		}
		loginFunc_Field.setBounds(215, 123, 191, 20);
		frame.getContentPane().add(loginFunc_Field);
		loginFunc_Field.setColumns(10);
		
		JCheckBox checkboxGerente = new JCheckBox("Gerente?");
		for(Funcionario itemF: func){
			if(itemF.getId_Func() == TelaListF.valorID) {
				if(itemF.isGerente()) {
					checkboxGerente.setSelected(true);
				}
			}
		}
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
		
		senhaFunc_Field = new JTextField();
		for(Funcionario itemF: func){
			if(itemF.getId_Func() == TelaListF.valorID) {
				senhaFunc_Field.setText(itemF.getSenha());
			}
		}
		senhaFunc_Field.setColumns(10);
		senhaFunc_Field.setBounds(215, 168, 191, 20);
		frame.getContentPane().add(senhaFunc_Field);
		
		JButton btnCadastrar = new JButton("Alterar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						boolean gerente = false;
						
						if (checkboxGerente.isSelected()) {
							gerente = true;
						}
						Funcionario f = new Funcionario(TelaListF.valorID, nomeFunc_Field.getText(), loginFunc_Field.getText(), senhaFunc_Field.getText(), gerente);
						UpdateFuncionario.update(TelaLogin.con, f);
						JOptionPane.showMessageDialog(null, "Funcionário atualizado!", "Atualização", JOptionPane.INFORMATION_MESSAGE);
						TelaListF.valorID = 0;
						try {
							TelaListF tlf = new TelaListF();
							tlf.main(null);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						frame.dispose();
						
					
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
