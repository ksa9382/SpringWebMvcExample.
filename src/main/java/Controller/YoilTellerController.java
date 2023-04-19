package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

/**
 * 원격 클라이언트(브라우저)에서 보낸 year, month, day 스트링을
 * HttpServlet Request 객체로 받아, 해당 날짜가 어떤 요일인지 계산 후
 * response 객체를 통해 원격 브라우저에 출력하도록 하는 예제
 * @Date: 2023-04-19
 * @Author: Andrew Kim
 */
@Controller
public class YoilTellerController {
    @RequestMapping("/getYoil")
    public void printYoilInfo(HttpServletRequest request, HttpServletResponse response) {
        // 1. 입력 변환
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        int yyyy = 0, mm = 0, dd = 0;
        try {
            yyyy = Integer.parseInt(year);
            mm = Integer.parseInt(month);
            dd = Integer.parseInt(day);
        }
        catch (NumberFormatException e) {
            // TODO: log4j 출력
            e.printStackTrace();
        }

        // 2. 작업
        Calendar cal = Calendar.getInstance();
        cal.set(yyyy, mm-1, dd);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        char yoil = "일월화수목금토".charAt(dayOfWeek);

        // 3. 출력
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter pw = response.getWriter()) {
            pw.println(year + "년 " + month + "월 " + day + "일은 ");
            pw.println(yoil + "요일 입니다.");
        }
        catch (IOException e) {
            // TODO: log4j 출력
            e.printStackTrace();
        }
    }
}
