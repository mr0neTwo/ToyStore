
public class Main {

    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        // Добавляем игрушки в магазин
        toyStore.addToy(new Toy(1, "Кукла", 5, 40));
        toyStore.addToy(new Toy(2, "Мяч", 10, 20));
        toyStore.addToy(new Toy(3, "Пазл", 3, 10));
        toyStore.addToy(new Toy(4, "Машинка", 8, 30));

        // Изменяем вес игрушки
        toyStore.updateToyWeight(2, 50);

        // Выбираем призовую игрушку
        Toy prizeToy = toyStore.selectPrizeToy();
        if (prizeToy != null) {
            System.out.println("Выиграна игрушка: " + prizeToy.getName());

            // Сохраняем призовую игрушку в файл
            toyStore.savePrizeToyToFile(prizeToy, "prize_toys.txt");
        } else {
            System.out.println("Игрушки закончились.");
        }
    }
}