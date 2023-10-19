package chap2_MVC;

import java.util.Scanner;

public class cafeController {
	public cafeModel model;
	public cafeView view;
	
	//�𵨰� �並 ������� ������
	public cafeController(cafeModel model, cafeView view) {
		this.model = model;
		this.view = view;
	}
	// run
	public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 4) {
            System.out.println("1. ī�� ���� �߰�");
            System.out.println("2. �޴� ���� ������Ʈ");
            System.out.println("3. ��ð� ������Ʈ");
            System.out.println("4. ����");
            System.out.print("���ϴ� �۾��� �����ϼ���: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    view.addCafeName();
                    break;
                case 2:
                    view.updateMenu();
                    break;
                case 3:
                    view.updateCafe();
                    break;
                case 4:
                    System.out.println("���α׷��� �����մϴ�.");
                    break;
                default:
                    System.out.println("�ùٸ� �ɼ��� �����ϼ���.");
            }
        }
    }
}