package uz.universes.mongodb;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import uz.universes.mongodb.service.CasheService;
import uz.universes.mongodb.service.mail.MailSenderService;
import uz.universes.mongodb.service.mail.MailSenderServiceImpl;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;


@SpringBootApplication
@EnableAsync
@EnableScheduling
@Slf4j
@RequiredArgsConstructor
public class MongodbApplication {
    private final CasheService casheService;
    private final MailSenderService mailSenderService;
    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class,args);
    }

    @Scheduled(initialDelay = 5,fixedDelay = 60,timeUnit = TimeUnit.SECONDS)
    public void sendCashedVerificationMails(){
        if (mailSenderService.isSMTPActive()) {
            ConcurrentHashMap<Object, Map<Object, Object>> cashe = casheService.getCashe();
            cashe.forEach((k, value) -> {
                mailSenderService.sendVerificationMail(value);
                cashe.remove(k);
            });
        } else {
            log.info("SMTP Dervice Off");
        }
    }

}
