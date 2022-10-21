import java.awt.*;

public class AwtExample1 extends Frame{
    public AwtExample1(){
        setLayout(new FlowLayout());
        Button pushButton = new Button("press me");
        add(pushButton);
    }
}
