package kiosk.menu;

public class DessertMenu extends MenuItem {
    public DessertMenu() {
        items.add(new MenuItem("Classic Hand-Spun Shakes", 6.8, "쫀득하고 진한 커스터드가 들어간 클래식 쉐이크"));
        items.add(new MenuItem("Floats", 6.8, "부드러운 바닐라 커스터드와 톡톡 터지는 탄산이 만나 탄생한 색다른 음료"));
        items.add(new MenuItem("Shack Attack", 6.2, "진한 초콜릿 커스터드에 퍼지 소스와 세 가지 초콜릿 토핑이 블렌딩된 쉐이크쉑의 대표 콘크리트"));
        items.add(new MenuItem("Honey Butter Crunch", 6.2, "바닐라 커스터드에 허니 버터 소스와 슈가 콘이 달콤하게 블렌딩된 콘크리트"));
    }

    public void showMenu() {
        super.showMenu("SHAKE SHACK DESSERT MENU");
    }
}
