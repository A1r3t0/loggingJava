import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class logging {

    static Logger Logger;
    static {
        try(FileInputStream ins = new FileInputStream("/Users/artyomartyushin/IdeaProjects/logging/logs.config")){ //полный путь до файла с конфигами
            LogManager.getLogManager().readConfiguration(ins);
            Logger = Logger.getLogger(logging.class.getName());
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            //Logger = java.util.logging.Logger.getLogger(logging.class.getName());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Logger.log(Level.INFO, "Создаем пустой список, в котором будут храниться бочки");
            ArrayList<Integer> barrels = new ArrayList<>();
            Logger.log(Level.INFO, "Вводим количество бочек");
            System.out.println("Введите количество бочек (натуральное число): ");
            String s = reader.readLine();
            Logger.log(Level.INFO, "Меняем тип переменной со String на Integer");
            int s1 = Integer.parseInt(s);
            Logger.log(Level.INFO, "Проверка правильности ввода количества бочек");
            if (s1 < 1) {
                Logger.log(Level.WARNING, "Число меньше 1");
                Logger.log(Level.INFO, "Выход из программы");
                System.exit(0);
            }
            Logger.log(Level.INFO, "Заполняем список номерами бочек");
            for (int i = 1; i <= s1; i++) {
                barrels.add(i);
            }
            Logger.log(Level.INFO, "Заходим в цикл пока список с бочками не пустой");
            System.out.println("Нажмите Enter чтобы достать бочонок");
            reader.readLine();
            while (barrels.size() != 0) {
                int x = getRandomNumber(s1);
                for (int i = 0; i < barrels.size(); i++) {
                    if (x == barrels.get(i)) {
                        if (barrels.size() == 1) {
                            barrels.remove(i);
                            Logger.log(Level.INFO, "Вытаскиваем бочку " + x);
                        }
                        else {
                            barrels.remove(i);
                            Logger.log(Level.INFO, "Вытаскиваем бочку " + x);
                            System.out.println("Нажмите Enter чтобы достать бочонок");
                            reader.readLine();
                        }
                    }
                }
            }
            Logger.log(Level.INFO, "---------------------РАБОТА ПРОГРАММЫ ЗАВЕРШЕНА----------------------");
        }
        catch (Exception e) {
            Logger.log(Level.WARNING, "Ошибка!", e);
        }
    }
    public static int getRandomNumber(int s1)
    {
        return (int) (Math.random() * s1) + 1;
    }
}
