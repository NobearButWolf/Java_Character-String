/*
* @Author:2017110342_吴谭波
* @Description:实验任务：
【任务一】：创建一个 DoubleConverter 类，该类的作用是将一个字符串转换成浮点型(double)数值。
要求： 1 DoubleConverter 具有一个属性，double result;
2 DoubleConverter 具有一个方法 boolean convert(String value);
2.1 该方法将参数字符串转换为整数。
2.2 转换若成功，则返回值为 true，并且转换的值存在 result 属性中。
2.3 若转换失败，则返回值为 false，并将 result 属性的值赋 0。
* @Date: 2019/10/05
* @Modified By:2017110342_吴谭波
 */

package tanbo.wu.converter;

public class DoubleConverter {
    double result = 0;
    public boolean convert(String org){
        int pointPosition = org.indexOf('.');
        pointPosition--;
        for(int i = 0;i < org.length();i++){
            if(org.charAt(i) == '.') continue;
            result = result + Math.pow(10,pointPosition)* Integer.parseInt(String.valueOf(org.charAt(i)));
            pointPosition--;

        }
        return  true;
    }
}
