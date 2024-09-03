package common;

import com.codeborne.selenide.Selenide;
import pages.Buttons;
import pages.WebTables;
import utils.PropertyManager;

public class PageFactory {

    static PropertyManager propertyManager=new PropertyManager();

    public static Buttons buildButtons(){
        String url=propertyManager.getProperty("APP_URL");
        Selenide.open(url + "elements");
        return new Buttons("/");
    }

    public static WebTables buildWebTables(){
        String url=propertyManager.getProperty("APP_URL");
        Selenide.open(url+"webtables");
        return new WebTables("/");
    }
}
