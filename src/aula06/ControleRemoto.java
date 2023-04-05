package aula06;

public class ControleRemoto implements Controlador {
    // Atributos
    private int volume;
    private boolean ligado;
    private boolean tocando;
    
    //Métodos Especiais

    public ControleRemoto() {
        this.volume = 50;
        this.ligado = true;
        this.tocando = false;
    }

    private int getVolume() {
        return volume;
    }

    private void setVolume(int volume) {
        this.volume = volume;
    }

    private boolean getLigado() {
        return ligado;
    }

    private void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    private boolean getTocando() {
        return tocando;
    }

    private void setTocando(boolean tocando) {
        this.tocando = tocando;
    }
    // Métodos Abstratos

    @Override
    public void ligar() {
        this.setLigado(true);
    }

    @Override
    public void desligar() {
        this.setLigado(false);
        if(this.getLigado() == false){           
        }
    }

    @Override
    public void abrirMenu() {
        System.out.println("---- MENU ----");
        System.out.println("Está ligado? " + this.getLigado());
        System.out.println("Está tocando? " + this.getTocando());
        System.out.print("Volume: " + this.getVolume() + " ");
        for (int i = 0; i <= this.getVolume(); i+=10){
            System.out.print("|");
        }
    }

    @Override
    public void fecharMenu() {
        System.out.println(" ");
        System.out.println("Fechando Menu...");
    }

    @Override
    public void maisVolume() {
        if (this.getLigado()== true){
            this.setVolume(this.getVolume() + 5 );
        } else{
            System.out.println("Impossível aumentar volume, controle desligado.");
        }
    }
    
    @Override
    public void menosVolume(){
        if(this.getLigado() == true){
            this.setVolume(this.getVolume() - 5);
        } else{
            System.out.println("Impossível diminuir volume, controle desligado.");
        }
    }

    @Override
    public void ligarMudo() {
        if (this.getLigado() == true && this.getVolume() > 0){
            this.setVolume(0);            
        }
    }

    @Override
    public void desligarMudo() {
        if(this.getLigado() == true && this.getVolume() == 0){
          this.setVolume(50);            
        }
    }

    @Override
    public void play() {
        if(this.getLigado() == true && this.getTocando() == false){
            this.setTocando(true);
        }else{
            System.out.println("Controle desligado, impossível reproduzir.");
        }
    }

    @Override
    public void pause() {
        if(this.getLigado() == true && getTocando() == true){
            this.setTocando(false);  
        } else{
            System.out.println("Controle desligado, impossível pausar.");
        }
    }
    
            
}
