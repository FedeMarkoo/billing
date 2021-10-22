package com.prosegur.sol.servicebilling.view.search.resource.response.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class WorkOrderResponse {
    @JsonIgnore
    private String id;
    @NotNull
    private String servicePointCode;
    @NotNull
    private String workOrderType;
    @NotNull
    private String branchCode;
    @NotNull
    private String operationalStopType;
    @NotNull
    private String dayType;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date requestedStartTime;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date requestedEndTime;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date startTime;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date endTime;
    @NotNull
    private String nonPerformingCode;
    @NotNull
    private String nonPerformingDescription;
    @NotNull
    private String isNonPerformingBillable;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date routeDate;
    @NotNull
    private String routeNumber;
    @NotNull
    private String vehiclePlate;
    @NotNull
    private String centerStopId;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date centerStopStartTime;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date centerStopEndTime;
    @NotNull
    private String centerStopServiceQuantity;
    @NotNull
    private String servicePointStopId;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date servicePointStopStartTime;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date servicePointStopEndTime;
    @NotNull
    private String servicePointStopServiceQuantity;
    private String travelTime;
}
