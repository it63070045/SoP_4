package com.example.lab04;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@Route("index2")
public class Cashierview extends VerticalLayout {
    TextField num1 = new TextField("money");
    public Cashierview(){

        TextField b1000 = new TextField(), b500 = new TextField(), b100 = new TextField(), b20 = new TextField(), b10 = new TextField(), b5 = new TextField(), b1 = new TextField();
        Button but = new Button("เงินทอน");
        Div dollarPrefix = new Div();
        dollarPrefix.setText("$");
        num1.setPrefixComponent(dollarPrefix);

        Div d1000 = new Div();
        d1000.setText("$1000:");
        b1000.setPrefixComponent(d1000);

        Div d500 = new Div();
        d500.setText("$500:");
        b500.setPrefixComponent(d500);

        Div d100 = new Div();
        d100.setText("$100:");
        b100.setPrefixComponent(d100);

        Div d20 = new Div();
        d20.setText("$20:");
        b20.setPrefixComponent(d20);

        Div d10 = new Div();
        d10.setText("$10:");
        b10.setPrefixComponent(d10);

        Div d5 = new Div();
        d5.setText("$5:");
        b5.setPrefixComponent(d5);

        Div d1 = new Div();
        d1.setText("$10:");
        b1.setPrefixComponent(d1);
        add(num1, but, b1000, b500, b100, b20, b10, b5, b1);
        but.addClickListener(e->{
            int a = Integer.parseInt(num1.getValue());
            Change out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/getChange/" + a)
                    .retrieve()
                    .bodyToMono(Change.class)
                    .block();
            b1000.setValue(out.getB1000()+"");
            b500.setValue(out.getB500()+"");
            b100.setValue(out.getB100()+"");
            b20.setValue(out.getB20()+"");
            b10.setValue(out.getB10()+"");
            b5.setValue(out.getB5()+"");
            b1.setValue(out.getB1()+"");
        });
    }
}
