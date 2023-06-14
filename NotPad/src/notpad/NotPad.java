
package notpad;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NotPad extends JFrame implements ActionListener {
    
    JMenuBar menubar=new JMenuBar();
    JMenu file=new JMenu("File");
    JMenu edit=new JMenu("Edit");
    JMenu help=new JMenu("Help");
    
    JMenuItem newfile=new JMenuItem("New");
    JMenuItem openfile=new JMenuItem("Open");
    JMenuItem savefile=new JMenuItem("Save");
    JMenuItem print=new JMenuItem("Print");
    JMenuItem exit=new JMenuItem("Exit");
    
    JMenuItem cut=new JMenuItem("Cut");
    JMenuItem copy=new JMenuItem("Copy");
    JMenuItem paste=new JMenuItem("Paste");
    JMenuItem selectall=new JMenuItem("Select All");
    
    JMenuItem about=new JMenuItem("About");
    
    JTextArea textarea=new JTextArea();
    NotPad(){
        setTitle("NotePad++");
        setBounds(100,100,800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon=new ImageIcon(getClass().getResource("mainicon.png"));
        setIconImage(icon.getImage());
        
        setJMenuBar(menubar);
        menubar.add(file);
        menubar.add(edit);
        menubar.add(help);
        
        
        file.add(newfile);
        file.add(openfile);
        file.add(savefile);
        file.add(print);
        file.add(exit);
        
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectall);
        
        help.add(about);
        
        JScrollPane scrollpane=new JScrollPane(textarea);
        add(scrollpane);
        
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
 
         newfile.addActionListener(this);
          openfile.addActionListener(this);
           savefile.addActionListener(this);
            print.addActionListener(this);
             exit.addActionListener(this);
              cut.addActionListener(this);
               copy.addActionListener(this);
                paste.addActionListener(this);
                 selectall.addActionListener(this);
                  about.addActionListener(this);
                  
                  
                        
                  
        
        
    }

    
    public static void main(String[] args) {
        new NotPad().setVisible(true);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("New")){
            textarea.setText(null);
        }
        else if(e.getActionCommand().equalsIgnoreCase("Open")){
            
             JFileChooser filechooser=new JFileChooser();
           FileNameExtensionFilter textfilter=new FileNameExtensionFilter("Only Text Files(.txt)","txt");
           filechooser.setAcceptAllFileFilterUsed(false);
           filechooser.addChoosableFileFilter(textfilter);
           
          int action=filechooser.showOpenDialog(null);
           
            if(action!=JFileChooser.APPROVE_OPTION){
               return;
           }else{
                try{
                    
               BufferedReader reader=new BufferedReader(new FileReader(filechooser.getSelectedFile()));
               textarea.read(reader,null);
               }
               catch(IOException ex){
                   ex.printStackTrace();
               }
            }
            
            
            
        }
        else if(e.getActionCommand().equalsIgnoreCase("Print")){
            try {
                textarea.print();
            } catch (PrinterException ex) {
                Logger.getLogger(NotPad.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if (e.getActionCommand().equalsIgnoreCase("Exit")){
            System.exit(0);
            
        }
        else if(e.getActionCommand().equalsIgnoreCase("Save")){
            
            
           JFileChooser filechooser=new JFileChooser();
           FileNameExtensionFilter textfilter=new FileNameExtensionFilter("Only Text Files(.txt)","txt");
           filechooser.setAcceptAllFileFilterUsed(false);
           filechooser.addChoosableFileFilter(textfilter);
           
           
           int action=filechooser.showSaveDialog(null);
           if(action!=JFileChooser.APPROVE_OPTION){
               return;
           }
           else{
               String fileName=filechooser.getSelectedFile().getAbsolutePath().toString();
               if(!fileName.contains(".txt"))
                   fileName+=".txt";
               try{
               BufferedWriter writer=new BufferedWriter(new FileWriter(fileName));
               textarea.write(writer);
               }
               catch(IOException ex){
                   ex.printStackTrace();
               }
               
           }
           
           
         
            
            
            
        }
        else if (e.getActionCommand().equalsIgnoreCase("Cut")){
            textarea.cut();
            
        }
        else if(e.getActionCommand().equalsIgnoreCase("Copy")){
            textarea.copy();
            
        }
        else if(e.getActionCommand().equalsIgnoreCase("Paste")){
            textarea.paste();
            
        }
        else if(e.getActionCommand().equalsIgnoreCase("Select All")){
            textarea.selectAll();
        }
        else if(e.getActionCommand().equalsIgnoreCase("About")){
            new About().setVisible(true);
            
        }
        
       
    }
    
}
