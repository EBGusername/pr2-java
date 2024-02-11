package org.example;
import java.util.Scanner;

public class Main {
    // Константа радиуса Земли в километрах
    static final double EARTH_RADIUS = 6371;  // Радиус Земли в километрах

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрос пользователю координаты для двух точек
        System.out.println("Введите широту первой точки в градусах:");
        double lat1 = scanner.nextDouble();

        System.out.println("Введите долготу первой точки в градусах:");
        double lon1 = scanner.nextDouble();

        System.out.println("Введите широту второй точки в градусах:");
        double lat2 = scanner.nextDouble();

        System.out.println("Введите долготу второй точки в градусах:");
        double lon2 = scanner.nextDouble();

        // Метода для вычисления расстояния
        double distance = calculateDistance(lat1, lon1, lat2, lon2);

        // Вывод расстояния
        System.out.println("Расстояние между двумя точками: " + distance + " км");
        scanner.close(); // Закрытие Scanner
    }

    // Метод для вычисления расстояния по формуле гаверсинусов
    private static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Преобразование градусов в радианы
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // Вычисление расстояния с использованием формулы haversine
        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;
        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.pow(Math.sin(dLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c;
    }
}