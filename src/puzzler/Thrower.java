package puzzler;

public class Thrower {
    public static void main(String[] args) {
        sneakyThrow(new Exception("This is a checked exception"));
    }
    private static Throwable t;
    public Thrower() throws Throwable{
    	throw t;
    }

    /*
     * Provide a body for this method to make it throw the specified exception.
     * You must not use any deprecated methods.
     */
    public static void sneakyThrow(Throwable t) {
    	Thrower.t=t;
    	try {
    		//new Instance�����޲ι��캯�����׳��쳣��Ȼ��ȴû�б�����
			Thrower.class.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
    }
}
