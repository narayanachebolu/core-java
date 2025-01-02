package org.com.java8.challenges.simple;

import java.text.DecimalFormat;

// example to show how to find available runtime memory in Java.
public class MemoryUtil {

    public static void main(String[] args) {
        String memoryInfo = getMemoryInfo();
        System.out.println(memoryInfo);
    }

    private static String getMemoryInfo() {
        long freeMemory = Runtime.getRuntime().freeMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();

        return "Memory available: " + formatMemoryValue(freeMemory) + " / " + formatMemoryValue(totalMemory);
    }

    private static String formatMemoryValue(long size) {
        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
        // Dividing the log of the size by the log of 1024 effectively determines how many times 1024 fits into the
        // size, giving us the correct index for our units array.
        System.out.println(Math.log10(size) + ".." + Math.log10(1024));
        int unitIndex = (int) (Math.log10(size) / Math.log10(1024));
        System.out.println("Unit Index: " + unitIndex);
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.#");
        String formattedValue = decimalFormat.format(size / Math.pow(1024, unitIndex));

        return formattedValue + " " + units[unitIndex];
    }
}
