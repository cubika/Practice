package enumerated;

//枚举类型
public enum Spaceship {
	SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;
	public String toString(){
		//枚举常量的名字
		String id=name();
		String lower=id.substring(1).toLowerCase();
		return id.charAt(0)+lower;
	}
	
	public static void main(String[] args){
		//values方法是编译器加上去的静态方法
		for(Spaceship s:values())
			System.out.println(s);
	}
	
}
