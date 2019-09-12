
package demo.sphinx.helloworld;
import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import edu.cmu.sphinx.util.props.PropertyException;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.JOptionPane;


/**
 * A simple HelloWorld demo showing a simple speech application 
 * built using Sphinx-4. This application uses the Sphinx-4 endpointer,
 * which automatically segments incoming audio into utterances and silences.
 */
public class HelloWorld {

    /**
     * Main method for running the HelloWorld demo.
     * @wbp.parser.entryPoint
     */
   
    public String sound(String b)
    {
    	String resultText=b;
        try {
            URL url;
           
                url = HelloWorld.class.getResource("helloworld.config.xml");
            

           

            ConfigurationManager cm = new ConfigurationManager(url);

			Recognizer recognizer = (Recognizer) cm.lookup("recognizer");
			Microphone microphone = (Microphone) cm.lookup("microphone");


            /* allocate the resource necessary for the recognizer */
            recognizer.allocate();

            /* the microphone will keep recording until the program exits */
			microphone.startRecording();
	    	 
			JOptionPane.showMessageDialog(null, "Start speaking");

                 
		    Result result = recognizer.recognize();
		    
			
		
			if (result != null) {
				 resultText = result.getBestFinalResultNoFiller();
				 JOptionPane.showMessageDialog(null, "You said: " + resultText + "\n");
			    } 
			else {
			    	 JOptionPane.showMessageDialog(null, "I can't hear what you said.\n");
			    }
			 microphone.stopRecording();
		   recognizer.deallocate();
		    
		   
	   
        } catch (IOException e) {
            System.err.println("Problem when loading HelloWorld: " + e);
            e.printStackTrace();
        } catch (PropertyException e) {
            System.err.println("Problem configuring HelloWorld: " + e);
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.err.println("Problem creating HelloWorld: " + e);
            e.printStackTrace();
        }
		return resultText;
    }
}
