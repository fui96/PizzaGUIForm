import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaGUIFrame extends JFrame {
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();

    //Panels
    JPanel MainPanel,SizePanel,CrustPanel,ToppingPanel,BottomPanel;
    //Button Groups
    ButtonGroup CrustButtonGroup;
    //ComboBox
    JComboBox PizzaSizeComboBox;
    //Check Boxes
    JCheckBox PepperoniCB,ExtraCheeseCB,OnionCB,PineappleCB,HamCB,BaconCB,ChickenCB,OlivesCB;
    //Radio Buttons
    JRadioButton ThinCrustRB,RegularCrustRB,DeepDishRB;
    //Buttons
    JButton OrderButton,ClearButton,QuitButton;
    //TextArea
    JTextArea OrderTextArea;
    //ScrollPane
    JScrollPane OrderScrollPane;

    String Crust = "";
    String Size = "";
    PizzaObject Pizza;
    public PizzaGUIFrame() {
        setTitle("Pizza Order");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        int Width = (int) (screenSize.width * .35);
        int Height = (int) (screenSize.height * .8);
        setSize(Width, Height);
        setLocationRelativeTo(null);
        MainPanel = new JPanel();
        MainPanel.setLayout(new GridLayout(4,1));
        add(MainPanel, BorderLayout.CENTER);
        CreateSizePanel();
        MainPanel.add(SizePanel);
        CreateCrustPanel();
        MainPanel.add(CrustPanel);
        CreatToppingsPanel();
        MainPanel.add(ToppingPanel);

        setVisible(true);
    }

    //Panel Creators
    public void CreateSizePanel(){
        SizePanel = new JPanel();
        SizePanel.setBorder(new TitledBorder(new EtchedBorder(), " Pizza Size"));

        PizzaSizeComboBox = new JComboBox();

        PizzaSizeComboBox.addItem("Small");
        PizzaSizeComboBox.addItem("Medium");
        PizzaSizeComboBox.addItem("Large");
        PizzaSizeComboBox.addItem("Super");

        PizzaSizeComboBox.addActionListener((ActionEvent ae) -> {
            Size = PizzaSizeComboBox.getSelectedItem().toString();
        });


        SizePanel.add(PizzaSizeComboBox);


    }
    public void CreateCrustPanel(){
        CrustPanel = new JPanel();
        CrustPanel.setBorder(new TitledBorder(new EtchedBorder(), " Crust"));
        CrustPanel.setLayout(new GridLayout(1,3));

        ThinCrustRB = new JRadioButton("Thin Crust");
        RegularCrustRB = new JRadioButton("Hand-tossed Crust");
        DeepDishRB = new JRadioButton("Deep Dish");

        ThinCrustRB.addActionListener((ActionEvent ae) -> {Crust = ThinCrustRB.getText();
             Pizza = new PizzaObject(Crust, Size);
        });
        RegularCrustRB.addActionListener((ActionEvent ae) -> {Crust = RegularCrustRB.getText();
             Pizza = new PizzaObject(Crust, Size);
        });
        DeepDishRB.addActionListener((ActionEvent ae) -> {Crust = DeepDishRB.getText();
             Pizza = new PizzaObject(Crust, Size);
        });

        CrustButtonGroup = new ButtonGroup();
        CrustButtonGroup.add(ThinCrustRB);
        CrustButtonGroup.add(RegularCrustRB);
        CrustButtonGroup.add(DeepDishRB);

        CrustPanel.add(ThinCrustRB);
        CrustPanel.add(RegularCrustRB);
        CrustPanel.add(DeepDishRB);

    }
    public void CreatToppingsPanel(){

        ToppingPanel = new JPanel();
        ToppingPanel.setBorder(new TitledBorder(new EtchedBorder(), " Toppings"));
        ToppingPanel.setLayout(new GridLayout(4,2));

        PepperoniCB = new JCheckBox("Pepperoni");
        PepperoniCB.addActionListener((ActionEvent ae) -> {ToppingButtonAction(ae,Pizza);});

        ExtraCheeseCB = new JCheckBox("Extra Cheese");
        ExtraCheeseCB.addActionListener((ActionEvent ae) -> {ToppingButtonAction(ae,Pizza);});

        OnionCB = new JCheckBox("Onion");
        OnionCB.addActionListener((ActionEvent ae ) -> {ToppingButtonAction(ae,Pizza);});

        PineappleCB = new JCheckBox("Pineapple");
        PineappleCB.addActionListener((ActionEvent ae) -> {ToppingButtonAction(ae,Pizza);});

        HamCB = new JCheckBox("Ham");
        HamCB.addActionListener((ActionEvent ae) -> {ToppingButtonAction(ae,Pizza);});

        BaconCB = new JCheckBox("Bacon");
        BaconCB.addActionListener((ActionEvent ae) -> {ToppingButtonAction(ae,Pizza);});

        ChickenCB = new JCheckBox("Chicken");
        ChickenCB.addActionListener((ActionEvent ae ) -> {ToppingButtonAction(ae,Pizza);});

        OlivesCB = new JCheckBox("Olives");
        OlivesCB.addActionListener((ActionEvent ae) -> {ToppingButtonAction(ae,Pizza);});

        ToppingPanel.add(PepperoniCB);
        ToppingPanel.add(ExtraCheeseCB);
        ToppingPanel.add(OnionCB);
        ToppingPanel.add(PineappleCB);
        ToppingPanel.add(HamCB);
        ToppingPanel.add(BaconCB);
        ToppingPanel.add(ChickenCB);
        ToppingPanel.add(OlivesCB);

    }
    public void CreateBottomPanel(){

    }

    public void ToppingButtonAction(ActionEvent ae,PizzaObject Pizza){
        Pizza.addToppings(ae.getSource().toString());
    }
}