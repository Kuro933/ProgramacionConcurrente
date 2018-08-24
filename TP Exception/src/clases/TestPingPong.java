package clases;

public class TestPingPong {

	public static void main(String[] args) {
		PingPong p1 = new PingPong("PING" , 33);
		PingPong p2 = new PingPong("PONG" , 10);
		PingPong p3 = new PingPong("PANG" , 19);
		PingPong p4 = new PingPong("PUNG" , 22);
		//activacion
		
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		
		//espera unos segundos

//		for(int i=0; i<10000; i++) {
//			System.out.println("Crack");
//			try {Thread.sleep(30);
//			}catch(InterruptedException e) {}
//			
//			
//		}
		
		
	}
}
