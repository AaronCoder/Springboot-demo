package cn.ypf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class JavabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavabaseApplication.class, args);
    }

}
