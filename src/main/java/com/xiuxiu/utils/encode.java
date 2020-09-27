package com.xiuxiu.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * @author stone
 * @date 2020/9/10 001011:22
 */
public class encode {
        private static final String DES = "DES";
        private static final String KEY = "linshanxiuxustone4YztMHI7PsT4rLZN_adorechen";

        private encode() {}

        private static byte[] encrypt(byte[] src, byte[] key) throws Exception {
            return encryptAndDecrypt(src, key, Cipher.ENCRYPT_MODE);
        }

        private static byte[] decrypt(byte[] src, byte[] key) throws Exception {
            return encryptAndDecrypt(src, key, Cipher.DECRYPT_MODE);
        }

        private static byte[] encryptAndDecrypt(byte[] src, byte[] key, int mode) throws Exception {
            SecureRandom sr = new SecureRandom();
            DESKeySpec dks = new DESKeySpec(key);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
            SecretKey secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(DES);
            cipher.init(mode, secretKey, sr);
            return cipher.doFinal(src);
        }

        private static String byte2hex(byte[] b) {
            String hs = "";
            String temp = "";
            for (int n = 0; n < b.length; n++) {
                temp = (java.lang.Integer.toHexString(b[n] & 0XFF));
                if (temp.length() == 1)
                    hs = hs + "0" + temp;
                else
                    hs = hs + temp;
            }
            return hs.toUpperCase();

        }

        private static byte[] hex2byte(byte[] b) {
            if ((b.length % 2) != 0)
                throw new IllegalArgumentException("length not even");
            byte[] b2 = new byte[b.length / 2];
            for (int n = 0; n < b.length; n += 2) {
                String item = new String(b, n, 2);
                b2[n / 2] = (byte) Integer.parseInt(item, 16);
            }
            return b2;
        }

        private static String decode(String src, String key) {
            String decryptStr = "";
            try {
                byte[] decrypt = decrypt(hex2byte(src.getBytes()), key.getBytes());
                decryptStr = new String(decrypt);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return decryptStr;
        }

        private static String encode(String src, String key){
            byte[] bytes = null;
            String encryptStr = "";
            try {
                bytes = encrypt(src.getBytes(), key.getBytes());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (bytes != null)
                encryptStr = byte2hex(bytes);
            return encryptStr;
        }

        /**
         * 解密
         */
        public static String decode(String src) {
            return decode(src, KEY);
        }

        /**
         * 加密
         */
        public static String encode(String src) {
            return encode(src, KEY);
        }
    }

