package testers;

import java.util.LinkedList;

import elements.City;
import graph.Node;
import maps.PuertoRico;
import routes.Astar;

public class AStarAnalisisPR2 {
		//Quantity of how many times to run the test
		protected static int test_Quantity = 100;
		
		//Local variables
		private static int failed = 0;
		private static double executionTime = 0;

		public static void main(String[] arg) {
			//Set Up a testing Graph
			PuertoRico pr2 = new PuertoRico(0.2,0.8); 
			
			//Expected Value
			LinkedList<City> expected = new LinkedList<City>();
			expected.add(pr2.salinas);
			expected.add(pr2.cayey);
			expected.add(pr2.barranquitas);
			
			//AStar Test
			Node<City> start = pr2.getNode(pr2.salinas);
			Node<City> goal = pr2.getNode(pr2.barranquitas);

			System.out.println("A* Search Analisis (PR2 Configuration):");
			
			double successRate = AStarAnalisis(start, goal, expected);
			System.out.println("\nAverage Execution Time: "+(executionTime/test_Quantity)+" ms");
			System.out.println("\nSuccess Rate: "+ (successRate*100)+"%");
			
		}
		
		private static double AStarAnalisis(Node<City> start, Node<City> goal, LinkedList<City> expected) {
			for(int t = 0; t < test_Quantity; t++) {
				long timer = System.currentTimeMillis();
				LinkedList<Node<City>> result = Astar.ARoute(start, goal);
				executionTime += System.currentTimeMillis()-timer;
				//Verify if optimize value was found
				for (int i = 0; i < result.size(); i++) {
					if(!((City)result.get(i).get()).getName().equals(expected.get(i).getName())) {
						failed++;
						break;
					}
				}
			}
			return 1-((double)(failed)/(double)test_Quantity);
		}
		
}
