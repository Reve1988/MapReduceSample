/*
 * @(#)org.reve.DepartureDelayCountMapper.java  2016.11.09
 *
 * Copyright 2016 NHN Corp. All rights Reserved.
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.reve;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import org.reve.common.AirlineInfo;
import org.reve.common.AirlinePerformanceParser;

import java.io.IOException;

/**
 * @author giwoong.kim
 */
public class DepartureDelayCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    /**
     * 지연이 되었다면 1을 출력한다
     * 항상 1만 출력하기 때문에 final static으로 설정했다.
     * 출발 지연 시간을 계산하고 싶다면 지연 시간을 생성하여 반환하면 된다.
     */
    private final static IntWritable outputValue = new IntWritable(1);
    private Text outputKey = new Text();

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        AirlineInfo airlineInfo = AirlinePerformanceParser.parse(value);
        if (airlineInfo == null) {
            return;
        }

        // 출발시간 지연이 되었을 경우에만 집계를 수행한다.
        if (isDepartureDelay(airlineInfo)) {
            outputKey.set(createOutputKey(airlineInfo));
            context.write(outputKey, outputValue);
        }
    }

    private boolean isDepartureDelay(AirlineInfo airlineInfo) {
        return airlineInfo.getDepartureDelayTime() > 0;
    }

    private String createOutputKey(AirlineInfo airlineInfo) {
        return airlineInfo.getYear() + "," + airlineInfo.getMonth();
    }
}
