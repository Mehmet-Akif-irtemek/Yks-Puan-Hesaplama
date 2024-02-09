import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Yks1 extends JFrame{
    private JComboBox<Integer> matD;    private JComboBox<Integer> fenDogruField;
    private JComboBox<Integer> turkceDogruField;
    private JComboBox<Integer> sosyalDogruField;
    private JComboBox<Integer> matamatikYanlisField;
    private JComboBox<Integer> fenYanlisField;
    private JComboBox<Integer> turkceYanlisField;
    private JComboBox<Integer> sosyalYanlisField;

    private JComboBox<Integer> amatD;
    private  JComboBox<Integer> afenDogruField;
    private JComboBox<Integer> afenYanlisField;
    private JComboBox<Integer> aturkceDogruField;
    private JComboBox<Integer> asosyalYanlisField;
    private JComboBox<Integer> aturkceYanlisField;

    private JComboBox<Integer> asosyalDogruField;
    private JComboBox<Integer> aMatamatikYanlisField;

    private JButton hesaplaButton;
    private JLabel sonucLabel;
    private static final long serialVersionUID=1L;

    public Yks1(){
        setTitle("Yks Puan Hesaplama");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,500);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel contentPane = new JPanel(){
            private static final long serialVersionUID = 1L;
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                int width = getWidth();
                int height = getHeight();
                GradientPaint gradient = new GradientPaint(0, 0, Color.yellow, 0, height, Color.green);

                g2d.setPaint(gradient);
                g2d.fillRect(0,0, width,height);

            }
        };
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("TYT", createYksTab());        tabbedPane.addTab("Ayt", createAytTab());
        contentPane.add(tabbedPane,BorderLayout.CENTER);
        hesaplaButton = new JButton("Hesapla");
        hesaplaButton.setBackground(Color.BLUE);
         contentPane.add(hesaplaButton,BorderLayout.SOUTH);

         hesaplaButton.addActionListener(new ActionListener() {
        public void  actionPerformed(ActionEvent e){
            hesaplaYks();
        }
         });
         sonucLabel = new JLabel("YKS Puanınız");
         sonucLabel.setFont(new Font("Arial",Font.BOLD,18));
         sonucLabel.setForeground(Color.BLACK);
         contentPane.add(sonucLabel,BorderLayout.NORTH);

    }
    private JPanel createYksTab(){
        JPanel yksTab = new JPanel();
        yksTab.setLayout(new GridLayout(8,2));

        yksTab.add(new JLabel("Matematik Doğru Sayısı:"));
        matD = new JComboBox<>(createComboBoxModel());
        yksTab.add(matD);

        yksTab.add(new JLabel("Türkçe Doğru Sayısı:"));
        turkceDogruField = new JComboBox<>(createComboBoxModel());
        yksTab.add(turkceDogruField);

        yksTab.add(new JLabel("Fen Doğru Sayısı:"));
        fenDogruField = new JComboBox<>(createComboBoxModel());
        yksTab.add(fenDogruField);

        yksTab.add(new JLabel("Sosyal Doğru Sayısı:"));
        sosyalDogruField = new JComboBox<>(createComboBoxModel());
        yksTab.add(sosyalDogruField);

        yksTab.add(new JLabel("Matamatik Yanlış Sayısı:"));
        matamatikYanlisField = new JComboBox<>(createComboBoxModel());
        yksTab.add(matamatikYanlisField);

        yksTab.add(new JLabel("Fen Bilimleri Yanlış Sayısı:"));
        fenYanlisField = new JComboBox<>(createComboBoxModel());
        yksTab.add(fenYanlisField);

        yksTab.add(new JLabel("Türkçe Yanlış Sayısı:"));
        turkceYanlisField = new JComboBox<>(createComboBoxModel());
        yksTab.add(turkceYanlisField);

        yksTab.add(new JLabel("Sosyal Yanlış Sayısı:"));
        sosyalYanlisField = new JComboBox<>(createComboBoxModel());
        yksTab.add(sosyalYanlisField);
        return yksTab;
    }
    private JPanel createAytTab(){
        JPanel aytTab = new JPanel();
        aytTab.setLayout(new GridLayout(8,2));


        aytTab.add(new JLabel("AYT Matematik Doğru Sayısı:"));
        amatD = new JComboBox<>(createComboBoxModel());
        aytTab.add(amatD);

        aytTab.add(new JLabel("AYT COĞRAFYA Doğru Sayısı:"));
        afenDogruField = new JComboBox<>(createComboBoxModel());
        aytTab.add(afenDogruField);

        aytTab.add(new JLabel("AYT EDEBİYAT Doğru Sayısı:"));
        aturkceDogruField = new JComboBox<>(createComboBoxModel());
        aytTab.add(aturkceDogruField);

        aytTab.add(new JLabel("AYT TARİH  Doğru Sayısı:"));
        asosyalDogruField = new JComboBox<>(createComboBoxModel());
        aytTab.add(asosyalDogruField);

        aytTab.add(new JLabel("AYT Matematik Yanlış Sayısı:"));
        aMatamatikYanlisField = new JComboBox<>(createComboBoxModel());
        aytTab.add(aMatamatikYanlisField);

        aytTab.add(new JLabel("AYT COĞRAFYA Yanlış Sayısı:"));
        afenYanlisField = new JComboBox<>(createComboBoxModel());
        aytTab.add(afenYanlisField);

        aytTab.add(new JLabel("AYT EDEBİYAT Yanlış Sayısı:"));
        aturkceYanlisField = new JComboBox<>(createComboBoxModel());
        aytTab.add(aturkceYanlisField);

        aytTab.add(new JLabel("AYT TARİH Yanlış Sayısı:"));
        asosyalYanlisField = new JComboBox<>(createComboBoxModel());
        aytTab.add(asosyalYanlisField);

return aytTab;
    }
    private DefaultComboBoxModel<Integer> createComboBoxModel(){
        DefaultComboBoxModel<Integer> model = new DefaultComboBoxModel<>();
        for (int i = 0; i <= 40;i++){
            model.addElement(i);
        }
        return model;
    }
    private void hesaplaYks(){
        int matamatikDogru = (int) matD.getSelectedItem();
        int fenDogru = (int) fenDogruField.getSelectedItem();
        int turkceDogru = (int) turkceDogruField.getSelectedItem();
        int sosyalDogru = (int) sosyalDogruField.getSelectedItem();

        int matamatikYanlıs = (int) matamatikYanlisField.getSelectedItem();
        int fenYanlıs = (int) fenYanlisField.getSelectedItem();
        int turkceYanlıs = (int) turkceYanlisField.getSelectedItem();
        int sosyalYanlıs = (int) sosyalYanlisField.getSelectedItem();

        int amatamatikDogru = (int) amatD.getSelectedItem();
        int afenDogru = (int) afenDogruField.getSelectedItem();
        int aturkceDogru = (int) aturkceDogruField.getSelectedItem();
        int asosyalDogru = (int) asosyalDogruField.getSelectedItem();

        int amatamatikYanlıs = (int) aMatamatikYanlisField.getSelectedItem();
        int afenYanlıs = (int) afenYanlisField.getSelectedItem();
        int aturkceYanlıs = (int) aturkceYanlisField.getSelectedItem();
        int asosyalYanlıs = (int) asosyalYanlisField.getSelectedItem();

        if (matamatikDogru > 40){
            JOptionPane.showMessageDialog(Yks1.this,"Matamatik doğru sayısı 40'tan fazla olamaz.","Hata",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (turkceDogru > 40){
            JOptionPane.showMessageDialog(Yks1.this,"Türkçe doğru sayısı 40'tan fazla olamaz.","Hata",JOptionPane.ERROR_MESSAGE);
            return;
        }       if (sosyalDogru > 40){
            JOptionPane.showMessageDialog(Yks1.this,"Sosyal doğru sayısı 40'tan fazla olamaz.","Hata",JOptionPane.ERROR_MESSAGE);
            return;
        }       if (fenDogru > 40){
            JOptionPane.showMessageDialog(Yks1.this,"Fen doğru sayısı 40'tan fazla olamaz.","Hata",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (amatamatikDogru > 40){
            JOptionPane.showMessageDialog(Yks1.this," AYT Matamatik doğru sayısı 40'tan fazla olamaz.","Hata",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (aturkceDogru > 40){
            JOptionPane.showMessageDialog(Yks1.this,"AYT Türkçe doğru sayısı 40'tan fazla olamaz.","Hata",JOptionPane.ERROR_MESSAGE);
            return;
        }       if (asosyalDogru > 40){
            JOptionPane.showMessageDialog(Yks1.this,"Matamatik doğru sayısı 40'tan fazla olamaz.","Hata",JOptionPane.ERROR_MESSAGE);
            return;
        }       if (afenDogru > 40){
            JOptionPane.showMessageDialog(Yks1.this,"Matamatik doğru sayısı 40'tan fazla olamaz.","Hata",JOptionPane.ERROR_MESSAGE);
            return;
        }
        double matamatikPuan = (matamatikDogru * 1.3) - (matamatikYanlıs / 4.0);
        double fenPuan = (fenDogru * 1.4) - (fenYanlıs / 4.0);
        double turkcePuan = (turkceDogru * 1.3) - (turkceYanlıs / 4.0);
        double sosyalPuan = (sosyalDogru * 1.3) - (sosyalYanlıs / 4.0);

        double amatamatikPuan = (amatamatikDogru * 3) - (amatamatikYanlıs / 4.0);
        double afenPuan = (afenDogru * 3.3) - (afenYanlıs / 4.0);
        double aturkcePuan = (aturkceDogru * 3) - (aturkceYanlıs / 4.0);
        double asosyalPuan = (asosyalDogru * 2.8) - (asosyalYanlıs / 4.0);

        int a = 100;

        double yksPuan = matamatikPuan + fenPuan + turkcePuan + sosyalPuan + amatamatikPuan + afenPuan + aturkcePuan + asosyalPuan;
        sonucLabel.setText("Yks Puanınınz:"+ yksPuan + a);

    }

    public  static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                Yks1 gui = new Yks1();
                gui.setVisible(true);
            }
        });
    }

}