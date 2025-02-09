package com.jpa_concepts.util;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class EncryptionUtil {

    private static final String ALGORITHM = "RSA";
    private static final int KEY_SIZE = 2048;

    private PublicKey publicKey;
    private PrivateKey privateKey;

    public EncryptionUtil() throws Exception {
        generateKeyPair();
    }

    private void generateKeyPair() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
        keyGen.initialize(KEY_SIZE);
        KeyPair keyPair = keyGen.generateKeyPair();
        this.publicKey = keyPair.getPublic();
        this.privateKey = keyPair.getPrivate();
    }

    public String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }

    public String getEncodedPublicKey() {
        return Base64.getEncoder().encodeToString(publicKey.getEncoded());
    }

    public String getEncodedPrivateKey() {
        return Base64.getEncoder().encodeToString(privateKey.getEncoded());
    }

    public void setEncodedPublicKey(String encodedKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        this.publicKey = KeyFactory.getInstance(ALGORITHM).generatePublic(new X509EncodedKeySpec(decodedKey));
    }

    public void setEncodedPrivateKey(String encodedKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        this.privateKey = KeyFactory.getInstance(ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(decodedKey));
    }
}