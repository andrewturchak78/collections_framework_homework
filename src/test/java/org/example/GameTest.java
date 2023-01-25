package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
     Game game = new Game();
    Player player1 = new Player(1, "Vasya", 5);
    Player player2 = new Player(2, "Petya", 2);
    Player player3 = new Player(3, "Kolya", 5);
    @Test
    public void shouldRound1() {
        game.register(player1);
        game.register(player2);
        int actual = game.round("Vasya","Petya");
        int expected = 1;
        Assertions.assertEquals(actual,expected);
    }
    @Test
    public void shouldRound2() {
        game.register(player1);
        game.register(player3);
        int actual = game.round("Vasya","Kolya");
        int expected = 0;
        Assertions.assertEquals(actual,expected);
    }
    @Test
    public void shouldRound3() {
        game.register(player2);
        game.register(player3);
        int actual = game.round("Petya", "Kolya");
        int expected = -1;
        Assertions.assertEquals(actual,expected);
    }
    @Test
    public void shouldGetException() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Vasya","Petya");
        });
    }
    @Test
    public void shouldGetException2() {
        game.register(player1);
        game.register(player3);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Danya","Sasha");
        });
    }
    @Test
    public void shouldGetException3() {
        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Vasya","Sasha");
        });
    }
}
