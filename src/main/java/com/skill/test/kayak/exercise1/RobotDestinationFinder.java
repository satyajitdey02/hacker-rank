package com.skill.test.kayak.exercise1;

public class RobotDestinationFinder {

    /**
     * <p>Find the final destination of a robot based on the movement {instructions}</p>
     * @param instructions a String containing characters L(Turn Left), R(Turn Right) or F(Go Forward)
     * @return an Array of Integers with 2 elements representing the calculated coordinates of the Robot
     */
    public Integer[] find(String instructions) {
        int x = 0, y = 0;
        double theta = 0.0;

        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'L') {
                theta = theta - 90.0;
            } else if (instructions.charAt(i) == 'R') {
                theta = theta + 90.0;
            } else {
                x = x + (int) Math.sin(Math.toRadians(theta));
                y = y + (int) Math.cos(Math.toRadians(theta));
            }
        }

        return new Integer[]{x, y};
    }
}
