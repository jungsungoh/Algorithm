package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import virus.Corona;

public class CoronaStreamTest {
	public static void main(String[] args) {
		List<Corona> list = new ArrayList<Corona>();
		
		Random r = new Random();
		for(int i=0; i<10000; i++) {
			String name = "Corona" + i;
			int level = r.nextInt(50);
			String spreadSpeed = "S" + r.nextInt(10);
			list.add(new Corona(name, level, spreadSpeed));
		}
		//구현
		Stream<Corona> a = list.stream().filter(x -> (x.getLevel()>=30));
		long count = a.count();
		System.out.println("Corona Count : " + count);
	}
}
