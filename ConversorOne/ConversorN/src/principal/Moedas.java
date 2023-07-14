package principal;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Moedas extends JFrame {

    Moedas() {
        // criando janela e definindo

        setTitle("Conversor");
        setSize(420, 420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // criando caixa selecionavel 1
        JPanel painel = new JPanel();
        JComboBox<String> caixa1 = new JComboBox<>();
        caixa1.addItem("Reais");
        caixa1.addItem("Dólar Americano");
        caixa1.addItem("Euro");
        caixa1.addItem("Libras Esterlinas");
        caixa1.addItem("Peso argentino");
        caixa1.addItem("Peso Chileno");
        Dimension tamanho = new Dimension(10, 10);
        caixa1.setPreferredSize(tamanho);
        Dimension comboBoxSize = new Dimension(20, 50);

        // criando caixa selecionavel 2
        JComboBox<String> caixa2 = new JComboBox<>();
        caixa2.addItem("Reais");
        caixa2.addItem("Dólar Americano");
        caixa2.addItem("Euro");
        caixa2.addItem("Libras Esterlinas");
        caixa2.addItem("Peso argentino");
        caixa2.addItem("Peso Chileno");
        caixa2.setPreferredSize(tamanho);

        // botao conversao
        JButton btn1 = new JButton("Converter");

        // configurando layout
        painel.setLayout(new GridLayout(5, 5, 10, 20));

        Font fonte = new Font("Arial", Font.BOLD, 20);
        JTextField n1 = new JTextField();
        JLabel n2 = new JLabel();

        painel.add(caixa1);
        painel.add(n1);
        painel.add(caixa2);
        painel.add(btn1);
        painel.add(n2);

        caixa1.setPreferredSize(comboBoxSize);
        caixa2.setPreferredSize(comboBoxSize);

        setContentPane(painel);

        caixa1.setFont(fonte);
        n1.setFont(fonte);
        caixa2.setFont(fonte);
        btn1.setFont(fonte);
        n2.setFont(fonte);

        // adicionando listener
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                String item1 = (String) caixa1.getSelectedItem();
                String item2 = (String) caixa2.getSelectedItem();
            
                String valorStr = n1.getText();
                try {
                double valor = Double.parseDouble(valorStr);

                double resultado = 0.0;    
                
                if (item1.equals("Reais") && item2.equals("Dólar Americano")) {
                    resultado = valor / 5.0;
                } else if (item1.equals("Reais") && item2.equals("Euro")) {
                    resultado = valor / 5;
                } else if (item1.equals("Reais") && item2.equals("Libras Esterlinas")) {
                    resultado = valor / 6;
                } else if (item1.equals("Reais") && item2.equals("Peso argentino")) {
                    resultado = valor / 0.05;
                } else if (item1.equals("Reais") && item2.equals("Peso Chileno")) {
                    resultado = valor / 0.007;
                } else if (item1.equals("Dólar Americano") && item2.equals("Reais")) {
                    resultado = valor * 5;
                } else if (item1.equals("Euro") && item2.equals("Reais")) {
                    resultado = valor * 5;
                } else if (item1.equals("Libras Esterlinas") && item2.equals("Reais")) {
                    resultado = valor * 6;
                } else if (item1.equals("Peso argentino") && item2.equals("Reais")) {
                    resultado = valor * 0.05;
                } else if (item1.equals("Peso Chileno") && item2.equals("Reais")) {
                    resultado = valor * 0.007;
                } 
                
                
                DecimalFormat df = new DecimalFormat("#.##");
                String resultadoArredondado = df.format(resultado);

                n2.setText(resultadoArredondado);
               }
                catch (NumberFormatException e) {
                    n2.setText("Escreva apenas números.");
                }
              }
        });

   
        setVisible(true);
    }

    public static void main(String[] args) {
        new Moedas();
    }
}
