package com.yamhto.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;

/**
 * 秘钥加密解密类
 * @author tan_wang
 *
 */
public class AESCryptoConverter {

	private static final String SECRET_KEY = "secret.key";

	public final static String DEFAULT_KEY="yak-global-aec-key";
	
	private static String key = DEFAULT_KEY;
	
	static{
		//系统属性中取值
		 String systemKey = System.getProperty(SECRET_KEY);
		 if(StringUtils.isNotBlank(systemKey)){
			 key = systemKey;
		 }else{//从系统环境变量取，如取不到则使用默认
			 String envKey = System.getenv(SECRET_KEY);
			 if(StringUtils.isNotBlank(systemKey)){
				 key = envKey;
			 }
		 }
		 System.out.println(key);
	}
	
	/**
	 * 加密
	 * @param plainText 明文密码
	 * @return
	 */
	public static String encrypt(String plainText){
		String result = AESUtils.encrypt(plainText, key);
		return result;
	}
	
	/**
	 * 解密
	 * @param secrectText 密文
	 * @return
	 */
	public static String decrypt(String secrectText){
		String plainText = AESUtils.decrypt(secrectText, key);;
		return plainText;
	}
	
	public static void main(String[] args) throws IOException {
		String plainText = null;
		//首先从参数中取
		if(args!=null&&args.length>0){
			plainText = args[0];
		}else{ //否则提示用户输入
			System.out.println("请输入需要加密的字符串:");
			BufferedReader buf = new BufferedReader( 
					new InputStreamReader(System.in));
			 plainText = buf.readLine();
			buf.close();
		}
		String secrectText = AESCryptoConverter.encrypt(plainText);
		System.out.println("加密后的密码为：      "+secrectText);
		System.exit(0);
	}
}
