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
                if (buffer.readByte() == SmartIotpower.START) {
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
            short dataIdentification = buffer.readShort();
            System.out.println("dataIdentification = " + dataIdentification);
            long Ua = buffer.readLong();
            System.out.println("Ua = " + Ua);
            long Ub = buffer.readLong();
            System.out.println("Ub = " + Ub);
            long Uc = buffer.readLong();
            System.out.println("Uc = " + Uc);
            short dataIdentification2 = buffer.readShort();
            System.out.println("dataIdentification2 = " + dataIdentification2);
            byte registersCount2 = buffer.readByte();
            System.out.println("registersCount2 = " + registersCount2);
            long Ia = buffer.readLong();
            System.out.println("Ia = " + Ia);
            long Ib = buffer.readLong();
            System.out.println("Ib = " + Ib);
            long Ic = buffer.readLong();
            System.out.println("Ic = " + Ic);
            long I0 = buffer.readLong();
            System.out.println("I0 = " + I0);
            short dataIdentification3 = buffer.readShort();
            System.out.println("dataIdentification3 = " + dataIdentification3);
            byte registersCount3 = buffer.readByte();
            System.out.println("registersCount3 = " + registersCount3);
            long PT = buffer.readLong();
            System.out.println("PT = " + PT);
            long PA = buffer.readLong();
            System.out.println("PA = " + PA);
            long PB = buffer.readLong();
            System.out.println("PB = " + PB);
            long PC = buffer.readLong();
            System.out.println("PC = " + PC);
            long PTn = buffer.readLong();
            System.out.println("PTn = " + PTn);
            long PAn = buffer.readLong();
            System.out.println("PAn = " + PAn);
            long PBn = buffer.readLong();
            System.out.println("PBn = " + PBn);
            long PCn = buffer.readLong();
            System.out.println("PCn = " + PCn);
            long PTin = buffer.readLong();
            System.out.println("PTin = " + PTin);
            long PAin = buffer.readLong();
            System.out.println("PAin = " + PAin);
            long PBin = buffer.readLong();
            System.out.println("PBin = " + PBin);
            long PCin = buffer.readLong();
            System.out.println("PCin = " + PCin);
            short dataIdentification4 = buffer.readShort();
            System.out.println("dataIdentification4 = " + dataIdentification4);
            byte registersCount4 = buffer.readByte();
            System.out.println("registersCount4 = " + registersCount4);
            long PTf = buffer.readLong();
            System.out.println("PTf = " + PTf);
            long PAf = buffer.readLong();
            System.out.println("PAf = " + PAf);
            long PBf = buffer.readLong();
            System.out.println("PBf = " + PBf);
            long PCf = buffer.readLong();
            System.out.println("PCf = " + PCf);
            long IV_angleA = buffer.readLong();
            System.out.println("IV_angleA = " + IV_angleA);
            long IV_angleB = buffer.readLong();
            System.out.println("IV_angleB = " + IV_angleB);
            long IV_angleC = buffer.readLong();
            System.out.println("IV_angleC = " + IV_angleC);
            long V_angleA = buffer.readLong();
            System.out.println("V_angleA = " + V_angleA);
            long V_angleB = buffer.readLong();
            System.out.println("V_angleB = " + V_angleB);
            long V_angleC = buffer.readLong();
            System.out.println("V_angleC = " + V_angleC);
            long I_angleA = buffer.readLong();
            long I_angleB = buffer.readLong();
            long I_angleC = buffer.readLong();
            long frequency = buffer.readLong();
            short dataIdentification5 = buffer.readShort();
            byte registersCount5 = buffer.readByte();

            System.out.println("继续"+buffer.readByte());
            System.out.println("继续"+buffer.readByte());
            System.out.println("继续"+buffer.readByte());
            System.out.println("继续"+buffer.readByte());
            System.out.println("继续"+buffer.readByte());
            System.out.println("继续"+buffer.readByte());
            byte cs = buffer.readByte();
            System.out.println("cs....."+cs);
//            long V_rate = buffer.readLong();
//            System.out.println(buffer.readerIndex());
//            long I_rate = buffer.readLong();
//            short dataIdentification6 = buffer.readShort();
//            byte registersCount6 = buffer.readByte();
//            long V_ratio = buffer.readLong();
//            long I_ratio = buffer.readLong();
//            short dataIdentification7 = buffer.readShort();
//            byte registersCount7 = buffer.readByte();
//            long CombinedActiveTotalEnergy = buffer.readLong();
//            long CombinedActiveTipEnergy = buffer.readLong();
//            long CombinedActivePeakEnergy = buffer.readLong();
//            long CombineActivePowerLeveling = buffer.readLong();
//            long CombinedActiveValleyPower = buffer.readLong();
//            long ForwardActiveTotalElectricalEnergy = buffer.readLong();
//            long PositiveActiveTipEnergy = buffer.readLong();
//            long PositiveActivePeakEnergy = buffer.readLong();
//            long PositiveActivePowerLeveling = buffer.readLong();
//            long PositiveActiveValleyEnergy = buffer.readLong();
//            long TotalReverseActiveEnergy = buffer.readLong();
//            long ReverseActiveTip = buffer.readLong();
//            long ReverseActivePeakEnergy = buffer.readLong();
//            long ReverseActivePowerLeveling = buffer.readLong();
//            long ReverseActiveValleyPower = buffer.readLong();


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
            System.out.println("end......"+end);
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