package telas;

import java.awt.EventQueue;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import conexao.*;
import conexao.funcionario.*;
import recursos.Funcionario;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TelaListF {

	private JFrame frame;
	private JTable table;
	static public int valorID = 0;

	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception{
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListF window = new TelaListF();
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
	public TelaListF() throws Exception {
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
		frame.setBounds(100, 100, 450, 328);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		String[] column = {"ID", "Nome", "Login", "Senha", "Gerente"};
		final String[] row = new String[5];
		model.setColumnIdentifiers(column);
		scrollPane.setViewportView(table);
		table.setModel(model);
		for(Funcionario itemF: func) {
			row[0] = String.valueOf(itemF.getId_Func());
			row[1] = itemF.getNome_Func();
			row[2] = itemF.getLogin();
			row[3] = itemF.getSenha();
			if(itemF.isGerente()) { row[4] = "Sim"; } else { row[4] = "Não"; };
			model.addRow(row);
		}
		
		table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                int columnToGet = 0;

                if (selectedRow != -1) { 
                	Object valorTabela = table.getValueAt(selectedRow, columnToGet);

                    try {
                        if (valorTabela instanceof Integer) {
                            valorID = (Integer) valorTabela;
                        } else if (valorTabela instanceof String) {
                            valorID = Integer.parseInt((String) valorTabela);
                        } else {
                            throw new IllegalArgumentException("Unsupported object type");
                        }
                    } catch (NumberFormatException ex) {
                        System.err.println("Erro ao converter valor para inteiro: " + valorTabela);
                    }
                }
            }
        });
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBackground(new Color(149, 149, 255));
		btnNewButton.setBounds(65, 255, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(frame,
                        "Você tem certeza que deseja deletar?",
                        "Confirmar Exclusão",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                if (response == JOptionPane.YES_OPTION) {
                	try {
                		if(valorID!=0) {
    						DeleteFuncionario.delete(TelaLogin.con, valorID);
    						for (int i = 0; i < model.getRowCount(); i++) {
                                if (Integer.parseInt((String) model.getValueAt(i, 0)) == valorID) {
                                    model.removeRow(i);
                                    model.fireTableRowsDeleted(i, i);
                                    break;
                                }
                            }
    						valorID = 0;
                		}
						else {
							JOptionPane.showMessageDialog(btnDeletar, "Selecione o funcionário que deseja deletar","Mensagem", 2);
						}
					} 
                	catch (Exception e1) {
						// TODO Auto-generated catch block
                		JOptionPane.showMessageDialog(btnDeletar, e1);
					}
                } else {
                    System.out.println("Exclusão cancelada.");
                }
			}
		});
		btnDeletar.setBackground(new Color(149, 149, 255));
		btnDeletar.setBounds(164, 255, 89, 23);
		frame.getContentPane().add(btnDeletar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(valorID !=0) {
					try {
						AtualizF af = new AtualizF();
						af.main(null);
						frame.dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(btnDeletar, "Selecione o funcionário que deseja alterar","Mensagem", 2);
				}
			}
		});
		btnAlterar.setBackground(new Color(149, 149, 255));
		btnAlterar.setBounds(263, 255, 89, 23);
		frame.getContentPane().add(btnAlterar);
	}
}
