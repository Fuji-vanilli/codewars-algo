package org.example.humanReadableDurationFormat;

/**
 * Your task in order to complete this Kata is to write a function which formats a duration,
 * given as a number of seconds, in a human-friendly way.

 * The function must accept a non-negative integer. If it is zero, it just returns "now".
 * Otherwise, the duration is expressed as a combination of years, days, hours, minutes and seconds.
 * * For seconds = 62, your function should return
 *     "1 minute and 2 seconds"
 * * For seconds = 3662, your function should return
 *     "1 hour, 1 minute and 2 seconds"
 */
public class TimeFormatter {

    public static String formatDuration(int seconds) {
        if (seconds == 0) {
            return "now";
        }

        int[] timeUnits = { 365 * 24 * 60 * 60, 24 * 60 * 60, 60 * 60, 60, 1 };
        String[] unitNames = { "year", "day", "hour", "minute", "second" };

        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < timeUnits.length; i++) {
            if (seconds >= timeUnits[i]) {
                count = seconds / timeUnits[i];
                seconds %= timeUnits[i];

                if (sb.length() > 0) {
                    sb.append(", ");
                }

                sb.append(count).append(" ").append(unitNames[i]);
                if (count > 1) {
                    sb.append("s");
                }
            }
        }

        if (sb.length() > 1) {
            int lastIndex = sb.lastIndexOf(",");
            if (lastIndex != -1) {
                sb.replace(lastIndex, lastIndex + 1, " and");
            }
        }

        return sb.toString();
    }

}