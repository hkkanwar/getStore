package StoreClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StoreVCart {

        private StoreManager storeManager;
        private int cartID;
        private final JFrame frame;

        /**
         * Constructor for StoreView
         * @param storeManager    StoreManager object
         * @param cartID          int value for the Id of the cart
         */
        public StoreVCart(StoreManager storeManager, int cartID){
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

        //We should probably pass the object instead of all these parameters
        private JPanel productCard(String name, double price, int stock, ImageIcon image){
            JPanel description = new JPanel(new BorderLayout());
            JButton buttonAdd = new JButton("+");
            JButton buttonSub = new JButton("-");
            JLabel newImage = new JLabel(image); // This is so that it doesn't use/move the passed image in the argument
            JLabel nameLabel = new JLabel(name);
            JLabel priceLabel = new JLabel("Price: " + Double.toString(price) + "$");
            JLabel stockLabel = new JLabel("Stock: " + Integer.toString(stock));
            description.add(nameLabel, BorderLayout.NORTH);
            description.add(priceLabel, BorderLayout.CENTER);
            description.add(stockLabel, BorderLayout.SOUTH);
            JPanel borderLayout = new JPanel(new BorderLayout());
            borderLayout.add(newImage, BorderLayout.CENTER);
            borderLayout.add(description, BorderLayout.NORTH);
            JPanel gridLayout = new JPanel(new GridLayout(1,2));
            gridLayout.add(buttonSub);
            gridLayout.add(buttonAdd);
            borderLayout.add(gridLayout, BorderLayout.PAGE_END);
            borderLayout.setBorder(BorderFactory.createLineBorder(Color.black));
            return borderLayout;
        }

        public void displayGUI(){
            // some things you should specify when creating your JFrame
            frame.setTitle("TEST FOR CART");

            // create JLabels
            JLabel headerLabel = new JLabel("Welcome to our Store");

            //create Jpanels
            JPanel mainPanel = new JPanel(new BorderLayout());
            JPanel headerPanel = new JPanel(new BorderLayout());
            JPanel footerPanel = new JPanel(new BorderLayout());
            JPanel bodyPanel = new JPanel(new BorderLayout());
            JPanel inventoryP = new JPanel(new BorderLayout());
            JPanel cartP = new JPanel(new BorderLayout());
            JPanel cartItemsGrid = new JPanel(new GridLayout(3,1));

            //icons
            ImageIcon applesImage = new ImageIcon(new ImageIcon("src/StoreClass/Apples.jpg").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
            ImageIcon orangesImage = new ImageIcon(new ImageIcon("src/StoreClass/Oranges.jpg").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
            ImageIcon lemonsImage = new ImageIcon(new ImageIcon("src/StoreClass/Lemons.jpg").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
            ImageIcon cartImage = new ImageIcon(new ImageIcon("src/StoreClass/cart1.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
            //_____________________________________________
            JLabel appleImageLabel = new JLabel(applesImage);
            JLabel orangesImageLabel = new JLabel(orangesImage);
            JLabel lemonsImageLabel = new JLabel(lemonsImage);
            JLabel cartText = new JLabel("Cart");
            //cartText.setMinimumSize(new Dimension(30, 30));
            //cartP.setBackground(Color.pink);
            JButton cartB = new JButton(cartImage);
            JButton checkoutB = new JButton("Checkout");
            JButton quitB = new JButton("Quit");
            JLabel showCartText = new JLabel("Click on the cart icon to show items in your cart");
            cartItemsGrid.setVisible(false);
            cartB.addActionListener(new ActionListener() {

                // this method will be called when we click the button
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if(cartItemsGrid.isVisible()){
                        cartItemsGrid.setVisible(false);
                        showCartText.setVisible(true);
                    }
                    else{
                        cartItemsGrid.setVisible(true);
                        showCartText.setVisible(false);
                    }
                }});
            //cartB.setMinimumSize(new Dimension(10, 10));


            bodyPanel.add(cartP, BorderLayout.WEST);
            bodyPanel.add(inventoryP, BorderLayout.CENTER);
            bodyPanel.add(footerPanel, BorderLayout.SOUTH);
            footerPanel.add(showCartText, BorderLayout.WEST);
            //footerPanel.add(quitB, BorderLayout.CENTER);
            cartP.add(cartB, BorderLayout.NORTH);
            cartP.add(checkoutB, BorderLayout.SOUTH);
            JPanel productCardsGrid = new JPanel(new GridLayout(2,2));

            cartItemsGrid.setPreferredSize(new Dimension(10, 30));
            cartP.add(cartItemsGrid, BorderLayout.CENTER);
            productCardsGrid.add(productCard("Apples", 1.3, 10, applesImage));
            productCardsGrid.add(productCard("Oranges", 3.2, 4, orangesImage));
            productCardsGrid.add(productCard("Lemons", 0.6, 34, lemonsImage));

            cartItemsGrid.add(productCard("Apples", 1.3, 10, applesImage));
            //cartItemsGrid.add(productCard("Oranges", 3.2, 4, orangesImage));
            //cartItemsGrid.add(productCard("Lemons", 0.6, 34, lemonsImage));

            inventoryP.add(productCardsGrid, BorderLayout.CENTER);
            JLabel inventoryText = new JLabel("Inventory");
            JButton button = new JButton("Testing");
            JButton button1 = new JButton("Testing1");
            JButton button2 = new JButton("Testing2");
            JButton button3 = new JButton("Testing3");
            JButton buttonAdd = new JButton("+");
            JButton buttonSub = new JButton("-");

            inventoryP.add(inventoryText, BorderLayout.NORTH);
            inventoryP.setBorder(BorderFactory.createLineBorder(Color.black));
            /*
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.insets = new Insets(0,20,15,20);
            //bodyPanel.add(cartText,constraints);
            //bodyPanel.add(cartB,constraints);
            //constraints.gridx = 1;
            //constraints.gridy = 0;

            bodyPanel.add(cartP,constraints);
            constraints.gridx = 0;
            constraints.gridy = 0;
            bodyPanel.add(inventoryText,constraints);
            constraints.gridx = 1;
            constraints.gridy = 0;
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

             */


            // -------------------------------------------------

            // adding JLabels to the respective JPanel
            headerPanel.add(headerLabel, BorderLayout.CENTER);


            // set the preferred sizes and colours here
            // headerPanel.setPreferredSize(new Dimension(250, 100));
            // bodyPanel.setPreferredSize(new Dimension(250, 100));


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
        StoreVCart sv1 = new StoreVCart(sm, sm.assignNewCartID());
        //StoreView sv2 = new StoreView(sm, sm.assignNewCartID());
        //StoreView sv3 = new StoreView(sm, sm.assignNewCartID());
        //StoreView[] users = {sv1, sv2, sv3};
        sv1.displayGUI();
    }

}
