package chap2_MVC;

import java.util.Scanner;

public class cafeController {
	public cafeModel model;
	public cafeView view;
	
	//모델과 뷰를 가지고올 생성자
	public cafeController(cafeModel model, cafeView view) {
		this.model = model;
		this.view = view;
	}
	// run
	public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 4) {
            System.out.println("1. 카페 정보 추가");
            System.out.println("2. 메뉴 설명 업데이트");
            System.out.println("3. 운영시간 업데이트");
            System.out.println("4. 종료");
            System.out.print("원하는 작업을 선택하세요: ");
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
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("올바른 옵션을 선택하세요.");
            }
        }
    }
}