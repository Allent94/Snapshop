package gui;

import filters.EdgeDetectFilter;
import filters.EdgeHighlightFilter;
import filters.FlipHorizontalFilter;
import filters.FlipVerticalFilter;
import filters.GrayscaleFilter;
import filters.SharpenFilter;
import filters.SoftenFilter;
import image.PixelImage;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



/**
 * 
 * @author Allen Tran
 * @version 4-25-2017
 */
public class SnapShopGUI extends JFrame {

   /**
     * 
     */
    private static final long serialVersionUID = 1L;

/**
    * Make variable for row.
    */
    private static final int ROW = 7;
    
    /**
     * Make variable for row2.
     */
    
    private static final int ROW2 = 3;
    
    /**
     * Make variable for col.
     */
    private static final int COL = 1; 
    
    
    /**
     * Make variable for edge detect String.
     */
    
    private static final String EDGE_DETECT_COMMAND = "Edge Detect";
    
    /**
     * Make variable for edge highlight String.
     */
    
    private static final String EDGE_HIGHLIGHT_COMMAND = "Edge Highlight";
    
    /**
     * Make variable for flip horizontal String.
     */
    
    private static final String FLIP_HORIZONTAL_COMMAND = "Flip Horizontal";
    
    /**
     * Make variable for flip Vertical.
     */
    
    private static final String FLIP_VERTICAL_COMMAND = "Flip Vertical";
    
    /**
     * Make variable for grayscale String.
     */
    
    private static final String GRAYSCALE_COMMAND = "Grayscale";
    
    /**
     * Make variable for Sharpen String.
     */
  
    private static final String SHARPEN_COMMAND = "Sharpen";
    
    /**
     * Make variable for soften String.
     */
    
    private static final String SOFTEN_COMMAND = "Soften";
    
    /**
     * Make variable for open String.
     */
    
    private static final String OPEN_COMMAND = "Open...";
    
    /**
     * Make variable for save as String.
     */
    
    private static final String SAVE_AS_COMMAND = "Save as...";
    
    /**
     * Make variable for close Image String.
     */
    
    private static final String CLOSE_IMAGE_COMMAND = "Close Image";
    
    /**
     * Make variable for image.
     * 
     */
    
    private PixelImage myImage;
    
    
    /**
     * Make variable for myCenter.
     */
  
    private JLabel myCenter  = new JLabel();

    /**
     * 
     * Make variable for myCenterPanel.
     */
    
    private JPanel myCenterPanel = new JPanel();

    /**
     * Make variable for egdeDetect.
     */

    private EdgeDetectFilter myEdgeDetect = new EdgeDetectFilter();
    
    /**
     * Make variable for edgeHighlight.
     */
    
    private EdgeHighlightFilter myEdgeHighlight = new EdgeHighlightFilter();
    
    /**
     * Make variable for flipHorizontal.
     */
    
    private FlipHorizontalFilter myFilpHorizontal = new FlipHorizontalFilter();
    
    /**
     * Make variable for flipVertical.
     */
    
    private FlipVerticalFilter myFlipVertical = new FlipVerticalFilter();
    
    /**
     * Make variable for grayScale.
     */
    
    private GrayscaleFilter myGrayScale = new GrayscaleFilter();
    
    /**
     * Make variable for Sharpen.
     */
    
    
    private SharpenFilter mySharpen = new SharpenFilter();
    
    /**
     * Make variable for soften.
     */
    
    private SoftenFilter mySoften = new SoftenFilter();
    
    
    /**
     * Make Varaible for myWestPanel.
     */
    
    private JPanel myWestPanel = new JPanel();
    
    /**
     * Make variable for myWestPanel.
     */
    
    private JPanel myNorthGrid = new JPanel(new GridLayout(ROW, COL));
    
    /**
     * Make variable for mySouthGrid.
     */
    
    private JPanel mySouthGrid = new JPanel(new GridLayout(ROW2, COL));
    
    /**
     * Make variable for JFileChooser.
     */
    
    private final JFileChooser myFc = new JFileChooser(".");
    
    
    /**
     * Make method for start.
     */
    
    public void start() {
        

        buttons();
      
        makePanels();
        
        pack();
        
        this.setVisible(true);
  
        this.setResizable(true);
        
        
        
  
    }
    
    /**
     * Make method for make pnaels.
     */


    private void makePanels() {
        
        myCenterPanel.add(myCenter); //add image
        
        myCenterPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        myWestPanel.setLayout(new BorderLayout());
        
        myWestPanel.add(myNorthGrid , BorderLayout.NORTH);
        
        myWestPanel.add(mySouthGrid , BorderLayout.SOUTH);
        
        this.add(myWestPanel , BorderLayout.WEST);
        
        this.add(myCenterPanel , BorderLayout.CENTER);
        
        pack();
       
        
    }
    
    /**
     * Make method for buttons.
     */
    
    
    public void buttons() {

        final ArrayList<String> list = new ArrayList<String>();
        
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int six = 6;
        final int seven = 7;
        final int eight = 8;
        final int nine = 9;
        
        list.add(EDGE_DETECT_COMMAND);
        list.add(EDGE_HIGHLIGHT_COMMAND);
        list.add(FLIP_HORIZONTAL_COMMAND);
        list.add(FLIP_VERTICAL_COMMAND);
        list.add(GRAYSCALE_COMMAND);
        list.add(SHARPEN_COMMAND);
        list.add(SOFTEN_COMMAND);
        list.add(OPEN_COMMAND);
        list.add(SAVE_AS_COMMAND);
        list.add(CLOSE_IMAGE_COMMAND);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JButton[] buttons = new JButton[list.size()];
  
        for (int i = 0; i < list.size(); i++) {
            
            buttons[i] = new JButton(list.get(i));
            
            if (i < seven) {
                
                myNorthGrid.add(buttons[i]);
                
            } else {
                mySouthGrid.add(buttons[i]);
            }

            buttons[i].setEnabled(false);
            
            if (buttons[i] == buttons[seven]) {
                
                buttons[seven].setEnabled(true);
   
            }
                      
        }

        buttons[0].addActionListener(new ActionListener() {
           
            @Override
          public void actionPerformed(final java.awt.event.ActionEvent theEvent) {
                
                
                myEdgeDetect.filter(myImage);
               
                repaint();
                
              
                
            }
            
        }
        
        );
        
        buttons[1].addActionListener(new ActionListener() {
            
            @Override
          public void actionPerformed(final java.awt.event.ActionEvent theEvent) {
                

                
                myEdgeHighlight.filter(myImage);
                
                repaint();

            }
            
        }
        
        );
        
        buttons[2].addActionListener(new ActionListener() {
            
            @Override
          public void actionPerformed(final java.awt.event.ActionEvent theEvent) {
                
                
                myFilpHorizontal.filter(myImage);
                
                repaint();
                
              
                
            }
            
        }
        
        );
        
        buttons[three].addActionListener(new ActionListener() {
            
            @Override
          public void actionPerformed(final java.awt.event.ActionEvent theEvent) {
                
                
                myFlipVertical.filter(myImage);
                
                repaint();
 
                
            }
            
        }
        
        );
        
        buttons[four].addActionListener(new ActionListener() {
            
            @Override
          public void actionPerformed(final java.awt.event.ActionEvent theEvent) {
                
                
                myGrayScale.filter(myImage);
                
                repaint();
                             
            }
            
        }
        
        );
        
        buttons[five].addActionListener(new ActionListener() {
            
            @Override
          public void actionPerformed(final java.awt.event.ActionEvent theEvent) {
                
                
                
                mySharpen.filter(myImage);
                
                repaint();
           
                
            }
            
        }
        
        );
        
        buttons[six].addActionListener(new ActionListener() {
            
            @Override
          public void actionPerformed(final java.awt.event.ActionEvent theEvent) {
                
                mySoften.filter(myImage);
                
                repaint();
                
            }
            
        }
        
        );
        
        buttons[seven].addActionListener(new ActionListener() {
      
            @Override
          public void actionPerformed(final java.awt.event.ActionEvent theEvent) {
             
              
                final int returnValue = myFc.showOpenDialog(null);
              
            
                if (returnValue == JFileChooser.APPROVE_OPTION) {
          
                    final File file = myFc.getSelectedFile();

                    if (file.getName().endsWith(".jpg") 
                                    || file.getName().endsWith(".PNG".toLowerCase()) 
                                    || file.getName().endsWith(".GIF".toLowerCase())
                                    || file.getName().endsWith(".JNG".toLowerCase())) {
                      
                        
                        try {

                            myImage = PixelImage.load(file);
                            
                            
                        
                            myCenter.setIcon(new ImageIcon(myImage));

                            repaint();
                            
                            for (int i = 0; i < buttons.length; i++) {

                                buttons[i].setEnabled(true);

                                
                                
                            }

                        
                          
                        } catch (final IOException e1) {
                       
                            JOptionPane.showMessageDialog(null,
                                                          
                                                          "ERROR: This is not a picture.");
                        }
                      
                       
                        
                        pack();
 
                      

                      
                    } else {
                      
                        JOptionPane.showMessageDialog(null, "THIS IS NOT A PICURE!");
                      
                      
                      
                    }


                }
              
            }
                     
        } 
        
        );
             
        
        buttons[eight].addActionListener(new ActionListener() {
            
            @Override
          public void actionPerformed(final java.awt.event.ActionEvent theEvent) {
 
                final int returnVaule = myFc.showSaveDialog(null);
                
                if (returnVaule == JFileChooser.APPROVE_OPTION) {
                    
                    try {
                        myImage.save(myFc.getSelectedFile());
                    } catch (final IOException e) {
                        e.printStackTrace();
                    }
                    
                }
               
            }
            
        }
        
        );
        
        
        buttons[nine].addActionListener(new ActionListener() {
            
            @Override
          public void actionPerformed(final java.awt.event.ActionEvent theEvent) {
                
                

                myCenter.setIcon(null);
                pack();
                
            }
            
        }
        
        );
          
        
    }
    
    
}



