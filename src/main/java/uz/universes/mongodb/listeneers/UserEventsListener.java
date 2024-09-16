package uz.universes.mongodb.listeneers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import uz.universes.mongodb.entity.Users;
import uz.universes.mongodb.event.SendMailEvent;
import uz.universes.mongodb.events.OtpGenerateEvent;
import uz.universes.mongodb.repository.UserRepository;
import uz.universes.mongodb.service.mail.MailSenderService;
import uz.universes.mongodb.service.mail.MailSenderServiceImpl;
import uz.universes.mongodb.service.otp.OtpService;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
@RequiredArgsConstructor()
public class UserEventsListener {
    private final OtpService otpService;
    private final MailSenderService mailSenderService;
  //  @EventListener //Oddiy xolatda exception tashlasa ham ishlaydi
   /* @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT,condition = "#event.users.email ne null ") //super method @Transactional method bolsa hozirgi method ozi ishlamaydi assosiy prorsesga xalaqit qilmaydi shunchaki ishlamaydi
    @Transactional(propagation = Propagation.REQUIRES_NEW)*/
    @EventListener
    @Async
    //@Order(2) Tartiblash uchun yani, qaysi brinchi keyingilar qaysi bri ishlasin ?????
    public CompletableFuture<SendMailEvent> generateOtpEventListener(OtpGenerateEvent event) throws InterruptedException {
        //TimeUnit.SECONDS.sleep(10);
        Users users = event.getUsers();
        otpService.generateOtp(users);
        log.info("Generate UUDI: "+event.getUsers());
        //throw new RuntimeException("Hammasi barbot boldi");
        return CompletableFuture.completedFuture(new SendMailEvent(users.getId(),users.getEmail(),users.getOtp()));
    }
    @EventListener(SendMailEvent.class)
    //@Order(1)
    public void verificationMailSender(SendMailEvent event){
       Map<Object,Object> model= Map.of(
                "UserID",event.getId(),
                "Email",event.getEmail(),
                "Otp",event.getOtp()
        );
       mailSenderService.sendVerificationMail(model);
    }
}
