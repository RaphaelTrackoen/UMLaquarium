
import javax.swing.ImageIcon;

 class Algae extends Motionless{
    private ImageIcon img;
    
    
    
    public Algae()
    {
        super("Algae");
        img = new ImageIcon("algue.png");
    }
    
    public ImageIcon getImage()
    {
        return img;
    }
}