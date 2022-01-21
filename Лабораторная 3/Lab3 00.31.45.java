/*
Колода карт состоит из 36 листов. Колода перемешивается, а затем раздается полностью двум игрокам:
1-ая карта – 1-ому игроку, 2-ая карта – 2-ому игроку, 3-ая карта – 1-ому игроку,
4-ая карта – 2-ому игроку и т. д. Напишите программу, используя объектно-ориентированную методологию,
котроая создает объект колода, вывод колоду на экран, перемешивает колоду, вновь выводит на экран,
создает объекты игроков, раздает карт игрокам, выводит на экран последовательности карт каждого игрока.
Используйте для хранения колоды и последовательностей карт только один массив из 36 элементов.
 */

public class Lab3 {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Player p1 = new Player();
        Player p2 = new Player();
        System.out.println("Колода:");
        deck.printAll();
        System.out.println("Перемешанная колода:");
        deck.mix();
        deck.printAll();
        deck.splitCards(p1, p2);
        System.out.println("Колода карт 1 игрока:");
        p1.print();
        System.out.println("Колода карт 2 игрока:");
        p2.print();
    }
}
