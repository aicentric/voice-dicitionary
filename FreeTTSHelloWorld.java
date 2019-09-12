package demo.sphinx.helloworld;
import java.sql.*;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.audio.JavaClipAudioPlayer;
public class FreeTTSHelloWorld {  
	public static 	 String word=null,meaning=null,type=null,sentence=null,s=null;
    /** 
     * Example of how to list all the known voices. 
     */  
    public static void listAllVoices() {  
        
        VoiceManager voiceManager = VoiceManager.getInstance();  
        Voice[] voices = voiceManager.getVoices();  
       
         
    }  
  
    public void performTts(String b) throws SQLException  
    {
    	
   
    	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	    Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","db49","db49");
	    Statement st = conn.createStatement();
	   s=b;
	    
	    
	    ResultSet res=null;    
	      res=st.executeQuery("select * from diction where WORD='"+s+"'");
		   while (res.next())
		   {
			   word=res.getString("WORD");
			   meaning=res.getString("MEANING");
			   type=res.getString("TYPEW");
			   sentence=res.getString("SENTENCE");
		   }
	
    	

    	
        System.setProperty( "mbrola.base", "C:\\mbrola" );   
        listAllVoices();  
        
        String voiceName =  "mbrola_us1";  
  

        /* The VoiceManager manages all the voices for FreeTTS. 
         */  
        VoiceManager voiceManager = VoiceManager.getInstance();  
        Voice helloVoice = voiceManager.getVoice(voiceName);  
  
        if (helloVoice == null) {  
            System.err.println(  
                "Cannot find a voice named "  
                + voiceName + ".  Please specify a different voice.");  
            System.exit(1);  
        }  
  
        /* Allocates the resources for the voice. 
         */  
        helloVoice.allocate();  
  
 
        helloVoice.speak(word+" ...,,,.... "+meaning+"..,,,..usage of the word"+".....,,,,."+sentence);  

        helloVoice.deallocate();  
       
        
        
    }  
}  