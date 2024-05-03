package design.snake;

public enum CellType {
    EMPTY('.'),
    SNAKE('*'),
    FOOD('@');

    char value;

    CellType(char value) {
        this.value = value;
    }
}
