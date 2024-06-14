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

public class MenuPrincipal {

	private JFrame frame;
	private JButton btnAreaC;
	private JButton btnAreaF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
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
	public MenuPrincipal() {
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
		
		JButton btnAreaP = new JButton("Área de Paciente");
		btnAreaP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AreaPaciente ap = new AreaPaciente();
				ap.main(null);
			}
		});
		btnAreaP.setBounds(64, 113, 145, 36);
		frame.getContentPane().add(btnAreaP);
		
		btnAreaC = new JButton("Área de Consulta");
		btnAreaC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AreaConsultas ac = new AreaConsultas();
				ac.main(null);
			}
		});
		btnAreaC.setBounds(272, 113, 158, 36);
		frame.getContentPane().add(btnAreaC);
		
		if(TelaLogin.f.isGerente()) {
			btnAreaF = new JButton("Área Funcionários");
			btnAreaF.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AreaFuncionario af = new AreaFuncionario();
					af.main(null);
				}
			});
			btnAreaF.setBounds(175, 210, 158, 36);
			frame.getContentPane().add(btnAreaF);
		}
		
	}
}
