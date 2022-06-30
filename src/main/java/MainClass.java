import DTO.Item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MainClass
{
//    public static void c_info()
//    {
//        System.out.println("db를 연결해보자");
//        Scanner sc = new Scanner(System.in);
//        //db 생성
//        DBClass dc = new DBClass();
//
//        //db에 character 정보 삽입 / 출력
//        System.out.println("캐릭터 등록");
//        System.out.print("이름 입력 : ");
//        String c_name = sc.nextLine();
//        System.out.print("hp 설정 : ");
//        String c_hp = sc.nextLine();
//        System.out.print("직업 설정 : ");
//        String job = sc.nextLine();
//
//        dc.insertCharacter(c_name, c_hp, job);
//        dc.selectCharacter();
//    }
//
//    public void i_info()
//    {
//        System.out.println("db를 연결해보자");
//        Scanner sc = new Scanner(System.in);
//        //db 생성
//        DBClass dc = new DBClass();
//
//        //db에 아이템 정보 삽입 / 출력
//        System.out.print("아이템 등록");
//        System.out.print("이름 입력 : ");
//        String i_name = sc.nextLine();
//        System.out.print("속성 입력 : ");
//        String att = sc.nextLine();
//        System.out.print("공격력 입력 : ");
//        String dam = sc.nextLine();
//        System.out.print("효과 입력 : ");
//        String hyo = sc.nextLine();
//
//        dc.insertItem(i_name, att, dam, hyo);
//        dc.selectItem();
//    }
//    public void m_info()
//    {
//        System.out.println("db를 연결해보자");
//        Scanner sc = new Scanner(System.in);
//        //db 생성
//        DBClass dc = new DBClass();
//
//        //db에 monster 정보 삽입 / 출력
//        System.out.println("몬스터 등록");
//        System.out.print("이름 입력 : ");
//        String m_name = sc.nextLine();
//        System.out.print("hp 설정 : ");
//        String m_hp = sc.nextLine();
//
//        dc.insertMonster(m_name, m_hp);
//        dc.selectMonster();
//    }

    public static void main(String[] args)
    {
//        MainClass mc = new MainClass();
//        mc.c_info();
//        mc.i_info();
//        mc.m_info();

        System.out.println("db를 연결해보자");
        Scanner sc = new Scanner(System.in);
        //db 생성
        DBClass dc = new DBClass();

        //db에 character 정보 삽입 / 출력
//        System.out.println("캐릭터 등록");
//        System.out.print("이름 입력 : ");
//        String c_name = sc.nextLine();
//        System.out.print("hp 설정 : ");
//        String c_hp = sc.nextLine();
//        System.out.print("직업 설정 : ");
//        String job = sc.nextLine();
//
//        dc.insertCharacter(c_name, c_hp, job);
//        dc.selectCharacter();

        //db에 아이템 정보 삽입 / 출력
        System.out.println("아이템 등록");
        System.out.print("이름 입력 : ");
        String i_name = sc.nextLine();
        System.out.print("속성 입력 : ");
        String att = sc.nextLine();
        System.out.print("공격력 입력 : ");
        int dam = sc.nextInt();
        sc.nextLine();
        System.out.print("효과 입력 : ");
        String hyo = sc.nextLine();

        //Item 클래스에 입력받은 내용 담기
        Item item = new Item();;
        item.setName(i_name);
        item.setAtt(att);
        item.setDam(dam);
        item.setHyo(hyo);

        dc.insertItem(item);
        dc.selectItem();

        //db에 monster 정보 삽입 / 출력
//        System.out.println("몬스터 등록");
//        System.out.print("이름 입력 : ");
//        String m_name = sc.nextLine();
//        System.out.print("hp 설정 : ");
//        String m_hp = sc.nextLine();
//
//        dc.insertMonster(m_name, m_hp);
//        dc.selectMonster();
    }
}
