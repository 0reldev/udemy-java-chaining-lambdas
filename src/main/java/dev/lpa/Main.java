package dev.lpa;

import java.util.Arrays;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        String name = "Tim";
        Function<String, String> uCase = String::toUpperCase;
        System.out.println(uCase.apply(name));
//        TIM

        Function<String, String> lastName = s -> s.concat(" Buchalka");
        Function<String, String> uCaseLastName = uCase.andThen(lastName);
        System.out.println(uCaseLastName.apply(name));
//        TIM Buchalka

        uCaseLastName = uCase.compose(lastName);
        System.out.println(uCaseLastName.apply(name));
//        TIM BUCHALKA

        Function<String, String[]> f0 = uCase
                .andThen(s -> s.concat(" Buchalka"))
                .andThen(s -> s.split(" "));
        System.out.println(Arrays.toString(f0.apply(name)));
//        [TIM, Buchalka]

        Function<String, String> f1 = uCase
                .andThen(s -> s.concat(" Buchalka"))
                .andThen(s -> s.split(" "))
                .andThen(s -> s[1].toUpperCase() + ", " + s[0]);
        System.out.println(f1.apply(name));
//        BUCHALKA, TIM

        Function<String, Integer> f2 = uCase
                .andThen(s -> s.concat(" Buchalka"))
                .andThen(s -> s.split(" "))
                .andThen(s -> String.join(", ", s))
                .andThen(String::length);
        System.out.println(f2.apply(name));
//        13
    }
}
