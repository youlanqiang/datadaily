package season01listStackAndQueue.example;

import java.util.*;

public class PolandNotation {

    public static void main(String[] args) {
        //逆波兰表达式
        //(3+4)x5-6 => 3 4 + 5 x 6 -
        String suffixExpression = "3 4 + 5 x 6 -";
        //1. 先将"3 4 + 5 x 6 -" 放到ArrayList中
        //2. 将ArrayList传递给一个方法，遍历ArrayList配合栈完成计算
        System.out.println(calculate(getListString(suffixExpression)));

        System.out.println(calculate(strToPoland("( 3 + 4 ) x 5 - 6")));
    }

    /**
     * todo 将中缀表达式转为后缀表达式
     * 牢记
     */
    public static List<String> strToPoland(String str){
        List<String> ls = Arrays.asList(str.split(" "));
        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        for (String item : ls) {
            if(item.matches("\\d+")){
                s2.push(item);
            }else if(item.equals("(")){//第一优先级
                s1.push(item);
            }else if(item.equals(")")){//第一优先级
                while(!s1.peek().equals("(")){
                    s2.push(s1.pop());
                }
                s1.pop();//弹出（
            }else if(item.matches("[x/]")){ //第二优先级
                s1.push(item);
            }else if(item.matches("[+-]")){ //第三优先级
                if(!s1.isEmpty() && s1.peek().matches("[x/]")){
                    s2.push(s1.pop());
                    if(!s1.isEmpty() && s1.peek().matches("[+-]")){
                        s2.push(s1.pop());
                    }
                }
                s1.push(item);
            }
        }
        //将剩余操作符压入栈中.
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return new ArrayList<String>(s2);
    }

    //将表达式放入ArrayList中
    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        return Arrays.asList(split);
    }



    //完成逆波兰表达式
    /**
     * 遇到运算符号弹出前2位数字
     */
    public static int calculate(List<String> list){
        //创建一个栈
        Stack<String> stack = new Stack<>();
        //遍历list
        for (String item : list) {
            //这里使用正则表达式来取出数
            if(item.matches("\\d+")){//匹配多位数
                //入栈
                stack.push(item);
            }else{
                //pop 出2个数
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                switch (item) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "x":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                    default:
                        throw new RuntimeException("运算符号有问题");
                }
                stack.push(String.valueOf(res));
            }
        }
        return Integer.parseInt(stack.peek());
    }


}
