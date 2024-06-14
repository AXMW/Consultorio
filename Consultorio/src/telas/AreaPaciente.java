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

public class AreaPaciente {

	private JFrame frame;
	private JButton btnAlterarP;
	private JButton btnVoltar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AreaPaciente window = new AreaPaciente();
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
	public AreaPaciente() {
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
		
		JButton btnCadP = new JButton("Cadastrar Paciente");
		btnCadP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadP tcp = new TelaCadP();
				tcp.main(null);
			}
		});
		btnCadP.setBounds(134, 111, 223, 36);
		frame.getContentPane().add(btnCadP);
		
		btnAlterarP = new JButton("Alterar Paciente");
		btnAlterarP.setBounds(134, 174, 223, 36);
		frame.getContentPane().add(btnAlterarP);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnVoltar.setBounds(209, 241, 68, 36);
		frame.getContentPane().add(btnVoltar);
	}
}
