

package demo.sphinx.helloworld;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
import java.io.FileInputStream;
import javazoom.jl.player.Player;
  
public class Testplay  
{  
	 public void performTts(String b)  
    {  
        String a="C:\\voice\\A\\"+b+".mp3";
        String c="C:\\voice\\A\\"+b+"(m).mp3";
        try  
        {  
            FileInputStream fis=new FileInputStream(a);  
            FileInputStream fis1=new FileInputStream(c);
            Player playMp3=new Player(fis);  
            Player play1=new Player(fis1);  
  
            playMp3.play();
            play1.play();
        }  
        catch(Exception e)  
        {  
            System.out.println(e);  
        }  
    }  
}  