package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }


    public int round(String name1, String name2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : players) {
            if (player.getName().equals(name1)) {
                player1 = player;
            }
            if (player.getName().equals(name2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException(
                    "This player doesn't exists"
            );
        }
        if (player2 == null) {
            throw new NotRegisteredException(
                    "This player doesn't exists"
            );
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return -1;
        }
        return 0;
    }
}
