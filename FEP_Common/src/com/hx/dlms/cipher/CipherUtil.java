package com.hx.dlms.cipher;

import java.nio.ByteBuffer;

import cn.hexing.fk.utils.HexDump;

public final class CipherUtil {
	public static final byte[] NULL_KEY = new byte[0];
	public static final byte[] NULL_MAC = HexDump.toArray("000000000000000000000000");
	public static final byte[] ZERO_KEY = HexDump.toArray("00000000000000000000000000000000");

	public static final byte[] cat( byte[] src1, byte[] src2 ){
		if( null == src1 && null == src2 )
			return null;
		if( null == src1 || src1.length == 0 )
			return src2;
		else if( null == src2 || src2.length == 0 )
			return src1;
		ByteBuffer buf = ByteBuffer.allocate(src1.length+src2.length);
		buf.put(src1).put(src2);
		return buf.array();
	}
}
