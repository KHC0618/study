package timeReward;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Controller extends JFrame {
    private HashMap<String, String> sessions = new HashMap<>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private JTextField userIdField;
    private View sessionView;
    private Timer timer;

    public Controller() {
        setTitle("사용자 접속 시간 체크");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel userIdLabel = new JLabel("사용자 ID:");
        userIdField = new JTextField(10);
        JButton startButton = new JButton("접속 시작");

        panel.add(userIdLabel);
        panel.add(userIdField);
        panel.add(startButton);

        add(panel, BorderLayout.CENTER);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = userIdField.getText();
                String currentTime = dateFormat.format(new Date());
                sessions.put(userId, currentTime);

                // 새로운 View 생성 및 시작
                sessionView = new View(userId, currentTime);
                sessionView.setVisible(true);

                // 타이머 시작
                startTimer();
            }
        });
    }

    private void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = userIdField.getText();
                String startTime = sessions.get(userId);
                if (startTime != null) {
                    long elapsedTime = System.currentTimeMillis() - getTimeInMillis(startTime);
                    String formattedElapsedTime = formatElapsedTime(elapsedTime);
                    sessionView.updateElapsedTime(formattedElapsedTime);
                }
            }
        });
        timer.start();
    }

    private long getTimeInMillis(String timeString) {
        try {
            Date date = dateFormat.parse(timeString);
            return date.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private String formatElapsedTime(long elapsedTime) {
        long seconds = elapsedTime / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        return String.format("%02d:%02d:%02d", hours, minutes % 60, seconds % 60);
    }

    public void start() {
        setVisible(true);
    }
}


