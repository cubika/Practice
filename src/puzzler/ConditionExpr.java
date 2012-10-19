package puzzler;

//任何混合类型的计算都会引起混乱
public class ConditionExpr {

    public static void main(String[] args) {
        char x = 'X';
        int i = 0;
        //0是int型的常量，可以表示为char，则第二操作数和第三操作数都是char
        System.out.print(true  ? x : 0);
        //第二操作数和第三操作数一个是int，一个是char，所以需要将char转换为int
        System.out.print(false ? i : x); 
    }
}
