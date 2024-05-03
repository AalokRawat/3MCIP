package design.snake;

import java.util.Deque;
import java.util.LinkedList;

public class Snake {
    private final Deque<int[]> deque = new LinkedList();
    private final Cell[][] cells;
    private Direction direction;

    public Snake(Cell[][] cells) {
        this.cells = cells;

        deque.addFirst(new int[]{0, 0});
        this.cells[0][0].cellType = CellType.SNAKE;

        direction = Direction.RIGHT;
    }

    public int[] move() throws HitTheBorderException {
        int[] loc = deque.peekFirst();
        loc = moveForward(loc);
        try {
            deque.addFirst(loc);
            cells[loc[0]][loc[1]].cellType = CellType.SNAKE;

            if(cells[loc[0]][loc[1]].cellType!=CellType.FOOD) {
                int[] remLoc = deque.removeLast();
                cells[remLoc[0]][remLoc[1]].cellType = CellType.EMPTY;
            }
        } catch (Exception e) {
            throw new HitTheBorderException();
        }

        return loc;
    }

    private int[] moveForward(int[] loc) {
        int i = loc[0];
        int j = loc[1];
        switch (this.direction) {
            case UP:
                i--;
                break;
            case DOWN:
                i++;
                break;
            case LEFT:
                j--;
                break;
            case RIGHT:
                j++;
                break;
        }
        return new int[]{i, j};
    }

    public void change(Direction direction) {
        this.direction = direction;
    }

}
