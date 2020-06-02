package CellMarkUp;

import sun.java2d.loops.Blit;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;


public class MarkUpApp {
    public JPanel Background;
    public JPanel imageArea;
    public JButton nextCell;
    public JButton saveToFile;
    public JTextField BrownQuantity;
    public JLabel Brown;
    public JTextField BlueQuantity;
    public JLabel Blue;
    public JCheckBox classOfImage;
    public JLabel image;

    public  Tile currentTile;

    private String fileNameIn="F:\\BSU_FAMCS\\BMI\\CourseProject\\Datasets\\ATiles\\info.csv";
    private String fileNameOut="F:\\BSU_FAMCS\\BMI\\CourseProject\\Datasets\\ATiles\\bb_tiles_DATASET.csv";
    private String folderImageName="F:\\BSU_FAMCS\\BMI\\CourseProject\\Datasets\\ATiles\\";


    private InputStream is=new FileInputStream(fileNameIn);
    public BufferedReader reader=new BufferedReader(new InputStreamReader(is));

    //public BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameOut));
    //public BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(os));



    public MarkUpApp() throws IOException {
        nextCell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String inputStr=reader.readLine();

                    currentTile=new Tile(inputStr);

                    BufferedImage bufferedImage = ImageIO.read(new File(folderImageName+currentTile.getTileName()));
                    image.setIcon(new ImageIcon(new ImageIcon(bufferedImage).getImage().getScaledInstance(256*3,256*3,Image.SCALE_DEFAULT)));

                    BrownQuantity.setText("");
                    BlueQuantity.setText("");

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        saveToFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTile.setHasCells(classOfImage.isSelected());

                if(!classOfImage.isSelected())
                {
                    BrownQuantity.setText("0");
                    BlueQuantity.setText("0");
                }


                if(BrownQuantity.getText()!=null)
                    currentTile.setBrownCells(Double.parseDouble(BrownQuantity.getText()));
                else
                    currentTile.setBrownCells(0);

                if(BlueQuantity.getText()!=null)
                    currentTile.setBlueCells(Double.parseDouble(BlueQuantity.getText()));
                else
                    currentTile.setBlueCells(0);



                try {
                    FileWriter writer=new FileWriter(fileNameOut,true);
                    String str=currentTile.makeCSVstring();
                    writer.write(str);
                    writer.append('\n');

                    BrownQuantity.setText(str);

                    writer.flush();
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }
}
