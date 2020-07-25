package org.academiadecodigo.battleship;

import org.academiadecodigo.battleship.server.Server;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
    }
}

/*
FLOW DO GAME
    Prompt -> abrir servidor com scanner e ficar a escuta de players.
    Multi Threading -> Dividir threads por players.
    Criar Menu player
    Ficar a espera do 2 player.
    Instanciar novo jogo com as posiçoes dos barcos iniciais definidas pelos players
    Mostrar os 2 fields para os dois players.
    Writter e reader para ler inputs dos players.
    Ganha quem partir tudo primeiro.

TODO
     Main -> Instancia novo server
     Game -> Instacia BattleField, Logica toda do jogo, se foi atingido barco, senao, se partiu  se nao.
     Menu -> Criar menu.
     Boat -> Guarda a posiçao inicial, orientaçao, estado, posiçao final
     BoatType -> ENUM com tipos de boats, e tamanho deles. // Good code
     Field -> Guarda posiçoes dos barcos de cada 1 dos players.
     Battlefield -> Instancia Field para cada jogador.
     BoatFactory -> Instancia novos barcos.
     PLayerHandler -> Runnable, guarda nome, fica a escuta de informaçao.
     Server -> Abre novo servidor numa porta e fica a escuta dos players e eventos.
     Messages -> SOUT'S DO JOGO.
 */
