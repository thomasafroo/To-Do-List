import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Footer extends JPanel{

    JButton addTask;
    JButton clear;


    Border emptyBorder = BorderFactory.createEmptyBorder();

    Footer()
    {
        this.setPreferredSize(new Dimension(400,60));

        addTask = new JButton("Add Task");
        addTask.setBorder(emptyBorder);
        addTask.setFont(new Font("Sans-serif",Font.PLAIN, 20));
        addTask.setVerticalAlignment(JButton.BOTTOM);
        //addTask.setBackground(Color.white);
        this.add(addTask);


        this.add(Box.createHorizontalStrut(20));//Space between buttons
        clear = new JButton("Clear finished tasks");
        clear.setFont(new Font("Sans-serif",Font.PLAIN, 20));
        clear.setBorder(emptyBorder);
        //clear.setBackground();
        clear.setBackground(Color.cyan);

        this.add(clear);


    }

    public JButton getNewTask(){
        return addTask;
    }

    public JButton getClear() {
        return clear;
    }
}