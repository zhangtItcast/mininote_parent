package com.changgou.token;

import org.junit.Test;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;

/*****
 *  使用公钥解密令牌数据
 ****/
public class ParseJwtTest {

    /***
     * 校验令牌
     */
    @Test
    public void testParseToken(){
        //令牌
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiaXRoZWltYSIsImlkIjoiMSIsImF1dGhvcml0aWVzIjpbImFkbWluIiwidXNlciJdfQ.FZJGfZGaC6u-gGlgFMWmtuM-gyNUPQY40-5WBYnxkz4c5r_kYqAndUhNNYean47JgWKd0z3m5dnHMS-N08OzYuF4NylFMshQV9qWGmpRjXECkefxG4BKxY54njImvXwu1lAZ0M4vG-LpsV6ESK5RRQkTj5xDpk-C6RsX4WrODh7GZ51beGVWyeVREkOLdChhExKmX3uS8i8DGagUv24Uq-gik9wIs_Cw_8c9riDdPj6wtZSdDhgc-64AhUNKiyzzOwO4c299V5DqOEabCdIQpHQKXHKXm5jf2C7PNaPzw6ihUXTQe58yqW-W_L9kMCKVLV13tXefa8YyARASGoWtSA";

        //公钥
        String publickey = "-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyo13UPlPAXlGrwp478KG6suQCw4NZvtDCryYyhSUmBQCzqmAygv0kF4uq1Tifvx1ayuoSlB/V2n4bO21ZmDY+1vOvtTbKj9CeGPc4ROXRzKbawaXXdrZBu2778RdboqV7idbXK3qLZUvjqPnK+1ZiBlnInndn8DTMtPUxp5xdVo8+1sN2iF1JVuUSTYI3HipHruWoukVx5JZFtuRo1LZOqo+iSrIIEnprHJr9cxJkSjEeBGzVuGgYqmbwG2QhtgwjtZYBTVtQhBckj9WT6pjbzU21oSrLoeOnnkxHXNUsWLaG9Uxlen8/jj9s54Zv4X2u7VKryJ2u0DPII3m/Do9IQIDAQAB-----END PUBLIC KEY-----";

        //校验Jwt
        Jwt jwt = JwtHelper.decodeAndVerify(token, new RsaVerifier(publickey));

        //获取Jwt原始内容
        String claims = jwt.getClaims();
        System.out.println(claims);
        //jwt令牌
        String encoded = jwt.getEncoded();
        System.out.println(encoded);
    }
}
