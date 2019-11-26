import tv.TV;
import tv.HaierTV;
import tv.HisenseTV;

import factory.TVFactory;
import factory.HaierTVFactory;
import factory.HisenseTVFactory;
import utility.XMLUtilTV;



public class Main {

	public static void main(String[] args) {
		
		TV tv;
                               TVFactory factory;
		factory=(TVFactory )XMLUtil.getBean();
		tv = factory.produceTV();
		tv.play();

	}

}
