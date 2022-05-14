/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import org.openqa.selenium.By;

/**
 *
 * @author Jes011
 * @github https://github.com/Jes011
 */
public class Bot {

    private org.openqa.selenium.WebDriver driver;
    private Instruction[] instruccions;

    public Bot(org.openqa.selenium.WebDriver driver) {
        this.driver = driver;
    }

    public void startProcesses() {
        for (int i = 0; i < this.instruccions.length; i++) {
            
            this.goToPage(this.instruccions[i].getPagina().getDomine()+this.instruccions[i].getPagina().getPath());
            
            for (int j = 0; j < this.instruccions[i].getProcesses().length; j++) {
                
                if (this.instruccions[i].getProcesses()[j].getAction() == Instruction.click) //Click
                {
                    this.searchElement(this.instruccions[i].getProcesses()[j].getXpathReference()).click();
                } 
                else if (this.instruccions[i].getProcesses()[j].getAction() == Instruction.write)//Write
                {
                    this.searchElement(this.instruccions[i].getProcesses()[j].getXpathReference()).sendKeys(this.instruccions[i].getProcesses()[j].getContent());
                }
            }
        }
    }
    
    private final void goToPage(String url){
        this.driver.navigate().to(url);
    }
    private final org.openqa.selenium.WebElement searchElement(String xpath){
        return this.driver.findElement(By.xpath(xpath));
    }

}
