/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import model.modelGoku;
import model.orderModel;//1
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Date;
//import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import lib.XFile;
import java.awt.Color;
import java.awt.List;
import java.util.Set;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import lib.XFile;

/**
 *
 * @author ACER
 */
public class Goku extends javax.swing.JFrame {
    CardLayout cardLayout;
    DefaultTableModel tbModel;
    DefaultComboBoxModel cbModel = new DefaultComboBoxModel();
    DefaultTableModel tbModel2;
    DefaultComboBoxModel cbModel2 = new DefaultComboBoxModel();
    
    String filePath = "";//địa chỉ file
    String filePath2 = "";
    
    ArrayList<modelGoku> cafList;
    ArrayList<orderModel> orderList;//1
    int currentRow = -1;

    /**
     * Creates new form Main
     */
    public Goku() {
        initComponents();

        loadCb();
        txtPriceOrder.setEnabled(false);
        btnDeleteAdd.setEnabled(false);
        btnUpdateAdd.setEnabled(false);
        txtIDOrder.setEditable(false);
        cardLayout = (CardLayout) jPanel3.getLayout();        
        this.setLocationRelativeTo(null);
        initTableOrder();
        initTable();//
        tbAdd.setDefaultEditor(Object.class, null);//chọn trong bản mà ko được sửa trong bản
        tbOrder.setDefaultEditor(Object.class, null);
        filePath2 = "./src/data/hhsongokushop.dat";
        filePath = "./src/data/siuuugokushop.dat";//1
        rdDrinkAdd.setSelected(true);
        orderList = new ArrayList<>();//1
        cafList = new ArrayList<>();
        boolean file = loadFile();
        boolean fileOrder = loadFileOrder();
        if (file) {
            fillToTable();//điền dữ liệu vào bảng
        } else {
            showMess("Nothing to show in management");
        }
        if (fileOrder) {
            fillToTableOrder();//điền dữ liệu vào bảng
        } else {
            showMess("Nothing to show in order");
        }
        
        this.setLocationRelativeTo(null);
    }


    private void fillToTable() {
        tbModel.setRowCount(0);
        for (modelGoku c : cafList) {
            Object[] row = new Object[]{c.getID(), c.getName(), c.getType(), c.getPrice()};//lấy dữ liệu
            tbModel.addRow(row);
        }
    }
    
    private void fillToTableOrder() {//1
        tbModel2.setRowCount(0);
        for (orderModel c : orderList) {
            Object[] row = new Object[]{c.getIDOrder(), c.getNameOrder(), c.getSizeOrder(),c.getPriceOrder()};//lấy dữ liệu
            tbModel2.addRow(row);
        }
    }
    

    private void initTable() {//thêm tên cột vào trong bảng
        String[] columnNames = {"ID", "Name", "Type", "Price"};
        tbModel = new DefaultTableModel(columnNames, 0);
        tbAdd.setModel(tbModel);
    }
    private void initTableOrder() {//thêm tên cột vào trong bảng //1
        String[] columnNames = {"ID", "Name","Size","Price"};
        tbModel2 = new DefaultTableModel(columnNames, 0);
        tbOrder.setModel(tbModel2);
    }
    
    
    
    
    private boolean Check() {
        String code = txtCodeAdd.getText();
        if (!"".equals(txtCodeAdd.getText()) && !"".equals(txtNameAdd.getText())) {
            for (modelGoku cf : cafList) {
                if (code.equals(cf.getID())) {
                    txtCodeAdd.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "The ID must be differance");
                    return false;
                }
            }
            String Price = txtPriceAdd.getText();
            for (int i = 0; i < Price.length(); i++) {
                Boolean flags = Character.isDigit(Price.charAt(i));
                if (!flags) {
                    txtPriceAdd.setBackground(Color.red);
                    return false;

                }
            }
        } else {
            txtCodeAdd.setBackground(Color.red);
            txtNameAdd.setBackground(Color.red);
            txtPriceAdd.setBackground(Color.red);
            return false;
        }
        txtCodeAdd.setBackground(Color.white);
        txtNameAdd.setBackground(Color.white);
        txtPriceAdd.setBackground(Color.white);
        return true;
    }
    
    private boolean CheckOrder() {
        String id = txtIDOrder.getText();
        if (!"".equals(txtCodeAdd.getText())) {
            for (orderModel cf : orderList) {
                if (id.equals(cf.getIDOrder())) {
                    txtIDOrder.setBackground(Color.red);
                    return false;
                }
                return true;
                
            }
        } else {
            txtIDOrder.setBackground(Color.red);
            return false;
        }
        txtIDOrder.setBackground(Color.white);
        return true;
    }
    
    
    

    private boolean loadFile() {
        /*
        tại vì em có 2 file, mà trong hàm này, em mới load 1 file chạy dc thì nó đã return true rồi
        */
        if (XFile.readObject(filePath) == null) {
            return false;
        }
        cafList = (ArrayList<modelGoku>) XFile.readObject(filePath);
        return true;
    }
    private boolean loadFileOrder() {
        if (XFile.readObject(filePath2) == null) {
            return false;
        }
        orderList = (ArrayList<orderModel>) XFile.readObject(filePath2);
        return true;
    }

    private void showMess(String mess) {
        JOptionPane.showMessageDialog(this, mess);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        addPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNameAdd = new javax.swing.JTextField();
        rdDrinkAdd = new javax.swing.JRadioButton();
        rdFoodAdd = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtCodeAdd = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAdd = new javax.swing.JTable();
        btnRefreshAdd = new javax.swing.JButton();
        btnAddAdd = new javax.swing.JButton();
        btnUpdateAdd = new javax.swing.JButton();
        btnDeleteAdd = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtPriceAdd = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        orderPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbNameProduct = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbOrder = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtPriceOrder = new javax.swing.JTextField();
        btnRefreshOrder = new javax.swing.JButton();
        btnAddOrder = new javax.swing.JButton();
        btnDeleteOrder = new javax.swing.JButton();
        cbSize = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtIDOrder = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 153));
        jLabel1.setText("GOKU CAFÉ");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel3.setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        jLabel2.setFont(new java.awt.Font("Sylfaen", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("Management Menu");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Product Code:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Product Name:");

        buttonGroup1.add(rdDrinkAdd);
        rdDrinkAdd.setText("Drink");
        rdDrinkAdd.setActionCommand("D");

        buttonGroup1.add(rdFoodAdd);
        rdFoodAdd.setText("Food");
        rdFoodAdd.setActionCommand("F");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Type:");

        tbAdd.setBackground(new java.awt.Color(204, 255, 204));
        tbAdd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Type", "Price"
            }
        ));
        tbAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbAddMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbAdd);

        btnRefreshAdd.setText("Refresh");
        btnRefreshAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshAddActionPerformed(evt);
            }
        });

        btnAddAdd.setBackground(new java.awt.Color(102, 255, 102));
        btnAddAdd.setText("Add");
        btnAddAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAddActionPerformed(evt);
            }
        });

        btnUpdateAdd.setBackground(new java.awt.Color(51, 204, 255));
        btnUpdateAdd.setText("Update");
        btnUpdateAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateAddActionPerformed(evt);
            }
        });

        btnDeleteAdd.setBackground(new java.awt.Color(255, 0, 0));
        btnDeleteAdd.setText("Delete");
        btnDeleteAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAddActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Price:");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/gokulogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnRefreshAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteAdd)
                        .addGap(72, 357, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodeAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdDrinkAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdFoodAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtPriceAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNameAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCodeAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNameAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtPriceAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdDrinkAdd)
                            .addComponent(rdFoodAdd)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRefreshAdd)
                            .addComponent(btnAddAdd)
                            .addComponent(btnUpdateAdd)
                            .addComponent(btnDeleteAdd)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        rdDrinkAdd.getAccessibleContext().setAccessibleName("true");
        rdFoodAdd.getAccessibleContext().setAccessibleName("false");
        rdFoodAdd.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout addPanelLayout = new javax.swing.GroupLayout(addPanel);
        addPanel.setLayout(addPanelLayout);
        addPanelLayout.setHorizontalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        addPanelLayout.setVerticalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.add(addPanel, "addPanel");

        orderPanel.setBackground(new java.awt.Color(255, 255, 204));

        jLabel7.setFont(new java.awt.Font("Sitka Text", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 255));
        jLabel7.setText("Order");

        jLabel8.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel8.setText("ID:");

        jLabel10.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel10.setText("Price:");

        cbNameProduct.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbNameProductItemStateChanged(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel11.setText("Size:");

        tbOrder.setBackground(new java.awt.Color(204, 255, 204));
        tbOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbOrderMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbOrder);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/gokulogo.png"))); // NOI18N

        btnRefreshOrder.setText("Refresh");
        btnRefreshOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshOrderActionPerformed(evt);
            }
        });

        btnAddOrder.setBackground(new java.awt.Color(102, 255, 102));
        btnAddOrder.setText("Add");
        btnAddOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOrderActionPerformed(evt);
            }
        });

        btnDeleteOrder.setBackground(new java.awt.Color(255, 0, 0));
        btnDeleteOrder.setText("Delete");
        btnDeleteOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteOrderActionPerformed(evt);
            }
        });

        cbSize.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSizeItemStateChanged(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel15.setText("Name:");

        javax.swing.GroupLayout orderPanelLayout = new javax.swing.GroupLayout(orderPanel);
        orderPanel.setLayout(orderPanelLayout);
        orderPanelLayout.setHorizontalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanelLayout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(orderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(orderPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(orderPanelLayout.createSequentialGroup()
                        .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderPanelLayout.createSequentialGroup()
                                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(orderPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(32, 32, 32)
                                        .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPriceOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(62, 62, 62))
                            .addGroup(orderPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbNameProduct, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtIDOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(orderPanelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(btnAddOrder)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRefreshOrder)
                                .addGap(47, 47, 47)
                                .addComponent(btnDeleteOrder)
                                .addGap(9, 9, 9)))
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160))))
        );
        orderPanelLayout.setVerticalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(orderPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel13))
                    .addGroup(orderPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtIDOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbNameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtPriceOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefreshOrder)
                    .addComponent(btnAddOrder)
                    .addComponent(btnDeleteOrder))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel3.add(orderPanel, "orderPanel");

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton2.setText("Management");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton3.setText("Order");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(40, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(252, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(428, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(282, 282, 282))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void showDetail(int r) {
        String id = (String) tbAdd.getValueAt(r, 0);//0 đó là cột id
        txtCodeAdd.setText(id);
        String name = (String) tbAdd.getValueAt(r, 1);
        txtNameAdd.setText(name);
        Double price = (Double) tbAdd.getValueAt(r, 3);
        txtPriceAdd.setText(price.toString());
        
//        Boolean gender = (Boolean) tbAdd.getValueAt(r, 2);
//        setBtnGroup(gender.toString());
        
    }
    private void showDetailOrder(int r){
        String id = (String) tbOrder.getValueAt(r, 0);
        txtIDOrder.setText(id);
        String name = (String) tbOrder.getValueAt(r, 1);
        cbNameProduct.setSelectedItem(name);
        String size = (String) tbOrder.getValueAt(r, 2);
        cbSize.setSelectedItem(size);
        Double priceOd = (Double) tbOrder.getValueAt(r, 3);
        txtPriceOrder.setText(priceOd.toString());
  
    }
    
    
    private void btnAddAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAddActionPerformed
        // TODO add your handling code here:
        if (Check() == true) {
            addPro();
            fillToTable();
            saveFile();
            resetForm();
        }
     
    }//GEN-LAST:event_btnAddAddActionPerformed

    private void btnUpdateAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateAddActionPerformed
        // TODO add your handling code here:
        updateCaf();
        fillToTable();
        saveFile();
        resetForm();
    }//GEN-LAST:event_btnUpdateAddActionPerformed

    private void btnDeleteAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAddActionPerformed
        // TODO add your handling code here:
        deleteCaf();
        fillToTable();
        saveFile();
        
    }//GEN-LAST:event_btnDeleteAddActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(this,
                "Do you want to exit?", "Exit?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);//lệnh tắt ứng dụng
        } 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        cardLayout.show(jPanel3, "orderPanel");  
         cafList.clear();
        cbNameProduct.removeAllItems();
//        orderList = (ArrayList<orderModel>) XFile.readObject(filePath2);
        cafList = (ArrayList<modelGoku>) XFile.readObject(filePath);
         for (modelGoku p : cafList) {  
             cbNameProduct.addItem(p.getName());
//                if(cbNameProduct.getSelectedItem().toString().equals(p.getName())){
//                    txtPriceOrder.setText(p.getPrice()+"");
//                }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        cardLayout.show(jPanel3, "addPanel");
//        orderList.clear();
//        cbNameProduct.removeAllItems();
//        orderList = (ArrayList<orderModel>) XFile.readObject(filePath2);
//        for (orderModel p : orderList) {  
//            cbNameProduct.addItem(p.getNameOrder());
////            menuProduct.put(p.getProductPrice().toString(), p);
//        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbAddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAddMousePressed
        // TODO add your handling code here:
        btnAddAdd.setEnabled(false);
        btnDeleteAdd.setEnabled(true);
        btnUpdateAdd.setEnabled(true);
        currentRow = tbAdd.getSelectedRow();
        showDetail(currentRow);
    }//GEN-LAST:event_tbAddMousePressed

    private void btnAddOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrderActionPerformed
        // TODO add your handling code here:
//        if (CheckOrder()== true){

        addOder();
        fillToTableOrder();
        saveFileOrder();
//        }
    }//GEN-LAST:event_btnAddOrderActionPerformed
    private void addOder() {
        String idOder = txtIDOrder.getText();
        String nameOder = cbNameProduct.getSelectedItem().toString();
        String size = cbSize.getSelectedItem().toString();
        Double price = Double.parseDouble(txtPriceOrder.getText());
        orderModel o = new orderModel(orderList.size()+1+"", nameOder, size, price);
        orderList.add(o);  
    }
                           
    
    
    private void btnDeleteOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteOrderActionPerformed
        // TODO add your handling code here:
        deleteOrder();
        fillToTableOrder();
        saveFileOrder();
    }//GEN-LAST:event_btnDeleteOrderActionPerformed

    
    private void btnRefreshAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshAddActionPerformed
        // TODO add your handling code here:
        btnDeleteAdd.setEnabled(false);
        btnUpdateAdd.setEnabled(false);
        txtCodeAdd.setText("");
        txtNameAdd.setText("");
        txtPriceAdd.setText("");
        btnAddAdd.setEnabled(true);
        
        
    }//GEN-LAST:event_btnRefreshAddActionPerformed

    private void cbNameProductItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbNameProductItemStateChanged
        // TODO add your handling code here:
//        String c = cbNameProduct.getSelectedItem().toString();
//        for (modelGoku p : cafList) {   
//        if (c.equals(p.getName())){
//            Double price = p.getPrice();
//            txtPriceOrder.setText(price+"");
//            break;                         
//        }
//        }
        for(modelGoku c : cafList){
            if(cbNameProduct.getSelectedItem().toString().equals(c.getName())){
                txtPriceOrder.setText(c.getPrice()+"");
            }
        }
       
    }//GEN-LAST:event_cbNameProductItemStateChanged

    private void tbOrderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbOrderMousePressed
        // TODO add your handling code here:
        btnAddOrder.setEnabled(false);
        btnDeleteOrder.setEnabled(true);
        currentRow = tbOrder.getSelectedRow();
        showDetailOrder(currentRow);
    }//GEN-LAST:event_tbOrderMousePressed

    private void btnRefreshOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshOrderActionPerformed
        // TODO add your handling code here:
        btnDeleteOrder.setEnabled(false);
        txtIDOrder.setText("");
        cbNameProduct.setSelectedIndex(0);
        cbSize.setSelectedIndex(0);
        
        btnAddOrder.setEnabled(true);
    }//GEN-LAST:event_btnRefreshOrderActionPerformed

    private void cbSizeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSizeItemStateChanged
        // TODO add your handling code here:   
//        Double pri = Double.parseDouble(txtPriceOrder.getText());
//        if(cbSize.getSelectedItem().toString().equals("L")){
//            txtPriceOrder.setText(pri+10+"");
//        }
    }//GEN-LAST:event_cbSizeItemStateChanged
    
    private void loadCb() {
        String[] sizeLst = {"M", "L"};//đặt dữ liệu cho combo box
        for (String string : sizeLst) {
            cbModel2.addElement(string);
        }
        cbSize.setModel(cbModel2);
    }

    
    private void updateCaf() {
        btnAddAdd.setEnabled(true);
        modelGoku c = cafList.get(currentRow);//bắt cái hàng được chọn bị sai nếu currentrow bằng -1 vì ban đầu chưa chọn
        
        c.setName(txtNameAdd.getText());
        c.setPrice(Double.parseDouble(txtPriceAdd.getText()));
        c.setType(buttonGroup1.getSelection().getActionCommand());
            btnUpdateAdd.setEnabled(false);
        btnDeleteAdd.setEnabled(false);
        
    }

    private void addPro() {        
        String id = txtCodeAdd.getText();
        String name = txtNameAdd.getText();
        String type = (buttonGroup1.getSelection().getActionCommand());
        Double price = Double.parseDouble(txtPriceAdd.getText());
        modelGoku c = new modelGoku(id, name, price, type);
        cafList.add(c);
    }

    private void deleteCaf() {
        String id = txtCodeAdd.getText();
        if (id.length() == 0) {
            showMess("Must choose 1 row");            
        } else {
            int result = JOptionPane.showConfirmDialog(this, "Do you want to delete this?", "Delete",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (result == JOptionPane.YES_NO_OPTION) {
                cafList.remove(currentRow);
                //reset form
                //cbMjor.setSelectedIndex(0);//trả về dữ liệu ban đầu của combo box
            }            
        }
        btnAddAdd.setEnabled(true);
        btnDeleteAdd.setEnabled(false);
        btnUpdateAdd.setEnabled(false);
    }
    private void deleteOrder() {
        String id = txtIDOrder.getText();
        if (id.length() == 0) {
            showMess("Must choose 1 row");            
        } else {
            int result = JOptionPane.showConfirmDialog(this, "Do you want to delete this?", "Delete",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (result == JOptionPane.YES_NO_OPTION) {
                orderList.remove(currentRow);
                //reset form
                //cbMjor.setSelectedIndex(0);//trả về dữ liệu ban đầu của combo box
            }            
        }
        btnAddOrder.setEnabled(true);
        btnDeleteOrder.setEnabled(false);
    }
    
    
    
    private void saveFile() {
        XFile.writeObject(filePath, cafList);
    }
    private void saveFileOrder() {//1
        XFile.writeObject(filePath2, orderList);
    }

    private void setBtnGroup(String value) {
        for (Component c : jPanel2.getComponents()) {
            if (c instanceof JRadioButton) {
                JRadioButton btn = (JRadioButton) c;
                if (btn.getActionCommand().equals(value)) {
                    btn.setSelected(true);
                }
            }
        }
    }
    private void resetForm(){
        btnDeleteAdd.setEnabled(false);
        btnUpdateAdd.setEnabled(false);
        txtCodeAdd.setText("");
        txtNameAdd.setText("");
        txtPriceAdd.setText("");
    }
  

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Goku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Goku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Goku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Goku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Goku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addPanel;
    private javax.swing.JButton btnAddAdd;
    private javax.swing.JButton btnAddOrder;
    private javax.swing.JButton btnDeleteAdd;
    private javax.swing.JButton btnDeleteOrder;
    private javax.swing.JButton btnRefreshAdd;
    private javax.swing.JButton btnRefreshOrder;
    private javax.swing.JButton btnUpdateAdd;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbNameProduct;
    private javax.swing.JComboBox<String> cbSize;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel orderPanel;
    private javax.swing.JRadioButton rdDrinkAdd;
    private javax.swing.JRadioButton rdFoodAdd;
    private javax.swing.JTable tbAdd;
    private javax.swing.JTable tbOrder;
    private javax.swing.JTextField txtCodeAdd;
    private javax.swing.JTextField txtIDOrder;
    private javax.swing.JTextField txtNameAdd;
    private javax.swing.JTextField txtPriceAdd;
    private javax.swing.JTextField txtPriceOrder;
    // End of variables declaration//GEN-END:variables
}
