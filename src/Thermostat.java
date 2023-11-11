import java.util.Scanner;

public class Thermostat {
    private int temperature;
    private boolean waterAvailable;
    private boolean isHeating;
    private boolean isDamaged;

    public Thermostat() {
        temperature = 0;
        waterAvailable = false;
        isHeating = false;
        isDamaged = false;
    }

    public void checkTemperature() {
        if (temperature < 20) {
            if (waterAvailable) {
                if (!isHeating) {
                    startHeating();
                }
            } else {
                System.out.println("没有水，不能加热.");
            }
        } else if (temperature >= 100) {
            stopHeating();
        }
    }

    public void checkWaterAvailability() {

        boolean newWaterAvailable = (Math.random() > 0.7);
        if (newWaterAvailable != waterAvailable) {
            waterAvailable = newWaterAvailable;
            if (temperature < 20 && waterAvailable && !isHeating) {
                startHeating();
            } else if (!waterAvailable && isHeating) {
                stopHeating();
            }
        }
    }

    public void startHeating() {
        isHeating = true;
        System.out.println(" 正在加热...");
    }

    public void stopHeating() {
        isHeating = false;
        System.out.println("停止加热...");
    }

    public void damage() {
        isDamaged = true;
        System.out.println("水箱损坏，请修复.");
    }

    public void repair() {
        isDamaged = false;
        System.out.println("已经修复.");
    }

    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("当前温度: " + thermostat.temperature + "°");
            System.out.println("是否可烧水: " + thermostat.waterAvailable);
            System.out.println("加热: " + thermostat.isHeating);
            System.out.println("损坏: " + thermostat.isDamaged);
            System.out.println("----------------------------");
            System.out.println("1. 查看温度");
            System.out.println("2. 检查水供应情况");
            System.out.println("3. 开始烧水");
            System.out.println("4. 停止烧水");
            System.out.println("5. 损坏");
            System.out.println("6. 修复");
            System.out.println("7. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: // Check temperature  
                    thermostat.checkTemperature();
                    break;
                case 2: // Check water availability  
                    thermostat.checkWaterAvailability();
                    break;
                case 3: // Start heating  
                    thermostat.startHeating();
                    break;
                case 4: // Stop heating  
                    thermostat.stopHeating();
                    break;
                default:
                    break;

            }
        }
    }
}
