package kiosk.menu;

import java.util.ArrayList;
import java.util.List;


// 버거,디저트,음료 클래스의 상위 클래스
public class MenuItem {
    protected List<MenuItem> items = new ArrayList<>();
    private String name;
    private double price;
    private String description;

    public MenuItem() {}

    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // 메뉴 항목 출력 공통 로직
    public void showMenu(String menuTitle) {
        System.out.println("[ " + menuTitle + " ]");
        System.out.println("================================");
        int index = 1;
        for (MenuItem item : items) {
            System.out.printf("%-4d │ %-12s │ W %-6.1f │ %s%n",
                    index,
                    item.getName(),
                    item.getPrice(),
                    item.getDescription());
            index++;
        }
        System.out.printf("%-4s │ %-12s │ %-6s │ %s%n", "0", "초기화면으로 돌아가기", "", "돌아가기");
    }

        // 선택한 메뉴 항목 출력
    public void showSelected(int select) {
        try {
            if (select < 0 || select > items.size()) {
                throw new IllegalArgumentException("올바르지 않은 메뉴 번호입니다.");
            } else if (select == 0) {
                System.out.println("초기 화면으로 돌아갑니다.");
                return;
            }
            MenuItem selectedMenu = items.get(select - 1);
            System.out.println("선택한 메뉴: " + selectedMenu.getName() +
                    " | W " + selectedMenu.getPrice() +
                    " | 음식 설명: " + selectedMenu.getDescription());
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
    public double getMenuPrice(int index) {
        return items.get(index - 1).getPrice();
    }

    public List<MenuItem> getItems() {
        return items;
    }

}
