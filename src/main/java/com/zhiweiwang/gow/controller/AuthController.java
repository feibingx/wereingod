package com.zhiweiwang.gow.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiweiwang.gow.utils.SHA1;

@Controller
public class AuthController {

	Logger log = LoggerFactory.getLogger(AuthController.class);

	String TOKEN = "Fei8ingx";

	@RequestMapping("/auth")
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// 微信加密签名
		String signature = request.getParameter("signature");
		// 随机字符串
		String echostr = request.getParameter("echostr");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		String digest = "";
		try {
			log.info("signature:{}", signature);
			log.info("echostr:{}", echostr);
			log.info("timestamp: {}", timestamp);
			log.info("nonce:{}", nonce);
			String[] str = { TOKEN, timestamp, nonce };
			Arrays.sort(str);
			String bigStr = str[0] + str[1] + str[2];

			digest = new SHA1().getDigestOfString(bigStr.getBytes()).toLowerCase();
			log.info("digest:{}", digest);

			log.info("length: " + request.getContentLength());
		} catch (NullPointerException e) {
		}

		travelRequest(request);
		
		BufferedInputStream in = new BufferedInputStream(request.getInputStream());
		byte[] content = new byte[request.getContentLength()];
		in.read(content);

		log.info(new String(content));

		// 确认请求来至微信
		if (digest.equals(signature)) {
			response.getWriter().print(echostr);
			log.info("echo ok");
		} else {
			log.error("not equal");
		}
	}

	private void travelRequest(HttpServletRequest request) {

		Enumeration<?> names = request.getParameterNames();

		while (names.hasMoreElements()) {
			String name = names.nextElement().toString();
			String value = request.getParameter(name);
			log.info("<P>" + name + "::::" + value);
		}

		Enumeration<?> hnames = request.getHeaderNames();
		while (hnames.hasMoreElements()) {
			String name = hnames.nextElement().toString();
			String value = request.getHeader(name);

			log.info("<H>" + name + ":" + value);
		}

	}

}
