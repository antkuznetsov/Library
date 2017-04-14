package library.utils;

/**
 * Created by Kuznetsov on 14/04/2017.
 */

import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

public class CustomLogLayout extends PatternLayout
{
    public String format(LoggingEvent event)
    {

        //UserObject user = (UserObject)event.getMessage();

        StringBuffer sb = new StringBuffer();

        //String name = user.getName();
        //String age= user.getAge();
        //String country= user.getCountry();

        sb.append("Я упал :(");

        return sb.toString();
    }
}