package pmf.math.kalkulatori;

import pmf.math.algoritmi.Abeceda;
import pmf.math.baza.dao.SupstitucijskaDAO;
import pmf.math.baza.tablice.SupstitucijskaPovijest;
import pmf.math.kriptosustavi.SupstitucijskaKriptosustav;
import pmf.math.obradaunosa.ObradaUnosa;
import pmf.math.router.Konzola;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.Arrays;
import java.util.HashSet;

public class SupstitucijskaKalkulator {
  private final JFormattedTextField[] textFields = new JFormattedTextField[26];
  private final SupstitucijskaDAO supstitucijskaDAO = new SupstitucijskaDAO();
  private final Konzola konzola; // Za ispis greške.
  public JPanel glavniPanel;
  private JTextArea otvoreniTekstArea;
  private JButton sifrirajButton;
  private JButton desifrirajButton;
  private JTextArea sifratArea;
  private JFormattedTextField textField0;
  private JFormattedTextField textField1;
  private JFormattedTextField textField2;
  private JFormattedTextField textField3;
  private JFormattedTextField textField4;
  private JFormattedTextField textField5;
  private JFormattedTextField textField6;
  private JFormattedTextField textField7;
  private JFormattedTextField textField8;
  private JFormattedTextField textField9;
  private JFormattedTextField textField10;
  private JFormattedTextField textField11;
  private JFormattedTextField textField12;
  private JFormattedTextField textField13;
  private JFormattedTextField textField14;
  private JFormattedTextField textField15;
  private JFormattedTextField textField16;
  private JFormattedTextField textField17;
  private JFormattedTextField textField18;
  private JFormattedTextField textField19;
  private JFormattedTextField textField20;
  private JFormattedTextField textField21;
  private JFormattedTextField textField22;
  private JFormattedTextField textField23;
  private JFormattedTextField textField24;
  private JFormattedTextField textField25;
  private JButton ocistiButton;
  private JLabel preostalaLabel;
  private JButton identitetaButton;
  private JButton ocistiSveButton;
  private JLabel iskoristenaLabel;
  private JPanel povijestPanel;

  public SupstitucijskaKalkulator(Konzola konzola) {
    this.konzola = konzola;
    SwingUtilities.invokeLater(() -> {
      napuniTextFields();
      postaviTextFields();
      osvjeziPovijest();

      sifrirajButton.addActionListener(new Sifriraj());
      desifrirajButton.addActionListener(new Desifriraj());

      // Brisanje unosa i postavljanje na identitetu.
      ocistiButton.addActionListener(e -> ocistiKljuc());
      ocistiSveButton.addActionListener(e -> ocistiPolja());
      identitetaButton.addActionListener(
          e -> {
            for (int i = 0; i < 26; i++) textFields[i].setValue(Abeceda.uSlovo(i));
            azurirajSlovaLabele();
            for (int i = 0; i < 26; i++) textFields[i].setBackground(Color.white);
          });

      // Sva napisana slova se automatski prebacuju u velika. Ažuriramo label preostalih slova.
      for (JFormattedTextField tf : textFields) {
        tf.addKeyListener(
            new KeyListener() {
              @Override
              public void keyTyped(KeyEvent e) {}

              @Override
              public void keyPressed(KeyEvent e) {}

              @Override
              public void keyReleased(KeyEvent e) {
                tf.setText(tf.getText().toUpperCase());
                azurirajSlovaLabele();
                obojajDuplikate();
              }
            });
      }
    });
  }

  private void obojajDuplikate() {
    int[] permutacija = dohvatiTextFields();
    HashSet<Integer> duplicirani = new HashSet<>();
    for (int i = 0; i < 26; i++)
      if (permutacija[i] != -1) {
        for (int j = 0; j < 26; j++)
          if (i != j && permutacija[i] == permutacija[j]) duplicirani.add(i);
      }

    for (int i = 0; i < 26; i++) {
      if (duplicirani.contains(permutacija[i]))
        textFields[i].setBackground(new Color(239, 120, 120));
      else textFields[i].setBackground(Color.white);
    }

    for (Integer slovo : duplicirani) {
      System.out.println(slovo);
    }
  }

  private void ocistiKljuc() {
    for (int i = 0; i < 26; i++) textFields[i].setValue(null);
    azurirajSlovaLabele();
    for (int i = 0; i < 26; i++) textFields[i].setBackground(Color.white);
  }

  private void ocistiPolja() {
    otvoreniTekstArea.setText("");
    sifratArea.setText("");
  }

  private void azurirajSlovaLabele() {
    String novaPreostala = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    StringBuilder novaIskoristena = new StringBuilder();
    int[] permutacija = dohvatiTextFields();
    Arrays.sort(permutacija);
    for (int i = 0; i < 26; i++) {
      novaPreostala = novaPreostala.replace(String.valueOf(Abeceda.uSlovo(permutacija[i])), "");
      if (permutacija[i] != -1) novaIskoristena.append(Abeceda.uSlovo(permutacija[i]));
    }
    preostalaLabel.setText(novaPreostala.replaceAll("([A-Z])", "$0 "));
    iskoristenaLabel.setText(novaIskoristena.toString().replaceAll("([A-Z])", "$0 "));
  }

  // Dohvaća vrijednost text fieldova i vraća pripadnu permutaciju (s brojevima).
  private int[] dohvatiTextFields() {
    int[] vrijednosti = new int[26];

    for (int i = 0; i < 26; i++) vrijednosti[i] = Abeceda.uBroj(textFields[i].getText().charAt(0));

    return vrijednosti;
  }

  private void postaviTextFields() {
    try {
      // Postavi dozvoljena slova za unos.
      MaskFormatter mask = new MaskFormatter("*");
      mask.setPlaceholderCharacter('_');
      mask.setValidCharacters("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_");
      DefaultFormatterFactory factory = new DefaultFormatterFactory(mask);
      for (int i = 0; i < 26; i++) {
        textFields[i].setFormatterFactory(factory);
        textFields[i].setValue(Abeceda.uSlovo(i)); // Na početku je zadana permutacija identiteta.
      }
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  public JButton stvoriGumbPovijesti(SupstitucijskaPovijest povijest) {
    String tekst = (povijest.getPermutacija()).replaceAll("([A-Z])", "$0 ");
    JButton noviGumb = new JButton(tekst);

    noviGumb.addActionListener(
        e -> {
          for (int i = 0; i < 26; i++) textFields[i].setValue(tekst.charAt(i));
        });

    return noviGumb;
  }

  public void osvjeziPovijest() {
    povijestPanel.removeAll();
    povijestPanel.setLayout(new GridLayout(5, 1));
    povijestPanel.setBorder(BorderFactory.createLineBorder(new Color(175, 175, 175)));
    supstitucijskaDAO
        .dohvatiElemente()
        .forEach(element -> povijestPanel.add(stvoriGumbPovijesti(element)));
    povijestPanel.revalidate();
  }

  private void napuniTextFields() {
    textFields[0] = textField0;
    textFields[1] = textField1;
    textFields[2] = textField2;
    textFields[3] = textField3;
    textFields[4] = textField4;
    textFields[5] = textField5;
    textFields[6] = textField6;
    textFields[7] = textField7;
    textFields[8] = textField8;
    textFields[9] = textField9;
    textFields[10] = textField10;
    textFields[11] = textField11;
    textFields[12] = textField12;
    textFields[13] = textField13;
    textFields[14] = textField14;
    textFields[15] = textField15;
    textFields[16] = textField16;
    textFields[17] = textField17;
    textFields[18] = textField18;
    textFields[19] = textField19;
    textFields[20] = textField20;
    textFields[21] = textField21;
    textFields[22] = textField22;
    textFields[23] = textField23;
    textFields[24] = textField24;
    textFields[25] = textField25;
  }

  // -----------------------------------------------------------------------------------------------------------------
  // Listeneri.
  private class Sifriraj implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      String otvoreniTekst = otvoreniTekstArea.getText();
      int[] permutacija = dohvatiTextFields(); // Permutacija kojom šifriramo.

      // Provjeri unose (zbog ispisa poruka).
      boolean greska = false;
      if (ObradaUnosa.kriviUnos(permutacija)) {
        konzola.ispisiGresku("Niti jedna dva slova ključa ne smiju biti ista!");
        greska = true;
      }
      if (ObradaUnosa.kriviUnos(otvoreniTekst)) {
        konzola.ispisiGresku("Otvoreni tekst smije sadržavati samo slova engleske abecede!");
        greska = true;
      }

      // Šifriraj (ako je moguće).
      if (!greska) {
        String sifrat = (new SupstitucijskaKriptosustav(permutacija)).sifriraj(otvoreniTekst);
        sifratArea.setText(sifrat);
        konzola.ispisiPoruku("Poruka uspješno šifrirana.");

        // Ispis i ažuriranje povijesti.
        supstitucijskaDAO.ubaciElement(
            (new SupstitucijskaKriptosustav(permutacija).dohvatiPermutacijuString()));
        osvjeziPovijest();
      }
    }
  }

  private class Desifriraj implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      String sifrat = sifratArea.getText();
      int[] permutacija = dohvatiTextFields(); // Permutacija kojom šifriramo.

      // Provjeri unose (zbog ispisa poruka).
      boolean greska = false;
      if (ObradaUnosa.kriviUnos(permutacija)) {
        konzola.ispisiGresku("Niti jedna dva slova se ne smiju preslikati u isto!");
        greska = true;
      }
      if (ObradaUnosa.kriviUnos(sifrat)) {
        konzola.ispisiGresku("Šifrat smije sadržavati samo slova engleske abecede!");
        greska = true;
      }

      // Dešifriraj (ako je moguće).
      if (!greska) {
        String otvoreniTekst = (new SupstitucijskaKriptosustav(permutacija)).desifriraj(sifrat);
        otvoreniTekstArea.setText(otvoreniTekst);
        konzola.ispisiPoruku("Poruka uspješno dešifrirana.");

        // Ispis i ažuriranje povijesti.
        supstitucijskaDAO.ubaciElement(
            (new SupstitucijskaKriptosustav(permutacija).dohvatiPermutacijuString()));
        osvjeziPovijest();
      }
    }
  }
}
