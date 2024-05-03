package design.snake;

public enum Direction {
    UP('U', 'U'),
    DOWN('D', 'D'),
    LEFT('L', 'L'),
    RIGHT('R', 'R');

    char key;
    char value;

    Direction(char key, char value) {
        this.key = key;
        this.value = value;
    }
}
