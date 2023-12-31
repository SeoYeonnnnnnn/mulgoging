package Main;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundManager {
    private Clip clip;

    public SoundManager(String soundFilePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource(soundFilePath));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        if (clip != null) {
            clip.setFramePosition(0); // 소리 재생 위치를 처음으로 설정
            clip.start(); // 소리 재생 시작
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop(); // 소리 재생 중지
        }
    }
}
