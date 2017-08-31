
import javax.swing.ImageIcon;

public class Medusa extends Motion{
    private int foodLevel;
    private int satiety;
    private int life;
    private final int birthDelay = 0;
    private ImageIcon img;
    
/////////////////////////////////////////////////////////////  Constructor /////////////////////////////////////////////////////////////     
    
    public Medusa()
    {
        super("Medusa");
        this.foodLevel = 10;
        this.satiety = 15;
        this.life = 0;
        img = new ImageIcon("meduse.png");
    }
    
/////////////////////////////////////////////////////////////  Getters and Setters ///////////////////////////////////////////////////////////// 
    
    public String getSpecie() {
            return super.getName();
    }

    public void setSpecie(String specie) {
            super.setName(specie);
    }

    public int getFoodLevel() {
            return foodLevel;
    }

    public void setFoodLevel(int foodLevel) {
            this.foodLevel = foodLevel;
    }

    public int getSatiety() {
            return satiety;
    }

    public void setSatiety(int satiety) {
            this.satiety = satiety;
    }

    public int getLife() {
            return life;
    }

    public void setLife(int life) {
            this.life = life;
    }

    public int getbirthDelay() {
            return birthDelay;
    }
    
    public ImageIcon getImg()
    {
        return img;
    }
}