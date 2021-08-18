package com.timetable_plan.score;

import com.timetable_plan.domain.Lesson;
import com.timetable_plan.domain.TimeTable;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.calculator.EasyScoreCalculator;

import java.util.List;

public class TimeTableEasyScoreCalculator implements EasyScoreCalculator<TimeTable,HardSoftScore> {


    @Override
    public HardSoftScore calculateScore(TimeTable timeTable) {
        List<Lesson> lessonList= timeTable.getLessonList();
        int hardScore=0;
        for (Lesson a:lessonList){
            for (Lesson b:lessonList){
                if (a.getTimeslot()!=null && a.getTimeslot().equals(b.getTimeslot())
                &&a.getId()<b.getId()){
                    if(a.getRoom()!=null&&a.getRoom().equals(b.getRoom())){
                        hardScore--;
                    }
                    if (a.getTeacher().equals(b.getTeacher())){
                        hardScore--;
                    }
                    if (a.getStudentGroup().equals(b.getStudentGroup())){
                        hardScore--;
                    }
                }
            }
        }
        int softScore=0;
        return HardSoftScore.of(hardScore,softScore
        );
    }
}
