package com.colin.util;

public class Transfer {
	
	public static void main(String[] args)
	{
		//测试各种数据转换方法
	}
	
	/**
	 * StringBuffer转String
	 * @param strBuf
	 * @return	对应的String
	 */
	public static String stringBufferToString(StringBuffer strBuf )
	{
		return strBuf.toString();
	}
	
	/**
	 * String转StringBuffer
	 * @param str
	 * @return	StringBuffer
	 */
	public static StringBuffer stringToStringBuffer(String str)
	{
		return new StringBuffer(str);
	}
	
	/**
	 * String转化成一个一个存储的byte[]数组
	 * @param str
	 * @return	byte[]数组
	 */
	public static byte[] stringToByteArray(String str)
	{
		return str.getBytes();
	}
}
