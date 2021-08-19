package com.example.plannertime.domain;

import lombok.Data;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.List;

@Data
@PlanningSolution  //  so OptaPlanner knows that this class contains all of the input and output data.
public class TimeTable {

    @ValueRangeProvider(id = "timeslotRange")   // 对应 @PlanningVariable下的id
    @ProblemFactCollectionProperty         // 输入 不变
    private List<Timeslot> timeslotList; // A timeslotList field with all time slots


    @ValueRangeProvider(id = "roomRange")     // 对应 @PlanningVariable下的id
    @ProblemFactCollectionProperty           // 输入 不变
    private List<Room> roomList;             // 存储所有的Room枚举情况

    /**
     * 输入时:
     * 课程信息 subject, teacher and studentGroup 需要填入;
     * timeslot and room fields 为空, timeslot and room fields 正是需要计算的.
     *
     * 输出时:
     * 输出结果存储在在Lesson的timeslot and room fields
     */
    @PlanningEntityCollectionProperty        // 输出  结果域  (在计算过程中会一直进行尝试,直到尝试到最优解)
    private List<Lesson> lessonList;

    /**
     * 输出评分质量: for example, 0hard/-5soft  (硬约束扣0分, 软约束扣了5分)
     */
    @PlanningScore
    private HardSoftScore score;

    private TimeTable() {
    }

    public TimeTable(List<Timeslot> timeslotList, List<Room> roomList,
                     List<Lesson> lessonList) {
        this.timeslotList = timeslotList;
        this.roomList = roomList;
        this.lessonList = lessonList;
    }
}

