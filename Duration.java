package lab02;

public class Duration {
    // Fields to store the number of seconds, minutes, and hours in a duration
    private int seconds;
    private int minutes;
    private int hours;

    // Class invariants:
    // 1. seconds should be in the range [0, 59]
    // 2. minutes should be in the range [0, 59]
    // 3. hours should be non-negative

    // Private helper method to normalize the field values
    private void normalize() {
        int extraMinutes = seconds / 60;
        seconds %= 60;
        minutes += extraMinutes;

        int extraHours = minutes / 60;
        minutes %= 60;
        hours += extraHours;
    }

    // Constructor with parameters for seconds, minutes, and hours
    public Duration(int seconds, int minutes, int hours) {
        if (seconds < 0 || minutes < 0 || hours < 0) {
            throw new IllegalArgumentException("Negative values are not allowed.");
        }

        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;

        // Normalize the field values
        normalize();
    }

    // Accessor method for the number of minutes
    public int getMinutes() {
        return minutes;
    }

    // Main method for testing
    public static void main(String[] args) {
        Duration duration1 = new Duration(125, 73, 1); // 1 hour 73 minutes 125 seconds
        Duration duration2 = new Duration(30, 45, 2);  // 2 hours 45 minutes 30 seconds

        // Combine durations and print the total number of minutes
        int totalMinutes = duration1.getMinutes() + duration2.getMinutes();
        System.out.println("Total minutes in both durations: " + totalMinutes);
    }
}