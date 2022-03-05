package com.skill.test.kayak.exercise1;

import com.skill.test.kayak.exercise1.RobotDestinationFinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RobotDestinationFinderTest {

    private final RobotDestinationFinder destinationFinder = new RobotDestinationFinder();

    @Test
    @DisplayName("Find Destination when instruction is EMPTY")
    public void findRobotDestinationWhenInstructionsAreEmpty() {
        assertArrayEquals(new Integer[]{0, 0}, destinationFinder.find(""));
    }

    @Test
    @DisplayName("Find Destination when instruction is 'LFFFRFFFRRFFF'")
    public void findRobotDestinationWithNonEmptyInstruction() {
        assertArrayEquals(new Integer[]{-3, 0}, destinationFinder.find("LFFFRFFFRRFFF"));
    }
}
