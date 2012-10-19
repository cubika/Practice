/*package puzzler;

public class UnwelcomeGuest {
    public static final long GUEST_USER_ID = -1;

    private static final long USER_ID;
    static {
        try {
            USER_ID = getUserIdFromEnvironment();
        } catch (IdUnavailableException e) {
        	//编译器无法判断对一个空final赋值多次逻辑上是否正确，因此采用不允许赋值两次的策略
            USER_ID = GUEST_USER_ID;
            System.out.println("Logging in as guest");
        }
    }

    private static long getUserIdFromEnvironment() 
            throws IdUnavailableException { 
        throw new IdUnavailableException(); // Simulate an error
    }

    public static void main(String[] args) {
        System.out.println("User ID: " + USER_ID);
    }
}

class IdUnavailableException extends Exception { 
}*/

