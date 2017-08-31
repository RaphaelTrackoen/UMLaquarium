import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Simulation{
	
//////////////////////////////////////////////////////////////////////////////// Variables ////////////////////////////////////////////////////////////////////////////////////////////
    private JFrame frame;
    private JPanel speciesPanel;
    private JButton day, night, goldFishes;
    private JButton start, reStart;
    private Random random;
	private Timer whaleTimer, sharkTimer, goldFishesTimer, MedusaTimer;
    private int mode, round;
    private JLabel algae1, algae2, algae3, algae4, algae5, algae6, algae7, algae8;
    private ArrayList<Whale> whales;
    private ArrayList<JLabel> whaleslbl;
    private ArrayList<Shark> sharks;
    private ArrayList<JLabel> sharklbl;
    private ArrayList<Goldfish> goldfishes;
    private ArrayList<JLabel> goldfisheslbl;
    private ArrayList<Medusa> Medusa;
    private ArrayList<JLabel> Medusalbl;
    int x,y;
    
/////////////////////////////////////////////////////////////////////////////////// Constructor ////////////////////////////////////////////////////////////////////////////////////////
    public Simulation() {
        // Initialization of variables
        random = new Random();
        mode = 1;
        setRound(0);
        initiate();
        
        //Building elements on JPanel
        buildWhales();
        buildSharks();
        buildGoldfishes();
        buildMedusa();
        
    }
    
    
    
/////////////////////////////////////////////////////////////////////////////////// Methods //////////////////////////////////////////////////////////////////////////////////////////// 
    
    public static void main(String[] args) {
        new Simulation();
    }
    
    public void buildWhales()
    {
        // Adding whales to the panel
        whales = new ArrayList<Whale>();
        whaleslbl = new ArrayList<JLabel>();
        Whale w1 = new Whale();
        Whale w2 = new Whale();
        Whale w3 = new Whale();
        Whale w4 = new Whale();
        w3.setDirection(-1);//Set the direction to the opposite so we have 2 whales facing right and 2 whales facing left
        w4.setDirection(-1);
        whales.add(w1);//add objects to the list
        whales.add(w2);
        whales.add(w3);
        whales.add(w4);
        
        for(int i=0;i<whales.size();i++)
        {
             x = random.nextInt(speciesPanel.getWidth()-245);
             y = random.nextInt(speciesPanel.getHeight()-105);
             JLabel temp = new JLabel(whales.get(i).getImg());
             whaleslbl.add(temp);
             temp.setBounds(x, y, 245, 105);
             speciesPanel.add(temp);
             speciesPanel.repaint();
        }
    }

    public void buildSharks()
    {
        // Adding sharks to the panel
        sharks = new ArrayList<Shark>();
        sharklbl = new ArrayList<JLabel>();
        Shark s1 = new Shark();
        Shark s2 = new Shark();
        Shark s3 = new Shark();
        Shark s4 = new Shark();
        s1.setDirection(-1);
        s2.setDirection(-1);
        sharks.add(s1);
        sharks.add(s2);
        sharks.add(s3);
        sharks.add(s4);
        
        for(int i=0;i<sharks.size();i++)
        {
             x = random.nextInt(speciesPanel.getWidth()-269);
             y = random.nextInt(speciesPanel.getHeight()-139);
             JLabel temp = new JLabel(sharks.get(i).getImg());
             sharklbl.add(temp);
             temp.setBounds(x, y, 269, 139);
             speciesPanel.add(temp);
             speciesPanel.repaint();
        }
    }

    public void buildGoldfishes()
    {
        // Adding goldfishes to the panel
        goldfishes = new ArrayList<Goldfish>();
        goldfisheslbl = new ArrayList<JLabel>();
        Goldfish g1 = new Goldfish();
        Goldfish g2 = new Goldfish();
        Goldfish g3 = new Goldfish();
        Goldfish g4 = new Goldfish();
        g1.setDirection(-1);
        g2.setDirection(-1);
        goldfishes.add(g1);
        goldfishes.add(g2);
        goldfishes.add(g3);
        goldfishes.add(g4);
        
        for(int i=0;i<goldfishes.size();i++)
        {
            x = random.nextInt(algae5.getX())+50;						
            y = random.nextInt(algae5.getY())+150;
            JLabel temp = new JLabel(goldfishes.get(i).getImg());
            goldfisheslbl.add(temp);
            temp.setBounds(x, y, 80, 56);
            speciesPanel.add(temp);
            speciesPanel.repaint();
        }
    }
    
    public void buildMedusa()
    {
    	// Adding Medusa to the panel
        Medusa = new ArrayList<Medusa>();
        Medusalbl = new ArrayList<JLabel>();
        Medusa j1 = new Medusa();
        Medusa j2 = new Medusa();
        Medusa.add(j1);
        Medusa.add(j2);
        
        for(int i=0;i<Medusa.size();i++)
        {
            x = random.nextInt(speciesPanel.getWidth()-109);
            y = random.nextInt(speciesPanel.getHeight()-165);
            JLabel temp = new JLabel(Medusa.get(i).getImg());
            Medusalbl.add(temp);
            temp.setBounds(x, y, 109, 165);
            speciesPanel.add(temp);
            speciesPanel.repaint();
        }
    }
    
    // GUI initiation
    public void initiate() {
        frame = new JFrame("Aquarium Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
     

        
        speciesPanel = new JPanel(null);
        speciesPanel.setBackground(Color.LIGHT_GRAY);
        speciesPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        speciesPanel.setBounds(10, 10, 850, 740);
        frame.add(speciesPanel);
        
        addAlgae();
        
/////////////////////////////////////////////////////////////////////////////////// Day button ///////////////////////////////////////////////////////////////////////////////////  
        
        day = new JButton(new ImageIcon("day.png"));
        day.setBounds(280, 780, 50, 50);
        day.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(mode == 0)
                {
                    mode = 1;
                    whaleTimer.start();
                    speciesPanel.setBackground(Color.lightGray);
                    speciesPanel.repaint();
                }
            }
        });
        frame.add(day);

/////////////////////////////////////////////////////////////////////////////////// Night button ///////////////////////////////////////////////////////////////////////////////////
        
        night = new JButton(new ImageIcon("night.png"));
        night.setBounds(350, 780, 50, 50);
        night.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(mode == 1)
                {
                    mode = 0;
                    whaleTimer.stop();
                    speciesPanel.setBackground(Color.DARK_GRAY);
                    speciesPanel.repaint();
                }
            }
        });
        
        frame.add(night);
        
/////////////////////////////////////////////////////////////////////////////////// Goldfish button ///////////////////////////////////////////////////////////////////////////////////
        
        goldFishes = new JButton(new ImageIcon("CreateGoldFishes.png"));
        goldFishes.setBounds(420, 780, 50, 50);
        goldFishes.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                goldFishesTimer.stop();
                for(int i=0;i<goldfisheslbl.size();i++)
                {
                    speciesPanel.remove(goldfisheslbl.get(i));
                }
                buildGoldfishes();
                goldFishesTimer.start();
            }
        });
        frame.add(goldFishes);

/////////////////////////////////////////////////////////////////////////////////// Timers ///////////////////////////////////////////////////////////////////////////////////
        
        // timer for movement of whales
        whaleTimer = new Timer(15, new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
               for(int i=0;i<whales.size();i++)
               {
                    JLabel temp = whaleslbl.get(i);
                    x = temp.getX();
                    y = temp.getY();
                    if(whales.get(i).getDirection() == 1)
                    {
                        x++;
                       
                        if(x>= speciesPanel.getWidth())
                        {
                            x= -245;
                        }
                    }
                    else
                    {
                        x--;
                        if(x <= -245)
                        {
                            x= speciesPanel.getWidth();
                        }
                    }
                    temp.setBounds(x,y, 245,105);
                    speciesPanel.add(temp);
                    speciesPanel.repaint();
                    
                    if(mode == 0)
                    {
                    	whaleTimer.stop();
                    }
               }
           }
        });
        
        // timer for movement of sharks
        sharkTimer = new Timer(10, new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
               for(int i=0;i<sharks.size();i++)
               {
                    JLabel temp = sharklbl.get(i);
                    int x = temp.getX();
                    int y = temp.getY();
                    if(sharks.get(i).getDirection() == -1)
                    {
                        x++;
                        if(x>= speciesPanel.getWidth())
                        {
                            x= -269;
                        }
                    }
                    else
                    {
                        x--;
                        if(x <= -269)
                        {
                            x= speciesPanel.getWidth();
                        }
                    }
                    temp.setBounds(x,y, 269,139);
                    speciesPanel.add(temp);
                    speciesPanel.repaint();
               }
           }
        });
        
        // timer for movement of goldfishes
        goldFishesTimer = new Timer(6, new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
               for(int i=0;i<goldfishes.size();i++)
               {
                    JLabel temp = goldfisheslbl.get(i);
                    int x = temp.getX();
                    int y = temp.getY();
                    if(goldfishes.get(i).getDirection() == -1)
                    {
                        x++;
                        if(x>= speciesPanel.getWidth())
                        {
                            x= -80;
                        }
                    }
                    else
                    {
                        x--;
                        if(x <= -80)
                        {
                            x= speciesPanel.getWidth();
                        }
                    }
                    temp.setBounds(x,y, 80,56);
                    speciesPanel.add(temp);
                    speciesPanel.repaint();
               }
           }
        });
        
        // timer for movement of medusa
        MedusaTimer = new Timer(10, new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
               for(int i=0;i<Medusa.size();i++)
               {
                    JLabel temp = Medusalbl.get(i);
                    int x = temp.getX();
                    int y = temp.getY();
                    
                    if(y <= speciesPanel.getHeight())
                    {
                        y--;
                    }
                    
                    if(y<=0)
                    {
                        y = y * -600;
                    }
                    temp.setBounds(x, y, 109, 165);
                    speciesPanel.add(temp);
                    speciesPanel.repaint();
               }
           }
        });
        
/////////////////////////////////////////////////////////////////////////////////// Start button ///////////////////////////////////////////////////////////////////////////////////
        
        start = new JButton("Start");
        start.setBounds(270, 850, 110, 50);
        start.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(!whaleTimer.isRunning() && mode == 1)
                {
                    whaleTimer.start();
                }
                
                if(!sharkTimer.isRunning())
                {
                    sharkTimer.start();
                }
                
                if(!goldFishesTimer.isRunning())
                {
                    goldFishesTimer.start();
                }
                
                if(!MedusaTimer.isRunning())
                {
                    MedusaTimer.start();
                }
                
                // Day and night cycle
                
                Thread timer = new Thread(){
                	
                	
                    public void run()
                    {
                        int time = 0;
                        while(true)
                        {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Simulation.class.getName()).log(Level.SEVERE, null, ex);
                            }
                           time++;
                           if(time == 5)
                           {
                               time = 0;
                               if(mode == 1)
                                {
                                    night.doClick();                   
                                    speciesPanel.repaint();
                                    for(int i=0;i<whales.size();i++)
                                    {
                                        whales.get(i).setLife(whales.get(i).getLife()+1);
                                        whales.get(i).setSatiety(whales.get(i).getSatiety()-1);
                                        sharks.get(i).setLife(sharks.get(i).getLife()+1);
                                        sharks.get(i).setSatiety(sharks.get(i).getSatiety()-1);
                                        
                                    }
                                    for(int i=0;i<2;i++)
                                    {
                                        Medusa.get(i).setLife(Medusa.get(i).getLife()+1);
                                        Medusa.get(i).setSatiety(Medusa.get(i).getSatiety()-1);
                                        
                                    }
                                }
                                else
                                {
                                    day.doClick();                         
                                    speciesPanel.repaint();
                                }
                           }
                        }
                        
                    }
                };
                timer.start();
            }
        });
        frame.add(start);
        
/////////////////////////////////////////////////////////////////////////////////// Restart button ///////////////////////////////////////////////////////////////////////////////////
        reStart = new JButton("Restart");
        reStart.setBounds(400, 850, 110, 50);
        reStart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(whaleTimer.isRunning())
                {
                    whaleTimer.stop();
                }
                if(sharkTimer.isRunning())
                {
                    sharkTimer.stop();
                }
                if(goldFishesTimer.isRunning())
                {
                    goldFishesTimer.stop();
                }
                for(int i=0;i<4;i++)
                {
                    speciesPanel.remove(whaleslbl.get(i));
                    speciesPanel.remove(sharklbl.get(i));
                    speciesPanel.remove(goldfisheslbl.get(i));
                    speciesPanel.repaint();
                }
                
                buildSharks();
                buildWhales();
                buildGoldfishes();
                if(!whaleTimer.isRunning())
                {
                    whaleTimer.start();
                }
                
                if(!sharkTimer.isRunning())
                {
                    sharkTimer.start();
                }
                
                if(!goldFishesTimer.isRunning())
                {
                    goldFishesTimer.start();
                }
            }
        });
        frame.add(reStart);
        

        frame.setSize(900, 980);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    // add algae to panel
    public void addAlgae()
    {
        algae1 = new JLabel(new Algae().getImage());
        algae1.setBounds(20, 200, 93, 165);
        speciesPanel.add(algae1);

        algae2 = new JLabel(new Algae().getImage());
        algae2.setBounds(80, 200, 93, 165);
        speciesPanel.add(algae2);

        algae3 = new JLabel(new Algae().getImage());
        algae3.setBounds(140, 200, 93, 165);
        speciesPanel.add(algae3);

        algae4 = new JLabel(new Algae().getImage());
        algae4.setBounds(650, 30, 93, 165);
        speciesPanel.add(algae4);

        algae5 = new JLabel(new Algae().getImage());
        algae5.setBounds(600, 450, 93, 165);
        speciesPanel.add(algae5);

        algae6 = new JLabel(new Algae().getImage());
        algae6.setBounds(90, 550, 93, 165);
        speciesPanel.add(algae6);

        algae7 = new JLabel(new Algae().getImage());
        algae7.setBounds(170, 560, 93, 165);
        speciesPanel.add(algae7);

        algae8 = new JLabel(new Algae().getImage());
        algae8.setBounds(250, 530, 93, 165);
        speciesPanel.add(algae8);
    }



///////////////////////////////////////////////////////////// Getters and Setters ///////////////////////////////////////////////////////////// 
    
	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}
	
	
}