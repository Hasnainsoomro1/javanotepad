
package notpad;
import javax.swing.*;

public class About extends JFrame {
    About(){
        setBounds(100,100,500,400);
        setTitle("NotePad++");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon icon =new ImageIcon(getClass().getResource("mainicon.png"));
        setIconImage(icon.getImage());
        setLayout(null);
        
        JLabel iconLabel=new JLabel(new ImageIcon(getClass().getResource("mainicon.png")));
        iconLabel.setBounds(100,50,80,80);
        add(iconLabel);
        
        JLabel textlabel=new JLabel("<html>Wellcome To Notepad++<br>Windows Notepad is a simple text editor for Windows; it creates and edits plain text documents. First released in 1983 to commercialize the computer mouse in MS-DOS,<br> Notepad has been part of every version of Windows ever since.</html>");
        textlabel.setBounds(100, 50, 350, 300);
        add(textlabel);
        
    }
    public static void main(String []arg){
        new About().setVisible(true);
    }
    
}
