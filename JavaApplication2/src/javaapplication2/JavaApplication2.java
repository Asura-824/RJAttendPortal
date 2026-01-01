package javaapplication2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.*;
import java.awt.*; 
import javax.swing.*;
import java.sql.Date;
import java.sql.Time;

class JavaApplication2 implements ActionListener , ItemListener {
    String url = "your_localhost_driver_database_url";
    String user = "your_username";
    String password = "your_password";
    public JFrame f1;
    String s="";
    JLabel l1;      
    JButton b1,b2;
    JComboBox jcb;

    JavaApplication2() {
        f1 = new JFrame("RJ College Attendance");
        l1 = new JLabel("Welcome to RJ College Attendance Portal");
        b1 = new JButton("Next");
        b1.addActionListener(this);

        Container cp1 = f1.getContentPane();
        cp1.setLayout(new FlowLayout());

        cp1.add(l1);
        cp1.add(b1);

        f1.setSize(400, 220);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
    }
    public void itemStateChanged(ItemEvent ie){
        s=(String) ie.getItem();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            f1.dispose();
            JFrame f2 = new JFrame("RJ College login");
            JLabel l2 = new JLabel("Login to RJ College Attendance Portal");
            JLabel l3 = new JLabel("Username");
            JLabel l4 = new JLabel("Password");
            JTextField t1 = new JTextField(28);
            JPasswordField p = new JPasswordField(20);

            JButton b2 = new JButton("Login");
            b2.addActionListener(this);

            Container cp2 = f2.getContentPane();
            cp2.setLayout(null);
            
            l2.setBounds(50, 20, 300, 25);
            l3.setBounds(50, 60, 100, 25);
            t1.setBounds(150, 60, 150, 25);
            l4.setBounds(50, 100, 100, 25);
            p.setBounds(150, 100, 150, 25);
            b2.setBounds(150, 140, 100, 30);
            
            cp2.add(l2);
            cp2.add(l3);
            cp2.add(t1);
            cp2.add(l4);
            cp2.add(p);
            cp2.add(b2);

            f2.setSize(400, 220);
            f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f2.setVisible(true);
            
                b2.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e4){
                            String s1 = String.valueOf(p.getPassword());
                            if(t1.getText().equals("rjcollege") && s1.equals("rjc123")){
                            f2.dispose();
                            JFrame f3 = new JFrame("Select Designation");
                            JLabel l5 = new JLabel("Please select Your Designation");
                            jcb =new JComboBox();
                            jcb.addItem("Select your designation");     
                            jcb.addItem("Teacher");
                            jcb.addItem("Student");
                            jcb.addItem("Other");
                            jcb.addItemListener(JavaApplication2.this);

                            JButton b3 = new JButton("Continue");

                            Container cp3 = f3.getContentPane();
                            cp3.setLayout(new FlowLayout());
                            
                            cp3.add(l5);
                            cp3.add(jcb);
                            cp3.add(b3);

                            f3.setSize(400, 220);
                            f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            f3.setVisible(true); 
                            
                            b3.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e2) {
                                    f3.dispose();

                                    JFrame f4 = new JFrame("Fill the Details");

                                    JLabel l6 = new JLabel("Enter Unique ID");
                                    JLabel l7 = new JLabel("Enter Name");
                                    JLabel l8 = new JLabel("Enter Middle name");
                                    JLabel l9 = new JLabel("Enter Surname");

                                    JTextField t2 = new JTextField("Unique ID");
                                    JTextField t3 = new JTextField("Name");
                                    JTextField t4 = new JTextField("Middle name");
                                    JTextField t5 = new JTextField("Surname");

                                    // Add placeholder behavior
                                    addPlaceholder(t2, "Unique ID");
                                    addPlaceholder(t3, "Name");
                                    addPlaceholder(t4, "Middle name");
                                    addPlaceholder(t5, "Surname");

                                    JButton b4 = new JButton("Submit");

                                    Container cp4 = f4.getContentPane();
                                    cp4.setLayout(null);

                                    // Positioning labels and textfields
                                    l6.setBounds(30, 30, 120, 25);  t2.setBounds(160, 30, 150, 25);
                                    l7.setBounds(30, 60, 120, 25);  t3.setBounds(160, 60, 150, 25);
                                    l8.setBounds(30, 90, 120, 25);  t4.setBounds(160, 90, 150, 25);
                                    l9.setBounds(30, 120, 120, 25); t5.setBounds(160, 120, 150, 25);

                                    b4.setBounds(130, 220, 100, 30);

                                    cp4.add(l6); cp4.add(t2);
                                    cp4.add(l7); cp4.add(t3);
                                    cp4.add(l8); cp4.add(t4);
                                    cp4.add(l9); cp4.add(t5);
                                    cp4.add(b4);

                                    f4.setSize(400, 300);
                                    f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    f4.setVisible(true);

                                    b4.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e3) {
                                            JOptionPane.showMessageDialog(f3,
                                                "Form submitted!\n" +
                                                "ID: " + t2.getText() + "\n" +
                                                "Name: " + t3.getText() + " " + t4.getText() + " " + t5.getText() + "\n" +
                                                "Designation: " + s
                                            );

                                            int unique_id=Integer.parseInt(t2.getText());
                                            String first_name=t3.getText();
                                            String middle_name=t4.getText();
                                            String surname=t5.getText();

                                            String insertquery= "insert into rjclg(unique_no,first_name,middle_name,surname,designation) values (?,?,?,?,?)";
                                            String selectquery= "Select * from rjclg";  
                                            try (Connection conn = DriverManager.getConnection(url, user, password)){
                                                PreparedStatement insertpstmt = conn.prepareStatement(insertquery);
                                                insertpstmt.setInt(1, unique_id);        // bind unique_id
                                                insertpstmt.setString(2, first_name);    // bind first_name
                                                insertpstmt.setString(3, middle_name);   // bind middle_name
                                                insertpstmt.setString(4, surname);
                                                insertpstmt.setString(5, s);
                                                int rowsInserted = insertpstmt.executeUpdate();
                                                System.out.println(rowsInserted + " row(s) inserted.");

                                                PreparedStatement selectpstmt = conn.prepareStatement(selectquery);
                                                ResultSet rs = selectpstmt.executeQuery();
                                                while (rs.next()) {
                                                    int id = rs.getInt("sr_no");
                                                    int uid = rs.getInt("unique_no");
                                                    String fname = rs.getString("first_name");
                                                    String mname = rs.getString("middle_name");
                                                    String lname = rs.getString("surname");
                                                    String s = rs.getString("designation");
                                                    Date date = rs.getDate("punch_date");
                                                    Time time = rs.getTime("punch_time");
                                                    System.out.println("Serial no: " + id + " Unique id: " + uid + " Name: " + fname + " " + mname + " " + lname + " Designation: " + s + " Date: " + date + " Time: " + time);
                                                }

                                            } catch (SQLException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    });
                                };
                            });
                        } else{
                            JOptionPane.showMessageDialog(f2,"Invalid credentials!!!");
                        }
                    }
            });
        }
    }

    // Helper method to add placeholder behavior
    private void addPlaceholder(JTextField field, String placeholder) {
        field.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                }
            }
        });
    }

    public static void main(String[] args) {
        new JavaApplication2();
    }
}