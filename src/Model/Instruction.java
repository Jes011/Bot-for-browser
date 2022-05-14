/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;

/**
 *
 * @author Jes011
 * @github https://github.com/Jes011
 */
public class Instruction {
    
    public static byte click = 1;
    
    public static byte write = 2;
    
    private WebPage page;
    private Procces[] processes;
    
    public Instruction(WebPage page,Procces[] processes){
        this.page = page;
        this.processes=processes;
    }
    
    public WebPage getPagina(){
        return this.page;
    }
    
    public Procces[] getProcesses(){
        return this.processes;
    }
}
