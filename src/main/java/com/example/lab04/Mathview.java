package com.example.lab04;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Route("index1")
public class Mathview extends VerticalLayout {
    TextField num1 = new TextField("num1");
    TextField num2 = new TextField("num2");
    TextField answer = new TextField();
    public Mathview(){

        HorizontalLayout but = new HorizontalLayout();
        Button butplus = new Button("+");
        Button butminus = new Button("-");
        Button butmulti = new Button("X");
        Button butdivide = new Button("/");
        Button butmod = new Button("Mod");
        Button butmax = new Button("Max");

        but.add(butplus, butminus, butmulti, butdivide, butmod, butmax);
        add(num1, num2, but, answer);
        butplus.addClickListener(e->{
            aNswer("plus");
        });
        butminus.addClickListener(e->{
            aNswer("minus");
        });
        butmulti.addClickListener(e->{
            aNswer("multiply");
        });
        butdivide.addClickListener(e->{
            aNswer("divide");
        });
        butmod.addClickListener(e->{
            aNswer("mod");
        });
        butmax.addClickListener(e->{
            int a = Integer.parseInt(num1.getValue());
            int b = Integer.parseInt(num2.getValue());
            String out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/max")
                    .body(Mono.just(new Maxie(a, b)), Maxie.class)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            answer.setValue(out);
        });
    }
    public void aNswer(String hogkaw){
        int a = Integer.parseInt(num1.getValue());
        int b = Integer.parseInt(num2.getValue());

        String out = WebClient.create()
                .get()
                .uri("http://localhost:8080/" + hogkaw + "/" + a + "/" + b)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        answer.setValue(out);
    }

}
