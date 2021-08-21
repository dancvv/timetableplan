package com.example.plannertime.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
@PlanningEntity
public class CloudProcess {
    private int requiredCpuPower;
    private int requiredMemory;
    private int requiredNetworkBandwidth;
    private CloudComputer cloudComputer;

    @PlanningVariable(valueRangeProviderRefs = {"computerRange"})
    public CloudComputer getCloudComputer() {
        return cloudComputer;
    }

    public void setCloudComputer(CloudComputer cloudComputer) {
        this.cloudComputer = cloudComputer;
    }

    public CloudProcess() {
    }

    public CloudProcess(int requiredCpuPower, int requiredMemory, int requiredNetworkBandwidth, CloudComputer cloudComputer) {
        this.requiredCpuPower = requiredCpuPower;
        this.requiredMemory = requiredMemory;
        this.requiredNetworkBandwidth = requiredNetworkBandwidth;
        this.cloudComputer = cloudComputer;
    }

    public int getRequiredCpuPower() {
        return requiredCpuPower;
    }

    public void setRequiredCpuPower(int requiredCpuPower) {
        this.requiredCpuPower = requiredCpuPower;
    }

    public int getRequiredMemory() {
        return requiredMemory;
    }

    public void setRequiredMemory(int requiredMemory) {
        this.requiredMemory = requiredMemory;
    }

    public int getRequiredNetworkBandwidth() {
        return requiredNetworkBandwidth;
    }

    public void setRequiredNetworkBandwidth(int requiredNetworkBandwidth) {
        this.requiredNetworkBandwidth = requiredNetworkBandwidth;
    }

    @Override
    public String toString() {
        return "CloudProcess{" +
                "requiredCpuPower=" + requiredCpuPower +
                ", requiredMemory=" + requiredMemory +
                ", requiredNetworkBandwidth=" + requiredNetworkBandwidth +
                ", cloudComputer=" + cloudComputer +
                '}';
    }
}
