import java.util.*;
public class OrderingMsg {

	public static void main(String[] args) {
		String names[]=new String[4];//订餐人名称
		String []disMegs=new String[4];//锁定餐品信息
		int[]times=new int[4];//送餐时间
		String[]addresses=new String[4];//送餐地址
		int[]states=new int[4];//订单状态	0：已预订	1：已完成
		double[]sumPrices=new double[4];//订餐总金额
		
		//初始化订单信息
		names[0]="张三";
		disMegs[0]="鱼香肉丝1份";
		times[0]=12;
		addresses[0]="十里街";
		states[0]=1;
		sumPrices[0]=24.0;
		
		names[1]="李四";
		disMegs[1]="红烧带鱼2份";
		times[1]=12;
		addresses[1]="长安街";
		states[1]=0;
		sumPrices[1]=76.0;
		
		//数据主体：一组餐品信息
		String[]dishNames={"红烧带鱼","鱼香肉丝","素菜"};
		double prices[]={38.0,18.0,10.0};
		int []praiseNums=new int[3];
		
		Scanner input=new Scanner(System.in);
		int num=-1;//记录用户输入的数字
		//循环操作：
		do{
			//显示主菜单
			System.out.println("***************************");
			System.out.println("1.我要订餐");
			System.out.println("2.查看餐袋");
			System.out.println("3.签收订单");
			System.out.println("4.删除订单");
			System.out.println("5.我要点赞");
			System.out.println("6.退出系统");
			System.out.println("***************************");
			//提示用户输入功能编号，并执行相应功能
			System.out.print("请选择：");
			int choose=input.nextInt();//记录用户的功能编号
			
			boolean isAdd=false;//true：记录找到一个为空的位置	false：没找到
			//根据相应的编号执行相关操作
			switch (choose) {
			case 1:
				//1.我要订餐
				System.out.println("*******我要订餐*******");
				//查找要插入的位置
				for(int i=0;i<names.length;i++){
					//如果查找到空位置记录下来
					if(names[i]==null){
						isAdd=true;//已找到一个空的位置
						//执行插入条件
						//a.显示所有可供选择的菜品信息
						System.out.println("序号\t菜品名\t单价\t点赞数");
						for(int j=0;j<dishNames.length;j++){
							String price=prices[j]+"元";
							String praise=praiseNums[j]+"赞";
							System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
						}
						
						//输入所选菜品编号以及份数
						System.out.print("请输入订餐序号：");
						int chooseDish=input.nextInt();
						System.out.print("请选择所定份数：");
						int number=input.nextInt();
						String dishmeg=dishNames[chooseDish-1]+" "+number+"份";
						
						//b.输入订餐人姓名
						System.out.print("请输入订餐人姓名：");
						String name=input.next();
						
						//c.输入送餐时间
						System.out.print("请输入送餐时间：（10-20之间整点送餐）");
						int time=input.nextInt();
						//如果输入有误，重复输入
						while(time<10||time>20){
							System.out.println("对不起，您的输入有误，请重新输入10-20之间的数");
							time=input.nextInt();
						}
						
						//d.输入送餐地址
						System.out.print("请输入送餐地址：");
						String addres=input.next();
						
						//e.计算餐费
						double sumPrice=prices[chooseDish-1]*number;
						//送餐费，满50免配送，否则6元送餐费
						double deliChrage=sumPrice>=20?0.0:6.0;
						
						//显示订单信息
						System.out.println("订餐成功！");
						System.out.println("您定的是："+dishmeg);
						System.out.println("订餐人："+name);
						System.out.println("送餐时间："+time+"点");
						System.out.println("送餐地址："+addres);
						System.out.println("餐费："+sumPrice+",送餐费："+deliChrage+"元");
						System.out.println("总金额："+(sumPrice+deliChrage)+"元");
						
						//保存数组
						names[i]=name;
						disMegs[i]=dishmeg;
						times[i]=time;
						addresses[i]=addres;
						sumPrices[i]=sumPrice+deliChrage;
						break;
					}
				}
				if(!isAdd){
					System.out.println("对不起，您的餐袋已满！");
				}
				break;
			case 2:
				//2.查看餐袋
				System.out.println("*******查看餐袋*******");
				System.out.println("序号\t订餐人\t所定餐品信息\t送餐时间\t送餐地址\t总金额\t状态");
				//遍历数据
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						String time=times[i]+"点";
						String sumP=sumPrices[i]+"元";
						String state=states[i]==0?"已预订":"已完成";
						System.out.println((i+1)+"\t"+names[i]+"\t"+disMegs[i]+"\t"+time+"\t"+addresses[i]+"\t"+sumP+"\t"+state);
					}
				}
				break;
			case 3:
				//3.签收订单
				System.out.println("*******签收订单*******");
				//要求用户输入一个订单序号
				System.out.print("请输入一个订单序号：");
				int signOrderId=input.nextInt();
				boolean isFind=false;//记录是否找到这条订单   true找到	false没找到
				//查找这条订单（循环遍历）
				for(int i=0;i<names.length;i++){
					//1.找到，状态是已完成（已经签收完毕），提示不能再次签收
					//2.找到，状态是已预订（没有完成签收），可以签收
					if(names[i]!=null&&states[i]==1&&signOrderId==i+1){
						System.out.println("");
						isFind=true;
						break;
					}else if(names[i]!=null&&states[i]==0&&signOrderId==i+1){
						states[i]=1;//状态值改为已完成状态
						System.out.println("订单签收成功！");
						isFind=true;
						break;
					}
				}
				//如果没有找到订单，采取提示没有找到
				//3.没找到，提示信息没找到
				if(!isFind){
					System.out.println("对不起，此订单不存在！");
				}
				break;
			case 4:
				//4.删除订单
				System.out.println("*******删除订单*******");
				System.out.print("请输入要删除的订单号：");
				int delId=input.nextInt();
				int delIndex=-1;
				boolean delIsFind=false;
				for(int i=0;i<names.length;i++){
					//找到订单，且状态是已签收，可以删除
					//找到订单，状态是已预订，提示信息
					if(names[i]!=null&&states[i]==1&&delId==i+1){
						delIndex=i;
						delIsFind=true;
						//找到了，并执行删除操作(数组元素前移)
							for(int j=delIndex;j<names.length-1;j++){
								names[j]=names[j+1];
								disMegs[j]=disMegs[j+1];
								times[j]=times[j+1];
								addresses[j]=addresses[j+1];
								states[j]=states[j+1];
							}
							//末位清空
							names[names.length-1]=null;
							disMegs[names.length-1]=null;
							times[names.length-1]=0;
							addresses[names.length-1]=null;
							states[names.length-1]=0;
						System.out.println("订单删除成功！");
						break;
					}else if(names[i]!=null&&states[i]==0&&delId==i+1){
						System.out.println("订单未签收，不能删除订单！");
						delIsFind=true;
						break;
					}
				}
				//没找到相关订单
				if(!delIsFind){
					System.out.println("对不起，没找到订单！");
				}
				break;
			case 5:
				//5.我要点赞
				System.out.println("*******我要点赞*******");
				//1.显示点赞餐品列表
				System.out.println("序号\t菜品名\t单价\t点赞数");
				for(int j=0;j<dishNames.length;j++){
					String price=prices[j]+"元";
					String praise=praiseNums[j]+"赞";
					System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
				}
				//输入点赞的餐品序号
				System.out.println("请输入要点赞的餐品序号：");
				int dishId=input.nextInt();
				//点赞数加1
				praiseNums[dishId-1]++;
				//显示
				System.out.println("点赞成功！");
				System.out.println(dishNames[dishId-1]+" "+praiseNums[dishId-1]+"赞");
				break;
			case 6:
				//6.退出系统
				break;
			default:
				break;
			}
			
			//当用户输入编号为1-5之间的数字，退出循环，否则提示输入0返回
			if(choose<1||choose>5){
				break;
			}
			//提示输入0 返回
			System.out.print("输入0返回：");
			num=input.nextInt();
		}while(num==0);//循环操作 	输入0
		System.out.println("谢谢使用，欢迎下次光临！");
	}
}
