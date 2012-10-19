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
    		//new Instance调用无参构造函数，抛出异常，然而却没有被捕获
			Thrower.class.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
    }
}
