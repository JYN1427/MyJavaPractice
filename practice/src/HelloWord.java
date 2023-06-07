public class HelloWord {
    public static void main(String[] args) {
        System.out.println("Hello World");

        int[] mycharlist;
        mycharlist = new int[5];
        int a = 0;
        for(int i=0; i < mycharlist.length; i++) {
            mycharlist[i] = a;
            a++;
        }

        int index = 0;
        for(int i=0; i < 10; i++) {
            System.out.println(mycharlist[index % mycharlist.length]);
            index += 1;
        }


    }
}
