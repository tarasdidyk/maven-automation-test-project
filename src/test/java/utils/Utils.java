package utils;

import java.time.LocalDateTime;

public class Utils {

    public static boolean isEnvironmentRemote() {
        String env = System.getProperty("driver");
        return env != null && env.equals("remote1");
    }

    public static void delay(int minutes, int seconds) throws IllegalArgumentException {
        if (minutes < 0 || seconds < 0) {
            throw new IllegalArgumentException("Arguments cannot be negative!");
        }
        LocalDateTime timeLimit = LocalDateTime.now().plusMinutes(minutes);
        timeLimit = timeLimit.plusSeconds(seconds);
        while (LocalDateTime.now().isBefore(timeLimit)) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
