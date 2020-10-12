package main.task3;

public class Being {
    private Position bodyPosition;

    public Being() {
        bodyPosition = Position.NATURAL;
    }

    public Being(Position bodyPosition) {
        this.bodyPosition = bodyPosition;
    }

    public void changePosition() {
        switch (bodyPosition) {
            case NATURAL:
                bodyPosition = Position.UNNATURAL;
                break;

            case UNNATURAL:
                bodyPosition = Position.NATURAL;
                break;
        }
    }

    public Position getBodyPosition() {
        return bodyPosition;
    }
}
