package com.heyi.netty.smartiot.decoder;

public class HeartBeat {
    /**
     * 数据包启动符号 @@
     */
    public static byte START = 104;

    /**
     * 设备号
     */
    private int deviceid;
    /**
     * 设备类型
     */
    private byte deviceType;

    /**
     * 厂商代码
     */
    private byte vendorCode;
    /**
     * 功能码
     */
    private byte functionCode;

    /**
     * 数据长度
     */
    private byte dataLength;
    /**
     * 校验位
     */
    private byte cs;
    /**
     * 结束
     */
    public static byte end = 22;

    public static byte getSTART() {
        return START;
    }

    public static void setSTART(byte START) {
        HeartBeat.START = START;
    }

    public int getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(int deviceid) {
        this.deviceid = deviceid;
    }

    public byte getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(byte deviceType) {
        this.deviceType = deviceType;
    }

    public byte getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(byte vendorCode) {
        this.vendorCode = vendorCode;
    }

    public byte getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(byte functionCode) {
        this.functionCode = functionCode;
    }

    public byte getDataLength() {
        return dataLength;
    }

    public void setDataLength(byte dataLength) {
        this.dataLength = dataLength;
    }

    public byte getCs() {
        return cs;
    }

    public void setCs(byte cs) {
        this.cs = cs;
    }

    public static byte getEnd() {
        return end;
    }

    public static void setEnd(byte end) {
        HeartBeat.end = end;
    }
}
