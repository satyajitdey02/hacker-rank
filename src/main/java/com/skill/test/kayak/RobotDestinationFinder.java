package com.skill.test.kayak;

public class RobotDestinationFinder {


    /**
     * @param instructions a String containing characters L(Turn Left), R(Turn Right) or F(Go Forward)
     * @return an Array of Integers with 2 elements represting the calculated coordinates of the Robot
     */
    public Integer[] find(String instructions) {
        int x = instructions.chars().filter(e -> e != 'F').boxed().mapToInt(e -> e == 'L' ? -1 : 1).sum();
        int y = instructions.chars().filter(e -> e == 'F').boxed().mapToInt(e -> 1).sum();

        return new Integer[]{x, y};
    }
}
