package cjx.com.diary.util;

import android.content.Context;
import android.widget.Toast;

import java.util.UUID;

/**
 * @author: bear
 * @Description: 常用工具类
 * @date: 2017/5/10
 */

public class Utils {
    /**
     * 显示toast提示
     * @param context 上下文
     * @param message 显示的内容
     */
    public static void showToast(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }

    /**
     * 获取随机的ID作为日记的Uid
     */
    public static String getUUID(){
        return UUID.randomUUID().toString();
    }
}
