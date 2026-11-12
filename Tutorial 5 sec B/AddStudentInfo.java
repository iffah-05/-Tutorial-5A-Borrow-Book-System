import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AddStudentInfo extends JFrame {
    private JTextField txtName, txtMatric;
    private JButton btnAdd, btnList;
    private JTextArea txtAreaStudents;
    private ArrayList<Student> studentList;

    public AddStudentInfo(final ArrayList<Student> studentList) {
        this.studentList = studentList;

        setTitle("Add Student Info");
        setSize(420, 320);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JPanel panelInput = new JPanel(new GridLayout(2, 2, 5, 5));
        panelInput.add(new JLabel("Name:"));
        txtName = new JTextField(20);
        panelInput.add(txtName);

        panelInput.add(new JLabel("Matric:"));
        txtMatric = new JTextField(20);
        panelInput.add(txtMatric);

        JPanel panelBtn = new JPanel(new FlowLayout());
        btnAdd = new JButton("Add");
        btnList = new JButton("List");
        panelBtn.add(btnAdd);
        panelBtn.add(btnList);

        txtAreaStudents = new JTextArea(7, 32);
        txtAreaStudents.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtAreaStudents);

        JPanel panelArea = new JPanel(new BorderLayout());
        panelArea.add(new JLabel("Students:"), BorderLayout.NORTH);
        panelArea.add(scrollPane, BorderLayout.CENTER);

        add(panelInput);
        add(panelBtn);
        add(panelArea);

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText().trim();
                String matric = txtMatric.getText().trim();
                if (!name.isEmpty() && !matric.isEmpty()) {
                    Student s = new Student(name, matric);
                    AddStudentInfo.this.studentList.add(s);
                    txtName.setText("");
                    txtMatric.setText("");
                    JOptionPane.showMessageDialog(null, "Student added successfully!");
                }
            }
        });

        btnList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtAreaStudents.setText("");
                for (int i = 0; i < AddStudentInfo.this.studentList.size(); i++) {
                    Student s = (Student) AddStudentInfo.this.studentList.get(i);
                    txtAreaStudents.append("Name : " + s.getName() + " (" + s.getMatric() + ")\n");
                }
            }
        });
    }
}