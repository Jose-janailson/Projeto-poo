package org.example.View;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.example.Controller.CarroController;
import org.example.Controller.ClienteController;
import org.example.Controller.MecanicoController;
import org.example.Controller.OrdemDeServicoController;
import org.example.Model.OrdemDeServico;
import org.example.repository.CarroRepository;
import org.example.repository.ClienteRepository;
import org.example.repository.MecanicoRepository;
import org.example.repository.OrdemDeServicoRepository;

public class TelaOrdemDeServico extends javax.swing.JFrame {

    private final OrdemDeServicoController osController;
    private final ClienteController clienteController;
    private final CarroController carroController;
    private final MecanicoController mecanicoController;

    public TelaOrdemDeServico() {
        initComponents();

        ClienteRepository clienteRepo = new ClienteRepository();
        CarroRepository carroRepo = new CarroRepository();
        MecanicoRepository mecanicoRepo = new MecanicoRepository();
        OrdemDeServicoRepository osRepo = new OrdemDeServicoRepository();

        this.clienteController = new ClienteController(clienteRepo);
        this.carroController = new CarroController(carroRepo, clienteRepo);
        this.mecanicoController = new MecanicoController(mecanicoRepo);
        this.osController = new OrdemDeServicoController(carroRepo, mecanicoRepo, osRepo);
        atualizarTabela();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void atualizarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tblOrdens.getModel();
        modelo.setRowCount(0);

        for (OrdemDeServico os : osController.listarAsOrdens()) {
            modelo.addRow(new Object[]{
                os.getCarroConserto().getProprietario().getNome(),
                os.getCarroConserto().getModelo() + " (" + os.getCarroConserto().getPlaca() + ")",
                os.getMecanicoResponsavel().getNome(),
                os.getDescricaoDefeito(),
                os.getValorConserto()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botaoCadastrar = new javax.swing.JButton();
        botaoRemover = new javax.swing.JButton();
        botaoAtualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrdens = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Voltar");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel1.setText("Ordens de Serviço");

        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(this::botaoCadastrarActionPerformed);

        botaoRemover.setText("Remover");
        botaoRemover.addActionListener(this::botaoRemoverActionPerformed);

        botaoAtualizar.setText("Atualizar");
        botaoAtualizar.setToolTipText("");
        botaoAtualizar.addActionListener(this::botaoAtualizarActionPerformed);

        tblOrdens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cliente", "Carro", "Mecânico", "Descrição ", "Valor"
            }
        ));
        jScrollPane1.setViewportView(tblOrdens);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(botaoRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botaoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        OficinaProject principal = new OficinaProject();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        FormularioOrdemdeServico dialog = new FormularioOrdemdeServico(
                this, true, osController, clienteController, carroController, mecanicoController, null
        );
        dialog.setVisible(true);
        atualizarTabela();
    }

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int linha = tblOrdens.getSelectedRow();
            if (linha == -1) {
                JOptionPane.showMessageDialog(this, "Selecione uma Ordem de Serviço na tabela.");
                return;
            }

            String carroTexto = tblOrdens.getValueAt(linha, 1).toString();
            String placa = carroTexto.substring(carroTexto.indexOf("(") + 1, carroTexto.indexOf(")"));

            osController.removerOrdemDeServico(placa);
            atualizarTabela();
            JOptionPane.showMessageDialog(this, "Ordem de Serviço removida com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro ao remover", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void botaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {
        int linha = tblOrdens.getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma Ordem de Serviço na tabela.");
            return;
        }

        String carroTexto = tblOrdens.getValueAt(linha, 1).toString();
        String placa = carroTexto.substring(carroTexto.indexOf("(") + 1, carroTexto.indexOf(")"));

        OrdemDeServico ordem = osController.buscarPorPlaca(placa);

        FormularioOrdemdeServico dialog = new FormularioOrdemdeServico(
                this, true, osController, clienteController, carroController, mecanicoController, ordem
        );

        dialog.setVisible(true);
        atualizarTabela();
    }

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        OficinaProject principal = new OficinaProject();
        principal.setVisible(true);
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOrdens;
    // End of variables declaration//GEN-END:variables
}
