package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AreaFuncionario {

	private JFrame frame;
	private JButton btnAlterarF;
	private JButton btnVoltar;
	private JButton btnCadD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AreaFuncionario window = new AreaFuncionario();
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
	public AreaFuncionario() {
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
		
		JButton btnCadF = new JButton("Cadastrar Funcionário");
		btnCadF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadF tcf = new TelaCadF();
				tcf.main(null);
			}
		});
		btnCadF.setBounds(134, 81, 223, 36);
		frame.getContentPane().add(btnCadF);
		
		btnAlterarF = new JButton("Alterar Funcionário");
		btnAlterarF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListF tlf = new TelaListF()
				tlf.main(null);

			}
		});
		btnAlterarF.setBounds(134, 208, 223, 36);
		frame.getContentPane().add(btnAlterarF);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnVoltar.setBounds(210, 285, 68, 36);
		frame.getContentPane().add(btnVoltar);
		
		btnCadD = new JButton("Cadastrar Dentista");
		btnCadD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadD tcd = new TelaCadD();
				tcd.main(null);
			}
		});
		btnCadD.setBounds(134, 144, 223, 36);
		frame.getContentPane().add(btnCadD);
	}
}
