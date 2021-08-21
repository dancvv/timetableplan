package com.example.plannertime.solver;

import com.example.plannertime.domain.CloudBalance;
import com.example.plannertime.domain.TimeTable;
import org.optaplanner.core.api.solver.SolverJob;
import org.optaplanner.core.api.solver.SolverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/cloud")
public class CloudController {
    @Autowired
    private SolverManager<CloudBalance,UUID> solverManager;
    @GetMapping("/info")
    public String messageInfo(){
        return "the controller is ok";
    }
    @PostMapping("/proceess")
    public CloudBalance solve(@RequestBody CloudBalance problem){
        UUID problemID=UUID.randomUUID();
        SolverJob<CloudBalance,UUID> solverJob = solverManager.solve(problemID,problem);
        CloudBalance solution;
        try{
            solution=solverJob.getFinalBestSolution();

        } catch (InterruptedException|ExecutionException e) {
            throw new IllegalStateException("solving failed",e);
        }
        return solution;
    }
}
