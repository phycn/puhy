package phy.jdk12;

public class SwitchDemo {
    public static void main(String[] args) {
        switchTest(Status.CLOSE);
    }

    private static void switchTest(Status status) {
        var result = switch(status) {
            case OPEN -> 1;
            case INIT -> 2;
            case CLOSE -> 3;
        };
        System.out.println(result);
    }
}

enum Status {
    OPEN, INIT, CLOSE;
}
