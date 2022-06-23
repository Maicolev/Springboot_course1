package com.bagofideas.springboot.scheduleinterceptor.app.interceptors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

@Component("schedule")
public class ScheduleInterceptor implements HandlerInterceptor
{
    @Value("${config.schedule.opening}")
    private Integer opening;

    @Value("${config.schedule.closed}")
    private Integer closed;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        if(hour >= opening && hour < closed)
        {

            StringBuilder message = new StringBuilder("BWelcome to the customer service schedule");
            message.append(", We serve from ");
            message.append(opening);
            message.append("hrs. ");
            message.append("until ");
            message.append(closed);
            message.append("hrs. ");
            message.append("Thanks for the visit.");
            request.setAttribute("message", message.toString());
            return true;
        }
        response.sendRedirect(request.getContextPath().concat("/closed"));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
        String message = (String) request.getAttribute("message");

        if(modelAndView != null && handler instanceof HandlerMethod)
        {
            modelAndView.addObject("schedule", message);
        }
    }
}
