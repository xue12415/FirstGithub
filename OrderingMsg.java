import java.util.*;
public class OrderingMsg {

	public static void main(String[] args) {
		String names[]=new String[4];//����������
		String []disMegs=new String[4];//������Ʒ��Ϣ
		int[]times=new int[4];//�Ͳ�ʱ��
		String[]addresses=new String[4];//�Ͳ͵�ַ
		int[]states=new int[4];//����״̬	0����Ԥ��	1�������
		double[]sumPrices=new double[4];//�����ܽ��
		
		//��ʼ��������Ϣ
		names[0]="����";
		disMegs[0]="������˿1��";
		times[0]=12;
		addresses[0]="ʮ���";
		states[0]=1;
		sumPrices[0]=24.0;
		
		names[1]="����";
		disMegs[1]="���մ���2��";
		times[1]=12;
		addresses[1]="������";
		states[1]=0;
		sumPrices[1]=76.0;
		
		//�������壺һ���Ʒ��Ϣ
		String[]dishNames={"���մ���","������˿","�ز�"};
		double prices[]={38.0,18.0,10.0};
		int []praiseNums=new int[3];
		
		Scanner input=new Scanner(System.in);
		int num=-1;//��¼�û����������
		//ѭ��������
		do{
			//��ʾ���˵�
			System.out.println("***************************");
			System.out.println("1.��Ҫ����");
			System.out.println("2.�鿴�ʹ�");
			System.out.println("3.ǩ�ն���");
			System.out.println("4.ɾ������");
			System.out.println("5.��Ҫ����");
			System.out.println("6.�˳�ϵͳ");
			System.out.println("***************************");
			//��ʾ�û����빦�ܱ�ţ���ִ����Ӧ����
			System.out.print("��ѡ��");
			int choose=input.nextInt();//��¼�û��Ĺ��ܱ��
			
			boolean isAdd=false;//true����¼�ҵ�һ��Ϊ�յ�λ��	false��û�ҵ�
			//������Ӧ�ı��ִ����ز���
			switch (choose) {
			case 1:
				//1.��Ҫ����
				System.out.println("*******��Ҫ����*******");
				//����Ҫ�����λ��
				for(int i=0;i<names.length;i++){
					//������ҵ���λ�ü�¼����
					if(names[i]==null){
						isAdd=true;//���ҵ�һ���յ�λ��
						//ִ�в�������
						//a.��ʾ���пɹ�ѡ��Ĳ�Ʒ��Ϣ
						System.out.println("���\t��Ʒ��\t����\t������");
						for(int j=0;j<dishNames.length;j++){
							String price=prices[j]+"Ԫ";
							String praise=praiseNums[j]+"��";
							System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
						}
						
						//������ѡ��Ʒ����Լ�����
						System.out.print("�����붩����ţ�");
						int chooseDish=input.nextInt();
						System.out.print("��ѡ������������");
						int number=input.nextInt();
						String dishmeg=dishNames[chooseDish-1]+" "+number+"��";
						
						//b.���붩��������
						System.out.print("�����붩����������");
						String name=input.next();
						
						//c.�����Ͳ�ʱ��
						System.out.print("�������Ͳ�ʱ�䣺��10-20֮�������Ͳͣ�");
						int time=input.nextInt();
						//������������ظ�����
						while(time<10||time>20){
							System.out.println("�Բ�������������������������10-20֮�����");
							time=input.nextInt();
						}
						
						//d.�����Ͳ͵�ַ
						System.out.print("�������Ͳ͵�ַ��");
						String addres=input.next();
						
						//e.����ͷ�
						double sumPrice=prices[chooseDish-1]*number;
						//�Ͳͷѣ���50�����ͣ�����6Ԫ�Ͳͷ�
						double deliChrage=sumPrice>=20?0.0:6.0;
						
						//��ʾ������Ϣ
						System.out.println("���ͳɹ���");
						System.out.println("�������ǣ�"+dishmeg);
						System.out.println("�����ˣ�"+name);
						System.out.println("�Ͳ�ʱ�䣺"+time+"��");
						System.out.println("�Ͳ͵�ַ��"+addres);
						System.out.println("�ͷѣ�"+sumPrice+",�Ͳͷѣ�"+deliChrage+"Ԫ");
						System.out.println("�ܽ�"+(sumPrice+deliChrage)+"Ԫ");
						
						//��������
						names[i]=name;
						disMegs[i]=dishmeg;
						times[i]=time;
						addresses[i]=addres;
						sumPrices[i]=sumPrice+deliChrage;
						break;
					}
				}
				if(!isAdd){
					System.out.println("�Բ������Ĳʹ�������");
				}
				break;
			case 2:
				//2.�鿴�ʹ�
				System.out.println("*******�鿴�ʹ�*******");
				System.out.println("���\t������\t������Ʒ��Ϣ\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t�ܽ��\t״̬");
				//��������
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						String time=times[i]+"��";
						String sumP=sumPrices[i]+"Ԫ";
						String state=states[i]==0?"��Ԥ��":"�����";
						System.out.println((i+1)+"\t"+names[i]+"\t"+disMegs[i]+"\t"+time+"\t"+addresses[i]+"\t"+sumP+"\t"+state);
					}
				}
				break;
			case 3:
				//3.ǩ�ն���
				System.out.println("*******ǩ�ն���*******");
				//Ҫ���û�����һ���������
				System.out.print("������һ��������ţ�");
				int signOrderId=input.nextInt();
				boolean isFind=false;//��¼�Ƿ��ҵ���������   true�ҵ�	falseû�ҵ�
				//��������������ѭ��������
				for(int i=0;i<names.length;i++){
					//1.�ҵ���״̬������ɣ��Ѿ�ǩ����ϣ�����ʾ�����ٴ�ǩ��
					//2.�ҵ���״̬����Ԥ����û�����ǩ�գ�������ǩ��
					if(names[i]!=null&&states[i]==1&&signOrderId==i+1){
						System.out.println("");
						isFind=true;
						break;
					}else if(names[i]!=null&&states[i]==0&&signOrderId==i+1){
						states[i]=1;//״ֵ̬��Ϊ�����״̬
						System.out.println("����ǩ�ճɹ���");
						isFind=true;
						break;
					}
				}
				//���û���ҵ���������ȡ��ʾû���ҵ�
				//3.û�ҵ�����ʾ��Ϣû�ҵ�
				if(!isFind){
					System.out.println("�Բ��𣬴˶��������ڣ�");
				}
				break;
			case 4:
				//4.ɾ������
				System.out.println("*******ɾ������*******");
				System.out.print("������Ҫɾ���Ķ����ţ�");
				int delId=input.nextInt();
				int delIndex=-1;
				boolean delIsFind=false;
				for(int i=0;i<names.length;i++){
					//�ҵ���������״̬����ǩ�գ�����ɾ��
					//�ҵ�������״̬����Ԥ������ʾ��Ϣ
					if(names[i]!=null&&states[i]==1&&delId==i+1){
						delIndex=i;
						delIsFind=true;
						//�ҵ��ˣ���ִ��ɾ������(����Ԫ��ǰ��)
							for(int j=delIndex;j<names.length-1;j++){
								names[j]=names[j+1];
								disMegs[j]=disMegs[j+1];
								times[j]=times[j+1];
								addresses[j]=addresses[j+1];
								states[j]=states[j+1];
							}
							//ĩλ���
							names[names.length-1]=null;
							disMegs[names.length-1]=null;
							times[names.length-1]=0;
							addresses[names.length-1]=null;
							states[names.length-1]=0;
						System.out.println("����ɾ���ɹ���");
						break;
					}else if(names[i]!=null&&states[i]==0&&delId==i+1){
						System.out.println("����δǩ�գ�����ɾ��������");
						delIsFind=true;
						break;
					}
				}
				//û�ҵ���ض���
				if(!delIsFind){
					System.out.println("�Բ���û�ҵ�������");
				}
				break;
			case 5:
				//5.��Ҫ����
				System.out.println("*******��Ҫ����*******");
				//1.��ʾ���޲�Ʒ�б�
				System.out.println("���\t��Ʒ��\t����\t������");
				for(int j=0;j<dishNames.length;j++){
					String price=prices[j]+"Ԫ";
					String praise=praiseNums[j]+"��";
					System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
				}
				//������޵Ĳ�Ʒ���
				System.out.println("������Ҫ���޵Ĳ�Ʒ��ţ�");
				int dishId=input.nextInt();
				//��������1
				praiseNums[dishId-1]++;
				//��ʾ
				System.out.println("���޳ɹ���");
				System.out.println(dishNames[dishId-1]+" "+praiseNums[dishId-1]+"��");
				break;
			case 6:
				//6.�˳�ϵͳ
				break;
			default:
				break;
			}
			
			//���û�������Ϊ1-5֮������֣��˳�ѭ����������ʾ����0����
			if(choose<1||choose>5){
				break;
			}
			//��ʾ����0 ����
			System.out.print("����0���أ�");
			num=input.nextInt();
		}while(num==0);//ѭ������ 	����0
		System.out.println("ллʹ�ã���ӭ�´ι��٣�");
	}
}
