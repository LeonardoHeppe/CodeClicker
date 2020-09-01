package com.example.codeclicker;

public class Game {
    private int ponto,valorClick,quantidadeUpgrade,programador;
    private boolean vitoria;
    private static Game instacia;
    Game(){
        ponto = 0;
        valorClick = 1;
        quantidadeUpgrade = 1;
        programador = 1;
    }
    public String getPonto(){
        return ""+ponto;
    }
    public String getValorClick(){
        return ""+valorClick;
    }
    public void setVitoria(){
        vitoria = true;
    }
    public int getValorUpgrade(){
        return (quantidadeUpgrade*100);
    }
    public int getValorProg(){
        return (100*programador);
    }
    public void contaPonto(){
        ponto = ponto+valorClick;
    }
    public void codar(){
        if(programador != 1){
        ponto = ponto + ((programador*1)*2);
        }
    }
    public void upgradeClick(){
        if(ponto>=(100*quantidadeUpgrade)){
            ponto = ponto - (100*quantidadeUpgrade);
            valorClick = (((10*quantidadeUpgrade)*1)*2);
            quantidadeUpgrade = quantidadeUpgrade + 1;
        }
    }
    public void upProgramador(){
        if(ponto>=(100*programador)){
            ponto = ponto - (100*programador);
            programador = programador + 1;
        }
    }
    public boolean validaVitoria(){
        if(ponto >= 1000){
          vitoria = true;
        }
        if (vitoria){
            vitoria = false;
            return true;
        }
        return false;
    }
    public void setInstacia(){
        instacia = null;
    }
    public static Game getInstance(){
        if(instacia == null){
            return instacia = new Game();
        }
        return instacia;
    }
}
