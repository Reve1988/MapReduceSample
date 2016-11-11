package org.reve.common;/*
 * @(#)org.reve.common.AirlinePerformanceParser.java  2016.11.09
 *
 * Copyright 2016 NHN Corp. All rights Reserved.
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import org.apache.hadoop.io.Text;

/**
 * @author giwoong.kim
 */
public class AirlinePerformanceParser {
    private static int YEAR_INDEX = 0;
    private static int MONTH_INDEX = 1;
    private static int UNIQUE_CARRIER_INDEX = 8;
    private static int DEPARTURE_DELAY_INDEX = 15;
    private static int ARRIVE_DELAY_INDEX = 14;
    private static int DISTANCE_INDEX = 18;

    public static AirlineInfo parse(Text text) {
        try {
            String[] colums = parseCsvToArray(text.toString());

            AirlineInfo airlineInfo = new AirlineInfo(
                    parseInteger(colums, YEAR_INDEX),
                    parseInteger(colums, MONTH_INDEX),
                    parseString(colums, UNIQUE_CARRIER_INDEX),
                    isValid(colums, ARRIVE_DELAY_INDEX),
                    isValid(colums, ARRIVE_DELAY_INDEX) ? parseInteger(colums, ARRIVE_DELAY_INDEX) : 0,
                    isValid(colums, DEPARTURE_DELAY_INDEX),
                    isValid(colums, DEPARTURE_DELAY_INDEX) ? parseInteger(colums, DEPARTURE_DELAY_INDEX) : 0,
                    isValid(colums, DISTANCE_INDEX),
                    isValid(colums, DISTANCE_INDEX) ? parseInteger(colums, DISTANCE_INDEX) : 0
            );

            return airlineInfo;
        } catch (Exception e) {
            System.out.println("Error parsing a record : " + e.getMessage());
        }

        return null;
    }

    private static String[] parseCsvToArray(String text) {
        return text.split(",");
    }

    private static int parseInteger(String[] colums, int index) {
        return Integer.parseInt(colums[index]);
    }

    private static String parseString(String[] colums, int index) {
        return colums[index];
    }

    private static boolean isValid(String[] colums, int index) {
        return !colums[index].equals("NA");
    }
}
