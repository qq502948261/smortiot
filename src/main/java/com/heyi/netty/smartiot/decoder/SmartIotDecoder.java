package com.heyi.netty.smartiot.decoder;

import java.util.List;

import com.heyi.netty.smartiot.model.SmartIotProtocol;
import com.heyi.netty.smartiot.model.SmartIotpower;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

/**
 * 自定义协议解析
 *
 * @author Administrator
 */

public class SmartIotDecoder extends ByteToMessageDecoder {


    private static final Logger log = LoggerFactory.getLogger(SmartIotDecoder.class);

    /**
     * byte数组转化为16进制字符串
     *
     * @param arr       数组
     * @param lowerCase 转换后的字母为是否为小写 可不传默认为true
     * @return
     */
    public static String arr2HexStr(byte[] arr, boolean lowerCase) {
        return Hex.encodeHexString(arr, lowerCase);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf buffer, List<Object> out) throws Exception {
        log.info("启动解码器...");
        log.info("目前数据缓存大小: " + buffer.readableBytes());
        //byte转为byte数组,再转为16进制字符串,打印至控制台
        if (!buffer.hasArray()) {
            int len = buffer.readableBytes();
            byte[] arr = new byte[len];
            buffer.getBytes(0, arr);
            String Hex = arr2HexStr(arr, false);
            System.out.println(Hex);
        }
        System.out.println("目前数据缓存大小: " + buffer.readableBytes());
        // 刻度长度必须大于基本最小长度
        if (buffer.readableBytes() >= SmartIotProtocol.MIN_LEN) {
            log.info("符合最小长度，进行解析");
            System.out.println("符合最小长度，进行解析");
            //防止socket字节流攻击、客户端传来的数据过大，这里需要对数据进行过滤掉
            if (buffer.readableBytes() >= 4096) {
                buffer.skipBytes(buffer.readableBytes());
                return;
            }

            //记录包头开始位置
            int beginReader = 0;
            while (true) {
                beginReader = buffer.readerIndex(); //记录包头开始位置
                buffer.markReaderIndex(); //标记包头开始index
                //读取协议开始标志
                 byte start = buffer.readByte();
                if (start == SmartIotpower.START) {
                    break; //如果是开始标记，那么就结束查找
                }

                //如果找不到包头，这里要一个一个字节跳过
                buffer.resetReaderIndex();
                buffer.readByte();

                //当跳过后，如果数据包又不符合长度的，结束本次协议解析
                if (buffer.readableBytes() < SmartIotpower.MIN_LEN) {
                    return;
                }
            }
            System.out.println("进入解析........");
            int deviceid = buffer.readInt();
            System.out.println("deviceid = " + deviceid);
            byte deviceType = buffer.readByte();
            System.out.println("deviceType = " + deviceType);
            byte vendorCode = buffer.readByte();
            System.out.println("vendorCode = " + vendorCode);
            byte functionCode = buffer.readByte();
            System.out.println("functionCode = " + functionCode);
            short dataLength = buffer.readUnsignedByte();
            System.out.println("dataLength = " + dataLength);
            byte agreementType = buffer.readByte();
            System.out.println("agreementType = " + agreementType);
            byte year = buffer.readByte();
            System.out.println("year = " + year);
            byte month = buffer.readByte();
            System.out.println("month = " + month);
            byte date = buffer.readByte();
            System.out.println("date = " + date);
            byte hour = buffer.readByte();
            System.out.println("hour = " + hour);
            byte minute = buffer.readByte();
            System.out.println("minute = " + minute);
            byte second = buffer.readByte();
            System.out.println("second = " + second);
            byte modbusId = buffer.readByte();
            System.out.println("modbusId = " + modbusId);
            byte dataCount = buffer.readByte();
            System.out.println("dataCount = " + dataCount);
            int dataIdentification = buffer.readUnsignedShort();
            System.out.println("dataIdentification = " + dataIdentification);
            byte registersCount = buffer.readByte();
            System.out.println("registersCount = " + registersCount);
            float Ua = buffer.readFloat();
            System.out.println("Ua = " + Ua);
            float Ub = buffer.readFloat();
            System.out.println("Ub = " + Ub);
            float Uc = buffer.readFloat();
            System.out.println("Uc = " + Uc);
            int dataIdentification2 = buffer.readUnsignedShort();
            System.out.println("dataIdentification2 = " + dataIdentification2);
            byte registersCount2 = buffer.readByte();
            System.out.println("registersCount2 = " + registersCount2);
            float Uab = buffer.readFloat();
            System.out.println("Uab = " + Uab);
            float Ubc = buffer.readFloat();
            System.out.println("Ubc = " + Ubc);
            float Uca = buffer.readFloat();
            System.out.println("Uca = " + Uca);
            int dataIdentification3 = buffer.readUnsignedShort();
            System.out.println("dataIdentification3 = " + dataIdentification3);
            byte registersCount3 = buffer.readByte();
            System.out.println("registersCount3 = " + registersCount3);
            float Ia = buffer.readFloat();
            System.out.println("Ia = " + Ia);
            float Ib = buffer.readFloat();
            System.out.println("Ib = " + Ib);
            float Ic = buffer.readFloat();
            System.out.println("Ic = " + Ic);
            float I0 = buffer.readFloat();
            System.out.println("I0 = " + I0);
            int dataIdentification4 = buffer.readUnsignedShort();
            System.out.println("dataIdentification4 = " + dataIdentification4);
            byte registersCount4 = buffer.readByte();
            System.out.println("registersCount4 = " + registersCount4);

            float PT = buffer.readFloat();
            System.out.println("PT = " + PT);
            float PA = buffer.readFloat();
            System.out.println("PA = " + PA);
            float PB = buffer.readFloat();
            System.out.println("PB = " + PB);
            float PC = buffer.readFloat();
            System.out.println("PC = " + PC);
            float PTn = buffer.readFloat();
            System.out.println("PTn = " + PTn);
            float PAn = buffer.readFloat();
            System.out.println("PAn = " + PAn);
            float PBn = buffer.readFloat();
            System.out.println("PBn = " + PBn);
            float PCn = buffer.readFloat();
            System.out.println("PCn = " + PCn);
            float PTin = buffer.readFloat();
            System.out.println("PTin = " + PTin);
            float PAin = buffer.readFloat();
            System.out.println("PAin = " + PAin);
            float PBin = buffer.readFloat();
            System.out.println("PBin = " + PBin);
            float PCin = buffer.readFloat();
            System.out.println("PCin = " + PCin);
            int dataIdentification5 = buffer.readUnsignedShort();
            System.out.println("dataIdentification5 = " + dataIdentification5);
            byte registersCount5 = buffer.readByte();
            System.out.println("registersCount5 = " + registersCount5);
            short PTf = buffer.readShort();
            System.out.println("PTf = " + PTf);
            short PAf = buffer.readShort();
            System.out.println("PAf = " + PAf);
            short PBf = buffer.readShort();
            System.out.println("PBf = " + PBf);
            short PCf = buffer.readShort();
            System.out.println("PCf = " + PCf);
            short IV_angleA = buffer.readShort();
            System.out.println("IV_angleA = " + IV_angleA);
            short IV_angleB = buffer.readShort();
            System.out.println("IV_angleB = " + IV_angleB);
            short IV_angleC = buffer.readShort();
            System.out.println("IV_angleC = " + IV_angleC);
            short V_angleB = buffer.readShort();
            short V_angleA = buffer.readShort();
            System.out.println("V_angleA = " + V_angleA);
            System.out.println("V_angleB = " + V_angleB);
            short V_angleC = buffer.readShort();
            System.out.println("V_angleC = " + V_angleC);
            short I_angleA = buffer.readShort();
            System.out.println("I_angleA = " + I_angleA);
            short I_angleB = buffer.readShort();
            System.out.println("I_angleB = " + I_angleB);
            short I_angleC = buffer.readShort();
            System.out.println("I_angleC = " + I_angleC);
            short frequency = buffer.readShort();
            System.out.println("frequency = " + frequency);
            int dataIdentification6 = buffer.readUnsignedShort();
            System.out.println("dataIdentification6 = " + dataIdentification6);
            byte registersCount6 = buffer.readByte();
            System.out.println("registersCount6 = " + registersCount6);
            short V_rate = buffer.readShort();
            System.out.println("V_rate = " + V_rate);
            short I_rate = buffer.readShort();
            System.out.println("I_rate = " + I_rate);
            int dataIdentification7 = buffer.readUnsignedShort();
            System.out.println("dataIdentification7 = " + dataIdentification7);
            byte registersCount7 = buffer.readByte();
            System.out.println("registersCount7 = " + registersCount7);
            short V_ratio = buffer.readShort();
            System.out.println("V_ratio = " + V_ratio);
            short I_ratio = buffer.readShort();
            System.out.println("I_ratio = " + I_ratio);
             // 有两个寄存器位为空
            buffer.readShort();
            buffer.readShort();
            int dataIdentification8 = buffer.readUnsignedShort();
            System.out.println("dataIdentification8 = " + dataIdentification8);
            short registersCount8 = buffer.readByte();
            System.out.println("registersCount8 = " + registersCount8);
            float CombinedActiveTotalEnergy = buffer.readFloat();
            System.out.println("CombinedActiveTotalEnergy = " + CombinedActiveTotalEnergy);
            float CombinedActiveTipEnergy = buffer.readFloat();
            System.out.println("CombinedActiveTipEnergy = " + CombinedActiveTipEnergy);
            float CombinedActivePeakEnergy = buffer.readFloat();
            System.out.println("CombinedActivePeakEnergy = " + CombinedActivePeakEnergy);
            float CombineActivePowerLeveling = buffer.readFloat();
            System.out.println("CombineActivePowerLeveling = " + CombineActivePowerLeveling);
            float CombinedActiveValleyPower = buffer.readFloat();
            System.out.println("CombinedActiveValleyPower = " + CombinedActiveValleyPower);
            float ForwardActiveTotalElectricalEnergy = buffer.readFloat();
            System.out.println("ForwardActiveTotalElectricalEnergy = " + ForwardActiveTotalElectricalEnergy);
            float PositiveActiveTipEnergy = buffer.readFloat();
            System.out.println("PositiveActiveTipEnergy = " + PositiveActiveTipEnergy);
            float PositiveActivePeakEnergy = buffer.readFloat();
            System.out.println("PositiveActivePeakEnergy = " + PositiveActivePeakEnergy);
            float PositiveActivePowerLeveling = buffer.readFloat();
            System.out.println("PositiveActivePowerLeveling = " + PositiveActivePowerLeveling);
            float PositiveActiveValleyEnergy = buffer.readFloat();
            System.out.println("PositiveActiveValleyEnergy = " + PositiveActiveValleyEnergy);
            float TotalReverseActiveEnergy = buffer.readFloat();
            System.out.println("TotalReverseActiveEnergy = " + TotalReverseActiveEnergy);
            float ReverseActiveTip = buffer.readFloat();
            System.out.println("ReverseActiveTip = " + ReverseActiveTip);
            float ReverseActivePeakEnergy = buffer.readFloat();
            System.out.println("ReverseActivePeakEnergy = " + ReverseActivePeakEnergy);
            float ReverseActivePowerLeveling = buffer.readFloat();
            System.out.println("ReverseActivePowerLeveling = " + ReverseActivePowerLeveling);
            float ReverseActiveValleyPower = buffer.readFloat();
            System.out.println("ReverseActiveValleyPower = " + ReverseActiveValleyPower);
            byte cs = buffer.readByte();
            System.out.println("cs....." + cs);
            short end = buffer.readByte();
            System.out.println("end......" + end);
            if (end == SmartIotpower.END) {
                log.info("完成解析，并输出.");
                SmartIotpower iot = new SmartIotpower();
                iot.setDeviceid(deviceid);
                iot.setDeviceType(deviceType);
                iot.setVendorCode(vendorCode);
                iot.setFunctionCode(functionCode);
                iot.setDataLength(dataLength);
                iot.setAgreementType(agreementType);
                iot.setYear(year);
                iot.setMonth(month);
                iot.setDate(date);
                iot.setHour(hour);
                iot.setMinute(minute);
                iot.setSecond(second);
                iot.setModbusId(modbusId);
                iot.setDataCount(dataCount);
                iot.setDataIdentification(dataIdentification);
                iot.setRegistersCount(registersCount);
                iot.setUa(Ua);
                iot.setUb(Ub);
                iot.setUc(Uc);
                iot.setDataIdentification2(dataIdentification2);
                iot.setRegistersCount2(registersCount2);
                iot.setUab(Uab);
                iot.setUbc(Ubc);
                iot.setUca(Uca);
                iot.setDataIdentification3(dataIdentification3);
                iot.setRegistersCount3(registersCount3);
                iot.setIa(Ia);
                iot.setIb(Ib);
                iot.setIc(Ic);
                iot.setI0(I0);
                iot.setDataIdentification4(dataIdentification4);
                iot.setRegistersCount4(registersCount4);
                iot.setPT(PT);
                iot.setPA(PA);
                iot.setPC(PC);
                iot.setPTn(PTn);
                iot.setPAn(PAn);
                iot.setPBn(PBn);
                iot.setPCn(PCn);
                iot.setPTin(PTin);
                iot.setPAin(PAin);
                iot.setPBin(PBin);
                iot.setPCin(PCin);
                iot.setDataIdentification5(dataIdentification5);
                iot.setRegistersCount5(registersCount5);
                iot.setPTf(PTf);
                iot.setPAf(PAf);
                iot.setPBf(PBf);
                iot.setPCf(PCf);
                iot.setIV_angleA(IV_angleA);
                iot.setIV_angleB(IV_angleB);
                iot.setIV_angleC(IV_angleC);
                iot.setV_angleA(V_angleA);
                iot.setV_angleB(V_angleB);
                iot.setV_angleC(V_angleC);
                iot.setI_angleA(I_angleA);
                iot.setI_angleB(I_angleB);
                iot.setI_angleC(I_angleC);
                iot.setFrequency(frequency);
                iot.setDataIdentification6(dataIdentification6);
                iot.setRegistersCount6(registersCount6);
                iot.setV_rate(V_rate);
                iot.setI_rate(I_rate);
                iot.setDataIdentification7(dataIdentification7);
                iot.setRegistersCount7(registersCount7);
                iot.setV_ratio(V_ratio);
                iot.setI_ratio(I_ratio);
                iot.setDataIdentification8(dataIdentification8);
                iot.setRegitersCount8(registersCount8);
                iot.setCs(cs);
                out.add(iot);
                log.info("报文解析完成");
            } else {
                log.info("数据结构错误");
            }
        }
    }

}