package com.heyi.netty.smartiot.model;


import com.sun.org.apache.bcel.internal.classfile.Code;

/**
 * 自定义协议
 *readFloat：取4字节的int内容，转换为float类型；
 * readUnsignedByte：取1字节的内容，将十六进制非数字转化为十进制(解决返回数字为负情况)
 * readInt：取4字节的内容
 * readByte：取1字节的内容
 *readFloat：取4字节的int内容，转换为float类型
 * eadUnsignedInt：取4字节的内容，将十六进制非数字转化为十进制(解决返回数字为负情况)
 * @author hzz
 * @see //www.cnblogs.com/sidesky/p/6913109.html
 */
public class SmartIotpower {

    /**
     * 协议最短长度 30 字节
     */
    public static int MIN_LEN = 10;

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
    private int dataIdentification;

    ;
    /**
     * 2个寄存器信息八个字节A相电压
     */
    private float Ua;
    /**
     * 2个寄存器信息八个字节B相电压
     */
    private float Ub;
    /**
     * 2个寄存器信息八个字节C相电压
     */
    private float Uc;
    /**
     * 数据标识2两个字节
     */
    private int dataIdentification2;
    /**
     * 寄存器个数2
     */
    private byte registersCount2;

    /**
     * AB线电压
     */
    private float Uab;
    /**
     * BC线电压
     */
    private float Ubc;
    /**
     * CA线电压
     */
    private float Uca;
    /**
     * 2个寄存器信息八个字节A相电流
     */
    private float Ia;
    /**
     * 2个寄存器信息八个字节B相电流
     */
    private float Ib;
    /**
     * 2个寄存器信息八个字节C相电流
     */
    private float Ic;
    /**
     * 2个寄存器信息八个字节零序电流
     */
    private float I0;
    /**
     * 数据标识3两个字节
     */
    private int dataIdentification3;
    /**
     * 寄存器个数3
     */
    private byte registersCount3;
    /**
     * 有功总功率
     */
    private float PT;
    /**
     * A相有功功率
     */
    private float PA;
    /**
     * B相有功功率
     */
    private float PB;
    /**
     * C相有功功率
     */
    private float PC;
    /**
     * 无功总功率
     */
    private float PTn;
    /**
     * A相无功功率
     */
    private float PAn;
    /**
     * B相无功功率
     */
    private float PBn;
    /**
     * C相无功功率
     */
    private float PCn;
    /**
     * 总视在功率
     */

    private float PTin;
    /**
     * A相视在功率
     */
    private float PAin;
    /**
     * A相视在功率
     */
    private float PBin;

    /**
     * A相视在功率
     */
    private float PCin;




    /**
     * 数据标识4
     */
    private int dataIdentification4;

    /**
     * 寄存器个数4
     */
    private byte registersCount4;

    /**
     * 总功率因数
     */
    private short PTf;
    /**
     * A相功率因数
     */
    private short PAf;
    /**
     * B相功率因数
     */
    private short PBf;
    /**
     * C相功率因数
     */
    private short PCf;
    /**
     * A相电压与电流夹角:0
     */
    private float IV_angleA;
    /**
     * B相电压与电流夹角:0
     */
    private float IV_angleB;
    /**
     * C相电压与电流夹角
     */
    private float IV_angleC;

    /**
     * A相电压夹角
     */

    private float V_angleA;
    /**
     * B相电压夹角
     */
    private float V_angleB;
    /**
     * C相电压夹角
     */
    private float V_angleC;
    /**
     * A相电流夹角
     */
    private float I_angleA;
    /**
     * B相电流夹角
     */
    private float I_angleB;
    /**
     * C相电流夹角
     */
    private float I_angleC;
    /**
     * 电网频率
     */
    private float frequency;
    /**
     * 数据标识5
     */
    private int dataIdentification5;
    /**
     * 寄存器个数5
     */
    private byte registersCount5;
    /**
     * 电压不平衡率:
     */
    private float V_rate;
    /**
     * 电流不平衡率:
     */
    private float I_rate;
    /**
     * 数据标识6
     */
    private int dataIdentification6;

    /**
     * 寄存器个数6
     */
    private byte registersCount6;


    /**
     * 电压变比
     */
    private float V_ratio;
    /**
     * 电流变比
     */
    private float I_ratio;
    /**
     * 数据标识7
     */
    private int dataIdentification7;
    /**
     * 寄存器个数7
     */
    private byte registersCount7;


    /**
     * 数据标识8
     */
    private float   dataIdentification8;
    /**
     * 寄存器个数8
     */
    private float  regitersCount8;

    /**
     * 组合有功总电能
     */
    private float CombinedActiveTotalEnergy;
    /**
     * 组合有功尖电能
     */
    private float CombinedActiveTipEnergy;
    /**
     * 组合有功峰电能
     */
    private float CombinedActivePeakEnergy;

    /**
     * 组合有功平电能
     */
    private float CombineActivePowerLeveling;


    /**
     * 组合有功谷电能
     */
    private float CombinedActiveValleyPower;
    /**
     * 正向有功总电能
     */
    private float ForwardActiveTotalElectricalEnergy;
    /**
     * 正向有功尖电能
     */
    private float PositiveActiveTipEnergy;
    /**
     * 正向有功峰电能
     */
    private float PositiveActivePeakEnergy;


    /**
     * 正向有功平电能
     */
    private float PositiveActivePowerLeveling;
    /**
     *
     */
    private float PositiveActiveValleyEnergy;
    /**
     * 反向有功总电能
     */
    private float TotalReverseActiveEnergy;
    /**
     * 反向有功尖电能:
     */
    private float ReverseActiveTip;
    /**
     * 反向有功峰电能
     */
    private float ReverseActivePeakEnergy;
    /**
     * 反向有功平电能
     */
    private float ReverseActivePowerLeveling;
    /**
     * 反向有功谷电能
     */
    private float ReverseActiveValleyPower;

    /**
     * cs检验位一个字节
     */
    public byte cs;
    /**
     * 结束符
     */
    public static byte END = 22;

    public float getDataIdentification8() {
        return dataIdentification8;
    }

    public void setDataIdentification8(float dataIdentification8) {
        this.dataIdentification8 = dataIdentification8;
    }

    public float getRegitersCount8() {
        return regitersCount8;
    }

    public void setRegitersCount8(float regitersCount8) {
        this.regitersCount8 = regitersCount8;
    }

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

    public int getDataIdentification() {
        return dataIdentification;
    }

    public void setDataIdentification(int dataIdentification) {
        this.dataIdentification = dataIdentification;
    }

    public float getUa() {
        return Ua;
    }

    public void setUa(float ua) {
        Ua = ua;
    }

    public float getUb() {
        return Ub;
    }

    public void setUb(float ub) {
        Ub = ub;
    }

    public float getUc() {
        return Uc;
    }

    public void setUc(float uc) {
        Uc = uc;
    }

    public int getDataIdentification2() {
        return dataIdentification2;
    }

    public void setDataIdentification2(int dataIdentification2) {
        this.dataIdentification2 = dataIdentification2;
    }

    public byte getRegistersCount2() {
        return registersCount2;
    }

    public void setRegistersCount2(byte registersCount2) {
        this.registersCount2 = registersCount2;
    }

    public float getIa() {
        return Ia;
    }

    public void setIa(float ia) {
        Ia = ia;
    }

    public float getIb() {
        return Ib;
    }

    public void setIb(float ib) {
        Ib = ib;
    }

    public float getIc() {
        return Ic;
    }

    public void setIc(float ic) {
        Ic = ic;
    }

    public float getI0() {
        return I0;
    }

    public void setI0(float i0) {
        I0 = i0;
    }

    public int getDataIdentification3() {
        return dataIdentification3;
    }

    public void setDataIdentification3(int dataIdentification3) {
        this.dataIdentification3 = dataIdentification3;
    }

    public byte getRegistersCount3() {
        return registersCount3;
    }

    public void setRegistersCount3(byte registersCount3) {
        this.registersCount3 = registersCount3;
    }

    public float getPT() {
        return PT;
    }

    public void setPT(float PT) {
        this.PT = PT;
    }

    public float getPA() {
        return PA;
    }

    public void setPA(float PA) {
        this.PA = PA;
    }

    public float getPB() {
        return PB;
    }

    public void setPB(float PB) {
        this.PB = PB;
    }

    public float getPC() {
        return PC;
    }

    public void setPC(float PC) {
        this.PC = PC;
    }

    public float getPTn() {
        return PTn;
    }

    public void setPTn(float PTn) {
        this.PTn = PTn;
    }

    public float getPAn() {
        return PAn;
    }

    public void setPAn(float PAn) {
        this.PAn = PAn;
    }

    public float getPBn() {
        return PBn;
    }

    public void setPBn(float PBn) {
        this.PBn = PBn;
    }

    public float getPCn() {
        return PCn;
    }

    public void setPCn(float PCn) {
        this.PCn = PCn;
    }

    public float getPTin() {
        return PTin;
    }

    public void setPTin(float PTin) {
        this.PTin = PTin;
    }

    public float getPAin() {
        return PAin;
    }

    public void setPAin(float PAin) {
        this.PAin = PAin;
    }

    public float getPBin() {
        return PBin;
    }

    public void setPBin(float PBin) {
        this.PBin = PBin;
    }

    public float getPCin() {
        return PCin;
    }

    public void setPCin(float PCin) {
        this.PCin = PCin;
    }

    public byte getCs() {
        return cs;
    }

    public void setCs(byte cs) {
        this.cs = cs;
    }

    public int getDataIdentification4() {
        return dataIdentification4;
    }

    public void setDataIdentification4(int dataIdentification4) {
        this.dataIdentification4 = dataIdentification4;
    }

    public byte getRegistersCount4() {
        return registersCount4;
    }

    public void setRegistersCount4(byte registersCount4) {
        this.registersCount4 = registersCount4;
    }

    public float getPTf() {
        return PTf;
    }

    public void setPTf(short PTf) {
        this.PTf = PTf;
    }

    public float getPAf() {
        return PAf;
    }

    public void setPAf(short PAf) {
        this.PAf = PAf;
    }

    public short getPBf() {
        return PBf;
    }

    public void setPBf(short PBf) {
        this.PBf = PBf;
    }

    public short getPCf() {
        return PCf;
    }

    public void setPCf(short PCf) {
        this.PCf = PCf;
    }

    public float getIV_angleA() {
        return IV_angleA;
    }

    public void setIV_angleA(float IV_angleA) {
        this.IV_angleA = IV_angleA;
    }

    public float getIV_angleB() {
        return IV_angleB;
    }

    public void setIV_angleB(float IV_angleB) {
        this.IV_angleB = IV_angleB;
    }

    public float getIV_angleC() {
        return IV_angleC;
    }

    public void setIV_angleC(float IV_angleC) {
        this.IV_angleC = IV_angleC;
    }

    public float getV_angleA() {
        return V_angleA;
    }

    public void setV_angleA(float v_angleA) {
        V_angleA = v_angleA;
    }

    public float getV_angleB() {
        return V_angleB;
    }

    public void setV_angleB(float v_angleB) {
        V_angleB = v_angleB;
    }

    public float getV_angleC() {
        return V_angleC;
    }

    public void setV_angleC(float v_angleC) {
        V_angleC = v_angleC;
    }

    public float getI_angleA() {
        return I_angleA;
    }

    public void setI_angleA(float i_angleA) {
        I_angleA = i_angleA;
    }

    public float getI_angleB() {
        return I_angleB;
    }

    public void setI_angleB(float i_angleB) {
        I_angleB = i_angleB;
    }

    public float getI_angleC() {
        return I_angleC;
    }

    public void setI_angleC(float i_angleC) {
        I_angleC = i_angleC;
    }

    public float getFrequency() {
        return frequency;
    }

    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    public int getDataIdentification5() {
        return dataIdentification5;
    }

    public void setDataIdentification5(int dataIdentification5) {
        this.dataIdentification5 = dataIdentification5;
    }

    public byte getRegistersCount5() {
        return registersCount5;
    }

    public void setRegistersCount5(byte registersCount5) {
        this.registersCount5 = registersCount5;
    }

    public float getV_rate() {
        return V_rate;
    }

    public void setV_rate(float v_rate) {
        V_rate = v_rate;
    }

    public float getI_rate() {
        return I_rate;
    }

    public void setI_rate(float i_rate) {
        I_rate = i_rate;
    }

    public int getDataIdentification6() {
        return dataIdentification6;
    }

    public void setDataIdentification6(int dataIdentification6) {
        this.dataIdentification6 = dataIdentification6;
    }

    public byte getRegistersCount6() {
        return registersCount6;
    }

    public void setRegistersCount6(byte registersCount6) {
        this.registersCount6 = registersCount6;
    }

    public float getV_ratio() {
        return V_ratio;
    }

    public void setV_ratio(float v_ratio) {
        V_ratio = v_ratio;
    }

    public float getI_ratio() {
        return I_ratio;
    }

    public void setI_ratio(float i_ratio) {
        I_ratio = i_ratio;
    }

    public int getDataIdentification7() {
        return dataIdentification7;
    }

    public void setDataIdentification7(int dataIdentification7) {
        this.dataIdentification7 = dataIdentification7;
    }

    public byte getRegistersCount7() {
        return registersCount7;
    }

    public void setRegistersCount7(byte registersCount7) {
        this.registersCount7 = registersCount7;
    }

    public float getCombinedActiveTotalEnergy() {
        return CombinedActiveTotalEnergy;
    }

    public void setCombinedActiveTotalEnergy(float combinedActiveTotalEnergy) {
        CombinedActiveTotalEnergy = combinedActiveTotalEnergy;
    }

    public float getCombinedActiveTipEnergy() {
        return CombinedActiveTipEnergy;
    }

    public void setCombinedActiveTipEnergy(float combinedActiveTipEnergy) {
        CombinedActiveTipEnergy = combinedActiveTipEnergy;
    }

    public float getCombinedActivePeakEnergy() {
        return CombinedActivePeakEnergy;
    }

    public void setCombinedActivePeakEnergy(float combinedActivePeakEnergy) {
        CombinedActivePeakEnergy = combinedActivePeakEnergy;
    }

    public float getCombineActivePowerLeveling() {
        return CombineActivePowerLeveling;
    }

    public void setCombineActivePowerLeveling(float combineActivePowerLeveling) {
        CombineActivePowerLeveling = combineActivePowerLeveling;
    }

    public float getCombinedActiveValleyPower() {
        return CombinedActiveValleyPower;
    }

    public void setCombinedActiveValleyPower(float combinedActiveValleyPower) {
        CombinedActiveValleyPower = combinedActiveValleyPower;
    }

    public float getForwardActiveTotalElectricalEnergy() {
        return ForwardActiveTotalElectricalEnergy;
    }

    public void setForwardActiveTotalElectricalEnergy(float forwardActiveTotalElectricalEnergy) {
        ForwardActiveTotalElectricalEnergy = forwardActiveTotalElectricalEnergy;
    }

    public float getPositiveActiveTipEnergy() {
        return PositiveActiveTipEnergy;
    }

    public void setPositiveActiveTipEnergy(float positiveActiveTipEnergy) {
        PositiveActiveTipEnergy = positiveActiveTipEnergy;
    }

    public float getPositiveActivePeakEnergy() {
        return PositiveActivePeakEnergy;
    }

    public void setPositiveActivePeakEnergy(float positiveActivePeakEnergy) {
        PositiveActivePeakEnergy = positiveActivePeakEnergy;
    }

    public float getPositiveActivePowerLeveling() {
        return PositiveActivePowerLeveling;
    }

    public void setPositiveActivePowerLeveling(float positiveActivePowerLeveling) {
        PositiveActivePowerLeveling = positiveActivePowerLeveling;
    }

    public float getPositiveActiveValleyEnergy() {
        return PositiveActiveValleyEnergy;
    }

    public void setPositiveActiveValleyEnergy(float positiveActiveValleyEnergy) {
        PositiveActiveValleyEnergy = positiveActiveValleyEnergy;
    }

    public float getTotalReverseActiveEnergy() {
        return TotalReverseActiveEnergy;
    }

    public void setTotalReverseActiveEnergy(float totalReverseActiveEnergy) {
        TotalReverseActiveEnergy = totalReverseActiveEnergy;
    }

    public float getReverseActiveTip() {
        return ReverseActiveTip;
    }

    public void setReverseActiveTip(float reverseActiveTip) {
        ReverseActiveTip = reverseActiveTip;
    }

    public float getReverseActivePeakEnergy() {
        return ReverseActivePeakEnergy;
    }

    public void setReverseActivePeakEnergy(float reverseActivePeakEnergy) {
        ReverseActivePeakEnergy = reverseActivePeakEnergy;
    }

    public float getReverseActivePowerLeveling() {
        return ReverseActivePowerLeveling;
    }

    public void setReverseActivePowerLeveling(float reverseActivePowerLeveling) {
        ReverseActivePowerLeveling = reverseActivePowerLeveling;
    }

    public float getReverseActiveValleyPower() {
        return ReverseActiveValleyPower;
    }

    public void setReverseActiveValleyPower(float reverseActiveValleyPower) {
        ReverseActiveValleyPower = reverseActiveValleyPower;
    }

    public static byte getEND() {
        return END;
    }

    public static void setEND(byte END) {
        SmartIotpower.END = END;
    }

    public float getUab() {
        return Uab;
    }

    public void setUab(float uab) {
        Uab = uab;
    }

    public float getUbc() {
        return Ubc;
    }

    public void setUbc(float ubc) {
        Ubc = ubc;
    }

    public float getUca() {
        return Uca;
    }

    public void setUca(float uca) {
        Uca = uca;
    }
    /**
     * 打印调试信息
     */
//    public void printDebugInfo(){
//        System.out.println("---------完整数据包开始------------");
//        System.out.println("|开始标志: " + printHexShort(START));
//        System.out.println("|业务流水: " + printHexShort(flowid) + "\tFlowID:" + flowid);
//        System.out.println("|协议版本: " + printHexByte(version_major) + printHexByte(version_minor));
//        System.out.println("|时间标签: " + "20" + year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second);
//        System.out.println("|源地址  : " + printHexBytes(src));
//        System.out.println("|目的地址: " + printHexBytes(dest));
//        System.out.println("|数据长度: " + data_len);
//        System.out.println("|命令字节: " + printHexByte(cmd));
//        System.out.println("|应用数据: " + printHexBytes(data));
//        System.out.println("|校验字节: " + printHexByte(checksum));
//        System.out.println("|结束标志: " + printHexShort(END));
//        System.out.println("---------------------------------");
//    }
}