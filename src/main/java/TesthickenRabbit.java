public class TesthickenRabbit {
    public static void main(String[] args) {
        int x,y;
        for (x = 0; x <=35 ; x++) {
            y=35-x;
            if (x*2+y*4==94) {
                System.out.println("鸡："+x+"\n兔子："+y);
            }
        }
    }
}
