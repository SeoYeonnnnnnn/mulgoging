package Main;

import javax.swing.ImageIcon;
import java.awt.Image;

public class Character {
    private String name;
    private Image image;

    public Character(String name) {
        this.name = name;
        this.image = loadImage(name);
    }

    private Image loadImage(String characterName) {
        String imagePath;
        switch(characterName) {
            case "토끼":
                imagePath = "src/Image/animalimg/Rabbit_1.png";
                break;
            case "염소":
                imagePath = "src/Image/animalimg/염소.png";
                break;
            case "오리":
                imagePath = "src/Image/animalimg/오리.png";
                break;
            case "고양이":
                imagePath = "src/Image/animalimg/고양이.png";
                break;
            default:
                imagePath = "path/to/default/image.png";
                break;
        }
        return new ImageIcon(imagePath).getImage();
    }

    public Image getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
