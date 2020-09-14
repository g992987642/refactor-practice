package com.twu.refactoring;

import java.util.HashMap;

/**
 * TODO
 * 事实上turnRight和turnLeft还可以合并成一个方法，但是测试中直接调用了这两个方法，就不合并了
 */
public class Direction {
    private final char direction;

    public Direction(char direction) {
        this.direction = direction;
    }


    public Direction turnRight() {
        HashMap<Character, Character> turnRightMap = createTurnRightMap();
        Character turnRightResult = turnRightMap.get(direction);
        if (turnRightResult == null) {
            throw new IllegalArgumentException();
        }
        return new Direction(turnRightResult);

    }

    public HashMap<Character, Character> createTurnRightMap() {
        HashMap<Character, Character> turnRightMap = new HashMap<>();
        turnRightMap.put('N', 'E');
        turnRightMap.put('S', 'W');
        turnRightMap.put('E', 'N');
        turnRightMap.put('W', 'S');
        return turnRightMap;
    }

    public Direction turnLeft() {
        HashMap<Character, Character> turnLeftMap = createTurnLeftMap();
        Character turnRightResult = turnLeftMap.get(direction);
        if (turnRightResult == null) {
            throw new IllegalArgumentException();
        }
        return new Direction(turnRightResult);
    }
    public HashMap<Character, Character> createTurnLeftMap() {
        HashMap<Character, Character> turnLeftMap = new HashMap<>();
        turnLeftMap.put('N', 'W');
        turnLeftMap.put('S', 'E');
        turnLeftMap.put('E', 'N');
        turnLeftMap.put('W', 'S');
        return turnLeftMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction1 = (Direction) o;

        if (direction != direction1.direction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) direction;
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}
