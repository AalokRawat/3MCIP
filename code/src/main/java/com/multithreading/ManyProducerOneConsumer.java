package com.multithreading;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ManyProducerOneConsumer {

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executor = Executors.newFixedThreadPool(5);
    GameScheduler gameScheduler = new GameScheduler();
    AtomicInteger integer = new AtomicInteger();
    long start = System.currentTimeMillis();
    while (true) {
      executor.execute(() -> {
        Player player = new Player(gameScheduler, "Player-"+integer.getAndIncrement());
        player.joinGame();
      });

      if(System.currentTimeMillis() - start > 10) {
        Thread.sleep(2000);
        start = System.currentTimeMillis();
      }
    }
  }
}

class GameScheduler {
  private ConcurrentLinkedQueue<Player> queue = new ConcurrentLinkedQueue<>();
  private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

  public GameScheduler() {
    scheduler.scheduleAtFixedRate(() -> {
      System.out.println("Game Scheduler running.");
      while (queue.size() > 1) {
        Player p1 = queue.poll();
        Player p2 = queue.poll();
        p1.setPlayingWith(p2);
        p2.setPlayingWith(p1);
      }
    }, 10, 2000, TimeUnit.MILLISECONDS);
  }

  public void findMeAnOpponent(Player player) {
    queue.add(player);
  }

}

class Player {
  private GameScheduler gameScheduler;
  private String name;
  private Player playingWith;

  public Player(GameScheduler gameScheduler, String name) {
    this.gameScheduler = gameScheduler;
    this.name = name;
  }

  public void joinGame() {
    gameScheduler.findMeAnOpponent(this);
  }

  public String getName() {
    return name;
  }

  public void setPlayingWith(Player playingWith) {
    this.playingWith = playingWith;
    gameStarted();
  }

  public void gameStarted() {
    System.out.println(this.getName() + " playing with : " + playingWith.getName());
  }
}
