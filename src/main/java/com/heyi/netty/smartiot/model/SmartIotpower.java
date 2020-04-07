package com.heyi.netty.smartiot.model;


import com.sun.org.apache.bcel.internal.classfile.Code;

/**
 * 自定义协议
 *
 * @author Administrator
 * @see https://www.cnblogs.com/sidesky/p/6913109.html
 */
public class SmartIotpower {

    /**
     * 协议最短长度 30 字节
     */
    public static int MIN_LEN = 30;

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
    private short dataLength;
    /**
     * 协议类型
     */
    private byte agreementType;
    /**
     * 年
     */
    private byte year;
    /**
     * 月
     */
    private byte month;
    /**
     * 日
     */
    private byte date;
    /**
     * 时
     */
    private byte hour;
    /**
     * 分
     */
    private byte minute;
    /**
     * 秒
     */
    private byte second;
    /**
     * 命令字节 为控制单元的命令字节
     */
    private byte modbusId;
    /**
     * 数据标识个数
     */
    private byte dataCount;
    /**
     * 寄存器个数
     */
    private byte registersCount;

    /**
     * 数据标识1
     */
    private short dataIdentification;

    ;
    /**
     * 2个寄存器信息八个字节A相电压
     */
    private long Ua;
    /**
     * 2个寄存器信息八个字节B相电压
     */
    private long Ub;
    /**
     * 2个寄存器信息八个字节C相电压
     */
    private long Uc;
    /**
     * 数据标识2两个字节
     */
    private short dataIdentification2;
    /**
     * 寄存器个数2
     */
    private byte registersCount2;

    /**
     * 2个寄存器信息八个字节A相电流
     */
    private long Ia;
    /**
     * 2个寄存器信息八个字节B相电流
     */
    private long Ib;
    /**
     * 2个寄存器信息八个字节C相电流
     */
    private long Ic;
    /**
     * 2个寄存器信息八个字节零序电流
     */
    private long I0;
    /**
     * 数据标识3两个字节
     */
    private short dataIdentification3;
    /**
     * 寄存器个数3
     */
    private byte registersCount3;
    /**
     * 有功总功率
     */
    private long PT;
    /**
     * A相有功功率
     */
    private long PA;
    /**
     * B相有功功率
     */
    private long PB;
    /**
     * C相有功功率
     */
    private long PC;
    /**
     * 无功总功率
     */
    private long PTn;
    /**
     * A相无功功率
     */
    private long PAn;
    /**
     * B相无功功率
     */
    private long PBn;
    /**
     * C相无功功率
     */
    private long PCn;
    /**
     * 总视在功率
     */

    private long PTin;
    /**
     * A相视在功率
     */
    private long PAin;
    /**
     * A相视在功率
     */
    private long PBin;

    /**
     * A相视在功率
     */
    private long PCin;




    /**
     * 数据标识4
     */
    private short dataIdentification4;

    /**
     * 寄存器个数4
     */
    private byte registersCount4;

    /**
     * 总功率因数
     */
    private long PTf;
    /**
     * A相功率因数
     */
    private long PAf;
    /**
     * B相功率因数
     */
    private long PBf;
    /**
     * C相功率因数
     */
    private long PCf;
    /**
     * A相电压与电流夹角:0
     */
    private long IV_angleA;
    /**
     * B相电压与电流夹角:0
     */
    private long IV_angleB;
    /**
     * C相电压与电流夹角
     */
    private long IV_angleC;

    /**
     * A相电压夹角
     */

    private long V_angleA;
    /**
     * B相电压夹角
     */
    private long V_angleB;
    /**
     * C相电压夹角
     */
    private long V_angleC;
    /**
     * A相电流夹角
     */
    private long I_angleA;
    /**
     * B相电流夹角
     */
    private long I_angleB;
    /**
     * C相电流夹角
     */
    private long I_angleC;
    /**
     * 电网频率
     */
    private long frequency;
    /**
     * 数据标识5
     */
    private short dataIdentification5;
    /**
     * 寄存器个数5
     */
    private byte registersCount5;
    /**
     * 电压不平衡率:
     */
    private long V_rate;
    /**
     * 电流不平衡率:
     */
    private long I_rate;
    /**
     * 数据标识6
     */
    private short dataIdentification6;

    /**
     * 寄存器个数6
     */
    private byte registersCount6;


    /**
     * 电压变比
     */
    private long V_ratio;
    /**
     * 电流变比
     */
    private long I_ratio;
    /**
     * 数据标识7
     */
    private short dataIdentification7;
    /**
     * 寄存器个数7
     */
    private byte registersCount7;

    /**
     * 组合有功总电能
     */
    private long CombinedActiveTotalEnergy;
    /**
     * 组合有功尖电能
     */
    private long CombinedActiveTipEnergy;
    /**
     * 组合有功峰电能
     */
    private long CombinedActivePeakEnergy;

    /**
     * 组合有功平电能
     */
    private long CombineActivePowerLeveling;


    /**
     * 组合有功谷电能
     */
    private long CombinedActiveValleyPower;
    /**
     * 正向有功总电能
     */
    private long ForwardActiveTotalElectricalEnergy;
    /**
     * 正向有功尖电能
     */
    private long PositiveActiveTipEnergy;
    /**
     * 正向有功峰电能
     */
    private long PositiveActivePeakEnergy;


    /**
     * 正向有功平电能
     */
    private long PositiveActivePowerLeveling;
    /**
     *
     */
    private long PositiveActiveValleyEnergy;
    /**
     * 反向有功总电能
     */
    private long TotalReverseActiveEnergy;
    /**
     * 反向有功尖电能:
     */
    private long ReverseActiveTip;
    /**
     * 反向有功峰电能
     */
    private long ReverseActivePeakEnergy;
    /**
     * 反向有功平电能
     */
    private long ReverseActivePowerLeveling;
    /**
     * 反向有功谷电能
     */
    private long ReverseActiveValleyPower;

    /**
     * cs检验位一个字节
     */
    public byte cs;
    /**
     * 结束符
     */
    public static byte END = 22;

    /**
     * 打印调试信息
     */
/*    public void printDebugInfo(){
        System.out.println("---------完整数据包开始------------");
        System.out.println("|开始标志: " + printHexShort(START));
        System.out.println("|业务流水: " + printHexShort(flowid) + "\tFlowID:" + flowid);
        System.out.println("|协议版本: " + printHexByte(version_major) + printHexByte(version_minor));
        System.out.println("|时间标签: " + "20" + year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second);
        System.out.println("|源地址  : " + printHexBytes(src));
        System.out.println("|目的地址: " + printHexBytes(dest));
        System.out.println("|数据长度: " + data_len);
        System.out.println("|命令字节: " + printHexByte(cmd));
        System.out.println("|应用数据: " + printHexBytes(data));
        System.out.println("|校验字节: " + printHexByte(checksum));
        System.out.println("|结束标志: " + printHexShort(END));
        System.out.println("---------------------------------");
    }*/
    private String printHexByte(byte b) {
        return String.format("%02X", b);
    }

    private String printHexBytes(byte[] bytes) {
        String str = "";
        for (int i = 0; i < bytes.length; i++) {
            str += String.format("%02X", bytes[i]);
        }
        return str;
    }

    private String printHexShort(int s) {
        byte[] bytes = hexShort(s);
        return printHexBytes(bytes);
    }

    private byte[] hexShort(int s) {
        byte[] bytes = new byte[2];
        bytes[0] = (byte) ((s << 24) >> 24);
        bytes[1] = (byte) ((s << 16) >> 24);
        return bytes;
    }

    private byte[] hexInt(int n) {
        byte[] bytes = new byte[4];
        bytes[3] = (byte) ((n) >> 24);
        bytes[2] = (byte) ((n << 8) >> 24);
        bytes[1] = (byte) ((n << 16) >> 24);
        bytes[0] = (byte) ((n << 24) >> 24);
        return bytes;
    }

    public static int getMinLen() {
        return MIN_LEN;
    }

    public static void setMinLen(int minLen) {
        MIN_LEN = minLen;
    }

    public static byte getSTART() {
        return START;
    }

    public static void setSTART(byte START) {
        SmartIotpower.START = START;
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

    public short getDataLength() {
        return dataLength;
    }

    public void setDataLength(short dataLength) {
        this.dataLength = dataLength;
    }

    public byte getAgreementType() {
        return agreementType;
    }

    public void setAgreementType(byte agreementType) {
        this.agreementType = agreementType;
    }

    public byte getYear() {
        return year;
    }

    public void setYear(byte year) {
        this.year = year;
    }

    public byte getMonth() {
        return month;
    }

    public void setMonth(byte month) {
        this.month = month;
    }

    public byte getDate() {
        return date;
    }

    public void setDate(byte date) {
        this.date = date;
    }

    public byte getHour() {
        return hour;
    }

    public void setHour(byte hour) {
        this.hour = hour;
    }

    public byte getMinute() {
        return minute;
    }

    public void setMinute(byte minute) {
        this.minute = minute;
    }

    public byte getSecond() {
        return second;
    }

    public void setSecond(byte second) {
        this.second = second;
    }

    public byte getModbusId() {
        return modbusId;
    }

    public void setModbusId(byte modbusId) {
        this.modbusId = modbusId;
    }

    public byte getDataCount() {
        return dataCount;
    }

    public void setDataCount(byte dataCount) {
        this.dataCount = dataCount;
    }

    public byte getRegistersCount() {
        return registersCount;
    }

    public void setRegistersCount(byte registersCount) {
        this.registersCount = registersCount;
    }

    public short getDataIdentification() {
        return dataIdentification;
    }

    public void setDataIdentification(short dataIdentification) {
        this.dataIdentification = dataIdentification;
    }

    public long getUa() {
        return Ua;
    }

    public void setUa(long ua) {
        Ua = ua;
    }

    public long getUb() {
        return Ub;
    }

    public void setUb(long ub) {
        Ub = ub;
    }

    public long getUc() {
        return Uc;
    }

    public void setUc(long uc) {
        Uc = uc;
    }

    public short getDataIdentification2() {
        return dataIdentification2;
    }

    public void setDataIdentification2(short dataIdentification2) {
        this.dataIdentification2 = dataIdentification2;
    }

    public byte getRegistersCount2() {
        return registersCount2;
    }

    public void setRegistersCount2(byte registersCount2) {
        this.registersCount2 = registersCount2;
    }

    public long getIa() {
        return Ia;
    }

    public void setIa(long ia) {
        Ia = ia;
    }

    public long getIb() {
        return Ib;
    }

    public void setIb(long ib) {
        Ib = ib;
    }

    public long getIc() {
        return Ic;
    }

    public void setIc(long ic) {
        Ic = ic;
    }

    public long getI0() {
        return I0;
    }

    public void setI0(long i0) {
        I0 = i0;
    }

    public short getDataIdentification3() {
        return dataIdentification3;
    }

    public void setDataIdentification3(short dataIdentification3) {
        this.dataIdentification3 = dataIdentification3;
    }

    public byte getRegistersCount3() {
        return registersCount3;
    }

    public void setRegistersCount3(byte registersCount3) {
        this.registersCount3 = registersCount3;
    }

    public long getPT() {
        return PT;
    }

    public void setPT(long PT) {
        this.PT = PT;
    }

    public long getPA() {
        return PA;
    }

    public void setPA(long PA) {
        this.PA = PA;
    }

    public long getPB() {
        return PB;
    }

    public void setPB(long PB) {
        this.PB = PB;
    }

    public long getPC() {
        return PC;
    }

    public void setPC(long PC) {
        this.PC = PC;
    }

    public long getPTn() {
        return PTn;
    }

    public void setPTn(long PTn) {
        this.PTn = PTn;
    }

    public long getPAn() {
        return PAn;
    }

    public void setPAn(long PAn) {
        this.PAn = PAn;
    }

    public long getPBn() {
        return PBn;
    }

    public void setPBn(long PBn) {
        this.PBn = PBn;
    }

    public long getPCn() {
        return PCn;
    }

    public void setPCn(long PCn) {
        this.PCn = PCn;
    }

    public long getPTin() {
        return PTin;
    }

    public void setPTin(long PTin) {
        this.PTin = PTin;
    }

    public long getPAin() {
        return PAin;
    }

    public void setPAin(long PAin) {
        this.PAin = PAin;
    }

    public long getPBin() {
        return PBin;
    }

    public void setPBin(long PBin) {
        this.PBin = PBin;
    }

    public long getPCin() {
        return PCin;
    }

    public void setPCin(long PCin) {
        this.PCin = PCin;
    }

    public byte getCs() {
        return cs;
    }

    public void setCs(byte cs) {
        this.cs = cs;
    }

    public short getDataIdentification4() {
        return dataIdentification4;
    }

    public void setDataIdentification4(short dataIdentification4) {
        this.dataIdentification4 = dataIdentification4;
    }

    public byte getRegistersCount4() {
        return registersCount4;
    }

    public void setRegistersCount4(byte registersCount4) {
        this.registersCount4 = registersCount4;
    }

    public long getPTf() {
        return PTf;
    }

    public void setPTf(long PTf) {
        this.PTf = PTf;
    }

    public long getPAf() {
        return PAf;
    }

    public void setPAf(long PAf) {
        this.PAf = PAf;
    }

    public long getPBf() {
        return PBf;
    }

    public void setPBf(long PBf) {
        this.PBf = PBf;
    }

    public long getPCf() {
        return PCf;
    }

    public void setPCf(long PCf) {
        this.PCf = PCf;
    }

    public long getIV_angleA() {
        return IV_angleA;
    }

    public void setIV_angleA(long IV_angleA) {
        this.IV_angleA = IV_angleA;
    }

    public long getIV_angleB() {
        return IV_angleB;
    }

    public void setIV_angleB(long IV_angleB) {
        this.IV_angleB = IV_angleB;
    }

    public long getIV_angleC() {
        return IV_angleC;
    }

    public void setIV_angleC(long IV_angleC) {
        this.IV_angleC = IV_angleC;
    }

    public long getV_angleA() {
        return V_angleA;
    }

    public void setV_angleA(long v_angleA) {
        V_angleA = v_angleA;
    }

    public long getV_angleB() {
        return V_angleB;
    }

    public void setV_angleB(long v_angleB) {
        V_angleB = v_angleB;
    }

    public long getV_angleC() {
        return V_angleC;
    }

    public void setV_angleC(long v_angleC) {
        V_angleC = v_angleC;
    }

    public long getI_angleA() {
        return I_angleA;
    }

    public void setI_angleA(long i_angleA) {
        I_angleA = i_angleA;
    }

    public long getI_angleB() {
        return I_angleB;
    }

    public void setI_angleB(long i_angleB) {
        I_angleB = i_angleB;
    }

    public long getI_angleC() {
        return I_angleC;
    }

    public void setI_angleC(long i_angleC) {
        I_angleC = i_angleC;
    }

    public long getFrequency() {
        return frequency;
    }

    public void setFrequency(long frequency) {
        this.frequency = frequency;
    }

    public short getDataIdentification5() {
        return dataIdentification5;
    }

    public void setDataIdentification5(short dataIdentification5) {
        this.dataIdentification5 = dataIdentification5;
    }

    public byte getRegistersCount5() {
        return registersCount5;
    }

    public void setRegistersCount5(byte registersCount5) {
        this.registersCount5 = registersCount5;
    }

    public long getV_rate() {
        return V_rate;
    }

    public void setV_rate(long v_rate) {
        V_rate = v_rate;
    }

    public long getI_rate() {
        return I_rate;
    }

    public void setI_rate(long i_rate) {
        I_rate = i_rate;
    }

    public short getDataIdentification6() {
        return dataIdentification6;
    }

    public void setDataIdentification6(short dataIdentification6) {
        this.dataIdentification6 = dataIdentification6;
    }

    public byte getRegistersCount6() {
        return registersCount6;
    }

    public void setRegistersCount6(byte registersCount6) {
        this.registersCount6 = registersCount6;
    }

    public long getV_ratio() {
        return V_ratio;
    }

    public void setV_ratio(long v_ratio) {
        V_ratio = v_ratio;
    }

    public long getI_ratio() {
        return I_ratio;
    }

    public void setI_ratio(long i_ratio) {
        I_ratio = i_ratio;
    }

    public short getDataIdentification7() {
        return dataIdentification7;
    }

    public void setDataIdentification7(short dataIdentification7) {
        this.dataIdentification7 = dataIdentification7;
    }

    public byte getRegistersCount7() {
        return registersCount7;
    }

    public void setRegistersCount7(byte registersCount7) {
        this.registersCount7 = registersCount7;
    }

    public long getCombinedActiveTotalEnergy() {
        return CombinedActiveTotalEnergy;
    }

    public void setCombinedActiveTotalEnergy(long combinedActiveTotalEnergy) {
        CombinedActiveTotalEnergy = combinedActiveTotalEnergy;
    }

    public long getCombinedActiveTipEnergy() {
        return CombinedActiveTipEnergy;
    }

    public void setCombinedActiveTipEnergy(long combinedActiveTipEnergy) {
        CombinedActiveTipEnergy = combinedActiveTipEnergy;
    }

    public long getCombinedActivePeakEnergy() {
        return CombinedActivePeakEnergy;
    }

    public void setCombinedActivePeakEnergy(long combinedActivePeakEnergy) {
        CombinedActivePeakEnergy = combinedActivePeakEnergy;
    }

    public long getCombineActivePowerLeveling() {
        return CombineActivePowerLeveling;
    }

    public void setCombineActivePowerLeveling(long combineActivePowerLeveling) {
        CombineActivePowerLeveling = combineActivePowerLeveling;
    }

    public long getCombinedActiveValleyPower() {
        return CombinedActiveValleyPower;
    }

    public void setCombinedActiveValleyPower(long combinedActiveValleyPower) {
        CombinedActiveValleyPower = combinedActiveValleyPower;
    }

    public long getForwardActiveTotalElectricalEnergy() {
        return ForwardActiveTotalElectricalEnergy;
    }

    public void setForwardActiveTotalElectricalEnergy(long forwardActiveTotalElectricalEnergy) {
        ForwardActiveTotalElectricalEnergy = forwardActiveTotalElectricalEnergy;
    }

    public long getPositiveActiveTipEnergy() {
        return PositiveActiveTipEnergy;
    }

    public void setPositiveActiveTipEnergy(long positiveActiveTipEnergy) {
        PositiveActiveTipEnergy = positiveActiveTipEnergy;
    }

    public long getPositiveActivePeakEnergy() {
        return PositiveActivePeakEnergy;
    }

    public void setPositiveActivePeakEnergy(long positiveActivePeakEnergy) {
        PositiveActivePeakEnergy = positiveActivePeakEnergy;
    }

    public long getPositiveActivePowerLeveling() {
        return PositiveActivePowerLeveling;
    }

    public void setPositiveActivePowerLeveling(long positiveActivePowerLeveling) {
        PositiveActivePowerLeveling = positiveActivePowerLeveling;
    }

    public long getPositiveActiveValleyEnergy() {
        return PositiveActiveValleyEnergy;
    }

    public void setPositiveActiveValleyEnergy(long positiveActiveValleyEnergy) {
        PositiveActiveValleyEnergy = positiveActiveValleyEnergy;
    }

    public long getTotalReverseActiveEnergy() {
        return TotalReverseActiveEnergy;
    }

    public void setTotalReverseActiveEnergy(long totalReverseActiveEnergy) {
        TotalReverseActiveEnergy = totalReverseActiveEnergy;
    }

    public long getReverseActiveTip() {
        return ReverseActiveTip;
    }

    public void setReverseActiveTip(long reverseActiveTip) {
        ReverseActiveTip = reverseActiveTip;
    }

    public long getReverseActivePeakEnergy() {
        return ReverseActivePeakEnergy;
    }

    public void setReverseActivePeakEnergy(long reverseActivePeakEnergy) {
        ReverseActivePeakEnergy = reverseActivePeakEnergy;
    }

    public long getReverseActivePowerLeveling() {
        return ReverseActivePowerLeveling;
    }

    public void setReverseActivePowerLeveling(long reverseActivePowerLeveling) {
        ReverseActivePowerLeveling = reverseActivePowerLeveling;
    }

    public long getReverseActiveValleyPower() {
        return ReverseActiveValleyPower;
    }

    public void setReverseActiveValleyPower(long reverseActiveValleyPower) {
        ReverseActiveValleyPower = reverseActiveValleyPower;
    }

    public static byte getEND() {
        return END;
    }

    public static void setEND(byte END) {
        SmartIotpower.END = END;
    }
}