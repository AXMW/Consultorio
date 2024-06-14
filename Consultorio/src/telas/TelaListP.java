package telas;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import conexao.paciente.DeletePaciente;
import conexao.paciente.ReadPaciente;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import recursos.Paciente;


public class TelaListP {

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
					TelaListP window = new TelaListP();
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
	public TelaListP() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		ArrayList<Paciente> pacientes = ReadPaciente.read(TelaLogin.con);
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setBounds(100, 100, 450, 328);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		String[] column = {"ID", "Nome", "Endereco", "Tipo Sanguineo", "CPF", "Telefone"};
		final String[] row = new String[6];
		model.setColumnIdentifiers(column);
		scrollPane.setViewportView(table);
		table.setModel(model);
		for(Paciente itemF: pacientes) {
			row[0] = String.valueOf(itemF.getId_Pac());
			row[1] = itemF.getNome_Pac();
			row[2] = itemF.getEndereco_Pac();
			row[3] = itemF.getTipo_Sanguineo();
			row[4] = itemF.getCPF_Pac();
			row[5] = itemF.getTelefone();
			model.addRow(row);
		}
		
		table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                int columnToGet = 0; // Índice da coluna que você quer pegar o valor (começa em 0)

                if (selectedRow != -1) { // Verifica se alguma linha está selecionada
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
				// Mostra a caixa de diálogo de confirmação
                int response = JOptionPane.showConfirmDialog(frame,
                        "Você tem certeza que deseja deletar?",
                        "Confirmar Exclusão",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                // Verifica a resposta do usuário
                if (response == JOptionPane.YES_OPTION) {
                	try {
                		if(valorID!=0) {
    						DeletePaciente.delete(TelaLogin.con, valorID);
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
                    // Usuário confirmou a exclusão
                    System.out.println("Item deletado.");
                    // Aqui você pode colocar o código para deletar o item
                } else {
                    // Usuário cancelou a exclusão
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
						AtualizP ap = new AtualizP();
						ap.main(null);
						frame.dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(btnDeletar, "Selecione o paciente que deseja alterar","Mensagem", 2);
				}
			}
		});
		btnAlterar.setBackground(new Color(149, 149, 255));
		btnAlterar.setBounds(263, 255, 89, 23);
		frame.getContentPane().add(btnAlterar);
	}
}
