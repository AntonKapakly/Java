/*
Промоделируйте процесс распространения инфекции стригущего лишая по участку кожи размером 21 Х 21 клеток.
Предполагается, что исходной зараженной клеткой кожи является центральная.
В каждый интервал времени пораженная инфекцией клетка может с вероятностью 0,5
заразить любую из соседних здоровых клеток (только одну).
По прошествии шести единиц времени зараженная клетка становится невосприимчивой к инфекции,
возникший иммунитет действует в течение последующих четырех единиц времени,
а затем клетка оказывается здоровой. В ходе моделирования описанного процесса выдавать на экран
текущее состояние моделируемого участка кожи в каждом интервале времени,
отмечая зараженные, невосприимчивые к инфекции и здоровые клетки.
 */

public class Main {
    public static void main(String[] args) {
        Skin skin = new Skin();
        int counter = 21;
        for (int i = 0; i < counter; i++) {
            System.out.println("Момент времени " + (i+1));
            skin.printField();
            skin.nextGeneration();
            System.out.println();
        }
    }
}
