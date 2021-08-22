package com.continental.assignment.vehicle.domain;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class VehicleViolation {

    private String violationId;

    private String vehicleId;

    private boolean isViolated;

    private String description;

    private Date violationDate;

    private String penalty;

    public String getViolationId() {
        return violationId;
    }

    public void setViolationId(String violationId) {
        this.violationId = violationId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public boolean isViolated() {
        return isViolated;
    }

    public void setViolated(boolean violated) {
        isViolated = violated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getViolationDate() {
        return violationDate;
    }

    public void setViolationDate(Date violationDate) {
        this.violationDate = violationDate;
    }

    public String getPenalty() {
        return penalty;
    }

    public void setPenalty(String penalty) {
        this.penalty = penalty;
    }
}