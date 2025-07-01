import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    public JButton addTask, deleteTask;
    public JTextField tf;
    public DefaultListModel<String> tasklist;
    public JList<String> tl;

    Main() {
        setLayout(null);
        setBounds(150,150,600,600);
        setTitle("TO-DO list Application");
        setLayout(new BorderLayout());

        //ui component
        tf = new JTextField(20);
        addTask = new JButton("Add task");
        addTask.addActionListener(this);
        deleteTask = new JButton("Delete task");
        deleteTask.addActionListener(this);

        tasklist = new DefaultListModel<>();
        tl = new JList<>(tasklist);
        JScrollPane sp = new JScrollPane(tl);

        //panel
        JPanel jp = new JPanel();
        jp.add(tf);
        jp.add(addTask);
        jp.add(deleteTask);

        // add component on frame
        add(jp,BorderLayout.NORTH);
        add(sp,BorderLayout.CENTER);


        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Main();

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addTask) {
            String task = tf.getText().trim();
            if (!task.isEmpty()) {
                tasklist.addElement(task);
                tf.setText("");
            }else {
                JOptionPane.showMessageDialog(null,"Please enter a task.");
            }
        } else if (e.getSource() == deleteTask) {
            int selectindex = tl.getSelectedIndex();
            if (selectindex != -1) {
                tasklist.remove(selectindex);
            }else {
                JOptionPane.showMessageDialog(null,"Pleas select task to delete");
            }
        }
    }
}