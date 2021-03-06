package com.heyi.netty.smartiot.decoder;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.heyi.netty.smartiot.model.SmartIotpower;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
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

    private ConcurrentHashMap<String, Channel> sessionChannelMap = new ConcurrentHashMap<String, Channel>();
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
        log.info("等待接收数据包");

        // 刻度长度必须大于基本最小长度
        if (buffer.readableBytes() >= SmartIotpower.MIN_LEN) {
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
            System.out.println("设备号deviceid = " + deviceid);
            byte deviceType = buffer.readByte();
            System.out.println("设备类型deviceType = " + deviceType);
            byte vendorCode = buffer.readByte();
            System.out.println("出厂码vendorCode = " + vendorCode);
            byte functionCode = buffer.readByte();
            System.out.println("functionCode = " + functionCode);
            if (functionCode ==31 ){
                System.out.println("收到周期上报数据======================================");
                short dataLength = buffer.readUnsignedByte();
                System.out.println("数据长度dataLength = " + dataLength);
                byte agreementType = buffer.readByte();
                System.out.println("功能码agreementType = " + agreementType);
                byte year = buffer.readByte();
                System.out.println("年year = " + year);
                byte month = buffer.readByte();
                System.out.println("月month = " + month);
                byte date = buffer.readByte();
                System.out.println("日date = " + date);
                byte hour = buffer.readByte();
                System.out.println("小时hour = " + hour);
                byte minute = buffer.readByte();
                System.out.println("分钟minute = " + minute);
                byte second = buffer.readByte();
                System.out.println("秒second = " + second);
                byte modbusId = buffer.readByte();
                System.out.println("协议类型modbusId = " + modbusId);
                byte dataCount = buffer.readByte();
                System.out.println("dataCount = " + dataCount);
                int dataIdentification = buffer.readUnsignedShort();
                System.out.println("数据标识dataIdentification = " + dataIdentification);
                byte registersCount = buffer.readByte();
                System.out.println("registersCount = " + registersCount);
                float Ua = buffer.readFloat();
                System.out.println("A相电压Ua = " + Ua);
                float Ub = buffer.readFloat();
                System.out.println("B相电压Ub = " + Ub);
                float Uc = buffer.readFloat();
                System.out.println("C相电压Uc = " + Uc);
                int dataIdentification2 = buffer.readUnsignedShort();
                System.out.println("dataIdentification2 = " + dataIdentification2);
                byte registersCount2 = buffer.readByte();
                System.out.println("registersCount2 = " + registersCount2);
                float Uab = buffer.readFloat();
                System.out.println("AB线电压Uab = " + Uab);
                float Ubc = buffer.readFloat();
                System.out.println("BC线电压Ubc = " + Ubc);
                float Uca = buffer.readFloat();
                System.out.println("CA线电压Uca = " + Uca);
                int dataIdentification3 = buffer.readUnsignedShort();
                System.out.println("dataIdentification3 = " + dataIdentification3);
                byte registersCount3 = buffer.readByte();
                System.out.println("registersCount3 = " + registersCount3);
                float Ia = buffer.readFloat();
                System.out.println("A相电流Ia = " + Ia);
                float Ib = buffer.readFloat();
                System.out.println("B相电流Ib = " + Ib);
                float Ic = buffer.readFloat();
                System.out.println("C相电流Ic = " + Ic);
                float I0 = buffer.readFloat();
                System.out.println("零序电流I0 = " + I0);
                int dataIdentification4 = buffer.readUnsignedShort();
                System.out.println("dataIdentification4 = " + dataIdentification4);
                byte registersCount4 = buffer.readByte();
                System.out.println("registersCount4 = " + registersCount4);

                float PT = buffer.readFloat();
                System.out.println("有功总功率PT = " + PT);
                float PA = buffer.readFloat();
                System.out.println("A相有功总功率PA = " + PA);
                float PB = buffer.readFloat();
                System.out.println("B相有功总功率PB = " + PB);
                float PC = buffer.readFloat();
                System.out.println("C相有功总功率PC = " + PC);
                float PTn = buffer.readFloat();
                System.out.println("无功总功率PTn = " + PTn);
                float PAn = buffer.readFloat();
                System.out.println("A相无功总功率PAn = " + PAn);
                float PBn = buffer.readFloat();
                System.out.println("B相无功总功率PBn = " + PBn);
                float PCn = buffer.readFloat();
                System.out.println("C相无功总功率PCn = " + PCn);
                float PTin = buffer.readFloat();
                System.out.println("总视在功率PTin = " + PTin);
                float PAin = buffer.readFloat();
                System.out.println("A相视在功率PAin = " + PAin);
                float PBin = buffer.readFloat();
                System.out.println("B相视在功率PBin = " + PBin);
                float PCin = buffer.readFloat();
                System.out.println("C相视在功率PCin = " + PCin);
                int dataIdentification5 = buffer.readUnsignedShort();
                System.out.println("dataIdentification5 = " + dataIdentification5);
                byte registersCount5 = buffer.readByte();
                System.out.println("registersCount5 = " + registersCount5);
                short PTf = buffer.readShort();
                System.out.println("总功率因数PTf = " + PTf);
                short PAf = buffer.readShort();
                System.out.println("A相功率因数PAf = " + PAf);
                short PBf = buffer.readShort();
                System.out.println("B相功率因数PBf = " + PBf);
                short PCf = buffer.readShort();
                System.out.println("C相功率因数PCf = " + PCf);
                short IV_angleA = buffer.readShort();
                System.out.println("A相电压与电流夹角:IV_angleA = " + IV_angleA);
                short IV_angleB = buffer.readShort();
                System.out.println("B相电压与电流夹角:IV_angleB = " + IV_angleB);
                short IV_angleC = buffer.readShort();
                System.out.println("C相电压与电流夹角:IV_angleC = " + IV_angleC);
                short V_angleB = buffer.readShort();
                short V_angleA = buffer.readShort();
                System.out.println("A相电压夹角V_angleA = " + V_angleA);
                System.out.println("B相电压夹角:V_angleB = " + V_angleB);
                short V_angleC = buffer.readShort();
                System.out.println("C相电压夹角:V_angleC = " + V_angleC);
                short I_angleA = buffer.readShort();
                System.out.println("A相电流夹角:I_angleA = " + I_angleA);
                short I_angleB = buffer.readShort();
                System.out.println("B相电流夹角:I_angleB = " + I_angleB);
                short I_angleC = buffer.readShort();
                System.out.println("C相电流夹角:I_angleC = " + I_angleC);
                short frequency = buffer.readShort();
                System.out.println("电网频率:frequency = " + frequency);
                int dataIdentification6 = buffer.readUnsignedShort();
                System.out.println("数据标识：dataIdentification6 = " + dataIdentification6);
                byte registersCount6 = buffer.readByte();
                System.out.println("寄存器个数：registersCount6 = " + registersCount6);
                short V_rate = buffer.readShort();
                System.out.println("电压不平衡率:V_rate = " + V_rate);
                short I_rate = buffer.readShort();
                System.out.println("电流不平衡率:I_rate = " + I_rate);
                int dataIdentification7 = buffer.readUnsignedShort();
                System.out.println("数据标识：dataIdentification7 = " + dataIdentification7);
                byte registersCount7 = buffer.readByte();
                System.out.println("寄存器个数：registersCount7 = " + registersCount7);
                short V_ratio = buffer.readShort();
                System.out.println("电压变比:V_ratio = " + V_ratio);
                short I_ratio = buffer.readShort();
                System.out.println("电流变比:I_ratio = " + I_ratio);
                // 有两个寄存器位为空
                buffer.readShort();
                buffer.readShort();
                int dataIdentification8 = buffer.readUnsignedShort();
                System.out.println("dataIdentification8 = " + dataIdentification8);
                short registersCount8 = buffer.readByte();
                System.out.println("registersCount8 = " + registersCount8);
                float CombinedActiveTotalEnergy = buffer.readFloat();
                System.out.println("组合有功总电能:CombinedActiveTotalEnergy = " + CombinedActiveTotalEnergy);
                float CombinedActiveTipEnergy = buffer.readFloat();
                System.out.println("组合有功尖电能:CombinedActiveTipEnergy = " + CombinedActiveTipEnergy);
                float CombinedActivePeakEnergy = buffer.readFloat();
                System.out.println("组合有功峰电能:CombinedActivePeakEnergy = " + CombinedActivePeakEnergy);
                float CombineActivePowerLeveling = buffer.readFloat();
                System.out.println("组合有功平电能::CombineActivePowerLeveling = " + CombineActivePowerLeveling);
                float CombinedActiveValleyPower = buffer.readFloat();
                System.out.println("组合有功谷电能:CombinedActiveValleyPower = " + CombinedActiveValleyPower);
                float ForwardActiveTotalElectricalEnergy = buffer.readFloat();
                System.out.println("正向有功总电能:ForwardActiveTotalElectricalEnergy = " + ForwardActiveTotalElectricalEnergy);
                float PositiveActiveTipEnergy = buffer.readFloat();
                System.out.println("正向有功尖电能:PositiveActiveTipEnergy = " + PositiveActiveTipEnergy);
                float PositiveActivePeakEnergy = buffer.readFloat();
                System.out.println("正向有功峰电能:PositiveActivePeakEnergy = " + PositiveActivePeakEnergy);
                float PositiveActivePowerLeveling = buffer.readFloat();
                System.out.println("正向有功平电能:PositiveActivePowerLeveling = " + PositiveActivePowerLeveling);
                float PositiveActiveValleyEnergy = buffer.readFloat();
                System.out.println("正向有功谷电能:PositiveActiveValleyEnergy = " + PositiveActiveValleyEnergy);
                float TotalReverseActiveEnergy = buffer.readFloat();
                System.out.println("反向有功总电能::TotalReverseActiveEnergy = " + TotalReverseActiveEnergy);
                float ReverseActiveTip = buffer.readFloat();
                System.out.println("反向有功尖电能:ReverseActiveTip = " + ReverseActiveTip);
                float ReverseActivePeakEnergy = buffer.readFloat();
                System.out.println("反向有功峰电能:ReverseActivePeakEnergy = " + ReverseActivePeakEnergy);
                float ReverseActivePowerLeveling = buffer.readFloat();
                System.out.println("反向有功平电能:ReverseActivePowerLeveling = " + ReverseActivePowerLeveling);
                float ReverseActiveValleyPower = buffer.readFloat();
                System.out.println("反向有功谷电能ReverseActiveValleyPower = " + ReverseActiveValleyPower);
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
            //08为登录包
            if (functionCode ==8 ){
                System.out.println("收到登录请求======+++++++++++++++++++++++ " );
//68 11 11 11 11 11 11 08 18 38 36 31 35 32 32 30 34 30 30 34 31 39 37 33 00 00 00 00 00 00 00 00 00 F2 16
                //解析这个心跳包的IEMI码
               ByteBuf IEMI= buffer.readBytes(24);
                byte cs = buffer.readByte();
                byte end = buffer.readByte();
                byte dataLength =buffer.readByte();
                LoginPackage loginPackage =new LoginPackage();
                loginPackage.setDeviceid(deviceid);
                loginPackage.setDeviceType(deviceType);
                loginPackage.setVendorCode(vendorCode);
                loginPackage.setFunctionCode(functionCode);
                loginPackage.setDataLength(dataLength);
                loginPackage.setIEMI(IEMI);
                loginPackage.setCs(cs);
//                out.add(loginPackage);

                ByteBuf byteBuf = ctx.alloc().buffer(11);//为bytebuf分配11个字节
                byteBuf.writeByte(SmartIotpower.START);
                byteBuf.writeByte(170);
                byteBuf.writeByte(170);
                byteBuf.writeByte(170);
                byteBuf.writeByte(170);
                byteBuf.writeByte(170);
                byteBuf.writeByte(170);
                byteBuf.writeByte(170);
                byteBuf.writeByte(136);
                byteBuf.writeByte(0);
                byteBuf.writeByte(236);
                byteBuf.writeByte(SmartIotpower.END);
                ctx.writeAndFlush(byteBuf); // (3)
                System.out.println("发送了68 AA AA AA AA AA AA 88 00 EC 16");
            }
            if (functionCode ==10 ){
                System.out.println("收到心跳包========================================");
               byte cs = buffer.readByte();
               byte end = buffer.readByte();
               byte dataLength =buffer.readByte();
                HeartBeat heartBeat = new HeartBeat();
                heartBeat.setDeviceid(deviceid);
                heartBeat.setDeviceType(deviceType);
                heartBeat.setVendorCode(vendorCode);
                heartBeat.setFunctionCode(functionCode);
                heartBeat.setDataLength(dataLength);
                heartBeat.setCs(cs);
                HeartBeat.setEnd(end);
//                out.add(heartBeat);
                Channel channel=ctx.channel();
                ByteBuf byteBuf = ctx.alloc().buffer(11);//为bytebuf分配11个字节
                byteBuf.writeByte(SmartIotpower.START);
                byteBuf.writeByte(170);
                byteBuf.writeByte(170);
                byteBuf.writeByte(170);
                byteBuf.writeByte(170);
                byteBuf.writeByte(170);
                byteBuf.writeByte(170);
                byteBuf.writeByte(138);
                byteBuf.writeByte(0);
                byteBuf.writeByte(238);
                byteBuf.writeByte(SmartIotpower.END);
                channel.writeAndFlush(byteBuf); // (3)
                System.out.println("channel发送了68 AA AA AA AA AA AA 8A 00 EE 16");
            }

            //


        }
    }

}