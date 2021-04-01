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

    public void displayGUI(){
        // some things you should specify when creating your JFrame
        frame.setTitle("GETSTORE()");

        // create JLabels
        JLabel headerLabel = new JLabel("Welcome to our Store");

        //create Jpanels
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel headerPanel = new JPanel();
        JPanel bodyPanel = new JPanel(new GridLayout(1,8));

        // adding JLabels to the respective JPanel
        headerPanel.add(headerLabel);

        // set the preferred sizes and colours here
        headerPanel.setPreferredSize(new Dimension(250, 100));
        bodyPanel.setPreferredSize(new Dimension(250, 100));

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
