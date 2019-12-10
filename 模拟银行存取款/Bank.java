package 模拟银行存取款;

import java.util.Scanner;

public class bank {

	int account;
	private static User user;
	public static void main (String[] args) {
		Bank b = new Bank();
		b.login();
		b.operart();
	}
	pubilc  void  operate() {
		Bank b = new Bank();
		while (true){
			System.out.println("请输入您要进行的操作类型，按回车键结束")；
		    System.out.println("存款：1" + "\t" + "取款：2" + "\t" + "余额：3" + "\t" + "退出：0");
			Scanner in = new Scanner( System.in);
			String s = in.nextLine();
			if("1".equals(s) || "2".equals(s) ){
				int num = 0;
				try{
					System.outprint("输入存取的金额：");
					num = Integer .parseInt(in.nextLine());
				}cath(Exception ){
					System.out.println("金额输入错误！");
					continue;
				}
				switch (s) {
				case "1":
					b.income(num);
					break;
				case "2":
					b.takeout(num);
					break;
				}
			}else if("3".equals(s) ){
                                                          b.show();
                                                }else if("0".equals(s) ){
                                                          System.out.println("退出系统！");
                                                          return;
                                                }else {
                                                          System.out.println("请输入0~3之间的数字选择相关操作！");
                                                }
		}
	}
	public void login(){
		DBUtil dbutil = DBUtil.getInstance();
		System.out.println("欢迎进入网上登录系统！")；、
		while (true) {
			Scanner in = new Scanner(System.in);
			System.out.println("请输入银行卡号：");
			String cardId = in.nextLine();
			System.out.println("请输入银行卡密码：");
			String cardPwd = in.nextLine();
			user = dbutil.getUser(cardId);
			if(dbutil.getUsers().containsKey(cardId)
					&& user.getCardPwd().equals(cardPwd)){
				System.out.println("登陆成功！欢迎" + user.getUserName() + "先生");
				break;
			}else{
				Sysetem.out.println("银行卡号或密码错误 ！");
				continue;
			}
		}
	}
public void  income(int num) {
	account = user.getAccount() + num;
	user.setAccount(account);
	System.out.println("存入金额" + num + "元成功！");
}
public void  takeout(int num) {
	if(user.getAccount() >= num){
	account = user.getAccount() - num;
	user.setAccount(account);
	System.out.println("取出金额" + num + "元成功！");
	}else{
		System.out.println("金额不足，取款失败！");
	}
}

}