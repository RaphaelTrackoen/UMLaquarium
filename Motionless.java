
public class Motionless extends Agents{
    private String name;
    
/////////////////////////////////////////////////////////////  Constructor /////////////////////////////////////////////////////////////     
    
    public Motionless()
    {
        super();
        name = "";
    }
    
    
///////////////////////////////////////////////////////////// Getters and Setters /////////////////////////////////////////////////////////////     
    public Motionless(String name)
    {
        super(false);
        this.name = name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
}