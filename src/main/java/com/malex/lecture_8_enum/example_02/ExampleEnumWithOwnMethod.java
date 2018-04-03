package com.malex.lecture_8_enum.example_02;

/**
 * Example Enum with own method
 *
 * @author malex
 */
public class ExampleEnumWithOwnMethod {

    public static void main(String[] args) {
        Direction down = Direction.DOWN;
        down.opposite();

        down = Direction.UP;
        down.opposite();
    }

    enum Direction {
        UP {
            public void opposite() {
                System.out.println(" UP  <<<<<<<<<<<<<<<<<<");
            }
        },
        DOWN {
            public void opposite() {
                System.out.println(" DOWN  >>>>>>>>>>>>>>");
            }
        };

        public abstract void opposite();
    }
}
