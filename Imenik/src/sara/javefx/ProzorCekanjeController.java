package sara.javefx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;


public class ProzorCekanjeController {
	
	@FXML
	private ProgressIndicator pr = new ProgressIndicator();
	
	@FXML
	private Button b1 = new Button();
	
	
	@SuppressWarnings("static-access")
	@FXML
	void initialize()
	{
		pr.setProgress(pr.INDETERMINATE_PROGRESS);
	}
	
	
	
	

}
