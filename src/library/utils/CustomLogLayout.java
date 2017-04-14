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

        String text = (String) event.getMessage();

        StringBuffer sb = new StringBuffer();

        sb.append("Информация 1");
        sb.append(text);

        return sb.toString();
    }
}