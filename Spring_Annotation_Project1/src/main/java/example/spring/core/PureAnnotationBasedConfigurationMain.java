package example.spring.core;
//this class releted tho SpringConfig3 class
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import desserts.IceCream;
import desserts.brownies.WalnutBrownie;
import juices.OrangeJuices;
import milkshakes.MangoMilkShake;

public class PureAnnotationBasedConfigurationMain {

	public static void main(String[] args) {
		Class<SpringConfig3> configClass = SpringConfig3.class;
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(configClass);
	
		Class<MyComponent> componentType = MyComponent.class;
	   MyComponent myCompRef = context.getBean(componentType);
	   myCompRef.testMyComponent();
	   
		Class<OrangeJuices> juiceComp = OrangeJuices.class;
		OrangeJuices juiceRef = context.getBean(juiceComp);
		juiceRef.tasteOrangeJuice();
		
		Class<MangoMilkShake> shakeComp = MangoMilkShake.class;
		MangoMilkShake shakeRef = context.getBean(shakeComp);
		shakeRef.tasteMangoMilkShake();
		
		Class<IceCream> iceComp = IceCream.class;
		IceCream iceRef = context.getBean(iceComp);
		iceRef.tasteChocolateIceCream();
		
		Class<WalnutBrownie> brownieComp = WalnutBrownie.class;
		WalnutBrownie brownieRef = context.getBean(brownieComp);
		brownieRef.tasteWalnutBrownie();

	}
	
}
