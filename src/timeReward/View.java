package timeReward;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    private JLabel userIdLabel;
    private JLabel startTimeLabel;
    private JLabel elapsedTimeLabel;

    public View() {

    }

    public View(String userId, String startTime) {
        setTitle("사용자 접속 확인");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(3, 1));

        userIdLabel = new JLabel("사용자 ID: " + userId);
        startTimeLabel = new JLabel("접속 시작 시간: " + startTime);
        elapsedTimeLabel = new JLabel("경과 시간: ");

        add(userIdLabel);
        add(startTimeLabel);
        add(elapsedTimeLabel);
    }

    public void updateElapsedTime(String elapsedTime) {
        elapsedTimeLabel.setText("경과 시간: " + elapsedTime);
    }
}
