package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private JFrame frame;
    private CardLayout cl;
    private GamePanel gamePanel;
    private IntroPanel introPanel;
    private EndPanel endPanel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Main window = new Main();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Main() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cl = new CardLayout();
        frame.getContentPane().setLayout(cl);

        introPanel = new IntroPanel(this);
        gamePanel = new GamePanel(frame, cl, this, "오리");
        endPanel = new EndPanel(this, 0); // 수정: Main 객체 참조와 함께 초기 스코어 전달

        frame.getContentPane().add(introPanel, "intro");
        frame.getContentPane().add(gamePanel, "game");
        frame.getContentPane().add(endPanel, "end");

        // 기타 초기화 로직
    }

    public void startGame() {
        cl.show(frame.getContentPane(), "game");
        gamePanel.gameReady();
        gamePanel.gameStart();
    }

    public void endGame(int finalScore) {
        endPanel.updateScore(finalScore); // EndPanel에 최종 점수 업데이트
        cl.show(frame.getContentPane(), "end"); // EndPanel을 보여줍니다.
    }

    public void restartGame() {
        cl.show(frame.getContentPane(), "game"); // GamePanel 보여주기
        gamePanel.restartGame(); // GamePanel의 restartGame 메서드 호출
    }

    // 필요한 경우 추가적인 메서드 구현
}
