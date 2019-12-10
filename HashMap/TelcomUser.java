import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.*;
class TelcomUser {
	private String phoneNumber;
	private String callTo;  
	
 HashMap communicationRecords;
	public TelcomUser(String phoneNumber) {
		this.phoneNumber = phoneNumber;
this.communicationRecords=new HashMap();
	}
	void generateCommunicateRecord() {
		int recordNum = new Random().nextInt(10);
		for(int i = 0; i <= recordNum; i++) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.HOUR, - new Random().nextInt(10));
			long timeStart = cal.getTimeInMillis();
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
		
			this.callTo = getCallToPhoneNumber();
		
			this.communicationRecords.put(this.callTo,
					 timeStart + 
					";" + timeEnd + 
					";" + this.phoneNumber+
					";");
		}
	}

	private String getCallToPhoneNumber() {
		return "1380372" + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10))
			 + String.valueOf(new Random().nextInt(10));
	}
	private String accountFee(long timeStart, long timeEnd) {
		double feePerMinute = 0.2;
		int minutes = Math.round((timeEnd - timeStart)/60000);
		double feeTotal = feePerMinute * minutes;
		return String.format("%.4f", feeTotal);
	}

	void printDetails() {
		Set keySet=communicationRecords.keySet();
		Iterator it=keySet.iterator();
		while(it.hasNext()){
			System.out.println("---------通话记录分割线---------");
			//Map.Entry entry=(Map.Entry) (it.next());
			Object key=it.next();
			Object value=communicationRecords.get(key);
			//System.out.println(value);
			//System.out.println();
			String [] recordField = ((String) value).split(";");
			System.out.println("主叫：" + recordField[2]);
			//System.out.println("被叫：" + recordField[3]);
			Date timeStart = new Date(Long.parseLong(recordField[0]));
			Date timeEnd = new Date(Long.parseLong(recordField[1]));
	
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
					
			System.out.println("通话开始时间：" + simpleDateFormat.format(timeStart));
			System.out.println("通话结束时间：" + simpleDateFormat.format(timeEnd));
			
			System.out.println("计费：" 
					+ accountFee(Long.parseLong(recordField[0]), Long.parseLong(recordField[1]))
					+ " 元。");
		}
	}
}
