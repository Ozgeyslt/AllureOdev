package common;

import driver.DriverFactory;
import pages.Buttons;
import pages.WebTables;

public class PageManager {

    public Buttons buttons;
    public WebTables webTables;
    public PageManager(){
        DriverFactory.initDriver();
        buttons=PageFactory.buildButtons();
        webTables=PageFactory.buildWebTables();
    }
}
