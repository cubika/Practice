package enumerated;

//ö������
public enum Spaceship {
	SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;
	public String toString(){
		//ö�ٳ���������
		String id=name();
		String lower=id.substring(1).toLowerCase();
		return id.charAt(0)+lower;
	}
	
	public static void main(String[] args){
		//values�����Ǳ���������ȥ�ľ�̬����
		for(Spaceship s:values())
			System.out.println(s);
	}
	
}
