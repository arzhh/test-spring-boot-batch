import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {
        "configuration"
})
public class SpringBootBatchProcessingApplication {

    public static void main(String[] args) {
        for (String arg : args){
            System.err.println(arg);
        }
        SpringApplication.run(SpringBootBatchProcessingApplication.class, args);
    }
}
