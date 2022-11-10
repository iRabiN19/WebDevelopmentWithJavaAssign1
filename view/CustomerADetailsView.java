package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;

import controller.CustomerAController;
import database.DBConnection;
import model.CustomerADetails;

public class CustomerADetailsView extends JFrame implements ActionListener {

    JLabel lbladdDetails, lblreligion, lblphone, lblincome, lbledu, lblocc,
            lblpan, lblseniorc, lblextacc, lblqlc, lblform, lblcitizen;
    JButton btnnext;
    JRadioButton rbtnSCyes, rbtnSCno, rbtnEAyes, rbtnEAno;
    JTextField txtpan, txtphone, txtcitizen;
    JComboBox<String> combReligion, combIncome, combEdu, combOcc;
    static int formno;
    static String mode;
    static String form;


    CustomerADetailsView(int formno2, String mode,String form) {

       

        CustomerADetailsView.formno = formno2;
        CustomerADetailsView.mode = mode;
        CustomerADetailsView.form = form;



        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        Color color = new Color(242, 202, 133);
        getContentPane().setBackground(color);

        setLayout(null);

        lbladdDetails = new JLabel("Page 2: Additonal Details");
        lbladdDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        lbladdDetails.setBounds(280, 30, 600, 40);

        lblreligion = new JLabel("Religion:");
        lblreligion.setFont(new Font("Raleway", Font.BOLD, 18));
        lblreligion.setBounds(100, 120, 100, 30);

        lblphone = new JLabel("Phone no:");
        lblphone.setFont(new Font("Raleway", Font.BOLD, 18));
        lblphone.setBounds(100, 170, 100, 30);
        txtphone = new JTextField();
        txtphone.setFont(new Font("Raleway", Font.BOLD, 14));
        txtphone.setBounds(350, 170, 320, 30);

        lblincome = new JLabel("Income:");
        lblincome.setFont(new Font("Raleway", Font.BOLD, 18));
        lblincome.setBounds(100, 220, 100, 30);

        lbledu = new JLabel("Educational");
        lbledu.setFont(new Font("Raleway", Font.BOLD, 18));
        lbledu.setBounds(100, 270, 150, 30);

        lblqlc = new JLabel("Qualification:");
        lblqlc.setFont(new Font("Raleway", Font.BOLD, 18));
        lblqlc.setBounds(100, 290, 150, 30);

        lblocc = new JLabel("Occupation:");
        lblocc.setFont(new Font("Raleway", Font.BOLD, 18));
        lblocc.setBounds(100, 340, 150, 30);

        lblpan = new JLabel("PAN Number:");
        lblpan.setFont(new Font("Raleway", Font.BOLD, 18));
        lblpan.setBounds(100, 390, 150, 30);
        txtpan = new JTextField();
        txtpan.setFont(new Font("Raleway", Font.BOLD, 14));
        txtpan.setBounds(350, 390, 320, 30);

        lblcitizen = new JLabel("Citizenship:");
        lblcitizen.setFont(new Font("Raleway", Font.BOLD, 18));
        lblcitizen.setBounds(100, 440, 150, 30);
        txtcitizen = new JTextField();
        txtcitizen.setFont(new Font("Raleway", Font.BOLD, 14));
        txtcitizen.setBounds(350, 440, 320, 30);

        lblseniorc = new JLabel("Senior Citizen:");
        lblseniorc.setFont(new Font("Raleway", Font.BOLD, 18));
        lblseniorc.setBounds(100, 490, 150, 30);

        lblextacc = new JLabel("Existing Account:");
        lblextacc.setFont(new Font("Raleway", Font.BOLD, 18));
        lblextacc.setBounds(100, 540, 180, 30);

        lblform = new JLabel("Form No:" + formno2);
        lblform.setFont(new Font("Raleway", Font.BOLD, 13));
        lblform.setBounds(700, 10, 120, 30);

        btnnext = new JButton("Next");
        btnnext.setFont(new Font("Monospaced", Font.BOLD, 20));
        btnnext.setBackground(Color.BLACK);
        btnnext.setForeground(Color.CYAN);
        btnnext.setBounds(570, 640, 100, 30);

        rbtnSCyes = new JRadioButton("Yes");
        rbtnSCyes.setFont(new Font("Raleway", Font.BOLD, 14));
        rbtnSCyes.setBackground(color);
        rbtnSCyes.setBounds(350, 490, 100, 30);

        rbtnSCno = new JRadioButton("No");
        rbtnSCno.setFont(new Font("Raleway", Font.BOLD, 14));
        rbtnSCno.setBackground(color);
        rbtnSCno.setBounds(460, 490, 100, 30);

        rbtnEAyes = new JRadioButton("Yes");
        rbtnEAyes.setFont(new Font("Raleway", Font.BOLD, 14));
        rbtnEAyes.setBackground(color);
        rbtnEAyes.setBounds(350, 540, 100, 30);

        rbtnEAno = new JRadioButton("No");
        rbtnEAno.setFont(new Font("Raleway", Font.BOLD, 14));
        rbtnEAno.setBackground(color);
        rbtnEAno.setBounds(460, 540, 100, 30);

        String religion[] = { "Hindu", "Muslim", "Buddhism", "Christian", "Other" };
        combReligion = new JComboBox<>(religion);
        combReligion.setBackground(Color.WHITE);
        combReligion.setFont(new Font("Raleway", Font.BOLD, 14));
        combReligion.setBounds(350, 120, 320, 30);

        String income[] = { "Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000" };
        combIncome = new JComboBox<>(income);
        combIncome.setBackground(Color.WHITE);
        combIncome.setFont(new Font("Raleway", Font.BOLD, 14));
        combIncome.setBounds(350, 220, 320, 30);

        String education[] = { "Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others" };
        combEdu = new JComboBox<>(education);
        combEdu.setBackground(Color.WHITE);
        combEdu.setFont(new Font("Raleway", Font.BOLD, 14));
        combEdu.setBounds(350, 270, 320, 30);

        String occupation[] = { "Salaried", "Self-Employmed", "Business", "Student", "Retired", "Others" };
        combOcc = new JComboBox<>(occupation);
        combOcc.setBackground(Color.WHITE);
        combOcc.setFont(new Font("Raleway", Font.BOLD, 14));
        combOcc.setBounds(350, 340, 320, 30);

        if(mode.equals("update")){
            try{
                DBConnection db = new DBConnection();
                String query="select * from customerAdetails where formno = '" + form + "';";
                ResultSet rs;
            rs = db.select(query);

                while(rs.next()){
                    combReligion.setSelectedItem(rs.getString("religion"));
                    txtphone.setText(rs.getString("phone"));
                    combIncome.setSelectedItem(rs.getString("income"));
                    combEdu.setSelectedItem(rs.getString("qualification"));
                    combOcc.setSelectedItem(rs.getString("occupation"));
                    if(!rs.getString("pan").equals(null)){
                        txtpan.setText(rs.getString("pan"));
                    }
                    txtcitizen.setText(rs.getString("citizenship"));

                    if(rs.getString("seniorc").equals("Yes")){
                        rbtnSCyes.setSelected(true);
                    } else if(rs.getString("seniorc").equals("No")){
                        rbtnSCno.setSelected(true);
                    }

                    if(rs.getString("existing").equals("Yes")){
                        rbtnEAyes.setSelected(true);
                    } else if(rs.getString("existing").equals("No")){
                        rbtnEAno.setSelected(true);
                    }


                }
             
            }catch(Exception e){
                System.out.println(e);
            }
        }

        add(lblform);
        add(lbladdDetails);
        add(lblreligion);
        add(combReligion);
        add(lblphone);
        add(txtphone);
        add(lblincome);
        add(combIncome);
        add(lbledu);
        add(combEdu);
        add(lblqlc);
        add(lblocc);
        add(combOcc);
        add(lblpan);
        add(txtpan);
        add(lblcitizen);
        add(txtcitizen);
        add(lblseniorc);
        add(rbtnSCyes);
        add(rbtnSCno);
        add(lblextacc);
        add(rbtnEAyes);
        add(rbtnEAno);
        add(btnnext);

        btnnext.addActionListener(this);

        setSize(850, 750);
        setLocation(500, 120);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CustomerADetailsView(formno,mode,form);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String religion = (String) combReligion.getSelectedItem();
        String phone = txtphone.getText();
        String income = (String) combIncome.getSelectedItem();
        String qualification = (String) combEdu.getSelectedItem();
        String occupation = (String) combOcc.getSelectedItem();

        String pan = txtpan.getText();
        String citizenship = txtcitizen.getText();
        String seniorc = "";
        if (rbtnSCyes.isSelected()) {
            seniorc = "Yes";
        } else if (rbtnSCno.isSelected()) {
            seniorc = "No";
        }

        String existing = "";
        if (rbtnEAyes.isSelected()) {
            existing = "Yes";
        } else if (rbtnEAno.isSelected()) {
            existing = "No";
        }

        try {
            if (txtcitizen.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else {
                CustomerADetails signUp2 = new CustomerADetails(formno, religion, phone, income, qualification, occupation, pan,
                        citizenship,seniorc, existing);

                CustomerAController sign2cont = new CustomerAController();
                int insert = sign2cont.registerCustomer(signUp2);

                if (insert > 0) {
                    System.out.println("Customer added successfully");

                    new AccountDetailsView(formno);
                    this.dispose();
                } else {
                    System.out.println("Error registering customer");
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
