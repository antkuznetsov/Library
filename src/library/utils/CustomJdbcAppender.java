package library.utils;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

/**
 * Created by Kuznetsov on 14/04/2017.
 */

public class CustomJdbcAppender extends AppenderSkeleton {

    private String myMailToSend;

    public String getMyMailToSend() {
        return myMailToSend;
    }
    public void setMyMailToSend(String myMailToSend) {
        this.myMailToSend = myMailToSend;
    }

    @Override
    protected void append(LoggingEvent event) {

        try
        {
            SendMailTLS mail = new SendMailTLS();
            String t = (String) event.getMessage();
            mail.sendMyMail("Я работаю, но я упал: " + t, myMailToSend);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}