package com.treehub.restapi.samples.jsp.utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.codec.binary.Hex;

public class GenerateKeyUtils {

    public GenerateKeyUtils() {
        // TODO Auto-generated constructor stub
    }
    
    private static long get64LeastSignificantBitsForVersion1() {
        Random random = new Random();
        long random63BitLong = random.nextLong() & 0x3FFFFFFFFFFFFFFFL;
        long variant3BitFlag = 0x8000000000000000L;
        return random63BitLong + variant3BitFlag;
    }

    private static long get64MostSignificantBitsForVersion1() {
        LocalDateTime start = LocalDateTime.of(1582, 10, 15, 0, 0, 0);
        Duration duration = Duration.between(start, LocalDateTime.now());
        long seconds = duration.getSeconds();
        long nanos = duration.getNano();
        long timeForUuidIn100Nanos = seconds * 10000000 + nanos * 100;
        long least12SignificatBitOfTime = (timeForUuidIn100Nanos & 0x000000000000FFFFL) >> 4;
        long version = 1 << 12;
        return 
          (timeForUuidIn100Nanos & 0xFFFFFFFFFFFF0000L) + version + least12SignificatBitOfTime;
    }
    
    public static String getUUID1() {
        String strResult = "";
        
        try {
            long most64SigBits = get64MostSignificantBitsForVersion1();
            long least64SigBits = get64LeastSignificantBitsForVersion1();
            
            UUID uuid = new UUID(most64SigBits, least64SigBits);
            
//          System.out.println("result : "+uuid);
            strResult = uuid.toString();
        } catch(Exception e) {
            //TODO: ????
        }
        
        return strResult;
    }
    
    public static String  getUUID4( )  {
        String strResult = "";
        
        try {
            UUID uuid = UUID.randomUUID();
            
            
//          System.out.println("result : "+uuid);
            strResult = uuid.toString();
        } catch(Exception e) {
            //TODO: ????
        }
        
        return strResult;
    }
    
    public static String getOrderedUUIDFromRandom() {
        String strResult = "";
        
        try {
            String strTemp = getUUID4();
            String[] strTempArr =  strTemp.split("-");
            
            strResult = strTempArr[2] + strTempArr[1] + strTempArr[0] + strTempArr[3] + strTempArr[4];
        } catch(Exception e) {
            //TODO: ????
        }
        
        return strResult;
    }
    
    public static String getOrderedUUID() {
        String strResult = "";
        
        try {
            String strTemp = getUUID1();
            String[] strTempArr =  strTemp.split("-");
            
            strResult =  strTempArr[0] + strTempArr[1] + strTempArr[2] + strTempArr[3] + strTempArr[4];
        } catch(Exception e) {
            //TODO: ????
        }
        
        return strResult;
    }
    
    public static byte[] getOrderedUUIDByBytes() {
        byte[] bytes = null;
        try {
            bytes = hexToBytes(getOrderedUUID());
        } catch(Exception e) {
            //TODO:????
        }
        return bytes;
    }
    
    public static byte[] getOrderedUUIDFromRandomByBytes() {
        byte[] bytes = null;
        try {
            bytes = hexToBytes(getOrderedUUIDFromRandom());
        } catch(Exception e) {
            //TODO:????
        }
        return bytes;
    }
    
    public static byte[] hexToBytes(String hexString)  {
        try {
            return Hex.decodeHex(hexString);
        } catch (Exception e) {
            return null;
        }
    }
    
    public static String byteToHex(byte[] bytes) {
        try  {
            return Hex.encodeHexString(bytes);
        } catch(Exception e) {
            return null;
        }
    }
}