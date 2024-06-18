package example.spring.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect //marks this class as an aspect-->proxy comes into picture
@Component
public class AudienceWithAround {
	@Pointcut("execution(* example.spring.aop.*.perform(..))")
	
	private void myPointCut() {
		
	}
	

	private void takeSeats() {
	 System.out.println("Please take your seats : Around");
   }

	private void turnOffMobiles() {
	 System.out.println("Please turn off your mobile : Around");
   }

	private void clap() {
	 System.out.println("Clap Clap Clap : Around...");
   }

	private void demandForRefund() {
	  System.out.println("Please give our money back : Around");
    }

	private void leave() {
	  System.out.println("Bye,Leaving now : Around... ");
	}
	@Around("myPointCut()")
	public void monitorPerformance(ProceedingJoinPoint joinPoint) {
		takeSeats();
		turnOffMobiles();
		try {
			joinPoint.proceed();//proceed towards target
			clap();
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			demandForRefund();
		} 
		
		leave();
	}
}