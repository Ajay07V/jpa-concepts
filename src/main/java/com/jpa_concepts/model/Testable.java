package com.jpa_concepts.model;

import com.jpa_concepts.util.EncryptionUtil;

public class Testable {
    public static void main(String[] args) throws Exception {
        String s="RamaChandra";
        EncryptionUtil encryptionUtil=new EncryptionUtil();
        var encryptedString=encryptionUtil.encrypt(s);
        System.out.println("Encrypted String "+encryptedString);
        String encodedPrivateKey = encryptionUtil.getEncodedPrivateKey();
        System.out.println("encodedPrivateKey "+encodedPrivateKey);
    }
}
