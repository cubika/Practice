package puzzler;

public class AnimalFarm {
	
	//pig和dog指向不同的对象，所以打印错误
	//+连接操作符要比==的优先级高，所以造成("Animals are equal: "+pig)==dog的判断
	//所以，对布尔表达式需要加括号，在此例中更应该使用equals
    public static void main(String[] args) {
        final String pig = "length: 10";
        final String dog = "length: " + pig.length();

        System.out.println("Animals are equal: "
                           + pig == dog);
    }
    
}
