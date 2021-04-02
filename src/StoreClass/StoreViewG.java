package StoreClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Harsimran Kanwar 101143556,
 * @author Hussein Elmokdad 101171490
 * @version 1.0
 */
public class StoreViewG {
    private StoreManager storeManager;
    private int cartID;
    private final JFrame frame;

    /**
     * Constructor for StoreView
     * @param storeManager    StoreManager object
     * @param cartID          int value for the Id of the cart
     */
    public StoreViewG(StoreManager storeManager, int cartID){
        this.storeManager = storeManager;
        this.cartID = cartID;
        this.frame = new JFrame();
    }
    /**
     * Fetches id of the cart
     * @return cartID   int value of id of cart
     */
    public int getCartID() {
        return cartID;
    }

    private JPanel productCard(String name, double price, int stock, JLabel image){
        JButton buttonAdd = new JButton("+");
        JButton buttonSub = new JButton("-");
        JLabel textLabel = new JLabel(name);
        JPanel borderLayout = new JPanel(new BorderLayout());
        borderLayout.add(image, BorderLayout.CENTER);
        borderLayout.add(textLabel, BorderLayout.PAGE_START);
        JPanel gridLayout = new JPanel(new GridLayout(1,2));
        gridLayout.add(buttonAdd);
        gridLayout.add(buttonSub);
        borderLayout.add(gridLayout, BorderLayout.PAGE_END);
        return borderLayout;
    }

    public void displayGUI(){
        // some things you should specify when creating your JFrame
        frame.setTitle("GETSTORE()");

        // create JLabels
        JLabel headerLabel = new JLabel("Welcome to our Store");

        //create Jpanels
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel headerPanel = new JPanel();
        JPanel bodyPanel = new JPanel(new GridBagLayout());

        // -------------------------------------------------
        JScrollBar scrollBar = new JScrollBar();
        ImageIcon appleImage = new ImageIcon(new ImageIcon("src/StoreClass/Apples.jpg").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
        JLabel appleImageLabel = new JLabel(appleImage);
        JLabel cartText = new JLabel("Cart");
        cartText.setMinimumSize(new Dimension(30, 30));
        JLabel inventoryText = new JLabel("Inventory");
        JLabel applesText = new JLabel("Apples");
        JButton button = new JButton("Testing");
        JButton button1 = new JButton("Testing1");
        JButton button2 = new JButton("Testing2");
        JButton button3 = new JButton("Testing3");
        JButton buttonAdd = new JButton("+");
        JButton buttonSub = new JButton("-");
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0,20,15,20);
        bodyPanel.add(cartText,constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        bodyPanel.add(inventoryText,constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        bodyPanel.add(appleImageLabel,constraints);
        constraints.gridx = 2;
        constraints.gridy = 1;
        bodyPanel.add(button, constraints);
        constraints.gridx = 3;
        constraints.gridy = 1;
        bodyPanel.add(button1, constraints);
        constraints.gridx = 1;
        constraints.gridy = 2;
        bodyPanel.add(button2, constraints);
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.weighty = 1.0;
        constraints.insets = new Insets(40,0,0,0);
        JPanel card1 = new JPanel(new BorderLayout());
        card1.add(appleImageLabel, BorderLayout.CENTER);
        card1.add(applesText, BorderLayout.PAGE_START);
        JPanel gridLayout = new JPanel(new GridLayout(1,2));
        gridLayout.add(buttonAdd);
        gridLayout.add(buttonSub);
        card1.add(gridLayout, BorderLayout.PAGE_END);
        JPanel card2 = productCard("Apples", 12.2, 12, appleImageLabel);
        bodyPanel.add(card2, constraints);
        bodyPanel.setBackground(Color.CYAN);
        bodyPanel.setOpaque(true);
        //mainPanel.add(scrollBar, BorderLayout.EAST);
        // -------------------------------------------------

        // adding JLabels to the respective JPanel
        headerPanel.add(headerLabel);

        // set the preferred sizes and colours here
        // headerPanel.setPreferredSize(new Dimension(250, 100));
        // bodyPanel.setPreferredSize(new Dimension(250, 100));

        JButton palButton = new JButton("TEST");
        palButton.addActionListener(new ActionListener() {

            // this method will be called when we click the button
            @Override
            public void actionPerformed(ActionEvent ae) {
            System.out.println("hii");

            }});

        // add your JLabels to the panel here
        mainPanel.add(headerPanel, BorderLayout.PAGE_START);
        mainPanel.add(bodyPanel, BorderLayout.CENTER);
        //mainPanel.setPreferredSize(new Dimension(500, 500));
        // pack
        frame.add(mainPanel);
        frame.pack();
        // add the window listener
        // we no longer want the frame to close immediately when we press "x"
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to quit?")
                        == JOptionPane.OK_OPTION) {
                    // close it down!
                    frame.setVisible(false);
                    frame.dispose();
                }
            }
        });
        // the frame is not visible until we set it to be so
        frame.setVisible(true);
        //frame.setMinimumSize(new Dimension(300, 300));
        System.out.println(frame.getSize()); //Default w182 & h155
    }


    public static void main(String[] args) {
        StoreManager sm = new StoreManager();
        StoreViewG sv1 = new StoreViewG(sm, sm.assignNewCartID());
        //StoreView sv2 = new StoreView(sm, sm.assignNewCartID());
        //StoreView sv3 = new StoreView(sm, sm.assignNewCartID());
        //StoreView[] users = {sv1, sv2, sv3};
        sv1.displayGUI();
    }



}
