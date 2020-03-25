package app;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import person.Patient;

public class NetworkHttpServerPatient {
public static void main(String[] args) {
		Patient p1 = new Patient("김모씨", 35, "010-1223-4444","독감", "대학병원",true);
		Patient p2 = new Patient("강모씨", 23, "010-2345-8888","고열", "동네병원",false);
		Patient p3 = new Patient("고모씨", 48, "010-7778-1234","기침", "대학병원",true);
		List<Patient> patientList = new ArrayList<>();
		patientList.add(p1);
		patientList.add(p2);
		patientList.add(p3);
		
		StringBuilder sb = new StringBuilder();
		sb.append("<html><body><h2>환자 정보</h2><table style = 'border: 1px solid green;'>").
		append("<thead><th>성명</th><th>나이</th><th>전화번호</th><th>병명</th><th>병원명</th></thead>");
		for(Patient p : patientList) {
			String name = p.getName().substring(0,1) + "XX";
			String num = p.getPhone().substring(0, p.getPhone().length()-4) + "XXXX";
			sb.append("<tr style = 'border: 1px solid green;'><td>").append(name).append("</td><td>").
			append(String.valueOf(p.getAge())).append("</td><td>").
			append(num).append("</td><td>").
			append(p.getDiseaseName()).append("</td><td>").
			append(p.getHospitalId()).append("</td><td>").
			append("</td></tr>");
		}
		sb.append("</table></body></html>");
		String html = sb.toString();

		try(ServerSocket ss = new ServerSocket(8090)){
			System.out.println("[Patient Info Server is ready]");
			while(true) {
				try(Socket socket = ss.accept()){
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));

					bw.write("HTTP/1.1 200 OK \r\n");
					bw.write("Content-Type: text/html; charset= utf-8\r\n");
					bw.write("Content.length: " + html.length() + "\r\n");
					bw.write("\r\n");
					bw.write(html);
					bw.write("\r\n");
					bw.flush();
				}
			}
			}catch(IOException e) {
				e.printStackTrace();
			}
	}
}
