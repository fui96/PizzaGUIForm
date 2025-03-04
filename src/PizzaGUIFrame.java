import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class PizzaGUIFrame extends JFrame {
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();

    //Panels
    JPanel MainPanel,SizePanel,CrustPanel,ToppingPanel,OrderPanel,BottomPanel,BottomButtonPanel;
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
    ArrayList<String> Toppings;
    public PizzaGUIFrame() {
        Toppings = new ArrayList<>();
        setTitle("Pizza Order");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        int Width = (int) (screenSize.width * .7);
        int Height = (int) (screenSize.height * .8);
        setSize(Width, Height);
        setLocationRelativeTo(null);
        MainPanel = new JPanel();
        MainPanel.setLayout(new BorderLayout());

        add(MainPanel, BorderLayout.CENTER);

        CreateSizePanel();
        MainPanel.add(SizePanel,BorderLayout.NORTH);

        CreateCrustPanel();
        MainPanel.add(CrustPanel,BorderLayout.WEST);

        CreatToppingsPanel();
        MainPanel.add(ToppingPanel, BorderLayout.CENTER);

        CreateOrderPanel();
        CreateBottomButtonPanel();
        BottomPanel = new JPanel();
        BottomPanel.setLayout(new BorderLayout());
        BottomPanel.add(BottomButtonPanel, BorderLayout.SOUTH);
        BottomPanel.add(OrderPanel,BorderLayout.NORTH);
        MainPanel.add(BottomPanel,BorderLayout.SOUTH);

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
        });
        RegularCrustRB.addActionListener((ActionEvent ae) -> {Crust = RegularCrustRB.getText();
        });
        DeepDishRB.addActionListener((ActionEvent ae) -> {Crust = DeepDishRB.getText();
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
        PepperoniCB.addActionListener((ActionEvent ae) -> {ToppingButtonAction(ae);});

        ExtraCheeseCB = new JCheckBox("Extra Cheese");
        ExtraCheeseCB.addActionListener((ActionEvent ae) -> {ToppingButtonAction(ae);});

        OnionCB = new JCheckBox("Onion");
        OnionCB.addActionListener((ActionEvent ae ) -> {ToppingButtonAction(ae);});

        PineappleCB = new JCheckBox("Pineapple");
        PineappleCB.addActionListener((ActionEvent ae) -> {ToppingButtonAction(ae);});

        HamCB = new JCheckBox("Ham");
        HamCB.addActionListener((ActionEvent ae) -> {ToppingButtonAction(ae);});

        BaconCB = new JCheckBox("Bacon");
        BaconCB.addActionListener((ActionEvent ae) -> {ToppingButtonAction(ae);});

        ChickenCB = new JCheckBox("Chicken");
        ChickenCB.addActionListener((ActionEvent ae ) -> {ToppingButtonAction(ae);});

        OlivesCB = new JCheckBox("Olives");
        OlivesCB.addActionListener((ActionEvent ae) -> {ToppingButtonAction(ae);});

        ToppingPanel.add(PepperoniCB);
        ToppingPanel.add(ExtraCheeseCB);
        ToppingPanel.add(OnionCB);
        ToppingPanel.add(PineappleCB);
        ToppingPanel.add(HamCB);
        ToppingPanel.add(BaconCB);
        ToppingPanel.add(ChickenCB);
        ToppingPanel.add(OlivesCB);

    }
    public void CreateOrderPanel(){

        OrderPanel = new JPanel();
        OrderPanel.setBorder(new TitledBorder(new EtchedBorder(), " Order"));
        OrderPanel.setLayout(new GridLayout(1,1));

        OrderTextArea = new JTextArea(15,10);
        OrderTextArea.setEditable(false);
        OrderTextArea.setLineWrap(true);

        JScrollPane OrderScrollPane = new JScrollPane(OrderTextArea);

        OrderPanel.add(OrderScrollPane);
    }

    public void CreateBottomButtonPanel(){
        BottomButtonPanel = new JPanel();
        BottomButtonPanel.setBorder(new TitledBorder(new EtchedBorder(), "Order Management"));
        BottomButtonPanel.setLayout(new GridLayout(1,3));

        OrderButton = new JButton("Order");
        QuitButton = new JButton("Quit");
        ClearButton = new JButton("Clear");

        QuitButton.addActionListener((ActionEvent ae) -> {
            int response = JOptionPane.showConfirmDialog(null,"Are you sure you want to quit?","Quit",JOptionPane.YES_NO_OPTION);
            if(response == JOptionPane.YES_OPTION){
                System.exit(0);
            }
        });

        ClearButton.addActionListener((ActionEvent ae) -> {
            //Clear Text Area
            OrderTextArea.setText("");
            //Clear Toppings
            Toppings.clear();
            //Reset CheckBoxes
            PepperoniCB.setSelected(false);
            ExtraCheeseCB.setSelected(false);
            OnionCB.setSelected(false);
            PineappleCB.setSelected(false);
            HamCB.setSelected(false);
            BaconCB.setSelected(false);
            ChickenCB.setSelected(false);
            OlivesCB.setSelected(false);
            //Reset ComboBox
            PizzaSizeComboBox.setSelectedIndex(0);
            //ButtonGroupReset
            CrustButtonGroup.clearSelection();
            //Clear Variables
            Crust = "";
            Size = "";

        });
        OrderButton.addActionListener((ActionEvent ae) -> {
            if(OrderValidation()){

                 PizzaObject Pizza = new PizzaObject(Crust,Size);

                 for(String topping : Toppings){
                     Pizza.addToppings(topping);
                 }
                 OrderTextArea.append(Pizza.DisplayPizza());

            }
        });
        BottomButtonPanel.add(OrderButton);
        BottomButtonPanel.add(QuitButton);
        BottomButtonPanel.add(ClearButton);
    }

    public void ToppingButtonAction(ActionEvent ae){
        JCheckBox Source = (JCheckBox) ae.getSource();
        String topping = Source.getText();
        if(Source.isSelected()){
            Toppings.add(topping);
        }
        else{
            Toppings.remove(topping);
        }
    }

    public Boolean OrderValidation(){
        if(Crust.isEmpty()){
            JOptionPane.showMessageDialog(null,"Crust is empty, Please select a Crust type","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            return true;
        }
    }

}