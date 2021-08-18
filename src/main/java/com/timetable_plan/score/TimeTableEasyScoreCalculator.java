package com.timetable_plan.score;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.calculator.EasyScoreCalculator;

public class TimeTableEasyScoreCalculator implements EasyScoreCalculator<TimeTable, HardSoftScore> {
    @Override
    public HardSoftScore calculateScore(TimeTable timeTable) {
        return null;
    }
}
