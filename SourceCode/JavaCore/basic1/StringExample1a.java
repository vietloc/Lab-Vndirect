public class StringExample1a {
    public static void main(String[] args) {
        String text = "say hello to everyone";
        System.out.println("length of text is "+ text.length());

        int i = 0;
        while(i < text.length()){
            char c = text.charAt(i);
            if(c == ' '){
                i++;
                continue;
            }
            System.out.println("Character at "+ i + " is " + c);
            i++;
        }
    }
}
