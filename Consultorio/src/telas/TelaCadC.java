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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadC {

	private JFrame frame;
	private JButton btnVoltar;
	private JTextField CPFPac_Field;
	private JTextField CRMDent_Field;
	private JLabel lblNewLabel_1_1_2;
	private JTextField tipoCons_Field;
	private JTextField data_Field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadC window = new TelaCadC();
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
	public TelaCadC() {
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
		btnVoltar.setBounds(134, 263, 68, 36);
		frame.getContentPane().add(btnVoltar);
		
		CPFPac_Field = new JTextField();
		CPFPac_Field.setBounds(215, 85, 191, 20);
		frame.getContentPane().add(CPFPac_Field);
		CPFPac_Field.setColumns(10);
		
		CRMDent_Field = new JTextField();
		CRMDent_Field.setBounds(215, 123, 191, 20);
		frame.getContentPane().add(CRMDent_Field);
		CRMDent_Field.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF do Paciente:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(94, 87, 114, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("CRM do Dentista:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(88, 124, 114, 16);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tipo de Consulta:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(88, 169, 114, 16);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JButton btnAgendar = new JButton("Agendar");
		btnAgendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgendar.setBounds(227, 263, 109, 36);
		frame.getContentPane().add(btnAgendar);
		
		lblNewLabel_1_1_2 = new JLabel("Data:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_2.setBounds(163, 206, 36, 16);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		tipoCons_Field = new JTextField();
		tipoCons_Field.setColumns(10);
		tipoCons_Field.setBounds(215, 168, 191, 20);
		frame.getContentPane().add(tipoCons_Field);
		
		data_Field = new JTextField();
		data_Field.setColumns(10);
		data_Field.setBounds(215, 205, 191, 20);
		frame.getContentPane().add(data_Field);
	}
}
