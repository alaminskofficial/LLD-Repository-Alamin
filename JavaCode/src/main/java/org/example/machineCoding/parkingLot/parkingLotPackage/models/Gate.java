package org.example.machineCoding.parkingLot.models;

public class Gate {
    private Long number;
    private GateType gateType;
    private Operator operator;
    private GateStatus gateStatus;

    public Gate(Long number, GateType gateType, GateStatus gateStatus) {
        this.number = number;
        this.gateType = gateType;
        this.gateStatus = gateStatus;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }
}
