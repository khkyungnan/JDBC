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
        System.out.println("ī�� ID�� �Է� ��, ��ð��� ������Ʈ�ϼ���:");
        System.out.print("ī�� ID: ");
        int cafeId = scanner.nextInt();

        System.out.print("�� ��ð�: ");
        String newOR = scanner.next();
      
        scanner.nextLine(); // ���� ���� ó��

        model.UpdateCafe(newOR,cafeId );
        System.out.println("��ð��� ������Ʈ�Ǿ����ϴ�!");
    }

	public void deleteCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�並 �����ϰڽ��ϴ�.");
		System.out.println("������ ī���� ID�� �Է��ϼ���.");
		int cafeId = Integer.parseInt(sc.nextLine());
		//int cafedId_other = sc.nextInt();
		
		model.deleteCafe(cafeId);
		System.out.println("ī�䰡 �����Ǿ����ϴ�.");
	}

	public void deleteMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴��� �����ϼ���.");
		System.out.println("ī��ID : ");
		int cafe_id = sc.nextInt();
		int menu_id = sc.nextInt();
		model.deleteMenu(menu_id, cafe_id);
		System.out.println("�޴��� �����Ǿ����ϴ�.");
	}
}





