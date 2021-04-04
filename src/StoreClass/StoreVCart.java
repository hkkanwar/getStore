package StoreClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

public class StoreVCart {

        private StoreManager storeManager;
        private int cartID;
        private final JFrame frame;
        private final JFrame checkout;
        private final JPanel cartItemsGrid = new JPanel(new GridLayout(7,1)); //Add this to the constructor

        /**
         * Constructor for StoreView
         * @param storeManager    StoreManager object
         * @param cartID          int value for the Id of the cart
         */
        public StoreVCart(StoreManager storeManager, int cartID){
            this.storeManager = storeManager;
            this.cartID = cartID;
            this.frame = new JFrame();
            this.checkout = new JFrame();
        }
        /**
         * Fetches id of the cart
         * @return cartID   int value of id of cart
         */
        public int getCartID() {
            return cartID;
        }

        /**
         *
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
         *
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
            frame.setTitle("Client StoreView");
            JLabel headerLabel = new JLabel("Welcome to our Store! (ID:" + cartID + ")");
            cartItemsGrid.setVisible(false);

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
            JPanel cartI = new JPanel(new GridLayout(8,0));

            ImageIcon cartImage = new ImageIcon(new ImageIcon("src/StoreClass/Images/cart1.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
            ImageIcon adIm = new ImageIcon(new ImageIcon("src/StoreClass/Images/ad1.jpeg").getImage().getScaledInstance(100, 150, Image.SCALE_DEFAULT));
            ImageIcon adIm2 = new ImageIcon(new ImageIcon("src/StoreClass/Images/ad2.jpeg").getImage().getScaledInstance(100, 150, Image.SCALE_DEFAULT));
            ImageIcon c = new ImageIcon(new ImageIcon("src/StoreClass/Images/secure-checkout.jpeg").getImage().getScaledInstance(250, 50, Image.SCALE_DEFAULT));
            JLabel adImage = new JLabel(adIm);
            JLabel adImage2 = new JLabel(adIm2);
            JLabel seCheck = new JLabel(c);
            JLabel inventoryText = new JLabel("Inventory");
            JLabel showCartText = new JLabel("Click on the cart icon to show items in your cart");
            JLabel adsText = new JLabel("Ads");

            JButton quitB = new JButton("Quit");
            quitB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to quit?") == JOptionPane.OK_OPTION) {
                        frame.dispose();
                        frame.setVisible(false);
                        System.out.print("Program exited, have a great day!");
                        System.exit(0);
                    }
                }});
            JButton cartB = new JButton(cartImage);
            JButton checkoutB = new JButton("Checkout");
            JButton payB = new JButton("Pay Now");
            payB.setEnabled(false);

            for (Product product : storeManager.showInventory()){
                productCardsGrid.add(productCard(product, storeManager.checkStock(product)));
            }

            checkoutB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    System.out.println("Opening checkout frame");

                    for (String s : storeManager.cartItemsList(cartID)) {
                        JLabel item = new JLabel("  " +s);
                        cartI.add(item);
                    }
                    double payment = storeManager.processTransaction(storeManager.getCart(cartID), cartID);
                    JLabel total = new JLabel("TOTAL: $"+ String.format("%.2f",payment));
                    if(payment>0){payB.setEnabled(true);}
                    cartI.add(total);
                    checkout.setMinimumSize(new Dimension(300, 300));
                    checkout.setVisible(true);
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

            adsBorderLayout.add(buffer, BorderLayout.CENTER);
            adsBorderLayout.add(adsText, BorderLayout.NORTH);
            buffer.add(adImage);
            buffer.add(adImage2);
            bodyPanel.add(cartP, BorderLayout.WEST);
            bodyPanel.add(inventoryP, BorderLayout.CENTER);
            bodyPanel.add(adsBorderLayout, BorderLayout.EAST);
            inventoryP.add(productCardsGrid, BorderLayout.CENTER);
            inventoryP.add(inventoryText, BorderLayout.NORTH);
            cartP.add(cartB, BorderLayout.NORTH);
            cartP.add(cartItemsGrid, BorderLayout.CENTER);
            cartP.add(checkoutB, BorderLayout.SOUTH);
            headerPanel.add(headerLabel, BorderLayout.CENTER);
            footerPanel.add(showCartText, BorderLayout.WEST);
            footerPanel.add(quitB, BorderLayout.EAST);
            mainPanel.add(headerPanel, BorderLayout.PAGE_START);
            mainPanel.add(bodyPanel, BorderLayout.CENTER);
            mainPanel.add(footerPanel, BorderLayout.SOUTH);

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
            // the frame is not visible until we set it to be so
            frame.setVisible(true);


            //checkout pay button
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


            checkoutP.add(seCheck, BorderLayout.NORTH);
            checkoutP.add(cartI);
            checkoutP.add(payB,BorderLayout.PAGE_END);

            checkout.add(checkoutP);


            //frame.setMinimumSize(new Dimension(300, 300));
            checkout.pack();
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


