package DemoPackage;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AlertHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Browser br=Playwright.create().chromium().launch(new LaunchOptions().setHeadless(false).setSlowMo(3000));
    Page p=br.newPage();
    p.navigate("https://the-internet.herokuapp.com/javascript_alerts");
    
    
    
  /*  p.onDialog(dialog ->{
    	String m=dialog.message();
    	Assert.assertTrue(m.contains("I am a JS Alert"));             //for alert
    	System.out.println(m);
    });
    p.getByText("Click for JS Alert").click();
   */
    
    
    
    
   /* p.onDialog(dialog ->{
    	String m=dialog.message();
    	Assert.assertTrue(m.contains("I am a JS Confirm"));             //for accept or dismiss
    	System.out.println(m);
    	dialog.accept();         //to accept
    	//dialog.dismiss();        //to dismiss
    });
    
    p.getByText("Click for JS Confirm").click();
    */
    
    
    p.onDialog(dialog ->{
    	String m=dialog.message();
    	Assert.assertTrue(m.contains("I am a JS prompt"));             //for accept or dismiss the prompt
    	System.out.println(m);
    	dialog.accept("kamal");         //to accept the text in prompt
    	//dialog.dismiss();        //to dismiss
    });
    
    p.getByText("Click for JS Prompt").click();
    
    
    
//    br.close();
//    p.close();
    
    
	}

}
