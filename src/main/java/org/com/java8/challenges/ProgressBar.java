package org.com.java8.challenges;

public class ProgressBar {
    public static void main(String[] args) throws InterruptedException {
        long total = 108000000; // total bytes
        long current = 0;

        while (current <= total) {
            printProgress(current, total);
            Thread.sleep(50); // simulate work
            current += 1500000; // simulate progress
        }
        System.out.println(); // move to next line when done.
    }

    /**
     * How this works
     * 1) \r → moves the cursor to the start of the current line, so we overwrite instead of printing a new line.
     * 2) .repeat() → Java 11 method to repeat a character N times.
     * 3) Formatting → we use String.format to align MB values and percentages neatly.
     * 4) Simulation → Thread.sleep() + increment simulate data being downloaded.
     * 
     * @param current
     * @param total
     */
    private static void printProgress(long current, long total) {
        int barLength = 30; // total length of the bar in characters
        double progress = (double) current / total;
        int filledLength = (int) (progress * barLength);

        String bar = "[" + "=".repeat(filledLength) + (filledLength < barLength ? ">" : "")
                + " ".repeat(barLength - filledLength) + "]";

        String progressText = String.format("\rKafka  %6.1fMB / %6.1fMB Pulling  %s  %3.0f%%",
                current / (1024.0 * 1024), total / (1024.0 * 1024), bar, progress * 100);

        System.out.println(progressText);
    }
}
