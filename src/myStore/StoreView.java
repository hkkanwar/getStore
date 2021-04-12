package myStore;

/**
 * @author Harsimran Kanwar 101143556,
 * @author Hussein Elmokdad 101171490
 * @version 1.0
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StoreView {

        private StoreManager storeManager;
        private int cartID;
        private final JFrame frame;
        private final JFrame checkout;
        private final JPanel cartItemsGrid;

        /**
         * Constructor for StoreView
         * @param storeManager    StoreManager object
         * @param cartID          int value for the Id of the cart
         */
        public StoreView(StoreManager storeManager, int cartID){
            this.storeManager = storeManager;
            this.cartID = cartID;
            this.frame = new JFrame();
            this.checkout = new JFrame();
            this.cartItemsGrid = new JPanel(new GridLayout(7,1));
        }
        /**
         * Fetches id of the cart
         * @return cartID   int value of id of cart
         */
        public int getCartID() {
            return cartID;
        }

        /**
         * Returns a JPanel (BorderLayout) that displays information about a product, such as name,
         * stock, price, image, and the ability to add/remove from cart
         * @param product Product object for the card
         * @param stock int number of available stock
         * @return a JPanel that's a BorderLayout of the productCard
         */
        private JPanel productCard(Product product, int stock){
            JPanel borderLayout = new JPanel(new BorderLayout());
            JPanel gridLayout = new JPanel(new GridLayout(1,2));
            JPanel description = new JPanel(new BorderLayout());
            JButton buttonAdd = new JButton("+");
            JButton buttonSub = new JButton("-");
            JLabel imageLable = new JLabel(product.getImageIcon());
            JLabel nameLabel = new JLabel(product.getName());
            JLabel priceLabel = new JLabel("Price: " + Double.toString(product.getPrice()) + "$");
            JLabel stockLabel = new JLabel("Stock: " + Integer.toString(storeManager.checkStock(product)));
            buttonSub.setEnabled(false);
            buttonAdd.addActionListener(new ActionListener() {
                // this method will be called when we click the button
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if(storeManager.checkStock(product) > 0) {
                        storeManager.addItemToCart(product, 1, cartID);
                        stockLabel.setText("Stock: " + Integer.toString(storeManager.checkStock(product)));
                    }
                    if (storeManager.checkStock(product) == 0) buttonAdd.setEnabled(false);
                    if (storeManager.checkStock(product) != stock) buttonSub.setEnabled(true);

                    while (cartItemsGrid.getComponents().length != 0){
                       cartItemsGrid.remove(0);
                    }
                    for (Product product: storeManager.showCart(cartID)){
                        cartItemsGrid.add(productCardInCart(product, storeManager.getCart(cartID).get(product)));
                    }
            }});
            buttonSub.addActionListener(new ActionListener() {
                // this method will be called when we click the button
                @Override
                public void actionPerformed(ActionEvent ae) {
                    storeManager.removeItemFromCart(product, 1, cartID);
                    stockLabel.setText("Stock: " + Integer.toString(storeManager.checkStock(product)));
                    if (storeManager.checkStock(product) > 0) buttonAdd.setEnabled(true);
                    if (storeManager.checkStock(product) == stock) buttonSub.setEnabled(false);
                    while (cartItemsGrid.getComponents().length != 0){
                        cartItemsGrid.remove(0);
                    }
                    for (Product product: storeManager.showCart(cartID)){
                        cartItemsGrid.add(productCardInCart(product, storeManager.getCart(cartID).get(product)));
                    }
                    cartItemsGrid.repaint();
                }});
            description.add(nameLabel, BorderLayout.NORTH);
            description.add(priceLabel, BorderLayout.CENTER);
            description.add(stockLabel, BorderLayout.SOUTH);
            gridLayout.add(buttonSub);
            gridLayout.add(buttonAdd);
            borderLayout.add(imageLable, BorderLayout.CENTER);
            borderLayout.add(description, BorderLayout.NORTH);
            borderLayout.add(gridLayout, BorderLayout.PAGE_END);
            borderLayout.setBorder(BorderFactory.createLineBorder(Color.black));
            return borderLayout;
        }

        /**
         * Returns a JPanel (BorderLayout) that displays information about a product in the cart,
         * such as name, price, quantity, and image
         * @param product Product object for the card
         * @param quantity int number of quantity in cart
         * @return a JPanel that's a BorderLayout of the product card in the cart
         */
        private JPanel productCardInCart(Product product, int quantity){
            JPanel borderLayout = new JPanel(new BorderLayout());
            JPanel description = new JPanel(new BorderLayout());
            JLabel imageLable = new JLabel(product.getImageIcon());
            JLabel nameLabel = new JLabel(product.getName());
            JLabel priceLabel = new JLabel("Price: " + Double.toString(product.getPrice()) + "$");
            JLabel stockLabel = new JLabel("Quantity: " + Integer.toString(quantity));
            description.add(nameLabel, BorderLayout.NORTH);
            description.add(priceLabel, BorderLayout.CENTER);
            description.add(stockLabel, BorderLayout.SOUTH);
            borderLayout.add(imageLable, BorderLayout.CENTER);
            borderLayout.add(description, BorderLayout.NORTH);
            borderLayout.setBorder(BorderFactory.createLineBorder(Color.black));
            return borderLayout;
        }


        /**
         *Displays the entire store interface for the user to interact with.
         */
        public void displayGUI(){
            //name frames
            frame.setTitle("Client StoreView");
            checkout.setTitle("Time to checkout :)");

            JLabel headerLabel = new JLabel("Welcome to our Store! (ID:" + cartID + ")");
            cartItemsGrid.setVisible(false);

            //panels
            JPanel mainPanel = new JPanel(new BorderLayout());
            JPanel headerPanel = new JPanel(new BorderLayout());
            JPanel footerPanel = new JPanel(new BorderLayout());
            JPanel bodyPanel = new JPanel(new BorderLayout());
            JPanel inventoryP = new JPanel(new BorderLayout());
            JPanel cartP = new JPanel(new BorderLayout());
            JPanel checkoutP = new JPanel(new BorderLayout());
            JPanel buffer = new JPanel(new GridLayout(2,1));
            JPanel adsBorderLayout = new JPanel(new BorderLayout());
            JPanel productCardsGrid = new JPanel(new GridLayout(3,3));
            JPanel cartSummary = new JPanel(new GridLayout(8,0));
            JPanel invT = new JPanel(new GridLayout(1,2));

            //images
            ImageIcon cartImage = new ImageIcon(new ImageIcon("src/myStore/Images/cart1.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
            ImageIcon adIm = new ImageIcon(new ImageIcon("src/myStore/Images/ad1.jpeg").getImage().getScaledInstance(100, 150, Image.SCALE_DEFAULT));
            ImageIcon adIm2 = new ImageIcon(new ImageIcon("src/myStore/Images/ad2.jpeg").getImage().getScaledInstance(100, 150, Image.SCALE_DEFAULT));
            ImageIcon c = new ImageIcon(new ImageIcon("src/myStore/Images/secure-checkout.jpeg").getImage().getScaledInstance(250, 50, Image.SCALE_DEFAULT));

            //labels
            JLabel adImage = new JLabel(adIm);
            JLabel adImage2 = new JLabel(adIm2);
            JLabel seCheck = new JLabel(c);
            JLabel inventoryText = new JLabel("Inventory");
            JLabel showCartText = new JLabel("Click on the cart icon to show items in your cart");
            JLabel adsText = new JLabel("Ads");
            JLabel invItems = new JLabel("Displaying Items: " + Integer.toString(storeManager.getInventoryCount()));
            JButton quitB = new JButton("Quit");
            JButton cartB = new JButton(cartImage);
            JButton checkoutB = new JButton("Checkout");
            JButton payB = new JButton("Pay Now");

            payB.setEnabled(false);

            for (Product product : storeManager.showInventory()){
                productCardsGrid.add(productCard(product, storeManager.checkStock(product)));
            }

            quitB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to quit?") == JOptionPane.OK_OPTION) {
                        frame.dispose();
                        frame.setVisible(false);
                        storeManager.returnItemsToInventory(getCartID()); // Returns the items in cart back to the inventory
                        System.out.print("Program exited, have a great day!");
                        System.exit(0);
                    }
                }});

            checkoutB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    System.out.println("Opening checkout frame");
                    JLabel itemNum = new JLabel("Total Items: " +Integer.toString(storeManager.getCartCount(cartID)));
                    cartSummary.add(itemNum);
                    for (String s : storeManager.cartItemsList(cartID)) {
                        JLabel item = new JLabel("  " +s);
                        cartSummary.add(item);
                    }
                    double payment = storeManager.processTransaction(storeManager.getCart(cartID), cartID);
                    JLabel total = new JLabel("TOTAL: $"+ String.format("%.2f",payment));
                    if(payment>0){payB.setEnabled(true);}
                    cartSummary.add(total);

                    checkout.setMinimumSize(new Dimension(300, 300));
                    checkout.setVisible(true);
                    frame.setVisible(false);
                }
            });

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

            buffer.setVisible(true);

            //test
            invT.add(inventoryText,BorderLayout.WEST);
            invT.add(invItems,BorderLayout.CENTER);
            //adding components to main frame
            adsBorderLayout.add(buffer, BorderLayout.CENTER);
            adsBorderLayout.add(adsText, BorderLayout.NORTH);
            buffer.add(adImage);
            buffer.add(adImage2);
            bodyPanel.add(cartP, BorderLayout.WEST);
            bodyPanel.add(inventoryP, BorderLayout.CENTER);
            bodyPanel.add(adsBorderLayout, BorderLayout.EAST);
            inventoryP.add(productCardsGrid, BorderLayout.CENTER);
            //inventoryP.add(inventoryText, BorderLayout.NORTH);
            inventoryP.add(invT, BorderLayout.NORTH);
            cartP.add(cartB, BorderLayout.NORTH);
            cartP.add(cartItemsGrid, BorderLayout.CENTER);
            cartP.add(checkoutB, BorderLayout.SOUTH);
            headerPanel.add(headerLabel, BorderLayout.CENTER);
            footerPanel.add(showCartText, BorderLayout.WEST);
            footerPanel.add(quitB, BorderLayout.EAST);
            mainPanel.add(headerPanel, BorderLayout.PAGE_START);
            mainPanel.add(bodyPanel, BorderLayout.CENTER);
            mainPanel.add(footerPanel, BorderLayout.SOUTH);

            //adding components to the checkout frame
            checkoutP.add(seCheck, BorderLayout.NORTH);
            checkoutP.add(cartSummary);
            checkoutP.add(payB,BorderLayout.PAGE_END);
            checkout.add(checkoutP);

            cartItemsGrid.setPreferredSize(new Dimension(10, 30));
            inventoryP.setBorder(BorderFactory.createLineBorder(Color.black));


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

            checkout.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent we) {
                    for (String s : storeManager.cartItemsList(cartID)) {
                        // If the user is about to checkout but decides to go back
                        // it'll remove the items in cartSummary (not the actual cart)
                        cartSummary.remove(0);
                    }
                    cartSummary.remove(0); // Removes total

                    frame.setVisible(true);
                }
            });

            // the frame is not visible until we set it to be so
            frame.setVisible(true);

            //checkout frame components
            payB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    int input = JOptionPane.showConfirmDialog(null,
                            "Payment Received!", "Confirmation", JOptionPane.DEFAULT_OPTION);
                    if (input == 0) {
                        System.out.println("closing store");
                        System.out.println("Have a nice day! :)");
                        // close it down
                        frame.setVisible(false);
                        frame.dispose();
                        checkout.setVisible(false);
                        checkout.dispose();
                        System.exit(0);
                    }
                }
            });
            //frame.setMinimumSize(new Dimension(300, 300));
            checkout.pack();
        }

    public static void main(String[] args) {
        StoreManager sm = new StoreManager();
        StoreView sv1 = new StoreView(sm, sm.assignNewCartID());
        sv1.displayGUI();
    }

}


