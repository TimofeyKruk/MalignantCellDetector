import CellMarkUp.MarkUpApp;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //__________________DESIGN part________________________
        Font bigFont = new Font("TimesNewRoman", Font.PLAIN, 55);
        Font smallFont = new Font("TimesNewRoman", Font.PLAIN, 30);

        MarkUpApp markUpApp=new MarkUpApp();

        markUpApp.BrownQuantity.setFont(bigFont);
        markUpApp.BlueQuantity.setFont(bigFont);

        markUpApp.classOfImage.setFont(smallFont);
        markUpApp.Brown.setFont(smallFont);
        markUpApp.Blue.setFont(smallFont);
        markUpApp.nextCell.setFont(smallFont);
        markUpApp.saveToFile.setFont(smallFont);
        //__________________________________________

        //First String is a table head, so we will get rid of it during the initialization
        markUpApp.reader.readLine();




        //Combining all things together and showing them
        JFrame frame = new JFrame("Cell mark up application");
        frame.setContentPane(markUpApp.Background);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
