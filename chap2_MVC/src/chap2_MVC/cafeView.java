package chap2_MVC;

import java.util.Scanner;

public class cafeView {
	//cafeModel �̶�� Ŭ������ ������ ���� ���� ��������� ī�� ���� �߰���
	public cafeModel model;
	
	//model �Ű������� ���� �� �ִ� �����ڸ� ����������
	public cafeView(cafeModel model) {
		this.model = model;
	}
// name,address,phone_number, operationg_hours
	public void addCafeName() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ī�� ������ �Է��ϼ���.");
		System.out.println("��ȣ�� : ");
		String name = sc.nextLine();
		
		System.out.println("ī�� �ּ� : ");
		String address = sc.nextLine();
		
		System.out.println("ī�� ����ó : ");
		String phoneNumber = sc.nextLine();
		
		System.out.println("ī�� � �ð� : ");
		String operatingHours = sc.nextLine();
		
		//ī�� �𵨿��� insertCafe ��� �޼��带 ������ �;���
		model.insertCafe(name, address, phoneNumber, operatingHours);
		System.out.println("ī�䰡 ���������� �߰��Ǿ����ϴ�.");
	}

	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴� ������ ������Ʈ�ϼ���.");
		System.out.print("ī�� ID : ");
		int cafeId = sc.nextInt();
		
		System.out.print("�޴� ID : ");
		int menuId = sc.nextInt();
		
		System.out.print("������ �޴� ���� : ");
		String description = sc.nextLine();

		
		//model �� �ִ� UpdateMenu�� ������ͼ� 
		//����ڰ� �ۼ��� ���� ���� �߰��ϱ�
		model.UpdateMenu(description, menuId, cafeId);
		System.out.println("�޴� ������ ������Ʈ �Ǿ����ϴ�.");
	}
	
	
	public void updateCafe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("��ð��� ������Ʈ�ϼ���:");
        System.out.print("�� ��ð�: ");
        String newOperatingHours = scanner.next();
        System.out.print("ī�� ID: ");
        int cafeId = scanner.nextInt();
        scanner.nextLine(); // ���� ���� ó��
     

        model.UpdateCafe(cafeId, newOperatingHours);
        System.out.println("��ð��� ������Ʈ�Ǿ����ϴ�!");
    }
}





