import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectCheck {

    public boolean searchForSelect(String a, WebElement element){
        Select cars = new Select(element);
        List<WebElement> options = cars.getOptions();
        for(WebElement option : options){
            if(option.getText().equals(a))
                return true;
        }
        return false;
    }
}
