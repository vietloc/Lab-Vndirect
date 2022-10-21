/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author AD
 */
public class AwtExample1 extends Frame{
    private List list;
    
    public AwtExample1(){
//            setLayout(new FlowLayout());
            setLayout(new BorderLayout());
            
            final TextField text = new TextField();
            
            add(text, BorderLayout.PAGE_START);
            
            list = new List(4, true);
            IntStream.range(0, 10).forEach(i ->{
                list.add("Item " + i);
            });
            //tao menubar
            MenuBar menuBar = new MenuBar();
            setMenuBar(menuBar);
            
            Menu menu = new Menu("FileItem");
            menuBar.add(menu);
            
            
            
            MenuItem menuItem = new MenuItem("Exit", new MenuShortcut('X'));
            menu.add(menuItem);
            menuItem.addActionListener(e->{
                System.exit(1);
            });
//            add(text, BorderLayout.CENTER); 
            add(list, BorderLayout.CENTER); //add list
            Button pushButton = new Button("press me");
            
            add(pushButton, BorderLayout.PAGE_END);
//            add(pushButton, BorderLayout.LINE_END);
            pushButton.addActionListener(new ActionListener(){
                @Override
            public void actionPerformed(ActionEvent e){
                
                menu.setLabel(text.getText());
                
//                //lay gtri trong list gan vao values
//                String[] values = list.getSelectedItems();
//                
//                //tao doi tuong
//                StringBuilder builder = new StringBuilder();
//                
//                //chay qua tat ca cac dong trong values va noi vao array bang append.
//                Arrays.stream(values).forEach(value -> {
//                    if(builder.length()>0){
//                        builder.append("; ");
//                    }builder.append(value);
//                });
//                text.setText(builder.toString());
////                    System.out.println(text.getText());
////set title
//                AwtExample1.this.setTitle(text.getText());
                Supplier<StringBuilder> supplier = StringBuilder::new;
                BiConsumer<StringBuilder, String>consumer = (builder, value)->{
                  if(builder.length()>0)builder.append(",");
                  builder.append(value);
                };
                BinaryOperator<StringBuilder> operator = StringBuilder::append;
                Function<StringBuilder, String>finisher = StringBuilder::toString;
                
                String[]values = list.getSelectedItems();
                Collector<String, StringBuilder, String>collector = Collector.of(supplier, consumer, operator, finisher);
                text.setText(Arrays.stream(values).collect(collector));
                
                Arrays.stream(values).collect(Collectors.joining(","));
                }
            });
            
    }
    
}
