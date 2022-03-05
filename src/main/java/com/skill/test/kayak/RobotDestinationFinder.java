package com.skill.test.kayak;

public class RobotDestinationFinder {


    /**
     * @param instructions a String containing characters L(Turn Left), R(Turn Right) or F(Go Forward)
     * @return an Array of Integers with 2 elements representing the calculated coordinates of the Robot
     */
    public Integer[] find(String instructions) {
        return find(instructions, Turn.LEFT, Turn.RIGHT, 1);
    }

    public Integer[] find(String instructions, Turn leftDirection, Turn rightDirection, int moveForwardUnit) {
        int x = 0, y = 0;
        double theta = 0.0;

        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'L') {
                theta = theta + (leftDirection.getValue() * 90.0);
            } else if (instructions.charAt(i) == 'R') {
                theta = theta + (rightDirection.getValue() * 90.0);
            } else {//Consider instructions are valid containing characters 'L', 'R' and 'F' only
                x = x + (int) Math.sin(Math.toRadians(theta)) * moveForwardUnit;
                y = y + (int) Math.cos(Math.toRadians(theta)) * moveForwardUnit;
            }
        }

        return new Integer[]{x, y};
    }
}
