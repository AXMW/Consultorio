package telas;

import java.awt.EventQueue;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import conexao.*;
import conexao.funcionario.*;
import recursos.Funcionario;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TelaAltF {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception{
		Connection con = null;
		con = Conector.getConecction();
		
		Funcionario f = new Funcionario("Mikhael Kenji", "Mikha", "1234", true);
		CreateFuncionario.create(con, f);
		ArrayList<Funcionario> func = ReadFuncionario.read(con);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAltF window = new TelaAltF(func);
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
	public TelaAltF(ArrayList<Funcionario> func) {
		initialize(func);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Funcionario> func) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setBounds(100, 100, 450, 328);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		String[] column = {"Origem", "Usuário", "Senha"};
		final String[] row = new String[3];
		model.setColumnIdentifiers(column);
		scrollPane.setViewportView(table);
		table.setModel(model);
		for(Funcionario itemF: func) {
			row[0] = String.valueOf(itemF.getId_Func());
			row[1] = itemF.getNome_Func();
			row[2] = itemF.getLogin();
			row[4] = itemF.getSenha();
			model.addRow(row);
		}
		
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBackground(new Color(149, 149, 255));
		btnNewButton.setBounds(163, 255, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
