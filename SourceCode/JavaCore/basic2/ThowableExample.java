

public class ThowableExample {
        public static class SaiSoException extends Exception{
                private String so;
                public SaiSoException(String value){
                    this.so = value;
                }
        
                public String getMessage(){
                    return "Gia tri\'" + so + "\' khong phai la so!";
                }
            }   
        int toNumber(String value) throws SaiSoException{
           
            try{
                Integer integer = Integer.parseInt(value);
                return integer.intValue();
            } catch(NumberFormatException e){
                throw new SaiSoException(value);
            }
        }
        
        public static void main(String[] args) {
            try{
                System.out.println("Number = " + toNumber(args[0]));
            }catch(SaiSoException e){
                System.out.println(e.getMessage());
            }
        }
        
}
