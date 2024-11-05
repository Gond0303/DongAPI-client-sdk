package com.dong.dongapiclientsdk.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * 签名工具
 */
public class SignUtils {
    /**
     * 生成签名
     * @param body
     * @param secretKey
     * @return
     */
    public static String getSign(String body, String secretKey){
        Digester sha256 = new Digester(DigestAlgorithm.SHA256);
        //生成需要加密的数据
        String testStr = body + "." + secretKey;
//        System.out.println("签名拿到的 body:"+ body);
        //加密
        String digestHex = sha256.digestHex(testStr);
//        System.out.println("加密的数据:"+ digestHex);

        return digestHex;
    }


}
