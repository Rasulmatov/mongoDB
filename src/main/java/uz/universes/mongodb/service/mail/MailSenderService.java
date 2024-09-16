package uz.universes.mongodb.service.mail;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface MailSenderService {
    void sendVerificationMail(Map<Object,Object> model);

    Boolean turnOnOffSMTPservice();

   ConcurrentHashMap<Object, Map<Object, Object>> getCashe();
   Boolean isSMTPActive();
}
