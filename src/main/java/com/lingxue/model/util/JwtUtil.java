package com.lingxue.model.util;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.*;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import static com.lingxue.model.constants.CommonConstant.Token_DayTimeOut;

/**
 *@Author Wisdom
 *@date 2019/12/22 16:21
 *@description 生成token验证码
 *return
 */
public class JwtUtil {

    /**
     *@Author 86151
     *@Date 2019/12/22 16:39
     *Description 获取到json转换的token
     @Param
     *return
     */
    public static String getTokenByJson(Map<String,Object> clainMaps,String encryKey){
        return getToken(clainMaps,true,encryKey);
    }

    /**
     *@Author 86151
     *@Date 2019/12/22 16:23
     *Description 获取token
     @Param
     *return
     */
    private static String getToken(Map<String, Object> claimMaps, boolean isJsonMpas, String encryKey){

        if (isJsonMpas){
            claimMaps.forEach((key,val)->{
                claimMaps.put(key, JSON.toJSONString(val));
            });
        }

        //获取当前毫秒
        long currentTime = System.currentTimeMillis();

        //利用jwt完成token条件限定
        return Jwts.builder()
                .setId(UUID.randomUUID().toString())  //通过id设置
                .setIssuedAt(new Date(currentTime))   //签发时间
                .setSubject("System")  //说明
                .setIssuer("anqin")   //签发者信息
                .setAudience("custom")   //接收者
                .compressWith(CompressionCodecs.GZIP)   //数据已压缩包的方式
                .signWith(SignatureAlgorithm.ES256,encryKey) //加密方式
                .setExpiration(new Date(currentTime + Token_DayTimeOut * 1000)) //过期时间，默认超过30分钟就宕机
                .addClaims(claimMaps)  //cla信息
                .compact();
    }

    /**
     *@Author 86151
     *@Date 2019/12/22 16:42
     *Description 获取token中的claims值
     @Param
     *return
     */

    public static String getSignature(String token, String encryKey){
        try {
            return getJws(token,encryKey).getSignature();
        }catch (Exception e){
            return "";
        }
    }

    /**
     *@Author 86151
     *@Date 2019/12/22 16:49
     *Description 获取token的请求头head信息
     @Param
     *return
     */
    public static JwsHeader getHeader(String token, String encryKey){
        try {
            return getJws(token, encryKey).getHeader();
        }catch (Exception e){
            return null;
        }
    }

    /**
     *@Author 86151
     *@Date 2019/12/22 16:51
     *Description 获取payload body信息
     @Param 
     *return
     */
    public static Claims getClaimsBody(String token, String encryKey){
        return getJws(token,encryKey).getBody();
    }

    /**
     *@Author 86151
     *@Date 2019/12/22 16:52
     *Description 获取body中的某个值
     @Param
     *return
     */
    public static Object getVal(String token, String encryKey, String key){
        return getJws(token,encryKey).getBody().get(key);
    }

    /**
     *@Author 86151
     *@Date 2019/12/22 16:54
     *Description 获取body中的某个值，json转实体
     @Param
     *return
     */
    public static <T> T getValByT(String token, String encryKey, String key, Class<T> tClass){
        try {
            String strJson = (String) getVal(token,encryKey,key);

            return JSON.parseObject(strJson,tClass);
        }catch (Exception e){
            return null;
        }
    }

    /**
     *@Author 86151
     *@Date 2019/12/22 16:59
     *Description 判断是否过期
     @Param
     *return
     */
    public static boolean isExpiration(String token, String encryKey){
        try {
            return getClaimsBody(token,encryKey)
                    .getExpiration()
                    .before(new Date());
        }catch (Exception e){
            return true;
        }
    }

    public static String getSubject(String token, String encryKey){
        try {
            return getClaimsBody(token,encryKey).getSubject();
        }catch (Exception e){
            return "";
        }
    }

    private static Jws<Claims> getJws(String token, String encryKey){
        return Jwts.parser()
                .setSigningKey(encryKey)
                .parseClaimsJws(token);
    }
}
