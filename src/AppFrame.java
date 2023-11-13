import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AppFrame extends JFrame{

    private TitleBar title;
    private Footer footer;
    private List list;

    private JButton newTask;
    private JButton clear;

    AppFrame()
    {
        this.setSize(400,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        title = new TitleBar();
        footer = new Footer();
        list = new List();



        this.add(title,BorderLayout.NORTH);
        this.add(footer,BorderLayout.SOUTH);
        this.add(list,BorderLayout.CENTER);

        newTask = footer.getNewTask();
        clear = footer.getClear();

        this.setVisible(true);
        addListeners();
    }


    public void addListeners()
    {
        newTask.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                Task task = new Task();
                list.add(task);
                list.updateNumbers();


                task.getDone().addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mousePressed(MouseEvent e)
                    {

                        task.changeState();
                        list.updateNumbers();
                        revalidate();

                    }
                });
            }

        });

        clear.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                list.removeCompletedTasks();
                repaint();
            }
        });
    }

}