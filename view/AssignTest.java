package view;

// import java.awt.Event;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class AssignTest extends JFrame {
    JLabel lbladdDetails, lblreligion, lblincome, lbledu, lblocc,
            lblpan, lblseniorc, lblextacc, l11, lblform, lblformno;
    JButton btnnext;
    JRadioButton rbtnSCyes, rbtnSCno, rbtnEAyes, rbtnEAno;
    JTextField txtpan, t3;
    JComboBox c1, c3, c4, c5;
    String formno;

    AssignTest() {

        // ImageIcon i1 = new
        // ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
        // Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        // ImageIcon i3 = new ImageIcon(i2);
        // JLabel l14 = new JLabel(i3);
        // l14.setBounds(150, 0, 100, 100);
        // add(l14);

        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        lbladdDetails = new JLabel("Page 2: Additonal Details");
        lbladdDetails.setFont(new Font("Raleway", Font.BOLD, 22));

        lblreligion = new JLabel("Religion:");
        lblreligion.setFont(new Font("Raleway", Font.BOLD, 18));

        lblincome = new JLabel("Income:");
        lblincome.setFont(new Font("Raleway", Font.BOLD, 18));

        lbledu = new JLabel("Educational");
        lbledu.setFont(new Font("Raleway", Font.BOLD, 18));

        l11 = new JLabel("Qualification:");
        l11.setFont(new Font("Raleway", Font.BOLD, 18));

        lblocc = new JLabel("Occupation:");
        lblocc.setFont(new Font("Raleway", Font.BOLD, 18));

        lblpan = new JLabel("PAN Number:");
        lblpan.setFont(new Font("Raleway", Font.BOLD, 18));

        lblseniorc = new JLabel("Senior Citizen:");
        lblseniorc.setFont(new Font("Raleway", Font.BOLD, 18));

        lblextacc = new JLabel("Existing Account:");
        lblextacc.setFont(new Font("Raleway", Font.BOLD, 18));

        lblform = new JLabel("Form No:");
        lblform.setFont(new Font("Raleway", Font.BOLD, 13));

        lblformno = new JLabel(formno);
        lblformno.setFont(new Font("Raleway", Font.BOLD, 13));

        btnnext = new JButton("Next");
        btnnext.setFont(new Font("Raleway", Font.BOLD, 14));
        btnnext.setBackground(Color.BLACK);
        btnnext.setForeground(Color.WHITE);

        txtpan = new JTextField();
        txtpan.setFont(new Font("Raleway", Font.BOLD, 14));

        rbtnSCyes = new JRadioButton("Yes");
        rbtnSCyes.setFont(new Font("Raleway", Font.BOLD, 14));
        rbtnSCyes.setBackground(Color.WHITE);

        rbtnSCno = new JRadioButton("No");
        rbtnSCno.setFont(new Font("Raleway", Font.BOLD, 14));
        rbtnSCno.setBackground(Color.WHITE);

        rbtnEAyes = new JRadioButton("Yes");
        rbtnEAyes.setFont(new Font("Raleway", Font.BOLD, 14));
        rbtnEAyes.setBackground(Color.WHITE);

        rbtnEAno = new JRadioButton("No");
        rbtnEAno.setFont(new Font("Raleway", Font.BOLD, 14));
        rbtnEAno.setBackground(Color.WHITE);

        String religion[] = { "Hindu", "Muslim", "Buddhism", "Christian", "Other" };
        c1 = new JComboBox(religion);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 14));

        String income[] = { "Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000" };
        c3 = new JComboBox(income);
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 14));

        String education[] = { "Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others" };
        c4 = new JComboBox(education);
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 14));

        String occupation[] = { "Salaried", "Self-Employmed", "Business", "Student", "Retired", "Others" };
        c5 = new JComboBox(occupation);
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 14));

        setLayout(null);

        lblform.setBounds(700, 10, 60, 30);
        add(lblform);

        lblformno.setBounds(760, 10, 60, 30);
        add(lblformno);

        lbladdDetails.setBounds(280, 30, 600, 40);
        add(lbladdDetails);

        lblreligion.setBounds(100, 120, 100, 30);
        add(lblreligion);

        c1.setBounds(350, 120, 320, 30);
        add(c1);

        lblincome.setBounds(100, 220, 100, 30);
        add(lblincome);

        c3.setBounds(350, 220, 320, 30);
        add(c3);

        lbledu.setBounds(100, 270, 150, 30);
        add(lbledu);

        c4.setBounds(350, 270, 320, 30);
        add(c4);

        l11.setBounds(100, 290, 150, 30);
        add(l11);

        lblocc.setBounds(100, 340, 150, 30);
        add(lblocc);

        c5.setBounds(350, 340, 320, 30);
        add(c5);

        lblpan.setBounds(100, 390, 150, 30);
        add(lblpan);

        txtpan.setBounds(350, 390, 320, 30);
        add(txtpan);

        lblseniorc.setBounds(100, 490, 150, 30);
        add(lblseniorc);

        rbtnSCyes.setBounds(350, 490, 100, 30);
        add(rbtnSCyes);

        rbtnSCno.setBounds(460, 490, 100, 30);
        add(rbtnSCno);

        lblextacc.setBounds(100, 540, 180, 30);
        add(lblextacc);

        rbtnEAyes.setBounds(350, 540, 100, 30);
        add(rbtnEAyes);

        rbtnEAno.setBounds(460, 540, 100, 30);
        add(rbtnEAno);

        btnnext.setBounds(570, 640, 100, 30);
        add(btnnext);

        // btnnext.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 750);
        setLocation(500, 120);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AssignTest();
    }
}
