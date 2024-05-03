package design.snake;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Board {

    private final int m;
    private final int n;
    private final Cell[][] cells;
    private final Snake snake;
    private boolean isGameOver;

    private int[] foodLocation = new int[2];

    public Board(int m, int n) {
        this.m = m;
        this.n = n;

        this.cells = new Cell[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                cells[i][j] = new Cell();
            }
        }

        this.snake = new Snake(cells);
        this.foodLocation = generateFood();
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void start(){
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.execute(() ->{
            Scanner sc = new Scanner(System.in);
            while(true) {
                int[] loc;
                try {
                    loc = snake.move();
                    foodLocation = generateFood();
                } catch (HitTheBorderException e) {
                    isGameOver = true;
                    System.out.println("... Game Over ...");
                    return;
                }
                printBoard();

                if(isCrash(loc)) {
                    isGameOver = true;
                    System.out.println("... Game Over ...");
                    return;
                }
                System.out.println("Provider Direction");
                String s = sc.next();
                this.changeDirection(Direction.valueOf(s));
                //sleepForASec();
            }
        });
        service.shutdown();
    }

    private void sleepForASec() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isCrash(int[] loc) {
        int i = loc[0];
        int j = loc[1];

        return i<0||i>=m||j<0||j>=n;
    }

    private void printBoard() {
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(cells[i][j].cellType.value);
            }
            System.out.println();
        }
        System.out.println("----------------");
    }

    private int[] generateFood() {
        int i = foodLocation[0];
        int j = foodLocation[1];

        if(cells[i][j].cellType==CellType.FOOD) {
            return foodLocation;
        }

        while(cells[i][j].cellType!=CellType.EMPTY) {
            i = (int) (Math.random()*m);
            j = (int) (Math.random()*n);
        }

        cells[i][j].cellType=CellType.FOOD;
        return new int[]{i, j};
    }

    public void changeDirection(Direction direction) {
        System.out.println("Change Direction to " + direction.value);
        snake.change(direction);
    }
}
