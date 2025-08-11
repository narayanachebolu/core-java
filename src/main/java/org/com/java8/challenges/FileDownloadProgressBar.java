package org.com.java8.challenges;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class FileDownloadProgressBar {
    public static void main(String[] args) {
        // delete this file after downloading. do NOT execute the file.
        String fileURL = "https://nbg1-speed.hetzner.com/100MB.bin"; // test file.
        String savePath = "delete-this-file.bin";

        try {
            downloadFileWithProgress(fileURL, savePath);
            System.out.println("\nFile download complete: " + savePath);
        } catch (IOException iox) {
            iox.printStackTrace();
        }
    }

    /**
     * How it works
     * 1) URLConnection.getContentLengthLong() → Gets total file size for percentage calculation.
     * 2) BufferedInputStream + FileOutputStream → Reads from the internet and writes to disk.
     * 3) Progress Calculation → Updates the filled part of the bar based on (downloadedBytes / totalBytes).
     * 4) \r carriage return → Keeps printing on the same line instead of moving down.
     * 5) .repeat() → Creates the visual part of the progress bar.
     *
     * @param fileURL
     * @param savePath
     * @throws IOException
     */
    private static void downloadFileWithProgress(String fileURL, String savePath) throws IOException {
        URL url = new URL(fileURL);
        URLConnection urlConnection = url.openConnection();
        long contentLength = urlConnection.getContentLengthLong();

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
             FileOutputStream fileOutputStream = new FileOutputStream(savePath)) {
            byte[] buffer = new byte[8192];
            long downloadedBytes = 0;
            int bytesRead = 0;

            while ((bytesRead = bufferedInputStream.read(buffer, 0, buffer.length)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
                downloadedBytes += bytesRead;
                printProgress(downloadedBytes, contentLength);
            }
        }
    }

    private static void printProgress(long downloadedBytes, long contentLength) {
        int barLength = 30;
        double progress = (double) downloadedBytes / contentLength;
        int filledLength = (int) (progress * barLength);

        String bar = "["
                + "=".repeat(filledLength)
                + (filledLength < barLength ? ">" : "")
                + " ".repeat(barLength - filledLength)
                + "]";

        String progessText = String.format("\rDownloading %6.1fMB / %6.1fMB %s %3.0f%%",
                downloadedBytes / (1024.0 * 1024), contentLength / (1024.0 * 1024), bar, progress * 100);

        System.out.print(progessText);
    }
}
