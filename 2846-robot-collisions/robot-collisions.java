import java.util.regex.Pattern;

class Solution {
    /* My attempt, not working but progress is there

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> remainingRobots = new ArrayList<>();
        
        // Early return if all robots in the same direction
        if (allSameDirection(directions)) {
            return Arrays.stream(healths).boxed().collect(Collectors.toList());
        }

        // Used to iterate over the difference between min and max positions
        // because if !collision in this scope, collisions will not occur 
        int[] minmax = findMinMax(positions);
        int collisionScope = minmax[1] - minmax[0];


        for (int step = 0; step < collisionScope; step++) {
            for (int robot = 0; robot < positions.length; robot++) {
                if (checkIfCollision(robot, Arrays.copyOf(positions, positions.length))) {

                }
            }
        }
        return remainingRobots;
    }

    private static boolean allSameDirection(String str) {
        return Pattern.matches("^(.)\\1*$", str);
    }

    private static int[] findMinMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return new int[]{min, max};
    }

    private static boolean checkIfcollision(int index, int[] positions) {
        Arrays.sort(positions);
        int start = 0;
        int end = positions.length;
        int middle = 0;
        while (start < end) {
            middle = (start + end) / 2;
            if (positions[middle] == positions[index]) {
                break;
            } else if (positions[middle] < positions[index]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return positions[middle] == positions[index];
    }

    private static removeRobot() {

    } */

    
    public List<Integer> survivedRobotsHealths(
        int[] positions, 
        int[] healths, 
        String directions) {
        
        int n = positions.length;
        Integer[] indices = new Integer[n];
        Stack<Integer> stack = new Stack<>();
        List<Integer> remainingRobots = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        
        Arrays.sort(indices, (index1, index2) 
            -> Integer.compare(positions[index1], positions[index2]));
        
        for (int currentIndex : indices) {
            // if the robot goes to the right, hence we put it onto the stack
            if (directions.charAt(currentIndex) == 'R') {
                stack.push(currentIndex);
            } else {
                while (!stack.isEmpty() && healths[currentIndex] > 0) {
                    // get the robot to see the collision
                    int rightGoingRobot = stack.pop();

                    if (healths[rightGoingRobot] > healths[currentIndex]) {
                        healths[rightGoingRobot] -= 1;
                        healths[currentIndex] = 0;
                        stack.push(rightGoingRobot);

                    } else if (healths[rightGoingRobot] < healths[currentIndex]) {
                        healths[rightGoingRobot] = 0;
                        healths[currentIndex] -= 1;

                    } else { //both robots destroyed
                        healths[rightGoingRobot] = 0;
                        healths[currentIndex] = 0;
                    }
                } 
            }
        }

        // Collect remaining robots
        for (int index = 0; index < n; index++) {
            if (healths[index] > 0) {
                remainingRobots.add(healths[index]);
            }
        }
        return remainingRobots;
    }
}