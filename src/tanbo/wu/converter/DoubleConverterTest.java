/*
* @Author:2017110342_吴谭波
* @Description:设计一个测试类来测试 DoubleConverter。
3.1 当测试类开始运行时，要求用户从键盘输入一个字符串，然后调用 DoubleConverter 的方法将字符串转换
成为一个浮点型的数值。
3.2 当用户输入的字符串不是浮点数时，则提示“你输入的不是浮点数。”，并要求重新输入。
3.3 若用户输入的是浮点数，则打印该值的内容，最后退出程序。
* @Date: 2019/10/05
* @Modified By:2017110342_吴谭波
 */

package tanbo.wu.converter;

import java.util.Scanner;

public class DoubleConverterTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String org = input.next();
        while (!isFloat(org)) {
            System.out.println("error");
            org = input.next();
        }
        boolean isSuccess;
        DoubleConverter doubleConverter = new DoubleConverter();
        isSuccess = doubleConverter.convert(org);
        if (isSuccess){
            System.out.println("The result is:"+ doubleConverter.result);
        }
    }

    public static boolean isFloat(String org){
        char charArray[] = org.toCharArray();
        int figureNum = 0;
        int pointNum = 0;
        for(int i = 0;i < org.length();i++){
            if(charArray[i] == '.'){
                pointNum++;
            }
            if(charArray[i] <= '9' && charArray[i] >= '0'){
                figureNum++;
            }
            if(pointNum == 1 && figureNum + pointNum == org.length()){
                return true;
            }
        }
        return false;
    }
}
