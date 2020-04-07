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
            float Ia = buffer.readFloat();
            System.out.println("Ia = " + Ia);
            float Ib = buffer.readFloat();
            System.out.println("Ib = " + Ib);
            float Ic = buffer.readFloat();
            System.out.println("Ic = " + Ic);
            float I0 = buffer.readFloat();
            System.out.println("I0 = " + I0);
            int dataIdentification8 = buffer.readUnsignedShort();
            System.out.println("dataIdentification3 = " + dataIdentification8);
            byte registersCount3 = buffer.readByte();
            System.out.println("registersCount3 = " + registersCount3);
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
            int dataIdentification4 = buffer.readUnsignedShort();
            System.out.println("dataIdentification4 = " + dataIdentification4);
            byte registersCount4 = buffer.readByte();
            System.out.println("registersCount4 = " + registersCount4);
            float PTf = buffer.readFloat();
            System.out.println("PTf = " + PTf);
            float PAf = buffer.readFloat();
            System.out.println("PAf = " + PAf);
            float PBf = buffer.readFloat();
            System.out.println("PBf = " + PBf);
            float PCf = buffer.readFloat();
            System.out.println("PCf = " + PCf);
            float IV_angleA = buffer.readFloat();
            System.out.println("IV_angleA = " + IV_angleA);
            float IV_angleB = buffer.readFloat();
            System.out.println("IV_angleB = " + IV_angleB);
            float IV_angleC = buffer.readFloat();
            System.out.println("IV_angleC = " + IV_angleC);
            float V_angleB = buffer.readFloat();
            System.out.println("V_angleB = " + V_angleB);
            float V_angleC = buffer.readFloat();
            System.out.println("V_angleC = " + V_angleC);
            float I_angleA = buffer.readFloat();
            float I_angleB = buffer.readFloat();
            float I_angleC = buffer.readFloat();
            float frequency = buffer.readFloat();
            int dataIdentification5 = buffer.readUnsignedShort();
            byte registersCount5 = buffer.readByte();

            System.out.println("继续" + buffer.readByte());
            System.out.println("继续" + buffer.readByte());
            System.out.println("继续" + buffer.readByte());
            System.out.println("继续" + buffer.readByte());
            System.out.println("继续" + buffer.readByte());
            System.out.println("继续" + buffer.readByte());
            byte cs = buffer.readByte();
            System.out.println("cs....." + cs);
//            float V_rate = buffer.readFloat();
//            System.out.println(buffer.readerIndex());
//            float I_rate = buffer.readFloat();
//            short dataIdentification6 = buffer.readShort();
//            byte registersCount6 = buffer.readByte();
//            float V_ratio = buffer.readFloat();
//            float I_ratio = buffer.readFloat();
//            short dataIdentification7 = buffer.readShort();
//            byte registersCount7 = buffer.readByte();
//            float CombinedActiveTotalEnergy = buffer.readFloat();
//            float CombinedActiveTipEnergy = buffer.readFloat();
//            float CombinedActivePeakEnergy = buffer.readFloat();
//            float CombineActivePowerLeveling = buffer.readFloat();
//            float CombinedActiveValleyPower = buffer.readFloat();
//            float ForwardActiveTotalElectricalEnergy = buffer.readFloat();
//            float PositiveActiveTipEnergy = buffer.readFloat();
//            float PositiveActivePeakEnergy = buffer.readFloat();
//            float PositiveActivePowerLeveling = buffer.readFloat();
//            float PositiveActiveValleyEnergy = buffer.readFloat();
//            float TotalReverseActiveEnergy = buffer.readFloat();
//            float ReverseActiveTip = buffer.readFloat();
//            float ReverseActivePeakEnergy = buffer.readFloat();
//            float ReverseActivePowerLeveling = buffer.readFloat();
//            float ReverseActiveValleyPower = buffer.readFloat();


//            short flowid = buffer.readShort();
//            byte version_major = buffer.readByte();
//            byte version_minor = buffer.readByte();
//            byte second = buffer.readByte();
//            byte minute = buffer.readByte();
//            byte hour = buffer.readByte();
//            byte day = buffer.readByte();
//            byte month = buffer.readByte();
//            byte year = buffer.readByte();
//            byte[] src = new byte[6];
//            src[0] = buffer.readByte();
//            src[1] = buffer.readByte();
//            src[2] = buffer.readByte();
//            src[3] = buffer.readByte();
//            src[4] = buffer.readByte();
//            src[5] = buffer.readByte();
//            byte[] dest = new byte[6];
//            dest[0] = buffer.readByte();
//            dest[1] = buffer.readByte();
//            dest[2] = buffer.readByte();
//            dest[3] = buffer.readByte();
//            dest[4] = buffer.readByte();
//            dest[5] = buffer.readByte();

//            short data_len = buffer.readShort();
//            if (buffer.readableBytes() < data_len + 4) {
//                //还原读指针
//                buffer.readerIndex(beginReader);
//                return;
//            }
//            byte[] data = null;
//            if (data_len > 0) {
//                //读取应用数据单元
//                data = new byte[data_len];
//                buffer.readBytes(data);
//            }

//            byte checcsksum = buffer.readByte();
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
                iot.setCs(cs);


//                iot.setFlowid(flowid);
//                iot.setVersion_major(version_major);
//                iot.setVersion_minor(version_minor);
//                iot.setSecond(second);
//                iot.setMinute(minute);
//                iot.setHour(hour);
//                iot.setDay(day);
//                iot.setMonth(month);
//                iot.setYear(year);
//                iot.setSrc(src);
//                iot.setDest(dest);
//                iot.setData_len(data_len);
//                iot.setCmd(cmd);
//                if (data_len > 0) {
//                    iot.setData(data);
//                } else {
//                    iot.setData(null);
//                }
//                iot.setChecksum(checksum);
                out.add(iot);
            } else {
                log.info("数据结构错误");
            }
        }
    }

}