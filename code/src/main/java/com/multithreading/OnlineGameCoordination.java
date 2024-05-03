package com.multithreading;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class OnlineGameCoordination {

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    AtomicInteger atomicInteger = new AtomicInteger();
    OnlineGameOperator gameOperator = new OnlineGameOperator();
    while(true) {
      executorService.execute(() -> {
        final int index = atomicInteger.getAndIncrement();
        new OnlinePlayer("Player" + index, Level.easy, gameOperator).sendJoinRequest();
      });
    }
  }
}

class OnlineGameOperator {
  ConcurrentLinkedQueue<OnlinePlayer> queue = new ConcurrentLinkedQueue<>();

  public OnlineGameOperator() {
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    executorService.scheduleAtFixedRate(() -> {
      if(queue.size()>1) {
        OnlinePlayer p1 = queue.poll();
        OnlinePlayer p2 = queue.poll();
        System.out.println(p1.name +" vs "+ p2.name);
      }
    }, 5, 10, TimeUnit.MILLISECONDS);
  }

  public void add(OnlinePlayer player) {
    queue.add(player);
  }
}

class OnlinePlayer {
  String name;
  Level level;
  OnlineGameOperator gameOperator;

  public OnlinePlayer(String name, Level level, OnlineGameOperator gameOperator) {
    this.name = name;
    this.level = level;
    this.gameOperator = gameOperator;
  }

  public Level getLevel() {
    return level;
  }

  public void setLevel(Level level) {
    this.level = level;
  }

  public void sendJoinRequest() {
    gameOperator.add(this);
  }
}

enum Level {
  easy,
  moderate,
  hard
}