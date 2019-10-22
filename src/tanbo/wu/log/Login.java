/*
* @Author:2017110342_吴谭波
* @Description:完成用户登录注册功能
* @Date: 2019/10/05
* @Modified By:2017110342_吴谭波
 */


package tanbo.wu.log;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
    public static String[] userNameArray = new String[100] ;
    public static String[] screenNameArray = new String[100];
    public static String[] passwordArray = new String[100];
    public static String[] emailAddressArray = new String[100];
    public static String[] answerArray = new String[100];
    public static int userCount = 0;
    public static void main(String[] args){
        mainMenue();
    }
    public static void mainMenue () {
        Scanner input = new Scanner(System.in);
        System.out.println("1.系统登陆");
        System.out.println("2.系统设置");
        System.out.println("3.写日记");
        System.out.println("4.查找日记");
        System.out.println("5.退出系统");
        System.out.println("请选择：");
        int option = input.nextInt();
        while (!(option >= 1 && option <= 5)) {
            System.out.println("Input Error,input again");
            option = input.nextInt();
        }
        switch (option) {
            case 1:
                loginMenue();
                break;
            case 2:
            case 3:
            case 4:
                System.out.println("用户未登录,请先登录");
                break;
            case 5:
                System.out.println("谢谢使用,再见!");
                System.exit(0);
                break;
        }
    }

    public static void loginMenue(){
        System.out.println("1.注册");
        System.out.println("2.登录");
        System.out.println("3.找回密码");
        System.out.println("4.返回上一级菜单");
        System.out.println("请选择:");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        switch(option) {
            case 1:
                System.out.println("请输入用户名:");
                String username = input.next();
                while (!usernameIsRight(username)) {
                    System.out.println("请重新输入用户名:");
                    username = input.next();
                }
                userNameArray[userCount] = username;
                System.out.println("请输入显示名:");
                String screenName = input.next();
                while (!screenNameIsRight(screenName)){
                    System.out.println("请重新输入显示名:");
                    screenName = input.next();
                }
                screenNameArray[userCount] = screenName;
                System.out.println("请输入密码:");
                String password = input.next();
                while (!passwordIsRight(password)){
                    System.out.println("请重新输入密码:");
                    password = input.next();
                }
                passwordArray[userCount] = password;
                System.out.println("请确认密码:");
                String confirmPassword = input.next();
                while (!confirmPasswordIsRight(password,confirmPassword)){
                    System.out.println("请重新输入确认密码:");
                    confirmPassword = input.next();
                }
                System.out.println("请输入邮箱:");
                String mailAddress = input.next();
                while (!mailAddressIsRight(mailAddress)){
                    System.out.println("请重新输入邮箱:");
                    mailAddress = input.next();
                }
                emailAddressArray[userCount] = mailAddress;
                System.out.println("请选择密码提示问题:");
                System.out.println("1.Q1");
                System.out.println("2.Q2");
                System.out.println("3.Q3");
                System.out.println("4.Q4");
                System.out.println("5.Q5");
                int choice = input.nextInt();
                System.out.println("请回答密码提示问题:");
                String answer = input.next();
                while (!answerIsRight(answer)){
                    System.out.println("请重新回答密码提示问题:");
                    answer = input.next();
                }
                answerArray[userCount] = answer;
                System.out.println("请作答:5*3-6=");
                int result = input.nextInt();
                if(result == 9) System.out.println("注册成功!");
                else{
                    System.out.println("请作答:5*4-6=");
                    result = input.nextInt();
                    if(result == 14) System.out.println("注册成功!");
                    else{
                        System.out.println("请作答:1*4+2=");
                        result = input.nextInt();
                        if(result ==6) System.out.println("注册成功!");
                        else{
                            System.out.println("请作答:8/4+3=");
                            result = input.nextInt();
                            if(result == 5) System.out.println("注册成功!");
                            else{
                                System.out.println("请作答:9/3-6=");
                                result = input.nextInt();
                                if(result == -3) {
                                    System.out.println("注册成功!");
                                }
                                else{
                                    System.out.println("注册失败!");
                                }
                            }
                        }
                    }
                }
                userCount++;
                loginMenue();
                break;
            case 2:
                System.out.println("请输入用户名:");
                username = input.next();
                while (!usernameIsRight(username)) {
                    System.out.println("请重新输入用户名:");
                    username = input.next();
                }
                System.out.println("请输入密码:");
                password = input.next();
                while (!passwordIsRight(password)){
                    System.out.println("请重新输入密码:");
                    password = input.next();
                }
                if(checkInformation(username,password)){
                    logoutMenue(username);
                }
                break;
            case  3:
                System.out.println("请选择密码提示问题:");
                System.out.println("1.Q1");
                System.out.println("2.Q2");
                System.out.println("3.Q3");
                System.out.println("4.Q4");
                System.out.println("5.Q5");
                choice = input.nextInt();
                System.out.println("请输入密码提示问题答案:");
                answer = input.next();
                if(answer.equals(answerArray[userCount-1])){
                    System.out.println("请输入新密码:");
                    password = input.next();
                    while (!passwordIsRight(password)){
                        System.out.println("请重新输入新密码:");
                        password = input.next();
                    }
                    System.out.println("请确认密码:");
                    confirmPassword = input.next();
                    while (!confirmPasswordIsRight(password,confirmPassword)){
                        System.out.println("请重新输入确认密码:");
                        confirmPassword = input.next();
                    }
                    passwordArray[userCount-1] = password;
                }
                loginMenue();
                break;
        }
    }

    public static void logoutMenue(String username){
        Scanner input = new Scanner(System.in);
        int option;
        System.out.println("1.[" + username + "]" + "退出登录" );
        System.out.println("2.系统设置");
        System.out.println("3.写日记");
        System.out.println("4.查找日记");
        System.out.println("5.退出系统");
        System.out.println("请选择：");
        option = input.nextInt();
        switch (option){
            case 1:
                loginMenue();
                break;
            case 2:
                System.out.println("正在执行系统设置功能");
                logoutMenue(username);
                break;
            case 3:
                System.out.println("正在执行写日记功能");
                logoutMenue(username);
                break;
            case 4:
                System.out.println("正在执行查找日记功能");
                logoutMenue(username);
                break;
            case 5:
                System.out.println("正在退出系统功能");
                logoutMenue(username);
                break;
        }

    }

    public static void secondMenue () {
        System.out.println("1.按标题查找");
        System.out.println("2.按内容查找");
        System.out.println("3.按日期查找");
        System.out.println("4.按心情查找");
        System.out.println("5.按天气查找");
        System.out.println("6.返回上一层菜单");
        System.out.println("请选择：");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        while (!(option >= 1 && option <= 6)) {
            System.out.println("Input Error,input again");
            option = input.nextInt();
        }
        switch (option) {
            case 1:
                System.out.println("正在执行按标题查找功能");
                break;
            case 2:
                System.out.println("正在执行按内容查找功能");
                break;
            case 3:
                System.out.println("正在执行按日期查找功能");
                break;
            case 4:
                System.out.println("正在执行按心情查找功能");
                break;
            case 5:
                System.out.println("正在执行按天气查找功能");
                break;
            case 6:
                mainMenue();
                break;
        }
    }

    public static boolean usernameIsRight(String username){
        if(!(username.charAt(0) >= 'A' && username.charAt(0) <= 'z')){
            return false;
        }
        if(!(username.length() >=6 && username.length() <= 20)){
            return false;
        }
        for(int i = 0;i < username.length();i++){
            if(!((username.charAt(i) >= '0' && username.charAt(i) <= '9') || (username.charAt(i) >= 'A' && username.charAt(i) <= 'z') || username.charAt(i) == '_')){
                return false;
            }
        }
        return true;
    }

    public static boolean screenNameIsRight(String screenName){
        if(!(screenName.length() >= 3 && screenName.length() <= 20)){
            return false;
        }
        return true;
    }

    public static boolean passwordIsRight(String password){
        boolean hasFigure = false;
        boolean hasLetter = false;
        boolean hasFix = false;
        if(!(password.length() >= 8 && password.length() <= 30)){
            return false;
        }
        for (int i = 0;i < password.length();i++){
            if(password.charAt(i) <= '9' && password.charAt(i) >= '0') hasFigure = true;
            if(password.charAt(i) <= 'z' && password.charAt(i) >= 'A') hasLetter = true;
            if(password.charAt(i) == '!' || password.charAt(i) == '@' || password.charAt(i) == '#' || password.charAt(i) == '$' || password.charAt(i) == '%' || password.charAt(i) == '*' || password.charAt(i) == '^' ){
                hasFix = true;
            }
            if (hasFigure && hasFix && hasLetter){
                return true;
            }
        }
        return false;
    }

    public static boolean confirmPasswordIsRight(String password,String confirmPassword){
        return password.equals(confirmPassword);
    }

    public static boolean mailAddressIsRight(String mailAddress){
        if (mailAddress == null)
            return false;
        if(!(mailAddress.length() <= 50)){
            return false;
        }
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(mailAddress);
        if (m.matches())
            return true;
        else
            return false;
    }

    public static boolean answerIsRight(String answer){
        if (answer == null){
            return false;
        }
        else{
            return true;
        }
    }

    public static boolean checkInformation(String username,String password){
        for(int i = 0;i < userCount;i++){
            if(userNameArray[i].equals(username)){
                if(passwordArray[i].equals(password)){
                    return true;
                }
            }
        }
        return false;

    }
}

