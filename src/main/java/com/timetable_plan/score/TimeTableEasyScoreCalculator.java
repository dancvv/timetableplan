package com.timetable_plan.score;

import com.timetable_plan.domain.Lesson;
import com.timetable_plan.domain.TimeTable;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.calculator.EasyScoreCalculator;

public class TimeTableEasyScoreCalculator implements EasyScoreCalculator<TimeTable, HardSoftScore> {
    @Override
    public HardSoftScore calculateScore(TimeTable timeTable) {
        int hardScore = 0;
        for (Lesson a : timeTable.getLessonList()) {
            for (Lesson b : timeTable.getLessonList()) {

                // 双层,不重复,遍历
                // 硬约束: 在相同的timeslot里
                if (a.getId() < b.getId() && a.getTimeslot() != null && a.getTimeslot().equals(b.getTimeslot())) {
                    // 一间教室最多只能容纳一堂课
                    if(a.getRoom()!=null && a.getRoom().equals(b.getRoom())) {
                        hardScore--;
                    }

                    // 一个教师最多只能上一堂课
                    if(a.getTeacher().equals(b.getTeacher())) {
                        hardScore--;
                    }

                    // 一个班级的学生也只能上一节课
                    if(a.getStudentGroup().equals(b.getStudentGroup())) {
                        hardScore--;
                    }

                }
            }

        }

        int softScore = 0;
        return HardSoftScore.of(hardScore, softScore);
    }
}
