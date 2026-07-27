package org.example.View;

import javax.swing.JOptionPane;
import org.example.Controller.CarroController;
import org.example.Controller.ClienteController;
import org.example.Controller.MecanicoController;
import org.example.Controller.OrdemDeServicoController;
import org.example.Model.Carro;
import org.example.Model.Cliente;
import org.example.Model.Mecanico;
import org.example.Model.OrdemDeServico;

public class FormularioOrdemdeServico extends javax.swing.JDialog {

    private final OrdemDeServicoController osController;
    private final ClienteController clienteController;
    private final CarroController carroController;
    private final MecanicoController mecanicoController;
    private boolean modoEdicao = false;
    private String placaOriginal;

    public FormularioOrdemdeServico(java.awt.Frame parent, boolean modal,
            OrdemDeServicoController osController,
            ClienteController clienteController,
            CarroController carroController,
            MecanicoController mecanicoController,
            OrdemDeServico ordem) {
        super(parent, modal);
        initComponents();
        this.osController = osController;
        this.clienteController = clienteController;
        this.carroController = carroController;
        this.mecanicoController = mecanicoController;

        preencherComboBoxes();

        setLocationRelativeTo(null);
        setResizable(false);

        if (ordem != null) {
            modoEdicao = true;
            placaOriginal = ordem.getCarroConserto().getPlaca();

            jComboBox1.setSelectedItem(ordem.getCarroConserto().getProprietario().getCpf() + " - " + ordem.getCarroConserto().getProprietario().getNome());
            jComboBox2.setSelectedItem(ordem.getCarroConserto().getPlaca() + " - " + ordem.getCarroConserto().getModelo());
            jComboBox3.setSelectedItem(ordem.getMecanicoResponsavel().getCpf() + " - " + ordem.getMecanicoResponsavel().getNome());

            jTextField1.setText(ordem.getDescricaoDefeito());
            jTextField2.setText(String.valueOf(ordem.getValorConserto()));

            jComboBox1.setEnabled(false);
            jComboBox2.setEnabled(false);
            setTitle("Atualizar Ordem de Serviço");
        } else {
            setTitle("Cadastrar nova Ordem de Serviço");
        }
    }

    private void preencherComboBoxes() {
        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
        jComboBox3.removeAllItems();

        for (Cliente c : clienteController.listarClientes()) {
            jComboBox1.addItem(c.getCpf() + " - " + c.getNome());
        }

        for (Carro car : carroController.listarCarros()) {
            jComboBox2.addItem(car.getPlaca() + " - " + car.getModelo());
        }

        for (Mecanico m : mecanicoController.listarMecanicos()) {
            jComboBox3.addItem(m.getCpf() + " - " + m.getNome());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Cliente:");
        jLabel2.setText("Carro:");
        jLabel3.setText("Mecânico:");
        jLabel4.setText("Descrição:");
        jLabel5.setText("Valor:");

        jButton1.setText("Enviar");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, 250, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (jComboBox2.getSelectedItem() == null || jComboBox3.getSelectedItem() == null) {
                throw new IllegalArgumentException("Selecione um Carro e um Mecânico válidos.");
            }

            String itemCarro = jComboBox2.getSelectedItem().toString();
            String placaCarro = itemCarro.split(" - ")[0];

            String itemMecanico = jComboBox3.getSelectedItem().toString();
            String cpfMecanico = itemMecanico.split(" - ")[0];

            String descricao = jTextField1.getText().trim();
            String valorTexto = jTextField2.getText().trim().replace(",", ".");

            if (valorTexto.isEmpty()) {
                throw new IllegalArgumentException("Informe o valor do conserto.");
            }

            float valor = Float.parseFloat(valorTexto);

            if (modoEdicao) {
                osController.atualizarOrdemDeServico(cpfMecanico, placaOriginal, descricao, valor);
                JOptionPane.showMessageDialog(this, "Ordem de Serviço atualizada com sucesso!");
            } else {
                osController.adicionarOrdemDeServico(cpfMecanico, placaCarro, descricao, valor);
                JOptionPane.showMessageDialog(this, "Ordem de Serviço cadastrada com sucesso!");
            }

            dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite um valor numérico válido no campo Valor.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration
}
