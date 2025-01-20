package kiosk;

import kiosk.exception.InvalidMenuException;
import kiosk.menu.BurgerMenu;
import kiosk.menu.DessertMenu;
import kiosk.menu.DrinkMenu;
import kiosk.menu.MenuItem;
import kiosk.discount.DiscountType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private final BurgerMenu burgerMenu;
    private final DrinkMenu drinkMenu;
    private final DessertMenu dessertMenu;
    private final List<MenuItem> cart;

    public Kiosk() {
        this.burgerMenu = new BurgerMenu();
        this.drinkMenu = new DrinkMenu();
        this.dessertMenu = new DessertMenu();
        this.cart = new ArrayList<>();
    }

    private void showMainMenu() {
        System.out.println("[ MAIN MENU ]");
        System.out.println("1. Burgers");
        System.out.println("2. Drinks");
        System.out.println("3. Desserts");
        if (!cart.isEmpty()) {
            System.out.println("[ ORDER MENU ]");
            System.out.println("4. Orders            |  장바구니 확인 후 주문");
            System.out.println("5. Cancel            |  진행중인 주문 취소");
        }
        System.out.println("0. 종료");
    }


    // 장바구니 내용
    private void showCart() {
        System.out.println("장바구니에 담음 메뉴");
        cart.stream()
                .map(item -> String.format("%s | W %.2f | %s", item.getName(), item.getPrice(), item.getDescription()))
                .forEach(System.out::println);
        double total = cart.stream().mapToDouble(MenuItem::getPrice).sum();
        System.out.println("[ Total ]");
        System.out.printf("W %.2f%n", total);
    }


    // 할인 적용
    private void applyDiscount(DiscountType discountType) {
        double discountedTotal = cart.stream()
                .mapToDouble(MenuItem::getPrice)
                .reduce(0, (total, price) -> total + price * (1 - discountType.getDiscountRate()));
        System.out.printf("할인 적용한 총 금액: W %.2f%n", discountedTotal);
        System.out.println("주문이 완료되었습니다. 감사합니다.");
    }

    private boolean isCartEmpty() {
        if (cart.isEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
            return false;
        }
        return true;
    }


    //실제 프로그램을 실행시키는 메소드
    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            showMainMenu();
            System.out.print("선택 : ");
            int mainChoice = sc.nextInt();

            switch (mainChoice) {
                case 0:
                    System.out.println("종료합니다.");
                    return;
                case 1:
                    burgerMenu.showMenu();
                    menuSelection(sc, burgerMenu);
                    break;
                case 2:
                    drinkMenu.showMenu();
                    menuSelection(sc, drinkMenu);
                    break;
                case 3:
                    dessertMenu.showMenu();
                    menuSelection(sc, dessertMenu);
                    break;
                case 4:
                    if (isCartEmpty()) {
                        showCart();
                        System.out.println("1. 주문하기    2. 메뉴판으로 돌아가기");
                        int orderChoice = sc.nextInt();
                        if (orderChoice == 1) {
                            System.out.println("할인 정보를 입력하세요.");
                            System.out.println("1. 국가유공자: 10%\n2. 군인: 5%\n3. 학생: 3%\n4. 일반: 0%");
                            int discountCode = sc.nextInt();
                            DiscountType discountType = DiscountType.fromCode(discountCode);
                            applyDiscount(discountType);
                            cart.clear();
                        }
                    }
                    break;
                case 5:
                    if (isCartEmpty()) {
                        cart.clear();
                        System.out.println("주문이 취소되었습니다.");
                    }
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
            }
        }
    }

    // 메뉴 관리
    private void menuSelection(Scanner sc, MenuItem menu) {
        System.out.print("메뉴를 선택해주세요(0입력 시 취소) ");
        int itemChoice = sc.nextInt();
        if (itemChoice == 0) {
            return;
        }

        // 잘못된 입력을 처리하기 위한 try - catch문
        try {
    문       MenuItem selectedItem = menu.getItems().get(itemChoice - 1);
            System.out.printf("선택: %s | W %.2f | %s%n", selectedItem.getName(), selectedItem.getPrice(), selectedItem.getDescription());
            System.out.println("장바구니에 추가하시겠습니까? 1. 예  2. 아니오");
            int addChoice = sc.nextInt();
            if (addChoice == 1) {
                cart.add(selectedItem);
                System.out.printf("%s 추가되었습니다.%n", selectedItem.getName());
            }
        } catch (InvalidMenuException e) {
            System.out.println("잘못된 입력입니다. 다시 시도해주세요");
        }
    }
}
