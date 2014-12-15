import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;

/**
 * Created by koencertyn on 11/12/14.
 */
public class Gui extends JFrame{

    public static final int EXIT_BUTTONS_X = 200;
    public static final int EXIT_BUTTONS_Y = 330;
    public static final int EXIT_BUTTONS_SIZE_X = 80;
    public static final int EXIT_BUTTONS_SIZE_Y = 40;

    public static final int GLOBAL_STATUS_X = 5;
    public static final int GLOBAL_STATUS_Y = 5;

    public static final int GLOBAL_STATUS_SIZE_X = 200;
    public static final int GLOBAL_STATUS_SIZE_Y = 40;

    public static final int GLOBAL_COLOR_SIZE_X = 100;
    public static final int GLOBAL_COLOR_SIZE_Y = 40;

    public JLabel CounterStatusValue, alarmStatusColor, IRStatusColor, ButtonStatusColor;


    public Gui(){
        initGui();
    }

    public void initGui(){
        setTitle("Alarm Status");
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        Container pane = getContentPane();
        GroupLayout layout = new GroupLayout(pane);
        pane.setLayout(layout);

        JButton quitButton = new JButton("Quit");
        quitButton.setLayout(null);
        quitButton.setLocation(EXIT_BUTTONS_X, EXIT_BUTTONS_Y);
        quitButton.setSize(EXIT_BUTTONS_SIZE_X, EXIT_BUTTONS_SIZE_Y);
        quitButton.setHorizontalAlignment(0);
        quitButton.setForeground(Color.black);
        add(quitButton);

        JButton resetButton = new JButton("Reset");
        resetButton.setLayout(null);
        resetButton.setLocation(EXIT_BUTTONS_X + EXIT_BUTTONS_SIZE_X + 20 , EXIT_BUTTONS_Y);
        resetButton.setSize(EXIT_BUTTONS_SIZE_X, EXIT_BUTTONS_SIZE_Y);
        resetButton.setHorizontalAlignment(0);
        resetButton.setForeground(Color.black);
        add(resetButton);

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });


        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        JLabel alarmStatusText = new JLabel("The current alarm status :");
        alarmStatusText.setLayout(null);
        alarmStatusText.setLocation(GLOBAL_STATUS_X, GLOBAL_STATUS_Y);
        alarmStatusText.setSize(GLOBAL_STATUS_SIZE_X, GLOBAL_STATUS_SIZE_Y);
        alarmStatusText.setHorizontalAlignment(0);
        alarmStatusText.setForeground(Color.black);
        add(alarmStatusText);

        alarmStatusColor = new JLabel("OK");
        alarmStatusColor.setOpaque(true);
        alarmStatusColor.setLocation(GLOBAL_STATUS_X + GLOBAL_STATUS_SIZE_X + 20, GLOBAL_STATUS_Y);
        alarmStatusColor.setSize(GLOBAL_COLOR_SIZE_X, GLOBAL_COLOR_SIZE_Y);
        alarmStatusColor.setHorizontalAlignment(0);
        alarmStatusColor.setBackground(Color.green);
        add(alarmStatusColor);

        JLabel IRStatusText = new JLabel("Movement in room :");
        IRStatusText.setLayout(null);
        IRStatusText.setLocation(GLOBAL_STATUS_X, GLOBAL_STATUS_Y + GLOBAL_STATUS_SIZE_Y + 20);
        IRStatusText.setSize(GLOBAL_STATUS_SIZE_X, GLOBAL_STATUS_SIZE_Y);
        IRStatusText.setHorizontalAlignment(0);
        IRStatusText.setForeground(Color.black);
        add(IRStatusText);

        IRStatusColor = new JLabel("None");
        IRStatusColor.setOpaque(true);
        IRStatusColor.setLocation(GLOBAL_STATUS_X + GLOBAL_STATUS_SIZE_X + 20, GLOBAL_STATUS_Y + GLOBAL_STATUS_SIZE_Y + 20);
        IRStatusColor.setSize(GLOBAL_COLOR_SIZE_X, GLOBAL_COLOR_SIZE_Y);
        IRStatusColor.setHorizontalAlignment(0);
        IRStatusColor.setBackground(Color.green);
        add(IRStatusColor);

        JLabel ButtonStatusText = new JLabel("Button pressed :");
        ButtonStatusText.setLayout(null);
        ButtonStatusText.setLocation(GLOBAL_STATUS_X, GLOBAL_STATUS_Y + 2*(GLOBAL_STATUS_SIZE_Y + 20));
        ButtonStatusText.setSize(GLOBAL_STATUS_SIZE_X, GLOBAL_STATUS_SIZE_Y);
        ButtonStatusText.setHorizontalAlignment(0);
        ButtonStatusText.setForeground(Color.black);
        add(ButtonStatusText);

        ButtonStatusColor = new JLabel();
        ButtonStatusColor.setOpaque(true);
        ButtonStatusColor.setLocation(GLOBAL_STATUS_X + GLOBAL_STATUS_SIZE_X + 20, GLOBAL_STATUS_Y + 2* (GLOBAL_STATUS_SIZE_Y + 20));
        ButtonStatusColor.setSize(GLOBAL_COLOR_SIZE_X, GLOBAL_COLOR_SIZE_Y);
        ButtonStatusColor.setHorizontalAlignment(0);
        ButtonStatusColor.setBackground(Color.red);
        add(ButtonStatusColor);

        JLabel CounterStatusText = new JLabel("Counter :");
        CounterStatusText.setLayout(null);
        CounterStatusText.setLocation(GLOBAL_STATUS_X, GLOBAL_STATUS_Y + 3*(GLOBAL_STATUS_SIZE_Y + 20));
        CounterStatusText.setSize(GLOBAL_STATUS_SIZE_X, GLOBAL_STATUS_SIZE_Y);
        CounterStatusText.setHorizontalAlignment(0);
        CounterStatusText.setForeground(Color.black);
        add(CounterStatusText);

        CounterStatusValue = new JLabel("60");
        CounterStatusValue.setFont(new Font("Serif", Font.PLAIN, 40));
        CounterStatusValue.setOpaque(true);
        CounterStatusValue.setLocation(GLOBAL_STATUS_X + GLOBAL_STATUS_SIZE_X + 20, GLOBAL_STATUS_Y + 3* (GLOBAL_STATUS_SIZE_Y + 20));
        CounterStatusValue.setSize(GLOBAL_COLOR_SIZE_X, GLOBAL_COLOR_SIZE_Y);
        CounterStatusValue.setHorizontalAlignment(0);
        add(CounterStatusValue);

    }

    public void startTimer(){
        int i = 60;
        while(i > 0){
            CounterStatusValue.setText(String.valueOf(i-1));
            i = i - 1;
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void resetTimer(){
        CounterStatusValue.setText(String.valueOf(60));
    }

    public void activateAlarm(){
        alarmStatusColor.setBackground(Color.RED);
        alarmStatusColor.setText("Activated");
    }

    public void disableAlarm(){
        alarmStatusColor.setBackground(Color.GREEN);
        alarmStatusColor.setText("Disabled");
    }

    public void activateMovement(){
        IRStatusColor.setBackground(Color.RED);
        IRStatusColor.setText("Activated");
    }

    public void disableMovement(){
        IRStatusColor.setBackground(Color.GREEN);
        IRStatusColor.setText("No movement");
    }

    public void activateButton(){
        ButtonStatusColor.setBackground(Color.GREEN);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ButtonStatusColor.setBackground(Color.RED);
    }
}

