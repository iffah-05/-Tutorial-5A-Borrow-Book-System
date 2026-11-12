import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BorrowBookInfo extends JFrame {
    private JComboBox cbStudents;
    private JComboBox cbBooks;
    private JButton btnBorrow;
    private JLabel lblInfo;

    public BorrowBookInfo(final ArrayList<Student> studentList, final ArrayList<Book> bookList) {
        setTitle("Borrow Book");
        setSize(460, 260);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));

        JPanel panelSelect = new JPanel(new GridLayout(2, 2, 10, 10));
        panelSelect.add(new JLabel("Student Name & Matric:"));

        cbStudents = new JComboBox(studentList.toArray());
        panelSelect.add(cbStudents);

        panelSelect.add(new JLabel("Book Title & Author:"));
        cbBooks = new JComboBox(bookList.toArray());
        panelSelect.add(cbBooks);

        btnBorrow = new JButton("Borrow");

        JPanel panelInfo = new JPanel(new BorderLayout());
        panelInfo.add(new JLabel("Borrow Information :"), BorderLayout.NORTH);
        lblInfo = new JLabel("");
        panelInfo.add(lblInfo, BorderLayout.CENTER);

        add(panelSelect);
        add(btnBorrow);
        add(panelInfo);

        if (studentList.isEmpty() || bookList.isEmpty()) {
            lblInfo.setText("Sila tambah maklumat Pelajar & Buku di menu utama dahulu!");
        }

        btnBorrow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student selectedStudent = (Student) cbStudents.getSelectedItem();
                Book selectedBook = (Book) cbBooks.getSelectedItem();

                if (selectedStudent != null && selectedBook != null) {
                    selectedBook.borrowBy(selectedStudent);
                    String result = selectedStudent.getName() + " with matric number " +
                                   selectedStudent.getMatric() + " has borrow a book with title " +
                                   selectedBook.getTitle() + ".";
                    lblInfo.setText(result);
                } else {
                    lblInfo.setText("Sila pastikan Pelajar dan Buku telah dipilih!");
                }
            }
        });
    }
}