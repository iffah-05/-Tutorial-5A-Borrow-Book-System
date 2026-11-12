import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AddBookInfo extends JFrame {
    private JTextField txtTitle, txtAuthor;
    private JButton btnAdd, btnList;
    private JTextArea txtAreaBooks;
    private ArrayList<Book> bookList;

    public AddBookInfo(final ArrayList<Book> bookList) {
        this.bookList = bookList;

        setTitle("Add Book Info");
        setSize(420, 320);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JPanel panelInput = new JPanel(new GridLayout(2, 2, 5, 5));
        panelInput.add(new JLabel("Book Title:"));
        txtTitle = new JTextField(20);
        panelInput.add(txtTitle);

        panelInput.add(new JLabel("Author:"));
        txtAuthor = new JTextField(20);
        panelInput.add(txtAuthor);

        JPanel panelBtn = new JPanel(new FlowLayout());
        btnAdd = new JButton("Add");
        btnList = new JButton("List");
        panelBtn.add(btnAdd);
        panelBtn.add(btnList);

        txtAreaBooks = new JTextArea(7, 32);
        txtAreaBooks.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtAreaBooks);

        JPanel panelArea = new JPanel(new BorderLayout());
        panelArea.add(new JLabel("Books:"), BorderLayout.NORTH);
        panelArea.add(scrollPane, BorderLayout.CENTER);

        add(panelInput);
        add(panelBtn);
        add(panelArea);

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = txtTitle.getText().trim();
                String author = txtAuthor.getText().trim();
                if (!title.isEmpty() && !author.isEmpty()) {
                    Book b = new Book(title, author);
                    AddBookInfo.this.bookList.add(b);
                    txtTitle.setText("");
                    txtAuthor.setText("");
                    JOptionPane.showMessageDialog(null, "Book added successfully!");
                }
            }
        });

        btnList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtAreaBooks.setText("");
                for (int i = 0; i < AddBookInfo.this.bookList.size(); i++) {
                    Book b = (Book) AddBookInfo.this.bookList.get(i);
                    txtAreaBooks.append("Book title : " + b.getTitle() + " (Author : " + b.getAuthor() + ")\n");
                }
            }
        });
    }
}