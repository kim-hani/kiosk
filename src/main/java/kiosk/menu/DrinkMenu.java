package kiosk.menu;

public class DrinkMenu extends MenuItem {
    public DrinkMenu() {
        items.add(new MenuItem("Yuja Basil Lemonade", 5.7, "바질과 상큼한 유자의 향을 더한 스페셜 레몬에이드"));
        items.add(new MenuItem("Fresh Brewed Iced Tea", 4.4, "직접 유기농 홍차를 우려낸 아이스 티"));
        items.add(new MenuItem("Fountain Soda", 3.6, "탄산 음료"));
        items.add(new MenuItem("Shack Coffee", 4.5, "쉑 블렌드 원두를 사용한 밸런스 좋은 블랙 커피"));
    }

    public void showMenu() {
        super.showMenu("SHAKE SHACK DRINK MENU");
    }
}
