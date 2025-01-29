package tela;

import dados.Dicionario;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaDicionario extends JFrame {
    private Dicionario dicionario;
    private JTextField txtPalavra;
    private JTextArea txtResultado;
    private JComboBox<String> cbIdiomas;
    private JComboBox<String> cbDirecao;
    private JLabel lblBandeira;
    private JLabel lblMensagem;
    private JButton btnLocalizar;

    public TelaDicionario() {
        try {
            dicionario = new Dicionario("ingles");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao inicializar: " + e.getMessage());
            System.exit(1);
        }

        setTitle("Sistema de Tradução - TRAIN");
        setSize(700, 550);
        setLayout(null);

        JLabel lblTitulo = new JLabel("Sistema de Tradução de Palavras (TRAIN)");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBounds(150, 10, 400, 30);
        add(lblTitulo);

        JLabel lblPalavra = new JLabel("Digite a palavra:");
        lblPalavra.setBounds(20, 60, 120, 20);
        add(lblPalavra);

        txtPalavra = new JTextField();
        txtPalavra.setBounds(140, 60, 200, 25);
        add(txtPalavra);

        JLabel lblIdioma = new JLabel("Escolha o idioma:");
        lblIdioma.setBounds(20, 100, 120, 20);
        add(lblIdioma);

        cbIdiomas = new JComboBox<>();
        for (String idioma : dicionario.getIdiomas()) {
            cbIdiomas.addItem(idioma);
        }
        cbIdiomas.setBounds(140, 100, 200, 25);
        add(cbIdiomas);

        JLabel lblDirecao = new JLabel("Direção da tradução:");
        lblDirecao.setBounds(20, 140, 150, 20);
        add(lblDirecao);

        cbDirecao = new JComboBox<>(new String[]{"De Idioma para Português", "De Português para Idioma"});
        cbDirecao.setBounds(140, 140, 200, 25);
        add(cbDirecao);

        JButton btnTraduzir = new JButton("Traduzir");
        btnTraduzir.setBounds(360, 60, 100, 30);
        add(btnTraduzir);

        btnLocalizar = new JButton("Localizar");
        btnLocalizar.setBounds(480, 60, 100, 30);
        add(btnLocalizar);

        txtResultado = new JTextArea();
        txtResultado.setBounds(20, 200, 640, 250);
        txtResultado.setEditable(false);
        txtResultado.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(txtResultado);

        lblBandeira = new JLabel();
        lblBandeira.setBounds(600, 20, 80, 50);
        atualizarBandeira("ingles");
        add(lblBandeira);

        lblMensagem = new JLabel("");
        lblMensagem.setBounds(20, 470, 640, 20);
        lblMensagem.setForeground(Color.BLUE);
        add(lblMensagem);

        cbIdiomas.addActionListener(e -> {
            try {
                String idioma = (String) cbIdiomas.getSelectedItem();
                dicionario.setIdioma(idioma);
                atualizarBandeira(idioma);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao mudar idioma: " + ex.getMessage());
            }
        });

        btnTraduzir.addActionListener(e -> traduzirPalavra());
        btnLocalizar.addActionListener(e -> localizarPalavra());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void traduzirPalavra() {
        String termo = txtPalavra.getText().trim();
        if (termo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite uma palavra para traduzir.");
            return;
        }

        List<String> resultados;
        String direcao = (String) cbDirecao.getSelectedItem();

        if ("De Idioma para Português".equals(direcao)) {
            resultados = dicionario.traduzirParaPortugues(termo);
        } else {
            resultados = dicionario.traduzirParaIdioma(termo);
        }

        exibirResultados(resultados);
    }

    private void localizarPalavra() {
        String termo = txtPalavra.getText().trim();
        if (termo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite uma palavra para localizar.");
            return;
        }

        List<String> resultados;
        String direcao = (String) cbDirecao.getSelectedItem();

        if ("De Idioma para Português".equals(direcao)) {
            resultados = dicionario.localizarPalavraIdioma(termo);
        } else {
            resultados = dicionario.localizarPalavraPortugues(termo);
        }

        exibirResultados(resultados);
    }

    private void exibirResultados(List<String> resultados) {
        txtResultado.setText("");
        if (resultados.isEmpty()) {
            txtResultado.append("Nenhum resultado encontrado.\n");
            lblMensagem.setText("Nenhum resultado encontrado.");
        } else {
            txtResultado.append("Resultados encontrados (" + resultados.size() + "):\n");
            for (String resultado : resultados) {
                txtResultado.append("- " + resultado + "\n");
            }
            lblMensagem.setText("Consulta realizada com sucesso!");
        }
    }

    private void atualizarBandeira(String idioma) {
        String arquivoImagem = "/imagens/" + idioma + ".png";
        ImageIcon bandeira = new ImageIcon(getClass().getResource(arquivoImagem));
        lblBandeira.setIcon(new ImageIcon(bandeira.getImage().getScaledInstance(80, 50, Image.SCALE_SMOOTH)));
    }

    public static void main(String[] args) {
        new TelaDicionario();
    }
}