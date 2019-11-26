package user;
import java.util.*;
import java.text.*;
public class UnicomUser implements User {
	private String phoneNumber;
	private String callTo;
	private StringBuffer communicationRecords;

	public UnicomUser(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.communicationRecords = new StringBuffer();
	}

// ģ��ͨ����¼������
	public void generateCommunicateRecord() {
		int recordNum = new Random().nextInt(10);
		for (int i = 0; i <= recordNum; i++) {
			// this.phoneNumber=getCallToPhoneNumber();// ������ɵ�i��ͨ����¼
			// ��ʼʱ�䣬��ǰʱ��֮ǰ��ĳ�����ʱ��
			long timeStart = System.currentTimeMillis() - new Random().nextInt(36000000);
			// ����ʱ�俪ʼ���ʮ�����������һ-��ʱ�䣬����һ����
			long timeEnd = timeStart + 60000 + new Random().nextInt(600000);
			this.callTo = getCallToPhoneNumber();// ���к���
			// ����ͨ����¼
			this.communicationRecords
					.append(this.phoneNumber + "," + timeStart + "," + timeEnd + "," + this.callTo + ";");
		}

	}
//����õ��绰��
	public  String getCallToPhoneNumber() {
		return "1159881" + String.valueOf(new Random().nextInt(10)) + String.valueOf(new Random().nextInt(10))
				+ String.valueOf(new Random().nextInt(10)) + String.valueOf(new Random().nextInt(10));
	}

	// ģ��ƷѰ취�����ַ�������ʽ���ر���2λС���ļƷѽ��
	public  String accountFee(long timeStart, long timeEnd) {
		double feePerMinute = 0.3;	
		int minutes = Math.round((timeEnd - timeStart) / 60000);
		double feeTotal = feePerMinute * minutes;
		System.out.println("ͨ��ʱ���� "+minutes+"��");
		return String.format("%.2f", feeTotal);

	}

//��ӡͨ����¼
	public void printDetails() {
		String allRecords = this.communicationRecords.toString();
		String[] recordArray = allRecords.split(";");
		for (int i = 0; i < recordArray.length; i++) {
			String[] recordField = recordArray[i].split(",");
			System.out.println("----------ͨ����¼�ָ���----------");
			System.out.println("���У�" + recordField[0]);
			System.out.println("���У�" + recordField[3]);
			System.out.println("ͨ����ʼʱ�䣺" + new Date(Long.parseLong(recordField[1])));
			System.out.println("ͨ������ʱ�䣺" + new Date(Long.parseLong(recordField[2])));
			System.out
					.println("�Ʒѣ�" + accountFee(Long.parseLong(recordField[1]), Long.parseLong(recordField[2])) + "Ԫ");
		}

	}

}
