package trabalhofinal.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import trabalhofinal.controller.ChaleController;
import trabalhofinal.negocio.Chale;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmChale extends JFrame {

	private JLabel lblMensagem;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblConsulta;
	private JTextField txtIDChale;
	private JTextField txtCapacidade;
	private JTextField txtLocalizacao;
	private JTextField txtValorAltaEstacao;
	private JTextField txtValorBaixaEstacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmChale frame = new FrmChale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmChale() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE))
					.addGap(6))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            Chale emp = new Chale();
		            ChaleController ec = new ChaleController();
		            emp.setCodChale(Integer.parseInt(txtIDChale.getText()));
		            emp.setCapacidade(Integer.parseInt(txtCapacidade.getText()));
		            emp.setLocalizacao(txtLocalizacao.getText());
		            emp.setValorAltaEstacao(Double.parseDouble(txtValorAltaEstacao.getText()));
		            emp.setValorBaixaEstacao(Double.parseDouble(txtValorBaixaEstacao.getText()));
		            lblMensagem.setText(ec.inserir(emp));
		        } catch (NumberFormatException ex) {
		            lblMensagem.setText("Erro: Verifique os valores numéricos inseridos.");
		        } catch (Exception ex) {
		            lblMensagem.setText("Erro ao inserir o chalé: " + ex.getMessage());
		        }
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 11));
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chale emp = new Chale();
				ChaleController ec = new ChaleController();
				emp.setCodChale(Integer.parseInt(txtIDChale.getText()));
				emp.setCapacidade(Integer.parseInt(txtCapacidade.getText()));
				emp.setLocalizacao(txtLocalizacao.getText());
				emp.setValorAltaEstacao(Double.parseDouble(txtValorAltaEstacao.getText()));
				emp.setValorBaixaEstacao(Double.parseDouble(txtValorBaixaEstacao.getText()));
				lblMensagem.setText(ec.alterar(emp));
			}
		});
		btnAlterar.setFont(new Font("Dialog", Font.BOLD, 11));
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chale emp = new Chale();
				ChaleController ec = new ChaleController();
				emp.setCodChale(Integer.parseInt(txtIDChale.getText()));
				Object[] opcoes = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null, "Deseja excluir esse Chale: "+txtIDChale.getText()+"?","Exclusão",
				JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null,
				opcoes, opcoes[0]);
				if(JOptionPane.YES_OPTION == i){
				lblMensagem.setText(ec.excluir(emp));
				}
			}
		});
		btnExcluir.setFont(new Font("Dialog", Font.BOLD, 11));
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Chale> listaEmp = new ArrayList<Chale>();
				ChaleController ec = new ChaleController();
				listaEmp = ec.listarTodos();
				DefaultTableModel tbm =(DefaultTableModel)tblConsulta.getModel();
				for(int i = tbm.getRowCount()-1; i >= 0; i--){
				tbm.removeRow(i);
				}
				int i = 0;
				for(Chale ep : listaEmp){
				tbm.addRow(new String[1]);
				tblConsulta.setValueAt(ep.getCodChale(), i, 0);
				tblConsulta.setValueAt(ep.getCapacidade(), i, 1);
				tblConsulta.setValueAt(ep.getLocalizacao(), i, 2);
				tblConsulta.setValueAt(ep.getValorAltaEstacao(), i, 3);
				tblConsulta.setValueAt(ep.getValorBaixaEstacao(), i, 4);
				i++;
				}
			}
		});
		btnPesquisar.setFont(new Font("Dialog", Font.BOLD, 11));
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIDChale.setText("");
				txtCapacidade.setText("");
				txtLocalizacao.setText("");
				txtValorAltaEstacao.setText("");
				txtValorBaixaEstacao.setText("");
				DefaultTableModel tbm = (DefaultTableModel)tblConsulta.getModel();
				for(int i = tbm.getRowCount()-1; i >= 0; i--){
					tbm.removeRow(i);
				}
			}
		});
		btnLimpar.setFont(new Font("Dialog", Font.BOLD, 11));
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmChale.this.dispose();
			}
		});
		btnSair.setFont(new Font("Dialog", Font.BOLD, 11));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAlterar, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(btnExcluir, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnPesquisar, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnLimpar, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE)
						.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisar, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(4))
		);
		panel_1.setLayout(gl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tblConsulta = new JTable();
		tblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer linha = tblConsulta.getSelectedRow();
				String codChale= tblConsulta.getValueAt(linha, 0).toString();
				String capacidade = tblConsulta.getValueAt(linha, 1).toString();
				String localizacao = tblConsulta.getValueAt(linha, 2).toString();
				String alta = tblConsulta.getValueAt(linha, 3).toString();
				String baixa = tblConsulta.getValueAt(linha, 4).toString();
				txtIDChale.setText(codChale);
				txtCapacidade.setText(capacidade);
				txtLocalizacao.setText(localizacao);
				txtValorAltaEstacao.setText(alta);
				txtValorBaixaEstacao.setText(baixa);
				
			}
		});
		tblConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Chal\u00E9", "Capacidade", "Localiza\u00E7\u00E3o", "Valor Alta Esta\u00E7\u00E3o", "Valor Baixa Esta\u00E7\u00E3o"
			}
		) {
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblConsulta.getColumnModel().getColumn(0).setResizable(false);
		tblConsulta.getColumnModel().getColumn(1).setResizable(false);
		tblConsulta.getColumnModel().getColumn(2).setResizable(false);
		tblConsulta.getColumnModel().getColumn(3).setResizable(false);
		tblConsulta.getColumnModel().getColumn(4).setResizable(false);
		scrollPane.setViewportView(tblConsulta);
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblIdChal = new JLabel("ID Chalé:");
		
		JLabel lblCapacidade = new JLabel("Capacidade:");
		
		JLabel lblLocalizao = new JLabel("Localização:");
		
		JLabel lblValorAltaEstao = new JLabel("Valor Alta Estação:");
		
		JLabel lblValorBaixaEstao = new JLabel("Valor Baixa Estação:");
		
		txtIDChale = new JTextField();
		txtIDChale.setColumns(10);
		
		txtCapacidade = new JTextField();
		txtCapacidade.setColumns(10);
		
		txtLocalizacao = new JTextField();
		txtLocalizacao.setColumns(10);
		
		txtValorAltaEstacao = new JTextField();
		txtValorAltaEstacao.setColumns(10);
		
		txtValorBaixaEstacao = new JTextField();
		txtValorBaixaEstacao.setColumns(10);
		
		lblMensagem = new JLabel("Mensagem:");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblIdChal)
							.addGap(37)
							.addComponent(txtIDChale))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblCapacidade)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCapacidade))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblLocalizao)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtLocalizacao)))
					.addGap(64)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblValorAltaEstao)
								.addComponent(lblValorBaixaEstao))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtValorBaixaEstacao)
								.addComponent(txtValorAltaEstacao)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblMensagem, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
							.addGap(188)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdChal)
						.addComponent(txtIDChale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblValorAltaEstao)
						.addComponent(txtValorAltaEstacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCapacidade)
						.addComponent(txtCapacidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblValorBaixaEstao)
						.addComponent(txtValorBaixaEstacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocalizao)
						.addComponent(txtLocalizacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMensagem))
					.addGap(24))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
