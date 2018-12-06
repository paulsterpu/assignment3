package visualiser;

import graphics.Renderer;
import graphics.RendererBuilder;
import io.Parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;

import org.omg.Messaging.SyncScopeHelper;

import java.awt.Color;
import java.awt.Graphics;

public final class Main {
	private static Renderer renderer;
	
	public static RendererBuilder builder = new RendererBuilder();
	
	static List<Task> tasks = readTasks("logs/alfred");
	
	public static Map<visualiser.Color , Color> m = new HashMap<visualiser.Color, Color>();

	public static void main(String[] args) {
		
		//System.out.println(tasks.get(0).getUserEvents().get(0).getArea().getPathInEditor().get(0).getType());
		
		// TODO(5.3): Definiti o mapare intre culorile disponibile in enumeratia Color si culorile
		// echivalente disponibile in pachetul awt. Puteti utiliza coduri RGB pentru a personaliza
		// cat mai mult culorile pe care le folositi.
		
		m.put(visualiser.Color.RED, Color.red);
		m.put(visualiser.Color.GREEN, Color.green);
		m.put(visualiser.Color.BLUE, Color.blue);
		m.put(visualiser.Color.GRAY, Color.gray);
		
		// TODO(5.2): Completati cu dimensiunile potrivite, implementati drawAll si drawClusters
		// si decomentati.
		
		builder
			.circleSize(10);
		
		renderer = builder.build();
		
//		renderer = ...
//				.withDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
//				.withTitle("All data")
//				...
		
		renderer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		renderer.setTitle("All data");
		renderer.setSize(1500, 300);
		drawAll(tasks);
		renderer.draw();
//		
//		renderer = ...
//				.withDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
//				.withTitle("Clusters")
//				...
		renderer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		renderer.setTitle("Cluster");
		drawClusters(tasks);
		renderer.draw();
	}
	
	private static List<Task> readTasks(String path) {
		File[] filesList = new File(path).listFiles();
		List<Task> tasks = new ArrayList<>();
		String logs;
		
		if (filesList == null) {
			return tasks;
		}
		// TODO(1): Apelati consecutiv functia readFromFile, pentru fiecare fisier in parte.
		// TODO(2): Adaugati, pe rand, cate un task in lista de task-uri. Task-ul va fi obtinut
		// prin parsarea log-urilor citite anterior.
		
        for(File p:filesList)
        {
           
        	try {
				logs = Parser.readFromFile(p.toString());
				
				tasks.add(new Task(logs));
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
        	
        }
		
		return tasks;
	}
	
	private static void drawAll(List<Task> tasks) {
		// TODO(5.4): Implementati drawAll. Functia trebuie sa adauge, pe rand, cate un punct din
		// log-urile parsate intr-o instanta a clasei Renderer, utilizand valori alese
		// conventional pentru x si y. Culoarea utilizata va fi cea intoarsa de suprafata din
		// editor pe care s-a dat click.
		// Valoarea pentru x va fi intoarsa de functia getXValueFor, definita mai jos.
		// Valoarea pentru y va fi intoarsa de functia getYValueFor, definita mai jos.
		
		for ( int j = 0 ; j < tasks.size() ; j++ ) {
			
			for ( int i = 0 ; i < tasks.get(j).getUserEvents().size() ; i++ ) {
				
				UserEvent e = tasks.get(j).getUserEvents().get(i);
				
				if ( e.getArea().getPathInEditor().get(0).getType().contains("card") ){
					renderer.addPoint(getXValueFor(tasks.get(j).getUserEvents().get(i)) , getYValueFor(tasks.get(j).getUserEvents().get(i)) , visualiser.Color.RED);
				}
				
				else if ( e.getArea().getPathInEditor().get(0).getType().contains("input") ) {
					renderer.addPoint(getXValueFor(tasks.get(j).getUserEvents().get(i)) , getYValueFor(tasks.get(j).getUserEvents().get(i)) , visualiser.Color.RED);
				}
				
				else if ( e.getArea().getPathInEditor().get(0).getType().contains("page") ){
					renderer.addPoint(getXValueFor(tasks.get(j).getUserEvents().get(i)) , getYValueFor(tasks.get(j).getUserEvents().get(i)) , visualiser.Color.RED);
				}
				
				else if ( e.getArea().getPathInEditor().get(0).getType().contains("menu") ){
					renderer.addPoint(getXValueFor(tasks.get(j).getUserEvents().get(i)) , getYValueFor(tasks.get(j).getUserEvents().get(i)) , visualiser.Color.GREEN);
				}
				
				else if ( e.getArea().getPathInEditor().get(0).getType().contains("menu-button") ){
					renderer.addPoint(getXValueFor(tasks.get(j).getUserEvents().get(i)) , getYValueFor(tasks.get(j).getUserEvents().get(i)) , visualiser.Color.GREEN);
				}
				
				else if ( e.getArea().getPathInEditor().get(0).getType().contains("icon")){
					renderer.addPoint(getXValueFor(tasks.get(j).getUserEvents().get(i)) , getYValueFor(tasks.get(j).getUserEvents().get(i)) , visualiser.Color.GREEN);
				}
				
				else if ( e.getArea().getPathInEditor().get(0).getType().contains("dialog")){
					renderer.addPoint(getXValueFor(tasks.get(j).getUserEvents().get(i)) , getYValueFor(tasks.get(j).getUserEvents().get(i)) , visualiser.Color.BLUE);
				}
				else {
					renderer.addPoint(getXValueFor(tasks.get(j).getUserEvents().get(i)) , getYValueFor(tasks.get(j).getUserEvents().get(i)) , visualiser.Color.GRAY);
				}			
			
			}	
						
			
			
		}
	}
	
	private static void drawClusters(List<Task> tasks) {
		// TODO(5.4): Implementati drawClusters. Mai intai, desenati toate punctele din log-uri
		// utilizand culoarea gri (sau ceva apropiat). Dupa care, desenati pe deasupra, pentru
		// fiecare cluster determinat punctele clusterului. Aveti grija ca:
		// 		* fiecare cluster sa fie desenat cu o alta culoare (puteti, de exemplu, utiliza
		//        culorile definite in Color si sa le alternati circular).
		//      * algoritmul de obtinere al valorilor x si y sa fie acelasi ca in drawAll -
		//        folositi functiie getXValueFor si getYValueFor atat in drawAll, cat si in
		//        drawClusters.
	}
	
	private static int getXValueFor(UserEvent e) {
		// TODO(5.4): Intoarceti o valoare potrivita pentru x, in functie de evenimentul primit.
		
		return e.getTimpestamp();
	}
	
	private static int getYValueFor(UserEvent e) {
		// TODO(5.4): Intoarceti o valoare potrivita pentru y, in functie de evenimentul primit.
		
		if ( e.getArea().getPathInEditor().get(0).getType().contains("card")){
			return 1;
		
		} else if ( e.getArea().getPathInEditor().get(0).getType().contains("input")) {
			return 2;
		
		} else if ( e.getArea().getPathInEditor().get(0).getType().contains("page") ){
			return 3;
		
		} else if ( e.getArea().getPathInEditor().get(0).getType().contains("menu")){
			return 4;
		
		} else if ( e.getArea().getPathInEditor().get(0).getType().contains("menu-button")){
			return 5;
			
		} else if ( e.getArea().getPathInEditor().get(0).getType().contains("icon") ){
			return 6;
		
		} else if ( e.getArea().getPathInEditor().get(0).getType().contains("dialog")){
			return 7;
		
		} else {
			return 8;
		}	
	}
	
	public String mostUsedArea() {
		
		//zona pe care s-au dat cele mai multe click-uri din toate task-urile ; task 4.1
		
		String area = null;	//zona cu cele mai multe click-uri
		
		double max = -1;
		
		for ( int i = 0 ; i < 3 ; i++ ) {
			
			Task t = tasks.get(i);
			Map<String, Double> m = t.computeClicksPerArea();
		
			for ( Entry<String, Double> entry : m.entrySet() ) {
				if ( entry.getValue() > max ) {
					area = entry.getKey();		
				}
			}
		}
		return area;
	}
	
	public int mostUsedTask() {
		
		//task-ul cu cea mai mare frecventa a click-urilor din toate task-urile ; task 4.1
		
		int task = -1;	//task-ul cu cea mai mare frecventa a click-urilor	
		double max = -1;
		
		for ( int i = 0 ; i < 3 ; i++ ) {
			
			Task t = tasks.get(i);			
				if ( t.meanFrequencyPerTenSeconds() > max ) {
					task = i;	
				}
			}
		return task;
	}
}
