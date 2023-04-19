package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RequestInfoController {

    @RequestMapping("/requestInfo")
    public String requestInfo(HttpServletRequest request, Model model) {
        model.addAttribute("ContentLength", request.getContentLength());  // 요청 내용의 길이. 알수 없을 때는 -1
        model.addAttribute("ContentType", request.getContentType()); // 요청 내용의 타입. 알 수 없을 때는 null
        model.addAttribute("CharacterEncoding", request.getCharacterEncoding());

        model.addAttribute("Method", request.getMethod());      // 요청 방법
        model.addAttribute("Protocol", request.getProtocol());  // 프로토콜의 종류와 버젼 HTTP/1.1
        model.addAttribute("Scheme", request.getScheme());      // 프로토콜

        model.addAttribute("ServerName", request.getServerName()); // 서버 이름 또는 ip주소
        model.addAttribute("ServerPort", request.getServerPort()); // 서버 포트
        model.addAttribute("RequestURL", request.getRequestURL()); // 요청 URL
        model.addAttribute("RequestURI", request.getRequestURI()); // 요청 URI

        model.addAttribute("ContextPath", request.getContextPath()); // context path
        model.addAttribute("ServletPath", request.getServletPath()); // servlet path
        model.addAttribute("QueryString", request.getQueryString()); // 쿼리 스트링

        model.addAttribute("LocalName", request.getLocalName()); // 로컬 이름
        model.addAttribute("LocalPort", request.getLocalPort()); // 로컬 포트

        model.addAttribute("RemoteAddr", request.getRemoteAddr()); // 원격 ip주소
        model.addAttribute("RemoteHost", request.getRemoteHost()); // 원격 호스트 또는 ip주소
        model.addAttribute("RemotePort", request.getRemotePort()); // 원격 포트

        return "testView/requestInfo";
    }
}
