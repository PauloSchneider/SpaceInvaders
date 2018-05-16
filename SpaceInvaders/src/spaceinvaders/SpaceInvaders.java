/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

/**
 *
 * @author Lucas
 */
public class SpaceInvaders {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Local que fica os inimigos
        Inimigo[] meusmonstros = new Inimigo[12];
        //Local que fica os tiros
        Tiro[] meustiros = new Tiro[100];
        //Quantidade de tiros na tela
        int quantidadeTiros = 0;
        int quantidadeMonst = 12;
        int posTiro = 76;

        //Crio os monstros na tela
        meusmonstros[0] = new Inimigo(2, 5, 1);
        meusmonstros[1] = new Inimigo(15, 5, 1);
        meusmonstros[2] = new Inimigo(28, 5, 1);
        meusmonstros[3] = new Inimigo(41, 5, 1);
        meusmonstros[4] = new Inimigo(54, 5, 1);
        meusmonstros[5] = new Inimigo(67, 5, 1);
        meusmonstros[6] = new Inimigo(2, 15, 1);
        meusmonstros[7] = new Inimigo(15, 15, 1);
        meusmonstros[8] = new Inimigo(28, 15, 1);
        meusmonstros[9] = new Inimigo(41, 15, 1);
        meusmonstros[10] = new Inimigo(54, 15, 1);
        meusmonstros[11] = new Inimigo(67, 15, 1);
        //Inicia o jogo
        Space.init();

        for (int i = 0; i < 55; i++) {
            //Move os bonecos
            for (int j = 0; j < 12; j++) {
                meusmonstros[j].setY(meusmonstros[j].getY() + 1);
                if (meusmonstros[j].getY() == 70) {
                    Space.gameOver();

                }
            }

            //Verifica tiros
            for (int t = 0; t < quantidadeTiros; t++) {
                meustiros[t].y = meustiros[t].y - 1;
            }

            for (int k = 0; k < 12; k++) {
                for (int p = 0; p < quantidadeTiros; p++) {
                    System.out.println("monstro "+k+" x = "+meusmonstros[k].getX());
                    
                    if ((meustiros[p].x >= meusmonstros[k].getX()-1 && meustiros[p].x <= meusmonstros[k].getX()+11) && (meustiros[p].y >= meusmonstros[k].getY() && meustiros[p].y <= meusmonstros[k].getY()+8)) {
                        meusmonstros[k].vida--;
                    }
                    if (meusmonstros[k].vida == 0) {
                        meusmonstros[k].x = -10;
                        meusmonstros[k].y = 100;
                    } 
                }
                
            }

            System.out.println(Space.getPlatX());
            if (Space.apertouDireita()) {
                if (Space.getPlatX() < 75) {
                    Space.setPlatX(Space.getPlatX() + 1);
                }
            }
            System.out.println(Space.getPlatX());
            if (Space.apertouEsquerda()) {
                if (Space.getPlatX() > 1) {
                    Space.setPlatX(Space.getPlatX() - 1);
                }
            }
            if (Space.apertouEspaco()) {
                meustiros[quantidadeTiros] = new Tiro(Space.getPlatX(), posTiro);
                quantidadeTiros++;
            }

            if (quantidadeMonst == 0) {
                Space.ganhou();
                break;
            }

            //Atualiza a tela
            Space.desenha(meusmonstros, quantidadeMonst, meustiros, quantidadeTiros);
        }

    }
}
