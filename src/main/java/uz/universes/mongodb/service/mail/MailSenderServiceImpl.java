package uz.universes.mongodb.service.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.universes.mongodb.service.CasheService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class MailSenderServiceImpl implements MailSenderService {
    private final CasheService casheService;
    private boolean on=false;

    public MailSenderServiceImpl(CasheService casheService) {
        this.casheService = casheService;
    }

    @Override
    public void sendVerificationMail(Map<Object, Object> model) {
        if (on) {
            log.info("Connection to SMTP service");
            log.info("Connection Mail : " + model);
        }else {
            log.info("Cashing model : "+model);
            casheService.put(model);
        }
    }

    @Override
    public Boolean turnOnOffSMTPservice() {
        return this.on=!on;
    }
    public Boolean isSMTPActive() {
        return on;
    }


    @Override
    public ConcurrentHashMap<Object, Map<Object, Object>> getCashe(){
        return casheService.getCashe();
    }
}
