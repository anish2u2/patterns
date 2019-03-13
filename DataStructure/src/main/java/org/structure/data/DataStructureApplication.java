package org.structure.data;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.structure.contracts.List;
import org.structure.impl.list.LinkedList;

@SpringBootApplication
public class DataStructureApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DataStructureApplication.class, args);
		Runtime runtime = Runtime.getRuntime();
		System.out.println("Memory used:" + (runtime.totalMemory() - runtime.freeMemory()));
		List<String> list = new LinkedList<String>();
		System.out.println("Memory used:" + (runtime.totalMemory() - runtime.freeMemory()));
		list.add("Hi");
		System.out.println("Memory used:" + (runtime.totalMemory() - runtime.freeMemory()));
		list.add("this");
		System.out.println("Memory used:" + (runtime.totalMemory() - runtime.freeMemory()));
		list.add("is");
		System.out.println("Memory used:" + (runtime.totalMemory() - runtime.freeMemory()));
		list.add("Me");
		System.out.println("Memory used:" + (runtime.totalMemory() - runtime.freeMemory()));
		System.out.println(list.size());
		System.out.println(list.get(3));
		System.out.println(list.remove(3));
		System.out.println(list.get(3));
		System.out.println(list.size());
		list.add("new", 3);
		System.out.println(list.size());
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println(list.get(4));
		System.out.println("Memory used:" + (runtime.totalMemory() - runtime.freeMemory()));
		list.removeAll();
		System.out.println("Memory used:" + (runtime.totalMemory() - runtime.freeMemory()));
		Map<Thread, StackTraceElement[]> threadDump = Thread.getAllStackTraces();
		for (Thread thread : threadDump.keySet()) {
			for (StackTraceElement element : threadDump.get(thread)) {
				System.out.println(element.getFileName() + " " + element.getMethodName());
			}
		}
	}

}
