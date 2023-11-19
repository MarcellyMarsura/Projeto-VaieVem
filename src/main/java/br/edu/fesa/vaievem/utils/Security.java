
package br.edu.fesa.vaievem.utils;

import br.edu.fesa.vaievem.exception.PersistenciaException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Security {
    private static MessageDigest getInstanceMD5() throws PersistenciaException{
        try {
            return MessageDigest.getInstance("MD5");
            
        } catch(NoSuchAlgorithmException e){
            throw new PersistenciaException("Erro ao carregar criptografia");
        } 
    }
    
    public static String EncriptaString(String string) throws PersistenciaException{
        MessageDigest md = getInstanceMD5();
        
        BigInteger hash = new BigInteger(1, md.digest(string.getBytes()));
        
        return hash.toString(16);
    }
    
    public static boolean ComparaSenha(String senhaDB, String senhaForm) throws PersistenciaException{
        return senhaDB.equals(EncriptaString(senhaForm));
    }
}
