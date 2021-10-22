package program;

import DEPARTAMENTO.Department;
import DEPARTAMENTO.HourContract;
import DEPARTAMENTO.Worker;
import entities.*;
import entities.enums.OrderStatus;
import entities.enums.TipoCliente;
import DEPARTAMENTO.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class program {
    public static void main (String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        Date data = sdf.parse("21/10/2021");


        Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);
        Cliente cliente = new Cliente(1, "Matheus G.", "mgi@gmail.com", "000.000.000-00", TipoCliente.PESSOAFISICA, data);

        System.out.println(order);
        System.out.println(cliente);

        System.out.print("Enter department's name: ");
        String departmentName = sc.next();
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));

        System.out.println("How many contracts to this worker? ");
        int nContracts = sc.nextInt();

        for (int i = 1; i <= nContracts; i++){
            System.out.println("Enter contract #" + i +  " data:");
            System.out.print("Date (DD/MM/YYYY):");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour:");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours):");
            int duration = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, duration);
            worker.addContract(contract);
        }
        System.out.println("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt((monthAndYear.substring(3)));

        System.out.println("Name: "+worker.getName());
        System.out.println("Department: "+worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + worker.income(month, year));


    }
}
