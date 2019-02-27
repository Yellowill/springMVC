package com.allianz.pa.entity;

import java.util.Date;

public class WipPrlPartPlanFlights extends WipPrlPartPlanFlightsKey {
    private String actionCode;

    private Integer versionNo;

    private Long objectId;

    private String topIndicator;

    private Integer previousVersion;

    private Integer reversingVersion;

    private String flightCode;

    private String flightNo;

    private Short planId;

    private Short planVersionNo;

    private String departureAirportCode;

    private String arrivalAirportCode;

    private Date departureDateDate;

    private Date arrivalDateDate;

    private String travelCode;

    private String departureAirportName;

    private String arrivalAirportName;

    private String flightCompany;

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode == null ? null : actionCode.trim();
    }

    public Integer getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(Integer versionNo) {
        this.versionNo = versionNo;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getTopIndicator() {
        return topIndicator;
    }

    public void setTopIndicator(String topIndicator) {
        this.topIndicator = topIndicator == null ? null : topIndicator.trim();
    }

    public Integer getPreviousVersion() {
        return previousVersion;
    }

    public void setPreviousVersion(Integer previousVersion) {
        this.previousVersion = previousVersion;
    }

    public Integer getReversingVersion() {
        return reversingVersion;
    }

    public void setReversingVersion(Integer reversingVersion) {
        this.reversingVersion = reversingVersion;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode == null ? null : flightCode.trim();
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo == null ? null : flightNo.trim();
    }

    public Short getPlanId() {
        return planId;
    }

    public void setPlanId(Short planId) {
        this.planId = planId;
    }

    public Short getPlanVersionNo() {
        return planVersionNo;
    }

    public void setPlanVersionNo(Short planVersionNo) {
        this.planVersionNo = planVersionNo;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode == null ? null : departureAirportCode.trim();
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode == null ? null : arrivalAirportCode.trim();
    }

    public Date getDepartureDateDate() {
        return departureDateDate;
    }

    public void setDepartureDateDate(Date departureDateDate) {
        this.departureDateDate = departureDateDate;
    }

    public Date getArrivalDateDate() {
        return arrivalDateDate;
    }

    public void setArrivalDateDate(Date arrivalDateDate) {
        this.arrivalDateDate = arrivalDateDate;
    }

    public String getTravelCode() {
        return travelCode;
    }

    public void setTravelCode(String travelCode) {
        this.travelCode = travelCode == null ? null : travelCode.trim();
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(String departureAirportName) {
        this.departureAirportName = departureAirportName == null ? null : departureAirportName.trim();
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName == null ? null : arrivalAirportName.trim();
    }

    public String getFlightCompany() {
        return flightCompany;
    }

    public void setFlightCompany(String flightCompany) {
        this.flightCompany = flightCompany == null ? null : flightCompany.trim();
    }
}